package com.winwin.picreport.Bcontroller.daYang.manyConditionSearch;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.PrdtSamp1;
import com.winwin.picreport.Futils.FenYe;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class ManyConditionSearchOfPrdtSamp {
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private Cnst cnst;
    //传过来这个默认不要价格模块,不传默认要加个模块
    private final static String 不要价格模块="noPriceModel";

    private final static String 启动特殊查询="yes";

    /**
     *根据条件查询产品编码建档
     * sql
     * chanPinBianMaJianDangTiaoJianChaXun
     * 此接口时间默认传时间戳(str格式)
     * //此接口已经用了动态sql,当不传入isConfirm 参数的时候,相当于查询所有符合条件的信息
     * 当传入isConfirm参数是0的时候,会查询所有未打样的符合条件的信息
     * ifGetPrice="noPriceModel"表示不要价格模块
     * ifSpecificSearch=yes 表示特殊查询(老郑让符合编码规律的查询,在sql里做, 现在只有产品编码建档立用这个),传过来这个yes就是说需要特殊查询

     *
     * */
    @RequestMapping(value= "chanPinBianMaJianDangTiaoJianChaXun", method = RequestMethod.POST)
    public @ResponseBody FenYe f(@RequestBody FenYe fenYe,
                                 @RequestParam(value="ifGetPrice",required =false)String ifGetPrice,
                                 @RequestParam(value="ifSpecificSearch",required =false)String ifSpecificSearch

    ){
        log.info("-----chanPinBianMaJianDangTiaoJianChaXun  jieKou----ifGetPirce PARAM:----{}------",ifGetPrice);
        if(fenYe==null){
            FenYe f=new FenYe();
            ArrayList<PrdtSamp0> prdtSamps = new ArrayList<>();
            f.setPrdtSampList(prdtSamps);
            return f;
        }else{
            try {
                return  this.manyConditionSearchOfPrdtFiltList(fenYe,ifGetPrice,ifSpecificSearch);
            } catch (IllegalAccessException e) {
                FenYe f1=new FenYe();
                ArrayList<PrdtSamp0> prdtSamps1 = new ArrayList<>();
                f1.setPrdtSampList(prdtSamps1);
                return f1;
            }
        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *多条件产品打样列表
     * */
    private FenYe manyConditionSearchOfPrdtFiltList(FenYe f,String ifGetPrice,String ifSpecificSearch) throws IllegalAccessException {
        PrdtSamp1 p1 = f.getPrdtSamp1();
        boolean b = this.conditionOnlyPrdCode(p1);
        log.info("~~~~~jieKou :chanPinBianMaJianDangTiaoJianChaXun~~~~~~~~~~~~zhuanHuanQianDuoTiaoJianChaXun TEST~~~~~start~~~~qianDuanChuanGuoLaiDe condition: {}~~~~~~~~~~~~~~~",p1);
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

        log.info("~~~~~jieKou :chanPinBianMaJianDangTiaoJianChaXun~~~~~~~~~~~~zhuanHuanHouDuoTiaoJianChaXun TEST~~~~~start~~~~qianDuanChuanGuoLaiDe condition: {}~~~~~~~~~~~~~~~",p1);



        List<PrdtSamp0> prdtSampListOrg;
        //此时是带编码的查询, 要设置特定规则(根据编码规则),所以单走一直
        //带编码的查询起初是insertdate排序,后来被改为prdCode排序,所以我这里走一分支,再后来,
        //又恢复insertdate排序,但是要按照(编码规则)查询,
        if(b){
            //由于老郑规定产品编码建档的使用该规则,其他模块的不使用改规则,经过
            //我测试,徐勇只有"产品编码建档"里面把ifGetPrice传过来参数"noPriceModel"了,我
            //暂时拿该参数当做产品编码建档的标记,如果以后还有传过来  noPriceModel的模块,肯定
            //要换另外一个标记, 因为老郑只是规定产品编码建档查询适合他说的编码规则,其他模块保持不变
            //2018_9_6   weekday(4)   17:50:14  又改成特殊的 标记,不管哪个模块, 只要传过来这个 yes,就 启动特殊查询
            if(p.dy(ifSpecificSearch,启动特殊查询)){
                prdtSampListOrg=cnst.a001TongYongMapper.chanPinBianMaJianDangTiaoJianChaXunPrdCodeDESC(p1);
                f.setZongJiLuShu(cnst.a001TongYongMapper.getCountOfDuoTiaoJianChaXunZongJiLuShuaSpecific(p1));
            }else{
                prdtSampListOrg=cnst.a001TongYongMapper.chanPinBianMaJianDangTiaoJianChaXun(p1);
                f.setZongJiLuShu(cnst.a001TongYongMapper.getCountOfDuoTiaoJianChaXunZongJiLuShu(p1));
            }
        }else{
            prdtSampListOrg=cnst.a001TongYongMapper.chanPinBianMaJianDangTiaoJianChaXun(p1);
            f.setZongJiLuShu(cnst.a001TongYongMapper.getCountOfDuoTiaoJianChaXunZongJiLuShu(p1));
        }



        List<PrdtSamp0> prdtSampList= new  ArrayList<>();
        if(p.bdy(不要价格模块,ifGetPrice)){
            if(p.notEmpty(prdtSampListOrg)){
                for(PrdtSamp0 prdtSamp0:prdtSampListOrg){
                    //插入价格模块,走一遍这个模块就插入了
//                cnst.getPriceModelUpdef.GetPriceModel(prdtSamp0);
                    cnst.getPriceModelUpdef20180512.getPriceModel(prdtSamp0);
                    prdtSampList.add(prdtSamp0);
                }
            }
        }else{
            //此时不要价格模块
            prdtSampList.addAll(prdtSampListOrg);
        }



//        p.p(p.zhifgf);
//        p.p(prdtSampList);
//        p.p(p.zhifgf);



//        p.p(prdtSampList);
        f.setPrdtSampList(prdtSampList);
        //我在这个方法中顺便调了setZongYeShu()方法
//        f.setZongJiLuShu(cnst.a001TongYongMapper.getCountOfDuoTiaoJianChaXunZongJiLuShu(p1));
        return f;


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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////