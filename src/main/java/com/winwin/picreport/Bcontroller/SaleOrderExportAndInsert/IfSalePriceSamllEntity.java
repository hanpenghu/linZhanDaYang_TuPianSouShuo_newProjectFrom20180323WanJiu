package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

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
    //在updef货号在up_def不存在的代号是 2, 蓝色背景
    //在updef对应销售定价不存在 用  点号 3,颜色待定
    private String state="0";


    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getOsDd() {
        return osDd;
    }

    public void setOsDd(String osDd) {
        this.osDd = osDd;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
