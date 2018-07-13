package com.winwin.picreport.Bcontroller.daYang.AlterPrice;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2018/7/12.
 */
@CrossOrigin
@RestController
public class DelPrice {
    @Autowired
    private Cnst cnst;
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    private final String dingJiaGuanLian="dingJiaGuanLian";
    private final String 成功="成功 ! ";
    private final String 失败="失败 ! ";
    private final String 未知异常="未知异常 ! ";
    private final String sale="sale";
    private final String buy="buy";
    private final String usr="usr";
    //注意删除界面上的一条价格会删除 关联的价格,比如删除采购价格会把采购价格关联的销售价格也删除
    //map 如右  {"dingJiaGuanLian":"","usr":""}
    //usr是为了判断是不是当前用户,是的话就可以删掉,不是不能删掉
    @RequestMapping(value="/delPrice",method= RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody  Msg f删掉界面上的一条价格和关联价格(@RequestBody Map<String,String> map){
        List<String> msg=new LinkedList<String>();
        try {
            this.isIgll(map,msg);
            this.delPrice(map,msg);
        } catch (Exception e) {
            l.error(e.getMessage(),e);
            if(msg.contains(e.getMessage())){
                return Msg.gmg().setStatus("0").setMsg(失败+e.getMessage());
            }else{
                return Msg.gmg().setStatus("0").setMsg(失败+未知异常);
            }
        }
        return Msg.gmg().setStatus("1").setMsg(成功);
    }



    @Transactional
    public void delPrice(Map<String,String> map,List<String> msg) {
        String djgl = map.get(dingJiaGuanLian);
        String prmNo=this.getPrmNoUseDjgl(djgl);
        String salOrBuy = this.isSalOrBuy(djgl,msg);
        if(sale.equals(salOrBuy)){
            //此时是销售的,删销售不删采购
            this.delUpUseDjgl(djgl,msg);
        }else if(buy.equals(salOrBuy)){
            //此时如果没有prm_no,就证明没有销售定价
            if(p.empty(prmNo)){
                //此时没有销售定价,只删除采购定价
                this.delUpUseDjgl(djgl,msg);
            }else if(p.notEmpty(prmNo)){
                //此时销售采购都有,删除采购顺便删除销售,用prmNo删除
                this.delUpUsePrmNo(prmNo,msg);
            }
        }
    }

    @Transactional
    public void delUpUseDjgl(String djgl,List<String> msg) {
        UpDefExample u=new UpDefExample();
        u.createCriteria().andOlefieldEqualTo(djgl);
        int i = cnst.upDefMapper.deleteByExample(u);
        if(i<1){
            p.throwEAddToList("没有删除一条记录定价关联《"+djgl+"》",msg);
        }else if(i>4){
            //此时有prm_no是空的,顶多只能删除4条
            p.throwEAddToList("没有删除一条记录定价关联《"+djgl+"》,对应的记录超过4条,但是prm_no有空的,这是不可能的",msg);
        }
    }

    @Transactional
    public void delUpUsePrmNo(String prmNo,List<String>msg) {
        UpDefExample u=new UpDefExample();
        u.createCriteria().andPrmNoEqualTo(prmNo);
        int i = cnst.upDefMapper.deleteByExample(u);
        if(i==0){
            p.throwEAddToList("删除价格失败prm_no=《"+prmNo+"》",msg);
        }else if(i>8){
            p.throwEAddToList("删除价格失败prm_no=《"+prmNo+"》up_def对应超过8条数据,这是不可能的",msg);
        }
    }

    @Transactional
    public String getPrmNoUseDjgl(String djgl) {
        UpDefExample u=new UpDefExample();
        u.createCriteria().andOlefieldEqualTo(djgl);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(u);
        String prmNo = upDefs.get(0).getPrmNo();
        return prmNo;
    }

    @Transactional
    public String isSalOrBuy(String djgl, List<String> msg) {
        UpDefExample ue=new UpDefExample();
        ue.createCriteria().andOlefieldEqualTo(djgl);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(ue);
        String priceId = upDefs.get(0).getPriceId();
        if(Cnst.salPriceId.equals(priceId)){
            return sale;
        }else if(Cnst.buyPriceId.equals(priceId)){
            return buy;
        }else{
            p.throwEAddToList("该定价关联对应的price_id不是"+Cnst.salPriceId+"也不是"+Cnst.buyPriceId+"",msg);
        }
        return null;
    }


    private void isIgll(Map<String,String> map, List<String> msg) {
        if(p.empty(map)){
            p.throwEAddToList("前端传过来的json是空的",msg);
        }
        String djgl = map.get(dingJiaGuanLian);
        String usr1 = map.get(usr);
        if(p.empty(djgl)){
            p.throwEAddToList("前端穿过来的定价关联是空的",msg);
        }
        this.isCurrentUserSetThePrice(usr1,djgl,msg);
        UpDefExample ue=new UpDefExample();
        ue.createCriteria().andOlefieldEqualTo(djgl);
        long l = cnst.upDefMapper.countByExample(ue);
        if(l<1){
            p.throwEAddToList("前端传过来的定价关联在数据库Up_def没有对应记录",msg);
        }

        List<UpDef> upDefList = cnst.upDefMapper.selectByExample(ue);
        if(p.notEmpty(upDefList)){
            String priceId = upDefList.get(0).getPriceId();
            String prmNo = upDefList.get(0).getPrmNo();
            if(Cnst.salPriceId.equals(priceId)&&p.empty(prmNo)){
                p.throwEAddToList("前端传过来的定价关联"+ djgl +"是销售定价的定价关联,但是prm_no是空的！",msg);
            }
            if(p.notEmpty(prmNo)){
                UpDefExample ue1=new UpDefExample();
                ue1.createCriteria().andPrmNoEqualTo(prmNo);
                long l1 = cnst.upDefMapper.countByExample(ue1);
                if(l1>8){
                    p.throwEAddToList("前端传过来的定价关联《"+ djgl +"》对应的prm_no=《"+prmNo+"》对应的记录超过8条,肯定是老数据有问题",msg);
                }
            }
        }
    }

    private void isCurrentUserSetThePrice(String usr1, String djgl, List<String> msg) {
        UpDefExample u=new UpDefExample();
        u.createCriteria().andOlefieldEqualTo(djgl);
        List<UpDef> upDefs = cnst.upDefMapper.selectByExample(u);
        p.p("------------------------List<UpDef> upDefs = cnst.upDefMapper.selectByExample(u);-------------------------------");
        p.p(upDefs);
        p.p("-------------------------------------------------------");
        int i=0;
        if(p.notEmpty(upDefs)){
            Set<String> usr2Set=new LinkedHashSet<String>();
            for(UpDef uu:upDefs){
                if(p.dy(uu.getUsr(),usr1)){
                    i=i+1;
                }else{
                    usr2Set.add(    p.sm(null!=uu.getUsr(),uu.getUsr(),"").trim()     );
                }
            }

            String usr2="";
            if(i==0){
                for(String s:usr2Set){usr2=usr2+s+",";}
                if(p.notEmpty(usr2)){usr2=usr2.substring(0,usr2.lastIndexOf(","));}
                if(usr2Set.contains(Cnst.ADMIN)){
                    p.throwEAddToList("你不是创建该采购定价的人,无法删除《老数据》,创建人是《"+usr2+"》,  djgl="+djgl+"",msg);
                }else{
                    //up_def中没有一个是本人
                    p.throwEAddToList("你不是创建该采购定价的人,无法删除,创建人是《"+usr2+"》,  djgl="+djgl+"",msg);
                }
            }
        }
    }





}
