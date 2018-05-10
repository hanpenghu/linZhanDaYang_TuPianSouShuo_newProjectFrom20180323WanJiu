package com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.AuthJsonObj;

public class Auth {
  private  Logistics logistics=new Logistics();
private Ai ai=new Ai();

    public Ai getAi() {
        return ai;
    }

    public Auth setAi(Ai ai) {
        this.ai = ai;
        return this;
    }

    public Logistics getLogistics() {
        return logistics;
    }

    public Auth setLogistics(Logistics logistics) {
        this.logistics = logistics;
        return this;
    }
}
