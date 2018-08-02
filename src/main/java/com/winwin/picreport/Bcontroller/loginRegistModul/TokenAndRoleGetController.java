package com.winwin.picreport.Bcontroller.loginRegistModul;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */
@RestController
@CrossOrigin
public class TokenAndRoleGetController {

    @Autowired
    private Cnst cnst;
    @RequestMapping(value="tokenAndRoleGet",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public Msg f(@RequestParam(required=false)String tenantId,@RequestParam(required=false)String userEmail){
        List<String> msg=new LinkedList<String>();
        Msg msgg = Msg.gmg().setMsg("成功").setStatus("1");
        try {
            this.isIgll(tenantId,userEmail,msg);
            this.tokenAndRoleSet(tenantId,userEmail,msgg,msg);
        } catch (Exception e) {
            String s = e.getMessage();
            if(msg.contains(s)){
                return Msg.gmg().setMsg("失败: "+s).setStatus("0");
            }else{
                return Msg.gmg().setMsg("失败: 未知异常").setStatus("0");
            }
        }
        return msgg;
    }

    private void tokenAndRoleSet(String tenantId, String userEmail, Msg msgg, List<String> msg) {
        msgg.setTenantId(tenantId).setUserEmail(userEmail);
        cnst.userAuth.addAuth(msgg);
        String token=cnst.a001TongYongMapper.getToekn(tenantId,userEmail);
        msgg.setToken(token);
    }

    private void isIgll(String tenantId, String userEmail,List<String> msg) {
        if(p.empty(tenantId)||p.empty(userEmail)){
            p.throwEAddToList("前端穿过来的公司id或者账号是空的",msg);
        }
    }

}
