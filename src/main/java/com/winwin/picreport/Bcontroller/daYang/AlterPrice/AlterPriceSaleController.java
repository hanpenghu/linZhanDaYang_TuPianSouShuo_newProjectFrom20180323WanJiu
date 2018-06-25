package com.winwin.picreport.Bcontroller.daYang.AlterPrice;
import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */


@CrossOrigin
@RestController
public class AlterPriceSaleController {
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    @Autowired
    private  Cnst cnst;
    @RequestMapping(value= Cnst.dingJiaXiuGaiSale,method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    Msg dingJiaXiuGaiSale(@RequestBody AlterPriceObj AlterPriceObj){
        //错误信息注册列表
        List<String> msgs= new LinkedList<String>();
        this.f打印刚传过来的对象(AlterPriceObj);
        this.isIgll(msgs,AlterPriceObj);
        try {
            cnst.dingJiaXiuGaiSaleService.dingJiaXiuGai(AlterPriceObj,msgs);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            //看msg是否在注册列表里面
            if(msgs.contains(e.getMessage())){
                return Msg.gmg().setMsg("定价修改失败").setChMsg(e.getMessage()).setStatus("0");
            }else{
                return Msg.gmg().setMsg("未知异常导致定价修改失败").setChMsg("未知异常").setStatus("0");
            }
        }
        return Msg.gmg().setMsg("定价修改成功").setStatus("1");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private void isIgll(List<String> msgs,AlterPriceObj AlterPriceObj) {
        String s="定价修改失败,前端传过来的是空数组或者null";
        if(p.empty(AlterPriceObj)){
            p.throwEAddToList(s,msgs);
        }

    }

    private void f打印刚传过来的对象(AlterPriceObj alterPriceObj) {
        p.p("--------定价修改,前端传过来的东西-----------------------------------------------");
        p.p(JSON.toJSONString(alterPriceObj));
        p.p("-------------------------------------------------------");
    }




}


/*

{

        "alterPrices":
        [{"dingJiaGuanLian":"SamplesSys180622082408146-56","bilType":"2","curIdAfter":"RMB","curIdBefore":"RMB","dingJiaZhuJian":"","prdNo":"15448214","prdtCode":"WW-NEFL-WW2876",
        "prdtSampUuid":"fedab9c4-7463-4ad5-9f64-8dd71e919c43","qtyAfter":"9,999.000","qtyBefore":"9,999.000","remFrontAfter":"han1测试",
        "saleOrBuy":"sale","tenantId":"ipace","unitAfter":"主:roll","unitBefore":"副:","upAfter":"12441","userName":"hanpenghu"},





        {"dingJiaGuanLian":"SamplesSys180622082408146-56","bilType":"2","curIdAfter":"USD","curIdBefore":"USD","dingJiaZhuJian":"","prdNo":"15448214","prdtCode":"WW-NEFL-WW2876",
        "prdtSampUuid":"fedab9c4-7463-4ad5-9f64-8dd71e919c43","qtyAfter":"9,999.000","qtyBefore":"9,999.000","remFrontAfter":"han1测试",
        "saleOrBuy":"sale","tenantId":"ipace","unitAfter":"主:roll","unitBefore":"副:","upAfter":"126","userName":"hanpenghu"},

        {"dingJiaGuanLian":"SamplesSys180622082408146-56","bilType":"1","curIdAfter":"USD","curIdBefore":"USD","dingJiaZhuJian":"","prdNo":"15448214","prdtCode":"WW-NEFL-WW2876",
        "prdtSampUuid":"fedab9c4-7463-4ad5-9f64-8dd71e919c43","qtyAfter":"9,999.000","qtyBefore":"9,999.000","remFrontAfter":"han1测试",
        "saleOrBuy":"sale","tenantId":"ipace","unitAfter":"主:roll","unitBefore":"副:","upAfter":"1255","userName":"hanpenghu"},





        {"dingJiaGuanLian":"SamplesSys180622082408146-56","bilType":"1","curIdAfter":"RMB","curIdBefore":"RMB","dingJiaZhuJian":"","prdNo":"15448214","prdtCode":"WW-NEFL-WW2876",
        "prdtSampUuid":"fedab9c4-7463-4ad5-9f64-8dd71e919c43","qtyAfter":"9,999.000","qtyBefore":"9,999.000","remFrontAfter":"han1测试",
        "saleOrBuy":"sale","tenantId":"ipace","unitAfter":"主:roll","unitBefore":"副:","upAfter":"12331","userName":"hanpenghu"}],





        "buyPriceUnionIds":[{"bilType":"1","curId":"RMB","dingJiaGuanLian":"SamplesSys2018-05-05 17:41:34","priceId":"2","uuid":"fedab9c4-7463-4ad5-9f64-8dd71e919c43"}]

        }*/
