package com.winwin.picreport.Bcontroller.daYang.Test;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Administrator on 2018/5/17.
 */
@CrossOrigin
@RestController
public class Test {

    @Autowired
    private Cnst cnst;

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

    @RequestMapping(value="/fuck",method = RequestMethod.GET)
    public String fuck()  {

        for(int i=0;i<100;i++){
            try {
                p.p("                                                                                     ");
                PrdtSamp pp=new PrdtSamp();
                pp.setId(p.uuid());
                pp.setPrdCode(p.uuid().substring(0,13)+"ADMIN");
                pp.setMainUnit("F");
                pp.setSampDesc("F_F");
                int i1 = cnst.prdtSampMapper.insertSelective(pp);
            } catch (Exception e) {}
        }
        return "插入prdtSamp100个完成";
    }


}
