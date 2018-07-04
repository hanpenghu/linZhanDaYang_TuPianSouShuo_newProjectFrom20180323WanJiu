package com.winwin.picreport.Bcontroller.daYang;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
@RestController
@CrossOrigin
public class ConfirmOfCancel {
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;


    @RequestMapping(value="confirmOfCancel",method= RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public @ResponseBody  Msg f(@RequestBody List<String>idList){
        List<String>msg=new LinkedList<String>();
        try {
            this.isIllgel(idList,msg);
            this.f取消确认信息(idList,msg);
        } catch (Exception e) {
            e.printStackTrace();
            String s = e.getMessage();
            if(msg.contains(s)){
                return Msg.gmg().setStatus("0").setMsg("失败, "+s);
            }else{
                return Msg.gmg().setStatus("0").setMsg("失败, "+"未知异常");
            }
        }
        return Msg.gmg().setStatus("1").setMsg("成功");
    }

    @Transactional
    public void f取消确认信息(List<String>idList,List<String> msg) {
        for(String id:idList){
            PrdtSamp pp=new PrdtSamp();
            pp.setId(id);pp.setIsconfirm(0);pp.setConfirmtimestr("");pp.setConfirmman("");pp.setConfirmrem("");
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(pp);
            if(i!=1){
                p.throwEAddToList("id《"+id+"》取消确认失败,导致一个都没有取消确认,请联系程序员",msg);
            }
        }

    }

    private void isIllgel(List<String> idList,List<String>msg) {
        if(p.empty(idList)){
            p.throwEAddToList("前端穿过来的id数组是空的",msg);
        }
        for(String id:idList){
            if(p.notEmpty(id)){
                p.throwEAddToList("前端穿过来的id有空的",msg);
            }
            PrdtSampExample pp=new PrdtSampExample();
            pp.createCriteria().andIdEqualTo(id);
            long l = cnst.prdtSampMapper.countByExample(pp);
            if(l==0){
                p.throwEAddToList("前端穿过来的id《"+id+"》在数据库不存在",msg);
            }
            if(l>1){
                p.throwEAddToList("前端穿过来的id《"+id+"》在数据库不唯一,请报告程序员13641928741",msg);
            }
        }

    }



}
