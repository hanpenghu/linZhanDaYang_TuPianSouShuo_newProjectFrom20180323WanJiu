package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Administrator on 2018/7/30.
 */
@Component
public class ScheduleOfdelTemp {

    @Value("${daYangSuoLueTuAndFuJianZongPath}")
    private String daYangSuoLueTuAndFuJianZongPath;

    @Scheduled(cron = "0 0 23 * * ?")
    public void delTempOfExportExcel(){
        this.delCountFile();
        this.delTempExcelExport();
    }


    //删除excel导出的临时文件
    private void delTempExcelExport(){
        try {
            String s=daYangSuoLueTuAndFuJianZongPath.replace(".","").replace("/","");
            String path=p.springBootJarPath()+s+File.separator+ Cnst.saveExcelTemp+File.separator;
            File file = new File(path);
            if(p.notExists(file))return;
            if(p.notDic(file))return;
            File[] files = file.listFiles();
            if(p.empty(files))return;
            for(File f:files){
                f.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除文件导出计数器文件
    private void delCountFile(){
        try {
           p.Del( new File("down"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
