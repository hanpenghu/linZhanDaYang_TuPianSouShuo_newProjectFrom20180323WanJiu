package com.winwin.picreport.Bcontroller.daYang.checkOutModule;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.PrdtSamp0;
import com.winwin.picreport.Edto.PrdtSampExample;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Administrator on 2018/6/19.
 * 对未提交状态的进行提交,isnull(is_check_out,'0')='0'的就算是未提交状态的
 * 具体状态看下面那个文档的状态码
 */
@CrossOrigin
@RestController
public class CheckOutOfSubmitController {

    @Autowired
    private Cnst cnst;

    @Autowired
    private CheckOutOfSubmitServices checkOutOfSubmitServices;
    /**
     * Created by Administrator on 2018/6/19.
     * {"id":"0000436d-0797-4e7b-9d8d-3ff0a30ea5c0","cusNameGive":"高树（金坛）饰品有限公司"
     * ,"cusNoGive":"F95","startsellcount":"211",
     "sampSendStamp":"1546387200000","modelcost":null,"littleorderprice":"222"
     ,"modelcostinvoiceno":"模具费用发票号","financedesc":"财务描述"}
     *
     *
     */

    //审核之前的状态提交接口
    //提交
    @RequestMapping(value = "checkOutOfSubMit", method = RequestMethod.POST ,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody  Msg  f(@RequestBody PrdtSamp0 prdtSamp0) {
        List<String> ms = new LinkedList<String>();
        try {
            this.isIgll(prdtSamp0, ms);
            checkOutOfSubmitServices.f(prdtSamp0, ms);
        } catch (Exception e) {
            return controllerIgllReturn(e, ms);
        }
        return Msg.gmg().setStatus(Cnst.SUCCESS).setMsg(成功);
    }

    private void isIgll(PrdtSamp0 prdtSamp0, List<String> ms) {
        if (p.empty(prdtSamp0)) {
            p.throwEAddToList("前端传过来的参数是空的", ms);
        }
        if(p.empty(prdtSamp0.getId())){
            p.throwEAddToList("前端传过来的id是空的",ms);
        }
        if(p.empty(prdtSamp0.getStartsellcount())){
            p.throwEAddToList("前端传过来的起订量startsellcount是空的",ms);
        }

        if(p.empty(prdtSamp0.getLittleorderprice())){
            p.throwEAddToList("前端传过来的小单费littleorderprice是空的",ms);
        }


        if (p.empty(prdtSamp0.getCusNoGive()) || p.empty(prdtSamp0.getCusNameGive())) {
            if (this.供应商No在prdtSamp是空(prdtSamp0)||this.供应商Name在prdtSamp是空(prdtSamp0)){
                p.throwEAddToList("前端传过来的供应商no和name是空,数据库也是空", ms);
            }
        }

        if(!this.isAllReadyHaveBuyPrice(prdtSamp0, ms)){
            p.throwEAddToList("该商品还没有采购定价", ms);
        }


    }

    //是否已经采购定价
    private boolean isAllReadyHaveBuyPrice(PrdtSamp0 prdtSamp0, List<String> ms) {
        PrdtSamp prdtSamp = cnst.prdtSampMapper.selectByPrimaryKey(prdtSamp0.getId());
        UpDefExample  upDefExample=new UpDefExample();
        upDefExample.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo()).andPriceIdEqualTo(Cnst.buyPriceId).andUpIsNotNull().andOlefieldLike("%"+Cnst.SamplesSys+"%");
        long l = cnst.upDefMapper.countByExample(upDefExample);
        if(l>0){
            //已经进行过采购定价
            return true;
        }else{
            return false;
        }

    }


    private boolean 供应商Name在prdtSamp是空(PrdtSamp0 prdtSamp0) {
        PrdtSampExample prdtSampExample = new PrdtSampExample();
        prdtSampExample.createCriteria().andCusNameGiveIsNull().andIdEqualTo(prdtSamp0.getId());
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        prdtSampExample.createCriteria().andCusNameGiveEqualTo("").andIdEqualTo(prdtSamp0.getId());
        long ll = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if (l > 0 || ll > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean 供应商No在prdtSamp是空(PrdtSamp0 prdtSamp0) {
        PrdtSampExample prdtSampExample = new PrdtSampExample();
        prdtSampExample.createCriteria().andCusNoGiveIsNull().andIdEqualTo(prdtSamp0.getId());
        long l = cnst.prdtSampMapper.countByExample(prdtSampExample);
        prdtSampExample.createCriteria().andCusNoGiveEqualTo("").andIdEqualTo(prdtSamp0.getId());
        long ll = cnst.prdtSampMapper.countByExample(prdtSampExample);
        if (l > 0 || ll > 0) {
            return true;
        } else {
            return false;
        }
    }


    private Msg controllerIgllReturn(Exception e, List<String> ms) {
        if (ms.contains(e.getMessage())) {
            e.printStackTrace();
            return Msg.gmg().setStatus(n0).setMsg(e.getMessage()).setOtherMsg(已知异常);
        } else {
            e.printStackTrace();
            return Msg.gmg().setStatus(n0).setMsg(未知异常).setOtherMsg(e.getMessage());
        }
    }

    private String n0 = "0";
    private String n1 = "1";
    private String 未知异常 = "《未知异常》";
    private String 已知异常 = "《已知异常》";
    private String 成功 = "《成功》";
    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
