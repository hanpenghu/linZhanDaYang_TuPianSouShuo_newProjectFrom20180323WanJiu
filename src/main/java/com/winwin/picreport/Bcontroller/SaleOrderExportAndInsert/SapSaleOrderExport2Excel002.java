package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.ChaXunTiaoJian;
import com.winwin.picreport.Edto.SalePrdDetailTab1;
import com.winwin.picreport.Edto.Sapso;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

//import com.winwin.picreport.Ddao.reportxmlmapper.ManyTabSerch;

@CrossOrigin
@RestController
@RequestMapping("/c1")
/**
 *导出excel  销售订单
 * */
public class SapSaleOrderExport2Excel002 {
    @Autowired
    private Cnst cnst;
    //  {"cus_no":[""],"startTimeStamp":"1506787200000","endTimeStamp":"1506873600000"}
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "salePrdDetailTab1", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public @ResponseBody
    List<SalePrdDetailTab1> salePrdDetailTab1001(@RequestBody ChaXunTiaoJian chaXunTiaoJian) {
        List<SalePrdDetailTab1> all=new LinkedList<SalePrdDetailTab1>();
        List<SalePrdDetailTab1> ss=this.salePrdDetailTab1sGet(chaXunTiaoJian);
        List<Sapso> sapsos = this.sapsoGet(chaXunTiaoJian);
        Collections.sort(sapsos);
        List<String>sapsoStrs=this.sapsoStrsGet(sapsos);
        for(SalePrdDetailTab1 s:ss){
            //在sapso中没有对应
            if(!sapsoStrs.contains(s.getDanHao_HuoHao_ChengFenDaiMa())){
                all.add(s);
                continue;
            }
            //在sapso中有对应
            this.canSplit(all,s,sapsos);
        }
        return all;
    }

    private void canSplit(List<SalePrdDetailTab1> all, SalePrdDetailTab1 s, List<Sapso> sapsos) {
        for(Sapso sa:sapsos){
            //该对象作为备份对象,每次只是数量变化,重要的是让s的地址指向变化
            SalePrdDetailTab1 当前拆行备份s=new SalePrdDetailTab1();
            BeanUtils.copyProperties(s,当前拆行备份s);
            //注意,在一个
            if(  !sa.getDanHao_HuoHao_ChengFenDaiMa().equals(s.getDanHao_HuoHao_ChengFenDaiMa())  )continue;
            if(        sa.getQtyDouble()<=0.00001        )continue;
            if(s.getQtyDouble()<=sa.getQtyDouble()){
                this.sCommonSet(s,sa);
                all.add(s);
                sa.setQty(   p.bsub(   sa.getQtyDouble(),s.getQtyDouble()     )  );
                break;
            }else{
                当前拆行备份s.setQty(    String.valueOf(   p.bsub(   s.getQty()  ,  sa.getQty()  )    )  );
                s.setQty(    sa.getQty().toString()   );
                this.sCommonSet(s,sa);
                all.add(s);
                //给后面拆行继续用这个数量
                s=当前拆行备份s;
                sa.setQty(p.b(0));
            }
        }
    }




    private void sCommonSet(SalePrdDetailTab1 s, Sapso sapso) {
        s.setAmt(String.valueOf(s.getQtyDouble() * Double.parseDouble(s.getUp())));
        s.setEbNo(sapso.getEbno());
        s.setSapph(sapso.getSapph());
        s.setCaiGouNo(sapso.getCaigouno());
        s.setSaphh(sapso.getSaphh());
        s.setLuoHao(sapso.getLuohao());
        s.setGangHao(sapso.getGanghao());
        s.setRealWidth(sapso.getRealwidth());
        s.setRealLength(sapso.getReallength());
    }
    private List<String> sapsoStrsGet(List<Sapso> sapsos) {
        List<String>ss=new LinkedList<String>();
        for(Sapso s:sapsos){
            ss.add(s.getDanHao_HuoHao_ChengFenDaiMa());
        }
        return ss;
    }


    private List<Sapso> sapsoGet(ChaXunTiaoJian chaXunTiaoJian) {
        List<String> cus_nos = chaXunTiaoJian.getCus_no();
        List<Sapso> sapOrg = new LinkedList<>();
        for (String cus_no : cus_nos) {
            List<Sapso> listsapso = cnst.manyTabSerch.selectSapso(cus_no, chaXunTiaoJian);
            if (p.empty(listsapso)) {
                continue;
            }
            sapOrg.addAll(listsapso);
        }
        return  sapOrg;
    }

    private List<SalePrdDetailTab1> salePrdDetailTab1sGet(ChaXunTiaoJian chaXunTiaoJian) {
        List<String> cus_nos = chaXunTiaoJian.getCus_no();
        List<SalePrdDetailTab1> salePrdDetailTab1s = new ArrayList<>();
        for (String cus_no : cus_nos) {
            List<SalePrdDetailTab1> sList = cnst.manyTabSerch.salePrdDetailTab1(chaXunTiaoJian, cus_no);
            if (p.empty(sList)) {
                continue;
            }
            salePrdDetailTab1s.addAll(sList);
        }
        return salePrdDetailTab1s;
    }


}

