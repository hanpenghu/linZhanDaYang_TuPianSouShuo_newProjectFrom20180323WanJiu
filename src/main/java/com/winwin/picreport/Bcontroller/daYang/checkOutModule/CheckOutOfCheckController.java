package com.winwin.picreport.Bcontroller.daYang.checkOutModule;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/25.
 */
@RestController
@CrossOrigin
public class CheckOutOfCheckController {

    @Autowired
    private Cnst cnst;

    @Autowired
    private CheckOutOfCheckService checkOutOfCheckService;

    //将   已经提交的状态"1"  更新成已经审核的状态  "2"
    @RequestMapping(value="checkOutOfCheck",method= RequestMethod.POST)
    public @ResponseBody  Msg f(@RequestBody CheckOutEntity checkOutEntity){
        List<String> ms=new LinkedList<String>();
        try {
            this.isIllgel(checkOutEntity,ms);
            checkOutOfCheckService.f(ms,checkOutEntity,cnst);
        } catch (Exception e) {
            return controllerIgllReturn(e, ms);
        }

        return Msg.gmg().setStatus(n1).setMsg(成功);
    }






    private void isIllgel(CheckOutEntity checkOutEntity, List<String> ms) {
        if(p.empty(checkOutEntity)){
            p.throwEAddToList("前端传过来的打样审核实体checkOutEntity是空的" ,ms);
        }
        if(p.empty(checkOutEntity.getUuid())){
            p.throwEAddToList("前端传过来的打样id是空的" ,ms);
        }
        if(p.empty(checkOutEntity.getIsCanPass())){
            p.throwEAddToList("前端传过来的打样审核是否能通过标记是空的" ,ms);
        }
        if(p.bdy("0",checkOutEntity.getIsCanPass())){
            if(p.bdy("1",checkOutEntity.getIsCanPass())){
                p.throwEAddToList("前端传过来的打样审核标记必须是字符串0或者字符串1" ,ms);
            }
        }
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
