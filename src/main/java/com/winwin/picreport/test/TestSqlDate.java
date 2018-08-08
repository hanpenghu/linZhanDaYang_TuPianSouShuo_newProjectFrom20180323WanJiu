package com.winwin.picreport.test;

import com.winwin.picreport.Ddao.reportxmlmapper.A12;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/4.
 */
@Component
public class TestSqlDate {
@Autowired
   private A12 a12;
    @Scheduled(initialDelay = 14000,fixedDelay =Long.MAX_VALUE)//只运行一次
    public void test(){
        p.p("--------草---------------a.testDate().getSysDate()--------------------------------");
        p.p(a12.testDate().getSysDate());
        p.p(a12.testDate().getSpcTax());
        p.p(a12.testDate().getPakExc());
        p.p("------------草-------------------------------------------");
    }

}
