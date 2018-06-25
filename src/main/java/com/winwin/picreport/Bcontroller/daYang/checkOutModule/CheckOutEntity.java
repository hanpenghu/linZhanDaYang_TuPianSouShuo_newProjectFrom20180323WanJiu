package com.winwin.picreport.Bcontroller.daYang.checkOutModule;

/**
 * Created by Administrator on 2018/6/25.
 */
public class CheckOutEntity {
    //所要审核的记录id
    private String uuid;
    //审核意见
    private String checkOutOpinion;
    //是否审核通过//  0是不通过,1是通过
    private String isCanPass;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCheckOutOpinion() {
        return checkOutOpinion;
    }

    public void setCheckOutOpinion(String checkOutOpinion) {
        this.checkOutOpinion = checkOutOpinion;
    }

    public String getIsCanPass() {
        return isCanPass;
    }

    public void setIsCanPass(String isCanPass) {
        this.isCanPass = isCanPass;
    }
}
