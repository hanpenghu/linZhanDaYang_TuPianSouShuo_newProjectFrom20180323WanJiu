package com.winwin.picreport.Bcontroller.daYang.AlterPrice;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.dto.AlterPrice;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.stra;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class DingJiaXiuGaiSaleService {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;
    @Transactional
    public void dingJiaXiuGai(AlterPriceObj alterPriceObj,List<String> msgs){
        List<AlterPrice> alterPrices = alterPriceObj.getAlterPrices();
        List<BuyPriceUnionId> 需要修改的采购UnionIds = alterPriceObj.getBuyPriceUnionIds();
        this.f需要修改的采购UnionIds是否非法(需要修改的采购UnionIds,msgs);
        p.p("-------------------------alterPrices刚进来------------------------------");
        p.p(alterPrices);
        p.p("-------------------------------------------------------");
        try {

            String sale一批数据统一的定价关联=this.获得一批数据统一的定价关联(alterPrices);
            AlterPrice alterPrice放入修改记录表= this.f创建修改记录对象(alterPrices);
            for(AlterPrice alterPrice:alterPrices){
               this.f修改记录表设置(alterPrice放入修改记录表,alterPrice,msgs);
                //其中dingJiaGuanLian(oleField)+bilType+curIdBefore可以形成联合主键进行某条记录的修改
                //设置定价主键,将来更新updef表 用,插入的时候用    “sale当没有任何记录需要插入的时候的定价关联'
                alterPrice.setDingJiaZhuJian(this.f设置定价主键(alterPrice));
                //修改价格主表up_def
                this.f存在就修改不存在插入upDef(sale一批数据统一的定价关联,alterPrice,需要修改的采购UnionIds,msgs);
            }
            //记录修改
            Integer j=cnst.alterPriceRecMapper.insertSelective(alterPrice放入修改记录表);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(JSON.toJSONString(alterPrices));
            logger.error(e.getMessage(),e);
            p.throwEAddToList("定价修改失败",msgs);
        }
    }



    @Transactional
    private String 获得一批数据统一的定价关联(List<AlterPrice> alterPrices) {
        String s=Cnst.SamplesSys+p.sj();
        for(AlterPrice a:alterPrices){
            UpDefExample uu=new UpDefExample();
            uu.createCriteria().andOlefieldEqualTo(a.getDingJiaGuanLian()==null?"":a.getDingJiaGuanLian());
            List<UpDef> upDefs = cnst.upDefMapper.selectByExample(uu);
            if(p.notEmpty(upDefs)&&upDefs.size()>0){
                s=a.getDingJiaGuanLian();
                return s;
            }
        }

        return s;
    }

    @Transactional
    private void f修改记录表设置(AlterPrice alterPrice放入修改记录表, AlterPrice alterPrice, List<String> msgs) {
        //设置修改时间,将来插入修改记录表
        alterPrice放入修改记录表.setAlterTime(p.dtoStr(new Date(),p.d16));
        String saleOrBuy= alterPrice.getSaleOrBuy();
        this.isIgll(saleOrBuy,msgs);
        this.设置修改对象币别(alterPrice放入修改记录表,alterPrice);
        //得到8种组合单价,只是为了修改记录用
        //销售和采购的无运费都是1,不用分2种情况
        this.f设置无运费本币修改之前之后价格(alterPrice放入修改记录表,alterPrice);
        //以下是有运费,以上是无运费
        this.f设置有运费前后价格(alterPrice放入修改记录表,alterPrice,saleOrBuy);
    }


    @Transactional
    private void f需要修改的采购UnionIds是否非法(List<BuyPriceUnionId> 需要修改的采购UnionIds,List<String> msgs) {
        if(p.empty(需要修改的采购UnionIds))p.throwEAddToList("前端穿过来的采购定价的主键集合为空",msgs);
    }

    @Transactional
    private void f存在就修改不存在插入upDef(String sale一批数据统一的定价关联,AlterPrice alterPrice,List<BuyPriceUnionId> 需要修改的采购UnionIds,List<String> msgs) {
        if(p.notEmpty(alterPrice.getUpAfter())){
            if(alterPrice.getUpAfter().contains(",")){
                alterPrice.setUpAfter(alterPrice.getUpAfter().replace(",",""));
            }
        }
        if(p.notEmpty(alterPrice.getQtyAfter())){
            if(alterPrice.getQtyAfter().contains(",")){
                alterPrice.setQtyAfter(alterPrice.getQtyAfter().replace(",",""));
            }
        }
        int k=cnst.a001TongYongMapper.isExsit(alterPrice.getDingJiaZhuJian());
        if(k>0){
            //更新定价关联,因为一组数据,有的是存在的,有的是不存在的,不存在的插入新的定价关联,老的数据也要把定价关联更新过来
            alterPrice.setDingJiaGuanLian(sale一批数据统一的定价关联);
            //修改的话肯定是原来就是关联的,不用管prm_no
            Integer i=cnst.a001TongYongMapper.updateUpdef(alterPrice);
        }else{
            //不存在insert一条
            this.f不存在插入一条(sale一批数据统一的定价关联,alterPrice,需要修改的采购UnionIds,msgs);
        }

    }

    @Transactional
    private void f不存在插入一条(String sale当没有任何记录需要插入的时候的定价关联,AlterPrice alterPrice,List<BuyPriceUnionId> 需要修改的采购UnionIds,List<String> msgs) {
        //prm_no   varchar(20)      180614223502247-561这种17到19位以内
        String prmNo销售采购关联主键=this.f获得采购销售关联主键prmNo并给采购的设置(需要修改的采购UnionIds,msgs);
        p.p("------------------不存在插入1-------------------------------------");
        if(p.isBd(alterPrice.getUpAfter())){
            p.p("------------------不存在插入2-------------------------------------");
            UpDef upDef=new UpDef();
//            if(p.dy(alterPrice.getSaleOrBuy(),"sale")){
//                upDef.setPriceId(Cnst.salPriceId);
//            }
//            if(p.dy(alterPrice.getSaleOrBuy(),"buy")){
//                upDef.setPriceId(Cnst.buyPriceId);
//            }
            upDef.setPriceId(Cnst.salPriceId);
            upDef.setBilType(alterPrice.getBilType());
            upDef.setCurId(alterPrice.getCurIdAfter());
            upDef.setOlefield(sale当没有任何记录需要插入的时候的定价关联);
            upDef.setPrdNo(alterPrice.getPrdNo());
            upDef.setChkMan(alterPrice.getUserName());
            upDef.setUsr(alterPrice.getUserName());
            upDef.setHjNo(alterPrice.getUnitAfter());
            upDef.setRem(alterPrice.getRemFrontAfter());
            upDef.setPrmNo(prmNo销售采购关联主键);
            upDef.setUp(new BigDecimal(alterPrice.getUpAfter()));
            upDef.setsDd(new Date());
            if(p.isBd(alterPrice.getQtyAfter())){
                upDef.setQty(new BigDecimal(alterPrice.getQtyAfter()));
            }
            p.p("-------------------upDef------------------------------------");
            p.p(upDef);
            p.p("-------------------------------------------------------");
            if(p.notEmpty(upDef.getOlefield())){
                p.p("------------------不存在插入3-------------------------------------");
                if(p.notEmpty(upDef.getCurId())){
                    p.p("------------------不存在插入4-------------------------------------");
                    if(null!=upDef.getBilType()){
                        p.p("------------------不存在插入5-------------------------------------");
                        if(p.notEmpty(upDef.getPriceId())){
                            p.p("------------------不存在插入6-------------------------------------");
                            this.f设置upDef必须字段为空(upDef);
                            cnst.upDefMapper.insertSelective(upDef);
                        }else{p.throwEAddToList("设置销售类型失败",msgs);}
                    }else{p.throwEAddToList("设置销售运费类型失败",msgs);}
                }else{p.throwEAddToList("设置销售币别失败",msgs);}
            }else{p.throwEAddToList("设置销售定价关联失败",msgs);}

        }

    }

    @Transactional
    private String f获得采购销售关联主键prmNo并给采购的设置(List<BuyPriceUnionId> 需要修改的采购UnionIds,List<String> msgs) {
        String 采购销售关联主键prmNo="";//p.timeAndRandom0_999NoSymbolRemoveHead_()
        BuyPriceUnionId b = 需要修改的采购UnionIds.get(0);
        String prdNo=cnst.a001TongYongMapper.getPrdNoFromPrdtSampUseId(b.getUuid());
        if(p.empty(prdNo)){p.throwEAddToList("该条记录没有货号prdNo",msgs);}

        UpDefExample upDefExample=new UpDefExample();
        upDefExample.createCriteria().andPrdNoEqualTo(prdNo)
                .andCurIdEqualTo(b.getCurId()).andBilTypeEqualTo(b.getBilType())
                .andPriceIdEqualTo(b.getPriceId()).andOlefieldEqualTo(b.getDingJiaGuanLian());
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
        if(p.empty(upDefs)){p.throwEAddToList("前端传过来的采购联合主键不存在",msgs);}

        采购销售关联主键prmNo= upDefs.get(0).getPrmNo();

        if(p.empty(采购销售关联主键prmNo)){
            采购销售关联主键prmNo=p.timeAndRandom0_999NoSymbolRemoveHead_();
            this.f更新所有采购关联主键(需要修改的采购UnionIds,采购销售关联主键prmNo,prdNo);
        }
        if(p.notEmpty(采购销售关联主键prmNo)){
            if(采购销售关联主键prmNo.contains("-")){
                int length = 采购销售关联主键prmNo.substring(0, 采购销售关联主键prmNo.indexOf("-")).length();
                if(length<15){
                    //此时不是我们关联的
                    采购销售关联主键prmNo=p.timeAndRandom0_999NoSymbolRemoveHead_();
                    this.f更新所有采购关联主键(需要修改的采购UnionIds,采购销售关联主键prmNo,prdNo);
                }
            }else{
                采购销售关联主键prmNo=p.timeAndRandom0_999NoSymbolRemoveHead_();
                this.f更新所有采购关联主键(需要修改的采购UnionIds,采购销售关联主键prmNo,prdNo);
            }
        }

        return 采购销售关联主键prmNo;
    }





    @Transactional
    private void f更新所有采购关联主键(List<BuyPriceUnionId> 需要修改的采购UnionIds, String 采购销售关联主键prmNo,String prdNo) {
        for(BuyPriceUnionId b:需要修改的采购UnionIds){
            UpDefExample upDefExample=new UpDefExample();
            upDefExample.createCriteria().andPrdNoEqualTo(prdNo)
                    .andCurIdEqualTo(b.getCurId()).andBilTypeEqualTo(b.getBilType())
                    .andPriceIdEqualTo(b.getPriceId()).andOlefieldEqualTo(b.getDingJiaGuanLian());
            UpDef upDef =new UpDef();
            upDef.setPrmNo(采购销售关联主键prmNo);
            cnst.upDefMapper.updateByExampleSelective(upDef,upDefExample);
        }

    }


    @Transactional
    private void f设置upDef必须字段为空(UpDef upDef) {
        upDef.setCusNo("");
        upDef.setPrdMark("");
        upDef.setBzKnd("");
        upDef.setKnd("");
        upDef.setSupPrdNo("");
        upDef.setCusAre("");
    }


    @Transactional
    private String f设置定价主键(AlterPrice alterPrice) {
        String dingJiaZhuJian= stra.b()
                .a(p.strNullToSpace(alterPrice.getDingJiaGuanLian()))
                .a(p.strNullToSpace(alterPrice.getBilType()))
                .a(p.strNullToSpace(alterPrice.getCurIdBefore()))
                .a(p.strNullToSpace(alterPrice.getPrdNo()))
                .g();
        return dingJiaZhuJian;
    }

    @Transactional
    private void 设置修改对象币别(AlterPrice alterPriceMeraged, AlterPrice alterPrice) {
        if(p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)) {
            alterPriceMeraged.setCurIdBefore(alterPrice.getCurIdBefore());
            alterPriceMeraged.setCurIdAfter(alterPrice.getCurIdAfter());
        }
    }

    @Transactional
    private void f设置有运费前后价格(AlterPrice alterPriceMeraged, AlterPrice alterPrice,String saleOrBuy) {
        this.设置有运费采购前后价格(alterPriceMeraged,alterPrice,saleOrBuy);
        this.设置有运费销售前后价格(alterPriceMeraged,alterPrice,saleOrBuy);

    }

    @Transactional
    private void 设置有运费销售前后价格(AlterPrice alterPriceMeraged, AlterPrice alterPrice, String saleOrBuy) {
        if(p.dy("sale",saleOrBuy)){
            //得到有运费本币修改之前价格
            if(p.dy(alterPrice.getBilType(),Cnst.saleBilTypeHaveTrans)&&p.dy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpMyBefore(alterPrice.getUpBefore());
            }
            //得到有运费本币修改之后价格
            if(p.dy(alterPrice.getBilType(),Cnst.saleBilTypeHaveTrans)&&p.dy(alterPrice.getCurIdAfter(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpMyAfter(alterPrice.getUpAfter());
            }

            //得到有运费外币币修改之前价格
            if(p.dy(alterPrice.getBilType(),Cnst.saleBilTypeHaveTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpOtherBefore(alterPrice.getUpBefore());
            }

            //得到有运费外币币修改之后价格
            if(p.dy(alterPrice.getBilType(),Cnst.saleBilTypeHaveTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpOtherAfter(alterPrice.getUpAfter());
            }
        }
    }

    @Transactional
    private void 设置有运费采购前后价格(AlterPrice alterPriceMeraged, AlterPrice alterPrice, String saleOrBuy) {
        if(p.dy("buy",saleOrBuy)){
            //得到有运费本币修改之前价格
            if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeHaveTrans)&&p.dy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpMyBefore(alterPrice.getUpBefore());
            }
            //得到有运费本币修改之后价格
            if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeHaveTrans)&&p.dy(alterPrice.getCurIdAfter(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpMyAfter(alterPrice.getUpAfter());
            }

            //得到有运费外币币修改之前价格
            if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeHaveTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpOtherBefore(alterPrice.getUpBefore());
            }

            //得到有运费外币币修改之后价格
            if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeHaveTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
                alterPriceMeraged.setHaveTransUpOtherAfter(alterPrice.getUpAfter());
            }
        }
    }

    @Transactional
    private void f设置无运费本币修改之前之后价格(AlterPrice alterPriceMeraged, AlterPrice alterPrice) {
        //得到无运费本币修改之前价格//销售和采购的无运费都是1(Cnst.buyBilTypeNoTrans),不用分2种情况
        if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeNoTrans)&&p.dy(alterPrice.getCurIdBefore(),Cnst.benBi)){
            alterPriceMeraged.setNoTransUpMyBefore(alterPrice.getUpBefore());
        }
        //得到无运费本币修改之后价格
        if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeNoTrans)&&p.dy(alterPrice.getCurIdAfter(),Cnst.benBi)){
            alterPriceMeraged.setNoTransUpMyAfter(alterPrice.getUpAfter());
        }

        //得到无运费外币币修改之前价格
        if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeNoTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
            alterPriceMeraged.setNoTransUpOtherBefore(alterPrice.getUpBefore());
        }

        //得到无运费外币币修改之后价格
        if(p.dy(alterPrice.getBilType(),Cnst.buyBilTypeNoTrans)&&p.bdy(alterPrice.getCurIdBefore(),Cnst.benBi)){
            alterPriceMeraged.setNoTransUpOtherAfter(alterPrice.getUpAfter());
        }
    }

    @Transactional
    private void isIgll(String saleOrBuy,List<String>msgs) {
        if(p.bdy(saleOrBuy,"sale")&&p.bdy(saleOrBuy,"buy")){
            p.throwEAddToList("定价修改失败,前端没有传过来saleOrBuy字段以确定是销售还是采购的修改",msgs);
        }
    }


    @Transactional
    private AlterPrice f创建修改记录对象(List<AlterPrice> alterPrices) {
        /**
         *插入修改记录表之前要先把价格跟有没有运费,是本币还是外币组合成一条数据
         * 注意记录表只是记录我们打样系统中uuid对应那个记录的价格被修改的次数,不是对应某个prdNo的次数
         * */
        //准备一个存储合并后数据的对象
        AlterPrice alterPriceMeraged=new AlterPrice();
        BeanUtils.copyProperties(alterPrices.get(0),alterPriceMeraged);
        return alterPriceMeraged;
    }
}





//此时是外币的时候,得到修改前后的币别
//                    curIdBefore=alterPrice.getCurIdBefore();
//                    curIdAfter=alterPrice.getCurIdAfter();


//            //不含运费单价本币 修改前
//            String noTransUpMyBefore="";//--------
//不含运费单价本币修改后
//            String noTransUpMyAfter="";
//            //不含含运费单价外币修改 前
//            String noTransUpOtherBefore="";
//            //不含运费单价外币修改后
//            String noTransUpOtherAfter="";
//            //含运费单价本币修改前
//            String haveTransUpMyBefore="";
//            //含运费单价本币修改后
//            String haveTransUpMyAfter="";
//            //含运费单价外币修改前
//            String haveTransUpOtherBefore="";
//                //含运费单价外币修改后
//            String haveTransUpOtherAfter="";
//            //币别其实前端指的是外币的币别
//            String curIdBefore="";
//            String curIdAfter="";






//下面开始合并,首先是得到  noTransUpMyBefore
//无运费筛选标准  根据 bilType='01' curIdBefore="RMB" 找到  upBefore
//            alterPriceMeraged.setNoTransUpMyBefore(noTransUpMyBefore);
//            alterPriceMeraged.setNoTransUpMyAfter(noTransUpMyAfter);
//            alterPriceMeraged.setNoTransUpOtherBefore(noTransUpOtherBefore);
//            alterPriceMeraged.setNoTransUpOtherAfter(noTransUpOtherAfter);
//            alterPriceMeraged.setHaveTransUpMyBefore(haveTransUpMyBefore);
//            alterPriceMeraged.setHaveTransUpMyAfter(haveTransUpMyAfter);
//            alterPriceMeraged.setHaveTransUpOtherBefore(haveTransUpOtherBefore);
//            alterPriceMeraged.setHaveTransUpOtherAfter(haveTransUpOtherAfter);
//            //设置币别(这个存进数据库的币别其实指的是外币的币别,但是前端每次穿过来的时候的curid指的是当时的币别)
//            alterPriceMeraged.setCurIdBefore(curIdBefore);
//            alterPriceMeraged.setCurIdAfter(curIdAfter);