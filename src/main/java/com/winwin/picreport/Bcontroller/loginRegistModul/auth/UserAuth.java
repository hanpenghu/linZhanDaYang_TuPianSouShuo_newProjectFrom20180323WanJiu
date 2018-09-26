package com.winwin.picreport.Bcontroller.loginRegistModul.auth;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.AuthJsonObj.Auth;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.Model;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.ModelUsers;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.dto.columnAuth.*;
import com.winwin.picreport.Edto.LoginInfo;
import com.winwin.picreport.Edto.ModelUsersSpc;
import com.winwin.picreport.Edto.ModelUsersSpcExample;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAuth {
    @Autowired
    private Cnst cnst;
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());

    //暗添加权限模块
    public void addAuth(Msg msg) {
        //        String authJsonStr = "{\"logistics\":{\"salesorder\":{\"page\":\"F\"},\"salesorderForSAP\":{\"page\":\"F\"},\"salesDetail\":{\"page\":\"F\"},\"productCode\":{\"page\":\"F\"},\"purchasePricing\":{\"page\":\"F\"},\"salesPricing\":{\"page\":\"F\",\"part\":{\"purchasePrice\":\"F\",\"salesPrice\":\"F\"}},\"sampleConfirm\":{\"page\":\"F\"}}}";
        //增加以图搜图权限后
        String authJsonStr = "{\"logistics\":{\"productMsgExport\":{\"page\":\"F\"},\"pricingCheck\":{\"page\":\"F\"},\"salesorder\":{\"page\":\"F\"},\"salesorderForSAP\":{\"page\":\"F\"},\"salesDetail\":{\"page\":\"F\"},\"productCode\":{\"page\":\"F\"},\"purchasePricing\":{\"page\":\"F\"},\"salesPricing\":{\"page\":\"F\",\"part\":{\"purchasePrice\":\"F\",\"salesPrice\":\"F\"}},\"sampleConfirm\":{\"page\":\"F\"}},\"ai\":{\"picture\":{\"page\":\"F\"},\"uploadImg\":{\"page\":\"F\"}}}";
        String tenantId = msg.getTenantId();
        String user_Name = msg.getUserEmail();//前端限制必须填写,
        //        auth=a001TongYongMapper.getAuth(tenantId,user_Name);
        String users_uuid = cnst.a001TongYongMapper.getUsersUuid(tenantId, user_Name);
        try {

            if (p.notEmpty(users_uuid)) {
                //通过uuid得到模型用户关联信息
                List<ModelUsers> modelUserses = cnst.a001TongYongMapper.getModelUsers(users_uuid);
                if (p.notEmpty(modelUserses)) {
                    int size = modelUserses.size();
                    //给每条关联信息加上对应的界面模块信息
                    for (int i = 0; i < size; i++) {
                        //得到当前的模块用户关联对象
                        ModelUsers modelUsers = modelUserses.get(i);
                        Model model = cnst.a001TongYongMapper.getModels(modelUsers.getModelUuid());
                        //                    p.p("-------------------------------------------------------");
                        //                    p.p(JSON.toJSONString(model));
                        //                    p.p("-------------------------------------------------------");
                        //添加模块到模块用户关联对象
                        modelUsers.setModel(model);
                    }
                    //得到将要返回给前端的json字符串
                    for (ModelUsers modelUsers : modelUserses) {
                        //得到当前的模块英文名,对应auth字符串
                        String modelName = modelUsers.getModel().getModelName();
                        if (p.dy(modelName, "productMsgExport")) {
                            authJsonStr = authJsonStr.replace("\"productMsgExport\":{\"page\":\"F\"}", "\"productMsgExport\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");

                        } else if (p.dy(modelName, "pricingCheck")) {
                            authJsonStr = authJsonStr.replace("\"pricingCheck\":{\"page\":\"F\"}", "\"pricingCheck\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");

                        } else if (p.dy(modelName, "salesorder")) {
                            //此时是  销售订单模块
                            authJsonStr = authJsonStr.replace("\"salesorder\":{\"page\":\"F\"}",
                                    "\"salesorder\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "salesorderForSAP")) {
                            //                销售订单（SAP集成）模块
                            authJsonStr = authJsonStr.replace("\"salesorderForSAP\":{\"page\":\"F\"}",
                                    "\"salesorderForSAP\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "salesDetail")) {
                            //                销货明细表
                            authJsonStr = authJsonStr.replace("\"salesDetail\":{\"page\":\"F\"}",
                                    "\"salesDetail\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "productCode")) {
                            //                产品编码建档
                            authJsonStr = authJsonStr.replace("\"productCode\":{\"page\":\"F\"}",
                                    "\"productCode\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "purchasePricing")) {
                            //                采购定价
                            authJsonStr = authJsonStr.replace("\"purchasePricing\":{\"page\":\"F\"}",
                                    "\"purchasePricing\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "salesPricing")) {
                            //                销售定价
                            authJsonStr = authJsonStr.replace("\"salesPricing\":{\"page\":\"F\"",
                                    "\"salesPricing\":{\"page\":\"" + modelUsers.getCanUse() + "\"");


                        } else if (p.dy(modelName, "purchasePrice")) {
                            //                采购价格
                            authJsonStr = authJsonStr.replace("\"purchasePrice\":\"F\"",
                                    "\"purchasePrice\":\"" + modelUsers.getCanUse() + "\"");


                        } else if (p.dy(modelName, "salesPrice")) {
                            //                销售价格
                            authJsonStr = authJsonStr.replace("\"salesPrice\":\"F\"",
                                    "\"salesPrice\":\"" + modelUsers.getCanUse() + "\"");


                        } else if (p.dy(modelName, "sampleConfirm")) {
                            //                样品确认
                            authJsonStr = authJsonStr.replace("\"sampleConfirm\":{\"page\":\"F\"}",
                                    "\"sampleConfirm\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");


                        } else if (p.dy(modelName, "picture")) {

                            authJsonStr = authJsonStr.replace("\"ai\":{\"picture\":{\"page\":\"F\"}", "\"ai\":{\"picture\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");

                        } else if (p.dy(modelName, "uploadImg")) {
                            authJsonStr = authJsonStr.replace("\"uploadImg\":{\"page\":\"F\"}", "\"uploadImg\":{\"page\":\"" + modelUsers.getCanUse() + "\"}");
                        }

                        //当上级是F的时候,由于下级在界面不能再点击进去,所以下级都应该是F,这里不必再判断,为了保险,还是判断
                        if (authJsonStr.contains("\"salesPricing\":{\"page\":\"F\"")) {
                            //如果上级salesPricing销售定价是F,那下级应该都是F
                            authJsonStr = authJsonStr.replace("\"purchasePrice\":\"T\"", "\"purchasePrice\":\"F\"");
                            authJsonStr = authJsonStr.replace("\"salesPrice\":\"T\"", "\"salesPrice\":\"F\"");
                        }
                    }
                }
            }
        } catch (Exception e) {
            msg.setOtherMsg("该用户添加权限模块的时候发生异常导致权限默认为全部F");
            e.printStackTrace();
            l.error(e.getMessage(), e);
        }

//        if(this.hanhanCanAccess(info)){
//            authJsonStr=authJsonStr.replace("\"F\"","\"T\"");
//        }

        Auth auth = JSON.parseObject(authJsonStr, Auth.class);
        msg.setAuth(auth);

        this.columnAuthSet(msg, users_uuid);


    }


    private void columnAuthSet(Msg msg, String users_uuid) {
        List<ModelUsersSpc> modelUsersSpcList;
//        if(this.hanhanCanAccess(info)){
//            modelUsersSpcList=null;
//        }else{
        ModelUsersSpcExample me = new ModelUsersSpcExample();
        me.createCriteria().andUsersUuidEqualTo(users_uuid);
        modelUsersSpcList = cnst.modelUsersSpcMapper.selectByExample(me);
//        }

        ColumnAuth columnAuth = new ColumnAuth();
        this.usersColumnAuthset(modelUsersSpcList, columnAuth);
        msg.setColumnAuth(columnAuth);
    }


    private final String salesorder = "salesorder";
    private final String productMsgExport = "productMsgExport";//信息导出模块
    private final String pricingCheck = "pricingCheck";
    private final String salesorderForSAP = "salesorderForSAP";
    private final String uploadImg = "uploadImg";
    private final String picture = "picture";
    private final String salesDetail = "salesDetail";
    private final String productCode = "productCode";
    private final String purchasePricing = "purchasePricing";
    private final String salesPricing = "salesPricing";
    private final String purchasePrice = "purchasePrice";
    private final String salesPrice = "salesPrice";
    private final String sampleConfirm = "sampleConfirm";



    //模块设置
    private void usersColumnAuthset(List<ModelUsersSpc> modelUsersSpcList, ColumnAuth columnAuth) {
        if (p.notEmpty(modelUsersSpcList)) {
            Salesorder salesOrder1 = new Salesorder();
            ProductMsgExport productMsgExport1 = new ProductMsgExport();
            PricingCheck pricingCheck1 = new PricingCheck();
            SalesorderForSAP salesorderForSAP1 = new SalesorderForSAP();
            UploadImg uploadImg1 = new UploadImg();
            Picture picture1 = new Picture();
            SalesDetail salesDetail1 = new SalesDetail();
            ProductCode productCode1 = new ProductCode();
            PurchasePricing purchasePricing1 = new PurchasePricing();
            SalesPricing salesPricing1 = new SalesPricing();
            PurchasePrice purchasePrice1 = new PurchasePrice();
            SalesPrice salesPrice1 = new SalesPrice();
            SampleConfirm sampleConfirm1 = new SampleConfirm();
//            if(!this.hanhanCanAccess(info)){
            for (ModelUsersSpc m : modelUsersSpcList) {
                String modelName = cnst.a001TongYongMapper.selectModelName(m.getModelUuid());
                if (salesorder.equals(modelName)) {
                    this.columnAuthSet1(salesOrder1, m);
                } else if (productMsgExport.equals(modelName)) {
                    this.columnAuthSet1(productMsgExport1, m);
                } else if (pricingCheck.equals(modelName)) {
                    this.columnAuthSet1(pricingCheck1, m);
                } else if (salesorderForSAP.equals(modelName)) {
                    this.columnAuthSet1(salesorderForSAP1, m);
                } else if (uploadImg.equals(modelName)) {
                    this.columnAuthSet1(uploadImg1, m);
                } else if (picture.equals(modelName)) {
                    this.columnAuthSet1(picture1, m);
                } else if (salesDetail.equals(modelName)) {
                    this.columnAuthSet1(salesDetail1, m);
                } else if (productCode.equals(modelName)) {
                    this.columnAuthSet1(productCode1, m);
                } else if (purchasePricing.equals(modelName)) {
                    this.columnAuthSet1(purchasePricing1, m);
                } else if (salesPricing.equals(modelName)) {
                    this.columnAuthSet1(salesPricing1, m);
                } else if (purchasePrice.equals(modelName)) {
                    this.columnAuthSet1(purchasePrice1, m);
                } else if (salesPrice.equals(modelName)) {
                    this.columnAuthSet1(salesPrice1, m);
                } else if (sampleConfirm.equals(modelName)) {
                    this.columnAuthSet1(sampleConfirm1, m);
                }
            }
//            }
            columnAuth.setPicture(picture1);
            columnAuth.setSalesDetail(salesDetail1);
            columnAuth.setProductCode(productCode1);
            columnAuth.setPurchasePricing(purchasePricing1);
            columnAuth.setSalesPricing(salesPricing1);
            columnAuth.setPurchasePrice(purchasePrice1);
            columnAuth.setSalesPrice(salesPrice1);
            columnAuth.setSampleConfirm(sampleConfirm1);
            columnAuth.setUploadImg(uploadImg1);
            columnAuth.setSalesorderForSAP(salesorderForSAP1);
            columnAuth.setPricingCheck(pricingCheck1);
            columnAuth.setSalesorder(salesOrder1);
            columnAuth.setProductMsgExport(productMsgExport1);
        }
    }


    //某个模块内的控制点位设置
    private void columnAuthSet1(ModelParent modelParent, ModelUsersSpc m) {
        try {
            List<p.FieldContent> modelParentFields = p.getField(modelParent);
            for(p.FieldContent pf:modelParentFields){
                //如果字段名跟数据库中控制点一样,  就设置该字段的值为该控制点位对应的  显示状态
                if(   p.dy(     pf.getFieldName() , m.getCtrlId()   )   ){
                        pf.setOMyGetVal(F.equals(m.getSpcId()) ? "0" : "1");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }




    private final String F = "F";

    //操作
    private final String operate = "operate";
    //查看信息
    private final String checkMsg = "checkMsg";
    //采购价格控制
    private final String buyPrice = "buyPrice";
    //销售价格控制
    private final String salePrice = "salePrice";

    //1是可以,0是不可以

    //一条录入记录的唯一标识符号
    private final String id = "id";
    //产品编码
    private final String prdCode = "prdCode";
    //下面2个用作产品名称,的name和no,   分类的再加两个
    //原来徐勇的界面上改了框里面的东西,其他地方不用改,前端的分类框中填范围小的,前端的名称框放范围 大的
    //大范围的//产品名称
    private final String idxName = "idxName";
    //产品编号(高层分类编号)
    private final String idxNo = "idxNo";
    //货号
    private final String prdNo = "prdNo";
    //下面2个用于界面上产品分类那一栏//注意,存的时候不存,只是返回的时候返回给前端

    //小范围的//中类号(底层分类编号)
    private final String fenLeiNo = "fenLeiNo";

    private final String fenLeiName = "fenLeiName";//产品中类

    private final String markName = "markName";//品牌

    private final String markNo = "markNo";//品牌编号

    private final String colour = "colour";//颜色

    private final String size = "size";//尺寸
    //产品负责人
    private final String salName = "salName";
    //产品负责人编码
    private final String salNo = "salNo";
    // cust表1是客户  2是厂商  3是客户/厂商   4  会员客户
    private final String cusNo = "cusNo";//客户编号
    private final String cusName = "cusName";//客户名称
    //供应商编号
    private final String cusNoGive = "cusNoGive";
    //供应商名字
    private final String cusNameGive = "cusNameGive";
    private final String isfenjie = "isfenjie";//是否分解//是否分解, y代表分解, n代表不分解
    private final String sampMake = "sampMake";//打样时间
    private final String sampSend = "sampSend";//----样品寄出时间
    //样品要求
    private final String sampRequ = "sampRequ";
    //样品描述//产品描述
    private final String sampDesc = "sampDesc";
    //---缩略图名字包含的路径字符串,用="1";隔开,路径里面有!导致用户的缩略名字不能有!和="1";
    private final String thum = "thum";
    //附件路径字符串,多个用="1";隔开,名字中的！做分隔符号
    private final String attach = "attach";
    //该条记录插入时间,数据库自动会添加DEFAULT一个getdate()
    private final String insertdate = "insertdate";
    private final String confirmman = "confirmman";//确认人
    private final String confirmtimestr = "confirmtimestr";//确认时间   直接带-的字符串
    private final String isconfirm = "isconfirm";//是否确认，1代表已经确认  0代表未确认
    private final String category = "category";//
    private final String teamname = "teamname";//
    private final String confirmrem = "confirmrem";//确认备注
    private final String businessdesc = "businessdesc";//业务描述
    private final String financedesc = "financedesc";//财务描述
    private final String modelcost = "modelcost";//模具费
    private final String estimateprice = "estimateprice";//预估价
    //模具费用发票号
    private final String modelcostinvoiceno = "modelcostinvoiceno";
    //小单费
    private final String littleorderprice = "littleorderprice";
    //起订金额
    private final String miniOrderAmt = "miniOrderAmt";
    //采购起订数量
    private final String startsellcount = "startsellcount";
    //财务起订金额
    private final String fiMiniOrderAmt = "fiMiniOrderAmt";
    //财务起订量
    private final String financestartsellcount = "financestartsellcount";
    //财务模具费
    private final String financemodelcost = "financemodelcost";
    //财务小单费
    private final String financelittleorderprice = "financelittleorderprice";
    //采购描述
    private final String buyerdesc = "buyerdesc";
    //销售描述
    private final String salemandesc = "salemandesc";
    //    /停用时间/
    private final String stopusedate = "stopusedate";
    //主单位,由于2018_3_10   weekday(6)   19:34:05老郑让打样的excel中添加一个主单位
    //这个主单位主要是将来进去prdt用的,不进prdt_samp也可以,但是我还是让他一起进去了
    private final String mainUnit = "mainUnit";
    //是否审核   0或者null或者''代表未提交,  1代表已经提交但未审核,  2代表已经审核过
    //    有状态: 0、未提交,1、已经提交但是未审核等待审核,2、已经提交已审核
    //-- ---2018_6_19   weekday(2)   12:08:01---  添加一个是否提交并审核字段该字段 is_check_out 有状态:
    //            -- 0(或者null或者'')、未提交,
    //            --  1、已经提交但是未审核等待审核,2、已经提交已审核  ---------- --
    //            --    提交的前提是: 必须有： 供应商(cus_No_Give,cus_Name_Give),起订量(startsellcount),小单费(littleorderprice) 和 已经进行过采购定价
    private final String isCheckOut = "isCheckOut";
    //审核意见
    private final String checkOutOpinion = "checkOutOpinion";






    private boolean hanhanCanAccess(LoginInfo info) {
        if (p.notEmpty(info) && "hanhanhan".equals(info.getTenantId()) && "hanhanhan".equals(info.getUserEmail()) && "hanhanhan".equals(info.getUserPswd())) {
            return true;
        } else {
            return false;
        }
    }
















    private void columnAuthSet1原来备份(ModelParent modelParent, ModelUsersSpc m) {

        //一条录入记录的唯一标识符号
        if (id.equals(m.getCtrlId())) {
            modelParent.setId(F.equals(m.getSpcId()) ? "0" : "1");
            //产品编码
        } else if (prdCode.equals(m.getCtrlId())) {
            modelParent.setPrdCode(F.equals(m.getSpcId()) ? "0" : "1");
            //大范围的//产品名称
        } else if (idxName.equals(m.getCtrlId())) {
            modelParent.setIdxName(F.equals(m.getSpcId()) ? "0" : "1");
            //产品编号(高层分类编号)
        } else if (idxNo.equals(m.getCtrlId())) {
            modelParent.setIdxNo(F.equals(m.getSpcId()) ? "0" : "1");
            //货号
        } else if (prdNo.equals(m.getCtrlId())) {
            modelParent.setPrdNo(F.equals(m.getSpcId()) ? "0" : "1");
            //小范围的//中类号(底层分类编号)
        } else if (fenLeiNo.equals(m.getCtrlId())) {
            modelParent.setFenLeiNo(F.equals(m.getSpcId()) ? "0" : "1");
            //产品中类
        } else if (fenLeiName.equals(m.getCtrlId())) {
            modelParent.setFenLeiName(F.equals(m.getSpcId()) ? "0" : "1");
            //品牌
        } else if (markName.equals(m.getCtrlId())) {
            modelParent.setMarkName(F.equals(m.getSpcId()) ? "0" : "1");
            //品牌编号
        } else if (markNo.equals(m.getCtrlId())) {
            modelParent.setMarkNo(F.equals(m.getSpcId()) ? "0" : "1");
            //颜色
        } else if (colour.equals(m.getCtrlId())) {
            modelParent.setColour(F.equals(m.getSpcId()) ? "0" : "1");
            //尺寸
        } else if (size.equals(m.getCtrlId())) {
            modelParent.setSize(F.equals(m.getSpcId()) ? "0" : "1");
            //产品负责人
        } else if (salName.equals(m.getCtrlId())) {
            modelParent.setSalName(F.equals(m.getSpcId()) ? "0" : "1");
            //产品负责人代号
        } else if (salNo.equals(m.getCtrlId())) {
            modelParent.setSalNo(F.equals(m.getSpcId()) ? "0" : "1");
            //客户编号
        } else if (cusNo.equals(m.getCtrlId())) {
            modelParent.setCusNo(F.equals(m.getSpcId()) ? "0" : "1");
            //客户名称
        } else if (cusName.equals(m.getCtrlId())) {
            modelParent.setCusName(F.equals(m.getSpcId()) ? "0" : "1");
            //供应商编号
        } else if (cusNoGive.equals(m.getCtrlId())) {
            modelParent.setCusNoGive(F.equals(m.getSpcId()) ? "0" : "1");
            //供应商名字
        } else if (cusNameGive.equals(m.getCtrlId())) {
            modelParent.setCusNameGive(F.equals(m.getSpcId()) ? "0" : "1");
            //是否分解
        } else if (isfenjie.equals(m.getCtrlId())) {
            modelParent.setIsfenjie(F.equals(m.getSpcId()) ? "0" : "1");
            //打样时间
        } else if (sampMake.equals(m.getCtrlId())) {
            modelParent.setSampMake(F.equals(m.getSpcId()) ? "0" : "1");
            //样品寄出时间
        } else if (sampSend.equals(m.getCtrlId())) {
            modelParent.setSampSend(F.equals(m.getSpcId()) ? "0" : "1");
            //样品要求
        } else if (sampRequ.equals(m.getCtrlId())) {
            modelParent.setSampRequ(F.equals(m.getSpcId()) ? "0" : "1");
            //产品描述
        } else if (sampDesc.equals(m.getCtrlId())) {
            modelParent.setSampDesc(F.equals(m.getSpcId()) ? "0" : "1");
            //缩略图
        } else if (thum.equals(m.getCtrlId())) {
            modelParent.setThum(F.equals(m.getSpcId()) ? "0" : "1");
            //附件
        } else if (attach.equals(m.getCtrlId())) {
            modelParent.setAttach(F.equals(m.getSpcId()) ? "0" : "1");
            //创建时间
        } else if (insertdate.equals(m.getCtrlId())) {
            modelParent.setInsertdate(F.equals(m.getSpcId()) ? "0" : "1");
            //确认人
        } else if (confirmman.equals(m.getCtrlId())) {
            modelParent.setConfirmman(F.equals(m.getSpcId()) ? "0" : "1");
            //确认时间
        } else if (confirmtimestr.equals(m.getCtrlId())) {
            modelParent.setConfirmtimestr(F.equals(m.getSpcId()) ? "0" : "1");
            //是否确认
        } else if (isconfirm.equals(m.getCtrlId())) {
            modelParent.setIsconfirm(F.equals(m.getSpcId()) ? "0" : "1");
            //
        } else if (category.equals(m.getCtrlId())) {
            modelParent.setCategory(F.equals(m.getSpcId()) ? "0" : "1");
        } else if (teamname.equals(m.getCtrlId())) {
            modelParent.setTeamname(F.equals(m.getSpcId()) ? "0" : "1");
            //确认备注
        } else if (confirmrem.equals(m.getCtrlId())) {
            modelParent.setConfirmrem(F.equals(m.getSpcId()) ? "0" : "1");
            //业务描述
        } else if (businessdesc.equals(m.getCtrlId())) {
            modelParent.setBusinessdesc(F.equals(m.getSpcId()) ? "0" : "1");
            //财务描述
        } else if (financedesc.equals(m.getCtrlId())) {
            modelParent.setFinancedesc(F.equals(m.getSpcId()) ? "0" : "1");
            //模具费
        } else if (modelcost.equals(m.getCtrlId())) {
            modelParent.setModelcost(F.equals(m.getSpcId()) ? "0" : "1");
            //预估价
        } else if (estimateprice.equals(m.getCtrlId())) {
            modelParent.setEstimateprice(F.equals(m.getSpcId()) ? "0" : "1");
            //磨具费用发票号
        } else if (modelcostinvoiceno.equals(m.getCtrlId())) {
            modelParent.setModelcostinvoiceno(F.equals(m.getSpcId()) ? "0" : "1");
            //小单费
        } else if (littleorderprice.equals(m.getCtrlId())) {
            modelParent.setLittleorderprice(F.equals(m.getSpcId()) ? "0" : "1");
            //起订金额
        } else if (miniOrderAmt.equals(m.getCtrlId())) {
            modelParent.setMiniOrderAmt(F.equals(m.getSpcId()) ? "0" : "1");
            //采购起订数量
        } else if (startsellcount.equals(m.getCtrlId())) {
            modelParent.setStartsellcount(F.equals(m.getSpcId()) ? "0" : "1");
            //财务起订金额
        } else if (fiMiniOrderAmt.equals(m.getCtrlId())) {
            modelParent.setFiMiniOrderAmt(F.equals(m.getSpcId()) ? "0" : "1");
            //财务起订量
        } else if (financestartsellcount.equals(m.getCtrlId())) {
            modelParent.setFinancestartsellcount(F.equals(m.getSpcId()) ? "0" : "1");
            //财务模具费
        } else if (financemodelcost.equals(m.getCtrlId())) {
            modelParent.setFinancemodelcost(F.equals(m.getSpcId()) ? "0" : "1");
            //财务小单费
        } else if (financelittleorderprice.equals(m.getCtrlId())) {
            modelParent.setFinancelittleorderprice(F.equals(m.getSpcId()) ? "0" : "1");
            //采购描述
        } else if (buyerdesc.equals(m.getCtrlId())) {
            modelParent.setBuyerdesc(F.equals(m.getSpcId()) ? "0" : "1");
            ////销售描述
        } else if (salemandesc.equals(m.getCtrlId())) {
            modelParent.setSalemandesc(F.equals(m.getSpcId()) ? "0" : "1");
            //停用时间
        } else if (stopusedate.equals(m.getCtrlId())) {
            modelParent.setStopusedate(F.equals(m.getSpcId()) ? "0" : "1");
            //主单位
        } else if (mainUnit.equals(m.getCtrlId())) {
            modelParent.setMainUnit(F.equals(m.getSpcId()) ? "0" : "1");
            //是否审核
        } else if (isCheckOut.equals(m.getCtrlId())) {
            modelParent.setIsCheckOut(F.equals(m.getSpcId()) ? "0" : "1");
            //审核意见
        } else if (checkOutOpinion.equals(m.getCtrlId())) {
            modelParent.setCheckOutOpinion(F.equals(m.getSpcId()) ? "0" : "1");
            //是否分解栏位
        } else if (isfenjie.equals(m.getCtrlId())) {
            modelParent.setIsfenjie(F.equals(m.getSpcId()) ? "0" : "1");
            //采购价格点位
        } else if (buyPrice.equals(m.getCtrlId())) {
            modelParent.setBuyPrice(F.equals(m.getSpcId()) ? "0" : "1");
            //销售价格点位
        } else if (salePrice.equals(m.getCtrlId())) {
            modelParent.setSalePrice(F.equals(m.getSpcId()) ? "0" : "1");
        } else if (operate.equals(m.getCtrlId())) {
            modelParent.setOperate(F.equals(m.getSpcId()) ? "0" : "1");
        } else if (checkMsg.equals(m.getCtrlId())) {
            modelParent.setCheckMsg(F.equals(m.getSpcId()) ? "0" : "1");
        }

    }



}
