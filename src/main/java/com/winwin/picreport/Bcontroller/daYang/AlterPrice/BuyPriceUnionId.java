package com.winwin.picreport.Bcontroller.daYang.AlterPrice;

import com.winwin.picreport.AllConstant.Cnst;

/**
 * Created by Administrator on 2018/6/21.
 *
 * 插入销售价格的时候需要把对应行采购价格的主键发过来
 */
public class BuyPriceUnionId {

//    olefield(dingJiaGuanLian)+curId+bilType+priceId+prdNo形成绝对主键来修改该条记录

    private String dingJiaGuanLian;
    private String curId;
    private String bilType;
    //这个是死的,不用对方传过来
    private String priceId= Cnst.buyPriceId;
    //把对方的该条记录的id穿过来,方便得到货号形成唯一键
    private String uuid;


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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return "BuyPriceUnionId{" +
                "dingJiaGuanLian='" + dingJiaGuanLian + '\'' +
                ", curId='" + curId + '\'' +
                ", bilType='" + bilType + '\'' +
                ", priceId='" + priceId + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
