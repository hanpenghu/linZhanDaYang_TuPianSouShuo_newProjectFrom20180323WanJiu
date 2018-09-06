package com.winwin.picreport.Bcontroller.daYang.deleteOneThumAndSomeAttach;

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
public class DeleteOneImg1 {
    @Autowired
    private Cnst cnst;

    /**
     *删除单张图片接口,要求前端传过来图片全路径
     *Content-Type:application/x-www-form-urlencoded
     * ajax请求头设置为:
     * x-www-form-urlencoded
     * */

    @RequestMapping(value = InterFaceCnst.deleteOneImage,
            method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    Msg deleteOneImage
    (@RequestParam(value = Cnst.imgUrl, required = false) String imgUrl) {
        p.p("--------------------删除图片的url-----------------------------------");
        p.p(imgUrl);
        p.p("-------------------------------------------------------");
        List<String> msgList=new LinkedList<>();
        try {
            throwE(imgUrl,msgList);
            cnst.dyDeleteOneImg.f(imgUrl,msgList);
        } catch (Exception e) {
            if(msgList.contains(e.getMessage())){
                return Msg.gmg().setMsg("图片删除失败！"+e.getMessage()).setStatus("0");
            }else{
                return Msg.gmg().setMsg("图片删除失败！未知异常"+e.getMessage()).setStatus("0");
            }
        }
        return Msg.gmg().setMsg("图片删除成功").setStatus("1");
    }

    private void throwE(String attachUrl,List<String> msgList){
        if(p.empty(attachUrl)){
            commonMsgthrow(msgList,"前端穿过来的缩略图url是空的！");
        }
        if(!attachUrl.contains("http://")){
            commonMsgthrow(msgList,"前端穿过来的缩略图url格式不正确,没有http://！");
        }
        if(!attachUrl.contains(cnst.suoLueTuWenJianJia)){
            commonMsgthrow(msgList,"前端穿过来的缩略图url不属于我们系统,因为没有包含: "+cnst.suoLueTuWenJianJia+"");
        }

    }



    private void commonMsgthrow(List<String> msgList,String msgStr){
        msgList.add(msgStr);
        l.error(msgStr);
        p.throwE(msgStr);
    }



    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());



}
