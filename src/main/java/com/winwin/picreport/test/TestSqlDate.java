package com.winwin.picreport.test;

import com.winwin.picreport.AllConstant.Cnst;
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
    private Cnst cnst;

    @Scheduled(initialDelay = 14000,fixedDelay =Long.MAX_VALUE)//只运行一次
    public void test(){
        p.p("--------草---------------a.testDate().getSysDate()--------------------------------");
        if(null==cnst.a12.testDate())return;
        p.p(cnst.a12.testDate().getSysDate());
        p.p(cnst.a12.testDate().getSpcTax());
        p.p(cnst.a12.testDate().getPakExc());
        p.p("------------草-------------------------------------------");
    }

}
