package com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale.entity;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;

/**
 * Created by Administrator on 2018/6/15.
 */
public class UpdefBuyStr {
    private String curIdWaiBi;
    private String rem;
    private String unitFu;
    private String unitZhu;
    private String dingJiaGuanLian;
    private String qty;
    private String haveTransUpBenBi;
    private String haveTransUpWaiBi;
    private String noTransUpBenBi;
    private String noTransUpWaiBi;
    //关联采购和销售的字段
    private String prmNo;
    //定价时间
    private String sDd;


    public String getCurIdWaiBi() {
        return curIdWaiBi;
    }

    public void setCurIdWaiBi(String curIdWaiBi) {
        this.curIdWaiBi = curIdWaiBi;
    }

    public String getsDd() {
        return sDd;
    }

    public void setsDd(String sDd) {
        this.sDd = sDd;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getUnitFu() {
        return unitFu;
    }

    public void setUnitFu(String unitFu) {
        this.unitFu = unitFu;
    }

    public String getUnitZhu() {
        return unitZhu;
    }

    public void setUnitZhu(String unitZhu) {
        this.unitZhu = unitZhu;
    }

    public String getDingJiaGuanLian() {
        return dingJiaGuanLian;
    }

    public void setDingJiaGuanLian(String dingJiaGuanLian) {
        this.dingJiaGuanLian = dingJiaGuanLian;
    }

    public String getQty() {
        String num = p.getNum(Cnst.pointAfter, Cnst.pointAfter, qty);
        if(p.notEmpty(num)){
            num=p.del0(num);
        }
        return num;
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(p.del0(p.getNum(Cnst.pointAfter, Cnst.pointAfter, "10001.000100000")));
//        p.p("-------------------------------------------------------");
//    }



    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getHaveTransUpBenBi() {
        String num = p.getNum(Cnst.pointAfter, Cnst.pointAfter, haveTransUpBenBi);
        if(p.notEmpty(num)){
            num=p.del0(num);
        }
        return num;
    }

    public void setHaveTransUpBenBi(String haveTransUpBenBi) {
        this.haveTransUpBenBi = haveTransUpBenBi;
    }

    public String getHaveTransUpWaiBi() {

        String num = p.getNum(Cnst.pointAfter, Cnst.pointAfter, haveTransUpWaiBi);
        if(p.notEmpty(num)) {
            num=p.del0(num);
        }
        return num;
    }



    public void setHaveTransUpWaiBi(String haveTransUpWaiBi) {
        this.haveTransUpWaiBi = haveTransUpWaiBi;
    }





    public String getNoTransUpBenBi() {
        String num = p.getNum(Cnst.pointAfter, Cnst.pointAfter, noTransUpBenBi);
        if(p.notEmpty(num)){
            num=p.del0(num);
        }
        return num;
    }






    public void setNoTransUpBenBi(String noTransUpBenBi) {
        this.noTransUpBenBi = noTransUpBenBi;
    }

    public String getNoTransUpWaiBi() {
        String num = p.getNum(Cnst.pointAfter, Cnst.pointAfter, noTransUpWaiBi);
        if(p.notEmpty(num)){
            num=p.del0(num);
        }
        return num;
    }

    public void setNoTransUpWaiBi(String noTransUpWaiBi) {
        this.noTransUpWaiBi = noTransUpWaiBi;
    }

    public String getPrmNo() {
        return prmNo;
    }

    public void setPrmNo(String prmNo) {
        this.prmNo = prmNo;
    }
}
