package com.winwin.picreport.Bcontroller.daYang.manyConditionSearch;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.FenYe;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/19.
 */

@CrossOrigin
@Controller
public class ManyConditionSearchOfExportInfo2Excel {
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private Cnst cnst;

    @RequestMapping(value="manyConditionSearchOfExportInfo2Excel",method= RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public @ResponseBody FenYe f(@RequestBody FenYe fenYe){
        if(fenYe==null){
            FenYe f=new FenYe();
            return f;
        }else{
            try {
                return  this.manyConditionSearchOfPrdtFiltList(fenYe);
            } catch (IllegalAccessException e) {
                FenYe f1=new FenYe();
                return f1;
            }
        }
    }


    /**
     *多条件产品打样列表
     * */
    private FenYe manyConditionSearchOfPrdtFiltList(FenYe f) throws IllegalAccessException {

        PrdtSamp1 p1 = f.getPrdtSamp1();
        boolean b = this.conditionOnlyPrdCode(p1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~转换前多条件的条件实验~~~~~~~~~~~~~~~~~~~~~~~~");
        p.p(p1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
        //注意,Select,不用写在service里面也可以
        //得到创建开始时间时间戳
        String insertdateStr = p1.getInsertdateStr();
        //将创建开始时间戳转换为Date格式
        Date date = p.sjc2Date(insertdateStr);
        //得到创建结束时间时间戳
        String insertdateStrEnd = p1.getInsertdateStrEnd();
        //将创建结束时间戳转换成Date
        Date date1 = p.sjc2Date(insertdateStrEnd);
        //得到确认开始时间str
        String confirmtimestr = p1.getConfirmtimestr();
        //将确认开始时间戳转换成Date
        Date date2 = p.sjc2Date(confirmtimestr);
        //得到确认结束时间戳str
        String confirmtimestrEnd = p1.getConfirmtimestrEnd();
        //得到确认结束时间date
        Date date3 = p.sjc2Date(confirmtimestrEnd);

        p1.setInsertdate(date);
        p1.setInsertdateEnd(date1);
        p1.setConfirmtime(date2);
        p1.setConfirmtimeEnd(date3);
        //从新定义p1的时间戳str为一定格式的时间  带-时间,将来在sql里要用这个str时间
        p1.setInsertdateStr(p.dtoStr(date,p.d2));
        p1.setInsertdateStrEnd(p.dtoStr(date1,p.d2));
        p1.setConfirmtimestr(p.dtoStr(date2,p.d2));
        p1.setConfirmtimestrEnd(p.dtoStr(date3,p.d2));
        p1 = (PrdtSamp1) p.StringTypeNull2Space(p1);

        //把每页显示数和当前页设置进去
        if(f.getMeiYeXianShiShu()==null){
            p1.setMeiYeXianShiShu(10);
        }else{
            p1.setMeiYeXianShiShu(f.getMeiYeXianShiShu());
        }
        if(f.getDangQianYe()==null){
            p1.setDangQianYe(1);
        }else{
            p1.setDangQianYe(f.getDangQianYe());
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~转换后多条件的条件实验~~~~~~~~~~~~~~~~~~~~~~~~");
        p.p(p1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("================p1.getFenLeiName()="+p1.getFenLeiName()+"==========================================");

        if(p.notEmpty(p1.getFenLeiName())){
            List<String> fenLeiNameList = cnst.a001TongYongMapper.diGuiFenLeiName(p1.getFenLeiName());
            p1.setFenLeiNames((List<String>) p.removeNull(fenLeiNameList));
        }
        System.out.println("======list==========p1.getFenLeiNames()="+p1.getFenLeiNames()+"==========================================");
        System.out.println("================p1.getFenLeiName()="+p1.getFenLeiName()+"==========================================");
        List<PrdtSampExcleExportManyCondition> prdtSampExcels;
        if(b){
            //为了根据prd_code排序专门走这一步,后来改成按insertdate排序又按老郑说的编码规则查询
            //只用于
            //昨天说了只改产品编码建档里的查询，销售定价，样品确认模块里怎么受影响了 2018_9_4   weekday(2)   9:29:34 by 老郑
            prdtSampExcels = cnst.a001TongYongMapper.chanPinBianMaJianDangTiaoJianChaXunExportExcelPrdCode(p1);
        }else{
            //不能根据 prd_code排序走这一步
            prdtSampExcels = cnst.a001TongYongMapper.chanPinBianMaJianDangTiaoJianChaXunExportExcel(p1);
        }


        this.onePriceSet(prdtSampExcels);
        p.p("--------------------List<PrdtSampExcleExportManyCondition> prdtSampExcels = -----------------------------------");
        p.p(prdtSampExcels);
        p.p("-------------------------------------------------------");
        f.setPrdtSampExcleList(prdtSampExcels);
        //我在这个方法中顺便调了setZongYeShu()方法
        f.setZongJiLuShu(cnst.a001TongYongMapper.getCountOfDuoTiaoJianChaXunZongJiLuShuExportExcel(p1));
        return f;


    }

    private void onePriceSet(List<PrdtSampExcleExportManyCondition> prdtSampExcels) {
        for(PrdtSampExcleExportManyCondition pp:prdtSampExcels){
            if(p.notEmpty(pp.getPrdNo())){
                PrdtSamp0 p0=new PrdtSamp0();
                p0.setPrdNo(pp.getPrdNo());
                cnst.getPriceModelUpdef20180512.getPriceModel(p0);
                pp.setUpDefMyList(p0.getUpDefMyList());
                pp.setUpDefMyListBuy(p0.getUpDefMyListBuy());
                this.qtySet(pp);
            }
        }
    }


    private String qtySet(PrdtSampExcleExportManyCondition pp) {
        if(p.notEmpty(pp.getQty())){
            pp.setQty(p.del0(pp.getQty()));
            return "结束";
        }else{
            if(p.notEmpty(pp.getPrdNo())){
                UpDefExample u=new UpDefExample();
                u.createCriteria().andPrdNoEqualTo(pp.getPrdNo());
                List<UpDef> upDefs = cnst.upDefMapper.selectByExample(u);
                for(UpDef uu:upDefs){
                    if(null!=uu.getQty()){
                        pp.setQty(String.valueOf(uu.getQty()));
                        if(null!=pp.getQty()) {
                            pp.setQty(p.del0(pp.getQty()));
                        }
                        return "结束";
                    }
                }
            }
        }
        return "结束";
    }



    private boolean conditionOnlyPrdCode(PrdtSamp1 p1) {

        boolean b6 = p.notEmpty(p1.getPrdCode());
        boolean b =  p.empty(p1.getCusName());
        boolean b1 =  p.empty(p1.getInsertdateStr());
        boolean b2 =  p.empty(p1.getInsertdateStrEnd());
        boolean b3 =  p.empty(p1.getConfirmtimestr());
        boolean b4 = p.empty(p1.getConfirmtimestrEnd() );
        boolean b5 = p.empty(p1.getIdxName());
        boolean b7 = p.empty(p1.getSalName() );
        boolean b8 = p.empty(p1.getFenLeiName());
        if(b6&&b&&b1&&b2&&b3&&b4&&b5&&b6&&b7&&b8){
            return true;
        }else{
            return false;
        }


    }


}
