package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;


import com.winwin.picreport.Bcontroller.PicSearchPic.utils.Cnst;

/**
 * Created by Administrator on 2018/8/24.
 */
public class IfSalePriceSamllEntity {
    //行号: 徐勇传过来界面的哪一行//用1 2 3 4  表示
    private String row;
    //货号

    private String prdNo;
    //单价


    private String up;
    //日期osDd传过来  2018-01-23 13:54:23这种
    //时间,受订单时间

    private String osDd;

    //这个是后端返回给前端用的,前端不用穿过来
    //正常代号 0
    //有单价低于销售定价的行,紫色背景 代号 1
    //在updef货号不存在的代号是 2, 蓝色背景
    //在updef对应销售定价不存在 用  点号 3,颜色待定,后来定位蓝色
    //后期是0的过滤掉, 不返回给徐勇了,只返回有问题的
    private String state="0";
     //2018_8_28   weekday(2)   15:44:47 如果货号是空的靠下面三个来找
    //货号
    private String prdName;
    //对方货号
    private String duiFangPrdNo;
    //客户代码
    private String cusNo;

//    人民币传RMB  美元USD
    private String curId;

    //运费别(销售的)有运费2,无运费1
    private String bilType;

    //加入 数量对比 2018_9_12   weekday(3)   14:25:05
    private String qty;






    public String getBilType() {
        return bilType;
    }

    public void setBilType(String bilType) {
        this.bilType = bilType;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public String getPrdName() {
        return prdName==null?"":prdName.trim();
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getDuiFangPrdNo() {
        return duiFangPrdNo==null?"":duiFangPrdNo.trim();
    }

    public void setDuiFangPrdNo(String duiFangPrdNo) {
        this.duiFangPrdNo = duiFangPrdNo;
    }

    public String getCusNo() {
        return cusNo==null?"":cusNo.trim();
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getRow() {
        return row==null?"":row.trim();
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPrdNo() {
        return prdNo==null?"":prdNo.trim();
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }

    public String getUp() {
        return up==null?"":up.trim();
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getOsDd() {
        return osDd==null?"":osDd.trim();
    }

    public void setOsDd(String osDd) {
        this.osDd = osDd;
    }

    public String getState() {
        return state==null?"":state.trim();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "IfSalePriceSamllEntity{" +
                "row='" + row + '\'' +
                ", prdNo='" + prdNo + '\'' +
                ", up='" + up + '\'' +
                ", osDd='" + osDd + '\'' +
                ", state='" + state + '\'' +
                ", prdName='" + prdName + '\'' +
                ", duiFangPrdNo='" + duiFangPrdNo + '\'' +
                ", cusNo='" + cusNo + '\'' +
                '}';
    }
}
