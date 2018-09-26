package com.winwin.picreport.Edto;

//我的定价表
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;
import java.math.BigDecimal;
public class UpDefMy01 extends UpDefMy {
    //dingJiaGuanLian最终存入up_def定价表OLEFIELD,为了让界面四种价格(含运费,不含运费,本币,外币)存入olefield的时候的关联字段
    String dingJiaGuanLian;
    String unitZhu;//主单位
    String unitFu;//副单位
    String usr;//操作员,登录的会员名
    String cusNo;//客户或者厂商
    //输入到up_def里面的rem备注
    String rem;//这个备注徐勇传过来
    //前端备注,不用了
    String remFront;
    //加一个uuid字段,让徐勇传过来保存新的单价,这个uuid就是prdtSamp表里面的唯一标识
    String  uuid;



    //不含运费单价的采购价格//up_def中bil_type=01
    BigDecimal noTransUpBuy;//
    //含运费单价采购价格//up_def中bil_type!=01
    BigDecimal haveTransUpBuy;//


    //不含运费单价的销售价格//up_def中bil_type=01
    BigDecimal noTransUpSale;//
    //含运费单价销售价格//up_def中bil_type!=01
    BigDecimal haveTransUpSale;//

    //注意:采购只有本币
    //由于销售价格有本币和外币区别,所以加2个字段区分//然后上面2个作为本币销售
    //不含运费单价的销售价格外币
    BigDecimal noTransUpSaleWaiBi;//
    //含运费单价销售价格外币//up_def中bil_type!=01
    BigDecimal haveTransUpSaleWaiBi;//

    //货号,后台数据流转用
    String prdNo;

    //prm_no,采购和销售一行上的联系no
    String prmNo;


    public String getPrmNo() {
        return prmNo;
    }

    public void setPrmNo(String prmNo) {
        this.prmNo = prmNo;
    }

    //数量
    public BigDecimal getQty() {
        if(null==qty){
            return qty;
        }else{
            return new BigDecimal(p.del0(String.valueOf(qty)));
        }
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }



    public BigDecimal getNoTransUpSaleWaiBi() {
        if(null==noTransUpSaleWaiBi){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(noTransUpSaleWaiBi)));
        }
//        return noTransUpSaleWaiBi;
    }

    public UpDefMy01 setNoTransUpSaleWaiBi(BigDecimal noTransUpSaleWaiBi) {
        this.noTransUpSaleWaiBi = noTransUpSaleWaiBi;
        return this;
    }

    public BigDecimal getHaveTransUpSaleWaiBi() {
        if(null==haveTransUpSaleWaiBi){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(haveTransUpSaleWaiBi)));
        }
//        return haveTransUpSaleWaiBi;
    }

    public UpDefMy01 setHaveTransUpSaleWaiBi(BigDecimal haveTransUpSaleWaiBi) {
        this.haveTransUpSaleWaiBi = haveTransUpSaleWaiBi;
        return this;
    }

    public String getDingJiaGuanLian() {
        return dingJiaGuanLian;
    }

    public UpDefMy01 setDingJiaGuanLian(String dingJiaGuanLian) {
        this.dingJiaGuanLian = dingJiaGuanLian;
        return this;
    }


//根据实际bil_type(没有运费是01)和priceId(销售是1,采购是2)来分配价格


    //采购的情况
    public BigDecimal getNoTransUpBuy() {
        if(p.dy(this.bilType,Cnst.buyBilTypeNoTrans)&&p.dy(this.priceId,Cnst.buyPriceId)){
            if(p.notEmpty(this.up)){
                this.noTransUpBuy=this.up;
                return this.up;
            }
        }
        if(null==noTransUpBuy){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(noTransUpBuy)));
        }
    }



    public UpDefMy01 setNoTransUpBuy(BigDecimal noTransUpBuy) {
        this.noTransUpBuy = noTransUpBuy;
        return this;
    }


    public BigDecimal getHaveTransUpBuy() {
        if(p.bdy(this.bilType,Cnst.buyBilTypeHaveTrans)&&p.dy(this.priceId,Cnst.buyPriceId)){
            if(p.notEmpty(this.up)){
                this.haveTransUpBuy=this.up;
                return this.up;
            }
        }
        if(null==haveTransUpBuy){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(haveTransUpBuy)));
        }
//        return haveTransUpBuy;
    }

    public UpDefMy01 setHaveTransUpBuy(BigDecimal haveTransUpBuy) {
        this.haveTransUpBuy = haveTransUpBuy;
        return this;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //销售的情况
    public BigDecimal getNoTransUpSale() {
        if(p.dy(this.bilType, Cnst.saleBilTypeNoTrans)&&p.dy(this.priceId,Cnst.salPriceId)){
            if(p.notEmpty(this.up)){
                this.noTransUpSale=this.up;
                return this.up;
            }

        }
        if(null==noTransUpSale){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(noTransUpSale)));
        }
//        return noTransUpSale;
    }

    public UpDefMy01 setNoTransUpSale(BigDecimal noTransUpSale) {
        this.noTransUpSale = noTransUpSale;
        return this;
    }

    public BigDecimal getHaveTransUpSale() {
        if(p.bdy(this.bilType,Cnst.saleBilTypeHaveTrans)&&p.dy(this.priceId,Cnst.salPriceId)){
            if(p.notEmpty(this.up)){
                this.haveTransUpSale=this.up;
                return this.up;
            }

        }
        if(null==haveTransUpSale){
            return null;
        }else{
            return new BigDecimal(p.del0(String.valueOf(haveTransUpSale)));
        }
//        return haveTransUpSale;
    }

    public UpDefMy01 setHaveTransUpSale(BigDecimal haveTransUpSale) {
        this.haveTransUpSale = haveTransUpSale;
        return this;
    }

    public String getRemFront() {
        return remFront;
    }

    public UpDefMy01 setRemFront(String remFront) {
        this.remFront = remFront;
        return this;
    }

    public String getRem() {
        return rem;
    }

    public UpDefMy01 setRem(String rem) {
        this.rem = rem;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UpDefMy01 setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsr() {
        return usr;
    }

    public UpDefMy01 setUsr(String usr) {
        this.usr = usr;
        return this;
    }

    public String getCusNo() {
        return cusNo;
    }

    public UpDefMy01 setCusNo(String cusNo) {
        this.cusNo = cusNo;
        return this;
    }

    public String getUnitZhu() {
        return unitZhu;
    }

    public UpDefMy01 setUnitZhu(String unitZhu) {
        this.unitZhu = unitZhu;
        return this;
    }

    public String getUnitFu() {
        return unitFu;
    }

    public UpDefMy01 setUnitFu(String unitFu) {
        this.unitFu = unitFu;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.winwin.picreport.Edto.UpDefMy01{");
        sb.append("unitZhu='").append(unitZhu).append('\'');
        sb.append(", unitFu='").append(unitFu).append('\'');
        sb.append(", usr='").append(usr).append('\'');
        sb.append(", cusNo='").append(cusNo).append('\'');
        sb.append(", rem='").append(rem).append('\'');
        sb.append(", remFront='").append(remFront).append('\'');
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", noTransUpBuy=").append(noTransUpBuy);
        sb.append(", haveTransUpBuy=").append(haveTransUpBuy);
        sb.append(", noTransUpSale=").append(noTransUpSale);
        sb.append(", haveTransUpSale=").append(haveTransUpSale);
        sb.append(", priceId='").append(priceId).append('\'');
        sb.append(", bilType='").append(bilType).append('\'');
        sb.append(", up=").append(up);
        sb.append(", remOfPrdtSampOs='").append(remOfPrdtSampOs).append('\'');
        sb.append(", sDd=").append(sDd);
        sb.append(", qty=").append(qty);
        sb.append(", unit='").append(unit).append('\'');
        sb.append(", curId='").append(curId).append('\'');
        sb.append(", curName='").append(curName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}