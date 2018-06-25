package com.winwin.picreport.Bcontroller.daYang.dto;

import com.winwin.picreport.Edto.AlterPriceRec;

public class AlterPrice extends AlterPriceRec{
    //dingJiaGuanLian+bileType+curIdBefore在upDef中可以唯一对应
//    {"dingJiaGuanLian":"","qty":"100","up":"44","unit":"","remFront":"阿里巴巴","bilType":"","curIdBefore":"RMB","curIdAfter":"USD"}
    //改动后 alterTime不用传过来,我自己加上去
//[{"dingJiaGuanLian":"","userName":"","tenantId":"","saleOrBuy":"sale代表是销售的,buy代表采购的","alterTime":"","prdtCode":"","prdtSampUuid":"","qtyBefore":"100","qtyAfter":"100","upBefore":"44","upAfter":"44","unitBefore":"","unitAfter":"","remFrontBefore":"阿里巴巴","remFrontAfter":"阿里巴巴","bilType":"","curIdBefore":"RMB","curIdAfter":"USD"}]

    //定价主键不用对方传过来,是自己组合的用来找updef中的唯一值的
    private String dingJiaZhuJian="";


    public String getDingJiaZhuJian() {

        return dingJiaZhuJian;
    }

    public AlterPrice setDingJiaZhuJian(String dingJiaZhuJian) {
        this.dingJiaZhuJian = dingJiaZhuJian;
        return this;
    }


    @Override
    public String toString() {
        return "AlterPrice{" +
                "prdNo='" + prdNo + '\'' +
                ", dingJiaGuanLian='" + dingJiaGuanLian + '\'' +
                ", userName='" + userName + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", alterTime='" + alterTime + '\'' +
                ", prdtCode='" + prdtCode + '\'' +
                ", prdtSampUuid='" + prdtSampUuid + '\'' +
                ", qtyBefore='" + qtyBefore + '\'' +
                ", qtyAfter='" + qtyAfter + '\'' +
                ", upBefore='" + upBefore + '\'' +
                ", upAfter='" + upAfter + '\'' +
                ", unitBefore='" + unitBefore + '\'' +
                ", unitAfter='" + unitAfter + '\'' +
                ", remFrontBefore='" + remFrontBefore + '\'' +
                ", remFrontAfter='" + remFrontAfter + '\'' +
                ", dingJiaZhuJian='" + dingJiaZhuJian + '\'' +
                ", bilType='" + bilType + '\'' +
                ", curIdBefore='" + curIdBefore + '\'' +
                ", curIdAfter='" + curIdAfter + '\'' +
                ", saleOrBuy='" + saleOrBuy + '\'' +
                ", noTransUpMyBefore='" + noTransUpMyBefore + '\'' +
                ", noTransUpMyAfter='" + noTransUpMyAfter + '\'' +
                ", noTransUpOtherBefore='" + noTransUpOtherBefore + '\'' +
                ", noTransUpOtherAfter='" + noTransUpOtherAfter + '\'' +
                ", haveTransUpMyBefore='" + haveTransUpMyBefore + '\'' +
                ", haveTransUpMyAfter='" + haveTransUpMyAfter + '\'' +
                ", haveTransUpOtherBefore='" + haveTransUpOtherBefore + '\'' +
                ", haveTransUpOtherAfter='" + haveTransUpOtherAfter + '\'' +
                '}';
    }
}
