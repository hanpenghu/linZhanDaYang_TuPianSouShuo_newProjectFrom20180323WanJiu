package com.winwin.picreport.Bcontroller.daYang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.winwin.picreport.Edto.PrdtSamp2;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;


/**
 * Created by Administrator on 2018/8/31.
 */

@RestController
@CrossOrigin
public class DyInfoUpdate001还没写好 {


    @RequestMapping(value="dyInfoUpdate001",method= RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public void f(MultipartFile[] attachs,String prdtSamp2){
        for(MultipartFile m:attachs){
            p.p("------------MultipartFile[] attachs ---li mian yuan su de chang du-------------------------------------------");
            p.p(m.getSize());
            p.p("-------------------------------------------------------");
        }
    }


    public static void main(String[]args){
        PrdtSamp2 prdtSamp2=new PrdtSamp2();
        prdtSamp2.setInsertdate(new Date());
        p.p("-------------------------------------------------------");
        p.p(JSON.parseObject("{\"insertdate\":\"2017-08-31\"}",PrdtSamp2.class));
        p.p("-------------------------------------------------------");
        prdtSamp2.setDelAttachs(Arrays.asList("http://127.0.0.1:8070/suoLueTuAndFuJian/635605893395515174.jpg","http://127.0.0.1:8070/suoLueTuAndFuJian/635605893395515174.jpg"));
        prdtSamp2.setDelThum("http://127.0.0.1:8070/suoLueTuAndFuJian/635605893395515174.jpg");
        p.p(JSON.toJSONString(prdtSamp2, SerializerFeature.WriteMapNullValue));
    }



}
