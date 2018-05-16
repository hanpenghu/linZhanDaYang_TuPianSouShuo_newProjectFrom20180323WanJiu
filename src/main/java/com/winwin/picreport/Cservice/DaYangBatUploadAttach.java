package com.winwin.picreport.Cservice;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/15.
 */

@Service

public class DaYangBatUploadAttach {
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
@Autowired
private Cnst cnst;
//cnst.fuJianWenJianJia
//  suoLueTuAndFuJian/20171213141055NFL_SPR18_SIDE STATED_OTC.pdf

    @Transactional
    public void f(List<String> msgList,List<MultipartFile>multipartFileList,String idListJson) throws IOException {

        List<File> fileList=multipartFile2RealFile(multipartFileList,msgList);

        //所有图片被每个id存一遍
        List<String> idList = JSON.parseObject(idListJson, List.class);//该异常在前面已经判断过来
        for(String id:idList){
            //通过id找到当前的attach字段所有内容     suoLueTuAndFuJian/20170317143142NEC_DL17_AndreTreiner_003[1].pdf;这种
            String attach= cnst.a001TongYongMapper.selectAttachUseId(id);
            if(null==attach){msgList.add("该id《"+id+"》在表prdt_samp不存在！");p.throwE("该id《"+id+"》对应的记录在表prdt_samp不存在！");}
            AttachS attchs = getAttachS2Save(multipartFileList);

            int k=cnst.a001TongYongMapper.updateAttachById(id,attach+attchs.getToSave2Db());
            if(k!=1){msgList.add("更新id《"+id+"》的附件失败");p.throwE("更新id《"+id+"》的附件失败");}
            int ii=0;
            for(File file:fileList){
                    FileUtils.copyFile(file,new File(attchs.getToSavePathList().get(ii)));
                ii=ii+1;
            }
        }
        delFileList(fileList);
    }
    
    private List<File> multipartFile2RealFile(List<MultipartFile>multipartFileList,List<String> msgList){
        List<File>fileList=new LinkedList<File>();
        for(MultipartFile m:multipartFileList){
            File file=new File(p.springBootJarPath()+p.uuid()+m.getOriginalFilename());//直接保存在springbootjarPath下
            try {
               file.createNewFile();
                m.transferTo(file);
            } catch (IOException e) {
                this.throwE(e,msgList,"MultiFile无法实例成File");
            }
            fileList.add(file);
        }
        return fileList;
    }

    private void delFileList(List<File>fileList){
        for(File file:fileList){
            file.delete();
        }
    }




//拼接成    suoLueTuAndFuJian/20170317143142NEC_DL17_AndreTreiner_003[1].pdf;suoLueTuAndFuJian/20170317143142NEC_DL17_AndreTreiner_003[1].pdf;
   //并的到  所有的要存储的路径

    private  AttachS getAttachS2Save(List<MultipartFile>multipartFileList){
        AttachS attachS=new AttachS();
        String toSave2Db="";
        List<String>toSavePathList=new LinkedList<String>();
        for(MultipartFile m:multipartFileList){
            String newName=p.uuid()+p.egth+m.getOriginalFilename();
            //E：/xx/daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/lasdflkdasf!woCao.png   这种
            String toSavePath=getParentAbsolutPath()+newName;
            toSavePathList.add(toSavePath);
            //   suoLueTuAndFuJian/lasdflkdasf!woCao.png;suoLueTuAndFuJian/lasdflkdasf!woCao.png;   这种
            toSave2Db=toSave2Db+(getAttachDirPath()+newName)+p.fh;
        }
        attachS.setToSavePathList(toSavePathList);
        attachS.setToSave2Db(toSave2Db);
        return attachS;
    }
    
    class AttachS{
        //   suoLueTuAndFuJian/lasdflkdasf!woCao.png;suoLueTuAndFuJian/lasdflkdasf!woCao.png;   这种
        private String toSave2Db;
        //E：/xx/daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/lasdflkdasf!woCao.png   这种  的集合
        private List<String>toSavePathList;

        public String getToSave2Db() {
            return toSave2Db;
        }

        public void setToSave2Db(String toSave2Db) {
            this.toSave2Db = toSave2Db;
        }

        public List<String> getToSavePathList() {
            return toSavePathList;
        }

        public void setToSavePathList(List<String> toSavePathList) {
            this.toSavePathList = toSavePathList;
        }
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





    
    private void  throwE(Exception e,List<String> msgList,String s){
        l.error(e.getMessage(),e);
        e.printStackTrace();
        msgList.add(s);
        p.throwE(s);
    }



}



/*
    //制造所有附件的唯一名字
    List<String>attachNameList=new LinkedList<>();
        for(MultipartFile m:multipartFileList){
                //  sadlfjsd!haha.pdf
                attachNameList.add(p.uuid()+p.egth+m.getOriginalFilename());
                }

                //拼接每个id对应的一堆附件的路径
                String attachNameStringS="";
                for(String attachName:attachNameList){attachNameStringS=attachNameStringS+cnst.fuJianWenJianJia+attachName+p.fh;}

                //更新附件到数据库
                List<String> idList=JSON.parseObject(idListJson,List.class);
        for(String id:idList){
        //找到原来id的attach//    suoLueTuAndFuJian/635605899744882326.jpg;    这种
        String attach= cnst.a001TongYongMapper.selectAttachUseId(id);
        if(null==attach){msgList.add("该id《"+id+"》在表prdt_samp不存在！");p.throwE("该id《"+id+"》在表prdt_samp不存在！");}
        String attach2save=attach+attachNameStringS;
        int k=cnst.a001TongYongMapper.updateAttachById(id,attach2save);
        if(k!=1){msgList.add("更新id《"+id+"》的附件失败");p.throwE("更新id《"+id+"》的附件失败");}
        }

        //开始保存图片
        int ii=multipartFileList.size();
        for(int i=0;i<ii;i++){
        //得到当前附件
        MultipartFile m= multipartFileList.get(i);
        //得到当前附件的唯一名字
        String attachName= attachNameList.get(i);


        //得到     daYangSuoLueTuAndFuJianZongPath/suoLueTuAndFuJian/attach.pdf
        String path=(cnst.daYangSuoLueTuAndFuJianZongPath+cnst.fuJianWenJianJia+attachName).substring(2);


        //springBootJarPath后面是带杠的
        String attachPath=(p.springBootJarPath()+path);//jarPath+去掉 ./ 后的路径
        p.p("-------------------------------------------------------");
        p.p(attachPath);
        p.p("-------------------------------------------------------");
        try {
        m.transferTo(new File(attachPath));
        } catch (Exception e) {
        String s="附件保存到文件夹失败！附件路径不对";
        l.error(s,e);
        msgList.add(s);
        p.throwE(s);
        }
        }*/
