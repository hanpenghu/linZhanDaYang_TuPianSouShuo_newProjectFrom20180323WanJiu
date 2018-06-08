package com.winwin.picreport.Bcontroller.xiaoShouDingDanDaoRuDaoChuExcel;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.MfPosExample;
import com.winwin.picreport.Edto.ShouDingDanFromExcel;
import com.winwin.picreport.Futils.*;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.pp;
import com.winwin.picreport.Futils.hanhan.stra;
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
/**
 *导入excel
 * */
public class SapXiaoShouDingDanExcelDaoRuXiTong {
    private  org.apache.log4j.Logger l = pp.getLogger(this);

    @Autowired
    private Cnst cnst;
/////////////////////////////////////////////////////////////////////////////////////////////
//前端没有任何参数传         [{}]         受订单号成功后是SO
@RequestMapping(value="shouDingDanExcelToTable",
        method= RequestMethod.POST,produces = {p.charsetUtf8})
public @ResponseBody List<Msg>
shouDingDanExcelToTable(@RequestBody List<ShouDingDanFromExcel> shouDingDanFromExcels){



    p.p("-------------------hebing danhao+huohao+chengfen+biaoshenbeizhu  daoru xitong (sap)-------start-----------------------------");
    if(p.notEmpty(shouDingDanFromExcels)&&shouDingDanFromExcels.size()<50){
        for(ShouDingDanFromExcel s:shouDingDanFromExcels){
            p.p("---danhao--<"+s.getOsNo()+">-----huohao--<"+s.getPrdNo()+">---chengfen---<"+s.getCfdm()+">--biaoshen beizhu-----<"+s.getRemBody()+">-----------------------");
        }
    }
    p.p("-------------------hebing danhao+huohao+chengfen+biaoshenbeizhu  daoru xitong (sap)-------end------------------------------------");

    Date date = p.getDate();

//    p.p(date);


    List<Msg> listmsg=new ArrayList<>();

    try {

        if(p.empty(shouDingDanFromExcels)){
            String s="前端传过来的参数对象为null";
            listmsg.addAll (new MessageGenerate().generateMessage(s));
            throw new RuntimeException(s);
        }

        ////根据saphh来判断是否导错了,  sap里面saphh必须不为空
        if(p.empty(shouDingDanFromExcels.get(0).getSaphh())){
            String s="请不要把标准订单当做sap订单导入《sap行号居然为空》";
            listmsg.addAll (new MessageGenerate().generateMessage(s));
            throw new RuntimeException(s);
        }

        //////////////////////////同一个excel中订单号检查必须一样的模块////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //检查shouDingDanFromExcels里面的osno订单号是否统一 一样,不一样不行
        //根据osNo订单号去重复//这里单单是为了看是否是统一单号
        TreeSet<ShouDingDanFromExcel> set1 = new TreeSet<>(Comparator.comparing(ShouDingDanFromExcel::getOsNo));
        set1.addAll(shouDingDanFromExcels);
        int size = set1.size();

        if(size ==1){
            //此时证明里面全部是一个相同单号,去重复后,变成一条记录在set中,此时什么都不用做,继续下一步
        }else{
            String s="excel里面有不相同的单号,请检查excel并把不同的单号放到不同的excel再导入";
            //此时证明有2个以上不同单号,需要提示 客户,同一个excel中必须只能有一个osno
            listmsg.addAll (new MessageGenerate().generateMessage(s));

            throw new RuntimeException(s);

        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





        Msg msg=new Msg();
        if(this.panDuanQianDuanChuanGuoLaiDeShuJuShiFouYouWenTi(shouDingDanFromExcels)){
            //guo lv suo you bu chong fu de osNo//分离出所有不相同的订单号
            Set<String> set = this.fenLeiQuChongFuDingDanHaoDaoSetJiHe
                    (shouDingDanFromExcels);
            List<List<ShouDingDanFromExcel>> list1=this
                    .anDingDanHaoFenLeiHouDe2GeJiHeFangRuYiGeJiHe
                    (set, shouDingDanFromExcels);
            //按批号分批插入数据库,一个批号下的不成功都不成功在service成实现，listmsg暗传输msg错误信息
            this.f按订单号分类后向ServiceCengChuanShuJu(list1,listmsg);
            msg.setMsg("数据插入成功");
        }else{ msg.setMsg("第一条数据就没有OsNo(订单号),拒绝所有操作,检查您的数据信息再次插入");}
        //把当前的msg放入将要返回给前端的集合
        listmsg.add(msg);
        //如果msg列表中有2个及2个以上,说明数据没有完全插入成功,就把那个数据插入成功的message删掉
        this.quChuDuoYuDeSuccessMsg(listmsg,"数据插入成功");
        this.quChuKongDeMsg(listmsg);//如果Msg中的字段msg是"",那么久去除这一条数据
    } catch (Exception e) {

        if(p.empty(listmsg)){//此时没有走到数据插入成功那一步并且在service层发生了未知异常,此时listmsg是空的
            //有异常的话肯定不能导入excel的
            listmsg=new ArrayList<>();//清空listmsg
            listmsg.add(Msg.gmg().setMsg("excel没有插入成功,请仔细检查你的数据"));
            e.printStackTrace();
        }
    }




    String sssss=stra.b()
            .a(p.dexhx)
            .a("sap销售订单导入时间")
            .a(p.dexhx)
            .a(p.huanHangfu)
            .a(p.strValeOfSpace(p.xjs(p.getDate(),date)))
            .a(p.huanHangfu).a(p.cexhx).a(p.huanHangfu).g();
    l.error(sssss);

//    p.p("---------------sap销售订单导入时间----------------------------------------");
//    p.p(p.xjs(p.getDate(),date));
//    p.p("-------------------------------------------------------");

    ////////////////////////////////////////////////////////////////////////
    return listmsg;
////////////////////////////////
}


 private void quChuKongDeMsg(List<Msg> listmsg) {
        try {
            if(listmsg.size()>1){
                for(int i=0;i<listmsg.size();i++){
                    Msg msg1 = listmsg.get(i);
                    if(p.empty(msg1.getMsg())){
                        listmsg.remove(msg1);
                    }
                }
            }
        } catch (Exception e) {
            l.error(e.getMessage(),e);
            e.printStackTrace();

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean panDuanQianDuanChuanGuoLaiDeShuJuShiFouYouWenTi
        (List<ShouDingDanFromExcel> shouDingDanFromExcels){
        boolean a=(shouDingDanFromExcels.get(0)==null);
        boolean c=shouDingDanFromExcels.get(0).getOsNo()==null;
        boolean b = p.space.equals(shouDingDanFromExcels.get(0).getOsNo());
        boolean d = p.undefined.equals(shouDingDanFromExcels.get(0).getOsNo());
        boolean e=!a||!c||!b||!d;
        return e;
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public Set<String> fenLeiQuChongFuDingDanHaoDaoSetJiHe
                (List<ShouDingDanFromExcel> shouDingDanFromExcels){
        Set<String> set=new HashSet();

        for(ShouDingDanFromExcel shouDingDanFromExcel:shouDingDanFromExcels){
            set.add(shouDingDanFromExcel.getOsNo().trim());
        }
        return set;
    }
 //////////////////////////////////////////////////////////////////////////////////////////////
 public List<List<ShouDingDanFromExcel>> anDingDanHaoFenLeiHouDe2GeJiHeFangRuYiGeJiHe(Set<String> set,List<ShouDingDanFromExcel> shouDingDanFromExcels){
     List<List<ShouDingDanFromExcel>> list1=new ArrayList();
     //把所有的记录根据单号分成多个单号相同的大类
     for(String str:set){
         List<ShouDingDanFromExcel> list2=new ArrayList();
         for(ShouDingDanFromExcel ss:shouDingDanFromExcels){
             if(str.equals(ss.getOsNo().trim())){
                 list2.add(ss);
             }
         }
         list1.add(list2);
     }
     return list1;
 }
 ////////////////////////////////////////////////////////////////////////////////////////
    /**
     *数据库插入数据
     * */
    public void f按订单号分类后向ServiceCengChuanShuJu(List<List<ShouDingDanFromExcel>> list1, List<Msg> listmsg){
        //客户代号
        String cusNo = list1.get(0).get(0).getCusNo();
        //找到税率
        Double taxRto=cnst.a001TongYongMapper.getTaxRtoFromCust(cusNo);
        if(taxRto==null||taxRto==0){
            String s="该客户《"+cusNo+"》对应的税率在erp《cust》表是空";
            listmsg.addAll(new MessageGenerate().generateMessage(s));
            throw new RuntimeException(s);
        }

        for(List<ShouDingDanFromExcel> list3:list1){
//            try {
                //首先进行osNo判断,如果在mf_pos中已经有这个osNo,我们就不再进行下面的save步骤
                MfPosExample mfPosExample=new MfPosExample();
                mfPosExample.createCriteria().andOsNoEqualTo(list3.get(0).getOsNo());
                long l = cnst.mfPosMapper.countByExample(mfPosExample);
                if(l==0){//此时数据库没有这个单号,我们开始进行接下来的save//如果有的话就不要再save了
                    //for一次就是处理同一批号osNo一次
                    Map<String, List> listMap =
                            this.f合并同一订单下面货号相同的_qty_amtn_tax_amt
                                    (list3,listmsg, taxRto);
                    /**
                     *数据库插入数据
                     * */
                    cnst.commonDaoRuDBZhiQianZhengLi.saveYiPiDingDanHaoXiangTongDe(listMap,listmsg,"sap");
                }else{
//                    listmsg.addAll(new MessageGenerate().generateMessage("重复数据,未能成功插入,重复的单号为“"+list3.get(0).getOsNo()+"”"));
                    listmsg.addAll(new MessageGenerate().generateMessage("重复数据,未能成功插入001---单号"+list3.get(0).getOsNo()+"已经存在于mfPos"));
                    return;//此时停止循环所有单号
                }

        }
    }
///////////////////////////////////////////////////////////////////////////////////
    public Map<String,List> f合并同一订单下面货号相同的_qty_amtn_tax_amt(List<ShouDingDanFromExcel> list3, List<Msg> listmsg, Double taxRto){
        Map<String,List>map=new HashMap();
        //用list00来装入合并同一货号的几个东西后的ShouDingDanFromExcel
        List<ShouDingDanFromExcel> list=new ArrayList<>();
        //收集同一货号的list
        List<List<ShouDingDanFromExcel>>samePrdNoList=new ArrayList<>();

        //注意:传进来的list3已经是同一订单号下面了
        //去重所有相同的(货号+成分代码)的组合放入set集合,因为同一订单下,货号+成分代码一起相同才能合并
        /**
         *2018_5_30   weekday(3)   10:19:16
         * by winston, 原来是  单号+货号+成分代码才能合并
         * 现在变为   单号+货号+成分代码+表身备注  一样才能合并
         * */
        Set<String>prdNoAndCfdmSet =new HashSet<>();
        for(ShouDingDanFromExcel shouDingDanFromExcel:list3){
            prdNoAndCfdmSet.add
                    (shouDingDanFromExcel.getPrdNo().trim()
                            +shouDingDanFromExcel.getCfdm().trim()
                            +shouDingDanFromExcel.getRemBody().trim());
        }

//         p.p(p.gp().sad(p.dexhx).sad(prdNoAndCfdmSet.toString()).sad(p.dexhx).gad());

        //循环所有去重后的货号+成分代码的集合,因为去重后导入主表的就只有去重后这么多了
        for(String prdNoAndCfdm:prdNoAndCfdmSet){
            //循环所有同一单号下的订单,对当前货号+成分代码下的订单合并
            List<ShouDingDanFromExcel>list0=new ArrayList<>();
            for(ShouDingDanFromExcel shouDingDanFromExcel:list3){//list3是所有徐勇传过来的excel
                if(prdNoAndCfdm.equals(
                        shouDingDanFromExcel.getPrdNo().trim()
                        +shouDingDanFromExcel.getCfdm().trim()
                        +shouDingDanFromExcel.getRemBody().trim()
                )){
                    list0.add(shouDingDanFromExcel);//找到同一个货号+成分代码下的所有excel项
                }
            }
                ///list0存的其实是当前 (货号+成分代码)相同 下的所有excel数据,需要合并,但是没有合并
            //这个算法的精妙之处在于,循环(货号+成分代码),然后一边用samePrdNoList收集没有合并的excel,一边合并list0中的数据放入list,最后
            //samePrdNoList进入主表//list进入sapso记录所有没有合并之前的数据

            //收集同一货号+成分代码下的list,这个是收集未合并的,将来用于放入sapso

            samePrdNoList.add(list0);//用于放入sapso的

                double qty=0;//数量
                double amtn=0;//未税金额
                double tax=0;//税额
                double amt=0;//金额合并

//                double danJia=0;//当时想错了,单价不能合并,有 数量 有单价 有 就能计算其他的金额,
                for(ShouDingDanFromExcel shouDingDanFromExcel:list0){
                    try {qty+=Double.parseDouble(shouDingDanFromExcel.getQty().trim());} catch (NumberFormatException e) {listmsg.addAll(new MessageGenerate().generateMessage("有qty数量不是数字  "+shouDingDanFromExcel.getOsNo()+"   "+shouDingDanFromExcel.getPrdNo()+"    "+shouDingDanFromExcel.getCfdm()+""));throw new RuntimeException(e);}
                    try {amtn+=Double.parseDouble(shouDingDanFromExcel.getAmtn().trim());} catch (NumberFormatException e) {listmsg.addAll(new MessageGenerate().generateMessage("有amtn未税金额不是数字"+shouDingDanFromExcel.getOsNo()+"   "+shouDingDanFromExcel.getPrdNo()+"    "+shouDingDanFromExcel.getCfdm()+""));throw new RuntimeException(e);}
                    try {tax+=Double.parseDouble(shouDingDanFromExcel.getTax().trim());} catch (NumberFormatException e) {listmsg.addAll(new MessageGenerate().generateMessage("有tax税额不是数字"+shouDingDanFromExcel.getOsNo()+"   "+shouDingDanFromExcel.getPrdNo()+"    "+shouDingDanFromExcel.getCfdm()+""));throw new RuntimeException(e);}
                    try {amt+=Double.parseDouble(shouDingDanFromExcel.getAmt().trim());} catch (NumberFormatException e) {listmsg.addAll(new MessageGenerate().generateMessage("有amt金额不是数字"+shouDingDanFromExcel.getOsNo()+"   "+shouDingDanFromExcel.getPrdNo()+"    "+shouDingDanFromExcel.getCfdm()+""));throw new RuntimeException(e);}
//                    try {danJia+=Double.parseDouble(shouDingDanFromExcel.getUp());} catch (NumberFormatException e) {e.printStackTrace();}
                }


                if(0==qty){
                    listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有数量为0"));
                    p.throwE("无法导入 有数量为0");
                }





                if(list0.size()>0) {
                    //我们只要取到第一个就行了,因为list0里面放入的都是一样的,需要合并的,上面已经把该合并的合并了,下面只要找到其中一个,把合并后的设置进去就好了
                    ShouDingDanFromExcel shouDingDanFromExcel=new ShouDingDanFromExcel();

                    ShouDingDanFromExcel shouDingDanFromExcel1 = list0.get(0);

                    BeanUtils.copyProperties(shouDingDanFromExcel1,shouDingDanFromExcel);

                    //判断excel中税率和系统厂商cust中的税率是否一致
                    if(p.notEmpty(shouDingDanFromExcel.getTaxRto())){
                        Double d=0D;
                        try {
                            d=Double.valueOf(shouDingDanFromExcel.getTaxRto());
                        } catch (Exception e) {
                            e.printStackTrace();
                            listmsg.addAll(new MessageGenerate().generateMessage("无法导入,税率taxRto不为空且不为数字,如果不需要税率请设置为空"));
                            p.throwE("无法导入 税率taxRto不为空且不为数字");
                        }finally{}
                        if(d<0.00001){
                            String ss="无法导入,税率不能为0,请设置为空后使用erp厂商税率";
                            listmsg.addAll(new MessageGenerate().generateMessage(ss));
                            p.throwE(ss);
                        }

                        if(d>1){
                            String ss="税率不能大于1,请除以100";
                            listmsg.addAll(new MessageGenerate().generateMessage(ss));
                            p.throwE(ss);
                        }

                        if(Math.abs(d*0.01-taxRto)>0.00001){//相差太大,应该几乎相等的
                            String ss="无法导入,excel中的税率和系统厂商对应的税率不一致";
                            listmsg.addAll(new MessageGenerate().generateMessage(ss));
                            p.throwE(ss);
                        }


                    }




                    double up=0;//单价
                    try {
                        qty = Double.valueOf(shouDingDanFromExcel.getQty());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        listmsg.addAll(new MessageGenerate().generateMessage("无法导入, 有数量不是数字"));
                        p.throwE("无法导入 有数量不是数字");
                    }
                    if(0==qty){
                        listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有数量为0"));
                        p.throwE("无法导入 有数量为0");
                    }
                    try {up = Double.valueOf(shouDingDanFromExcel.getUp());} catch (NumberFormatException e) {
                        e.printStackTrace();
                        listmsg.addAll(new MessageGenerate().generateMessage("无法导入, 有单价不为数字"));
                        p.throwE("无法导入 有单价不为数字");
                    }
                    if(up==0){
                        listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有单价为0"));
                        p.throwE("无法导入 有单价为0");
                    }





                    /**
                     * 2018_6_7   weekday(4)   16:42:20    by winston
                     *订单导入税率这样处理：
                     * 1.如果表格里有税额，就按表格里的税额，税率取这个客户cust.rto_tax
                     * 2.如果表格里没有税额，原来计算税额按0.17现在按cust.rto_tax*0.01，税率取这个客户cust.rto_tax
                     * */
                    shouDingDanFromExcel.setTaxRto(String.valueOf(taxRto*0.01));

                    ////////////////////2017-11-23郑总让加/////////////////////////////////////////////////////////////////////////
//                    AmtAndAmtnAndTaxChongXinSuan.f(amt,amtn,tax,qty,shouDingDanFromExcel,shouDingDanFromExcel.getTaxRto(),listmsg);//在类内部进行判断计算各种金额



                    try {up = Double.valueOf(shouDingDanFromExcel.getUp());} catch (NumberFormatException e) {
                        e.printStackTrace();
                        String ss="无法导入,,有单价不为数字";
                        listmsg.addAll(new MessageGenerate().generateMessage(ss));
                        p.throwE(ss);
                    }
                    if(up==0){
                        String ss="无法导入 有单价为0";
                        listmsg.addAll(new MessageGenerate().generateMessage(ss));
                        p.throwE(ss);
                    }

                    if(amt==0){
                        amt=up*qty;//数量不是数字的在前面已经判断过了
                    }
                    ///税率,
                    double taxRtoAdd1=taxRto+1;
                    if(amtn==0){
//            amtn=amt-amt/1.17*0.17;
                        amtn=amt-amt/taxRtoAdd1*taxRto;//taxRto是税率//这种计算可以避免除以0
                        if(amtn<0){amtn=0D;}
                    }
                    if(tax==0){
//            tax=amt/1.17*0.17;
                        tax=amt/taxRtoAdd1*taxRto;

                    }





                    ///////////////////////////////////////////////////////////////////////////////////////////
                    shouDingDanFromExcel.setQty(String.valueOf(qty));
                    shouDingDanFromExcel.setAmtn(BaoLiuXiaoShu.m3SiSheWuRuBianStr(amtn,2));
                    shouDingDanFromExcel.setTax(BaoLiuXiaoShu.m3SiSheWuRuBianStr(tax,2));
                    shouDingDanFromExcel.setAmt(BaoLiuXiaoShu.m3SiSheWuRuBianStr(amt,2));
//                    shouDingDanFromExcel.setUp(String.valueOf(danJia));
                    list.add(shouDingDanFromExcel);//合并后放入list//用于合并后放入系统表的
                }
        }

        map.put("samePrdNoMeraged",list);//合并后的放入系统表的
        map.put("samePrdNoList",samePrdNoList);//未合并的放入sapso的

        return  map;
    }
/////////////////////////////////////////////////////////////////////////////
    public void quChuDuoYuDeSuccessMsg(List<Msg> listmsg,String msg){
//        try {
            if(listmsg.size()>1){
                for(int i=0;i<listmsg.size();i++){
                    Msg msg1 = listmsg.get(i);
                    if(p.dy(msg,msg1.getMsg())){
                        listmsg.remove(msg1);
                    }
                }


            }

    }
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