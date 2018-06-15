package com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity;

/**
 * Created by Administrator on 2018/6/14.
 *


 {"uuid":"",

 "buy":[{"dingJiaGuanLian":"","curId":"RMB","bilType":"","priceId":"2"}],

 "sale":[{"curId":"","bilType":"","priceId":"1",

 "up":"12.00","rem":"备注","qty":"1000","unit":"主:kg"}]

 }

 *
 *
 */
public class BuyEntity {
    private String dingJiaGuanLian;
    private String curId="RMB";
    private String bilType="";//采购有运费是""
    private String priceId="2";//采购是2


    public String getDingJiaGuanLian() {
        return dingJiaGuanLian;
    }

    public void setDingJiaGuanLian(String dingJiaGuanLian) {
        this.dingJiaGuanLian = dingJiaGuanLian;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public String getBilType() {
        return bilType;
    }

    public void setBilType(String bilType) {
        this.bilType = bilType;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }


    @Override
    public String toString() {
        return "BuyEntity{" +
                "dingJiaGuanLian='" + dingJiaGuanLian + '\'' +
                ", curId='" + curId + '\'' +
                ", bilType='" + bilType + '\'' +
                ", priceId='" + priceId + '\'' +
                '}';
    }
}
