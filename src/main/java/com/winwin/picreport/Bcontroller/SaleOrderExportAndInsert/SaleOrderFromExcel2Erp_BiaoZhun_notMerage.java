package com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.CustWithBLOBs;
import com.winwin.picreport.Edto.MfPosExample;
import com.winwin.picreport.Edto.ShouDingDanFromExcel;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.BaoLiuXiaoShu;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
/**
 *导入excel,销售订单,上面那个A1ReportRestControllerEXCELUpLoad是sap导入的,比这个复杂
 * */
public class SaleOrderFromExcel2Erp_BiaoZhun_notMerage {

    @Autowired
    private Cnst cnst;

    /**
     select up,amt,amtn,tax,tax_rto,qty,* from tf_pos where os_no='EBNEK18004JY20561'
     select * from tf_pos_z where os_no='EBNEK18004JY20561'
     select * from mf_pos where os_no='EBNEK18004JY20561'


     delete from tf_pos where os_no='EBNEK18004JY20561'
     delete from tf_pos_z where os_no='EBNEK18004JY20561'
     delete from mf_pos where os_no='EBNEK18004JY20561'
     * */


    /**
     *添加一个接口,判断销售定价是否小于库中up_def中对应的定价
     *
     * {"row":"1","prdNo":"prd_no","up":"0.18","osDd":"2018-07-27 10:37:31.757"}
     * */


    @RequestMapping(value="checkSalePrice",method=RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public @ResponseBody Msg f(@RequestBody List<IfSalePriceSamllEntity> i){
        List<String>msg=new LinkedList<String>();
        IfSalePriceSamllEntityFlag ie=new IfSalePriceSamllEntityFlag();
        try {
            this.igll(i,msg);
            i=this.checkSalePrice(i,msg);
            if(p.notEmpty(i)){
                //有颜色需要标记
                ie.setFlag(p.s0);
                ie.setStates(i);
            }
        } catch (Exception e) {
            String s=e.getMessage();
            if(msg.contains(s)){
                return Msg.gmg().setStatus("0").setMsg(s);
            }else{
                return Msg.gmg().setStatus("0").setMsg("未知异常《"+s+"》");
            }
        }
        return Msg.gmg().setStatus("1").setMsg("成功").setObj(ie);
    }

    private List<IfSalePriceSamllEntity> checkSalePrice(List<IfSalePriceSamllEntity> ii, List<String> msg) {
        int size = ii.size();
        List<IfSalePriceSamllEntity>list=new ArrayList<IfSalePriceSamllEntity>();
        for(int k=0;k<size;k++){
            IfSalePriceSamllEntity i = ii.get(k);
            this.stateGet(i);
            //徐勇要求是0的状态是正常,不用返回过去,只是把不正常的返回过去
            if(p.bdy(i.getState(),p.s0))list.add(i);
        }
        return list;
    }

    private void stateGet(IfSalePriceSamllEntity e) {
        UpDefExample ue=new UpDefExample();
        ue.createCriteria().andPrdNoEqualTo(e.getPrdNo());
        long l = cnst.upDefMapper.countByExample(ue);
        //2   货号在up_def不存在  蓝色背景(没有对应价格就是蓝色,  2和3都显示蓝色)
        if(l==0){e.setState(Cnst.salePriceColorOfNoPrdNo);return;}
        UpDefExample ue1=new UpDefExample();
        ue1.createCriteria().andPrdNoEqualTo(e.getPrdNo()).andPriceIdEqualTo(Cnst.salPriceId).andCurIdEqualTo(e.getCurId()).andBilTypeEqualTo(e.getBilType()).andUpIsNotNull();
        long l1 = cnst.upDefMapper.countByExample(ue1);
        //3   该币别该运费的销售定价在up_def不存在
        if(l1==0){e.setState(Cnst.salePriceColorOfNoThisCurIdAndBilType);return;}
        //找到符合条件的该币别该销售的低于up_def的价格
       int k= cnst.a001TongYongMapper.countPriceOfSmallThenUpdef(e.getOsDd(),e.getPrdNo(),Cnst.salPriceId,p.b(e.getUp()),e.getCurId(),e.getBilType(),e.getQty());
        //1    此时是  1  紫色背景   //对比 up_def,有单价低于销售定价的行,紫色背景 代号 1
        if(k>0)e.setState(Cnst.salePriceColorOfSmall);
    }

    private void igll(List<IfSalePriceSamllEntity> ii, List<String> msg) {
        p.p("--------------------p.p(ii);-----------------------------------");
        p.p(ii);
        p.p("-------------------------------------------------------");
        if(p.empty(ii))p.throwEAddToList("前端传过来的数组是空的",msg);

        for(IfSalePriceSamllEntity i:ii){

            if(p.empty(i.getBilType())){
                p.throwEAddToList("前端穿过来的运费代号是空,应该是"+Cnst.saleBilTypeNoTrans+"(无运费)"+Cnst.saleBilTypeHaveTrans+"(含运费)其中之一",msg);
            }
            if(p.bdy(Cnst.saleBilTypeHaveTrans,i.getBilType())&&p.bdy(Cnst.saleBilTypeNoTrans,i.getBilType())){
                p.throwEAddToList("前端传过来的bilType既不是"+Cnst.saleBilTypeHaveTrans+"也不是"+Cnst.saleBilTypeNoTrans,msg);
            }

            p.p("-------------------------------------------------------");
            p.p(i.getUp());
            p.p("----i.getUp()="+i.getUp()+"-----------p.isBd(i.getUp())==false------"+p.isBd(i.getUp())+"----------------------------------");

            p.p("-------------------xxx------------------------------------");

            if(!p.isBd(i.getUp()))p.throwEAddToList("第《"+(p.isBd(i.getRow())?p.badd(i.getRow(),1):"")+"》行单价不是数字",msg);

            if(p.empty(i.getRow()))p.throwEAddToList("前端传过来的行号有空的",msg);
            if(p.empty(i.getPrdNo())){
                this.prdNoSet(i);
                if(p.empty(i.getPrdNo())){
                    p.throwEAddToList("Excel第《"+(p.isBd(i.getRow())?p.badd(i.getRow(),2):"")+"》行货号是【空】的,根据【货品名称】和【客户代码+对方货号】在erp也找不到对应的 货号 ! ",msg);
                }
            }
            if(p.empty(i.getOsDd()))p.throwEAddToList("第《"+(p.isBd(i.getRow())?p.badd(i.getRow(),2):"")+"》行订单日期为空,",msg);
            if(p.isNotDate(i.getOsDd()))p.throwEAddToList("第《"+(p.isBd(i.getRow())?p.badd(i.getRow(),2):"")+"》行订单日期格式不对,",msg);

        }
    }




    //得到货号
    public void prdNoSet(IfSalePriceSamllEntity s) {

        try {
            //在使用货号之前如果是空的,先流水一下货号
            if (p.empty(s.getPrdNo())) {
                String prdNo = cnst.a001TongYongMapper.getPrdNoUsePrdName(s.getPrdName());
                if (p.empty(prdNo)) {
                    this.useOppPrdNoGetPrdNo(s);
                }else {
                    s.setPrdNo(prdNo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //根据对方货号和客户代码获得货号
    private void useOppPrdNoGetPrdNo(IfSalePriceSamllEntity s) {
        /**
         * 3）	标准订单的导入格式里加一列对方品号（最好列次序不要固定，识别列名就可以）。
         如果excel有品号按照品号，如果excel里无品号，有客户代码，
         对方品号，按同时符合这两个条件的查出品号select
         prd_no  from prdt_cus1 where  cus_no=客户代码 and sup_prd_no=对方品号
         * */
        try {
            if(p.empty(s.getPrdNo())){
                String prdNo=cnst.a001TongYongMapper.getPrdNoUseCus_noAndSup_prd_noFromPrdt_cus1(s.getCusNo(),s.getDuiFangPrdNo());
                if(p.notEmpty(prdNo)){
                    s.setPrdNo(prdNo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*    select amt,amtn,tax,tax_rto,up,qty,prd_no,*from tf_pos where os_no='EBNEK18004JY2056X'
        select*from tf_pos_z where os_no='EBNEK18004JY2056X'
        select*from mf_pos where os_no='EBNEK18004JY2056X'
        select * from sapso where osno='EBNEK18004JY2056X'




        delete from tf_pos where os_no='EBNEK18004JY2056X'
        delete from tf_pos_z where os_no='EBNEK18004JY2056X'
        delete from mf_pos where os_no='EBNEK18004JY2056X'
        delete  from sapso where osno='EBNEK18004JY2056X'*/
    /////////////////////////////////////////////////////////////////////////////////////////////
//前端没有任何参数传         [{}]         受订单号成功后是SO//注释掉暂时不用
    @RequestMapping(value = "upLoadExcelDontMerageOfSaleOrder", method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody List<Msg> shouDingDanExcelToTable(@RequestBody List<ShouDingDanFromExcel> sss) {
        this.打印当前对象(sss);
        List<Msg> listmsg = new ArrayList<>();
        try {
            this.isPriceIgll(sss,listmsg);
            this.f检查excel里面订单号是否都一样(sss,listmsg);
            this.f前端穿过来的数据是否非法_扣税类别之类(sss,listmsg);
            Msg msg = new Msg();
            if (this.判断前端传过来的数据是否有问题(sss)) {
                Set<String> set = this.分类去重复订单号到Set集合(sss);
                List<List<ShouDingDanFromExcel>> list1 = this.按订单号分类后的2个集合放入一个集合(set,sss);

                //按批号分批插入数据库,一个批号下的不成功都不成功在service成实现，listmsg暗传输msg错误信息
                this.按订单号分类后向Service传入数据(list1, listmsg);
                msg.setMsg("数据插入成功").setStatus("1");
            } else {
                msg.setMsg("第一条数据就没有OsNo(订单号),拒绝所有操作,检查您的数据信息再次插入").setStatus("0");
            }
            //把当前的msg放入将要返回给前端的集合
            listmsg.add(msg);
            this.listmsg去重复(listmsg);
        } catch (Exception e) {
            this.f最终异常(listmsg, e);
        }

        ////////////////////////////////////////////////////////////////////////
        return listmsg;
////////////////////////////////
    }

    private void isPriceIgll(List<ShouDingDanFromExcel> sss, List<Msg> listmsg) {
        if(p.empty(sss))this.commonThrow(listmsg,"前端传过来的数组是空的");
        int i=1;//出去表头第2行开始是excel的数据
        for(ShouDingDanFromExcel s:sss){
            if(p.empty(s.getUp()))this.commonThrow(listmsg,"在第《"+i+"》行有单价为空的; ");
//            if(p.empty(s.getPrdNo()))this.commonThrow(listmsg,"在第《"+i+"》行有货号为空的; ");
            i=i+1;
        }



    }


    //////////////////////////////其实这个方法已经多余了,因为后期一个excel里面的单号限制了必须相同//////////////////////////////////////////////////////////
    public void 按订单号分类后向Service传入数据(List<List<ShouDingDanFromExcel>> list1, List<Msg> listmsg) {
        //list1的长度其实是1了,后期限制了多单号同一个excel上传
        double 来自erp的税率 = this.f得到税率并判断是否合法(list1, listmsg);
        for (List<ShouDingDanFromExcel> list3同一单号集合 : list1) {
            this.f单号是否在erp已经存在(listmsg, list3同一单号集合);
            //for一次就是处理同一批号osNo一次//其实这个普通订单已经取消合并,但是这个方法是复制sap合并的
            Map<String, List> listMap = this.f计算amtn_tax_amt(list3同一单号集合, listmsg, 来自erp的税率);
            /**
             *插入数据到数据库
             * */
            this.cnst.commonDaoRuDBZhiQianZhengLi.saveYiPiDingDanHaoXiangTongDe(listMap, listmsg, "notSap");
        }
    }




    /**
     select up,amt,amtn,tax,tax_rto,qty,* from tf_pos where os_no='EBNEK18004JY20561'
     select * from tf_pos_z where os_no='EBNEK18004JY20561'
     select * from mf_pos where os_no='EBNEK18004JY20561'


     delete from tf_pos where os_no='EBNEK18004JY20561'
     delete from tf_pos_z where os_no='EBNEK18004JY20561'
     delete from mf_pos where os_no='EBNEK18004JY20561'
     * */


    //////////////////////////由于这个单子不合并了,所以这里删除了合并的代码,但是继续沿用这个方法而已/////////////////////////////////////////////////////////
    public Map<String, List> f计算amtn_tax_amt(List<ShouDingDanFromExcel> list3同一单号集合, List<Msg> listmsg, Double taxRto) {
        Map<String, List> map = new HashMap();
        //计算各种税额
        for (ShouDingDanFromExcel s : list3同一单号集合) {

            this.f判断excel中税率是否合法(s, listmsg, taxRto);
            double qty = 0;//数量
            double amtn = 0;//未税金额
            double tax = 0;//税额
            double amt = 0;//金额合并
            double up = 0;//单价
            qty = this.f计算qty并验证是否非法(s, listmsg);
            up = this.f计算up并验证是否非法(s, listmsg);
            /**
             * 2018_6_7   weekday(4)   16:42:20    by winston
             *订单导入税率这样处理：
             * 1.如果表格里有税额，就按表格里的税额，税率取这个客户cust.rto_tax
             * 2.如果表格里没有税额，原来计算税额按0.17现在按cust.rto_tax*0.01，税率取这个客户cust.rto_tax
             * */

            s.setTaxRto(String.valueOf(taxRto<1?taxRto*100:taxRto));
            amt = up * qty;//数量不是数字的在前面已经判断过了
            ///税率,
            double taxRtoAdd1 = taxRto + 1;
            //            amtn=amt-amt/1.17*0.17;
//            amtn = amt - amt / taxRtoAdd1 * taxRto;//taxRto是税率

            //2018_9_17   weekday(1)   14:53:22
//            金额amt：如果来源Excel该列不为空取Excel，如果为空=数量X单价；
            //原来 amtn = amt - amt / taxRtoAdd1 * taxRto;//taxRto是税率
//            现在2018_9_17   weekday(1)   15:31:02  未税金额amtn：如果来源Excel该列不为空取Excel，如果为空=数量X单价X汇率-ROUND( (数量X单价X汇率/(1+这个客户cust.rto_tax*0.01)*cust.rto_tax*0.01), 2)；
            amtn=this.newAmtnCalculateAndExcRtoSet(amt,s,listmsg,taxRtoAdd1,taxRto);//设置amtn并且设置汇率excRto
            //            tax=amt/1.17*0.17;
            tax = amt / taxRtoAdd1 * taxRto;
            this.isMoneyIgll(listmsg,s);//必须放在下面三句话前面,因为这里事先判断设置了结果金额
            s.setAmtn(p.notEmpty(s.getAmtn())?BaoLiuXiaoShu.m3SiSheWuRuBianStr(new Double(s.getAmtn()),2):BaoLiuXiaoShu.m3SiSheWuRuBianStr(amtn, 2));
            s.setTax(p.notEmpty(s.getTax())?BaoLiuXiaoShu.m3SiSheWuRuBianStr(new Double(s.getTax()),2):BaoLiuXiaoShu.m3SiSheWuRuBianStr(tax, 2));
            s.setAmt(p.notEmpty(s.getAmt())?BaoLiuXiaoShu.m3SiSheWuRuBianStr(new Double(s.getAmt()),2):BaoLiuXiaoShu.m3SiSheWuRuBianStr(amt, 2));

            p.p("--------------------汇率-----------------------------------");
            p.p(s.getExcRto());
            p.p("-------------------------------------------------------");
        }

        //老郑让这个玩意不用合并了,所以,放入同一个东西
        map.put("samePrdNoMeraged", list3同一单号集合);
        map.put("samePrdNoList", null);//不用了
        return map;
    }

    private double newAmtnCalculateAndExcRtoSet(double amt, ShouDingDanFromExcel s, List<Msg> listmsg, double taxRtoAdd1, Double taxRto) {
        s.setExcRto(s.getExcRto()==null?null:s.getExcRto().replace(" ","").replace(",",""));//设置汇率
        if(p.notEmpty(s.getExcRto())&&!p.isBigDecimal(s.getExcRto())){
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入,excel中有汇率excRto不为空且汇率不是数字 《后端已经去除空格和千分符》"));
            p.throwE("无法导入,excel中有汇率excRto不为空且汇率不是数字 《后端已经去除空格和千分符》");
        }
        //汇率默认为1,是1的意思就是人民币,不进行美元和人民币 的转换
        double excRto=1;
        if(p.notEmpty(s.getExcRto())){
            excRto=new Double(s.getExcRto());
        }else{
            //excRto为空的时候默认为人民币不转换,excRto=1
            s.setExcRto("1");
        }
        //原来 amtn = amt - amt / taxRtoAdd1 * taxRto;//taxRto是税率
        // 现在2018_9_17   weekday(1)   15:31:02           未税金额amtn：如果来源Excel该列不为空取Excel，如果为空=数量X单价X汇率-ROUND( (数量X单价X汇率/(1+这个客户cust.rto_tax*0.01)*cust.rto_tax*0.01), 2)；
       //注意,我这里的数值已经乘过0.01
        return amt*excRto-(amt*excRto/taxRtoAdd1*taxRto);
    }

    private void isMoneyIgll(List<Msg> listmsg, ShouDingDanFromExcel s) {
        s.setAmt(s.getAmt()==null?null:s.getAmt().replace(" ","").replace(",",""));
        s.setAmtn(s.getAmtn()==null?null:s.getAmtn().replace(" ","").replace(",",""));
        s.setTax(s.getTax()==null?null:s.getTax().replace(" ","").replace(",",""));
        if(p.notEmpty(s.getAmt())){
            if(!p.isBigDecimal(s.getAmt())){
                listmsg.addAll(new MessageGenerate().generateMessage("无法导入,excel中有金额amt不为空且金额不是数字《后端已经去除空格和千分符》"));
                p.throwE("无法导入,excel中有金额amt不为空且金额不是数字");
            }
        }
        if(p.notEmpty(s.getAmtn())){
            if(!p.isBigDecimal(s.getAmtn())){
                listmsg.addAll(new MessageGenerate().generateMessage("无法导入,excel中有未税金额amtn不为空且未税金额不是数字《后端已经去除空格和千分符》"));
                p.throwE("无法导入,excel中有未税金额amtn不为空且未税金额不是数字");
            }
        }
        if(p.notEmpty(s.getTax())){
            if(!p.isBigDecimal(s.getTax())){
                listmsg.addAll(new MessageGenerate().generateMessage("无法导入,excel中有税额tax不为空且税额不是数字《后端已经去除空格和千分符》"));
                p.throwE("无法导入,excel中有税额tax不为空且税额不是数字");
            }
        }
    }

    private double f计算up并验证是否非法(ShouDingDanFromExcel s, List<Msg> listmsg) {
        double up = 0;
        try {
            up = Double.valueOf(s.getUp());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有单价不为数字"));
            p.throwE("无法导入 有单价不为数字");
        }
        if (up == 0) {
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有单价为0"));
            p.throwE("无法导入 有单价为0");
        }
        return up;
    }

    private double f计算qty并验证是否非法(ShouDingDanFromExcel s, List<Msg> listmsg) {
        if(p.notEmpty(s.getQty())){
            s.setQty(s.getQty().trim().replace(",",""));
        }else{
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有数量不是数字"));
            p.throwE("无法导入 有数量不是数字");
        }
        double qty = 0;
        try {
            qty = Double.valueOf(s.getQty());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有数量不是数字"));
            p.throwE("无法导入 有数量不是数字");
        }
        if (0 == qty) {
            listmsg.addAll(new MessageGenerate().generateMessage("无法导入 有数量为0"));
            p.throwE("无法导入 有数量为0");
        }
        return qty;
    }

    private void f判断excel中税率是否合法(ShouDingDanFromExcel s, List<Msg> listmsg, Double taxRto) {
        //判断excel中税率和系统厂商cust中的税率是否一致
        if (p.notEmpty(s.getTaxRto())) {
            Double d = 0D;
            try {
                d = Double.valueOf(s.getTaxRto());
            } catch (Exception e) {
                e.printStackTrace();
                String ss = "无法导入,excel中有税率taxRto不为空且不为数字,如果不需要税率请设置为空";
                listmsg.addAll(new MessageGenerate().generateMessage(ss));
                p.throwE(ss);
            }
            if(d!=0&&d>=1){d=d*0.01;}
            if (Math.abs(d - taxRto) > 0.00001) {//意思是相差太大
                String ss = "无法导入,excel中的税率和系统厂商对应的税率不一致";
                listmsg.addAll(new MessageGenerate().generateMessage(ss));
                p.throwE(ss);
            }


        }
    }


    private void f单号是否在erp已经存在(List<Msg> listmsg, List<ShouDingDanFromExcel> list3同一单号集合) {
        //首先进行osNo判断,如果在mf_pos中已经有这个osNo,我们就不再进行下面的save步骤
        MfPosExample mfPosExample = new MfPosExample();
        mfPosExample.createCriteria().andOsNoEqualTo(list3同一单号集合.get(0).getOsNo());
        long l = cnst.mfPosMapper.countByExample(mfPosExample);
        /**
         *判断excel的单号在数据库是否存在,存在就不插入
         * */
        if (l != 0) {//此时数据库没有这个单号,我们开始进行接下来的save//如果有的话就不要再save了
            listmsg.addAll(new MessageGenerate().generateMessage("erp已经存在该单号"));
            return;//此时停止循环所有单号
        }
    }


    private double f得到税率并判断是否合法(List<List<ShouDingDanFromExcel>> list1, List<Msg> listmsg) {
        //客户代号
        String cusNo = list1.get(0).get(0).getCusNo();
        //找到税率
        Double taxRto = cnst.a001TongYongMapper.getTaxRtoFromCust(cusNo);

        if (taxRto == null) {
            String s = "该客户《" + cusNo + "》对应的税率在erp《cust》表是空";
            listmsg.addAll(new MessageGenerate().generateMessage(s));
            throw new RuntimeException(s);
        }

        if (taxRto > 1) {
            taxRto = taxRto / 100;
        }
        return taxRto;
    }


    private Set<String> 分类去重复订单号到Set集合(List<ShouDingDanFromExcel> ss) {
        Set<String> set = new HashSet();
        for (ShouDingDanFromExcel s : ss) {
            set.add(s.getOsNo().trim());
        }
        return set;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    private List<List<ShouDingDanFromExcel>> 按订单号分类后的2个集合放入一个集合(Set<String> set, List<ShouDingDanFromExcel> shouDingDanFromExcels) {
        List<List<ShouDingDanFromExcel>> list1 = new ArrayList();
        //把所有的记录根据单号分成2大类
        for (String str : set) {
            List<ShouDingDanFromExcel> list2 = new ArrayList();
            for (ShouDingDanFromExcel ss : shouDingDanFromExcels) {
                if (str.equals(ss.getOsNo().trim())) {
                    list2.add(ss);
                }
            }
            list1.add(list2);
        }
        return list1;
    }


    private void f最终异常(List<Msg> listmsg, Exception e) {
        //此时没有走到数据插入成功那一步并且在service层发生了未知异常,此时listmsg是空的
        if (p.empty(listmsg)) {
            //有异常的话肯定不能导入excel的
            listmsg = new ArrayList<>();//清空listmsg
            listmsg.add(Msg.gmg().setMsg("excel没有插入成功,请仔细检查你的数据").setStatus("0"));
            e.printStackTrace();
        }
        l.error(e.getMessage(), e);
    }

    private void listmsg去重复(List<Msg> listmsg) {
        if (listmsg.size() > 1) {
            this.去除多余的SuccessMsg(listmsg, "数据插入成功");
            this.quChuKongDeMsg(listmsg);//如果Msg中的字段msg是"",那么久去除这一条数据
        }
    }

    private void f检查excel里面订单号是否都一样(List<ShouDingDanFromExcel> shouDingDanFromExcels, List<Msg> listmsg) {
        TreeSet<ShouDingDanFromExcel> set去重 = new TreeSet<ShouDingDanFromExcel>(Comparator.comparing(ShouDingDanFromExcel::getOsNo));
        set去重.addAll(shouDingDanFromExcels);
        if (set去重.size() != 1) {
            String s = "excel里面有不相同的单号,请检查excel并把不同的单号放到不同的excel再导入！";
            this.commonThrow(listmsg, s);
        }
    }

    private void f前端穿过来的数据是否非法_扣税类别之类(List<ShouDingDanFromExcel> ss, List<Msg> listmsg) {
        if (p.empty(ss)) {
            String s = "前端传过来的参数对象为null";
            commonThrow(listmsg, s);
        }
        //根据saphh来判断是否导错了,  sap里面saphh必须不为空
        if (p.notEmpty(ss.get(0).getSaphh())) {
            String s = "请不要把sap订单当做标准订单导入《sap行号居然不为空》";
            commonThrow(listmsg, s);
        }
        for(ShouDingDanFromExcel s:ss){
            this.excel中扣税类别taxId和客户号cusNo不能同时空的(s,listmsg);
            this.f检查扣税类别如果没有就从Cust取(s,listmsg);
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


    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());

    private void quChuKongDeMsg(List<Msg> listmsg) {

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
            e.printStackTrace();
        }


    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean 判断前端传过来的数据是否有问题(List<ShouDingDanFromExcel> shouDingDanFromExcels) {
        boolean a = (shouDingDanFromExcels.get(0) == null);
        boolean c = shouDingDanFromExcels.get(0).getOsNo() == null;
        boolean b = "".equals(shouDingDanFromExcels.get(0).getOsNo());
        boolean d = "undefined".equals(shouDingDanFromExcels.get(0).getOsNo());
        boolean e = !a || !c || !b || !d;
        return e;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    private void 去除多余的SuccessMsg(List<Msg> listmsg, String msg) {
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
//////////////////////////////////////////////////////////////////


    private void 打印当前对象(List<ShouDingDanFromExcel> shouDingDanFromExcels) {
        try {
            if (p.notEmpty(shouDingDanFromExcels)) {
                if (shouDingDanFromExcels.size() < 50) {
                    p.p("-------------------------------------------------------");
                    p.p(shouDingDanFromExcels);
                    p.p("-------------------------------------------------------");
                }
            }
        } catch (Exception e) {
        }
    }

    private void commonThrow(List<Msg> msgs, String msgStr) {
        msgs.addAll(new MessageGenerate().generateMessage(msgStr));
        throw new RuntimeException(msgStr);
    }

///////////////////////////////////////////////////////////////////////////////////////////////
}
/////////////////////////////////////////////////////////////////////////////////////////////

/*
 这是前端传过来的数据
 [
                ShouDingDanFromExcel{wh='1000', osDd='1535385600000',
                estDd='1535385600000', taxId='', osNo='18LZ0164NEGCP',
                cusOsNo='', saphh='', remhead='', sapph='', prdNo='', sapwlm='', cfdm='N',
                prdName='WW-NEBML-NEC', curId='RMB', excRto='1', qty='234', unit='Pcs', up='0.15',
                amtn='30', tax='5.1', amt='35.1', taxRto='16', remBody='', cusNo='C002', caiGouNo='',
                maiTouNo='', ebNo='', luoHao='', gangHao='', realWidth='', realLength='', salNo='001',
                duiFangPrdNo='BRZ002269', bilType='null'}
                ]*/
