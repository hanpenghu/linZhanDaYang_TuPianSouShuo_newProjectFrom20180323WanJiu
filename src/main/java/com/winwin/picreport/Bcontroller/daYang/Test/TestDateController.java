package com.winwin.picreport.Bcontroller.daYang.Test;

import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/9/5.
 */
@RestController
@CrossOrigin
public class TestDateController {


    @RequestMapping(value="date001",method= RequestMethod.POST)
    public @ResponseBody TestDateEntity f(@RequestBody TestDateEntity testDateEntity){
        p.p("-------------------------------------------------------");
        p.p(testDateEntity.getDate1());
        p.p(p.dtoStr(testDateEntity.getDate1(),p.d16));
        p.p("-------------------------------------------------------");
        TestDateEntity testDateEntity1=new TestDateEntity();
        return testDateEntity1.setDate1(p.tod(p.unixTimeOri,p.d16));
    }


    public static void main(String[]args){
        p.p("-------------------------------------------------------");
        p.p(p.tod(p.unixTimeOri,p.d16).getTime());
        p.p(p.tod(p.unixTimeOri,p.d16));
        p.p("-------------------------------------------------------");
    }


}
