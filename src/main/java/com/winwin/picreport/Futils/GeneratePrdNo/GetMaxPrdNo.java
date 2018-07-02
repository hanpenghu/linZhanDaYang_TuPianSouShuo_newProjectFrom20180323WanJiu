package com.winwin.picreport.Futils.GeneratePrdNo;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.NotEmpty;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
@Transactional
public class GetMaxPrdNo {
    @Autowired
    private Cnst cnst;

    //找到idxNo的所有上下级 idxNp
    public String  getAllUpAndDownIdxNo(String idxNo){
        //在prdt里面找到相同的indx1的prdNo流水最大的那个
            String maxPrdNoSecond= cnst.a001TongYongMapper.selectTop1MaxPrdtNo(idxNo);
        maxPrdNoSecond = this.getMaxPrdNoSecond(maxPrdNoSecond);
        return maxPrdNoSecond;
    }



    /**
     *害怕这个prdt_no已经存在,再次通过加1的手段搞定
     * */
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




    //得到所有下级
    private List<String> deDaoSuoYouJiBie_IdxNo(String idxNo){
        List<String>list=new ArrayList<>();
        if(NotEmpty.notEmpty(idxNo)){
            list.add(idxNo);
            this.diGuiSuoYouXiaJi(list, idxNo);
        }


        return list;
    }


     private void diGuiSuoYouXiaJi(List<String>list,String idxNo){
         List<String>dangQianDeSuoYouXiaJi=cnst.a001TongYongMapper.selectAllXiaJi(idxNo);
         if(p.notEmpty(dangQianDeSuoYouXiaJi)){
             for(String idxno:dangQianDeSuoYouXiaJi){
                 list.add(idxno);
             }
             for(String idxno:dangQianDeSuoYouXiaJi){
                 this.diGuiSuoYouXiaJi(list,idxno);
             }
         }
     }





    //得到不是0000000000(10个0)最上级idxNo
    private String deDaoZuiShangJi_IdxNo(String idxNo){
        while(null!=idxNo){
            String idxNo1=cnst.a001TongYongMapper.deDaoShangJi_IdxNo(idxNo);
            if(null==idxNo1){
                //证明是"0000000000"
                return "0000000000";
            }
            if("0000000000".equals(idxNo1)){
                return  idxNo;
            }
            idxNo= cnst.a001TongYongMapper.deDaoShangJi_IdxNo(idxNo1);
            if("0000000000".equals(idxNo)){
                //此时证明idxNo1就是我要找到第二层上级
                return idxNo1;
            }
        }
        return "0000000000";
    }




}
