package com.winwin.picreport.Edto;

public class PrdtUt extends PrdtUtKey {
    private String cpySw;

    public String getCpySw() {
        return cpySw;
    }

    public void setCpySw(String cpySw) {
        this.cpySw = cpySw == null ? null : cpySw.trim();
    }
}