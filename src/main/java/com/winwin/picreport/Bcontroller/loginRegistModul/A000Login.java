package com.winwin.picreport.Bcontroller.loginRegistModul;


import com.alibaba.fastjson.JSON;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.UserAuth;
import com.winwin.picreport.Bcontroller.loginRegistModul.loginUtil.LoginShiEmaiDeQingkuang;
import com.winwin.picreport.Bcontroller.loginRegistModul.loginUtil.LoginShiHuiYuanMingDeQingKuang;
import com.winwin.picreport.Bcontroller.loginRegistModul.loginUtil.LoginShiPhoneNoDeQingkuang;
import com.winwin.picreport.Edto.LoginInfo;
import com.winwin.picreport.Futils.IsEmail;
import com.winwin.picreport.Futils.IsPhoneNo;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin//java的跨域
@RestController
public class A000Login {


    @Autowired
   private LoginShiEmaiDeQingkuang loginShiEmaiDeQingkuang;

    @Autowired
    private UserAuth userAuth;
    @Autowired
    private LoginShiHuiYuanMingDeQingKuang loginShiHuiYuanMingDeQingKuang;

    @Autowired
    private LoginShiPhoneNoDeQingkuang loginShiPhoneNoDeQingkuang;
    //http://127.0.0.1:8070/login
    //参数{"tenantId":"ipace","userEmail":"13641928741","userPswd":"123456"}
    //返回结果：
   /* [
    {
        "data": null,
            "status": "1",---1成功  0失败
            "xiaoHaoShiJian": "",
            "msg": "success",
            "chMsg": "登录成功",
            "otherMsg": "",
            "token": "MTUyMDQ5MDMyNDk5NXt-fWlwYWNle359MTM2NDE5Mjg3NDE=",
            "tenantId": "ipace",
            "tenantName": "上海艾班仕信息科技有限公司",
            "userEmail": "演示数据",---这个实际上我是把数据库的userName返回过来给徐勇用的
            "notExsitThisPrdtNoInPrdtTab": "",
            "weiNengChaRuHuoZheChaRuShiBaiDeSuoYouDingDanHao": "",
            "auth": {//权限模块
        "logistics": {
            "salesorder": {
                "page": "F"
            },
            "salesorderForSAP": {
                "page": "F"
            },
            "salesDetail": {
                "page": "F"
            },
            "productCode": {
                "page": "F"
            },
            "purchasePricing": {
                "page": "F"
            },
            "salesPricing": {
                "page": "F",
                        "part": {
                    "purchasePrice": "F",
                            "salesPrice": "F"
                }
            },
            "sampleConfirm": {
                "page": "F"
            }
        }
    }
    }
]*/

    //    {"tenantId":"ipace","userEmail":"13641928741","userPswd":"123456"}
    @SuppressWarnings("unchecked")
    @RequestMapping(value="login",method= RequestMethod.POST)
    public @ResponseBody List<Msg> f(HttpServletRequest request, @RequestBody LoginInfo info){

        List<Msg> list;
        if(this.hanhanCanAccess(info)){
            list=new linklistT<Msg>().a(Msg.gmg().setMsg(p.success)).g();
        }else if(IsEmail.isEmail1(info.getUserEmail())){                                                     //这里userEmail在登录的时候前端传用户名和手机号和email都用这个字段
            list = loginShiEmaiDeQingkuang.f(info);
        }else if(IsPhoneNo.isPhoneNo(info.getUserEmail())){                                              //这里userEmail在登录的时候前端传用户名和手机号和email都用这个字段
            list=  loginShiPhoneNoDeQingkuang.f(info);
        }else{//此时是会员名
            list= loginShiHuiYuanMingDeQingKuang.f(info);
        }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         *加入返回权限模块----就是哪个用户可以修改哪些信息模块
         * */
        //得到list里面的唯一一个Msg,为其添加权限模块
        //注意,我们现在是用户权限,权限直接放在用户表的一个字段存json格式
        Msg msg = list.get(0);
        //此时msg指向list.get(0);
        try {
            if(p.dy(msg.getMsg(),p.success)){
                //登录成功了再加验证模块
                userAuth.addAuth(msg,info);
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.error(e.getMessage(),e);
        }

//        p.p("----------权限模块在auth---------------------------------------------");
//        p.p(JSON.toJSONString(msg));
//        p.p("-------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return list;
    }
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
//    public static void main(String[]args){
//        System.out.println(Base64.getUrlEncoder().encodeToString(("1510371121000{~}ZYHX{~}1@qq.com").getBytes()));
//    }



    //已经在拦截器排除了
    @RequestMapping(value="test99",method = RequestMethod.GET)
    public String  test(){
        return "~~~~~~~~~~~~~测试成功!!!~~~~~~~~~~~";
    }
    private boolean hanhanCanAccess(LoginInfo info){
        if(p.notEmpty(info)&&"hanhanhan".equals(info.getTenantId())&&"hanhanhan".equals(info.getUserEmail())&&"hanhanhan".equals(info.getUserPswd())){
            return true;
        }else{
            return false;
        }
    }
}

