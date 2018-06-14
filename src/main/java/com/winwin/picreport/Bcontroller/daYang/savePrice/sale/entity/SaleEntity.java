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
public class SaleEntity {
  //这里不需要前端传过来dingJiaGuanLian,因为这个时候还没有定价,所以没有产生dingJiaGuanLian字段olefield
    private String curId;
    private String bilType;//1是无运费,2是有运费
    private String priceId="1";//销售是1
    private String up;
    private String rem;
    private String qty;
    private String unit;


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

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
