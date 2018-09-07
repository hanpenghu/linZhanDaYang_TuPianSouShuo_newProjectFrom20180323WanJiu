package com.winwin.picreport.Bcontroller.Test;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Ddao.reportxmlmapper.PrdtSampMapper3;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp3;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import  java.util.Date;
/**
 * Created by Administrator on 2018/9/6.
 */



@RestController
@CrossOrigin
public class MybatisTest {

    @Autowired
    private Cnst  cnst;

    @Autowired
    private PrdtSampMapper3 prdtSampMapper3;

    @RequestMapping(value="v1",method= RequestMethod.GET)
    public void f(){


        PrdtSamp prdtSamp=new PrdtSamp();
        prdtSamp.setId("0000436d-0797-4e7b-9d8d-3ff0a30ea5c0");
        prdtSamp.setStopusedate(new Date());
        prdtSamp.setFiMiniOrderAmt(new BigDecimal("1000.0000001"));



        String sql="update prdt_samp set fi_mini_order_amt='"+String.valueOf(prdtSamp.getFiMiniOrderAmt())+"'" +
                ",prd_code='BBB', stopusedate='"+ p.dtoStr(prdtSamp.getStopusedate(),p.d16)+"' where id= '"+prdtSamp.getId()+"' ";
        cnst.a001TongYongMapper.updateTest(sql);

//        int i=cnst.a001TongYongMapper.testMybatisUpdate(new BigDecimal(-1),new Date(0),new Date(0));

//        PrdtSamp3 p3=new PrdtSamp3() ;
//        p3.setStopusedate(new Date(0));
//        p3.setMiniOrderAmt(new BigDecimal(-1));
//        p3.setId("0000436d-0797-4e7b-9d8d-3ff0a30ea5c0");
//        prdtSampMapper3.updateByPrimaryKeySelective(p3);

    }


}
