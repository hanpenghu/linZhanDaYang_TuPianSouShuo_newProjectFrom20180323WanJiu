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
public class DyDeleteOneAttach {
    @Autowired
    private Cnst cnst;
    private String xg="/";

    //   //"http://127.0.0.1:8070/suoLueTuWenJianJia/be1272e8-b8cc-467d-8c84-981af0a4b2af!通过域名找到IP.jpg"
    @Transactional
    public void f(String attachUrl,List<String> msgList){
        //得到  suoLueTuWenJianJia/be1272e8-b8cc-467d-8c84-981af0a4b2af!通过域名找到IP.jpg;   这种
        String urlInDb = 得到db存储的url(attachUrl);
        //该url在数据库中应该是唯一的//通过该url找到该url对应的所有的attch组成的字符串
        String attachsStr=cnst.manyTabSerch.selectAttachsUse_urlInDb(p.bfh+urlInDb+p.bfh);

        attachsStr=attachsStr.replace(urlInDb,"");

       int k= cnst.manyTabSerch.updateAttach(p.bfh+urlInDb+p.bfh,attachsStr);
       if(k!=1)commonMsgthrow(msgList,"删除失败！有可能该url在数据库不唯一,检查数据库中来自老系统的url!");

        String 文件绝对路径 = getParentAbsolutPath() + 得到文件名字(attachUrl);

        boolean delete = new File(文件绝对路径).delete();
        if(!delete) commonMsgthrow(msgList,"删除失败！附件无法删除");


    }





    //得到  suoLueTuWenJianJia/be1272e8-b8cc-467d-8c84-981af0a4b2af!通过域名找到IP.jpg;   这种
    @Transactional
    private String 得到db存储的url(String attachUrl){
        String s = p.strCut(attachUrl, cnst.fuJianWenJianJia)+p.fh;
        return s;
    }

    private String 得到文件名字(String attachUrl){
        attachUrl= attachUrl+"{~}";
        String s = p.strCutNoHead(attachUrl,cnst.fuJianWenJianJia,"{~}").replace("{~}","");
        return s;
    }

    private void commonMsgthrow(List<String> msgList,String msgStr){
        msgList.add(msgStr);
        l.error(msgStr);
        p.throwE(msgStr);
    }


    //得到的是   daYangSuoLueTuAndFuJianZongPath/  这种
    private String getZongPathBeforeNo_AndAfterHave_(){
        //得 到     ./daYangSuoLueTuAndFuJianZongPath/
        String daYangSuoLueTuAndFuJianZongPath = cnst.daYangSuoLueTuAndFuJianZongPath;
        return daYangSuoLueTuAndFuJianZongPath.substring(2).replace("/",File.separator);//从0算 包头不包尾部
    }


    //得到   suoLueTuAndFuJian/  这种
    private String getAttachDirPath(){
        return  cnst.fuJianWenJianJia.replace("/",File.separator);
    }



    //得到  daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/这种
    private String getAttachDirPathAfterHave_(){
        return (getZongPathBeforeNo_AndAfterHave_()+getAttachDirPath()).replace("/",File.separator);
    }



    //得到  全路径父目录类似  E：/xx/daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/
    //p.springBootJarPath()后面带杠
    private String getParentAbsolutPath(){
        return p.springBootJarPath()+getAttachDirPathAfterHave_();
    }






    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
