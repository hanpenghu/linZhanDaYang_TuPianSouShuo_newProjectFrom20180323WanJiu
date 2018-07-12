package com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.columnAuth;

/**
 * Created by Administrator on 2018/7/9.
 */
public class ColumnAuth {
    private Picture picture = new Picture();
    private PricingCheck pricingCheck = new PricingCheck();
    private ProductCode productCode = new ProductCode();
    private ProductMsgExport productMsgExport = new ProductMsgExport();
    private PurchasePrice purchasePrice = new PurchasePrice();
    private PurchasePricing purchasePricing = new PurchasePricing();
    private SalesDetail salesDetail = new SalesDetail();
    private Salesorder salesorder = new Salesorder();
    private SalesorderForSAP salesorderForSAP = new SalesorderForSAP();
    private SalesPrice salesPrice = new SalesPrice();
    private SalesPricing salesPricing = new SalesPricing();
    private SampleConfirm sampleConfirm = new SampleConfirm();
    private UploadImg uploadImg = new UploadImg();

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public PricingCheck getPricingCheck() {
        return pricingCheck;
    }

    public void setPricingCheck(PricingCheck pricingCheck) {
        this.pricingCheck = pricingCheck;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }

    public ProductMsgExport getProductMsgExport() {
        return productMsgExport;
    }

    public void setProductMsgExport(ProductMsgExport productMsgExport) {
        this.productMsgExport = productMsgExport;
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(PurchasePrice purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public PurchasePricing getPurchasePricing() {
        return purchasePricing;
    }

    public void setPurchasePricing(PurchasePricing purchasePricing) {
        this.purchasePricing = purchasePricing;
    }

    public SalesDetail getSalesDetail() {
        return salesDetail;
    }

    public void setSalesDetail(SalesDetail salesDetail) {
        this.salesDetail = salesDetail;
    }

    public Salesorder getSalesorder() {
        return salesorder;
    }

    public void setSalesorder(Salesorder salesorder) {
        this.salesorder = salesorder;
    }

    public SalesorderForSAP getSalesorderForSAP() {
        return salesorderForSAP;
    }

    public void setSalesorderForSAP(SalesorderForSAP salesorderForSAP) {
        this.salesorderForSAP = salesorderForSAP;
    }

    public SalesPrice getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(SalesPrice salesPrice) {
        this.salesPrice = salesPrice;
    }

    public SalesPricing getSalesPricing() {
        return salesPricing;
    }

    public void setSalesPricing(SalesPricing salesPricing) {
        this.salesPricing = salesPricing;
    }

    public SampleConfirm getSampleConfirm() {
        return sampleConfirm;
    }

    public void setSampleConfirm(SampleConfirm sampleConfirm) {
        this.sampleConfirm = sampleConfirm;
    }

    public UploadImg getUploadImg() {
        return uploadImg;
    }

    public void setUploadImg(UploadImg uploadImg) {
        this.uploadImg = uploadImg;
    }
}
