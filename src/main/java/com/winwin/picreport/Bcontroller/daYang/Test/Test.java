package com.winwin.picreport.Bcontroller.daYang.Test;

import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/17.
 */
@CrossOrigin
@RestController
public class Test {

    @RequestMapping(value="/123",method = RequestMethod.GET)
    public void f() throws IOException {
        File file = new File("111");
        file.mkdir();
        p.p("--------------------------file.getAbsolutePath()-----------------------------");
        p.p(file.getAbsolutePath());//   E:\1\000\LinZhan\111
        p.p("-------------------------------------------------------");


        File filetxt = new File("111.txt");
        filetxt.createNewFile();
        p.p("-------------------------------------------------------");
        p.p(filetxt.getAbsolutePath());
        p.p("-------------------------------------------------------");
    }


}
