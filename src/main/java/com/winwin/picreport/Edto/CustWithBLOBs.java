package com.winwin.picreport.Edto;

public class CustWithBLOBs extends Cust {
    private String nmEng;

    private String adr1;

    private String adr2;

    private String adrEng;

    private String rem;

    private String workitm;

    private String mainPrd;

    private byte[] upDd;

    public String getNmEng() {
        return nmEng;
    }

    public void setNmEng(String nmEng) {
        this.nmEng = nmEng == null ? null : nmEng.trim();
    }

    public String getAdr1() {
        return adr1;
    }

    public void setAdr1(String adr1) {
        this.adr1 = adr1 == null ? null : adr1.trim();
    }

    public String getAdr2() {
        return adr2;
    }

    public void setAdr2(String adr2) {
        this.adr2 = adr2 == null ? null : adr2.trim();
    }

    public String getAdrEng() {
        return adrEng;
    }

    public void setAdrEng(String adrEng) {
        this.adrEng = adrEng == null ? null : adrEng.trim();
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    public String getWorkitm() {
        return workitm;
    }

    public void setWorkitm(String workitm) {
        this.workitm = workitm == null ? null : workitm.trim();
    }

    public String getMainPrd() {
        return mainPrd;
    }

    public void setMainPrd(String mainPrd) {
        this.mainPrd = mainPrd == null ? null : mainPrd.trim();
    }

    public byte[] getUpDd() {
        return upDd;
    }

    public void setUpDd(byte[] upDd) {
        this.upDd = upDd;
    }
}