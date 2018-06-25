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
    public void f(List<String> ms, CheckOutEntity checkOutEntity,Cnst cnst) {
        this.isAllReadySubmit(ms,checkOutEntity,cnst);
        PrdtSamp prdtSamp=null;
        if(p.dy("0",checkOutEntity.getIsCanPass())){
            if(null==checkOutEntity.getCheckOutOpinion()){
                checkOutEntity.setCheckOutOpinion("");
            }
            checkOutEntity.setCheckOutOpinion(checkOutEntity.getCheckOutOpinion()+"《审核未通过》");
            prdtSamp= this.f审核通过or不通过得到不同更新实体(checkOutEntity,ms,null);
        }else if(p.dy("1",checkOutEntity.getIsCanPass())){
            if(null==checkOutEntity.getCheckOutOpinion()){
                checkOutEntity.setCheckOutOpinion("");
            }
            checkOutEntity.setCheckOutOpinion(checkOutEntity.getCheckOutOpinion()+"《审核通过》");
            prdtSamp= this.f审核通过or不通过得到不同更新实体(checkOutEntity,ms,Cnst.yiShenHe);
        }else{
            p.throwEAddToList("前端穿过来的是否审核通过标记不是0也不是1",ms);
        }
        int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp);
        if(i!=1){
            p.throwEAddToList("审核更新数据库失败",ms);
        }

    }

    private PrdtSamp f审核通过or不通过得到不同更新实体(CheckOutEntity checkOutEntity, List<String> ms, String 审核状态) {
        PrdtSamp prdtSamp=new PrdtSamp();
        prdtSamp.setId(checkOutEntity.getUuid());
        prdtSamp.setIsCheckOut(审核状态);
        prdtSamp.setCheckOutOpinion(checkOutEntity.getCheckOutOpinion());
        return prdtSamp;
    }

    //不用 @Transactional
    private void isAllReadySubmit(List<String> ms,CheckOutEntity checkOutEntity, Cnst cnst) {
        PrdtSampExample prdtSampExample=new PrdtSampExample();
        prdtSampExample.createCriteria().andIdEqualTo(checkOutEntity.getUuid()).andIsCheckOutEqualTo(Cnst.yiTiJiao);
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if(l!=1){
            p.throwEAddToList("该条数据不是已提交状态,不能进行审核",ms);
        }
    }


}
