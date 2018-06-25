package com.winwin.picreport.Bcontroller.daYang.checkOutModule;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25.
 */
@Service
public class CheckOutOfCheckService {
    @Transactional
    public void f(List<String> ms, String uuid,Cnst cnst) {
        //判断是否是已经提交的状态
        this.isAllReadySubmit(ms,uuid,cnst);
        PrdtSamp prdtSamp=new PrdtSamp();
        prdtSamp.setId(uuid);
        prdtSamp.setIsCheckOut(Cnst.yiShenHe);
        int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp);
        if(i!=1){
            p.throwEAddToList("审核更新数据库失败",ms);
        }

    }

    //不用 @Transactional
    private void isAllReadySubmit(List<String> ms, String uuid, Cnst cnst) {
        PrdtSampExample prdtSampExample=new PrdtSampExample();
        prdtSampExample.createCriteria().andIdEqualTo(uuid).andIsCheckOutEqualTo(Cnst.yiTiJiao);
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if(l!=1){
            p.throwEAddToList("该条数据不是已提交状态,不能进行审核",ms);
        }
    }


}
