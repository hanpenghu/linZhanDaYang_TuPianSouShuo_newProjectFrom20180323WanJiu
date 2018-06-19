package com.winwin.picreport.Bcontroller.daYang.checkOutModule;

import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 */
@Service
public class CheckOutOfSubmitServices {
    //prdtSamp0是在接受前端和返回给前端的时候转化prdtSamp类型的加强版
    public void f(PrdtSamp0 prdtSamp0,List<String> ms) {
        PrdtSamp prdtSamp=new PrdtSamp();
        BeanUtils.copyProperties(prdtSamp0,prdtSamp);

    }

}
