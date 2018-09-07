package com.winwin.picreport.Edto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/6.
 */
public class PrdtSamp3 extends PrdtSamp0 {

    protected Date sampMakeBj=new Date(0);//打样时间
    protected Date sampSendBj=new Date(0);//----样品寄出时间
    //    /停用时间/
    protected Date stopusedateBj=new Date(0);

    protected String confirmtimestrBj="0";//确认时间   直接带-的字符串


    protected BigDecimal startsellcountBj=new BigDecimal(-1);//采购起订数量//json可以直接转换输出给外部//起订量

    protected BigDecimal modelcostBj=new BigDecimal(-1);//模具费

    protected BigDecimal estimatepriceBj=new BigDecimal(-1);//预估价

    protected BigDecimal littleorderpriceBj=new BigDecimal(-1);//小单费
    //财务起订量
    protected BigDecimal financestartsellcountBj=new BigDecimal(-1);
    //财务模具费
    protected BigDecimal financemodelcostBj=new BigDecimal(-1);
    //财务小单费
    protected BigDecimal financelittleorderpriceBj=new BigDecimal(-1);


    //起订金额
    protected BigDecimal miniOrderAmtBj=new BigDecimal(-1);

    //财务起订金额
    protected BigDecimal fiMiniOrderAmtBj=new BigDecimal(-1);

    public Date getSampMakeBj() {
        return sampMakeBj;
    }

    public void setSampMakeBj(Date sampMakeBj) {
        this.sampMakeBj = sampMakeBj;
    }

    public Date getSampSendBj() {
        return sampSendBj;
    }

    public void setSampSendBj(Date sampSendBj) {
        this.sampSendBj = sampSendBj;
    }

    public Date getStopusedateBj() {
        return stopusedateBj;
    }

    public void setStopusedateBj(Date stopusedateBj) {
        this.stopusedateBj = stopusedateBj;
    }

    public String getConfirmtimestrBj() {
        return confirmtimestrBj;
    }

    public void setConfirmtimestrBj(String confirmtimestrBj) {
        this.confirmtimestrBj = confirmtimestrBj;
    }

    public BigDecimal getStartsellcountBj() {
        return startsellcountBj;
    }

    public void setStartsellcountBj(BigDecimal startsellcountBj) {
        this.startsellcountBj = startsellcountBj;
    }

    public BigDecimal getModelcostBj() {
        return modelcostBj;
    }

    public void setModelcostBj(BigDecimal modelcostBj) {
        this.modelcostBj = modelcostBj;
    }

    public BigDecimal getEstimatepriceBj() {
        return estimatepriceBj;
    }

    public void setEstimatepriceBj(BigDecimal estimatepriceBj) {
        this.estimatepriceBj = estimatepriceBj;
    }

    public BigDecimal getLittleorderpriceBj() {
        return littleorderpriceBj;
    }

    public void setLittleorderpriceBj(BigDecimal littleorderpriceBj) {
        this.littleorderpriceBj = littleorderpriceBj;
    }

    public BigDecimal getFinancestartsellcountBj() {
        return financestartsellcountBj;
    }

    public void setFinancestartsellcountBj(BigDecimal financestartsellcountBj) {
        this.financestartsellcountBj = financestartsellcountBj;
    }

    public BigDecimal getFinancemodelcostBj() {
        return financemodelcostBj;
    }

    public void setFinancemodelcostBj(BigDecimal financemodelcostBj) {
        this.financemodelcostBj = financemodelcostBj;
    }

    public BigDecimal getFinancelittleorderpriceBj() {
        return financelittleorderpriceBj;
    }

    public void setFinancelittleorderpriceBj(BigDecimal financelittleorderpriceBj) {
        this.financelittleorderpriceBj = financelittleorderpriceBj;
    }

    public BigDecimal getMiniOrderAmtBj() {
        return miniOrderAmtBj;
    }

    public void setMiniOrderAmtBj(BigDecimal miniOrderAmtBj) {
        this.miniOrderAmtBj = miniOrderAmtBj;
    }

    public BigDecimal getFiMiniOrderAmtBj() {
        return fiMiniOrderAmtBj;
    }

    public void setFiMiniOrderAmtBj(BigDecimal fiMiniOrderAmtBj) {
        this.fiMiniOrderAmtBj = fiMiniOrderAmtBj;
    }
}
