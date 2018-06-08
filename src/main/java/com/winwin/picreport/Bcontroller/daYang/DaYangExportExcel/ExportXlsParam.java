package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 * {['id1','id2','id3'],['field1','field2','field3']}
 */
public class ExportXlsParam {
    //那些id对应的需要下载
    private List<String> ids;
    //那些字段需要插入excel
    private List<String>fields;
    //确认  起始时间
    private String startConfirmTime;

    //确认  结束时间
    private String endConfirmTime;


    public String getStartConfirmTime() {
        return startConfirmTime;
    }

    public void setStartConfirmTime(String startConfirmTime) {
        this.startConfirmTime = startConfirmTime;
    }

    public String getEndConfirmTime() {
        return endConfirmTime;
    }

    public void setEndConfirmTime(String endConfirmTime) {
        this.endConfirmTime = endConfirmTime;
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


    @Override
    public String toString() {
        return "ExportXlsParam{" +
                "ids=" + ids +
                ", fields=" + fields +
                ", startConfirmTime='" + startConfirmTime + '\'' +
                ", endConfirmTime='" + endConfirmTime + '\'' +
                '}';
    }
}
