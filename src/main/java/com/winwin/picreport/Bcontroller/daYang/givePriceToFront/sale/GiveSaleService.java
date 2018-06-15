package com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale.entity.UpDefStr;
import com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale.entity.UpdefBuyStr;
import com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale.entity.UpdefSaleStr;
import com.winwin.picreport.Ddao.reportxmlmapper.UpDefMapper;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */
@Service
public class GiveSaleService {

    @Autowired
    private Cnst  cnst;

    public List<UpDefStr> f(String uuid,List<String> ms) {
       String prdNo= cnst.a001TongYongMapper.getPrdNoFromPrdtSampUseId(uuid);
       if(p.empty(prdNo)){p.throwEAddToList("该条数据没有货号,无法得到对应的定价,请到erp录入货号",ms);}
        List<UpDefStr> upDefStrs = this.f通过货号拿到前80个采购定价(prdNo, ms);

       return upDefStrs;

    }

    private List<UpDefStr> f通过货号拿到前80个采购定价(String prdNo,List<String> ms) {
        //先找到该货号对应的定价关联的前80个
        List<String>n定价关联s去重复=cnst.a001TongYongMapper.selectTop80Olefiled(prdNo,"%"+Cnst.SamplesSys+"%");
        List<UpDefStr>upDefStrs总=new LinkedList<>();
        for(String s:n定价关联s去重复){
            UpDefStr upDefStr总=new UpDefStr();
            UpdefBuyStr updefBuyStr分=this.f拿到该定价关联的采购对象(s,ms);
            upDefStr总.setUpdefBuyStr(updefBuyStr分);
            if(p.notEmpty(updefBuyStr分)){
                //此时才能找到对应的销售定价
                if(p.notEmpty(updefBuyStr分.getPrmNo())){
                    UpdefSaleStr updefSaleStr分=this.f拿到该prmNo关联的销售定价对象(updefBuyStr分.getPrmNo(),ms);
                    upDefStr总.setUpdefSaleStr(updefSaleStr分);
                }
            }
            upDefStrs总.add(upDefStr总);
        }
        return upDefStrs总;
    }

    private UpdefSaleStr f拿到该prmNo关联的销售定价对象(String prmNo, List<String> ms) {
            UpDefExample upDefExample=new UpDefExample();
            upDefExample.createCriteria().andPrmNoEqualTo(prmNo).andPriceIdEqualTo(Cnst.salPriceId);
            //长度：1到4个
            List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
            UpdefSaleStr updefSaleStr=new UpdefSaleStr();
            for(UpDef u:upDefs){
                this.f封装updefSaleStr(ms,u,updefSaleStr);
            }
        return updefSaleStr;
    }

    private void f封装updefSaleStr(List<String> ms, UpDef u, UpdefSaleStr updefSaleStr) {
        if(p.notEmpty(u.getRem())){
            updefSaleStr.setRem(u.getRem());
        }
        if(p.notEmpty(u.getQty())){
            updefSaleStr.setQty(String.valueOf(u.getQty()));
        }
        if(p.notEmpty(u.getHjNo())&&u.getHjNo().contains("主")){
            updefSaleStr.setUnitZhu(u.getHjNo());
        }
        if(p.notEmpty(u.getHjNo())&&u.getHjNo().contains("副")){
            updefSaleStr.setUnitFu(u.getHjNo());
        }
        this.f封装组合销售运费(ms, u, updefSaleStr);
        if(p.notEmpty(u.getOlefield())){
            updefSaleStr.setDingJiaGuanLian(u.getOlefield());
        }
        if(p.notEmpty(u.getPrmNo())){
            updefSaleStr.setPrmNo(u.getPrmNo());
        }

    }

    private void f封装组合销售运费(List<String> ms, UpDef u, UpdefSaleStr updefSaleStr) {
        //有运费本币
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.saleBilTypeHaveTrans.equals(u.getBilType())&&Cnst.benBi.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefSaleStr.setHaveTransUpBenBi(String.valueOf(u.getUp()));
                }
            }
        }
        //有运费美元
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.saleBilTypeHaveTrans.equals(u.getBilType())&&Cnst.USD.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefSaleStr.setHaveTransUpWaiBi(String.valueOf(u.getUp()));
                }
            }

        }
        //无运费本币
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.saleBilTypeNoTrans.equals(u.getBilType())&&Cnst.benBi.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefSaleStr.setNoTransUpBenBi(String.valueOf(u.getUp()));
                }
            }

        }
        //无运费美元
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.saleBilTypeNoTrans.equals(u.getBilType())&&Cnst.USD.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefSaleStr.setNoTransUpWaiBi(String.valueOf(u.getUp()));
                }
            }
        }


    }


    //同一次保存的采购定价,他的定价关联olefield相同
    private UpdefBuyStr f拿到该定价关联的采购对象(String s定价关联,List<String> ms) {
        UpDefExample upDefExample=new UpDefExample();
        upDefExample.createCriteria().andOlefieldEqualTo(s定价关联);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
        UpdefBuyStr updefBuyStr=new UpdefBuyStr();
        for(UpDef u:upDefs){
            this.f封装updefBuyStr(ms,u,updefBuyStr,s定价关联);
        }
        return updefBuyStr;
    }

    private void f封装updefBuyStr(List<String> ms, UpDef u, UpdefBuyStr updefBuyStr,String s定价关联) {
        if(p.notEmpty(u.getRem())){
            updefBuyStr.setRem(u.getRem());
        }
        if(p.notEmpty(u.getQty())){
            updefBuyStr.setQty(String.valueOf(u.getQty()));
        }
        if(p.notEmpty(u.getHjNo())&&u.getHjNo().contains("主")){
            updefBuyStr.setUnitZhu(u.getHjNo());
        }
        if(p.notEmpty(u.getHjNo())&&u.getHjNo().contains("副")){
            updefBuyStr.setUnitFu(u.getHjNo());
        }
        this.f封装组合采购运费(ms, u, updefBuyStr);
        updefBuyStr.setDingJiaGuanLian(s定价关联);
        if(p.notEmpty(u.getPrmNo())){
            updefBuyStr.setPrmNo(u.getPrmNo());
        }
    }

    private void f封装组合采购运费(List<String> ms, UpDef u, UpdefBuyStr updefBuyStr) {
        //有运费本币
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeHaveTrans.equals(u.getBilType())&&Cnst.benBi.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setHaveTransUpBenBi(String.valueOf(u.getUp()));
                }
            }
        }
        //有运费美元
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeHaveTrans.equals(u.getBilType())&&Cnst.USD.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setHaveTransUpWaiBi(String.valueOf(u.getUp()));
                }
            }

        }
        //无运费本币
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeNoTrans.equals(u.getBilType())&&Cnst.benBi.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setNoTransUpBenBi(String.valueOf(u.getUp()));
                }
            }

        }
        //无运费美元
        if(p.notEmpty(u.getBilType())&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeNoTrans.equals(u.getBilType())&&Cnst.USD.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setNoTransUpWaiBi(String.valueOf(u.getUp()));
                }
            }
        }
    }
















}
