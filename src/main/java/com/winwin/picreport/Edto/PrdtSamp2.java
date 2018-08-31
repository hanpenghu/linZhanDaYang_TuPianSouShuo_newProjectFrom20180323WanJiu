package com.winwin.picreport.Edto;

import java.util.List;

/**
 * Created by winston on 2018/8/31.
 * 用于打样更新数据的第二种接口
 */
public class PrdtSamp2 extends PrdtSamp {
    //要删除的图片url全长度
    private String delThum;
    //要删除的附件访问url的全长度
    private List<String> delAttachs;

    public String getDelThum() {
        return delThum;
    }

    public void setDelThum(String delThum) {
        this.delThum = delThum;
    }

    public List<String> getDelAttachs() {
        return delAttachs;
    }

    public void setDelAttachs(List<String> delAttachs) {
        this.delAttachs = delAttachs;
    }
}
