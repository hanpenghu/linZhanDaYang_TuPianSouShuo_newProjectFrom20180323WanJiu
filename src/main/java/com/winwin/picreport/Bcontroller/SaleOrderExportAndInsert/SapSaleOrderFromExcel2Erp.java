package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.CustWithBLOBs;
import com.winwin.picreport.Edto.MfPosExample;
import com.winwin.picreport.Edto.ShouDingDanFromExcel;
import com.winwin.picreport.Futils.*;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.pp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
*   select os_dd as '受订日期',rem as '表头备注', cur_id as '币别',exc_rto as '汇率',cus_no as '客户编号',
   tax_id '扣税类别',cus_os_no '客户订单',os_no	 as '受订单号'
  ,* from mf_pos
----------------------------------------------------
  select os_dd as '受订日期',prd_no as '货品代号',prd_name as '品名',qty as '数量',unit as '单位'
  ,amtn as '未税本位币',tax as '税额',amt as '金额',
  tax_rto as '税率' ,rem as '表身备注'	,est_dd as '预交日期' ,up as '单价'
  ,*from tf_POS
 ---------------------------------------------------------
  select sapwlm as 'SAP物料名',saphh as 'SAP行号',SAPPH as 'SAP品号',cfdm as '成分代码',* from tf_pos_z
*
* */
@CrossOrigin
@RestController
@RequestMapping("/a")
/*    select amt,amtn,tax,tax_rto,up,qty,prd_no,*from tf_pos where os_no='EBNEK18004JY2056X'
    select*from tf_pos_z where os_no='EBNEK18004JY2056X'
    select*from mf_pos where os_no='EBNEK18004JY2056X'
    select * from sapso where osno='EBNEK18004JY2056X'




    delete from tf_pos where os_no='EBNEK18004JY2056X'
    delete from tf_pos_z where os_no='EBNEK18004JY2056X'
    delete from mf_pos where os_no='EBNEK18004JY2056X'
    delete  from sapso where osno='EBNEK18004JY2056X'*/
/**
 *导入excel
 * */
public class SapSaleOrderFromExcel2Erp {
    private org.apache.log4j.Logger l = pp.getLogger(this);

    @Autowired
    private Cnst cnst;

    /////////////////////////////////////////////////////////////////////////////////////////////
//前端没有任何参数传         [{}]         受订单号成功后是SO
    @RequestMapping(value = "shouDingDanExcelToTable", method = RequestMethod.POST, produces = {p.charsetUtf8})
    public @ResponseBody List<Msg> shouDingDanExcelToTable(@RequestBody List<ShouDingDanFromExcel> ss) {
        this.f刚入接口打印(ss);
        Date date = p.getDate();
        List<Msg> listmsg = new ArrayList<>();
        try {
            this.f前端穿过来的数据是否非法_扣税类别之类(ss, listmsg);
            this.excel里面的单号必须都一样(ss, listmsg);
            Msg msg = new Msg();
            if (this.f判断前端传过来的数据是否有问题(ss)) {
                //分离出所有不相同的订单号
                Set<String> set去重os_no单号集合 = this.set去重单号(ss);
                //其实后来要求一个excel里面的单号必须相同,这方法先放这里,其实没有吊用
                List<List<ShouDingDanFromExcel>> list1 = this.f按相同单号归类数据(set去重os_no单号集合, ss);
                //按批号分批插入数据库,一个批号下的不成功都不成功在service成实现，listmsg暗传输msg错误信息
                this.f按订单号分类后向Service层传入数据(list1, listmsg);
                msg.setMsg("数据插入成功").setStatus("1");
            } else {
                msg.setMsg("第一条数据就没有OsNo(订单号),拒绝所有操作,检查您的数据信息再次插入").setStatus("0");
            }
            //把当前的msg放入将要返回给前端的集合
            listmsg.add(msg);
            //如果msg列表中有2个及2个以上,说明数据没有完全插入成功,就把那个数据插入成功的message删掉
            this.f去除多余的成功信息(listmsg, "数据插入成功");
            this.f去除空Msg(listmsg);//如果Msg中的字段msg是"",那么久去除这一条数据
        } catch (Exception e) {
            this.controller最终异常(listmsg, e);
        }
        return listmsg;
    }




    /**
     * 数据库插入数据
     */
    private final String sap = "sap";

    public void f按订单号分类后向Service层传入数据(List<List<ShouDingDanFromExcel>> l根据osno分类后的集合, List<Msg> msgs) {

        Double taxRto = f通过厂商得到小于1的税率(l根据osno分类后的集合, msgs);

        //其实这个集合长度是1  因为我们限制了用户同一次插入的excel单号必须一样
        for (List<ShouDingDanFromExcel> l某一相同osno的集合 : l根据osno分类后的集合) {

            this.f数据库是否已经有重复数据(l某一相同osno的集合, msgs);

            Map<String, List> listMap合并和未合并 =
                    this.f合并同一单号下货号成分表身备注相同的qty并根据价格数量税率计算amtn_tax_amt
                            (l某一相同osno的集合, msgs, taxRto);
            //数据传入service
            cnst.commonDaoRuDBZhiQianZhengLi.saveYiPiDingDanHaoXiangTongDe(listMap合并和未合并, msgs, sap);

        }
    }

    /**
     * 2018_6_7   weekday(4)   16:42:20    by winston
     * 订单导入税率这样处理：
     * 1.如果表格里有税额，就按表格里的税额，税率取这个客户cust.rto_tax
     * 2.如果表格里没有税额，原来计算税额按0.17现在按cust.rto_tax*0.01，税率取这个客户cust.rto_tax
     * <p>
     * <p>
     * excel中可以没有税率,一旦有税率必须跟erp中cust表中的  rto_tax一致,否则会报错无法导入,税率不一致
     * amt金额,amtn未税金额以及税额tax都是根据   qty和up和rtoTax税率    使用公式 计算出来的
     */
    ///////////////////////////////////////////////////////////////////////////////////
    //其实现在要求同一excel必须单号相同
    public Map<String, List> f合并同一单号下货号成分表身备注相同的qty并根据价格数量税率计算amtn_tax_amt(List<ShouDingDanFromExcel> list相同osno, List<Msg> listmsg, Double taxRto来自erp) {
        Map<String, List> map传入service层的介质 = new HashMap();
        List<ShouDingDanFromExcel> list合并后集合入mfPos等 = new ArrayList<>();
        List<List<ShouDingDanFromExcel>> list未合并集合入sapso = new ArrayList<>();
        Set<String> set相同单号货号成分表身备注集合 = this.f货号单号成分表身备注去重后集合(list相同osno);
        //循环所有去重后的货号+成分代码的集合
        for (String s单号加货号加成分加表身备注 : set相同单号货号成分表身备注集合) {
            //循环所有同一单号下的订单,对当前货号+成分代码下的订单合并
            List<ShouDingDanFromExcel> list0相同货号单号成分表身备注下需要合并的对象集合 = this.f根据相同单号货号成分表身备注的合并(s单号加货号加成分加表身备注, list相同osno);
            //收集同一货号+成分代码下的list,这个是收集未合并的,将来用于放入sapso
            list未合并集合入sapso.add(list0相同货号单号成分表身备注下需要合并的对象集合);//用于放入sapso的
            double qty = 0;//数量//只合并这个,其他的用  qty和单价和税率都能算出来
            double amtn = 0;//未税金额
            double tax = 0;//税额
            double amt = 0;//金额合并
            double up = 0;//单价
            qty = this.f合并qty并判断最终qty是否非法(list0相同货号单号成分表身备注下需要合并的对象集合, listmsg);
            //我们只要取到第一个就行了,因为list0里面放入的都是一样的,需要合并的,上面已经把该合并的合并了,下面只要找到其中一个,把合并后的设置进去就好了
            ShouDingDanFromExcel ss将来插入MfPos的对象 = new ShouDingDanFromExcel();
            this.f设置_ss将来插入MfPos的对象_除了amt和amtn和qty和tax和rtoTax的属性(list0相同货号单号成分表身备注下需要合并的对象集合, ss将来插入MfPos的对象);
            //判断excel中税率和系统厂商cust中的税率是否一致
            this.f当excel税率不为空的时候判定税率是否跟erp中cust表的rtoTax相同以及是否非法(ss将来插入MfPos的对象, taxRto来自erp, listmsg);
            ss将来插入MfPos的对象.setTaxRto(String.valueOf(taxRto来自erp<1?taxRto来自erp*100:taxRto来自erp));
            this.f判断excel中单价是否合法(ss将来插入MfPos的对象, up, listmsg);
            up = Double.valueOf(ss将来插入MfPos的对象.getUp());
            amt = up * qty;//数量不是数字的在前面已经判断过了
            ///税率是taxRto
            double taxRtoAdd1 = taxRto来自erp + 1;
            //amtn=amt-amt/1.17*0.17;//后来是1.16
            amtn = amt - amt / taxRtoAdd1 * taxRto来自erp;//taxRto是税率//这种计算可以避免除以0
            //tax=amt/1.17*0.17;
            tax = amt / taxRtoAdd1 * taxRto来自erp;
            ///////////////////////////////////////////////////////////////////////////////////////////
            ss将来插入MfPos的对象.setQty(String.valueOf(qty));
            ss将来插入MfPos的对象.setAmtn(BaoLiuXiaoShu.m3SiSheWuRuBianStr(amtn, 2));
            ss将来插入MfPos的对象.setTax(BaoLiuXiaoShu.m3SiSheWuRuBianStr(tax, 2));
            ss将来插入MfPos的对象.setAmt(BaoLiuXiaoShu.m3SiSheWuRuBianStr(amt, 2));
            list合并后集合入mfPos等.add(ss将来插入MfPos的对象);//合并后放入list//用于合并后放入系统表的
        }
        map传入service层的介质.put(s合并后的list, list合并后集合入mfPos等);//合并后的放入系统表的
        map传入service层的介质.put(s未合并的list, list未合并集合入sapso);//未合并的放入sapso的
        return map传入service层的介质;
    }
    private final String s未合并的list = "samePrdNoList";
    private final String s合并后的list = "samePrdNoMeraged";




    private void controller最终异常(List<Msg> msgs, Exception e) {
        if (p.empty(msgs)) {//此时没有走到数据插入成功那一步并且在service层发生了未知异常,此时listmsg是空的
            //有异常的话肯定不能导入excel的
            msgs = new ArrayList<>();//清空listmsg
            msgs.add(Msg.gmg().setMsg("excel没有插入成功,请仔细检查你的数据").setStatus("0"));
            e.printStackTrace();
        }
    }
    private void f数据库是否已经有重复数据(List<ShouDingDanFromExcel> list3, List<Msg> msgs) {
        //首先进行osNo判断,如果在mf_pos中已经有这个osNo,我们就不再进行下面的save步骤
        MfPosExample mfPosExample = new MfPosExample();
        mfPosExample.createCriteria().andOsNoEqualTo(list3.get(0).getOsNo());
        long l = cnst.mfPosMapper.countByExample(mfPosExample);
        if (l != 0) {
            this.commonThrow(msgs, "重复数据,未能成功插入001---单号" + list3.get(0).getOsNo() + "已经存在于mfPos");
        }
    }

    private Double f通过厂商得到小于1的税率(List<List<ShouDingDanFromExcel>> list1, List<Msg> msgs) {
        //客户代号
        String cusNo = list1.get(0).get(0).getCusNo();
        //找到税率
        Double taxRto = cnst.a001TongYongMapper.getTaxRtoFromCust(cusNo);
        if (taxRto == null) {
            commonThrow(msgs, "该客户《" + cusNo + "》对应的税率在erp《cust》表是空");
        }
        if (taxRto > 1) {
            taxRto = taxRto / 100;
        }
        return taxRto;
    }


    private double f合并qty并判断最终qty是否非法(List<ShouDingDanFromExcel> list0需要合并的对象集合, List<Msg> listmsg) {
        double qty = 0;
        for (ShouDingDanFromExcel ss : list0需要合并的对象集合) {
            if(p.notEmpty(ss.getQty())){
                ss.setQty(ss.getQty().trim().replace(逗号,空字符串));
            }
            try {
                qty += Double.parseDouble(ss.getQty().trim());
            } catch (NumberFormatException e) {
                commonThrow(listmsg, "有qty数量不是数字 " + ss.getOsNo() + "  " + ss.getPrdNo() + " " + ss.getCfdm() + "");
            }
            if (0 == qty) {
                commonThrow(listmsg, "无法导入,有数量为0");
            }
        }
        return qty;
    }

    private void f判断excel中单价是否合法(ShouDingDanFromExcel ss将来插入MfPos的对象, double up, List<Msg> listmsg) {
        try {
            up = Double.valueOf(ss将来插入MfPos的对象.getUp());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            commonThrow(listmsg, "无法导入 有单价不为数字");
        }
        if (up == 0) {
            commonThrow(listmsg, "无法导入 有单价为0");
        }
    }

    private void f当excel税率不为空的时候判定税率是否跟erp中cust表的rtoTax相同以及是否非法(ShouDingDanFromExcel ss将来插入MfPos的对象, Double taxRto来自erp, List<Msg> listmsg) {
        if (p.notEmpty(ss将来插入MfPos的对象.getTaxRto())) {
            Double d = 0D;
            try {
                d = Double.valueOf(ss将来插入MfPos的对象.getTaxRto());
            } catch (Exception e) {
                e.printStackTrace();
                commonThrow(listmsg, "无法导入 税率taxRto不为空且不为数字");
            }


            if (Math.abs(d * 0.01 - taxRto来自erp) > 0.00001) {//相差太大,应该几乎相等的
                commonThrow(listmsg, "无法导入,excel中的税率和系统厂商对应的税率不一致");
            }


        }
    }

    private void f设置_ss将来插入MfPos的对象_除了amt和amtn和qty和tax和rtoTax的属性(List<ShouDingDanFromExcel> list0需要合并的对象集合, ShouDingDanFromExcel ss将来插入MfPos的对象) {
        ShouDingDanFromExcel ss = list0需要合并的对象集合.get(0);
        BeanUtils.copyProperties(ss, ss将来插入MfPos的对象);

    }

    private List<ShouDingDanFromExcel> f根据相同单号货号成分表身备注的合并(String p单号加货号加成分加表身备注, List<ShouDingDanFromExcel> list相同osno) {
        List<ShouDingDanFromExcel> list0需要合并的对象集合 = new ArrayList<>();
        for (ShouDingDanFromExcel ss : list相同osno) {//list3是所有徐勇传过来的excel
            if (p单号加货号加成分加表身备注.equals(ss.getPrdNo().trim() + ss.getCfdm().trim() + ss.getRemBody().trim())) {
                list0需要合并的对象集合.add(ss);//找到同一个货号+成分代码下的所有excel项
            }
        }
        return list0需要合并的对象集合;
    }




    private Set<String> f货号单号成分表身备注去重后集合(List<ShouDingDanFromExcel> list相同osno集合) {
        Set<String> set相同单号货号成分表身备注相加的集合 = new HashSet<>();
        for (ShouDingDanFromExcel ss : list相同osno集合) {
            set相同单号货号成分表身备注相加的集合.add(ss.getPrdNo().trim() + ss.getCfdm().trim() + ss.getRemBody().trim());
        }
        return set相同单号货号成分表身备注相加的集合;
    }


    private void excel里面的单号必须都一样(List<ShouDingDanFromExcel> ss, List<Msg> msgs) {
        TreeSet<ShouDingDanFromExcel> set1 = new TreeSet<>(Comparator.comparing(ShouDingDanFromExcel::getOsNo));
        set1.addAll(ss);
        int size = set1.size();
        if (size == 1) {
            //此时证明里面全部是一个相同单号,去重复后,变成一条记录在set中,此时什么都不用做,继续下一步
        } else {
            this.commonThrow(msgs, "excel里面有不相同的单号,请检查excel并把不同的单号放到不同的excel再导入");
        }
    }

    private void f前端穿过来的数据是否非法_扣税类别之类(List<ShouDingDanFromExcel> ss, List<Msg> msgs) {
        if (p.empty(ss)) {
            commonThrow(msgs, "前端传过来的参数对象为null");
        }

        ////根据saphh来判断是否导错了,  sap里面saphh必须不为空
        if (p.empty(ss.get(0).getSaphh())) {
            commonThrow(msgs, "请不要把标准订单当做sap订单导入《sap行号居然为空》");
        }

        if (p.empty(ss)) {
            String s = "前端传过来的参数对象为null";
            commonThrow(msgs, s);
        }

        for(ShouDingDanFromExcel s:ss){
            this.excel中扣税类别taxId和客户号cusNo不能同时空的(s,msgs);
            this.f检查扣税类别如果没有就从Cust取(s,msgs);
        }


    }

    private void excel中扣税类别taxId和客户号cusNo不能同时空的(ShouDingDanFromExcel s, List<Msg> listmsg) {
        if(p.empty(s.getCusNo())){
            if(p.empty(s.getTaxId())){
                commonThrow(listmsg,"扣税类别taxId和客户代码cusNo不能同时为空,否则无法找到有效的扣税类别");
            }
        }
    }

    private void f检查扣税类别如果没有就从Cust取(ShouDingDanFromExcel s,List<Msg> listmsg) {
        if(p.empty(s.getTaxId())){
            CustWithBLOBs c = cnst.custMapper.selectByPrimaryKey(s.getCusNo());
            if(p.notEmpty(c.getId1Tax())){
                s.setTaxId(c.getId1Tax());
            }else{
                commonThrow(listmsg,"excel中扣税类别是空的,根据excel中的客户代号cusNo也无法找到对应的扣税类别");
            }
        }
    }
    private void commonThrow(List<Msg> msgs, String msgStr) {
        msgs.addAll(new MessageGenerate().generateMessage(msgStr));
        throw new RuntimeException(msgStr);
    }


    private void f刚入接口打印(List<ShouDingDanFromExcel> ss) {
        p.p("-------------------hebing danhao+huohao+chengfen+biaoshenbeizhu  daoru xitong (sap)-------start-----------------------------");
        if (p.notEmpty(ss) && ss.size() < 50) {
            for (ShouDingDanFromExcel s : ss) {
                p.p("---danhao--<" + s.getOsNo() + ">-----huohao--<" + s.getPrdNo() + ">---chengfen---<" + s.getCfdm() + ">--biaoshen beizhu-----<" + s.getRemBody() + ">-----------------------");
            }
        }
        p.p("-------------------hebing danhao+huohao+chengfen+biaoshenbeizhu  daoru xitong (sap)-------end------------------------------------");
    }


    private void f去除空Msg(List<Msg> listmsg) {
        try {
            if (listmsg.size() > 1) {
                for (int i = 0; i < listmsg.size(); i++) {
                    Msg msg1 = listmsg.get(i);
                    if (p.empty(msg1.getMsg())) {
                        listmsg.remove(msg1);
                    }
                }
            }
        } catch (Exception e) {
            l.error(e.getMessage(), e);
            e.printStackTrace();

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean f判断前端传过来的数据是否有问题
    (List<ShouDingDanFromExcel> ss) {
        boolean a = (ss.get(0) == null);
        boolean c = ss.get(0).getOsNo() == null;
        boolean b = p.space.equals(ss.get(0).getOsNo());
        boolean d = p.undefined.equals(ss.get(0).getOsNo());
        boolean e = !a || !c || !b || !d;
        return e;
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public Set<String> set去重单号(List<ShouDingDanFromExcel> ss) {
        Set<String> set = new HashSet();
        for (ShouDingDanFromExcel s : ss) {
            set.add(s.getOsNo().trim());
        }
        return set;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //其实后来要求一个excel里面的单号必须相同,这个规律就放这里,其实没有吊用
    public List<List<ShouDingDanFromExcel>> f按相同单号归类数据(Set<String> set去重后的单号, List<ShouDingDanFromExcel> ss) {
        List<List<ShouDingDanFromExcel>> list1 = new ArrayList();
        //把所有的记录根据单号分成多个单号相同的大类
        for (String str : set去重后的单号) {
            List<ShouDingDanFromExcel> list2 = new ArrayList();
            for (ShouDingDanFromExcel s : ss) {
                if (str.equals(s.getOsNo().trim())) {
                    list2.add(s);
                }
            }
            list1.add(list2);
        }
        return list1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////
    public void f去除多余的成功信息(List<Msg> listmsg, String msg) {
//        try {
        if (listmsg.size() > 1) {
            for (int i = 0; i < listmsg.size(); i++) {
                Msg msg1 = listmsg.get(i);
                if (p.dy(msg, msg1.getMsg())) {
                    listmsg.remove(msg1);
                }
            }


        }

    }




    private final String 逗号=",";
    private final String 空字符串="";
//////////////////////////////////////////////////////////////////////////////////////////////////////////


//    public static void main(String[]args){
//        User user=new User();
//        f(user);
//        System.out.println(user.i);
//        System.out.println(user.s);
//
//    }
//    static void  f(User user){
//        user.i=100;
//        user.s="100";
//    }
////////////////////////////////////////////////////////////////////
}


//class User{
//    double i=0;
//    String s="0";
//}


//class Test{
//    private String str="";
//
//    public String getStr() {
//        return str;
//    }
//
//    public void setStr(String str) {
//        this.str = str;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("com.winwin.picreport.Bcontroller.Test{");
//        sb.append("str='").append(str).append('\'');
//        sb.append('}');
//        return sb.toString();
//    }
//}