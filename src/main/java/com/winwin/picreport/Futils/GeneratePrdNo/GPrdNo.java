package com.winwin.picreport.Futils.GeneratePrdNo;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class GPrdNo {

    @Autowired
    private Cnst cnst;

    /**
     * 判断前端传过来的要存的prdtSamp里面的prdCode
     * 是否在表prdt中有一个name字段对应_对应就找到第一个prd_no用_
     * 不对应就到idx表找到对应的分类_然后找到idx分类的最大no,然后加一流水到prdt中插入一项
     */


    @Transactional
    public void prdtSampObjGetPrdNo(PrdtSamp0 prdtSamp) {
        //得到前端传过来的prdt_code//在prdt里面其实对应的name
        String prdCode = prdtSamp.getPrdCode();
        p.p("===============1=================");
        //在prdt表中找该prdtCode是否对应一个name字段,有可能多个,但是我们只要一个,所以,我们要自己写sql找到top 1
        String prdtNo = cnst.a001TongYongMapper.selectTop1PrdtNo(prdCode);
        p.p("===============2=================");
        if (p.notEmpty(prdtNo)) {
            p.p("===============3=================");
            //如果不是空的,我们就要把这个prdtNo放到prdtSamp里面,将来进行插入prdt_samp表用
            prdtSamp.setPrdNo(prdtNo);
            //此时再判断 该prdNo在prdt表中对应的有ut没有,没有就插入一个,有的话算了
           this.updatePrdNoOfPrdt(prdtNo,prdtSamp);
        } else {
            //此时代表prdt表中没有对应的prd_no,这时候需要到idx表流水一个
            //通过prd_code(name)到表idx中找最后一个流水
            p.p("===============8=================");
            this.prdtSampObjGetPrdNoByIndxGenerate(prdtSamp);
            p.p("===============16=================");
        }


    }




    @Transactional
    public void prdtSampObjGetPrdNoByIndxGenerate(PrdtSamp0 prdtSamp) {
        p.p("--------------------开始流水货号--prdtSamp.getFenLeiNo()=" + prdtSamp.getFenLeiNo() + "---------------------------------");
        p.p("==============9=================");
        //        synchronized (this) {
        //得到中类代号,fenLeiNo是最小范围的
        String fenLeiNo = prdtSamp.getFenLeiNo();
        //在prdt里面找到相同的indx1的prdNo流水最大的那个
        //            String prdNoMax= cnst.a001TongYongMapper.selectTop1MaxPrdtNo(indx1);
        p.p("===============10=================");
        if (p.empty(fenLeiNo)) {
            p.p("==============11=================");
            throw new RuntimeException("该中类编号在《"+fenLeiNo+"》在prdt表中没有一个记录,导致无法流水");
        }

        p.p("===============12=================");
        String prdNoMax = this.getAllUpAndDownIdxNo(fenLeiNo);
        p.p("===============13================");
        //将prdNoMax转化成long
        if (p.notEmpty(prdNoMax)) {
            p.p("===============14=================");
            //给prdtSamp添加货号
            prdtSamp.setPrdNo(prdNoMax);
            p.p("-----------得到货号-----prdtSamp.setPrdNo(prdNoMax)---" + prdtSamp.getPrdNo() + "-------------------------");
           this.insertPrdtAPrdNo(prdtSamp,prdNoMax,fenLeiNo);
        }else{
            throw new RuntimeException("货号流水异常,未能流水到货号");
        }
    }


    @Transactional
    public void updatePrdNoOfPrdt(String prdtNo, PrdtSamp0 prdtSamp) {
        String ut = cnst.a001TongYongMapper.selectUtByPrdNoFromPrdt(prdtNo);
        p.p("===============4=================");
        if (p.empty(ut)) {
            p.p("===============5=================");
            String mainUnit = prdtSamp.getMainUnit();
            mainUnit=this.setUnit(mainUnit,prdtSamp);
            p.p("===============6=================");
            int i = cnst.a001TongYongMapper.updateUtToPrdtUsePrdNo(prdtNo, mainUnit);
            p.p("===============7=================");
        }



     /*   select prd_no,insertdate,fen_lei_no,fen_lei_name,*  from PRDT_SAMP where
      prd_code in (
                select name from prdt where idx1='' or  idx1=NULL or idx1 is NULL)*/

        //再次检查prdt里面的分类,没有就更新进去
        String idx1=cnst.a001TongYongMapper.selectIdx1ByPrdNoFromPrdt(prdtNo);
        if(p.empty(idx1)&&p.notEmpty(prdtSamp.getFenLeiNo())){
            int ii = cnst.a001TongYongMapper.updateIdx1(prdtNo,prdtSamp.getFenLeiNo());
        }


    }



    @Transactional
    public void insertPrdtAPrdNo(PrdtSamp0 prdtSamp, String prdNoMax, String indx1) {
        //对应数据库的name
        String prdCode = prdtSamp.getPrdCode();
        p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt插入prdNo开始~~~~~~~~~~~~~~~~~~~~~~~~");
        String knd = "1";String dfu_ut = "1";String usr = "ADMIN";String chkMan = "ADMIN";
        String mainUnit = prdtSamp.getMainUnit();
        mainUnit=this.setUnit(mainUnit,prdtSamp);
        cnst.a001TongYongMapper.insertPrdtOnePrdNo(prdNoMax, indx1, prdCode, usr, chkMan, knd, dfu_ut, mainUnit);
        p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt插入prdNo结束~~~~~~~~~~~~~~~~~~~~~~~~");
        p.p("===============15=================");
    }

    @Transactional
    public String setUnit(String mainUnit,PrdtSamp0 prdtSamp) {
        if(p.empty(mainUnit)){
            if(p.notEmpty(prdtSamp.getUnit())){
                mainUnit=prdtSamp.getUnit();
            }
        }
        if (mainUnit != null && mainUnit.contains("主:")) {
            mainUnit = mainUnit.replace("主:", "");
        }
        return mainUnit;
    }

    //找到idxNo的所有上下级 idxNp
    @Transactional
    public  String   getAllUpAndDownIdxNo(String fenLeiNo){
        //在prdt里面找到相同的indx1的prdNo流水最大的那个
        String maxPrdNoSecond= cnst.a001TongYongMapper.selectTop1MaxPrdtNo(fenLeiNo);
        if(p.empty(maxPrdNoSecond)){
            //此时具有该中类no的商拼在prdt还没有一条,我们从1开始流水一条
            throw new RuntimeException("分类编号在prdt里没有任何记录,无法流水");

        }
        maxPrdNoSecond = this.getMaxPrdNoSecond(maxPrdNoSecond);
        return maxPrdNoSecond;
    }



    /**
     *害怕这个prdt_no已经存在,再次通过加1的手段搞定
     * */
    @Transactional
    public String getMaxPrdNoSecond(String prdNoMax){
        Integer ii= cnst.a001TongYongMapper.ifIdxNoExistInPrdt(prdNoMax);
        //       System.out.println("~~~~~~~~~prdNoMax=~~~"+prdNoMax+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(ii>0){
            //如果ii在里面已经存在,就需要加1
            long l = new Long(prdNoMax) + 1L;
            prdNoMax=String.valueOf(l);
            ii= cnst.a001TongYongMapper.ifIdxNoExistInPrdt(prdNoMax);
        }
        //        System.out.println("~~~~~~~~~prdNoMax=~~~"+prdNoMax+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return prdNoMax;
    }


    /**
     * 当prdt_samp中prdno,存在,而prdt中prdno不存在的时候的操作
     */
  /*  public void reSetPrdNo(PrdtSamp0 prdtSamp) {

        //先判断prdt中是否有该prdno,没有就加入
        PrdtExample p1 = new PrdtExample();
        p1.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo());

        long l = cnst.prdtMapper.countByExample(p1);
        if (l == 0) {
            //此时prdt中没有该货号
            p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个~prdno=~" + prdtSamp.getPrdNo() + "~idxno=" + prdtSamp.getIdxNo() + "~prdcode=~" + prdtSamp.getPrdCode() + "~~user=~~~" + prdtSamp.getUsr() + "~~~~~~~~~~~~~");
            String knd = "1";
            String dfu_ut = "1";
            String usr = "ADMIN";
            String chkMan = "ADMIN";
            String mainUnit = prdtSamp.getMainUnit();
            Integer integer = cnst.a001TongYongMapper.insertPrdtOnePrdNo
                    (prdtSamp.getPrdNo(), prdtSamp.getIdxNo(), prdtSamp.getPrdCode(),
                            usr, chkMan, knd, dfu_ut, mainUnit);
            if (null != integer && integer == 1) {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个完成~~~~~~~~~~~~~~~~~~~~~~~~");

            } else {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个失败~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }


    }*/









}
