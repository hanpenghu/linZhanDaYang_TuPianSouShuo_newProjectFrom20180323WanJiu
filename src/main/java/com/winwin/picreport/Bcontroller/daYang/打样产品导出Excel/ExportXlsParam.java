package com.winwin.picreport.Bcontroller.daYang.打样产品导出Excel;

import java.util.LinkedList;
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
                '}';
    }
}
