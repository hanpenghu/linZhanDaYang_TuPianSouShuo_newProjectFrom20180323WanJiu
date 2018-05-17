package com.winwin.picreport.Bcontroller.daYang.样品确认模块里的批量确认批量上传附件;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/15.
 */


@CrossOrigin
@RestController
public class DaYangAttachBatUpLoad {
    @Autowired
    private Cnst cnst;
    /**
     * 样品确认模块
     *样品模块的  批上传附件,根据id批上传
     * ["id1","id2","id3".....]
     * 注意一个id就要对应所有一堆的attach
     * */
    @RequestMapping(value= InterFaceCnst.batUpLoadAttach)
    public Msg piLiangShangChuanFuJian_yangPinQueRenMoKuai(
            @RequestParam(value = "attach1", required = false) MultipartFile attach1,
            @RequestParam(value = "attach2", required = false) MultipartFile attach2,
            @RequestParam(value = "attach3", required = false) MultipartFile attach3,
            @RequestParam(value = "attach4", required = false) MultipartFile attach4,
            @RequestParam(value = "attach5", required = false) MultipartFile attach5,
            @RequestParam(value = "attach6", required = false) MultipartFile attach6,
            @RequestParam(value = "attach7", required = false) MultipartFile attach7,
            @RequestParam(value = "attach8", required = false) MultipartFile attach8,
            @RequestParam(value = "attach9", required = false) MultipartFile attach9,
            @RequestParam(value = "attach10", required = false) MultipartFile attach10,
            HttpServletRequest request
    ){

        List<String> msgList=new LinkedList<String>();
        List<MultipartFile>multipartFileList=new LinkedList<MultipartFile>();
        try {
            if(null!=attach1) multipartFileList.add(attach1);if(null!=attach2)multipartFileList.add(attach2);if(null!=attach3)multipartFileList.add(attach3);if(null!=attach4)multipartFileList.add(attach4);if(null!=attach5)multipartFileList.add(attach5);if(null!=attach6)multipartFileList.add(attach6);if(null!=attach7)multipartFileList.add(attach7);if(null!=attach8)multipartFileList.add(attach8);if(null!=attach9)multipartFileList.add(attach9);if(null!=attach10)multipartFileList.add(attach10);

            String idListJson= request.getParameter("idListJson");
            //已知异常模块
            throwE(msgList, multipartFileList,idListJson);

            cnst.daYangBatUploadAttach.f(msgList,multipartFileList,idListJson);

        } catch (Exception e) {
            if(msgList.contains(e.getMessage())){
                return Msg.gmg().setStatus("0").setMsg(e.getMessage());
            }else{
                return Msg.gmg().setStatus("0").setMsg("《未知异常》");
            }
        }
        return Msg.gmg().setStatus("1").setMsg("《成功》");
    }








    private void throwE(List<String> msgList, List<MultipartFile>multipartFileList,String idListJson){
        if(p.empty(multipartFileList)){
            msgList.add("《失败！您没有选择任何附件》");
            p.throwE("《失败！您没有选择任何附件》");
        }



        if(p.empty(idListJson)){
            msgList.add("《失败！前端穿过来没有传过来唯一标识符: 某条数据的唯一id》");
            p.throwE("《失败！前端穿过来没有传过来唯一标识符: 某条数据的唯一id》");
        }
        List<String> idList=null;
        try {
            idList= JSON.parseObject(idListJson,List.class);
        } catch (Exception e) {
            msgList.add("《失败！前端传过来的JOSN字符串无法格式化成类,请前端检查他的JSON格式》");
            p.throwE("《失败！前端传过来的JOSN字符串无法格式化成类,请前端检查他的JSON格式》");
        }
        if(p.empty(idList)){
            msgList.add("《失败！前端传过来的id列表是空》");
            p.throwE("《失败！前端传过来的id列表是空》");
        }
        for(String s:idList){
            if(p.empty(s)){
                msgList.add("《失败！前端传过来的id有空的》");
                p.throwE("《失败！前端传过来的id有空的》");
            }
        }
        for(MultipartFile m:multipartFileList){
            if(m.getName().contains("!")){
                msgList.add("《附件名称中不能包含  !  》");
                p.throwE("《附件名称中不能包含  !  》");
            }
            if(m.getName().contains(";")){
                msgList.add("《附件名称中不能包含  ;  》");
                p.throwE("《附件名称中不能包含  ;  》");
            }
        }
    }
}
