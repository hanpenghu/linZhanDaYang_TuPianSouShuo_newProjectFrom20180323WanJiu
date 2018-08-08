package com.winwin.picreport.Cservice;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 */

@Service
public class DyDeleteOneImg {
    @Autowired
    private Cnst cnst;
    private String xg="/";


    @Transactional
    public void f(String imgUrl, List<String> msgList) {
        p.p("---------------------------imgUrl----------------------------");
        p.p(imgUrl);
        p.p("-------------------------------------------------------");
        //得到  suoLueTuWenJianJia/be1272e8-b8cc-467d-8c84-981af0a4b2af!通过域名找到IP.jpg;   这种
        String urlInDb = this.得到db存储的url(imgUrl);
        p.p("---------------------------urlInDb----------------------------");
        p.p(urlInDb);
        p.p("-------------------------------------------------------");
        String urlInDb无中括号=urlInDb;
        if(urlInDb.contains("[")){
            //老数据中的[无法是在数据库中做like处理
            urlInDb无中括号=urlInDb.substring(0,urlInDb.indexOf("["));
        }
        p.p("---------------------------urlInDb无中括号----------------------------");
        p.p(urlInDb无中括号);
        p.p("-------------------------------------------------------");
        //该url在数据库中应该是唯一的//通过该url找到该url对应的所有的attch组成的字符串
        String thumStr=cnst.manyTabSerch.selectSuoLueTuUse_urlInDb(p.bfh+urlInDb无中括号+p.bfh);
        p.p("---------------------------thumStr----------------------------");
        p.p(thumStr);
        p.p("-------------------------------------------------------");
        if(thumStr.contains(urlInDb)){
            thumStr=thumStr.replace(urlInDb,"");
            p.p("---------------------------thumStr1----------------------------");
            p.p(thumStr);
            p.p("-------------------------------------------------------");
            int k= cnst.manyTabSerch.updateThum(p.bfh+urlInDb+p.bfh,thumStr);
            if(k!=1)commonMsgthrow(msgList,"删除失败！有可能该url在数据库不唯一,检查数据库中来自老系统的url!");
        }
        String 文件绝对路径 = this.getParentAbsolutPath() + this.得到文件名字(imgUrl);
        File 要删除的thum=new File(文件绝对路径);
        if(!要删除的thum.exists()){
            //这里主要是解决原来2个人删除的时候的假象问题
//            p.throwEAddToList("该图片已经删除！",msgList);
        }else{
            boolean delete = 要删除的thum.delete();
        }

//        if(!delete) commonMsgthrow(msgList,"删除失败！图片无法删除或者根本不存在");
    }



    //得到  suoLueTuWenJianJia/be1272e8-b8cc-467d-8c84-981af0a4b2af!通过域名找到IP.jpg;   这种
    @Transactional
    public String 得到db存储的url(String attachUrl){
        String s = p.strCut(attachUrl, cnst.suoLueTuWenJianJia)+p.fh;
        return s;
    }
    @Transactional
    public String 得到文件名字(String attachUrl){
        attachUrl= attachUrl+"{~}";
        String s = p.strCutNoHead(attachUrl,cnst.suoLueTuWenJianJia,"{~}").replace("{~}","");
        return s;
    }
    @Transactional
    public void commonMsgthrow(List<String> msgList,String msgStr){
        msgList.add(msgStr);
        l.error(msgStr);
        p.throwE(msgStr);
    }


    //得到的是   daYangSuoLueTuAndFuJianZongPath/  这种
    @Transactional
    public String getZongPathBeforeNo_AndAfterHave_(){
        //得 到     ./daYangSuoLueTuAndFuJianZongPath/
        String daYangSuoLueTuAndFuJianZongPath = cnst.daYangSuoLueTuAndFuJianZongPath;
        return daYangSuoLueTuAndFuJianZongPath.substring(2).replace("/",File.separator);//从0算 包头不包尾部
    }


    //得到   suoLueTuAndFuJian/  这种
    @Transactional
    public String getAttachDirPath(){
        return  cnst.suoLueTuWenJianJia.replace("/",File.separator);
    }



    //得到  daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/这种
    @Transactional
    public String getAttachDirPathAfterHave_(){
        return (getZongPathBeforeNo_AndAfterHave_()+getAttachDirPath()).replace("/",File.separator);
    }



    //得到  全路径父目录类似  E：/xx/daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/
    //p.springBootJarPath()后面带杠
    @Transactional
    public String getParentAbsolutPath(){
        return p.springBootJarPath()+getAttachDirPathAfterHave_();
    }






    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
