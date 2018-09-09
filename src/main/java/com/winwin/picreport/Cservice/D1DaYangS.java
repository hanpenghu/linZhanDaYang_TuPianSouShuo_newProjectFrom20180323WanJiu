package com.winwin.picreport.Cservice;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.dto.AlterPriceRecToFront;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.DateUtils.MakeDate1970Null;
import com.winwin.picreport.Futils.FenYe;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.NotEmpty;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("fenLei")
public class D1DaYangS {

    @Autowired
    private Cnst cnst;
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    private final String 已经采购定价但未销售定价标记 = "yiJingCaiGouDingJiaDanWeiXiaoShouDingJia";
    private final String 不要价格模块="noPriceModel";
    private final String sale = "sale";
    private final String buy = "buy";

    //注意:增加一个request获得参数,所有数据库定价类型分类的参数
    //dingJiaType//传过来"yiJingCaiGouDingJiaDanWeiXiaoShouDingJia"的时候
    //代表 已经采购定价但未销售定价的所有数据
    public FenYe dangqianyeData(FenYe fenYe, String dingJiaType,String ifGetPrice) {
//        p.p("-----------------------------111--------------------------");
        fenYe.setZongJiLuShu(cnst.manyTabSerch.dangYangZongJiLuShu());
//        p.p("-----------------------------222--------------------------");
        fenYe.setZongYeShu();
//        p.p("-----------------------------333--------------------------");
        List<PrdtSamp0> prdtSampList = new ArrayList<>();
//        p.p("-----------------------------444--------------------------");
        List<String> idList = new ArrayList<String>();
//        p.p("-----------------------------555--------------------------");
        ////这种用于显示在: 页面的<销售定价>那一栏
        if (p.dy(已经采购定价但未销售定价标记, dingJiaType)) {
//            p.p("----------------------------666--------------------------");
            idList = this.f已经采购定价并且审核完成但未销售定价的idList(fenYe);
//            p.p("-----------------------------777--------------------------");
        } else {
//            p.p("-----------------------------888--------------------------");
            idList = cnst.manyTabSerch.selectDangQianYeSuoYouId(fenYe.getDangQianYe(), fenYe.getMeiYeXianShiShu());
//            p.p("-----------------------------999--------------------------");
        }
        for (String id : idList) {
//            p.p("-----------------------------101010--------------------------");
            PrdtSamp prdtSampX1 = cnst.prdtSampMapper.selectByPrimaryKey(id);
//            p.p("-----------------------------kkk--------------------------");
            this.mainUnitSet(prdtSampX1);
//            p.p("-----------------------------ooo--------------------------");
            //设置创建时间和价格和修改记录
//            p.p("-----------------------------ifGetPrice="+ifGetPrice+"--------------------------");
//            p.p("-----------------prdtSampX1开始打印--------------------------------------");
//            p.p(prdtSampX1);
//            p.p("-----------------------prdtSampX1结束打印--------------------------------");
            PrdtSamp0 prdtSampX = this.setCreateTimeAndPriceAndAlterRec(prdtSampX1,ifGetPrice);
//            p.p("-----------------------------pppp--------------------------");
            prdtSampList.add(prdtSampX);
//            p.p("-----------------------------zzz-------------------------");
        }
        fenYe.setPrdtSampList(prdtSampList);
//        p.p("-----------------------------ttt--------------------------");
        if (p.dy(已经采购定价但未销售定价标记, dingJiaType)) {
//            p.p("-----------------------------qqq-------------------------");
            this.f设置fenYe的已经采购定价但未销售并且已经审核定价的总记录数(fenYe);
//            p.p("-----------------------------fff--------------------------");
        } else {
//            p.p("-----------------------------ccc--------------------------");
            fenYe.setZongJiLuShu(cnst.manyTabSerch.getCountOfAll());
//            p.p("-----------------------------vvv--------------------------");
            fenYe.setZongYeShu();
//            p.p("----------------------------bbb--------------------------");
        }
//        p.p("-----------------------------nnn--------------------------");
        return fenYe;
    }




    private void mainUnitSet(PrdtSamp prdtSampX1) {
        if(p.empty(prdtSampX1.getMainUnit())){
            String mainUt = cnst.a001TongYongMapper.selectUtByPrdNoFromPrdt(prdtSampX1.getPrdNo());
            prdtSampX1.setMainUnit(mainUt);
            cnst.a001TongYongMapper.updateUt2PrdtSamp(prdtSampX1.getId(),mainUt);
        }
    }





    public PrdtSamp0 setCreateTimeAndPriceAndAlterRec(PrdtSamp prdtSampX1初始,String ifGetPrice) {
//        p.p("-----------------------------a1-------------------------");
        PrdtSamp0 prdtSampX完美 = new PrdtSamp0();
//        p.p("-----------------------------a2-------------------------");
        BeanUtils.copyProperties(prdtSampX1初始, prdtSampX完美);
//        p.p("-----------------------------a3-------------------------");
        Date insertdate = prdtSampX完美.getInsertdate();
//        p.p("-----------------------------a4-------------------------");
        try {
//            p.p("-----------------------------a5-------------------------");
            prdtSampX完美.setInsertdateStr(p.dtoStr(insertdate, p.d2));
//            p.p("-----------------------------a6-------------------------");
            //添加价格模块//经过下一个方法,就会自动赋予一个模块
        } catch (Exception e) {
            //        System.out.println("有一个insertdate无法format成insertdateStr,对应的id是："+id);
        }
        if(p.bdy(不要价格模块,ifGetPrice)){
//            p.p("-----------------------------a7-------------------------");
            //插入价格模块,走一遍这个模块就插入了
            //        cnst.getPriceModelUpdef.GetPriceModel(prdtSampX);

            cnst.getPriceModelUpdef20180512.getPriceModel(prdtSampX完美);
//            p.p("-----------------------------a8-------------------------");
            String prdtSampUuid = prdtSampX完美.getId();
//            p.p("-----------------------------a9-------------------------");
            //插入修改记录
            List<AlterPriceRecToFront> saleAlterRecList = cnst.a001TongYongMapper.selectTop20AlterPriceRec(prdtSampUuid,sale);
//            p.p("-----------------------------a10-------------------------");
            prdtSampX完美.setSaleAlterRecList(saleAlterRecList);
//            p.p("-----------------------------a11-------------------------");
            List<AlterPriceRecToFront> buyAlterRecList = cnst.a001TongYongMapper.selectTop20AlterPriceRec(prdtSampUuid,buy);
//            p.p("-----------------------------a12-------------------------");
            prdtSampX完美.setBuyAlterRecList(buyAlterRecList);
//            p.p("-----------------------------a13-------------------------");
            //处理时间为1970的为NULL
            MakeDate1970Null.make1970null(prdtSampX完美);
//            p.p("-----------------------------a14-------------------------");
        }
        return prdtSampX完美;
    }


    private void f设置fenYe的已经采购定价但未销售并且已经审核定价的总记录数(FenYe fenYe) {
        //手动建立连接
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = p.getCon(cnst.dataSource001IP, cnst.dataSource001PORT, p.dbTypeSqlserver, cnst.Database001Name, cnst.dBUserName, cnst.dBPWd);
            String sql = "Select count(id) from prdt_samp        where    is_check_out='2' and prd_no  in             (                          select a.prd_no from                            (select prd_no from up_def where price_id='2' and olefield LIKE '%SamplesSys%' group by prd_no)a                            where a.prd_no                            not in(select prd_no from up_def where price_id='1' and olefield LIKE '%SamplesSys%' group by prd_no)             )";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int countID = 0;
            while (rs.next()) {
                countID = rs.getInt(1);
            }
            fenYe.setZongJiLuShu(countID);
            fenYe.setZongYeShu();
        } catch (Exception e) {
            e.printStackTrace();
            l.error(e.getMessage(), e);

        }
        p.closeAll(con, ps, rs);
    }


    private List<String> f已经采购定价并且审核完成但未销售定价的idList(FenYe fenYe) {
        List<String> idList = new ArrayList<String>();
        //手动建立连接
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = p.getCon(cnst.dataSource001IP, cnst.dataSource001PORT, p.dbTypeSqlserver, cnst.Database001Name, cnst.dBUserName, cnst.dBPWd);
            String sql = "select top(?)        id        from        PRDT_SAMP  where id not in        (            select top                (                        (?)*((?)-1)                )            id from PRDT_SAMP             where prd_no  in             (                          select a.prd_no from                            (select prd_no from up_def where price_id='2' and olefield LIKE '%SamplesSys%' group by prd_no)a                            where a.prd_no                            not in(select prd_no from up_def where price_id='1' and olefield LIKE '%SamplesSys%' group by prd_no)             )   and is_check_out='2'          ORDER BY insertDate DESC        )         and prd_no  in         (                select a.prd_no from                            (select prd_no from up_def where price_id='2' and olefield LIKE '%SamplesSys%' group by prd_no)a                            where a.prd_no    not in(select prd_no from up_def where price_id='1' and olefield LIKE '%SamplesSys%' group by prd_no)         ) and is_check_out='2'       ORDER BY insertDate DESC";
            ps = con.prepareStatement(sql);

            ps.setInt(1, fenYe.getMeiYeXianShiShu());
            ps.setInt(2, fenYe.getMeiYeXianShiShu());
            ps.setInt(3, fenYe.getDangQianYe());
            rs = ps.executeQuery();

            while (rs.next()) {
                idList.add(rs.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            l.error(e.getMessage(), e);

        }
        p.closeAll(con, ps, rs);
        return idList;
    }


    public List<CategoryNameCode> fenlei() {
        List<CategoryNameCode> categoryNameCodeList = new ArrayList<>();
        List<CategoryName> categoryNameList = cnst.manyTabSerch.fenlei();
        for (CategoryName categoryName : categoryNameList) {
            CategoryNameCode categoryNameCode = new CategoryNameCode();
            categoryNameCode.setIdxName(categoryName.getIdxName()).setIdxNo(categoryName.getIdxNo());
            List<String> codeList = cnst.manyTabSerch.getCodeList(categoryName.getIdxNo());
            categoryNameCode.setPrdCodeList(codeList);
            categoryNameCodeList.add(categoryNameCode);
        }
        return categoryNameCodeList;

    }


    public List<FuZeRen> fuZeRen() {
        List<FuZeRen> fuZeRenList = cnst.manyTabSerch.fuZeRen();
        return fuZeRenList;
    }

    public FenYe daYangZongYeShuHeMeiYeXianShiShu() {
        FenYe fenYe = new FenYe();
        fenYe.setZongJiLuShu(cnst.manyTabSerch.dangYangZongJiLuShu());
        fenYe.setZongYeShu();
        return fenYe;
    }

    /**
     ****************************************************************************************
     * 下面是按层级得到的分类
     * */

    /**
     * 先得到最上级,prdt的
     */

    public CategoryNameCode getCommonderHavePrdt() {
        //其实只有一个元素
        List<CategoryNameCode> commonders = cnst.manyTabSerch.getCommonder();
        if (p.notEmpty(commonders)) {
            CategoryNameCode categoryNameCode = commonders.get(0);
            List<String> codeList = cnst.manyTabSerch.getCodeList(categoryNameCode.getIdxNo());
            categoryNameCode.setPrdCodeList(codeList);
            return categoryNameCode;
        }
        return null;
    }


    /**
     * 先得到最上级,不带prdt的
     */

    public CategoryNameCode getCommonderNoPrdt() {
        //其实只有一个元素
        List<CategoryNameCode> commonders = cnst.manyTabSerch.getCommonder();
        if (p.notEmpty(commonders)) {
            CategoryNameCode categoryNameCode = commonders.get(0);
            return categoryNameCode;
        }
        return null;
    }

    /**
     * 找到某个CategoryNameCode的下级的下级,并封装商品编码(名字)进来
     */

    public CategoryNameCode getChildAndSetCode(CategoryNameCode cnc) {
        //找到所有的下级
        List<CategoryNameCode> ccnc = cnst.manyTabSerch.getChildCategoryNameCodeNoStopDd(cnc.getIdxNo());
        //用一个新的list替换所有下级集合 来 搜集   装好 code的  所有下级
        List<CategoryNameCode> ccncListChild = new ArrayList<>();
        if (p.notEmpty(ccnc)) {
            //给所有的下级添加货品名字
            for (CategoryNameCode c : ccnc) {
                List<String> codeList = cnst.manyTabSerch.getCodeList(c.getIdxNo());
                c.setPrdCodeList(codeList);
                ccncListChild.add(c);
            }
        } else {
            //如果size()==0,就设置为null,要不然就会产生一堆json垃圾
            ccncListChild = null;
        }
        return cnc.setChilds(ccncListChild);
    }


    /**
     * 找到某个CategoryNameCode的下级的下级,并封装商品编码(名字)进来
     */

    public CategoryNameCode getChildAndNotSetCode(CategoryNameCode cnc,String isContainStopDd,String 需要停用时间这个条件) {
        //找到所有的下级
        List<CategoryNameCode> ccnc = null;
        if(需要停用时间这个条件.equals(isContainStopDd)){
            ccnc = cnst.manyTabSerch.getChildCategoryNameCodeHaveStopDd(cnc.getIdxNo());
        }else{
            ccnc = cnst.manyTabSerch.getChildCategoryNameCodeNoStopDd(cnc.getIdxNo());
        }

        //放入所有下级,不再放入商品
        return cnc.setChilds(ccnc);
    }

    /**
     * 得到所有层级,使用递归,得到带商品的
     */

    public CategoryNameCode getAllLayerUtilUseRecursionGetPrdt(CategoryNameCode top) {
        //设置该top的child
        top = this.getChildAndSetCode(top);
        List<CategoryNameCode> childs = top.getChilds();
        if (NotEmpty.notEmpty(childs)) {
            //寻找该childs里面的所有child的childs
            for (CategoryNameCode c : childs) {
                this.getAllLayerUtilUseRecursionGetPrdt(c);
            }
        }
        return top;
    }

    /**
     * 得到所有层级,使用递归,得到不带商品的
     */

    public CategoryNameCode getAllLayerUtilUseRecursionNotGetPrdt(CategoryNameCode top,String isContainStopDd,String 需要停用时间这个条件) {
        //设置该top的child
        top = this.getChildAndNotSetCode(top,isContainStopDd,需要停用时间这个条件);
        List<CategoryNameCode> childs = top.getChilds();
        if (p.notEmpty(childs)) {
            //寻找该childs里面的所有child的childs
            for (CategoryNameCode c : childs) {
                this.getAllLayerUtilUseRecursionNotGetPrdt(c,isContainStopDd,需要停用时间这个条件);
            }
        }
        return top;
    }

    /**
     * 实现所有层级
     */

    public CategoryNameCode getAllLayerAndAllPrdt() {
        return this.getAllLayerUtilUseRecursionGetPrdt(this.getCommonderHavePrdt());


    }


    public CategoryNameCode getAllLayerNotHavePrdt(String isContainStopDd,String 需要停用时间这个条件) {
        Date date = new Date();
        CategoryNameCode allLayerUtilUseRecursionNotGetPrdt =
                this.getAllLayerUtilUseRecursionNotGetPrdt(this.getCommonderNoPrdt(), isContainStopDd, 需要停用时间这个条件);



        return allLayerUtilUseRecursionNotGetPrdt;


    }


    public List<Msg> insertDaYang(PrdtSamp prdtSamp) {
        Integer ii = null;
        List<Msg> list;
        try {
            ii = cnst.prdtSampMapper.insert(prdtSamp);
        } catch (Exception e) {
            return MessageGenerate.generateMessage
                    ("保存失败", "保存失败",
                            "数据库系统级别错误", "", "38");
        }
        list = new MessageGenerate().generateMessage
                ("" + ii + "", "产品打样新增" + ii + "条数据",
                        "产品打样新增" + ii + "条数据", "", "37");
        return list;
    }


}


















//    select top(100)        id        from        PRDT_SAMP  where id not in
//
//(
//        select top  ((100)*((100)-1))  id from PRDT_SAMP   where prd_no  in
//
//        (
//        select a.prd_no from (select prd_no from up_def where price_id='2' and olefield LIKE '%SamplesSys%' group by prd_no)a
//        where a.prd_no
//        not in(select prd_no from up_def where price_id='1' and olefield LIKE '%SamplesSys%' group by prd_no)
//        )  and is_check_out='2'
//
//        ORDER BY insertDate DESC
//
//
//        )         and prd_no  in
//
//        (
//
//        select a.prd_no from
//
//        (select prd_no from up_def where price_id='2' and olefield LIKE '%SamplesSys%' group by prd_no)a
//
//        where a.prd_no    not in(select prd_no from up_def where price_id='1' and olefield LIKE '%SamplesSys%' group by prd_no)
//
//        )   and is_check_out='2'
//
//        ORDER BY insertDate DESC