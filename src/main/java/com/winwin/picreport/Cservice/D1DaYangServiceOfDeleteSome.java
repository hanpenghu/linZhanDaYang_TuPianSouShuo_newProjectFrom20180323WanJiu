package com.winwin.picreport.Cservice;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.PrdtSamp;
import com.winwin.picreport.Edto.TfPosExample;
import com.winwin.picreport.Edto.UpDef;
import com.winwin.picreport.Edto.UpDefExample;
import com.winwin.picreport.Futils.MsgGenerate.MessageGenerate;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("unchecked")
@Service("deleteSome")
public class D1DaYangServiceOfDeleteSome {



    @Value("${daYangSuoLueTuAndFuJianZongPath}")//./1234567/
    private String daYangSuoLueTuAndFuJianZongPath;

    @Autowired
    private Cnst cnst;


    @Transactional
    public List<Msg> deleteSomeRecode(List<String> uuidList){
       List<String>   msg=new LinkedList<>();
       String strs="";
        int jiShuQi=0;
        String qunJuSuoLueTu="";
        String quanJuFuJian="";
 /////////////////////////////~~~~~~~~~~for开始~~~~~~~~~~~~~////////////////////////////////////////////
        try {
            for(String id:uuidList){
                    //this.del1(id,quanJuFuJian,qunJuSuoLueTu,msg);
                PrdtSamp prdtSamp=cnst.prdtSampMapper.selectByPrimaryKey(id);
                boolean b=this.ifHavePriceCanNotDel(prdtSamp);
                if(b==true){
                    strs=strs+"《"+prdtSamp.getPrdCode()+"》";
                    //此时有价格了,该条记录不能删除继续删除其他记录
                    continue;
                }
                this.del1(prdtSamp,quanJuFuJian,qunJuSuoLueTu,msg);
                this.deletePrdNoInPrdt(prdtSamp,msg);
                jiShuQi++;
            }
        } catch (Exception e) {
            if(msg.contains(e.getMessage())){
                return new linklistT<Msg>().a(Msg.gmg().setStatus("42").setMsg("删除失败: " + e.getMessage()).setChMsg("删除失败: " + e.getMessage())).g();
            }else{
                return new linklistT<Msg>().a(Msg.gmg().setStatus("42").setMsg("删除失败,未知异常: " + e.getMessage()).setChMsg("删除失败,未知异常: " + e.getMessage())).g();
            }
        }
        if(p.notEmpty(strs)){
            strs="    编码为: "+strs+" 的记录因为已经存在定价记录, 导致没有删除该记录,请先删除价格,再删除编码！    ";
        }
/////////////////////////////~~~~~~~~~~for结束~~~~~~~~~~~~~////////////////////////////////////////////

        if(strs.contains("的记录因为已经存在定价记录")){
            return MessageGenerate.generateMessage
                    ("删除失败,   "+strs+"   ", "删除失败,   "+strs+"   ",
                            "共删除"+jiShuQi+"条记录", "", "42");
        }else{
            return MessageGenerate.generateMessage
                    ("删除成功", "删除成功,   "+strs+"   ",
                            "共删除"+jiShuQi+"条记录", "", "43");
        }


///////////////deleteSomeRecode方法结束///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Transactional
    public void del1(PrdtSamp prdtSamp,String quanJuFuJian, String qunJuSuoLueTu,List<String>msg) {
        try {
            /**
             *数据库得到的路径是下面这种‘
             * fuJianWenJianJia/b9f7307f-ee68-44d0-bd91-1aa488281586!75533.xls;
             * */
            String attach = prdtSamp.getAttach();
            //避免切割字符串失败
            if(attach==null){ attach=""; }
            String thum = prdtSamp.getThum();
            if(thum==null){thum="";}

            List<String> attachList = Arrays.asList(attach.split(";"));

            List<String> thumList = Arrays.asList(thum.split(";"));

            //删除所有附件
            if(attachList.size()>0){
                for(String att:attachList){
                    quanJuFuJian=att;
                    this.deleteThumOrAttach(att);
                }
            }
            //删除所有缩略图
            if(thumList.size()>0){
                for(String thu:thumList){
                    qunJuSuoLueTu=thu;//在catch里有用
                    this.deleteThumOrAttach(thu);
                }
            }
        } catch (Exception e) {
            System.out.println("删除图片或者附件失败");
            System.out.println("删除图片失败的是"+qunJuSuoLueTu+"");
            System.out.println("删除附件失败的是"+quanJuFuJian+"");
        }

        int i = cnst.prdtSampMapper.deleteByPrimaryKey(prdtSamp.getId());
        if(i<1){
            p.throwEAddToList("删除id=  "+prdtSamp.getId()+"   ,编码="+prdtSamp.getPrdCode()+"  的记录失败,数据库错误,导致一条记录都没删掉",msg);
        }
    }

    @Transactional
    public boolean ifHavePriceCanNotDel(PrdtSamp prdtSamp) {
        List<UpDef> upDefs=null;
        try {
            UpDefExample u=new UpDefExample();
            u.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo());
            upDefs = cnst.upDefMapper.selectByExample(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(p.notEmpty(upDefs)){
            return true;
        }else{
            return false;
        }
    }


    @Transactional
    public void deletePrdNoInPrdt(PrdtSamp prdtSamp,List<String>msg) {
        if(p.notEmpty(prdtSamp)){
            if(p.notEmpty(prdtSamp.getPrdNo())){
                TfPosExample tfP=new TfPosExample();
                tfP.createCriteria().andPrdNoEqualTo(prdtSamp.getPrdNo());
                long l = cnst.tfPosMapper.countByExample(tfP);
                if(l<1){
                    //此时再tfPos表里没有用过该货号,可以在货品资料表删除该货品
                    cnst.prdtMapper.deleteByPrimaryKey(prdtSamp.getPrdNo());
                }
            }
        }
    }

/////////////D1DaYangServiceOfDeleteSome类结束////////////////////////////////////////////////////////////


//    public static void main(String[]args){
//            System.out.println(Arrays.asList("123".split(";")));
//    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Transactional
    public void deleteThumOrAttach(String thumOrAttach){
    String s = p.springBootJarPath();
    s=s.substring(0,s.length()-1);
    String totalPath = daYangSuoLueTuAndFuJianZongPath.replace(".", "");
    File file=new File(s + totalPath +thumOrAttach);
    if(file.exists()){file.delete();}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////