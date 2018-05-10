package com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.AuthJsonObj;

public class Ai {
    private Picture picture=new Picture();
    private UpLoadImg uploadImg=new UpLoadImg();

    public UpLoadImg getUploadImg() {
        return uploadImg;
    }

    public Ai setUploadImg(UpLoadImg uploadImg) {
        this.uploadImg = uploadImg;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public Ai setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
