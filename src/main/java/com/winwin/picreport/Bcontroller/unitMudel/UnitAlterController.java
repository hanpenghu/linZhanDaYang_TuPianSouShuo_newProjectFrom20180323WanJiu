package com.winwin.picreport.Bcontroller.unitMudel;
import com.winwin.picreport.Ddao.reportxmlmapper.PrdtUtMapper;
import com.winwin.picreport.Edto.PrdtUt;
import com.winwin.picreport.Edto.PrdtUtExample;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 * 1、	物流管理下面加货品单位（model_uuid=1026），放在产品信息导出下面
 界面栏位：单位名称，单位类型（主单位，副单位）；可以新增删除单位，
 进表prdt_ut（主单位ut_id=1，副单位ut_id=7）

 select * from prdt_ut
 */
@RestController
@CrossOrigin
public class UnitAlterController {

    @Autowired
    private PrdtUtMapper prdtUtMapper;

    //查看所有单位
    @RequestMapping(value="getAllUnit",method=RequestMethod.GET)
    public @ResponseBody Msg f(){
        List<PrdtUt> prdtUts=new LinkedList<PrdtUt>();
        try {
            PrdtUtExample pue=new PrdtUtExample();
            pue.createCriteria().andUtIsNotNull().andUtIdIsNotNull();
            prdtUts = prdtUtMapper.selectByExample(pue);
        } catch (Exception e) {
            e.printStackTrace();
            String ms = e.getMessage();
            return Msg.gmg().setMsg("数据库异常《"+ms+"》").setObjs(prdtUts).setStatus("0");
        }
         return Msg.gmg().setMsg("成功").setObjs(prdtUts).setStatus("1");
    }



    //删除某些单位
    @RequestMapping(value="deleteSomeUnit",method=RequestMethod.POST)
    public @ResponseBody Msg g(@RequestBody List<PrdtUt> pus){
        List<String>msg=new ArrayList<String>();
        String s="";
        try {
            this.igll(pus,msg);
            this.utDel(pus,s);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            if(msg.contains(message)){
                return Msg.gmg().setStatus("0").setMsg("删除失败！"+s+"《"+message+"》");
            }else{
                return Msg.gmg().setStatus("0").setMsg("删除失败,未知异常！"+s+"《"+message+"》");
            }
        }
        return Msg.gmg().setStatus("1").setMsg("删除成功！"+s);
    }


    private void utDel(List<PrdtUt> pus, String s) {
        for(PrdtUt pu:pus){
            try {
                prdtUtMapper.deleteByPrimaryKey(pu);
            } catch (Exception e) {
                e.printStackTrace();
                s=s+"单位《"+pu.getUt()+"》删除失败,对应的id是《"+pu.getUtId()+"》|-|";
            }
        }
    }

    private void igll(List<PrdtUt> pus,List<String>msg) {
        if(p.empty(pus)){
            p.throwEAddToList("前端传过来的PrdtUt数组对象是空的",msg);
        }
        for(PrdtUt pu:pus){
            if(p.empty(pu.getUt())){
                p.throwEAddToList("前端传过来的对象字段ut有空的",msg);
            }
            if(p.empty(pu.getUtId())){
                p.throwEAddToList("前端传过来的对象字段utId有空的",msg);
            }
        }

    }



    //更新某个单位//注意ut和utId是2个主键,不可能更新,只能删了再insert
//    @RequestMapping(value="updateUnit",method=RequestMethod.POST)
//    public @ResponseBody  Msg h(){
//
//
//        return null;
//    }






}
