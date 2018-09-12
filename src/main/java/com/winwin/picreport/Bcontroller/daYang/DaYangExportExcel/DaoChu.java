package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.winwin.picreport.Futils.hanhan.p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/1.
 */
public class DaoChu {

    //select nm_eng,* from cust
    //NE CODE NE编码
    private String nmEng;

    private String id;//一条录入记录的唯一标识符号
    private String prdCode;//产品编码
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //下面2个用作产品名称,的name和no,   分类的再加两个
    //原来徐勇的界面上改了框里面的东西,其他地方不用改,前端的分类框中填范围小的,前端的名称框放范围 大的
    private String idxName;//产品名称

    private String idxNameE;//产品名称

    private String idxNo;//产品的no
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //下面2个用于界面上产品分类那一栏//注意,存的时候不存,只是返回的时候返回给前端
    private String fenLeiNo;

    private String fenLeiName;

    private String fenLeiNameE;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String markName;//品牌

    private String markNo;//品牌编号

    private String colour;//颜色

    private String size;//尺寸
    //产品负责人
    private String salName;
    //产品负责人编码
    private String salNo;

    private String cusNo;//客户编号

    private String cusName;//客户名称

    private String isfenjie;//是否分解//是否分解, y代表分解, n代表不分解
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String sampMake;//打样时间

    private String sampSend;//----样品寄出时间
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //样品要求
    private String sampRequ;
    //样品描述
    private String sampDesc;
    //---缩略图名字包含的路径字符串,用;隔开,路径里面有!导致用户的缩略名字不能有!和;
    private String thum;



    //附件路径字符串,多个用;隔开,名字中的！做分隔符号
    private String attach;
    ///////////////////////////////////////////////////////////////////////////
    //该条记录插入时间,数据库自动会添加DEFAULT一个getdate()
    private String insertdate;

    private String confirmman;//确认人

    private String confirmtimestr;//确认时间   直接带-的字符串

    private String isconfirm;//是否确认，1代表已经确认  0代表未确认

    private String category;//未知//老郑让弄得

    private String teamname;//未知//老郑让弄得

    private String confirmrem;//确认备注

    private String unit;//单位

    private String businessdesc;//业务描述

    private String financedesc;//财务描述

    private String startsellcount;//起订数量//json可以直接转换输出给外部

    private String modelcost;//模具费

    private String estimateprice;//预估价

    private String littleorderprice;//小单费

    private String modelcostinvoiceno;//模具费用发票号

    //财务起订量
    private String financestartsellcount;
    //财务模具费
    private String financemodelcost;
    //财务小单费
    private String financelittleorderprice;
    //采购描述
    private String buyerdesc;
    //货号
    private String prdNo;

    //销售描述
    private String salemandesc;
    //    /停用时间/
    private String stopusedate;
    //供应商编号
    private String cusNoGive;

    //供应商名字
    private String cusNameGive;

    //创建人的userName,实际上我传给徐勇的放在userEmail字段了
    private String userName;
    //创建人所在的公司,
    private String tenantId;
    //主单位,由于2018_3_10   weekday(6)   19:34:05老郑让打样的excel中添加一个主单位
    //这个主单位主要是将来进去prdt用的,不进prdt_samp也可以,但是我还是让他一起进去了
    private String mainUnit;

    //未分类之前的单价
    private String  up;

    //含运费本币销售价格
    private String  haveTransUpSaleBenBi;


    //含运费单价销售外币价格
    private String haveTransUpSaleWaiBi;

    //无运费单价销售本币
    private String noTransUpSaleBenBi;

    //无运费单价销售WaiBi
    private String noTransUpSaleWaiBi;


    public String getNoTransUpSaleWaiBi() {

        return noTransUpSaleWaiBi;

    }

    public void setNoTransUpSaleWaiBi(String noTransUpSaleWaiBi) {
        this.noTransUpSaleWaiBi = noTransUpSaleWaiBi;
    }

    public String getHaveTransUpSaleWaiBi() {
        return haveTransUpSaleWaiBi;
    }

    public void setHaveTransUpSaleWaiBi(String haveTransUpSaleWaiBi) {
        this.haveTransUpSaleWaiBi = haveTransUpSaleWaiBi;
    }

    public String getNoTransUpSaleBenBi() {
        return noTransUpSaleBenBi;
    }

    public void setNoTransUpSaleBenBi(String noTransUpSaleBenBi) {
        this.noTransUpSaleBenBi = noTransUpSaleBenBi;
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
        //suoLueTuAndFuJian/636260305823469446.jpg;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getStartsellcount() {
        return startsellcount;
    }

    public void setStartsellcount(String startsellcount) {
        this.startsellcount = startsellcount;
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

    public String getLittleorderprice() {
        return littleorderprice;
    }

    public void setLittleorderprice(String littleorderprice) {
        this.littleorderprice = littleorderprice;
    }

    public String getModelcostinvoiceno() {
        return modelcostinvoiceno;
    }

    public void setModelcostinvoiceno(String modelcostinvoiceno) {
        this.modelcostinvoiceno = modelcostinvoiceno;
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

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getHaveTransUpSaleBenBi() {
        return haveTransUpSaleBenBi;
    }

    public void setHaveTransUpSaleBenBi(String haveTransUpSaleBenBi) {
        this.haveTransUpSaleBenBi = haveTransUpSaleBenBi;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getNmEng() {
        return nmEng;
    }

    public void setNmEng(String nmEng) {
        this.nmEng = nmEng;
    }


    public String getIdxNameE() {
        return idxNameE;
    }

    public void setIdxNameE(String idxNameE) {
        this.idxNameE = idxNameE;
    }

    public String getFenLeiNameE() {
        return fenLeiNameE;
    }

    public void setFenLeiNameE(String fenLeiNameE) {
        this.fenLeiNameE = fenLeiNameE;
    }

    @Override
    public String toString() {
        return "DaoChu{" +
                "id='" + id + '\'' +
                ", prdCode='" + prdCode + '\'' +
                ", idxName='" + idxName + '\'' +
                ", idxNo='" + idxNo + '\'' +
                ", fenLeiNo='" + fenLeiNo + '\'' +
                ", fenLeiName='" + fenLeiName + '\'' +
                ", markName='" + markName + '\'' +
                ", markNo='" + markNo + '\'' +
                ", colour='" + colour + '\'' +
                ", size='" + size + '\'' +
                ", salName='" + salName + '\'' +
                ", salNo='" + salNo + '\'' +
                ", cusNo='" + cusNo + '\'' +
                ", cusName='" + cusName + '\'' +
                ", isfenjie='" + isfenjie + '\'' +
                ", sampMake='" + sampMake + '\'' +
                ", sampSend='" + sampSend + '\'' +
                ", sampRequ='" + sampRequ + '\'' +
                ", sampDesc='" + sampDesc + '\'' +
                ", thum='" + thum + '\'' +
                ", attach='" + attach + '\'' +
                ", insertdate='" + insertdate + '\'' +
                ", confirmman='" + confirmman + '\'' +
                ", confirmtimestr='" + confirmtimestr + '\'' +
                ", isconfirm='" + isconfirm + '\'' +
                ", category='" + category + '\'' +
                ", teamname='" + teamname + '\'' +
                ", confirmrem='" + confirmrem + '\'' +
                ", unit='" + unit + '\'' +
                ", businessdesc='" + businessdesc + '\'' +
                ", financedesc='" + financedesc + '\'' +
                ", startsellcount='" + startsellcount + '\'' +
                ", modelcost='" + modelcost + '\'' +
                ", estimateprice='" + estimateprice + '\'' +
                ", littleorderprice='" + littleorderprice + '\'' +
                ", modelcostinvoiceno='" + modelcostinvoiceno + '\'' +
                ", financestartsellcount='" + financestartsellcount + '\'' +
                ", financemodelcost='" + financemodelcost + '\'' +
                ", financelittleorderprice='" + financelittleorderprice + '\'' +
                ", buyerdesc='" + buyerdesc + '\'' +
                ", prdNo='" + prdNo + '\'' +
                ", salemandesc='" + salemandesc + '\'' +
                ", stopusedate='" + stopusedate + '\'' +
                ", cusNoGive='" + cusNoGive + '\'' +
                ", cusNameGive='" + cusNameGive + '\'' +
                ", userName='" + userName + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", mainUnit='" + mainUnit + '\'' +
                ", up='" + up + '\'' +
                ", haveTransUpSaleBenBi='" + haveTransUpSaleBenBi + '\'' +
                ", haveTransUpSaleWaiBi='" + haveTransUpSaleWaiBi + '\'' +
                ", noTransUpSaleBenBi='" + noTransUpSaleBenBi + '\'' +
                ", noTransUpSaleWaiBi='" + noTransUpSaleWaiBi + '\'' +
                '}';
    }
}
