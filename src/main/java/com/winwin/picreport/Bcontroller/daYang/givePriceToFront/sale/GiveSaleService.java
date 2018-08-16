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

import java.util.Collections;
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
       //排列组合后没有80个
        List<UpDefStr> upDefStrs = this.f通过货号拿到前80个采购定价对应的采购和销售(prdNo, ms);
        this.sortUpDefStrs(upDefStrs);
//        List<String>dingJiaGuanLians=this.getAllReadyOlefieldOfSale(upDefStrs);
//        //搞到一些原来没有采购定价的销售定价老数据放进去
//        List<UpDefStr> upDefStrsNoBuy =this.getOldDataOfSalePrice(prdNo,dingJiaGuanLians,ms);
//        this.sortUpDefStrs(upDefStrsNoBuy);
//        upDefStrs.addAll(upDefStrsNoBuy);

       return upDefStrs;

    }

    private List<UpDefStr> getOldDataOfSalePrice(String prdNo, List<String> dingJiaGuanLiansNotIn, List<String> ms) {
        //根据货号找到去重复的定价关联80个
        List<String> dingJiaGuanLians = cnst.a001TongYongMapper.selectTop80OlefiledAndNoIn(prdNo, "%" + Cnst.SamplesSys + "%", Cnst.salPriceId,dingJiaGuanLiansNotIn);
        List<UpDefStr>upDefStrList总=new LinkedList<>();
        for(String s:dingJiaGuanLians){
            UpDefStr upDefStr总=new UpDefStr();
            UpdefSaleStr updefSaleStr分=this.f拿到该定价关联的销售对象(s,ms);
            upDefStr总.setUpdefSaleStr(updefSaleStr分);
            upDefStrList总.add(upDefStr总);
        }
        return upDefStrList总;
    }

    private UpdefSaleStr f拿到该定价关联的销售对象(String s定价关联, List<String> ms) {
        UpDefExample upDefExample=new UpDefExample();
        upDefExample.createCriteria().andOlefieldEqualTo(s定价关联);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
        UpdefSaleStr updefSaleStr=new UpdefSaleStr();
        for(UpDef u:upDefs){
            this.f封装updefSaleStr(ms,u,updefSaleStr);
        }
        return updefSaleStr;



    }

    private List<String> getAllReadyOlefieldOfSale(List<UpDefStr> upDefStrs) {
        List<String>list=new LinkedList<String>();
        if(p.notEmpty(upDefStrs)){
            for(UpDefStr u:upDefStrs){
                if(p.notEmpty(u)){
                    UpdefSaleStr updefSaleStr = u.getUpdefSaleStr();
                    if(p.notEmpty(updefSaleStr)){
                        list.add(updefSaleStr.getDingJiaGuanLian());
                    }
                }
            }
        }
        return list;
    }


    private List<UpDefStr> f通过货号拿到前80个采购定价对应的采购和销售(String prdNo,List<String> ms) {
        //先找到该货号对应的定价关联的前80个
        List<String>n采购定价关联s去重复=cnst.a001TongYongMapper.selectTop80Olefiled(prdNo,"%"+Cnst.SamplesSys+"%",Cnst.buyPriceId);
        List<UpDefStr>upDefStrs总=new LinkedList<>();
        if(p.empty(n采购定价关联s去重复)){
            //此时没有采购价格,只给销售价格
            this.onlySale(upDefStrs总,prdNo,ms);
        }else{
            for(String s:n采购定价关联s去重复){
                UpDefStr upDefStr总=new UpDefStr();
                UpdefBuyStr updefBuyStr分=this.f拿到该定价关联的采购对象(s,ms);
                upDefStr总.setUpdefBuyStr(updefBuyStr分);
                if(p.notEmpty(updefBuyStr分)){
                    //此时才能找到对应的销售定价
                    if(p.notEmpty(updefBuyStr分.getPrmNo())){
                        UpdefSaleStr updefSaleStr分=this.f拿到该prmNo关联的销售定价对象(updefBuyStr分,prdNo,ms);

                        upDefStr总.setUpdefSaleStr(updefSaleStr分);
                    }
                }
                upDefStrs总.add(upDefStr总);
            }
            //如果销售的数量大于采购对应的数量,老数据有这种情况
            if(this.salPriceMoreThanBuy(prdNo,upDefStrs总)){
                //找到upDefStrs总中所有的prmNo
                List<String>prmNosInUpDefStrsTotal=this.allPrmNoInUpDefStrsTotal(upDefStrs总);
                // prmNoInDb.size肯定>prmNosInUpDefStrsTotal.size
                List<String>prmNoInDb=this.allSalePrmNoInDb(prdNo);
                //找出prmNoInDb中不在prmNosInUpDefStrsTotal中的prmNo
                List<String>morePrmNos=this.morePrmNo(prmNosInUpDefStrsTotal,prmNoInDb);
                if(p.notEmpty(morePrmNos)){
                    this.addMore(morePrmNos,upDefStrs总,prdNo,ms);
                }
            }
        }
        return upDefStrs总;
    }

    private void addMore(List<String> morePrmNos, List<UpDefStr> upDefStrs总,String prdNo,List<String> ms) {
        for(String s:morePrmNos){
            UpDefExample upDefExample=new UpDefExample();
            upDefExample.createCriteria().andPrmNoEqualTo(s).andPriceIdEqualTo(Cnst.salPriceId).andPrdNoEqualTo(prdNo);
            //长度：1到4个
            List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
            UpdefSaleStr updefSaleStr=new UpdefSaleStr();
            for(UpDef u:upDefs){
                this.f封装updefSaleStr(ms,u,updefSaleStr);
            }
            //这个updefSaleStr对应的采购是空的,所以要造一个对应的采购
            UpdefBuyStr updefBuyStr=new UpdefBuyStr();
            updefBuyStr.setPrmNo(s);
            updefBuyStr.setQty(updefSaleStr.getQty());
            p.strNullToSpace(updefBuyStr);
            p.strNullToSpace(updefSaleStr);
            UpDefStr updefStr = new UpDefStr();
            updefStr.setUpdefBuyStr(updefBuyStr);
            updefStr.setUpdefSaleStr(updefSaleStr);
            upDefStrs总.add(updefStr);
        }
    }

    private List<String> morePrmNo(List<String> prmNosInUpDefStrsTotal, List<String> prmNoInDb) {
        List<String>list=new LinkedList<String>();
        for(String s:prmNoInDb){
            if(!prmNosInUpDefStrsTotal.contains(s)){
                list.add(s);
            }
        }
       return p.distinctList(list);

    }

    //用货号找当前销售下的prmNo
    private List<String> allSalePrmNoInDb(String prdNo) {
        UpDefExample u=new UpDefExample();
        u.createCriteria().andPriceIdEqualTo(Cnst.salPriceId).andPrdNoEqualTo(prdNo);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(u);
        List<String>prmNos=new LinkedList<String>();
        for(UpDef uu:upDefs){
            prmNos.add(uu.getPrmNo());
        }
        return prmNos;
    }

    ////找到upDefStrs总中所有的prmNo
    private List<String> allPrmNoInUpDefStrsTotal(List<UpDefStr> upDefStrs总) {
        List<String>list =new LinkedList<String>();
        for(UpDefStr u:upDefStrs总){
            list.add(u.getUpdefBuyStr().getPrmNo());
        }
        return list;
    }


    private boolean salPriceMoreThanBuy(String prdNo, List<UpDefStr> upDefStrs总) {
        UpDefExample ue=new UpDefExample();
        ue.createCriteria().andPrdNoEqualTo(prdNo).andPriceIdEqualTo(Cnst.salPriceId);
        long l = cnst.upDefMapper.countByExample(ue);
        if(l>upDefStrs总.size()){
            return true;
        }else{
            return false;
        }
    }

    //只有销售没有采购的老数据用
    private void onlySale(List<UpDefStr> upDefStrs总, String prdNo, List<String> ms) {
        List<String> olefields = cnst.a001TongYongMapper.selectSaleOlefield(prdNo, Cnst.salPriceId);
        if(p.empty(olefields))return;
        for(String s:olefields){
            UpDefStr upDefStr=new UpDefStr();
            UpdefSaleStr updefSaleStr = this.getSalPriceUseOlefield(s, prdNo, ms);
            p.strNullToSpace(updefSaleStr);
            //没有采购弄个空的给前端
            UpdefBuyStr updefBuyStr=new UpdefBuyStr();
            p.strNullToSpace(updefBuyStr);
            updefBuyStr.setPrmNo(updefSaleStr.getPrmNo());
            upDefStr.setUpdefBuyStr(updefBuyStr);
            upDefStr.setUpdefSaleStr(updefSaleStr);
            upDefStrs总.add(upDefStr);
        }
    }


    private UpdefSaleStr getSalPriceUseOlefield(String olefield,String prdNo,List<String> ms) {
        UpDefExample upDefExample=new UpDefExample();
        upDefExample.createCriteria().andOlefieldEqualTo(olefield).andPriceIdEqualTo(Cnst.salPriceId).andPrdNoEqualTo(prdNo);
        //长度：1到4个
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
        UpdefSaleStr updefSaleStr=new UpdefSaleStr();
        for(UpDef u:upDefs){
            this.f封装updefSaleStr(ms,u,updefSaleStr);
        }
        return updefSaleStr;
    }


    private UpdefSaleStr getSalPriceUsePrmNo(String prmNo,String prdNo,List<String> ms) {
        UpDefExample upDefExample=new UpDefExample();
        upDefExample.createCriteria().andPrmNoEqualTo(prmNo).andPriceIdEqualTo(Cnst.salPriceId).andPrdNoEqualTo(prdNo);
        //长度：1到4个
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(upDefExample);
        UpdefSaleStr updefSaleStr=new UpdefSaleStr();
        for(UpDef u:upDefs){
            this.f封装updefSaleStr(ms,u,updefSaleStr);
        }
        return updefSaleStr;
    }




    private UpdefSaleStr f拿到该prmNo关联的销售定价对象(UpdefBuyStr updefBuyStr分,String prdNo,List<String> ms) {
            UpDefExample upDefExample=new UpDefExample();
            upDefExample.createCriteria().andPrmNoEqualTo(updefBuyStr分.getPrmNo()).andPriceIdEqualTo(Cnst.salPriceId).andPrdNoEqualTo(prdNo);
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
        if(p.notEmpty(u.getsDd())){
            updefSaleStr.setsDd(p.dtoStr(u.getsDd(),p.d16));
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
                //设置销售外币币别给前端
                if(p.notEmpty(u.getCurId())&&p.empty(updefSaleStr.getCurIdWaiBi())){
                    updefSaleStr.setCurIdWaiBi(u.getCurId());
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
                //设置销售外币币别给前端
                if(p.notEmpty(u.getCurId())&&p.empty(updefSaleStr.getCurIdWaiBi())){
                    updefSaleStr.setCurIdWaiBi(u.getCurId());
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
        if(p.notEmpty(u.getsDd())){
            updefBuyStr.setsDd(p.dtoStr(u.getsDd(),p.d16));
        }
        this.f封装组合采购运费(ms, u, updefBuyStr);
        updefBuyStr.setDingJiaGuanLian(s定价关联);
        if(p.notEmpty(u.getPrmNo())){
            updefBuyStr.setPrmNo(u.getPrmNo());
        }
    }

    private void f封装组合采购运费(List<String> ms, UpDef u, UpdefBuyStr updefBuyStr) {
        //有运费本币
        if(u.getBilType()!=null&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeHaveTrans.equals(u.getBilType())&&Cnst.benBi.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setHaveTransUpBenBi(String.valueOf(u.getUp()));
                }
            }
        }
        //有运费美元
        if(u.getBilType()!=null&&p.notEmpty(u.getCurId())){
            if(Cnst.buyBilTypeHaveTrans.equals(u.getBilType())&&Cnst.USD.equals(u.getCurId())){
                if(p.notEmpty(u.getUp())){
                    updefBuyStr.setHaveTransUpWaiBi(String.valueOf(u.getUp()));
                }
                //设置采购外币币别给前端
                if(p.notEmpty(u.getCurId())&&p.empty(updefBuyStr.getCurIdWaiBi())){
                    updefBuyStr.setCurIdWaiBi(u.getCurId());
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
                //设置采购外币币别给前端
                if(p.notEmpty(u.getCurId())&&p.empty(updefBuyStr.getCurIdWaiBi())){
                    updefBuyStr.setCurIdWaiBi(u.getCurId());
                }
            }
        }
    }







    private void sortUpDefStrs(List<UpDefStr> upDefStrs) {
        try {
            Collections.sort(upDefStrs,(o1, o2)->{
                long time1 = p.tod(o1.getUpdefBuyStr().getsDd(),p.d16).getTime();
                long time2 = p.tod(o2.getUpdefBuyStr().getsDd(),p.d16).getTime();
                if(time1<time2){//desc
                    return 1;
                }else if(time1==time2){
                    return 0;
                }else{
                    return -1;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }













}
