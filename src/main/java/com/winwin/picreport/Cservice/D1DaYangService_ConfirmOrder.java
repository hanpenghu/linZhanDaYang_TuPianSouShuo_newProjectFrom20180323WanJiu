package com.winwin.picreport.Cservice;
import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Futils.*;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("dco")
public class D1DaYangService_ConfirmOrder {
    @Autowired
    private Cnst cnst;
    public FenYe notConfirmOrderFirstPage(FenYe fenYe) {//对方传过来当前页
//        p.p("-------------------------------------------------------");
//        p.p("刚刚进入  得到当前页打样未确认的数据的类D1DaYangService_ConfirmOrder service方法notConfirmOrderFirstPage  ");
//        p.p("-------------------------------------------------------");
        fenYe.setZongJiLuShu(cnst.manyTabSerch.dangYangZongJiLuShu());
        fenYe.setZongYeShu();
        List<PrdtSamp0> prdtSampList=new ArrayList<>();
        List<String> idList = cnst.manyTabSerch.selectDangQianYeSuoYouIdNotConfirm(fenYe.getDangQianYe(), fenYe.getMeiYeXianShiShu());
//        p.p("-------得到打样未确认当前页的所有id------------------------------------------------");
//        p.p(idList);
//        p.p("-------------------------------------------------------");
        for(String id:idList){
            PrdtSamp prdtSampX1 = cnst.prdtSampMapper.selectByPrimaryKey(id);
            PrdtSamp0 prdtSampX=new PrdtSamp0();
            BeanUtils.copyProperties(prdtSampX1,prdtSampX);
            Date insertdate = prdtSampX.getInsertdate();
            try {
                String insertdateStr= new SimpleDateFormat(p.d2).format(insertdate);
                prdtSampX.setInsertdateStr(insertdateStr);
            } catch (Exception e) {
                System.out.println("有一个insertdate无法format成insertdateStr,，对应的id是："+id);
            }

            //添加价格模块//经过下一个方法,就会自动赋予一个模块
            cnst.getPriceModelUpdef20180512.getPriceModel(prdtSampX);
            prdtSampList.add(prdtSampX);
        }
//        p.p("----------打样未确认的当前页数据全部插入FenYeLei的prdtSampList完成--一下是prdtSampList----json化后的形式---------------------------------------");
//        p.p(JSON.toJSONString(prdtSampList));
//        p.p("-------------------------------------------------------");
        fenYe.setPrdtSampList(prdtSampList);
        //只要掉了setZongJiLuShu就会自动setZongYeShu
        fenYe.setZongJiLuShu(cnst.manyTabSerch.getCountOfAllNotConfirm());
//        fenYe.setZongYeShu();
        return fenYe;
    }











    /**
     *只要传过来当前页就行了//默认每页显示数10
     * */
    public FenYe alReadyConfirmOrderPage(FenYe fenYe)  {
        fenYe.setZongJiLuShu(cnst.manyTabSerch.dangYangZongJiLuShu());
        fenYe.setZongYeShu();
        List<PrdtSamp0> prdtSampList=new ArrayList<>();


        List<String> idList = cnst.manyTabSerch.selectDangQianYeSuoYouIdAlReadyConfirm
                (fenYe.getDangQianYe(), fenYe.getMeiYeXianShiShu());


        for(String id:idList){
            PrdtSamp prdtSampX1 = cnst.prdtSampMapper.selectByPrimaryKey(id);
            PrdtSamp0 prdtSampX=new PrdtSamp0();
            BeanUtils.copyProperties(prdtSampX1,prdtSampX);
            Date insertdate = prdtSampX.getInsertdate();
            try {

                String insertdateStr= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(insertdate);
                prdtSampX.setInsertdateStr(insertdateStr);

            } catch (Exception e) {
                System.out.println("有一个insertdate无法format成insertdateStr,，对应的id是："+id);
            }
            //添加价格模块//经过下一个方法,就会自动赋予一个模块
//            cnst.getPriceModelUpdef.GetPriceModel(prdtSampX);
            cnst.getPriceModelUpdef20180512.getPriceModel(prdtSampX);
            prdtSampList.add(prdtSampX);
        }
        fenYe.setPrdtSampList(prdtSampList);
        //总页数在总记录数方法中调用,以后只用调用总记录数就行了
        fenYe.setZongJiLuShu(cnst.manyTabSerch.getCountOfAllReadyConfirm());
        return fenYe;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Msg> confirmTheOrder(PrdtSamp prdtSamp) {
        try {
            if(prdtSamp==null){
                return MessageGenerate.generateMessage(
                        "确认失败","确认失败",
                        "前端传过来的json对象是null","","48");
            }
            String id = prdtSamp.getId();
            if(!p.notEmpty(id)){
                return MessageGenerate.generateMessage(
                        "确认失败","确认失败",
                        "前端传过来的id是空字符串或者是null","","48");
            }
            Integer isconfirm = prdtSamp.getIsconfirm();
            if(!NotEmpty.notEmpty(isconfirm) && isconfirm!=1){
                return MessageGenerate.generateMessage(
                        "确认失败","确认失败",
                        "确认字段isConfirm不是1","","48");
            }
            String confirmman = prdtSamp.getConfirmman();
            if(!NotEmpty.notEmpty(confirmman)){
                return MessageGenerate.generateMessage(
                        "确认失败","确认失败",
                        "没有填写确认人","","48");
            }
            String confirmtimestr = prdtSamp.getConfirmtimestr();
            if(p.empty(confirmtimestr)){
                confirmtimestr=new SimpleDateFormat(p.d1).format(cnst.manyTabSerch.getDate());
            }
            String confirmrem = prdtSamp.getConfirmrem();
            PrdtSamp f = new MakeColumnNull0False<PrdtSamp>().f(prdtSamp);
            f.setId(id);
            f.setIsconfirm(isconfirm);
            f.setConfirmman(confirmman);
            f.setConfirmtimestr(confirmtimestr);
            f.setConfirmrem(confirmrem);
            PrdtSampExample prdtSampExample=new PrdtSampExample();
            prdtSampExample.createCriteria().andIdEqualTo(id);
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(f);
            if(i==1){
                return MessageGenerate.generateMessage(
                        "确认成功","确认成功",
                        "打样确认成功","","47");
            }else{
                return MessageGenerate.generateMessage(
                        "确认失败","确认失败",
                        "打样确认失败,属于库级别错误01","","48");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MessageGenerate.generateMessage(
                "确认失败","确认失败",
                "打样确认失败,属于库级别错误02","","48");
    }






    @Transactional
    public void confirmTheOrderBatch(List<PrdtSamp> prdtSampList,List<String>ms) {
        if(p.empty(prdtSampList)){
            p.throwEAddToList("前端传过来的json数组是空的",ms);
        }
        for(PrdtSamp p:prdtSampList){
            this.confirmTheOrderBatchOfOne(p,ms);
        }
    }


    @Transactional
    public void confirmTheOrderBatchOfOne(PrdtSamp prdtSamp,List<String>ms) {
            if(prdtSamp==null){
                p.throwEAddToList("前端传过来的json对象是null",ms);
            }
            String id = prdtSamp.getId();
            if(p.empty(id)){
                p.throwEAddToList("前端传过来的id是空字符串或者是null",ms);
            }
            Integer isconfirm = prdtSamp.getIsconfirm();
            if(p.empty(isconfirm) && isconfirm!=1){
                p.throwEAddToList("确认字段isConfirm不是1",ms);
            }
            String confirmman = prdtSamp.getConfirmman();
            if(p.empty(confirmman)){
                p.throwEAddToList("没有填写确认人",ms);
            }
            String confirmtimestr = prdtSamp.getConfirmtimestr();
            if(p.empty(confirmtimestr)){
                confirmtimestr=new SimpleDateFormat(p.d1).format(cnst.manyTabSerch.getDate());
            }
            String confirmrem = prdtSamp.getConfirmrem();
            PrdtSamp f = new MakeColumnNull0False<PrdtSamp>().f(prdtSamp);
            f.setId(id);
            f.setIsconfirm(isconfirm);
            f.setConfirmman(confirmman);
            f.setConfirmtimestr(confirmtimestr);
            f.setConfirmrem(confirmrem);
            PrdtSampExample prdtSampExample=new PrdtSampExample();
            prdtSampExample.createCriteria().andIdEqualTo(id);
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(f);
            if(i!=1){
                p.throwEAddToList("打样确认失败,属于库级别错误01",ms);
            }

    }






















//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public FenYe daYangZongYeShuHeMeiYeXianShiShu() {
        FenYe fenYe=new FenYe();
        fenYe.setZongJiLuShu(cnst.manyTabSerch.dangYangZongJiLuShu());
        fenYe.setZongYeShu();
        return fenYe;
    }


}
