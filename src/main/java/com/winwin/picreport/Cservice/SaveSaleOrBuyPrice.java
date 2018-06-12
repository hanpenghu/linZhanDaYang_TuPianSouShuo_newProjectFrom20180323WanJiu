package com.winwin.picreport.Cservice;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefMy01;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 注意:如果是我们打样系统流水的货号在进入
 * prdt的时候,会在  rem   字段标注   SamplesSys  标记
 * 在up_def价格表中   hj_no  标注  SamplesSys  标记
 * 这是为了将来好区别好删除,选出来的时候好选出来
 * <p>
 * <p>
 * 还有:
 * 由于打样系统保存的单位可能跟住单位表  prdt表中的对应的prd_no
 * 的单位不同意,所以,现在打样采购或者销售选的单位来自up_def表中的OLEFIELD
 * 字段,以后我们保存的时候也把价格保存在这个字段
 */
@Service
@Transactional
public class SaveSaleOrBuyPrice {
    @Autowired

    private Cnst cnst;

    //由于后期加了一个本币和外币在一个界面,所以这里用循环,就是说这个list里面其实就2个东西
    public void saveSaleOrBuyPrice0(List<UpDefMy01> ups, List<String> msgs) {
        for (UpDefMy01 u : ups) {
            this.saveSaleOrBuyPrice(u, msgs);
        }
    }

    public void saveSaleOrBuyPrice(UpDefMy01 up, List<String> msgs) {
        up.setCusNo(p.sm(p.empty(up.getCusNo()),p.space,up.getCusNo()));
        up.setQty(p.sm(p.empty(up.getQty()),p.b(p.n0),up.getQty()));
        up.setCurId(p.sm(p.empty(up.getCurId()),p.space,up.getCurId()));
        //前端传过来的备注
        up.setRem(up.getRemFront());
        //单位
        this.f前端传过来的主副单位确定(up);
        if (p.empty(up.getCurId())) {p.throwEAddToList("curId 币别代号没有传过来", msgs);}
        String prdNo=this.f货号流水模块_把流水后的货号放入PrdtSamp(up, msgs);
        this.f插入主副单位到prdt表中(up,prdNo);
        this.f主对象设置货号并保存数据(up,prdNo,msgs);
    }

    private void f主对象设置货号并保存数据(UpDefMy01 up, String prdNo, List<String> msgs) {
        if (p.empty(prdNo)) {
            //空的单号,必须告诉前端终止
            p.throwEAddToList("此名称在ERP中无对应品号，不能定价，请完善资料！《后台流水后货号依然为空》", msgs);
        } else {
            up.setPrdNo(prdNo);
            if (up.getHaveTransUpBuy() == null && up.getNoTransUpBuy() == null) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST3~~~~~~~~~~~~~~~~~~~~~~~~");
                //按销售保存
                this.saveAsSaler(up, msgs);
            } else {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST4~~~~~~~~~~~~~~~~~~~~~~~~");
                //现在是采购的,按采购保存
                this.saveAsBuyer(up, msgs);
            }

        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //采购的价格入库
    private void saveAsBuyer(UpDefMy01 up, List<String> msgs) {
        UpDef upDef = new UpDef();
        this.f采购给UpDef赋值(up,upDef);
        /////////含运费和不含运费依次根据程序顺序入库/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //采购含运费入库
        if (p.notEmpty(up.getHaveTransUpBuy())) {
            //1代表不含运费//其他代表是含运费的
            upDef.setBilType(Cnst.buyBilTypeHaveTrans);
            upDef.setUp(up.getHaveTransUpBuy());
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST5~~~~~~~~~~~~~~~~~~~~~~~~");
            int insert = cnst.upDefMapper.insert(upDef);
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST6~~~~~~~~~~~~~~~~~~~~~~~~");
            if (insert == 0) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST7~~~~~~~~~~~~~~~~~~~~~~~~");
                p.throwEAddToList("保存采购价格含运费的失败", msgs);
            }
        }
        //采购不含运费入库
        if (p.notEmpty(up.getNoTransUpBuy())) {
            //1代表不含运费//其他代表是含运费的
            upDef.setBilType(Cnst.buyBilTypeNoTrans);
            upDef.setUp(up.getNoTransUpBuy());
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST9~~~~~~~~~~~~~~~~~~~~~~~~");
            //往价格表up_def插入采购价格。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
            int insert = cnst.upDefMapper.insert(upDef);
            if (insert == 0) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST~~~~~~~10~~~~~~~~~~~~~~~~~");
                p.throwEAddToList("保存采购价格不含运费的失败", msgs);
            } else {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST~~11~~~~~~~~~~~~~~~~~~~~~~");

            }
        }
    }


    /**
     * ***************************************************************************************
     */

    //销售的价格入库
    private void saveAsSaler(UpDefMy01 up, List<String> msgs) {
        UpDef upDef = new UpDef();
        this.f销售给upDef赋值(up,upDef);

        //销售含运费入库
        if (p.notEmpty(up.getHaveTransUpSale())) {
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST~~~~~~~~~~~~~~12~~~~~~~~~~");
            //1代表不含运费//2代表销售含运费
            upDef.setBilType(Cnst.saleBilTypeHaveTrans);
            upDef.setUp(up.getHaveTransUpSale());
            //往价格表up_def插入采购价格
            int insert = cnst.upDefMapper.insert(upDef);//。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST~~~~~~~~13~~~~~~~~~~~~~~~~");
            if (insert == 0) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~TEST14~~~~~~~~~~~~~~~~~~~~~~~~");
                p.throwEAddToList("保存销售价格含运费的失败", msgs);
            } else {

            }
        }
        //销售不含运费入库
        if (p.notEmpty(up.getNoTransUpSale())) {
            p.p("~~~~~~~~~~~~~~~~~~~~~~16~~TEST~~~~~~~~~~~~~~~~~~~~~~~~");
            //1代表不含运费//其他代表是含运费的
            upDef.setBilType(Cnst.saleBilTypeNoTrans);
            upDef.setUp(up.getNoTransUpSale());
            p.p("~~~~~~~~~~~~~~~~~~~~~~17~~TEST~~~~~~~~~~~~~~~~~~~~~~~~");
            //往价格表up_def插入采购价格
            int insert = cnst.upDefMapper.insert(upDef);
            if (insert == 0) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~18~~TEST~~~~~~~~~~~~~~~~~~~~~~~~");
                p.throwEAddToList("保存销售价格不含运费的失败", msgs);
            } else {
                p.p("~~~~~~~~~~~~~~~~~~~~~~19~~TEST~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }

    }














    private void f插入主副单位到prdt表中(UpDefMy01 up,String prdNo) {
        /**
         *插入主单位到prdt中,条件是prdt中prdno对应ut主单位字段是空的并且前端
         * 传过来的unitZhu不是空的
         * */
        //找到该prdNo对应的ut(就是存的主单位)//如果是空的并且前端传过来的主单位不是空的,就给他插入当前前端传过来的单位
        String ut = cnst.manyTabSerch.selectUtFromPrdt(prdNo);
        if (p.empty(ut) && p.notEmpty(up.getUnitZhu())) {
            p.p(p.gp().sad(p.dexhx).sad("prdtTabHaveNoUt(主单位空)startInsert").sad(p.dexhx).gad());
            //如果是空的,证明prdt表中没有该ut,需要插入该unit
            Integer tt = cnst.manyTabSerch.insertUnitToUtOfPrdt(up.getUnitZhu(), prdNo);
            if (p.notEmpty(tt) && tt > 0) {
                p.p(p.gp().sad(p.dexhx).sad("prdt对应的记录更新ut主单位成功").sad(p.dexhx).gad());
            } else {
                p.p(p.gp().sad(p.dexhx).sad("prdt对应的记录更新ut主单位失败,更新条件达到,但是没有更新成功").sad(p.dexhx).gad());
            }
        }
        /**
         *插入副单位到prdt中,条件是prdt中prdno对应ut1主单位字段是空的并且前端
         * 传过来的unitFu不是空的
         * */
        //找到该prdNo对应的ut1(就是存的副单位)//如果是空的并且前端传过来的副单位不是空的,就给他插入当前前端传过来的单位
        String ut1 = cnst.manyTabSerch.selectUt1FromPrdt(prdNo);
        if (p.empty(ut1) && p.notEmpty(up.getUnitFu())) {
            p.p(p.gp().sad(p.dexhx).sad("prdtTabHaveNoUt1(副单位空)startInsert").sad(p.dexhx).gad());
            //如果是空的,证明prdt表中没有该ut,需要插入该unit
            Integer tt1 = cnst.manyTabSerch.insertUnitToUt1OfPrdt(up.getUnitFu(), prdNo);
            if (p.notEmpty(tt1) && tt1 > 0) {
                p.p(p.gp().sad(p.dexhx).sad("prdt对应的记录更新ut1副单位成功").sad(p.dexhx).gad());
            } else {
                p.p(p.gp().sad(p.dexhx).sad("prdt对应的记录更新ut1副单位失败,更新条件达到,但是没有更新成功").sad(p.dexhx).gad());
            }
        }
    }









    private String  f货号流水模块_把流水后的货号放入PrdtSamp(UpDefMy01 up, List<String> msgs) {
        //获得uuid对应的prdt_no
        String prdNo = cnst.manyTabSerch.selectPrdNoFromPrdtSamp(up.getUuid());
        if (p.empty(prdNo)) {
            PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(up.getUuid());
            PrdtSamp0 prdtSamp0 = new PrdtSamp0();
            BeanUtils.copyProperties(prdtSamp, prdtSamp0);
            //2018_5_14   weekday(1)   17:23:11
            prdNo = cnst.a001TongYongMapper.selectTop1PrdtNo(prdtSamp0.getPrdCode());
            if (p.empty(prdNo)) {//注意这边没有分类,无法帮  他流水,需要客户自己去prdt表注册商品的到品号
                p.p("-------------------------------------------------------");
                p.p("此名称在ERP中无对应品号，不能定价，请完善资料！ci mingCheng zai erp zhong wu duiying pinhao ,buneng dingJia  ,qing WanShan ZiLiao");
                p.p("-------------------------------------------------------");
                p.throwEAddToList("此名称在ERP中无对应品号，不能定价，请完善资料！", msgs);
            } else {
                //此时prdt表中有货号,把这个货号放入打样表中
                cnst.a001TongYongMapper.updatePrdNoByUuid(up.getUuid(), prdNo);
            }

        }
        return prdNo;
    }



    private void f采购给UpDef赋值(UpDefMy01 up, UpDef upDef) {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //插入单位, 这个是2018_1_18   weekday(4)   14:17:58郑总说的,把打样的单位
        //暂时放到OLEFIELD字段中,取的时候也取这个,不再取PRDT中的,但是PRDT中的prdno对应的记录如果没有
        //单位(unit为空)上面已经处理了再插入prdt单位的情况
//        upDef.setOlefield(unit);
        upDef.setOlefield(up.getDingJiaGuanLian());
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //我们将来取自己添加的价格的标识
//        upDef.setHjNo(Cnst.SamplesSys);
        upDef.setHjNo(up.getUnit());
        upDef.setsDd(cnst.getDbDate());
        upDef.setQty(up.getQty());
        //这个默认字符串"打样系统"
        upDef.setRem(up.getRem());
        //得到币别
        upDef.setCurId(up.getCurId());
        //得到单位//updef的unit字段里面1指的是主单位,2指的是副单位而已
        upDef.setUnit("1");
        upDef.setPriceId(Cnst.buyPriceId);
        /////////////////////////////////////////////////////////////////////////////////////
        upDef.setCusNo(up.getCusNo());
        upDef.setUsr(up.getUsr());
        upDef.setChkMan(up.getUsr());
        /////////////////////////////////////////////////////////////////////////////////////
        upDef.setPrdMark(p.space);
        upDef.setPrdNo(up.getPrdNo());
        upDef.setBzKnd(p.space);
        upDef.setKnd(p.space);
        upDef.setSupPrdNo(p.space);
        upDef.setCusAre(p.space);
    }


    private void f销售给upDef赋值(UpDefMy01 up, UpDef upDef) {
        //插入单位, 这个是2018_1_18   weekday(4)   14:17:58郑总说的,把打样的单位
        //暂时放到OLEFIELD字段中,取的时候也取这个,不再取PRDT中的,但是PRDT中的prdno对应的记录如果没有
        //单位(unit为空)上面已经处理了再插入prdt单位的情况
        //        upDef.setOlefield(unit);
        //改成界面四条数据进价格表的唯一标识符,SamplesSys+36位唯一标识
        upDef.setOlefield(up.getDingJiaGuanLian());
        //        upDef.setHjNo(Cnst.SamplesSys);
        upDef.setHjNo(up.getUnit());
        upDef.setsDd(cnst.getDbDate());
        upDef.setQty(up.getQty());
        //这个默认字符串"打样系统"//已经改为前端穿过来的
        upDef.setRem(up.getRem());
        //得到币别
        upDef.setCurId(up.getCurId());
        //得到单位//updef的unit字段里面1指的是主单位,2指的是副单位而已
        upDef.setUnit("1");
        //1代表销售,2代表采购
        upDef.setPriceId(Cnst.salPriceId);


/////////////////////////////////////////////////////////////////////////////////////
        upDef.setCusNo("");//销售没有厂商或客户
        upDef.setUsr(up.getUsr());
        upDef.setChkMan(up.getUsr());
        /////////////////////////////////////////////////////////////////////////////////////
        upDef.setPrdMark(p.space);
        upDef.setPrdNo(up.getPrdNo());
        upDef.setBzKnd(p.space);
        upDef.setKnd(p.space);
        upDef.setSupPrdNo(p.space);
        upDef.setCusAre(p.space);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private void f前端传过来的主副单位确定(UpDefMy01 up) {
        String unit="";
        //注意:后来加了主单位和副单位,
        //进入up_def之后都存在了OLEFIELD字段中,取出来的时候也取这个
        //但是老郑还要求了,单位分主副进入prdt中
        //prdt中ut字段是主单位,ut1是副单位
        if (p.notEmpty(up.getUnitZhu())) {
            unit = Cnst.zhu + up.getUnitZhu();
        } else if (p.notEmpty(up.getUnitFu())) {
            unit = Cnst.fu + up.getUnitFu();
        } else {
            unit = "前端空的";
        }
        up.setUnit(unit);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
