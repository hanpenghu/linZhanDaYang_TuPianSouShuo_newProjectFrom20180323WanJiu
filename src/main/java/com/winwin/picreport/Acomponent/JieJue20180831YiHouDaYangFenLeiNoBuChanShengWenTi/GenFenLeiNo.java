package com.winwin.picreport.Acomponent.JieJue20180831YiHouDaYangFenLeiNoBuChanShengWenTi;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 * 2018_8_31   weekday(5)   21:03:32
 */

@Component
public class GenFenLeiNo {//2018_8_31   weekday(5)   21:03:36
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Cnst cnst;

    private final long fixedDelay=60000;

    /**
     *定时任务,每30秒检查一次, 2018-08-31后更新的数据有没有fenLeiNo
     * */

    @Scheduled(initialDelay = 20000,fixedDelay =fixedDelay )
    public void updateFenLeiNoWhereNull20180831(){
        p.p("{"+fixedDelay+"} hao miao yi ci , geng xin null de fenLeiNo 1 ci start");
        this.f();
        p.p("{"+fixedDelay+"} hao miao yi ci , geng xin null de fenLeiNo 1 ci end");
    }


    /**
     *对31号以后的prdt_smap 里面fen_lei_no没有产生(对应prdt里面的idx1没有产生)
     * 的情况重新产生一遍
     * */


    public void f(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
    }


    public void g(String id) {
        try {
            log.info("id={}",id);
            PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(id);
            log.info("《《《《《《《《genJuDaYangIdDeDao DaYangDuiXiang De FenLeiName: 》{}》》prd_no》{}》》》》》》",prdtSamp.getFenLeiName(),prdtSamp.getPrdNo());
            if(p.empty(prdtSamp)){
                log.info("gen ju id de dao de prdtSamp shi kong de ");
                return;
            }
            if(p.empty(prdtSamp.getPrdNo())){
                log.info("gen ju id de dao de prdtSamp.PrdNo shi kong de ,jiang lai wu fa geng xin prdt zhong de idx1");
                return;
            }
            if(p.empty(prdtSamp.getFenLeiName())){
                log.info("gen ju id de dao de prdtSamp.FenLeiName shi kong de ");
                return;
            }
            IndxExample iee=new IndxExample();
            iee.createCriteria().andNameEqualTo(prdtSamp.getFenLeiName());
            List<Indx> indxes = cnst.indxMapper.selectByExample(iee);
            if(p.empty(indxes)){
                log.info("deDaoDe fenLeiDuiXiang shuZu shiKong de.");
                return;
            }
            log.info("deDaoDe fenLeiDuiXiang shuZu de changDu shi {} !",indxes.size());
            Indx indx = indxes.get(0);
            if(p.empty(indx)){
                log.info("indx duiXiang shi kong");
                return;
            }
            if(p.empty(indx.getIdxNo())){
                log.info("indx duiXiang de idxNo shi kong");
                return;
            }

            PrdtSamp prdtSamp1=new PrdtSamp();
            prdtSamp1.setFenLeiNo(indx.getIdxNo());
            prdtSamp1.setId(id);
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp1);
            log.info("geng xin prdt_samp zhu biao fen_lei_no {} tiao shu ju",i);

            PrdtWithBLOBs prdt=new PrdtWithBLOBs();
            prdt.setPrdNo(prdtSamp.getPrdNo());
            prdt.setIdx1(indx.getIdxNo());
            int i1 = cnst.prdtMapper.updateByPrimaryKeySelective(prdt);
            log.info("geng xin prdt biao idx1 {} tiao shu ju ",i1);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }

    }


    /**
     *用来根据id  更新prdt_samp的时间
     * */
    public void upDateTimeOfPrdtSamp(String id){
        try {
            log.info("\nkai shi geng xin prdtSamp de geng xin shi jian\n");
            PrdtSamp prdtSamp=new PrdtSamp();
            prdtSamp.setId(id);
            prdtSamp.setUpdateDate(new Date());
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp);
            log.info("\njie shu geng xin prdtSamp biao de update_date {} tiao shu ju \n",i);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
    }



}
