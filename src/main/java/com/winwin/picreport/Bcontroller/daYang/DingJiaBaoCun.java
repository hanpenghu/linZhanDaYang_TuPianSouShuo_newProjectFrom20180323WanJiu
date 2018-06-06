package com.winwin.picreport.Bcontroller.daYang;


import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.UpDefMy01;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.stra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
public class DingJiaBaoCun {

    @Autowired
    private Cnst cnst;

    /**
     *采购价格和销售价格的保存放在一个接口
     * //不含运费单价的采购价格//up_def中bil_type=01
     BigDecimal noTransUpBuy;//
     //含运费单价采购价格//up_def中bil_type!=01
     BigDecimal haveTransUpBuy;//


     //不含运费单价的销售价格//up_def中bil_type=01
     BigDecimal noTransUpSale;//
     //含运费单价销售价格//up_def中bil_type!=01
     BigDecimal haveTransUpSale;//

     上面四个字段可以区分采购和销售,
     比如当noTransUpBuy和haveTransUpBuy都为null的时候肯定是  销售的要保存
     销售 传入方式//币别徐勇来拆,运费我来拆分


     uuid是prdt_samp表中的uuid
     {"uuid":"填入给前端的唯一标识","noTransUpSale":"没有运费的销售定价",
     "haveTransUpSale":"有运费的销售定价","curId":"RMB","curName":"人民币","remFront":"客户备注"
     ,"qty":"数量","unitZhu":"","unitFu":""}


     采购传入方式//币别徐勇来拆,运费我来拆分



     uuid是prdt_samp表中的uuid
     //这个uuid是用来将来获得货号进行相关操作的,  后台的dingJiaGuanLian并没有用这个uuid
     {"uuid":"填入给前端的唯一标识","noTransUpBuy":"没有运费的采购定价",
     "haveTransUpBuy":"有运费的采购定价","curId":"RMB","curName":"人民币","remFront":"客户备注",
     "qty":"数量","unitZhu":"","unitFu":""}


     unitZhu指的是主单位

     //地址   ip地址:8070/saveSaleOrBuyPrice
     http://127.0.0.1:8070/saveSaleOrBuyPrice?token=MTUyMDQ5MDMyNDk5NXt-fWlwYWNle359MTM2NDE5Mjg3NDE=
     * */

    //传入参数,注意保存的时候是按unitZhu和unitFu传入的,
    // （但是修改的时候穿的是unit,直接是  主:  或者  副:）
    //注意参数有2中形式,一种如下面的销售价格,还有一种是采购价格的保存的,上面说的有
/*[
    {
        "uuid": "10478a3d-e981-40d6-92ee-4a07d6bb54b8",//来自prdt_samp的唯一标识
            "noTransUpSale": "100",//无运费销售价格
            "haveTransUpSale": "120",
            "curId": "RMB",
            "curName": "人民币",
            "remFront": "客户备注",
            "qty": "100",
            "unitZhu": "包"
    }
]*/
//返回结果
   /* {
        "data": null,
            "status": "49",--成功状态码--50是失败
            "xiaoHaoShiJian": "",
            "msg": "保存销售价格的成功",
            "chMsg": "",
            "otherMsg": "",
            "token": "",
            "tenantId": "",
            "tenantName": "",
            "userEmail": "",
            "notExsitThisPrdtNoInPrdtTab": "",
            "weiNengChaRuHuoZheChaRuShiBaiDeSuoYouDingDanHao": "",
            "auth": {
        "logistics": {
            "salesorder": {
                "page": "F"
            },
            "salesorderForSAP": {
                "page": "F"
            },
            "salesDetail": {
                "page": "F"
            },
            "productCode": {
                "page": "F"
            },
            "purchasePricing": {
                "page": "F"
            },
            "salesPricing": {
                "page": "F",
                        "part": {
                    "purchasePrice": "F",
                            "salesPrice": "F"
                }
            },
            "sampleConfirm": {
                "page": "F"
            }
        }
    }
    }*/

  /*  {"uuid":"填入给前端的唯一标识","noTransUpBuy":"没有运费的采购定价",
            "haveTransUpBuy":"有运费的采购定价","curId":"RMB","curName":"人民币","remFront":"客户备注",
            "qty":"数量","unitZhu":"","unitFu":""}*/
/*
  [{"uuid":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","noTransUpBuy":"12",
            "haveTransUpBuy":"13","curId":"RMB","curName":"人民币","remFront":"客户备注1",
            "qty":"100","unitZhu":"kg","unitFu":""},{"uuid":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","noTransUpBuy":"12.5",
            "haveTransUpBuy":"13.5","curId":"USD","curName":"美元","remFront":"客户备注2",
            "qty":"100","unitZhu":"kg","unitFu":""}]*/


/*
[{"uuid":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","noTransUpSale":"14",
            "haveTransUpSale":"14.5","curId":"RMB","curName":"人民币","remFront":"客户备注3",
            "qty":"1000","unitZhu":"kg","unitFu":""},{"uuid":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","noTransUpSale":"15",
            "haveTransUpSale":"15.5","curId":"USD","curName":"美元","remFront":"客户备注4",
            "qty":"1000","unitZhu":"","unitFu":"哈哈"}]*/
//    http://127.0.0.1:8070/saveSaleOrBuyPrice?token=MTUyMDQ5MDMyNDk5NXt-fWlwYWNle359MTM2NDE5Mjg3NDE=

    //保存采购和销售价格
    //保存采购的时候要供应商不要客户,保存销售的时候供应商和客户都不要
//    /saveSaleOrBuyPrice
    @RequestMapping(value= InterFaceCnst.saveSaleOrBuyPrice,method = RequestMethod.POST)
    public @ResponseBody//49成功,50失败
    Msg saveSaleOrBuyPrice(@RequestBody List<UpDefMy01> ups){//一般传过来2个,一个本币,一个外币
        List<String>msgs=new LinkedList<String>();
        try {
            //生成界面依次插入的四条记录的关联的uuid
            String uid = p.uuid();//用来跟一个字符串组合成该次定价的唯一标识, 比如4条数据一个标识
            ups.forEach(v->v.setDingJiaGuanLian(stra.b().a(Cnst.SamplesSys).a(uid).g()));
            p.p("-------------------------------！！！！！！保存价格开始！！！！！--------------------------------------");
            cnst.saveSaleOrBuyPrice.saveSaleOrBuyPrice0(ups,msgs);
        } catch (Exception e) {
            e.printStackTrace();
            if(msgs.contains(e.getMessage())){
                return Msg.gmg().setMsg(e.getMessage()).setStatus(p.s50);// 已知异常
            }else{
                return Msg.gmg().setStatus(p.s50).setMsg("《未知异常》");
            }
        }
        return Msg.gmg().setStatus(p.s49).setMsg("《保存成功》");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






































































}
