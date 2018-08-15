package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.winwin.picreport.AllConstant.Cnst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/14.
 */
@Component
public class ScheduleDownNull {

    @Autowired
    private Cnst cnst;

    @Scheduled(cron="0 0 23 * * ?")
    public void f(){
        try {
            int i=cnst.a001TongYongMapper.setDownNull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
