package com.winwin.picreport.Edto;

public class ShouDingDanFromExcel {


/*    public String getUnit() {
//        return unit;
        return  "1";//老郑让这么干的
    }*/


//    public void setUnit(String unit) {
//        this.unit = "1";
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    //仓库编号在界面选取
    private String wh="";//仓库编号  2018_4_10   weekday(2)   10:10:25  Winston add
    private String osDd = "";//受订日期
    private String estDd = "";//预交日期
    private String taxId = "";//扣税类别
    private String osNo = "";//受订单号
    private String cusOsNo = "";//客户订单
    private String saphh = "";//SAP行号
    private String remhead = "";//表头备注
    private String sapph = "";//sap品号
    private String prdNo = "";//货号
    private String sapwlm = "";//sap物料名
    private String cfdm = "";//成分代码
    private String prdName = "";//品名
    private String curId = "";//币别
    private String excRto = "";//汇率
    private String qty = "";//数量
    private String unit = "";//单位
    private String up = "";//单价
    private String amtn = "";//未税本位币
    private String tax = "";//税额
    private String amt = "";//金额
    private String taxRto = "";//税率
    private String remBody = "";//表身备注
    private String cusNo = "";//客户代码
    private String caiGouNo="";//采购单号
    private String maiTouNo="";//唛头号
    private String ebNo="";//EB单号
    private String luoHao="";//---落号
    private String gangHao="";//--缸号
    private String realWidth="";//实际幅宽
    private String realLength="";//实际长度
    //业务员代号在界面选取
    private String salNo="";//业务员代号
    //2018_6_1   weekday(5)   9:50:37加上
    /**
     *3）	标准订单的导入格式里加一列对方品号（最好列次序不要固定，识别列名就可以）。
     * 如果excel有品号按照品号，如果excel里无品号，有客户代码，对方品号，
     * 按同时符合这两个条件的查出品号
     * select  prd_no  from prdt_cus1 where  cus_no=客户代码 and sup_prd_no=对方品号
     * */
    //对方品号
    private String duiFangPrdNo="";


    //加bilType, 运费类型, 1.不含运费 2.含运费//将来导入mf_pos.bil_type
    //2018_8_24   weekday(5)   10:58:01
    private String bilType;





    public String getBilType() {
        return bilType;
    }

    public void setBilType(String bilType) {
        this.bilType = bilType;
    }

    public String getWh() {
        return wh;
    }

    public ShouDingDanFromExcel setWh(String wh) {
        this.wh = wh;
        return this;
    }

    public String getSalNo() {
        return salNo;
    }

    public ShouDingDanFromExcel setSalNo(String salNo) {
        this.salNo = salNo;
        return this;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////

    public String getOsDd() {
        return osDd;
    }

    public ShouDingDanFromExcel setOsDd(String osDd) {
        this.osDd = osDd;
        return this;
    }

    public String getEstDd() {
        return estDd;
    }

    public ShouDingDanFromExcel setEstDd(String estDd) {
        this.estDd = estDd;
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public ShouDingDanFromExcel setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public String getOsNo() {
        return osNo;
    }

    public ShouDingDanFromExcel setOsNo(String osNo) {
        this.osNo = osNo;
        return this;
    }

    public String getCusOsNo() {
        return cusOsNo;
    }

    public ShouDingDanFromExcel setCusOsNo(String cusOsNo) {
        this.cusOsNo = cusOsNo;
        return this;
    }

    public String getSaphh() {
        return saphh;
    }

    public ShouDingDanFromExcel setSaphh(String saphh) {
        this.saphh = saphh;
        return this;
    }

    public String getRemhead() {
        return remhead;
    }

    public ShouDingDanFromExcel setRemhead(String remhead) {
        this.remhead = remhead;
        return this;
    }

    public String getSapph() {
        return sapph;
    }

    public ShouDingDanFromExcel setSapph(String sapph) {
        this.sapph = sapph;
        return this;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public ShouDingDanFromExcel setPrdNo(String prdNo) {
        this.prdNo = prdNo;
        return this;
    }

    public String getSapwlm() {
        return sapwlm;
    }

    public ShouDingDanFromExcel setSapwlm(String sapwlm) {
        this.sapwlm = sapwlm;
        return this;
    }

    public String getCfdm() {
        return cfdm;
    }

    public ShouDingDanFromExcel setCfdm(String cfdm) {
        this.cfdm = cfdm;
        return this;
    }

    public String getPrdName() {
        return prdName;
    }

    public ShouDingDanFromExcel setPrdName(String prdName) {
        this.prdName = prdName;
        return this;
    }

    public String getCurId() {
        return curId;
    }

    public ShouDingDanFromExcel setCurId(String curId) {
        this.curId = curId;
        return this;
    }

    public String getExcRto() {
        return excRto;
    }

    public ShouDingDanFromExcel setExcRto(String excRto) {
        this.excRto = excRto;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public ShouDingDanFromExcel setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public ShouDingDanFromExcel setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getUp() {
        return up;
    }

    public ShouDingDanFromExcel setUp(String up) {
        this.up = up;
        return this;
    }

    public String getAmtn() {
        return amtn;
    }

    public ShouDingDanFromExcel setAmtn(String amtn) {
        this.amtn = amtn;
        return this;
    }

    public String getTax() {
        return tax;
    }

    public ShouDingDanFromExcel setTax(String tax) {
        this.tax = tax;
        return this;
    }

    public String getAmt() {
        return amt;
    }

    public ShouDingDanFromExcel setAmt(String amt) {
        this.amt = amt;
        return this;
    }

    public String getTaxRto() {
        return taxRto;
    }

    public ShouDingDanFromExcel setTaxRto(String taxRto) {
        this.taxRto = taxRto;
        return this;
    }

    public String getRemBody() {
        return remBody;
    }

    public ShouDingDanFromExcel setRemBody(String remBody) {
        this.remBody = remBody;
        return this;
    }

    public String getCusNo() {
        return cusNo;
    }

    public ShouDingDanFromExcel setCusNo(String cusNo) {
        this.cusNo = cusNo;
        return this;
    }

    public String getCaiGouNo() {
        return caiGouNo;
    }

    public ShouDingDanFromExcel setCaiGouNo(String caiGouNo) {
        this.caiGouNo = caiGouNo;
        return this;
    }

    public String getMaiTouNo() {
        return maiTouNo;
    }

    public ShouDingDanFromExcel setMaiTouNo(String maiTouNo) {
        this.maiTouNo = maiTouNo;
        return this;
    }

    public String getEbNo() {
        return ebNo;
    }

    public ShouDingDanFromExcel setEbNo(String ebNo) {
        this.ebNo = ebNo;
        return this;
    }

    public String getLuoHao() {
        return luoHao;
    }

    public ShouDingDanFromExcel setLuoHao(String luoHao) {
        this.luoHao = luoHao;
        return this;
    }

    public String getGangHao() {
        return gangHao;
    }

    public ShouDingDanFromExcel setGangHao(String gangHao) {
        this.gangHao = gangHao;
        return this;
    }

    public String getRealWidth() {
        return realWidth;
    }

    public ShouDingDanFromExcel setRealWidth(String realWidth) {
        this.realWidth = realWidth;
        return this;
    }

    public String getRealLength() {
        return realLength;
    }

    public ShouDingDanFromExcel setRealLength(String realLength) {
        this.realLength = realLength;
        return this;
    }

    public String getDuiFangPrdNo() {
        return duiFangPrdNo;
    }

    public void setDuiFangPrdNo(String duiFangPrdNo) {
        this.duiFangPrdNo = duiFangPrdNo;
    }

    @Override
    public String toString() {
        return "ShouDingDanFromExcel{" +
                "wh='" + wh + '\'' +
                ", osDd='" + osDd + '\'' +
                ", estDd='" + estDd + '\'' +
                ", taxId='" + taxId + '\'' +
                ", osNo='" + osNo + '\'' +
                ", cusOsNo='" + cusOsNo + '\'' +
                ", saphh='" + saphh + '\'' +
                ", remhead='" + remhead + '\'' +
                ", sapph='" + sapph + '\'' +
                ", prdNo='" + prdNo + '\'' +
                ", sapwlm='" + sapwlm + '\'' +
                ", cfdm='" + cfdm + '\'' +
                ", prdName='" + prdName + '\'' +
                ", curId='" + curId + '\'' +
                ", excRto='" + excRto + '\'' +
                ", qty='" + qty + '\'' +
                ", unit='" + unit + '\'' +
                ", up='" + up + '\'' +
                ", amtn='" + amtn + '\'' +
                ", tax='" + tax + '\'' +
                ", amt='" + amt + '\'' +
                ", taxRto='" + taxRto + '\'' +
                ", remBody='" + remBody + '\'' +
                ", cusNo='" + cusNo + '\'' +
                ", caiGouNo='" + caiGouNo + '\'' +
                ", maiTouNo='" + maiTouNo + '\'' +
                ", ebNo='" + ebNo + '\'' +
                ", luoHao='" + luoHao + '\'' +
                ", gangHao='" + gangHao + '\'' +
                ", realWidth='" + realWidth + '\'' +
                ", realLength='" + realLength + '\'' +
                ", salNo='" + salNo + '\'' +
                ", duiFangPrdNo='" + duiFangPrdNo + '\'' +
                ", bilType='" + bilType + '\'' +
                '}';
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/*

*
* 
* */