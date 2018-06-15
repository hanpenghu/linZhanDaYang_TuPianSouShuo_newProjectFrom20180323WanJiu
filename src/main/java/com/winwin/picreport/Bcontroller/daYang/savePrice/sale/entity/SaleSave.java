package com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 *


 {"uuid":"","user":"hanhan",

 "buy":[{"dingJiaGuanLian":"","curId":"RMB","bilType":"","priceId":"2"}],

 "sale":[{"dingJiaGuanLian":"","curId":"","bilType":"","priceId":"1",

 "up":"12.00","rem":"备注","qty":"1000","unit":"主:kg"}]

 }

 *
 *
 */
public class SaleSave {
    //传入当前操作用户的登录名 userEmail
    private String user;
    private String uuid;
    private List<BuyEntity> buy=new LinkedList<BuyEntity>();
    private List<SaleEntity> sale=new LinkedList<SaleEntity>();


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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
