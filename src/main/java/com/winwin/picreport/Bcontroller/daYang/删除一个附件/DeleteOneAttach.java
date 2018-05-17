package com.winwin.picreport.Bcontroller.daYang.删除一个附件;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 */

@CrossOrigin
@RestController
@RequestMapping("/d")
public class DeleteOneAttach {

    @Autowired
    private Cnst cnst;

    @RequestMapping(value = InterFaceCnst.deleteOneAttach,
            method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    Msg deleteOneAttach(@RequestParam(value = "attachUrl", required = false)String attachUrl) {
        List<String> msgList=new LinkedList<>();
        try {
            throwE(attachUrl,msgList);
            cnst.dyDeleteOneAttach.f(attachUrl,msgList);
        } catch (Exception e) {
            if(msgList.contains(e.getMessage())){
                return Msg.gmg().setMsg("删除失败！").setStatus("0");
            }else{
                return Msg.gmg().setMsg("删除失败！未知异常").setStatus("0");
            }
        }
        return Msg.gmg().setMsg("删除成功").setStatus("1");
    }

    private void throwE(String attachUrl,List<String> msgList){
        if(p.empty(attachUrl)){
            commonMsgthrow(msgList,"前端穿过来的附件url是空的！");
        }
        if(!attachUrl.contains("http://")){
            commonMsgthrow(msgList,"前端穿过来的附件url格式不正确,没有http://！");
        }
        if(!attachUrl.contains(cnst.fuJianWenJianJia)){
            commonMsgthrow(msgList,"前端穿过来的附件url不属于我们系统,因为没有包含: "+cnst.fuJianWenJianJia+"");
        }

    }



    private void commonMsgthrow(List<String> msgList,String msgStr){
        msgList.add(msgStr);
        l.error(msgStr);
        p.throwE(msgStr);
    }



    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
