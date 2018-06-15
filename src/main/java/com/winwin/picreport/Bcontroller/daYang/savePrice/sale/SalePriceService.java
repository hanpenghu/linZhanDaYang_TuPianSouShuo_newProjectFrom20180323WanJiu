package com.winwin.picreport.Bcontroller.daYang.savePrice.sale;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.BuyEntity;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.SaleEntity;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.SaleSave;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

@Service
public class SalePriceService {
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;
    @Transactional
    public void f(SaleSave saleSave, List<String> ms) {
        //prm_no   varchar(20)      180614223502247-561这种17到19位以内
        String n销售采购关联prmNo= p.timeAndRandom0_999NoSymbolRemoveHead_();
        String prdNo=this.f得到货号(saleSave.getUuid(),ms);
        boolean b是否有主单位 = this.prdt表中对应该单号是否有主单位(prdNo);
        boolean b是否有副单位 = this.prdt表中对应该单号是否有副单位(prdNo);
        this.f更新采购的采购销售关联标记prmNo(ms,prdNo,saleSave.getBuy(),n销售采购关联prmNo);
        this.f插入销售定价携带与采购的关联标记prmNo(ms,prdNo,saleSave.getSale(),saleSave.getUser(),n销售采购关联prmNo,b是否有主单位,b是否有副单位);
    }

    @Transactional
    private void f插入销售定价携带与采购的关联标记prmNo(List<String> ms, String prdNo, List<SaleEntity> sale, String user,String n销售采购关联prmNo,boolean b是否有主单位,boolean b是否有副单位) {
        String dingJiaGuanLian = Cnst.SamplesSys + p.timeAndRandom0_999NoSymbolRemoveHead_();
        Date date1到4条数据使用同一个插入时间=p.getDate();
        for(SaleEntity s:sale){
            this.f单价和数量是否是数字(s,ms);
            UpDef upDef=new UpDef();
            if(s.getQty()==null||"".equals(s.getQty())){
                //可以不填写数量
                upDef.setQty(null);
            }else{
                upDef.setQty(p.b(s.getQty()));
            }
            //采购和销售的页面一行关联
            upDef.setPrmNo(n销售采购关联prmNo);
            //同一次保存的关联(销售或者采购)
            upDef.setOlefield(dingJiaGuanLian);

            upDef.setCurId(s.getCurId());
            upDef.setBilType(s.getBilType());
            upDef.setPriceId(Cnst.salPriceId);
            upDef.setUp(p.b(s.getUp()));
            upDef.setRem(s.getRem());
            upDef.setUnit(s.getUnit());
            if(b是否有主单位){this.f插入主单位(prdNo,s.getUnit());}
            if(b是否有副单位){this.f插入副单位(prdNo,s.getUnit());}

            upDef.setsDd(date1到4条数据使用同一个插入时间);
            upDef.setUsr(user);
            upDef.setChkMan(user);
            this.f设置upDef必须字段为空(upDef);
            int i = cnst.upDefMapper.insertSelective(upDef);
            if(i!=1){
                p.throwEAddToList("保存销售定价失败(更新的时候数据库级别失败)",ms);
            }

        }

    }


    @Transactional
    private boolean prdt表中对应该单号是否有主单位(String prdNo){
        String ut = cnst.manyTabSerch.selectUtFromPrdt(prdNo);
        if(p.notEmpty(ut)){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    private boolean prdt表中对应该单号是否有副单位(String prdNo){
        String ut1 = cnst.manyTabSerch.selectUt1FromPrdt(prdNo);
        if(p.notEmpty(ut1)){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    private  void f插入主单位(String prdNo,String unit){
        if (p.notEmpty(unit)&&unit.contains("主")) {
            //如果是空的,证明prdt表中没有该ut,需要插入该unit
            Integer tt = cnst.manyTabSerch.insertUnitToUtOfPrdt(unit, prdNo);
        }
    }

    @Transactional
    private void f插入副单位(String prdNo,String unit){
        if (p.notEmpty(unit)&&unit.contains("副")) {
            //如果是空的,证明prdt表中没有该ut,需要插入该unit
            Integer tt1 = cnst.manyTabSerch.insertUnitToUt1OfPrdt(unit,prdNo);
        }
    }




    @Transactional
    private void f单价和数量是否是数字(SaleEntity s, List<String> ms) {
        if(!p.isBd(s.getUp())){p.throwEAddToList("前端传过来的单价有的不是数字",ms);}
        if(s.getQty()!=null&&!"".equals(s.getQty())){
            if(!p.isBd(s.getQty())){
                p.throwEAddToList("前端传过来的数量有的不是数字(是空的后台直接变为0了)",ms);
            }
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
    private void f更新采购的采购销售关联标记prmNo(List<String> ms, String prdNo, List<BuyEntity> buy, String n销售采购关联prmNo) {
        //后来老郑说采购的只有本币和有运费的,那么,这里其实就循环一次
        for(BuyEntity b:buy){
            UpDef upDef=new UpDef();
            upDef.setPrmNo(n销售采购关联prmNo);
            UpDefExample upDefExample=new UpDefExample();
            upDefExample.createCriteria()
                    .andPrdNoEqualTo(prdNo)
                    .andOlefieldEqualTo(b.getDingJiaGuanLian())
                    .andCurIdEqualTo(b.getCurId())
                    .andBilTypeEqualTo(b.getBilType())
                    .andPriceIdEqualTo(Cnst.buyPriceId);
            int i = cnst.upDefMapper.updateByExampleSelective(upDef, upDefExample);
            if(i!=1){
                String sss="销售定价保存之前,其所关联的采购定价关联字段prm_no更新失败,《考虑联合前端联合主键传递有问题》";
                p.throwEAddToList(sss,ms);
            }
        }
    }


    @Transactional
    private String f得到货号(String uuid,List<String> ms) {
        String prdNo= cnst.salePriceSaveDao.getPrdNoFromPrdtSamp(uuid);
        if(p.empty(prdNo)){
            p.throwEAddToList("当前商品没有货号,请到erp录入",ms);
        }
        return prdNo;
    }
}
