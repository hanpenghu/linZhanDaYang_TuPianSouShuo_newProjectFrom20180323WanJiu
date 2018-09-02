package com.winwin.picreport;

import com.winwin.picreport.AllConstant.InterFaceCnst;

import com.winwin.picreport.Futils.hanhan.p;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@MapperScan(InterFaceCnst.daoCnst)
public class A {
//	private static  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(A.class.getName());
	//过期时间通过application配置到拦截器
	public static void main(String[] args) {
//		l.info(l);
//		l.info("--------SpringBoot kaishi jiazai---------");
		SpringApplication.run(A.class, args);
		p.Del(new File("down"));
//		l.info("-------SpringBoot jiazai wanbi---------");
	}


}
