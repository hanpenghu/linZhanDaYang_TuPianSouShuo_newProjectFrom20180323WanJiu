package com.winwin.picreport.Bcontroller.daYang.Test;

import com.winwin.picreport.Futils.hanhan.p;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/2.
 */
public class TestDate {

    public static void f() {
        p.p("-------------------------------------------------------");
        p.p(LocalDate.now());
        p.p(LocalDateTime.now());
        p.p(LocalTime.now());
        LocalDateTime now = LocalDateTime.now();
        p.p(now.toString().replace("T", " "));
        p.p("-------------------------------------------------------");
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String text = now1.format(formatters);
        p.p(text);
        p.p("-------------------------------------------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        p.p(dateTime);
        p.p("-------------------------------------------------------");
        //2018-09-02 21:13:28.937
        String dateTime1 = LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        p.p(dateTime1);
        p.p("-------------------------------------------------------");
        System.out.println(LocalDateTime.now().toString().replace("T", " "));
        p.p(LocalDateTime.now().toString());
        p.p(LocalDateTime.now());
        p.p("-------------------------------------------------------");
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);  //2018-09-02T21:09:56.977

        p.p("---------------------------2018-09-02 21:23:28----------------------------");
        p.p(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        p.p("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        f();
    }
}
