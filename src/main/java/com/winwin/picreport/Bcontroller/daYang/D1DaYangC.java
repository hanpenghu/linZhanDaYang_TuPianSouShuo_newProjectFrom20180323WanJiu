package com.winwin.picreport.Bcontroller.daYang;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.*;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/d")
public class D1DaYangC {
    @Autowired
    private Cnst cnst;
    /**
 *delete 一条数据库信息并delete对应的图片和附件资源
 * 支持一次多删除
 * */
@RequestMapping(value = "deleteSomeRecode", method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
public @ResponseBody List<Msg> deleteSomeRecode(@RequestBody List<String>uuidList) {
    return cnst.deleteSome.deleteSomeRecode(uuidList);
}




    /**
     *分类实行层级制,这个已经被拦截器放行了     /d/allfenleitest
     * */

//    @RequestMapping(value = "allfenleitest", method = RequestMethod.GET, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody CategoryNameCode allfenleitest() {
//        return cnst.fenLei.getAllLayer();
//    }

    @RequestMapping(value = "allfenleiHavePrdt", method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody CategoryNameCode allfenleiHavePrdt() {
        return cnst.fenLei.getAllLayerAndAllPrdt();


    }



    @RequestMapping(value = InterFaceCnst.allfenlei, method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody CategoryNameCode allfenlei() {
        return cnst.fenLei.getAllLayerNotHavePrdt();
    }

    /**
     *得到当前分类的所有商品
     * 传参数{"idxName":"idxNo"}
     * 我传给前端的是加了  private List<String> prdCodeList=new ArrayList<>();    之后的CategoryNameCode
     * */
    @RequestMapping(value = InterFaceCnst.currentCategoryPrdtList, method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody CategoryNameCode currentCategoryPrdtList
    (@RequestBody CategoryNameCode categoryNameCode) {
        List<String> codeList=cnst.manyTabSerch.getCodeList(categoryNameCode.getIdxNo());
        return categoryNameCode.setPrdCodeList(codeList);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = InterFaceCnst.fenlei, method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    List<CategoryNameCode> fenlei() {
        List<CategoryNameCode> categoryNameCodeList = cnst.fenLei.fenlei();
        return categoryNameCodeList;
    }
//
//    @RequestMapping(value = "fenleitest", method = RequestMethod.GET, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody
//    List<CategoryNameCode> fenleitest() {
//        List<CategoryNameCode> categoryNameCodeList = cnst.fenLei.fenlei();
//        return categoryNameCodeList;
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = InterFaceCnst.fuZeRen, method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    List<FuZeRen> fuZeRen() {
        List<FuZeRen> fuZeRenList = cnst.fenLei.fuZeRen();
        return fuZeRenList;
    }

//    @RequestMapping(value = "fuZeRentest", method = RequestMethod.GET, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody
//    List<FuZeRen> fuZeRentest() {
//        List<FuZeRen> fuZeRenList = cnst.fenLei.fuZeRen();
//        return fuZeRenList;
//    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = InterFaceCnst.pinPai, method = RequestMethod.POST,
            produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody
    List<PinPai> pinPai() {
        List<PinPai> fuZeRenList = cnst.manyTabSerch.pinPai();
        return fuZeRenList;
    }


//    @RequestMapping(value = "pinPaitest", method = RequestMethod.GET, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody
//    List<PinPai> pinPaitest() {
//        List<PinPai> fuZeRenList = cnst.manyTabSerch.pinPai();
//        return fuZeRenList;
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /////////////////////////////////////////////list///////////////////////////////////////////////////////
//    @RequestMapping(value = "insertDaYang", method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody
//    List<Msg> insertDaYang(@RequestBody PrdtSamp prdtSamp) {
////        List<Msg> list=fenLei.insertDaYang(prdtSamp);
//        return MessageGenerate.generateMessage("该接口已经废弃,请调用新的接口   imageUpLoadAndDataSave");
//    }
///////////////////////////////////////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *得到所有打样已确认的单子的所有页,参数只要传过来当前页就行了
     * //默认每页显示数10
     * */

    @RequestMapping(value =InterFaceCnst.alReadyConfirmOrderPage,
            method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody FenYe alReadyConfirmOrderPage(@RequestBody FenYe fenYe) {
        return cnst.dco.alReadyConfirmOrderPage(fenYe);

    }





    /**
     *得到所有打样未确认的单子第某页,这个不只是能得到第一页,还能得到很多页
     *物流管理里面的 样品确认模块
     *
     * http://61.177.44.218:8070/d/notConfirmOrderFirstPage?token=MTUyMDM5OTQ1MTM2N3t-fWlwYWNle359MTM2NDE5Mjg3NDE=
     *
     * 请求参数
     *{"dangQianYe":"1","meiYeXianShiShu":"10"}
     *
     *   /d/notConfirmOrderFirstPage
     *
     * */
    @RequestMapping(value = InterFaceCnst.notConfirmOrderFirstPage,method = RequestMethod.POST)
    public @ResponseBody FenYe notConfirmOrderFirstPage(@RequestBody FenYe fenYe) {
//        p.p("-------------------------------------------------------");
//        p.p("----------接口/d/notConfirmOrderFirstPage被调用--------");
//        p.p("----------这个接口是为了得到未打样当前页的数据---------");
//        p.p("-------------------------------------------------------");
        return cnst.dco.notConfirmOrderFirstPage(fenYe);


    }




    /**
     *确认单子  isconfirm变为1
     *
     * 47 打样确认成功 isconfirm=1

     48 打样确认 没成功 isconfirm=0
      确认订单的时候如果要穿  附件,请调用编辑信息的那个接口
     imageUpLoadAndDataSave_InfoEdit_ManyAttach
     注意调这个编辑接口的时候必须把原来的信息再传一遍,否则会更改信息
     * */
    @RequestMapping(value = InterFaceCnst.confirmTheOrder,
            method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody List<Msg> confirmTheOrder(@RequestBody PrdtSamp prdtSamp) {
        return cnst.dco.confirmTheOrder(prdtSamp);



    }


    /**
     *批量确认   /d/confirmTheOrderBatch
     * */
    @RequestMapping(value = "confirmTheOrderBatch",
            method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
    public @ResponseBody Msg confirmTheOrderBatch(@RequestBody List<PrdtSamp> prdtSampList) {
        List<String>ms=new LinkedList<String>();
        try {
            cnst.dco.confirmTheOrderBatch(prdtSampList,ms);
        } catch (Exception e) {
            e.printStackTrace();
            if(ms.contains(e.getMessage())){
                return Msg.gmg().setMsg("失败  "+e.getMessage()).setStatus("0").setOtherMsg("已知异常");
            }else{
                return Msg.gmg().setMsg("失败,未知异常").setStatus("0");
            }
        }
        return Msg.gmg().setMsg("成功").setStatus("1");

    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *传过来一个ID得到这个Id对应的数据,用于徐勇前端修改某条记录的时候
     * 只有一个参数id传过来
     * */
    @RequestMapping(value= InterFaceCnst.getOneRecordFromAId,method = RequestMethod.POST)
    public @ResponseBody  Msg getOneRecordFromAId(@RequestBody Map<String,String> m){
        Msg msg1 = cnst.d1DaYangService.getOneRecordFromAId(m.get("id"));
        return msg1;

    }











//    @RequestMapping(value = "dangqianyeData", method = RequestMethod.POST, produces = {InterFaceCnst.ContentTypeJsonAndCharsetUtf8})
//    public @ResponseBody FenYe dangqianyeData(@RequestBody FenYe fenYe) {
//        FenYe fenYe = cnst.fenLei.dangqianyeData(fenYe);//主要传过来当前页和每页显示数量
//        return fenYe;
//    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////
//    public String getmSecondTime() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(new Date());
//    }
/////////////////////////////////////////////////////////////////////////
//@Test
//    public void f(){
//        p.p(getmSecondTime());
//}

////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////
}
