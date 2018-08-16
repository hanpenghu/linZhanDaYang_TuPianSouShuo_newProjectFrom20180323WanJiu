package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;

import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/14.
 */
@CrossOrigin
@RestController
public class GetDownLoadCenter {

    @Autowired
    private Cnst cnst;
    @RequestMapping(value="getDownCenter",method= RequestMethod.GET)
    public Msg f(@Param("tenantId")String tenantId,@Param("userEmail")String userEmail){
        List<String> msg=new LinkedList<String>();
        List<GetDownLoadCenterEntity> objs=new LinkedList<GetDownLoadCenterEntity> ();
        try {
            this.isIgll(tenantId,userEmail,msg);
            String s = cnst.a001TongYongMapper.selectDown(tenantId, userEmail);
            if(p.notEmpty(s)){
                List<GetDownLoadCenterEntity> list = JSON.parseArray(s, GetDownLoadCenterEntity.class);
                this.urlSet(list);
                objs.addAll(list);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if(msg.contains(message)){
                return Msg.gmg().setStatus("0").setMsg("失败!"+message);
            }else{
                return Msg.gmg().setStatus("0").setMsg("失败!未知异常！"+message);
            }
        }
        return Msg.gmg().setStatus("1").setMsg("成功！").setObjs(objs);
    }

    private void urlSet(List<GetDownLoadCenterEntity> list) {
        for(GetDownLoadCenterEntity g:list){
            //此时是文件名
            g.setName(g.getUrl());
            g.setUrl(cnst.dirUrl+Cnst.saveExcelTemp+"/"+g.getUrl());
        }

    }


//    public static void main(String[]args){
////        p.p("-------------------------------------------------------");
////        p.p(p.chaiFenZuHeFenGeFu("SampExport18-08-14-09_59_48_864-361.xls;".replace(";","{~}")));
////        p.p("-------------------------------------------------------");
//
//    }


    //最后有杠的下载路径
    private String getDownLoadPath(){
        return cnst.dirUrl+Cnst.saveExcelTemp+"/";
    }

    private void isIgll(String tenantId, String userEmail,List<String>msg) {
        if(p.empty(tenantId)||p.empty(userEmail)){
            p.throwEAddToList("前端传过来的公司id或者用户名是空的",msg);
        }
    }



}
