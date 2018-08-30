package com.winwin.picreport.Edto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.Constant.ConstantInit;
import com.winwin.picreport.Futils.hanhan.p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */
public class PrdtSampExcleExportManyCondition {
    private String id;//一条录入记录的唯一标识符号
    private String prdCode;//产品编码
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //下面2个用作产品名称,的name和no,   分类的再加两个
    //原来徐勇的界面上改了框里面的东西,其他地方不用改,前端的分类框中填范围小的,前端的名称框放范围 大的
    //大范围的
    private String idxName;//产品名称

    private String idxNo;//产品的no
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //下面2个用于界面上产品分类那一栏//注意,存的时候不存,只是返回的时候返回给前端

    //小范围的
    private String fenLeiNo;

    private String fenLeiName;//产品中类
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String markName;//品牌

    private String markNo;//品牌编号

    private String colour;//颜色

    private String size;//尺寸
    //产品负责人
    private String salName;
    //产品负责人编码
    private String salNo;
    // cust表1是客户  2是厂商  3是客户/厂商   4  会员客户
    private String cusNo;//客户编号
    private String cusName;//客户名称
    //供应商编号
    private String cusNoGive;
    //供应商名字
    private String cusNameGive;
    private String isfenjie;//是否分解//是否分解, y代表分解, n代表不分解
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        private Date sampMake;//打样时间

    private String sampMake;//打样时间


    //        private Date sampSend;//----样品寄出时间
    private String sampSend;//----样品寄出时间
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //样品要求
    private String sampRequ;
    //样品描述//产品描述
    private String sampDesc;
    //---缩略图名字包含的路径字符串,用;隔开,路径里面有!导致用户的缩略名字不能有!和;
    private String thum;

    //附件路径字符串,多个用;隔开,名字中的！做分隔符号
    private String attach;
    ///////////////////////////////////////////////////////////////////////////
    //该条记录插入时间,数据库自动会添加DEFAULT一个getdate()
//        private Date insertdate;
    private String insertdate;
    private String confirmman;//确认人

    private String confirmtimestr;//确认时间   直接带-的字符串

//        private Integer isconfirm;//是否确认，1代表已经确认  0代表未确认

    private String isconfirm;

    private String category;//未知//老郑让弄得

    private String teamname;//未知//老郑让弄得

    private String confirmrem;//确认备注


    private String businessdesc;//业务描述

    private String financedesc;//财务描述

    //        private BigDecimal startsellcount;//采购起订数量//json可以直接转换输出给外部//起订量
    private String startsellcount;
    //        private BigDecimal modelcost;//模具费
    private String modelcost;//模具费
    //        private BigDecimal estimateprice;//预估价
    private String estimateprice;//预估价
    //        private BigDecimal littleorderprice;//小单费
    private String littleorderprice;//小单费
    private String modelcostinvoiceno;//模具费用发票号
    //财务起订量
//        private BigDecimal financestartsellcount;
    private String financestartsellcount;
    //财务模具费
//        private BigDecimal financemodelcost;
    private String financemodelcost;
    //财务小单费
//        private BigDecimal financelittleorderprice;
    private String financelittleorderprice;
    //采购描述
    private String buyerdesc;
    //货号
    private String prdNo;


    //销售描述
    private String salemandesc;
    //    /停用时间/
//        private Date stopusedate;
    private String stopusedate;

    //创建人的userName,实际上我传给徐勇的放在userEmail字段了
    private String userName;
    //创建人所在的公司,
    private String tenantId;
    //主单位,由于2018_3_10   weekday(6)   19:34:05老郑让打样的excel中添加一个主单位
    //这个主单位主要是将来进去prdt用的,不进prdt_samp也可以,但是我还是让他一起进去了,并且考察prdt表并进入了
    private String mainUnit;//prdt表里的

    private String unit;//单位,up_def表里的
    //是否审核   0或者null或者''代表未提交,  1代表已经提交但未审核,  2代表已经审核过
    //    有状态: 0、未提交,1、已经提交但是未审核等待审核,2、已经提交已审核
    //-- ---2018_6_19   weekday(2)   12:08:01---  添加一个是否提交并审核字段该字段 is_check_out 有状态:
    //            -- 0(或者null或者'')、未提交,
    //            --  1、已经提交但是未审核等待审核,2、已经提交已审核  ---------- --
    //            --    提交的前提是: 必须有： 供应商(cus_No_Give,cus_Name_Give),起订量(startsellcount),小单费(littleorderprice) 和 已经进行过采购定价
    private String isCheckOut;

    //审核意见
    private String checkOutOpinion;

    //起订金额
//        private BigDecimal miniOrderAmt;
    private String miniOrderAmt;
    //财务起订金额
//        private BigDecimal fiMiniOrderAmt;

    private String fiMiniOrderAmt;

    //不含运费单价的销售价格//up_def中bil_type=01
    private String noTransUpSale;//
    //含运费单价销售价格//up_def中bil_type!=01
    private String haveTransUpSale;//

    //注意:采购只有本币
    //由于销售价格有本币和外币区别,所以加2个字段区分//然后上面2个作为本币销售
    //不含运费单价的销售价格外币
    private String noTransUpSaleWaiBi;//
    //含运费单价销售价格外币//up_def中bil_type!=01
    private String haveTransUpSaleWaiBi;//

    //该条记录的所有缩略图路径的集合,用上面的dirUrl来拼接
    private  List<String> thumUrlList=new ArrayList<>();
    //该条记录的所有附件路径的集合,用上面的dirUrl来拼接
    private List<String> attachUrlList=new ArrayList<>();

    //服务器的和图片所在的ip和域名,用于拼接附件和图片的地址
    private String dirUrl="http://10.0.3.101:8070/";

    //价格日期//up_def
    private String sDd;
    //价格数量//up_def
    private String qty;
    //销售的
    private List<UpDefMy01>upDefMyList=new ArrayList<>();
    //价格列表,单独采购的
    private List<UpDefMy01>upDefMyListBuy=new ArrayList<>();


    //加一个销售备注,没有销售备注的取采购备注
    private String rem;

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getsDd() {
        return sDd;
    }

    public void setsDd(String sDd) {
        this.sDd = sDd;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public List<UpDefMy01> getUpDefMyList() {
        return upDefMyList;
    }

    public PrdtSampExcleExportManyCondition setUpDefMyList(List<UpDefMy01> upDefMyList) {
        this.upDefMyList = upDefMyList;
        return this;
    }


    public List<UpDefMy01> getUpDefMyListBuy() {
        return upDefMyListBuy;
    }

    public PrdtSampExcleExportManyCondition setUpDefMyListBuy(List<UpDefMy01> upDefMyListBuy) {
        this.upDefMyListBuy = upDefMyListBuy;
        return this;
    }







    //构造函数初始化网址
    public PrdtSampExcleExportManyCondition(){
        this.dirUrl= ConstantInit.getDirUrl001();
    }

    public List<String> getThumUrlList() {
        String thum1=this.getThum();
        //把得到的缩略图的一堆路径拆成数组
        if(thum1!=null&&!"".equals(thum1)){
            List<String> strings = Arrays.asList(thum1.split(";"));
            List<String>strList=new ArrayList<>();
            //给每个图片加上地址、
            for(String  str:strings){
                strList.add(dirUrl+str);
            }
            this.thumUrlList=strList;
        }
        return thumUrlList;
    }


    public PrdtSampExcleExportManyCondition setThumUrlList(List<String> thumUrlList) {
        this.thumUrlList = thumUrlList;
        return this;
    }


    public List<String> getAttachUrlList() {
        String attach1=this.getAttach();
        //把得到的缩略图的一堆路径拆成数组
        if(attach1!=null&&!Cnst.emptyStr.equals(attach1)){
            List<String> strings = Arrays.asList(attach1.split(Cnst.fenHao));
            List<String>strList=new ArrayList<>();
            for(String str:strings){
                strList.add(dirUrl+str);
            }
            this.attachUrlList=strList;
        }
        return attachUrlList;
    }

    public PrdtSampExcleExportManyCondition setAttachUrlList(List<String> attachUrlList) {
        this.attachUrlList = attachUrlList;
        return this;
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
        return this.getSjc(sampMake);
    }

    public void setSampMake(String sampMake) {
        this.sampMake = sampMake;
    }

    public String getSampSend() {
        return this.getSjc(sampSend);
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

        return this.getSjc(insertdate);
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
        if(p.notEmpty(financelittleorderprice)){
            financelittleorderprice=p.del0(financelittleorderprice);
        }
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
        return this.getSjc(stopusedate);
    }

    public void setStopusedate(String stopusedate) {
        this.stopusedate = stopusedate;
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

    public String getMiniOrderAmt() {
        return miniOrderAmt;
    }

    public void setMiniOrderAmt(String miniOrderAmt) {
        this.miniOrderAmt = miniOrderAmt;
    }

    public String getFiMiniOrderAmt() {
        return fiMiniOrderAmt;
    }

    public void setFiMiniOrderAmt(String fiMiniOrderAmt) {
        this.fiMiniOrderAmt = fiMiniOrderAmt;
    }

    public String getNoTransUpSale() {
        if(p.notEmpty(noTransUpSale)){
            noTransUpSale=p.del0(noTransUpSale);
        }
        return noTransUpSale;
    }

    public void setNoTransUpSale(String noTransUpSale) {
        this.noTransUpSale = noTransUpSale;
    }

    public String getHaveTransUpSale() {
        if(p.notEmpty(haveTransUpSale)){
            haveTransUpSale=p.del0(haveTransUpSale);
        }
        return haveTransUpSale;
    }

    public void setHaveTransUpSale(String haveTransUpSale) {
        this.haveTransUpSale = haveTransUpSale;
    }

    public String getNoTransUpSaleWaiBi() {
        if(p.notEmpty(noTransUpSaleWaiBi)){
            noTransUpSaleWaiBi=p.del0(noTransUpSaleWaiBi);
        }
        return noTransUpSaleWaiBi;
    }

    public void setNoTransUpSaleWaiBi(String noTransUpSaleWaiBi) {
        this.noTransUpSaleWaiBi = noTransUpSaleWaiBi;
    }

    public String getHaveTransUpSaleWaiBi() {
        if(p.notEmpty(haveTransUpSaleWaiBi)){
            haveTransUpSaleWaiBi=p.del0(haveTransUpSaleWaiBi);
        }
        return haveTransUpSaleWaiBi;
    }

    public void setHaveTransUpSaleWaiBi(String haveTransUpSaleWaiBi) {
        this.haveTransUpSaleWaiBi = haveTransUpSaleWaiBi;
    }
    public String getSjc(String strSj){
        if(p.empty(strSj)){
            return null;
        }else{
            try {
                //yyyy-MM-dd注意:写成yyyy-MM-dd hh:mm:ss.sss就会过于严格
                Date d=new SimpleDateFormat("yyyy-MM-dd").parse(strSj);
                strSj=String.valueOf(d.getTime());
            } catch (ParseException e) {
                return null;
            }
        }
        return strSj;
    }
    @Override
    public String toString() {
        return "PrdtSampExcleExportManyCondition{" +
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
                ", cusNoGive='" + cusNoGive + '\'' +
                ", cusNameGive='" + cusNameGive + '\'' +
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
                ", userName='" + userName + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", mainUnit='" + mainUnit + '\'' +
                ", unit='" + unit + '\'' +
                ", isCheckOut='" + isCheckOut + '\'' +
                ", checkOutOpinion='" + checkOutOpinion + '\'' +
                ", miniOrderAmt='" + miniOrderAmt + '\'' +
                ", fiMiniOrderAmt='" + fiMiniOrderAmt + '\'' +
                ", noTransUpSale='" + noTransUpSale + '\'' +
                ", haveTransUpSale='" + haveTransUpSale + '\'' +
                ", noTransUpSaleWaiBi='" + noTransUpSaleWaiBi + '\'' +
                ", haveTransUpSaleWaiBi='" + haveTransUpSaleWaiBi + '\'' +
                '}';
    }
}
