package com.winwin.picreport.Bcontroller.daYang.savePrice.sale;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.BuyEntity;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.SaleEntity;
import com.winwin.picreport.Bcontroller.daYang.savePrice.sale.entity.SaleSave;
import com.winwin.picreport.Edto.UpDefMy01;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
@CrossOrigin
@RestController
public class SalePriceSave {
    private String n0 = "0";
    private String n1 = "1";
    private String 未知异常 = "《未知异常》";
    private String 已知异常 = "《已知异常》";
    private String 成功 = "《成功》";
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;

    //1成功  0失败
    @RequestMapping(value = "salePriceSave", method = RequestMethod.POST)
    public @ResponseBody
    Msg saveSalePrice(@RequestBody SaleSave saleSave) {
        List<String> ms = new LinkedList<String>();
        try {
            this.f判断数据合法性(saleSave, ms);
        } catch (Exception e) {
            return this.controllerIgllReturn(e,ms);
        }
        return Msg.gmg().setStatus(n1).setMsg(成功);
    }






    private Msg controllerIgllReturn(Exception e, List<String> ms) {
        if (ms.contains(e.getMessage())) {
            e.printStackTrace();
            return Msg.gmg().setStatus(n0).setMsg(e.getMessage()).setOtherMsg(已知异常);
        } else {
            e.printStackTrace();
            return Msg.gmg().setStatus(n0).setMsg(未知异常).setOtherMsg(e.getMessage());
        }
    }


    private void f判断数据合法性(SaleSave saleSave, List<String> ms) {
        List<SaleEntity> sales = saleSave.getSale();
        List<BuyEntity> buys = saleSave.getBuy();
        if (p.empty(saleSave.getUuid())) {
            p.throwEAddToList("前端传过来的uuid是空的", ms);
        }
        this.f判断销售数组是否合法(sales, ms);
        //注意采购数据可以是空的,因为有可能销售不去关联而是单独保存
        this.f判断采购数据是否合法(buys, ms);


    }

    private void f判断采购数据是否合法(List<BuyEntity> buys, List<String> ms) {
        if (p.empty(buys)) {
            p.throwEAddToList("前端传过来的采购定价数组List<SaleEntity>是空的", ms);
        }
        if (p.notEmpty(buys)) {
            for (BuyEntity s : buys) {
                if (p.empty(s.getDingJiaGuanLian())) {
                    p.throwEAddToList("前端传过来的采购定价数组里面有dingJiaGuanLian字段是空的", ms);
                }
                if (p.empty(s.getCurId())) {
                    p.throwEAddToList("前端传过来的采购定价数组里面有币别字段curId是空的", ms);
                }
                //这个肯定是空的,空的代表有运费
//            if(p.empty(s.getBilType())){
//                p.throwEAddToList("前端传过来的采购定价数组里面运费字段bilType有空的",ms);
//            }
                if (p.empty(s.getPriceId())) {
                    p.throwEAddToList("前端传过来的采购定价数组里面priceId字段有空的", ms);
                }

                //采购里面不需要这些,采购只是更新一个prm_no字段跟销售关联起来
//            if(p.empty(s.getUp())){
//                p.throwEAddToList("前端传过来的采购定价数组里面up价格字段有空的",ms);
//            }
//            if(p.empty(s.getUnit())){
//                p.throwEAddToList("前端传过来的采购定价数组里面unit单位字段有空的",ms);
//            }
            }
        }

    }

    private void f判断销售数组是否合法(List<SaleEntity> sales, List<String> ms) {
        //销售数据是要保存的,不能有空的
        if (p.empty(sales)) {
            p.throwEAddToList("前端传过来的销售定价数组List<SaleEntity>是空的", ms);
        }
        for (SaleEntity s : sales) {
            if (p.empty(s.getDingJiaGuanLian())) {
                p.throwEAddToList("前端传过来的销售定价数组里面有dingJiaGuanLian字段是空的", ms);
            }
            if (p.empty(s.getCurId())) {
                p.throwEAddToList("前端传过来的销售定价数组里面有币别字段curId是空的", ms);
            }
            if (p.empty(s.getBilType())) {
                p.throwEAddToList("前端传过来的销售定价数组里面运费字段bilType有空的", ms);
            }
            if (p.empty(s.getPriceId())) {
                p.throwEAddToList("前端传过来的销售定价数组里面priceId字段有空的", ms);
            }
            if (p.empty(s.getUp())) {
                p.throwEAddToList("前端传过来的销售定价数组里面up价格字段有空的", ms);
            }
            if (p.empty(s.getUnit())) {
                p.throwEAddToList("前端传过来的销售定价数组里面unit单位字段有空的", ms);
            }
        }
    }


}
