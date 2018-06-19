package com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale;
import com.winwin.picreport.Bcontroller.daYang.givePriceToFront.sale.entity.UpDefStr;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */
@CrossOrigin
@RestController
public class SalePriceGetController {

    @Autowired
    private GiveSaleService giveSaleService;

    @RequestMapping(value="salePriceGet",method = RequestMethod.POST)
    public @ResponseBody Msg f(@Param("uuid")String uuid){
        List<String> ms=new LinkedList<String>();
        List<UpDefStr> upDefStrs=new LinkedList<UpDefStr>();
        try {
            this.f打印(uuid);
            this.f前端数据是否非法(uuid,ms);
            upDefStrs = giveSaleService.f(uuid, ms);
        } catch (Exception e) {
            return controllerIgllReturn(e,ms);
        }
        return Msg.gmg().setStatus(n1).setMsg(成功).setObjs(upDefStrs);
    }





    private void f前端数据是否非法(String uuid,List<String> ms) {
        if(p.empty(uuid)){
            p.throwEAddToList("前端传过来的uuid是空的",ms);
        }
    }


    private void f打印(String uuid) {
        p.p("----salePriceGet接口---------前端传过来的prdt_samp的id是uuid="+uuid+"---------------");
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


    private String n0 = "0";
    private String n1 = "1";
    private String 未知异常 = "《未知异常》";
    private String 已知异常 = "《已知异常》";
    private String 成功 = "《成功》";
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
