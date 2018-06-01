package com.winwin.picreport.Bcontroller.xiaoShouDingDanDaoRuDaoChuExcel;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.MfPosExample;
import com.winwin.picreport.Edto.ShouDingDanFromExcel;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
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
/**
 *导入excel,销售订单,上面那个A1ReportRestControllerEXCELUpLoad是sap导入的,比这个复杂
 * */
public class XiaoShouDingDanExcelDaoRuXiTong_notMerage {

    @Autowired
    private Cnst cnst;

    /////////////////////////////////////////////////////////////////////////////////////////////
//前端没有任何参数传         [{}]         受订单号成功后是SO//注释掉暂时不用
    @RequestMapping(value = InterFaceCnst.upLoadExcelDontMerageOfSaleOrder,
            method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    List<Msg>
    shouDingDanExcelToTable(@RequestBody List<ShouDingDanFromExcel> shouDingDanFromExcels) {

        this.打印当前对象(shouDingDanFromExcels);


        List<Msg> listmsg = new ArrayList<>();
//    long time01=new Date().getTime();
        try {

            //////////////////////////同一个excel中订单号检查必须一样的模块////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //检查shouDingDanFromExcels里面的osno订单号是否统一 一样,不一样不行
            //根据osNo订单号去重复//这里单单是为了看是否是统一单号
            TreeSet<ShouDingDanFromExcel> set1 = new TreeSet<ShouDingDanFromExcel>(Comparator.comparing(ShouDingDanFromExcel::getOsNo));
            set1.addAll(shouDingDanFromExcels);
            int size = set1.size();
//        p.p(p.gp().sad(p.dexhx).sad("去重复后的长度是:").sad(p.strValeOfNullSpace(size)).sad(p.dexhx).gad());
            if (size == 1) {
                //此时证明里面全部是一个相同单号,去重复后,变成一条记录在set中,此时什么都不用做,继续下一步
//            p.p(p.gp().sad(p.dexhx).sad("所有单号一样,可以继续下一步").sad(p.dexhx).gad());
            } else {
                String s = "excel里面有不相同的单号,请检查excel并把不同的单号放到不同的excel再导入！";
                //此时证明有2个以上不同单号,需要提示 客户,同一个excel中必须只能有一个osno
                listmsg.addAll(new MessageGenerate().generateMessage(s));
                throw new RuntimeException(s);

            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            Msg msg = new Msg();
            if (this.判断前端传过来的数据是否有问题(shouDingDanFromExcels)) {
                //guo lv suo you bu chong fu de osNo//分离出所有不相同的订单号
                Set<String> set = this.分类去重复订单号到Set集合(shouDingDanFromExcels);
                List<List<ShouDingDanFromExcel>> list1 = this.按订单号分类后的2个集合放入一个集合(set, shouDingDanFromExcels);
                //按批号分批插入数据库,一个批号下的不成功都不成功在service成实现，listmsg暗传输msg错误信息
                this.按订单号分类后向Service传入数据(list1, listmsg);
                msg.setMsg("数据插入成功");
            } else {
                msg.setMsg("第一条数据就没有OsNo(订单号),拒绝所有操作,检查您的数据信息再次插入");
            }
            //把当前的msg放入将要返回给前端的集合
            listmsg.add(msg);
            //如果msg列表中有2个及2个以上,说明数据没有完全插入成功,就把那个数据插入成功的message删掉
            if (listmsg.size() > 1) {
                this.去除多余的SuccessMsg(listmsg, "数据插入成功");
                this.quChuKongDeMsg(listmsg);//如果Msg中的字段msg是"",那么久去除这一条数据
            }

        } catch (Exception e) {
            if (p.empty(listmsg)) {//此时没有走到数据插入成功那一步并且在service层发生了未知异常,此时listmsg是空的
                //有异常的话肯定不能导入excel的
                listmsg = new ArrayList<>();//清空listmsg
                listmsg.add(Msg.gmg().setMsg("excel没有插入成功,请仔细检查你的数据"));
                e.printStackTrace();
            }

            l.error(e.getMessage(), e);
        }

        ////////////////////////////////////////////////////////////////////////
        return listmsg;
////////////////////////////////
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

    public Set<String> 分类去重复订单号到Set集合(List<ShouDingDanFromExcel> shouDingDanFromExcels) {
        Set<String> set = new HashSet();

        for (ShouDingDanFromExcel shouDingDanFromExcel : shouDingDanFromExcels) {
            set.add(shouDingDanFromExcel.getOsNo().trim());
        }
        return set;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public List<List<ShouDingDanFromExcel>> 按订单号分类后的2个集合放入一个集合(Set<String> set, List<ShouDingDanFromExcel> shouDingDanFromExcels) {
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

    ////////////////////////////////////////////////////////////////////////////////////////
    public void 按订单号分类后向Service传入数据(List<List<ShouDingDanFromExcel>> list1, List<Msg> listmsg) {
        for (List<ShouDingDanFromExcel> list3 : list1) {

            //首先进行osNo判断,如果在mf_pos中已经有这个osNo,我们就不再进行下面的save步骤
            MfPosExample mfPosExample = new MfPosExample();
            mfPosExample.createCriteria().andOsNoEqualTo(list3.get(0).getOsNo());
            long l = cnst.mfPosMapper.countByExample(mfPosExample);
            /**
             *判断excel的单号在数据库是否存在,存在就不插入
             * */
            if (l == 0) {//此时数据库没有这个单号,我们开始进行接下来的save//如果有的话就不要再save了
                //for一次就是处理同一批号osNo一次
                Map<String, List> listMap =
                        this.合并同一订单号下面货号相同的qty_amtn_tax_amt
                                (list3, listmsg);

                /**
                 *插入数据到数据库
                 * */
                this.cnst.commonDaoRuDBZhiQianZhengLi.saveYiPiDingDanHaoXiangTongDe(listMap, listmsg, "notSap");
            } else {
//                    listmsg.addAll(new MessageGenerate().generateMessage("重复数据,未能成功插入,重复的单号为“"+list3.get(0).getOsNo()+"”"));
                listmsg.addAll(new MessageGenerate().generateMessage("重复数据,未能成功插入"));
                return;//此时停止循环所有单号
            }
        }
    }

    //////////////////////////由于这个单子不合并了,所以这里删除了合并的代码,但是继续沿用这个方法而已/////////////////////////////////////////////////////////
    public Map<String, List> 合并同一订单号下面货号相同的qty_amtn_tax_amt(List<ShouDingDanFromExcel> list3, List<Msg> listmsg) {
        Map<String, List> map = new HashMap();
        //老郑让这个玩意不用合并了,所以,放入同一个东西
        map.put("samePrdNoMeraged", list3);
        map.put("samePrdNoList", null);//不用了
        return map;
    }

    /////////////////////////////////////////////////////////////////////////////
    public void 去除多余的SuccessMsg(List<Msg> listmsg, String msg) {
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


    public void 打印当前对象(List<ShouDingDanFromExcel> shouDingDanFromExcels) {
        try {
            if (p.notEmpty(shouDingDanFromExcels)) {
                if (shouDingDanFromExcels.size() < 50) {
                    p.p("-------------------------------------------------------");
                    p.p(JSON.toJSONString(shouDingDanFromExcels));
                    p.p("-------------------------------------------------------");
                }
            }
        } catch (Exception e) {
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////
}
/////////////////////////////////////////////////////////////////////////////////////////////

