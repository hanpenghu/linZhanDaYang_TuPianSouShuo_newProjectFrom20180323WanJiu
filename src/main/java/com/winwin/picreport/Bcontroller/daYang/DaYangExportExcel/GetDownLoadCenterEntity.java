package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

/**
 * Created by Administrator on 2018/8/14.
 */

public class GetDownLoadCenterEntity {
    private String status="0";//0是失败//1是成功
    private String url="下载失败";
    private String time="";
    private String name="";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
