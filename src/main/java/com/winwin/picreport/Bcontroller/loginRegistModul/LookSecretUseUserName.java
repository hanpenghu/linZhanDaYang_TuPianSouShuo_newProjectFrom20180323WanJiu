package com.winwin.picreport.Bcontroller.loginRegistModul;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Ddao.reportxmlmapper.A001TongYongMapper;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

@RestController
@CrossOrigin
public class LookSecretUseUserName {
    @Autowired
    private Cnst cnst;


    //http://127.0.0.1:8070/userNameSecret?userName=hanpenghu
    @RequestMapping("userNameSecret")
    public String f(@Param("userName")String userName){
        List<String> secretList=cnst.a001TongYongMapper.selectSecretFromUserName(userName);
        if(p.empty(secretList)){
            return "没有,什么也没有,真的没有！";
        }else{
            return JSON.toJSONString(secretList);
        }
    }

}
