package com.winwin.picreport.Futils.GeneratePrdNo;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.Prdt;
import com.winwin.picreport.Edto.PrdtExample;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Futils.NotEmpty;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GPrdNo {
    @Autowired
    private Cnst cnst;
    /**
     *判断前端传过来的要存的prdtSamp里面的prdCode
     * 是否在表prdt中有一个name字段对应_对应就找到第一个prd_no用_
     * 不对应就到idx表找到对应的分类_然后找到idx分类的最大no,然后加一流水到prdt中插入一项
     * */


    @Transactional
    public void prdtSampObjGetPrdNo(PrdtSamp0 prdtSamp){
        //得到前端传过来的prdt_code//在prdt里面其实对应的name
        String prdCode = prdtSamp.getPrdCode();

        //在prdt表中找该prdtCode是否对应一个name字段,有可能多个,但是我们只要一个,所以,我们要自己写sql找到top 1
        String prdtNo=cnst.a001TongYongMapper.selectTop1PrdtNo(prdCode);

        if(p.notEmpty(prdtNo)){

            //如果不是空的,我们就要把这个prdtNo放到prdtSamp里面,将来进行插入prdt_samp表用
            prdtSamp.setPrdNo(prdtNo);
            //此时再判断 该prdNo在prdt表中对应的有ut没有,没有就插入一个,有的话算了
           String ut= cnst.a001TongYongMapper.selectUtByPrdNoFromPrdt(prdtNo);
            if(p.empty(ut)){
                String mainUnit = prdtSamp.getMainUnit();
                //此时prdt表么没有ut单位,插入一个
                int i=cnst.a001TongYongMapper.updateUtToPrdtUsePrdNo(prdtNo,mainUnit);
            }

        }else{
            //此时代表prdt表中没有对应的prd_no,这时候需要到idx表流水一个
            //通过prd_code(name)到表idx中找最后一个流水
            this.prdtSampObjGetPrdNoByIndxGenerate(prdtSamp);
        }



    }




    @Transactional
    public void prdtSampObjGetPrdNoByIndxGenerate(PrdtSamp0 prdtSamp){
//        synchronized (this) {
            //得到中类代号,fenLeiNo是最小范围的
            String indx1=prdtSamp.getFenLeiNo();
            //在prdt里面找到相同的indx1的prdNo流水最大的那个
//            String prdNoMax= cnst.a001TongYongMapper.selectTop1MaxPrdtNo(indx1);

            String prdNoMax = cnst.getMaxPrdNo.getAllUpAndDownIdxNo(indx1);

            //将prdNoMax转化成long
            if(p.notEmpty(prdNoMax)){
//                long l = Long.parseLong(prdNoMax);
//                p.p("~~~~~~~~~~~~~~~~~~~~~~~~未加1的prdno~~~"+l+"~~~~~~~~~~~~~~~~~~~~~");
//                l++;
//                String prdNo = String.valueOf(l);
//                p.p("~~~~~~~~~~~~~~~~~~~~~~~~加1的prdno~~"+l+"~~"+prdNo+"~~~~~~~~~~~~~~~~~~~~");
                //给prdtSamp添加货号
                prdtSamp.setPrdNo(prdNoMax);
                //对应数据库的name
                String prdCode = prdtSamp.getPrdCode();
                String usr=prdtSamp.getUsr();
                String chkMan=prdtSamp.getUsr();

//                try {
                p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt插入prdNo开始~~~~~~~~~~~~~~~~~~~~~~~~");
//                knd=1,dfu_ut=1,usr='ADMIN',chk_man='ADMIN'
                    String knd="1";
                    String dfu_ut="1";
                    usr="ADMIN";
                    chkMan="ADMIN";
                String mainUnit = prdtSamp.getMainUnit();
                cnst.a001TongYongMapper.insertPrdtOnePrdNo(prdNoMax,indx1,prdCode,usr,chkMan,knd,dfu_ut,mainUnit);
                    p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt插入prdNo结束~~~~~~~~~~~~~~~~~~~~~~~~");
//                } catch (Exception e) {
//                    p.p("com.winwin.picreport.Futils.GeneratePrdNo.GPrdNo.prdtSampObjGetPrdNoByIndxGenerate有问题");
//                    e.printStackTrace();
//                }

            }
//        }

    }
    /**
     *当prdt_samp中prdno,存在,而prdt中prdno不存在的时候的操作
     *
     * */
   public void  reSetPrdNo(PrdtSamp0 prdtSamp){

       //先判断prdt中是否有该prdno,没有就加入
       PrdtExample p1=new PrdtExample();
       p1.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo());

       long l = cnst.prdtMapper.countByExample(p1);
       if(l==0){
           //此时prdt中没有该货号
           p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个~prdno=~"+prdtSamp.getPrdNo()+"~idxno="+prdtSamp.getIdxNo()+"~prdcode=~"+prdtSamp.getPrdCode()+"~~user=~~~"+prdtSamp.getUsr()+"~~~~~~~~~~~~~");
           String knd="1";
           String dfu_ut="1";
           String usr="ADMIN";
           String  chkMan="ADMIN";
           String mainUnit=prdtSamp.getMainUnit();
           Integer integer = cnst.a001TongYongMapper.insertPrdtOnePrdNo
                   (prdtSamp.getPrdNo(), prdtSamp.getIdxNo(), prdtSamp.getPrdCode(),
                           usr, chkMan,knd,dfu_ut,mainUnit);
           if(null!=integer&&integer==1){
               p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个完成~~~~~~~~~~~~~~~~~~~~~~~~");

           }else{
               p.p("~~~~~~~~~~~~~~~~~~~~~~~~prdt表中没有该货号,插入一个失败~~~~~~~~~~~~~~~~~~~~~~~~");
           }
       }


   }
}
