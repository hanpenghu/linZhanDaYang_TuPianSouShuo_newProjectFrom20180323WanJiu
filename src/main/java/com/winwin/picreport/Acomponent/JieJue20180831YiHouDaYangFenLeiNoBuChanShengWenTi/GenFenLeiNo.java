package com.winwin.picreport.Acomponent.JieJue20180831YiHouDaYangFenLeiNoBuChanShengWenTi;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtExample;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtWithBLOBs;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 * 2018_8_31   weekday(5)   21:03:32
 */

@Component
public class GenFenLeiNo {//2018_8_31   weekday(5)   21:03:36
    @Autowired
    private Cnst cnst;
    /**
     *对31号以后的prdt_smap 里面fen_lei_no没有产生(对应prdt里面的idx1没有产生)
     * 的情况重新产生一遍
     * */
    public void f(){
        List<PrdtSamp> prdtSamps = cnst.a001TongYongMapper.getAllNoFenLeiNo();
        p.p("---------------GenFenLeiNo.f de dao de prdtSamp----------------------------------------");
        p.p(prdtSamps==null?null:prdtSamps.size());
        p.p("-------------------------------------------------------");
        if(p.empty(prdtSamps))return;
        p.p("--------------------GenFenLeiNo1-----------------------------------");
        for(PrdtSamp ps:prdtSamps){
            p.p("----------------------GenFenLeiNo2--------ps.getFenLeiName()="+ps.getFenLeiName()+"-------------------------");
            String fenLeiNo = cnst.a001TongYongMapper.getFenLeiNoUseFenLeiName(ps.getFenLeiName());
            p.p("-------------------------GenFenLeiNo3------------------------------");
            if(p.empty(fenLeiNo)){
                p.p("-------------------------GenFenLeiNo4------------------------------");
                continue;
            }
            p.p("-------------------------GenFenLeiNo5------------------------------");
            if(p.empty(ps.getFenLeiNo())){
                p.p("-------------------------GenFenLeiNo6------------------------------");
                PrdtSamp p1=new PrdtSamp();p1.setId(ps.getId());p1.setFenLeiNo(fenLeiNo);
                p.p("-------------------------GenFenLeiNo7------------------------------");
                cnst.prdtSampMapper.updateByPrimaryKeySelective(p1);
                p.p("-------------------------GenFenLeiNo8------------------------------");
            }

            p.p("-------------------------GenFenLeiNo9------------------------------");
            PrdtExample pe=new PrdtExample();
            pe.createCriteria().andPrdNoEqualTo(ps.getPrdNo()).andNameEqualTo(ps.getPrdCode()).andIdx1IsNull();
            long l = cnst.prdtMapper.countByExample(pe);
            p.p("-------------------------GenFenLeiNo10------------------------------");

            PrdtExample pe1=new PrdtExample();
            pe1.createCriteria().andPrdNoEqualTo(ps.getPrdNo()).andNameEqualTo(ps.getPrdCode()).andIdx1EqualTo("");
            long l1 = cnst.prdtMapper.countByExample(pe1);


            p.p("-------------------------GenFenLeiNo11------------------------------");
            if(l==0&&l1==0)continue;
            p.p("-------------------------GenFenLeiNo2------------------------------");
            PrdtWithBLOBs pb=new PrdtWithBLOBs();
            pb.setPrdNo(ps.getPrdNo());pb.setIdx1(fenLeiNo);
            int i = cnst.prdtMapper.updateByPrimaryKeySelective(pb);


            p.p("--------------------geng xin prdt biao li idx1(fenLeiNo)shi null huo zhe shi kong zi fu chuan de ge shu---------------");
            p.p(i);
            p.p("-------------------------------------------------------");



        }




    }


}
