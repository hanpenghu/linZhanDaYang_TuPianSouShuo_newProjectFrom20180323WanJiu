package com.winwin.picreport.Bcontroller.daYang;
import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Futils.ListUtils.ListUtils;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/d")
public class DyInfoUpdate {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Cnst cnst;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *用这个进行  信息编辑
     *
     * //我这里原来是37成功,其他的是失败
     * */

    //    @Transactional
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "imageUpLoadAndDataSave_InfoEdit_ManyAttach",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Msg> infoEdit_ManyAttach(@RequestParam(value = "thum", required = false) MultipartFile thum,
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
                        HttpServletRequest request) {
        List<String>ms=new LinkedList<String>( );
        String prdtSamp1 = request.getParameter("prdtSamp");//文本信息
        this.UpdateUpdateTimeSetFront(prdtSamp1);
        List<MultipartFile> attachList =new LinkedList<MultipartFile>();new ListUtils<MultipartFile>().add(attach1,attachList).add(attach2,attachList).add(attach3,attachList).add(attach4,attachList).add(attach5,attachList).add(attach6,attachList).add(attach7,attachList).add(attach8,attachList).add(attach9,attachList).add(attach10,attachList);
        try {
            cnst.infoEditOfManyAttach.infoEditOfManyAttach(thum,attachList,prdtSamp1,ms,"yuan");
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:28
            cnst.genFenLeiNo.f();
        } catch (Exception e) {
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:28
            cnst.genFenLeiNo.f();
            e.printStackTrace();
            if(ms.contains(e.getMessage())){
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg(e.getMessage()).setOtherMsg(e.getMessage())).g();
            }else{
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg("《未知异常》").setOtherMsg("《未知异常》")).g();
            }
        }

        return new linklistT<Msg>().a(Msg.gmg().setStatus("37").setMsg("成功").setOtherMsg("成功")).g();
    }





    @SuppressWarnings("unchecked")
    @RequestMapping(value = "imageUpLoadAndDataSave_InfoEdit_ManyAttach001",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Msg> infoEdit_ManyAttach001(@RequestParam(value = "thum", required = false) MultipartFile thum,
                                                       @RequestParam(value = "prdCodeOrg", required = false) String prdCodeOrg,
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
                                                       HttpServletRequest request) {
        List<String>ms=new LinkedList<String>();
        String prdtSamp1 = request.getParameter("prdtSamp");//文本信息
        log.info("<<<<<<<<<<<<<<<<daYangXiuGaiJieKou>qianDuanChuanGuoLaiDeWenBenShi>>{}>>>>>>>>>>>>>",prdtSamp1);
        List<MultipartFile> attachList =new LinkedList<MultipartFile>();new ListUtils<MultipartFile>().add(attach1,attachList).add(attach2,attachList).add(attach3,attachList).add(attach4,attachList).add(attach5,attachList).add(attach6,attachList).add(attach7,attachList).add(attach8,attachList).add(attach9,attachList).add(attach10,attachList);
        try {
            this.UpdateUpdateTimeSetFront(prdtSamp1);
            cnst.infoEditOfManyAttach.infoEditOfManyAttach(thum,attachList,prdtSamp1,ms,prdCodeOrg);
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:28
            cnst.genFenLeiNo.f();
        } catch (Exception e) {
            //弥补分类编号在prdt_samp 和prdt里面不产生的过错 2018_9_4   weekday(2)   12:47:32
            cnst.genFenLeiNo.f();
            if(ms.contains(e.getMessage())){
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg(e.getMessage()).setOtherMsg(e.getMessage())).g();
            }else{
                return new linklistT<Msg>().a(Msg.gmg().setStatus("0").setMsg("《未知异常》").setOtherMsg("《未知异常》")).g();
            }
        }
        return new linklistT<Msg>().a(Msg.gmg().setStatus("37").setMsg("成功").setOtherMsg("成功")).g();
    }

    private void UpdateUpdateTimeSetFront(String prdtSamp1) {

        try {
            PrdtSamp prdtSamp = JSON.parseObject(prdtSamp1, PrdtSamp.class);
            cnst.genFenLeiNo.upDateTimeOfPrdtSamp(prdtSamp.getId());
        } catch (Exception e) {}
    }

/////////////////////////////////////////////////////////////////////////
}
