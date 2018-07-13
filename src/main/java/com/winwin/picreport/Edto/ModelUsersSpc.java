package com.winwin.picreport.Edto;

public class ModelUsersSpc extends ModelUsersSpcKey {
    private String spcId;

    private String rem;

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId == null ? null : spcId.trim();
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }
}