package com.winwin.picreport.Edto;

public class PrdtUtKey {
    private String utId;

    private String ut;

    public String getUtId() {
        return utId;
    }

    public void setUtId(String utId) {
        this.utId = utId == null ? null : utId.trim();
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut == null ? null : ut.trim();
    }
}