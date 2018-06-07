package com.winwin.picreport.Futils;

import com.winwin.picreport.Edto.ShouDingDanFromExcel;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;

import java.util.List;

public class AmtAndAmtnAndTaxChongXinSuan {
    //amtn 未税金额  amt金额  tax税额
    //只要数量和单价不为0就行,其他的就能自动计算
    public static void f(Double amt,Double amtn,Double tax,Double qty,ShouDingDanFromExcel shouDingDanFromExcel,String taxRtos,List<Msg> listmsg){
        double up=0;//单价
        try {up = Double.valueOf(shouDingDanFromExcel.getUp());} catch (NumberFormatException e) {
            e.printStackTrace();
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入,,有单价不为数字"));
            p.throwE("无法导入 有单价不为数字");
        }
        if(up==0){
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有单价为0"));
            p.throwE("无法导入 有单价为0");
        }

        if(amt==0){
                amt=up*qty;//数量不是数字的在前面已经判断过了
        }
        double taxRto=Double.valueOf(taxRtos);//税率,已经是0.16之类的做好的
        double taxRtoAdd1=taxRto+1;
        if(amtn==0){
//            amtn=amt-amt/1.17*0.17;
            amtn=amt-amt/taxRtoAdd1*taxRto;//taxRto是税率
            if(amtn<0){amtn=0D;}
        }
        if(tax==0){
//            tax=amt/1.17*0.17;
            tax=amt/taxRtoAdd1*taxRto;

        }
    }



    /**
     *只要数量和单价不为0就行
     * amt是金额
     * amtn是未税金额
     * tax是 税额
     * taxRto税率
     * */
    public static void g(ShouDingDanFromExcel shouDingDanFromExcel,List<Msg> listmsg){
        String amtstr = shouDingDanFromExcel.getAmt();
        String amtnstr = shouDingDanFromExcel.getAmtn();
        String qtystr=shouDingDanFromExcel.getQty();
        String taxstr=shouDingDanFromExcel.getTax();
        double amt;
        double amtn;
        double qty;
        double tax;
        try {
            amt = Double.parseDouble(amtstr);
        } catch (NumberFormatException e) {
            amt=0;
//            listmsg.addAll(new MessageGenerate().generateMessage("amt 金额不是数字"));
//            throw new RuntimeException("amt 金额不是数字");
        }

        try {
            amtn = Double.parseDouble(amtnstr);
        } catch (NumberFormatException e) {
            amtn=0;
//            listmsg.addAll(new MessageGenerate().generateMessage("amtn 未税金额不是数字"));
//            throw new RuntimeException("amtn 未税金额不是数字");
        }

        try {
            qty = Double.parseDouble(qtystr.trim().replace(",",""));
        } catch (NumberFormatException e) {
            qty=0;
            listmsg.addAll(new MessageGenerate().generateMessage("qty 数量不是数字"));
            p.p("-----出问题的数量 qty 字段--------------------------------------------------");
            p.p(qtystr);
            p.p("-------------------------------------------------------");
            throw new RuntimeException("qty 数量不是数字");
        }



        try {
            tax = Double.parseDouble(taxstr);
        } catch (NumberFormatException e) {
            tax=0;
//            listmsg.addAll(new MessageGenerate().generateMessage("tax 税额不是数字"));
//            throw new RuntimeException("tax 税额不是数字");
        }


        if(amt==0){
            try {
                amt=Double.parseDouble(shouDingDanFromExcel.getUp())*qty;
            } catch (NumberFormatException e) {
                amt=0D;
            }
        }
        if(amtn==0){
            amtn=amt-amt/1.17*0.17;
            if(amtn<0){amtn=0D;}
        }
        if(tax==0){
            tax=amt/1.17*0.17;
        }

        shouDingDanFromExcel.setAmt(String.valueOf(amt));
        shouDingDanFromExcel.setAmtn(String.valueOf(amtn));
        shouDingDanFromExcel.setTax(String.valueOf(tax));

    }


}
