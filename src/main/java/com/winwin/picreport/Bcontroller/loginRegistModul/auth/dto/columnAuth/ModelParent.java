package com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.columnAuth;

/**
 * Created by Administrator on 2018/7/11.
 * 模块公共属性
 */
public class ModelParent {

//insert into model_users_spc values('DB2535F4-9DA6-4F1C-B9BE-563E3A403D20','exportExcelCanSee','F','商品信息导出6个字段不可见',10)
    //增加一个控制 点位,该点位暂时只在产品信息excel导出模块起作用
    //用来控制以下几个点位
//    startsellcount  采购起订量
//    littleorderprice 采购小单费
//    modelcost  采购模具费
//    miniOrderAmt 采购起订金额
//    采购含运费    haveTransBuyBenBi
//    采购不含运费  noTransBuyBenBi
    protected String exportExcelCanSee="1";


    //操作
    protected String operate="1";
    //查看信息
    protected String checkMsg="1";

    //采购价格控制
    protected String buyPrice="1";
    //销售价格控制
    protected String salePrice="1";

    //1是可以,0是不可以

    //一条录入记录的唯一标识符号
    protected String id="1";
    //产品编码
    protected String prdCode="1";
    //下面2个用作产品名称,的name和no,   分类的再加两个
    //原来徐勇的界面上改了框里面的东西,其他地方不用改,前端的分类框中填范围小的,前端的名称框放范围 大的
    //大范围的//产品名称
    protected String idxName="1";
    //产品编号(高层分类编号)
    protected String idxNo="1";
    //货号
    protected String prdNo="1";
    //下面2个用于界面上产品分类那一栏//注意,存的时候不存,只是返回的时候返回给前端

    //小范围的//中类号(底层分类编号)
    protected String fenLeiNo="1";

    protected String fenLeiName="1";//产品中类

    protected String markName="1";//品牌

    protected String markNo="1";//品牌编号

    protected String colour="1";//颜色

    protected String size="1";//尺寸
    //产品负责人
    protected String salName="1";
    //产品负责人编码
    protected String salNo="1";
    // cust表1是客户  2是厂商  3是客户/厂商   4  会员客户
    protected String cusNo="1";//客户编号
    protected String cusName="1";//客户名称
    //供应商编号
    protected String cusNoGive="1";
    //供应商名字
    protected String cusNameGive="1";
    protected String isfenjie="1";//是否分解//是否分解, y代表分解, n代表不分解

    protected String sampMake="1";//打样时间
    protected String sampSend="1";//----样品寄出时间

    //样品要求
    protected String sampRequ="1";
    //样品描述//产品描述
    protected String sampDesc="1";
    //---缩略图名字包含的路径字符串,用="1";隔开,路径里面有!导致用户的缩略名字不能有!和="1";
    protected String thum="1";

    //附件路径字符串,多个用="1";隔开,名字中的！做分隔符号
    protected String attach="1";



    //该条记录插入时间,数据库自动会添加DEFAULT一个getdate()
    protected String insertdate="1";

    protected String confirmman="1";//确认人

    protected String confirmtimestr="1";//确认时间   直接带-的字符串

    protected String isconfirm="1";//是否确认，1代表已经确认  0代表未确认

    protected String category="1";//

    protected String teamname="1";//

    protected String confirmrem="1";//确认备注

    protected String businessdesc="1";//业务描述

    protected String financedesc="1";//财务描述



    protected String modelcost="1";//模具费

    protected String estimateprice="1";//预估价



    //模具费用发票号
    protected String modelcostinvoiceno="1";


    //小单费
    protected String littleorderprice="1";
    //起订金额
    protected String miniOrderAmt="1";
    //采购起订数量
    protected String startsellcount="1";


    //财务起订金额
    protected String fiMiniOrderAmt="1";
    //财务起订量
    protected String financestartsellcount="1";
    //财务模具费
    protected String financemodelcost="1";
    //财务小单费
    protected String financelittleorderprice="1";

    //采购描述
    protected String buyerdesc="1";


    //销售描述
    protected String salemandesc="1";
    //    /停用时间/
    protected String stopusedate="1";


    //主单位,由于2018_3_10   weekday(6)   19:34:05老郑让打样的excel中添加一个主单位
    //这个主单位主要是将来进去prdt用的,不进prdt_samp也可以,但是我还是让他一起进去了
    protected String mainUnit="1";

    //是否审核   0或者null或者''代表未提交,  1代表已经提交但未审核,  2代表已经审核过
    //    有状态: 0、未提交,1、已经提交但是未审核等待审核,2、已经提交已审核
    //-- ---2018_6_19   weekday(2)   12:08:01---  添加一个是否提交并审核字段该字段 is_check_out 有状态:
    //            -- 0(或者null或者'')、未提交,
    //            --  1、已经提交但是未审核等待审核,2、已经提交已审核  ---------- --
    //            --    提交的前提是: 必须有： 供应商(cus_No_Give,cus_Name_Give),起订量(startsellcount),小单费(littleorderprice) 和 已经进行过采购定价
    protected String isCheckOut="1";

    //审核意见
    protected String checkOutOpinion="1";


    public String getExportExcelCanSee() {
        return exportExcelCanSee;
    }

    public void setExportExcelCanSee(String exportExcelCanSee) {
        this.exportExcelCanSee = exportExcelCanSee;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public String getIdxNo() {
        return idxNo;
    }

    public void setIdxNo(String idxNo) {
        this.idxNo = idxNo;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }

    public String getFenLeiNo() {
        return fenLeiNo;
    }

    public void setFenLeiNo(String fenLeiNo) {
        this.fenLeiNo = fenLeiNo;
    }

    public String getFenLeiName() {
        return fenLeiName;
    }

    public void setFenLeiName(String fenLeiName) {
        this.fenLeiName = fenLeiName;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getMarkNo() {
        return markNo;
    }

    public void setMarkNo(String markNo) {
        this.markNo = markNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSalName() {
        return salName;
    }

    public void setSalName(String salName) {
        this.salName = salName;
    }

    public String getSalNo() {
        return salNo;
    }

    public void setSalNo(String salNo) {
        this.salNo = salNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusNoGive() {
        return cusNoGive;
    }

    public void setCusNoGive(String cusNoGive) {
        this.cusNoGive = cusNoGive;
    }

    public String getCusNameGive() {
        return cusNameGive;
    }

    public void setCusNameGive(String cusNameGive) {
        this.cusNameGive = cusNameGive;
    }

    public String getIsfenjie() {
        return isfenjie;
    }

    public void setIsfenjie(String isfenjie) {
        this.isfenjie = isfenjie;
    }

    public String getSampMake() {
        return sampMake;
    }

    public void setSampMake(String sampMake) {
        this.sampMake = sampMake;
    }

    public String getSampSend() {
        return sampSend;
    }

    public void setSampSend(String sampSend) {
        this.sampSend = sampSend;
    }

    public String getSampRequ() {
        return sampRequ;
    }

    public void setSampRequ(String sampRequ) {
        this.sampRequ = sampRequ;
    }

    public String getSampDesc() {
        return sampDesc;
    }

    public void setSampDesc(String sampDesc) {
        this.sampDesc = sampDesc;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    public String getConfirmman() {
        return confirmman;
    }

    public void setConfirmman(String confirmman) {
        this.confirmman = confirmman;
    }

    public String getConfirmtimestr() {
        return confirmtimestr;
    }

    public void setConfirmtimestr(String confirmtimestr) {
        this.confirmtimestr = confirmtimestr;
    }

    public String getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(String isconfirm) {
        this.isconfirm = isconfirm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getConfirmrem() {
        return confirmrem;
    }

    public void setConfirmrem(String confirmrem) {
        this.confirmrem = confirmrem;
    }


    public String getBusinessdesc() {
        return businessdesc;
    }

    public void setBusinessdesc(String businessdesc) {
        this.businessdesc = businessdesc;
    }

    public String getFinancedesc() {
        return financedesc;
    }

    public void setFinancedesc(String financedesc) {
        this.financedesc = financedesc;
    }

    public String getModelcost() {
        return modelcost;
    }

    public void setModelcost(String modelcost) {
        this.modelcost = modelcost;
    }

    public String getEstimateprice() {
        return estimateprice;
    }

    public void setEstimateprice(String estimateprice) {
        this.estimateprice = estimateprice;
    }

    public String getModelcostinvoiceno() {
        return modelcostinvoiceno;
    }

    public void setModelcostinvoiceno(String modelcostinvoiceno) {
        this.modelcostinvoiceno = modelcostinvoiceno;
    }

    public String getLittleorderprice() {
        return littleorderprice;
    }

    public void setLittleorderprice(String littleorderprice) {
        this.littleorderprice = littleorderprice;
    }

    public String getMiniOrderAmt() {
        return miniOrderAmt;
    }

    public void setMiniOrderAmt(String miniOrderAmt) {
        this.miniOrderAmt = miniOrderAmt;
    }

    public String getStartsellcount() {
        return startsellcount;
    }

    public void setStartsellcount(String startsellcount) {
        this.startsellcount = startsellcount;
    }

    public String getFiMiniOrderAmt() {
        return fiMiniOrderAmt;
    }

    public void setFiMiniOrderAmt(String fiMiniOrderAmt) {
        this.fiMiniOrderAmt = fiMiniOrderAmt;
    }

    public String getFinancestartsellcount() {
        return financestartsellcount;
    }

    public void setFinancestartsellcount(String financestartsellcount) {
        this.financestartsellcount = financestartsellcount;
    }

    public String getFinancemodelcost() {
        return financemodelcost;
    }

    public void setFinancemodelcost(String financemodelcost) {
        this.financemodelcost = financemodelcost;
    }

    public String getFinancelittleorderprice() {
        return financelittleorderprice;
    }

    public void setFinancelittleorderprice(String financelittleorderprice) {
        this.financelittleorderprice = financelittleorderprice;
    }

    public String getBuyerdesc() {
        return buyerdesc;
    }

    public void setBuyerdesc(String buyerdesc) {
        this.buyerdesc = buyerdesc;
    }

    public String getSalemandesc() {
        return salemandesc;
    }

    public void setSalemandesc(String salemandesc) {
        this.salemandesc = salemandesc;
    }

    public String getStopusedate() {
        return stopusedate;
    }

    public void setStopusedate(String stopusedate) {
        this.stopusedate = stopusedate;
    }



    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getIsCheckOut() {
        return isCheckOut;
    }

    public void setIsCheckOut(String isCheckOut) {
        this.isCheckOut = isCheckOut;
    }

    public String getCheckOutOpinion() {
        return checkOutOpinion;
    }

    public void setCheckOutOpinion(String checkOutOpinion) {
        this.checkOutOpinion = checkOutOpinion;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getCheckMsg() {
        return checkMsg;
    }

    public void setCheckMsg(String checkMsg) {
        this.checkMsg = checkMsg;
    }
}
