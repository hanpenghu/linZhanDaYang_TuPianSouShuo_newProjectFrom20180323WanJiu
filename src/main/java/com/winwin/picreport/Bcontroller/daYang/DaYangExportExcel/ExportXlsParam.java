package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 * {"ids"：['id1','id2','id3'],"fields":['field1','field2','field3']}
 */
public class ExportXlsParam {
    //那些id对应的需要下载
    private List<String> ids;
    //那些字段需要插入excel
    private List<String>fields;
    //确认  起始时间
    private String confirmtimestr;

    //确认  结束时间
    private String confirmtimestrEnd;

    //创建时间
    private String insertdateStr;
    private String insertdateStrEnd;
    //产品名称
    private String idxName;

    //分类名称
    private String fenLeiName;


    //产品编码
    private String prdCode;

    //负责人

    private String salName;
    //是否确认  1是确认  0是未确认
    private String isconfirm;
    //0是未提交  1是已提交未审核,  2是已审核
    private String isCheckOut;


    public String getConfirmtimestr() {
        return confirmtimestr;
    }

    public void setConfirmtimestr(String confirmtimestr) {
        this.confirmtimestr = confirmtimestr;
    }

    public String getConfirmtimestrEnd() {
        return confirmtimestrEnd;
    }

    public void setConfirmtimestrEnd(String confirmtimestrEnd) {
        this.confirmtimestrEnd = confirmtimestrEnd;
    }

    public String getInsertdateStr() {
        return insertdateStr;
    }

    public void setInsertdateStr(String insertdateStr) {
        this.insertdateStr = insertdateStr;
    }

    public String getInsertdateStrEnd() {
        return insertdateStrEnd;
    }

    public void setInsertdateStrEnd(String insertdateStrEnd) {
        this.insertdateStrEnd = insertdateStrEnd;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public String getFenLeiName() {
        return fenLeiName;
    }

    public void setFenLeiName(String fenLeiName) {
        this.fenLeiName = fenLeiName;
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public String getSalName() {
        return salName;
    }

    public void setSalName(String salName) {
        this.salName = salName;
    }

    public String getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(String isconfirm) {
        this.isconfirm = isconfirm;
    }

    public String getIsCheckOut() {
        return isCheckOut;
    }

    public void setIsCheckOut(String isCheckOut) {
        this.isCheckOut = isCheckOut;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }



}
