package com.winwin.picreport.Bcontroller.daYang.Test;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */
@RestController
@CrossOrigin
public class LaoZhengShengChengPrdtNo {
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;

    /**
     * 把prdt_samp里面符合以下条件的生成货号
     *select * from  prdt_samp where tenant_id='88' and fen_lei_no is not NULL and (prd_no is NULL or prd_no='')
     * */
    @RequestMapping(value="/schh001",method= RequestMethod.GET)
    public String f1(){
        p.p("-------------------------------------------------------");
        p.p("开始更新货号");
        p.p("-------------------------------------------------------");
        PrdtSampExample pp=new PrdtSampExample();
        pp.createCriteria().andTenantIdEqualTo("88").andFenLeiNoIsNotNull().andPrdNoIsNull().andFenLeiNoNotEqualTo("");
        List<PrdtSamp> prdtSamps = cnst.prdtSampMapper.selectByExample(pp);

        PrdtSampExample ppp=new PrdtSampExample();
        ppp.createCriteria().andTenantIdEqualTo("88").andFenLeiNoIsNotNull().andPrdNoEqualTo("").andFenLeiNoNotEqualTo("");
        List<PrdtSamp> prdtSamps1 = cnst.prdtSampMapper.selectByExample(ppp);

        prdtSamps.addAll(prdtSamps1);


        int i=0;
        for(PrdtSamp pppp:prdtSamps){
            if(p.notEmpty(pppp.getPrdNo())){
                continue;
            }
            if(p.empty(pppp.getFenLeiNo())){
                continue;
            }

            PrdtSamp0 prdtSamp0=new PrdtSamp0();
            BeanUtils.copyProperties(pppp,prdtSamp0);
            cnst.gPrdNo.prdtSampObjGetPrdNo(prdtSamp0);

            PrdtSamp prdtSamp=new PrdtSamp();
            prdtSamp.setId(prdtSamp0.getId());
            prdtSamp.setPrdNo(prdtSamp0.getPrdNo());
            cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp);

            i=i+1;
        }



        return "-----------------共"+prdtSamps.size()+"个---------流水成功"+i+"个-----------------------------";
    }






    //  schh  就是生成货号的意思
    @RequestMapping(value="/schh",method= RequestMethod.GET)
    public String f(){
        p.p("-------------------------------------------------------");
        p.p("开始处理2000个货号开始");
        p.p("-------------------------------------------------------");
        PrdtSampExample pe=new PrdtSampExample();
        pe.createCriteria().andTenantIdEqualTo("0713");
        List<PrdtSamp> prdtSampList = cnst.prdtSampMapper.selectByExample(pe);
        int i=0;
        for(PrdtSamp pp:prdtSampList){
            try {
                if(p.empty(pp.getPrdNo())&&p.notEmpty(pp.getId())){
                    PrdtSamp0 p0=new PrdtSamp0();
                    BeanUtils.copyProperties(pp,p0);
                    cnst.gPrdNo.prdtSampObjGetPrdNo(p0);

                    PrdtSamp ppp=new PrdtSamp();
                    ppp.setPrdNo(p0.getPrdNo());
                    ppp.setId(p0.getId());
                    cnst.prdtSampMapper.updateByPrimaryKeySelective(ppp);
                }
            } catch (Exception e) {
                i=i+1;
                e.printStackTrace();
                l.error("--------生成货号有问题:prdCode=《"+pp.getPrdCode()+"》 ------------");

            }

        }

        p.p("-----------------共"+prdtSampList.size()+"个--------------------------------------");
        p.p("开始处理2000个货号完成");
        p.p("---------------------共有"+i+"个异常没流水成功----------------------------------");


        return "-----------------共"+prdtSampList.size()+"个---------共有"+i+"个异常没流水成功-----------------------------";


    }

}
