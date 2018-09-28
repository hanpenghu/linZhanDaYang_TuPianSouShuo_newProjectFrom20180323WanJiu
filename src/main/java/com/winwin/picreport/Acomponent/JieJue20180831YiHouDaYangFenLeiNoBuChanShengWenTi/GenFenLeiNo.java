package com.winwin.picreport.Acomponent.JieJue20180831YiHouDaYangFenLeiNoBuChanShengWenTi;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        p.p("kai shi geng xin fen_Lei_No");
        this.f1();
        p.p("jie shu geng xin fen_Lei_No");
        p.p("kai shi geng xin idx_No");
        this.doIdxNo1();
        p.p("jie shu geng xin idx_No");
        p.p("{"+fixedDelay+"} hao miao yi ci , geng xin null de fenLeiNo 1 ci end");
    }


    private String 最后生成="最后生成";
    /**
     *8月31号之后的自耦东生成idx_no
     * */
    public void doIdxNo(){
        try {
            List<PrdtSamp> prdtSamps = cnst.a001TongYongMapper.getAllNoIdxNo();
            p.p("---------------GenFenLeiNo.doIdxNo de dao de prdtSamp----------------------------------------");
            p.p(prdtSamps==null?null:prdtSamps.size());
            p.p("-------------------------------------------------------");
            if(p.empty(prdtSamps))return;
            p.p("--------------------sheng cheng idxno1-----------------------------------");
            for(PrdtSamp ps:prdtSamps){
                p.p("----------------------shengcheng idxNo2--------ps.getIdxName()="+ps.getIdxName()+"-------------------------");
                String idxNo = cnst.a001TongYongMapper.getIdxNoUseIdxName(ps.getIdxName());
                p.p("-------------------------shengcheng idxNo3------------------------------");
                if(p.empty(idxNo)){
                    p.p("-------------------------shengcheng idxNo4------------------------------");
                    continue;
                }
                p.p("-------------------------shengcheng idxNo5------------------------------");
                if(p.empty(ps.getIdxNo())){
                    p.p("-------------------------shengcheng idxNo6------------------------------");
                    PrdtSamp p1=new PrdtSamp();p1.setId(ps.getId());p1.setIdxNo(idxNo);
                    p.p("-------------------------shengcheng idxNo7------------------------------");
                    cnst.prdtSampMapper.updateByPrimaryKeySelective(p1);
                    p.p("-------------------------shengcheng idxNo8------------------------------");
                    this.remSet(p1,最后生成);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
    }


    /**
     *打样编辑之后根据id生成idx_no
     * 因为导出的时候是按idx_no匹配导出的
     * */
    public void gIdxNo(String id) {
        try {
            log.info("id={}",id);
            PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(id);
            log.info("《《《《《《《《genJuDaYangIdDeDao DaYangDuiXiang De FenLeiName: 》{}》》prd_no》{}》》》》》》",prdtSamp.getFenLeiName(),prdtSamp.getPrdNo());
            if(p.empty(prdtSamp)){
                log.info("gen ju id de dao de prdtSamp shi kong de ");
                return;
            }
            if(p.empty(prdtSamp.getIdxName())){
                log.info("gen ju id de dao de prdtSamp.FenLeiName shi kong de ");
                return;
            }
            IndxExample iee=new IndxExample();
            iee.createCriteria().andNameEqualTo(prdtSamp.getIdxName());
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
            prdtSamp1.setIdxNo(indx.getIdxNo());
            prdtSamp1.setId(id);
            int i = cnst.prdtSampMapper.updateByPrimaryKeySelective(prdtSamp1);
            this.remSet(prdtSamp1,最后生成);
            log.info("geng xin prdt_samp zhu biao fen_lei_no {} tiao shu ju",i);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }

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
                    this.remSet(p1,最后生成);
                    p.p("-------------------------GenFenLeiNo8------------------------------");
                }



                //下面是设置prdt里面的货号和idx1=FenLeiNo的
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
            this.remSet(prdtSamp1,最后生成);
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


    private  void remSet(PrdtSamp pp, String remMsg) {

        try {
            if(p.empty(remMsg)){return;}
            p.p("$$$$$$   0   $$$$$$$$$$ id="+pp.getId()+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            String rem= cnst.a001TongYongMapper.selectPrdtSampRem(pp.getId());
            p.p("$$$$$$   1   $$$$$$$$$$rem="+rem+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            List<String> list=new ArrayList<>();
            if(p.notEmpty(rem)){
                list = JSON.parseArray(rem, String.class);
                p.p("$$$$$$   2   $$$$$$$$$$list="+list+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            }
            list.add(remMsg);
            p.p("$$$$$$   3  $$$$$$$$$$list="+list+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            if(p.notEmpty(list)){
                rem=JSON.toJSONString(list);
                p.p("$$$$$$   4   $$$$$$$$$$ rem="+rem+"$$$   id="+pp.getId()+"   $$$$$$$$$$$$$$$$$$$$$$$$$$");
                int  i=cnst.a001TongYongMapper.updatePrdtSampRem(pp.getId(),rem);
    //            pp.setRem(rem);
    //            p.p("$$$$$$   5  $$$$$$$$$$ i="+i+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            }
            p.p("$$$$$$   6   $$$$$$$$$$ rem="+rem+"$$$$$$$$list="+list+"$$$$$$$$$$$$$$$$$$$$$");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
    }







    /**
     *下面2个专门用于定时任务更新从6月28日的
     * */
private String 定时任务生成="定时任务生成";

    public void doIdxNo1(){
        try {
            List<PrdtSamp> prdtSamps = cnst.a001TongYongMapper.getAllNoIdxNo1();
            p.p("---------------GenFenLeiNo.doIdxNo de dao de prdtSamp----------------------------------------");
            p.p(prdtSamps==null?null:prdtSamps.size());
            p.p("-------------------------------------------------------");
            if(p.empty(prdtSamps))return;
            p.p("--------------------sheng cheng idxno1-----------------------------------");
            for(PrdtSamp ps:prdtSamps){
                p.p("----------------------shengcheng idxNo2--------ps.getIdxName()="+ps.getIdxName()+"-------------------------");
                String idxNo = cnst.a001TongYongMapper.getIdxNoUseIdxName(ps.getIdxName());
                p.p("-------------------------shengcheng idxNo3------------------------------");
                if(p.empty(idxNo)){
                    p.p("-------------------------shengcheng idxNo4------------------------------");
                    continue;
                }
                p.p("-------------------------shengcheng idxNo5------------------------------");
                if(p.empty(ps.getIdxNo())){
                    p.p("-------------------------shengcheng idxNo6------------------------------");
                    PrdtSamp p1=new PrdtSamp();p1.setId(ps.getId());p1.setIdxNo(idxNo);
                    p.p("-------------------------shengcheng idxNo7------------------------------");
                    cnst.prdtSampMapper.updateByPrimaryKeySelective(p1);
                    p.p("-------------------------shengcheng idxNo8------------------------------");
                    this.remSet(p1,定时任务生成);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
    }


    public void f1(){
        try {
            List<PrdtSamp> prdtSamps = cnst.a001TongYongMapper.getAllNoFenLeiNo1();
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
                    this.remSet(p1,定时任务生成);
                    p.p("-------------------------GenFenLeiNo8------------------------------");
                }



                //下面是设置prdt里面的货号和idx1=FenLeiNo的
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




}
