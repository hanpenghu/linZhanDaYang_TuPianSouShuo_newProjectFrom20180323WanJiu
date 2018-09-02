package com.winwin.picreport.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/2.
 */

@RestController
@CrossOrigin
//@Slf4j
public class TestLog4j {
    private  Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="han1",method= RequestMethod.GET)
    public  void f(){
        try {
            log.info("han1测试开始","fuck");
            int i=1;int j=0;int k=i/j;
            log.info("han1测试结束");
        } catch (Exception e) {
            log.error("han1出错",e);
        }
    }

}
