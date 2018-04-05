package com.winwin.picreport.Edto;

//我的定价表

import com.winwin.picreport.Futils.NotEmpty;
import com.winwin.picreport.Futils.hanhan.p;
import java.math.BigDecimal;
public class UpDefMy01 extends UpDefMy {
    //dingJiaGuanLian最终存入up_def定价表OLEFIELD,为了让界面四种价格(含运费,不含运费,本币,外币)存入olefield的时候的关联字段
    String dingJiaGuanLian;
    String unitZhu;//主单位
    String unitFu;//副单位
    String usr;//操作员,登录的会员名
    String cusNo;
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
        if(p.dy(this.bilType,"01")&&p.dy(this.priceId,"2")){
            if(NotEmpty.notEmpty(this.up)){
                this.noTransUpBuy=this.up;
                return this.up;
            }

        }
        return noTransUpBuy;
    }

    public UpDefMy01 setNoTransUpBuy(BigDecimal noTransUpBuy) {
        this.noTransUpBuy = noTransUpBuy;
        return this;
    }


    public BigDecimal getHaveTransUpBuy() {
        if(p.bdy(this.bilType,"01")&&p.dy(this.priceId,"2")){
            if(NotEmpty.notEmpty(this.up)){
                this.haveTransUpBuy=this.up;
                return this.up;
            }
        }
        return haveTransUpBuy;
    }

    public UpDefMy01 setHaveTransUpBuy(BigDecimal haveTransUpBuy) {
        this.haveTransUpBuy = haveTransUpBuy;
        return this;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //销售的情况
    public BigDecimal getNoTransUpSale() {
        if(p.dy(this.bilType,"01")&&p.dy(this.priceId,"1")){
            if(NotEmpty.notEmpty(this.up)){
                this.noTransUpSale=this.up;
                return this.up;
            }

        }
        return noTransUpSale;
    }

    public UpDefMy01 setNoTransUpSale(BigDecimal noTransUpSale) {
        this.noTransUpSale = noTransUpSale;
        return this;
    }

    public BigDecimal getHaveTransUpSale() {
        if(p.bdy(this.bilType,"01")&&p.dy(this.priceId,"1")){
            if(NotEmpty.notEmpty(this.up)){
                this.haveTransUpSale=this.up;
                return this.up;
            }

        }
        return haveTransUpSale;
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