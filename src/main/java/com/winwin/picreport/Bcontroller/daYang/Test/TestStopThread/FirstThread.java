package com.winwin.picreport.Bcontroller.daYang.Test.TestStopThread;

import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Administrator on 2018/9/2.
 */

@RestController
@CrossOrigin
public class FirstThread {
    private String name="";private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="han2",method= RequestMethod.GET)
    public String f(){
        String pid="";
        new Thread(()->{
            name= UUID.randomUUID().toString();
            Thread.currentThread().setName(name);
            log.info("线程的名字是 name: {}",name);
            while (true){
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                p.p("fuck my boss ! ");
            }
        }).start();
        return "启动一个线程";
    }

    @RequestMapping(value="han3",method= RequestMethod.GET)
    public String f1(){
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        //下面2句话是获得当前所有线程
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
       for(Thread t:lstThreads){
           if(name.equals(t.getName())){
               t.stop();
               log.info("关闭了线程");
           }else{
               log.info("当前线程不是需要关闭的线程");
           }
       }
        return "关闭一个线程";
    }
}
