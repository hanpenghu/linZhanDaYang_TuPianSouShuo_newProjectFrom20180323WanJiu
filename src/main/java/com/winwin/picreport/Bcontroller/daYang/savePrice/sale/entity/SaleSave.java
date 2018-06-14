package com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 *


 {"uuid":"",

 "buy":[{"dingJiaGuanLian":"","curId":"RMB","bilType":"","priceId":"2"}],

 "sale":[{"dingJiaGuanLian":"","curId":"","bilType":"","priceId":"1",

 "up":"12.00","rem":"备注","qty":"1000","unit":"主:kg"}]

 }

 *
 *
 */
public class SaleSave {
    private String uuid;
    private List<BuyEntity> buy=new LinkedList<BuyEntity>();
    private List<SaleEntity> sale=new LinkedList<SaleEntity>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<BuyEntity> getBuy() {
        return buy;
    }

    public void setBuy(List<BuyEntity> buy) {
        this.buy = buy;
    }

    public List<SaleEntity> getSale() {
        return sale;
    }

    public void setSale(List<SaleEntity> sale) {
        this.sale = sale;
    }
}
