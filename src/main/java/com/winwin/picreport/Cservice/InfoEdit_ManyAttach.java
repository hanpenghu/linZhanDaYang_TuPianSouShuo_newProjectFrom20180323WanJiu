package com.winwin.picreport.Cservice;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.Constant.msgCnst;
import com.winwin.picreport.AllConstant.StatusCnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.*;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("infoEditOfManyAttach")
public class InfoEdit_ManyAttach {
    @Autowired
    private Cnst cnst;
    @Transactional
    public void infoEditOfManyAttach(MultipartFile thum, List<MultipartFile> attachList,String prdtSamp1, List<String> ms) throws Exception {
//        synchronized (this) {
        String uuid = p.timeAndRandom0_999NoHead_1();//给新的图片和缩略图的名字用,更新的时候并没有用这个uuid ,用的还是原来的
        String projectPath = SpringbootJarPath.JarLuJingGet();
        this.f图片名字不能有四种非法字符(thum, ms);
        p.p("----------------------111---------------------------------");
        PrdtSamp0 prdtSampOb = null;
        if (prdtSamp1 != null && !"".equals(prdtSamp1)) {
            prdtSampOb = JSON.parseObject(prdtSamp1, PrdtSamp0.class);
        }
        p.p("---------------------------222----------------------------");
        this.prdtSampOb是否非法(prdtSampOb,ms);
        p.p("---------------------------333----------------------------");
        //得到这个prdtSamp只为了得到当前主键下面的缩略图路径thum字段和附件字段attach
        PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(prdtSampOb.getId());
        p.p("-----------------------prdtSamp--------------------------------");
        p.p(prdtSamp);
        p.p("-------------------------------------------------------");
        if (prdtSamp == null) {p.throwEAddToList("您穿过来的主键id在数据库冇存在",ms);}
        p.p("---------------------------444--prdtSamp.getPrdNo()----"+prdtSamp.getPrdNo()+"----------------------");
        if(p.empty(prdtSamp.getPrdNo())){this.f流水货号(prdtSampOb,ms);}
        p.p("---------------------------555----------------------------");
        this.f保存单张图片(prdtSamp,thum,projectPath,uuid,prdtSampOb,ms);
        this.f保存多个附件(attachList,prdtSampOb,projectPath,ms);
    }

    @Transactional
    private void f流水货号(PrdtSamp prdtSamp,List<String>ms) {
        p.p("-------------f给pp装上货号---111--------"+prdtSamp.getPrdNo()+"-------------------------------");
        this.f给pp装上货号(prdtSamp,ms);
        p.p("-----------------f给pp装上货号-----222------"+prdtSamp.getPrdNo()+"---------------------------------------");
        if(p.notEmpty(prdtSamp.getPrdNo())){
            cnst.a001TongYongMapper.updatePrdNoByUuid(prdtSamp.getId(),prdtSamp.getPrdNo());
        }
        p.p("-----------------f给pp装上货号-----333------"+prdtSamp.getPrdNo()+"---------------------------------------");
    }

    @Transactional
    private void f给pp装上货号(PrdtSamp pp,List<String>msgs) {
//        this.f根据name找no不推荐用(pp,msgs);
        PrdtSamp0 p0=new PrdtSamp0();
        BeanUtils.copyProperties(pp,p0);
        //给当前的prdtSamp流水一个货号
            /*if(p.empty(p0.getFenLeiNo())){
                p.throwEAddToList("中类编号fenLeiNo为空,无法流水",msgs);
            }*/
        p.p("----------流水货号开始---fenleino="+pp.getFenLeiNo()+"----------------------");
        cnst.gPrdNo.prdtSampObjGetPrdNo(p0);
        p.p("----------流水货号结束---prdNo="+pp.getPrdNo()+"----------------------");

        p.p("==============="+p0.getPrdNo()+"================");
        if(p.empty(p0.getPrdNo())){
            String s="产品编码为：《" +p0.getPrdCode() +"》对应的产品中类《" +p0.getFenLeiName()+"》不存在,请手动录入该中类";
            p.throwEAddToList(s,msgs);
        }
        pp.setPrdNo(p0.getPrdNo());
    }


    @Transactional
    private void f根据name找no不推荐用(PrdtSamp pp,List<String>msgs) {
        String fenLeiNo = cnst.a001TongYongMapper.getIdxNoFromIdxName(pp.getFenLeiName());
        if(p.notEmpty(fenLeiNo)) {
            pp.setFenLeiNo(fenLeiNo);
        }else{
            String s="产品编码为：《" +pp.getPrdCode() +"》对应的产品中类《" +pp.getFenLeiName()+"》不存在,请手动录入该中类！";
            p.throwEAddToList(s,msgs);
        }

    }

    @Transactional
    public void f保存单张图片(PrdtSamp prdtSamp, MultipartFile thum, String projectPath, String uuid, PrdtSamp0 prdtSampOb, List<String> ms) throws IOException {
        String imageThumUrl = prdtSamp.getThum();
        if (thum != null&&thum.getSize()>0) {
            String s = projectPath + cnst.daYangSuoLueTuAndFuJianZongPath.replace(".", "") + cnst.suoLueTuWenJianJia+uuid+"!"+thum.getOriginalFilename();
            thum.transferTo(new File(s));
            if (!new File(s).exists()) {p.throwEAddToList("缩略图没有保存成功导致所有数据没保存",ms);}
            if (imageThumUrl == null) {imageThumUrl = "";}
            imageThumUrl = imageThumUrl+cnst.suoLueTuWenJianJia+uuid+"!"+thum.getOriginalFilename()+";";
        }
        if ("".equals(imageThumUrl)) {
            //为了是null的时候不更新这个字段
            imageThumUrl = null;
        }
        prdtSampOb.setThum(imageThumUrl);
//        prdtSampOb.setAttach(attachmentUrl);//在这里不再更新附件,因为附件有多个,放在最后单独更新
        prdtSampOb = this.prdtSampWhereSpaceToNull(prdtSampOb);//把""变成null,避免不必要的更新
        prdtSampOb.setIsconfirm(null);
        prdtSampOb.setIsCheckOut(Cnst.weiTiJiao);
        //Selective是不更新null
        cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSampOb);
    }


    @Transactional
    public void f保存多个附件(List<MultipartFile> attachList, PrdtSamp0 prdtSampOb, String projectPath, List<String> ms) throws IOException {
        for (MultipartFile attach : attachList) {
            PrdtSamp0 prdtSampO = new PrdtSamp0();
            //得到这个prdtSamp只为了得到当前主键下面的缩略图路径thum字段和附件字段attach
            PrdtSamp prdtsa = cnst.prdtSampMapper.selectByPrimaryKey(prdtSampOb.getId());
            String attachmentUr = prdtsa.getAttach();
            String uid =p.sj();
            ////////////////////////////////////////////////for开始/////////////////////////////////////////////////////
            this.f附件不能包含四种符号(attach,ms);
            String s1 = projectPath + cnst.daYangSuoLueTuAndFuJianZongPath.replace(".", "") + cnst.fuJianWenJianJia;
            if (attach != null) {
                String ss = uid + Cnst.ganTanHao + attach.getOriginalFilename();
                //将附件保存在指定的目录
                attach.transferTo(new File(s1, ss));
                if (!new File(s1,ss).exists()) {p.throwEAddToList("附件没有保存成功导致所有数据没保存！",ms);}
                if (attachmentUr == null) {attachmentUr = "";}//第一次没上传任何东西可能是空
                attachmentUr = attachmentUr + cnst.fuJianWenJianJia + uid + "!" + attach.getOriginalFilename() + ";";
            }
            if ("".equals(attachmentUr)) {
                //为了是null的时候不更新这个字段
                attachmentUr = null;
            }
            prdtSampO.setId(prdtSampOb.getId());
            //只更新附件
            prdtSampO.setAttach(attachmentUr);//在这里不再更新附件,因为附件有多个,放在最后单独更新
            prdtSampO = this.prdtSampWhereSpaceToNull(prdtSampO);//把""变成null,避免不必要的更新
            prdtSampO.setIsconfirm(null);//不更新这个
            //Selective是不更新null
            cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSampO);
            //更新商品主库的停用时间
            this.f更新商品主库的停用时间(prdtSampO);
            if (attach != null && !new File(s1, uid + "!" + attach.getOriginalFilename()).exists()) {
                p.throwEAddToList("附件没有保存成功导致所有数据没保存",ms);
            }
        }
    }


    @Transactional
    public void f更新商品主库的停用时间(PrdtSamp0 prdtSampO) {
        Date stopusedate = prdtSampO.getStopusedate();
        String prdNo = cnst.manyTabSerch.getPrdNoFromPrdtSamp(prdtSampO.getId());
        PrdtWithBLOBs prdt = new PrdtWithBLOBs();
        prdt.setPrdNo(prdNo);
        prdt.setNouseDd(stopusedate);
        if (p.notEmpty(prdNo)) {
            if (stopusedate == null) {
                p.p("前端传过来的停用时间是null");
            } else {
                //selective的意思就是null的不更新
                Integer i = cnst.a001TongYongMapper.updatePrdtNouseDd(prdNo, p.dtoStr(stopusedate));
            }

        } else {
            System.out.println("prdNo是空的,无法更新prdt的停用时间");
        }
    }

    @Transactional
    public void f附件不能包含四种符号(MultipartFile attach,List<String>ms) {
        boolean b1=attach != null;
        boolean b2=attach.getOriginalFilename().contains(Cnst.ganTanHao);
        boolean b3=attach.getOriginalFilename().contains(Cnst.fenHao);
        boolean b4=attach.getOriginalFilename().contains("[");
        boolean b5=attach.getOriginalFilename().contains("]");
        if (b1 && (b2 || b3 || b4 || b5)) {
            p.throwEAddToList("您的附件不能包含有以下四种符号    !    ;   [    ]  ", ms);
        }
    }

    @Transactional
    public void f图片名字不能有四种非法字符(MultipartFile thum, List<String> ms) {
        boolean b1=thum != null;
        if(b1) {
            boolean b2=thum.getOriginalFilename().contains(Cnst.ganTanHao);
            boolean b3=thum.getOriginalFilename().contains(Cnst.fenHao);
            boolean b4=thum.getOriginalFilename().contains("[");
            boolean b5=thum.getOriginalFilename().contains("]");
            if (b2 || b3 || b4 || b5) {
                p.throwEAddToList("您的图片不能包含有以下四种符号    !    ;   [    ] ", ms);
            }
        }

    }
    @Transactional
    public void prdtSampOb是否非法(PrdtSamp0 prdtSampOb,List<String>ms) {
        if (p.notEmpty(prdtSampOb)) {
            if (p.empty(prdtSampOb.getId())) {
                p.throwEAddToList("前端没有传输过来唯一标志id",ms);
            }
        } else {
            p.throwEAddToList("前后端传输错误,prdtSamp这个参数后端接收不到",ms);
        }

    }




//        return MessageGenerate.generateMessage("保存失败", "保存失败", "附件没有保存成功导致所有数据没保存！", "", "36");
//    }

    @Transactional
    public PrdtSamp0 prdtSampWhereSpaceToNull(PrdtSamp0 prdtSamp) {
        if ("".equals(prdtSamp.getPrdCode())) {
            prdtSamp.setPrdCode(null);
        }
        if ("".equals(prdtSamp.getIdxName())) {
            prdtSamp.setIdxName(null);
        }//
        if ("".equals(prdtSamp.getIdxNo())) {
            prdtSamp.setIdxNo(null);
        }//
        if ("".equals(prdtSamp.getMarkName())) {
            prdtSamp.setMarkName(null);
        }//
        if ("".equals(prdtSamp.getMarkNo())) {
            prdtSamp.setMarkNo(null);
        }//
        if ("".equals(prdtSamp.getColour())) {
            prdtSamp.setColour(null);
        }//
        if ("".equals(prdtSamp.getSize())) {
            prdtSamp.setSize(null);
        }//
        if ("".equals(prdtSamp.getSalName())) {
            prdtSamp.setSalName(null);
        }//
        if ("".equals(prdtSamp.getSalNo())) {
            prdtSamp.setSalNo(null);
        }//
        if ("".equals(prdtSamp.getCusNo())) {
            prdtSamp.setCusNo(null);
        }//
        if ("".equals(prdtSamp.getCusName())) {
            prdtSamp.setCusName(null);
        }//
        if ("".equals(prdtSamp.getIsfenjie())) {
            prdtSamp.setIsfenjie(null);
        }//
        if ("".equals(prdtSamp.getSampMakeStamp())) {
            prdtSamp.setSampMakeStamp(null);
        }//
        if ("".equals(prdtSamp.getSampSendStamp())) {
            prdtSamp.setSampSendStamp(null);
        }//

        //这2个空的就是空的
     /*   if ("".equals(prdtSamp.getSampRequ())) {
            prdtSamp.setSampRequ(null);
        }//
        if ("".equals(prdtSamp.getSampDesc())) {
            prdtSamp.setSampDesc(null);
        }//*/
        if ("".equals(prdtSamp.getThum())) {
            prdtSamp.setThum(null);
        }//
        if ("".equals(prdtSamp.getAttach())) {
            prdtSamp.setAttach(null);
        }//

        if (prdtSamp.getSampSend() != null) {
            String format1 = new SimpleDateFormat("yyyy-MM-dd").format(prdtSamp.getSampSend());

            if (p.isFirstDateBig_(p.hanhanBirthday_, format1)) {
                prdtSamp.setSampSend(null);
            }

        }


        if (prdtSamp.getSampMake() != null) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(prdtSamp.getSampMake());
            if (p.isFirstDateBig_(p.hanhanBirthday_, format)) {
                prdtSamp.setSampMake(null);
            }
        }


        return prdtSamp;

    }


    private List<Msg> isIgll(PrdtSamp0 prdtSamp0) {
        if (p.empty(prdtSamp0)) {
            return MessageGenerate.generateMessage("保存失败", "保存失败",
                    "前端传过来的参数是空的", "", "39");
        }
        if (p.empty(prdtSamp0.getId())) {

            return MessageGenerate.generateMessage("保存失败", "保存失败",
                    "前端传过来的id是空的", "", "39");
        }
        /*if(p.empty(prdtSamp0.getStartsellcount())){
            return MessageGenerate.generateMessage("保存失败", "保存失败",
                    "前端传过来的起订量startsellcount是空的", "", "39");
        }
        if(p.empty(prdtSamp0.getLittleorderprice())){
            return MessageGenerate.generateMessage("保存失败", "保存失败",
                    "前端传过来的小单费littleorderprice是空的", "", "39");
        }*/
        /*if (p.empty(prdtSamp0.getCusNoGive()) || p.empty(prdtSamp0.getCusNameGive())) {
            if (this.供应商No在prdtSamp是空(prdtSamp0)||this.供应商Name在prdtSamp是空(prdtSamp0)){
                return MessageGenerate.generateMessage("保存失败", "保存失败",
                        "前端传过来的供应商no和name是空,数据库也是空", "", "39");
            }
        }*/

        /*if(!this.isAllReadyHaveBuyPrice(prdtSamp0)){
            return MessageGenerate.generateMessage("保存失败", "保存失败",
                    "该商品还没有采购定价", "", "39");
        }*/

        return null;
    }

    //是否已经采购定价
    private boolean isAllReadyHaveBuyPrice(PrdtSamp0 prdtSamp0) {
        PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(prdtSamp0.getId());
        UpDefExample upDefExample = new UpDefExample();
        upDefExample.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo()).andPriceIdEqualTo(Cnst.buyPriceId).andUpIsNotNull().andOlefieldLike("%" + Cnst.SamplesSys + "%");
        long l = cnst.upDefMapper.countByExample(upDefExample);
        if (l > 0) {
            //已经进行过采购定价
            return true;
        } else {
            return false;
        }

    }


    private boolean 供应商Name在prdtSamp是空(PrdtSamp0 prdtSamp0) {
        PrdtSampExample prdtSampExample = new PrdtSampExample();
        prdtSampExample.createCriteria().andCusNameGiveIsNull().andIdEqualTo(prdtSamp0.getId());
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        prdtSampExample.createCriteria().andCusNameGiveEqualTo("").andIdEqualTo(prdtSamp0.getId());
        long ll = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if (l > 0 || ll > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean 供应商No在prdtSamp是空(PrdtSamp0 prdtSamp0) {
        PrdtSampExample prdtSampExample = new PrdtSampExample();
        prdtSampExample.createCriteria().andCusNoGiveIsNull().andIdEqualTo(prdtSamp0.getId());
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        prdtSampExample.createCriteria().andCusNoGiveEqualTo("").andIdEqualTo(prdtSamp0.getId());
        long ll = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if (l > 0 || ll > 0) {
            return true;
        } else {
            return false;
        }
    }


//    @Test
//    public void  f(){
//        String format1 = new SimpleDateFormat("yyyy-MM-dd").
//                format(new Date());
//
//        p.p(format1);
//
//    }





    //    @Value("${daYangSuoLueTuAndFuJianZongPath}")//./1234567/
//    private String daYangSuoLueTuAndFuJianZongPath;
//
//    @Value("${suoLueTuWenJianJia}")
//    private String suoLueTuWenJianJia;
//
//    @Value("${fuJianWenJianJia}")
//    private String fuJianWenJianJia;
}
