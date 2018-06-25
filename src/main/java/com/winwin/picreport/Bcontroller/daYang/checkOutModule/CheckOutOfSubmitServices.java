package com.winwin.picreport.Bcontroller.daYang.checkOutModule;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 * {"id":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","cusNameGive":"高树（金坛）饰品有限公司"
 * ,"cusNoGive":"F95","startsellcount":"211",
 "sampSendStamp":"1546387200000","modelcost":null,"littleorderprice":"222"
 ,"modelcostinvoiceno":"模具费用发票号","financedesc":"财务描述"}
 *
 *
 */
@Service
public class CheckOutOfSubmitServices {

    @Autowired
    private Cnst cnst;

    //prdtSamp0是在接受前端和返回给前端的时候转化prdtSamp类型的加强版
    @Transactional
    public void f(PrdtSamp0 prdtSamp0,List<String> ms) {
        this.isStatusIllgel(prdtSamp0, ms);
        PrdtSamp prdtSamp=new PrdtSamp();
        BeanUtils.copyProperties(prdtSamp0,prdtSamp);
        prdtSamp.setSampSend(prdtSamp0.getSampSend());
        prdtSamp.setSampMake(prdtSamp0.getSampMake());
        prdtSamp.setIsCheckOut(Cnst.yiTiJiao);
        p.p("---------------------------prdtSamp----------------------------");
        p.p(prdtSamp);
        p.p("-------------------------------------------------------");
        int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp);
        if(i<1){
            p.throwEAddToList("提交失败！",ms);
        }
    }

    private void isStatusIllgel(PrdtSamp0 pp,List<String> ms) {
        PrdtSampExample prdtSampExample=new PrdtSampExample();
        prdtSampExample.createCriteria().andIdEqualTo(pp.getId()).andIsCheckOutEqualTo(Cnst.yiTiJiao);
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if(l==1){
            p.throwEAddToList("该条数据已经是《已提交》状态, 无须再提交",ms);
        }
        prdtSampExample.createCriteria().andIdEqualTo(pp.getId()).andIsCheckOutEqualTo(Cnst.yiShenHe);
        l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if(l==1){
            p.throwEAddToList("该条数据已经是《已审核》状态, 无须再提交",ms);
        }
    }

}
