package com.winwin.picreport.Bcontroller.daYang;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.deleteOneAttach.DeleteOneAttachAndSomeAttach;
import com.winwin.picreport.Bcontroller.daYang.deleteOneThumAndSomeAttach.DeleteOneImg1;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Futils.ListUtils.ListUtils;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class DyInfoUpdateAndDelAttachAndPic {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Cnst cnst;

    @Autowired
    private DeleteOneImg1 deleteOneImg1;
    @Autowired
    private DeleteOneAttachAndSomeAttach deleteOneAttachAndSomeAttach;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/d/imageUpLoadAndDataSave_InfoEdit_ManyAttach002",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Msg> infoEdit_ManyAttach001(
            @RequestParam(value = Cnst.imgUrl, required = false) String imgUrl,//用来删除的图片url
            @RequestParam(value = "attachUrls", required = false) String attachUrls,//用来删除的附件集合
            @RequestParam(value = "prdtSamp", required = false) String prdtSamp,//用来删除图片
            @RequestParam(value = "thum", required = false) MultipartFile thum,//用来添加一个图片
           @RequestParam(value = "prdCodeOrg", required = false) String prdCodeOrg,
           @RequestParam(value = "attach1", required = false) MultipartFile attach1,//用来添加附件
           @RequestParam(value = "attach2", required = false) MultipartFile attach2,
           @RequestParam(value = "attach3", required = false) MultipartFile attach3,
           @RequestParam(value = "attach4", required = false) MultipartFile attach4,
           @RequestParam(value = "attach5", required = false) MultipartFile attach5,
           @RequestParam(value = "attach6", required = false) MultipartFile attach6,
           @RequestParam(value = "attach7", required = false) MultipartFile attach7,
           @RequestParam(value = "attach8", required = false) MultipartFile attach8,
           @RequestParam(value = "attach9", required = false) MultipartFile attach9,
           @RequestParam(value = "attach10", required = false) MultipartFile attach10) {
        log.info("qianDuanChuanGuoLaiYaoDeleteDeAttachUrlsShi : {}",attachUrls);
        List<String>ms=new LinkedList<String>();
        log.info("<<<<<<<<<<<<daYangXiuGaiJieKou>qianDuanChuanGuoLaiDeWenBenShi>>{}>>>>>>>>>>>>>",prdtSamp);
        List<MultipartFile> attachList =new LinkedList<MultipartFile>();new ListUtils<MultipartFile>().add(attach1,attachList).add(attach2,attachList).add(attach3,attachList).add(attach4,attachList).add(attach5,attachList).add(attach6,attachList).add(attach7,attachList).add(attach8,attachList).add(attach9,attachList).add(attach10,attachList);
        String str="";
        try {
            this.UpdateUpdateTimeSetFront(prdtSamp);
            cnst.infoEditOfManyAttach.infoEditOfManyAttach(thum,attachList,prdtSamp,ms,prdCodeOrg);

            try {
                if(p.notEmpty(imgUrl)){
                    Msg msg = deleteOneImg1.deleteOneImage(imgUrl);
                    if(p.dy(msg.getStatus(),"0")){
                        str=str+";"+msg.getMsg()+";";
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(p.notEmpty(attachUrls)){
                    List<String> attachUrls1 = JSON.parseArray(attachUrls, String.class);
                    Msg msg1= deleteOneAttachAndSomeAttach.deleteSomeAttach(attachUrls1);
                    if(p.dy(msg1.getStatus(),"0")){
                        str=str+";"+msg1.getMsg()+";";
                    }
                }
            } catch (Exception e) {e.printStackTrace();}
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:28
            cnst.genFenLeiNo.f();
        } catch (Exception e) {
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:32
            cnst.genFenLeiNo.f();
            e.printStackTrace();
            if(ms.contains(e.getMessage())){
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg(e.getMessage()+str).setOtherMsg(e.getMessage())).g();
            }else{
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg("《未知异常》"+str).setOtherMsg("《 未知异常》")).g();
            }
        }
        return new linklistT<Msg>().a(Msg.gmg().setStatus("37").setMsg("修改信息成功"+str).setOtherMsg("成功")).g();
    }

    private void UpdateUpdateTimeSetFront(String prdtSamp1) {

        try {
            PrdtSamp prdtSamp = JSON.parseObject(prdtSamp1, PrdtSamp.class);
            cnst.genFenLeiNo.upDateTimeOfPrdtSamp(prdtSamp.getId());
        } catch (Exception e) {}
    }



    public static void main(String[]args) throws UnsupportedEncodingException {
        p.p("-------------------------------------------------------");
        p.p(URLEncoder.encode("http://47.98.45.100:8070/suoLueTuAndFuJian/18-09-05 13_28_53_656 248!塔兰1.jpg","UTF-8"));
        p.p("-------------------------------------------------------");
    }
/////////////////////////////////////////////////////////////////////////
}
