package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

import com.winwin.picreport.AllConstant.Cnst;
//import com.winwin.picreport.Ddao.reportxmlmapper.ManyTabSerch;
import com.winwin.picreport.Edto.ChaXunTiaoJian;
import com.winwin.picreport.Edto.SalePrdDetailTab1;
import com.winwin.picreport.Edto.Sapso;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/c1")
/**
 *导出excel  销售订单
 * */
public class SapSaleOrderExport2Excel001 {
    @Autowired


    private Cnst cnst;

    //     {"cus_no":[""],"startTimeStamp":"1506787200000","endTimeStamp":"1506873600000"}
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "salePrdDetailTab1001", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public @ResponseBody
    List<SalePrdDetailTab1> salePrdDetailTab1(@RequestBody ChaXunTiaoJian chaXunTiaoJian) {
        //listAll用来储存所有没有匹配sapso表的原始数据
        List<String> cus_nos = chaXunTiaoJian.getCus_no();
        List<SalePrdDetailTab1> a得到客户条件未拆行数据 = this.salePrdDetailTab1ListWeiChaiHang(cus_nos, chaXunTiaoJian);
        //将来要根据客户订单号+货号来通过数量拆分行号saphh,拆行后的数据放到salePrdDetailTab1ListYiChaiHang
        List<SalePrdDetailTab1> 准备添加已拆行的list = new ArrayList<>();
        if (p.empty(a得到客户条件未拆行数据)) {
            return 准备添加已拆行的list;
        }//如果未拆行的list是空的,就暂停掉//在sql中关联时间
        List<Sapso> sapsos未拆行 = this.listSapsoWeiChaiHang(cus_nos, chaXunTiaoJian);
        List<String> sapso单号货号成分相加没拆行strlist = new ArrayList<>();
        for (Sapso sapso : sapsos未拆行) {
            sapso单号货号成分相加没拆行strlist.add(sapso.getDanHao_HuoHao_ChengFenDaiMa());
        }
        for (SalePrdDetailTab1 s : a得到客户条件未拆行数据) {
            if (sapso单号货号成分相加没拆行strlist.contains(s.getDanHao_HuoHao_ChengFenDaiMa())) {//是通过excel导入的
                this.sapso中有s中对应项需要拆行(sapsos未拆行,s,准备添加已拆行的list);
            } else {
                //不需要拆行,直接添加//不是通过excel导入的//此时不拆行//也不会有ebno
                准备添加已拆行的list.add(s);
            }
        }
        return 准备添加已拆行的list;
    }

    private void sapso中有s中对应项需要拆行(List<Sapso> sapsos未拆行, SalePrdDetailTab1 s, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        //此时拆行,//统计包sapso里面包含几个salePrdDetailTab1.getDanHao_HuoHao_ChengFenDaiMa()
        List<Sapso> sapso用于拆一个s的list =this.当前s下要拆行的sapso集合(sapsos未拆行, s);
        if (sapso用于拆一个s的list.size() == 1) {
            //其实集合里只有一个
           this.sapso中只有一个拆行(sapso用于拆一个s的list,s,准备添加已拆行的list);
        } else {
            this.sapso中有多个对应项(sapso用于拆一个s的list,s,准备添加已拆行的list);
        }
    }

    private void sapso中有多个对应项(List<Sapso> sapso用于拆一个s的list, SalePrdDetailTab1 s, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        Collections.sort(sapso用于拆一个s的list);//通过saphh升序
        Iterator<Sapso> iterator = sapso用于拆一个s的list.iterator();
        while (iterator.hasNext()) {
            SalePrdDetailTab1 salePrdDetailTab2 = new SalePrdDetailTab1();
            BeanUtils.copyProperties(s, salePrdDetailTab2);
            Sapso sapso = iterator.next();
            if (sapso.getQtyDouble() - s.getQtyDouble() >= 0) {
                this.s中数量小不拆行使用自己数量(s,sapso,准备添加已拆行的list);
                break;
            } else {
                double chaiHangHouQtyDouble = s.getQtyDouble() - sapso.getQtyDouble();
                this.s数量大要拆行用sapso数量(s,sapso,准备添加已拆行的list);
                salePrdDetailTab2.setQty(String.valueOf(chaiHangHouQtyDouble));
                //s被总的添加后,再使用s会出问题,这时候让s指向另一个备份的地方
                s = salePrdDetailTab2;
                iterator.remove();
            }
        }
    }


    private void s数量大要拆行用sapso数量(SalePrdDetailTab1 s, Sapso sapso, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        this.sCommonSet(s,sapso);
        s.setQty(String.valueOf(sapso.getQty()));
        s.setAmt(String.valueOf(sapso.getQty().doubleValue() * Double.parseDouble(s.getUp())));
        s.setEbNo(sapso.getEbno());
        准备添加已拆行的list.add(s);
    }

    private void s中数量小不拆行使用自己数量(SalePrdDetailTab1 s, Sapso sapso, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        this.sCommonSet(s,sapso);
        s.setAmt(String.valueOf(Double.parseDouble(s.getQty()) * Double.parseDouble(s.getUp())));
        s.setEbNo(sapso.getEbno());
        准备添加已拆行的list.add(s);
    }


    private void sCommonSet(SalePrdDetailTab1 s, Sapso sapso) {
        s.setSapph(sapso.getSapph());
        s.setCaiGouNo(sapso.getCaigouno());
        s.setSaphh(sapso.getSaphh());
        s.setLuoHao(sapso.getLuohao());
        s.setGangHao(sapso.getGanghao());
        s.setRealWidth(sapso.getRealwidth());
        s.setRealLength(sapso.getReallength());
    }


    private void sapso中只有一个拆行(List<Sapso> sapso用于拆一个s的list, SalePrdDetailTab1 s, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        for (Sapso sapso : sapso用于拆一个s的list) {
            if (sapso.getDanHao_HuoHao_ChengFenDaiMa().equals(s.getDanHao_HuoHao_ChengFenDaiMa())) {
                s.setCaiGouNo(sapso.getCaigouno());
                s.setSapph(sapso.getSapph());
                s.setSaphh(sapso.getSaphh());
                s.setLuoHao(sapso.getLuohao());
                s.setGangHao(sapso.getGanghao());
                s.setRealWidth(sapso.getRealwidth());
                s.setRealLength(sapso.getReallength());
                s.setAmt(String.valueOf(Double.parseDouble(s.getQty()) * Double.parseDouble(s.getUp())));
                s.setEbNo(sapso.getEbno());
                准备添加已拆行的list.add(s);
                break;
            }
        }
    }


    private List<Sapso> 当前s下要拆行的sapso集合(List<Sapso> sapsos未拆行, SalePrdDetailTab1 s) {
        List<Sapso> sapso用于拆一个s的list=new LinkedList<Sapso>();
        for (Sapso sapso : sapsos未拆行) {
            if (sapso.getDanHao_HuoHao_ChengFenDaiMa().equals(s.getDanHao_HuoHao_ChengFenDaiMa())) {
                sapso用于拆一个s的list.add(sapso);
            }
        }
        return sapso用于拆一个s的list;
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private List<SalePrdDetailTab1> salePrdDetailTab1ListWeiChaiHang(List<String> cus_nos, ChaXunTiaoJian chaXunTiaoJian) {
        List<SalePrdDetailTab1> salePrdDetailTab1ListWeiChaiHang = new ArrayList<>();//用来存放未拆行的
        //得到前端所需要的没有匹配sapso行号和数量的原始数据全部放入listAll
        for (String cus_no : cus_nos) {
            List<SalePrdDetailTab1> salePrdDetailTab1sOfDangQianCusNoXia = cnst.manyTabSerch.salePrdDetailTab1(chaXunTiaoJian, cus_no);
            if (p.empty(salePrdDetailTab1sOfDangQianCusNoXia)) {
                continue;//下面代码不再执行,继续下一个
            }
            salePrdDetailTab1ListWeiChaiHang.addAll(salePrdDetailTab1sOfDangQianCusNoXia);
        }
        return salePrdDetailTab1ListWeiChaiHang;
    }


    //    public List<Sapso> listSapsoWeiChaiHang(List<SalePrdDetailTab1> salePrdDetailTab1ListWeiChaiHang){
    private List<Sapso> listSapsoWeiChaiHang(List<String> cus_nos, ChaXunTiaoJian chaXunTiaoJian) {
        Date date = p.getDate();
        List<Sapso> listSapsoWeiChaiHang = new LinkedList<>();

        for (String cus_no : cus_nos) {
            List<Sapso> listsapso = cnst.manyTabSerch.selectSapso(cus_no, chaXunTiaoJian);
            if (p.empty(listsapso)) {
                continue;
            }
            listSapsoWeiChaiHang.addAll(listsapso);
        }
        return listSapsoWeiChaiHang;
    }

}

