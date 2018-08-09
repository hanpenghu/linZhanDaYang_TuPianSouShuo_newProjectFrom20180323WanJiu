

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

        import com.winwin.picreport.AllConstant.Cnst;
        import com.winwin.picreport.Edto.ChaXunTiaoJian;
        import com.winwin.picreport.Edto.SalePrdDetailTab1;
        import com.winwin.picreport.Edto.Sapso;
        import com.winwin.picreport.Futils.hanhan.p;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Date;
        import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.List;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"/c1"})
public class SapSaleOrderExport2Excel {
    @Autowired
    private Cnst cnst;

    public SapSaleOrderExport2Excel() {
    }

    @RequestMapping(
            value = {"salePrdDetailTab100原来"},
            method = {RequestMethod.POST},
            produces = {"application/json;charset=utf-8"}
    )
    @ResponseBody
    public List<SalePrdDetailTab1> salePrdDetailTab1(@RequestBody ChaXunTiaoJian chaXunTiaoJian) {
        List<String> cus_nos = chaXunTiaoJian.getCus_no();
        List<SalePrdDetailTab1> a得到客户条件未拆行数据 = this.salePrdDetailTab1ListWeiChaiHang(cus_nos, chaXunTiaoJian);
        List<SalePrdDetailTab1> 准备添加已拆行的list = new ArrayList();
        if(p.empty(a得到客户条件未拆行数据)) {
            return 准备添加已拆行的list;
        } else {
            List<Sapso> sapsos未拆行 = this.listSapsoWeiChaiHang(cus_nos, chaXunTiaoJian);
            List<String> sapso单号货号成分相加没拆行strlist = new ArrayList();
            Iterator var7 = sapsos未拆行.iterator();

            while(var7.hasNext()) {
                Sapso sapso = (Sapso)var7.next();
                sapso单号货号成分相加没拆行strlist.add(sapso.getDanHao_HuoHao_ChengFenDaiMa());
            }

            var7 = a得到客户条件未拆行数据.iterator();

            while(var7.hasNext()) {
                SalePrdDetailTab1 s = (SalePrdDetailTab1)var7.next();
                if(sapso单号货号成分相加没拆行strlist.contains(s.getDanHao_HuoHao_ChengFenDaiMa())) {
                    this.sapso中有s中对应项需要拆行(sapsos未拆行, s, 准备添加已拆行的list);
                } else {
                    准备添加已拆行的list.add(s);
                }
            }

            return 准备添加已拆行的list;
        }
    }

    private void sapso中有s中对应项需要拆行(List<Sapso> sapsos未拆行, SalePrdDetailTab1 s, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        List<Sapso> sapso用于拆一个s的list = this.当前s下要拆行的sapso集合(sapsos未拆行, s);
        if(sapso用于拆一个s的list.size() == 1) {
            this.sapso中只有一个拆行(sapso用于拆一个s的list, s, 准备添加已拆行的list);
        } else {
            Collections.sort(sapso用于拆一个s的list);
            Iterator iterator = sapso用于拆一个s的list.iterator();

            while(iterator.hasNext()) {
                SalePrdDetailTab1 salePrdDetailTab2 = new SalePrdDetailTab1();
                BeanUtils.copyProperties(s, salePrdDetailTab2);
                Sapso sapso = (Sapso)iterator.next();
                if(sapso.getQtyDouble().doubleValue() - s.getQtyDouble().doubleValue() >= 0.0D) {
                    s.setSapph(sapso.getSapph());
                    s.setCaiGouNo(sapso.getCaigouno());
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

                s.setSapph(sapso.getSapph());
                s.setCaiGouNo(sapso.getCaigouno());
                s.setSaphh(sapso.getSaphh());
                s.setLuoHao(sapso.getLuohao());
                s.setGangHao(sapso.getGanghao());
                s.setRealWidth(sapso.getRealwidth());
                s.setRealLength(sapso.getReallength());
                double chaiHangHouQtyDouble = s.getQtyDouble().doubleValue() - sapso.getQtyDouble().doubleValue();
                s.setQty(String.valueOf(sapso.getQty()));
                s.setAmt(String.valueOf(sapso.getQty().doubleValue() * Double.parseDouble(s.getUp())));
                s.setEbNo(sapso.getEbno());
                准备添加已拆行的list.add(s);
                salePrdDetailTab2.setQty(String.valueOf(chaiHangHouQtyDouble));
                s = salePrdDetailTab2;
                iterator.remove();
            }
        }

    }

    private void sapso中只有一个拆行(List<Sapso> sapso用于拆一个s的list, SalePrdDetailTab1 s, List<SalePrdDetailTab1> 准备添加已拆行的list) {
        Iterator var4 = sapso用于拆一个s的list.iterator();
        if(var4.hasNext()) {
            Sapso sapso = (Sapso)var4.next();
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
        }

    }

    private List<Sapso> 当前s下要拆行的sapso集合(List<Sapso> sapsos未拆行, SalePrdDetailTab1 s) {
        List<Sapso> sapso用于拆一个s的list = new LinkedList();
        Iterator var4 = sapsos未拆行.iterator();

        while(var4.hasNext()) {
            Sapso sapso = (Sapso)var4.next();
            if(sapso.getDanHao_HuoHao_ChengFenDaiMa().equals(s.getDanHao_HuoHao_ChengFenDaiMa())) {
                sapso用于拆一个s的list.add(sapso);
            }
        }

        return sapso用于拆一个s的list;
    }

    private List<SalePrdDetailTab1> salePrdDetailTab1ListWeiChaiHang(List<String> cus_nos, ChaXunTiaoJian chaXunTiaoJian) {
        List<SalePrdDetailTab1> salePrdDetailTab1ListWeiChaiHang = new ArrayList();
        Iterator var4 = cus_nos.iterator();

        while(var4.hasNext()) {
            String cus_no = (String)var4.next();
            List<SalePrdDetailTab1> salePrdDetailTab1sOfDangQianCusNoXia = this.cnst.manyTabSerch.salePrdDetailTab1(chaXunTiaoJian, cus_no);
            if(!p.empty(salePrdDetailTab1sOfDangQianCusNoXia)) {
                salePrdDetailTab1ListWeiChaiHang.addAll(salePrdDetailTab1sOfDangQianCusNoXia);
            }
        }

        return salePrdDetailTab1ListWeiChaiHang;
    }

    private List<Sapso> listSapsoWeiChaiHang(List<String> cus_nos, ChaXunTiaoJian chaXunTiaoJian) {
        Date date = p.getDate();
        List<Sapso> listSapsoWeiChaiHang = new LinkedList();
        Iterator var5 = cus_nos.iterator();

        while(var5.hasNext()) {
            String cus_no = (String)var5.next();
            List<Sapso> listsapso = this.cnst.manyTabSerch.selectSapso(cus_no, chaXunTiaoJian);
            if(!p.empty(listsapso)) {
                listSapsoWeiChaiHang.addAll(listsapso);
            }
        }

        return listSapsoWeiChaiHang;
    }
}
