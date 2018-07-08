package com.winwin.picreport.Bcontroller.daYang.prdtSampInsertExcelManyRequestVersion;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/5/17.
 */
@CrossOrigin
@RestController
//@RequestMapping("/d")
public class DyExcel {

    @Autowired
    private Cnst cnst;

    /**
     * 上传一个包含信息的excel到数据库
     * 这个一次只能穿一个附件
     * 用于同时上传缩略图(到springboot所在项目目录下某目录)和附件(到springboot所在项目目录下某目录)
     * 和打样信息(到数据库表prdt_samp)
     * 1保存成功,
     * 0保存失败
     * <p>
     * <p>
     * <p>
     * 传输格式form-data
     * http://127.0.0.1:8070/d/dataSaveByExcel?token=MTUyMDQxNDgzMzAwNHt-fWlwYWNle359MTM2NDE5Mjg3NDE=
     * <p>
     * key     user
     * value    {"tenantId":"1","userName":"1"}
     * 外加一个
     * key  excel
     * value  具体的excel
     */

    //        /dataSaveByExcel001
    @RequestMapping(value = "dataSaveByExcel001", method = RequestMethod.POST, //客户端请求的类型
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,//接受的类型
            produces = MediaType.APPLICATION_JSON_VALUE)//返回的类型
    public @ResponseBody Msg dataSaveByExcel(@RequestParam(value = p.excel, required = false) MultipartFile excel, HttpServletRequest request) {
        List<String> msgs = new LinkedList<String>();
        try {
            this.throwE(excel,request,msgs);
            cnst.dyExcelBf.f(excel, request, msgs);
        } catch (Exception e) {
            return exceptionReturn(msgs, e);
        }
        return rightReturn(msgs);
    }




    private Msg rightReturn(List<String> msgs){
        LinkedHashSet<String>ts=new LinkedHashSet<String>();
        ts.addAll(msgs);
        String s=this.msgJoin(ts);
        if(p.notEmpty(s)){
            return Msg.gmg().setMsg("导入《成功》,"+s).setStatus("1");
        }
        return Msg.gmg().setMsg("《成功》").setStatus("1");
    }






    private String msgJoin(LinkedHashSet<String>msgs) {
        String s="";
        if(p.notEmpty(msgs)){
            for(String ss:msgs) {
                s=s+"|__|"+ss;
            }
        }
        return s;
    }


//    private String  msgs包含重复数据提示(List<String> msgs) {
//        if(p.notEmpty(msgs)){
//            for(String str:msgs){
//                if(str.contains(CC.重复编码数据_)){
//                    return str;
//                }
//            }
//        }
//        //不包含
//        return null;
//    }


    private void throwE(MultipartFile excel, HttpServletRequest request, List<String> msgs) {
        String user = request.getParameter("user");
        if (p.empty(user)) {
            String s = "前端穿过来的用户信息是空的";
            this.commonsThrow(msgs, s);
        }
        try {
            JSON.parseObject(user);
        } catch (Exception e) {
            String s = "前端管过来的用户信息不是json";
            this.commonsThrow(msgs, s);
        }
        if (p.empty(excel)) {
            this.commonsThrow(msgs, "前端没有将excel传过来");
        }
        if(!excel.getOriginalFilename().contains("xlsx")){
            this.commonsThrow(msgs, "您传过来的不是大于等于2007版的excel");
        }
    }

    private Msg exceptionReturn(List<String> msgs, Exception e) {
        if (msgs.contains(e.getMessage())) {
            return Msg.gmg().setMsg(e.getMessage()).setStatus("0").setOtherMsg(e.getMessage());
        } else {
            return Msg.gmg().setMsg("《未知异常》").setStatus("0").setOtherMsg(e.getMessage());
        }
    }

    private void commonsThrow(List<String> msgs, String message) {
        l.error(message);
        msgs.add(message);
        p.throwE(message);
    }



    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
