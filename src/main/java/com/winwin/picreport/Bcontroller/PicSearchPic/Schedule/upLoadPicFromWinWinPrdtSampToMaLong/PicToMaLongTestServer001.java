package com.winwin.picreport.Bcontroller.PicSearchPic.Schedule.upLoadPicFromWinWinPrdtSampToMaLong;

import cn.productai.api.core.IWebClient;
import cn.productai.api.pai.entity.dataset.DataSetModifyResponse;
import com.alibaba.fastjson.JSON;
import com.winwin.picreport.Bcontroller.PicSearchPic.utils.*;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class PicToMaLongTestServer001 {

private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private CnstO cnstO;


//    @Scheduled(fixedDelay = Long.MAX_VALUE,initialDelay = 7000)//启动项目执行一次
    public void qiDong_XiangMu_shiHou_ShangChuan_YiCi(){
        nativePic2MaLong();

    }

//    @Scheduled(cron="0 0 1 * * ?")//每天凌晨一点执行
    public void meiTian_dingShi_zhiXing(){
        this.nativePic2MaLong();
    }




public  void nativePic2MaLong(){
    l.info("----------------kaiShi tongBu wenJianJia de tuPian-dao-MaLong---------------");
    try {
        //得到图片路径前半身 比如:http://61.177.44.218:8070/suoLueTuWenJianJia/
        //注意这个半身路径最后是有一个斜杠的
        String picUrlBefore = cnstO.tuPianShangChuanDaoMaLongDeURL;

        //得到打包后的工程jar所在的路径
        //        *得到类似路径
        //        * E:/1/000/LinZhan
//            String jarPath= p.jarPath();

        //得到打样和缩略图总文件夹路径
        //daYangSuoLueTuAndFuJianZongPath=./daYangSuoLueTuAndFuJianZongPath/
        String daYangSuoLueTuAndFuJianZongPath = cnstO.daYangSuoLueTuAndFuJianZongPath;
        //得到缩略图文件夹
//        suoLueTuWenJianJia=suoLueTuWenJianJia/
        String suoLueTuWenJianJia = cnstO.suoLueTuWenJianJia;
        //得到缩略图文件夹路径   ./daYangSuoLueTuAndFuJianZongPath/suoLueTuWenJianJia/
        String suoLueTuWenJianJiaPath=daYangSuoLueTuAndFuJianZongPath+suoLueTuWenJianJia;
        l.info("-----------suoLueTuWenJianJiaPath:"+suoLueTuWenJianJiaPath+"------------------------------");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //下面是得到所有图片集的模块
        File thumDic=new File(suoLueTuWenJianJiaPath);
        if(thumDic.isDirectory()){
        }else{
            //不是文件
//                p.p("---------您要找的缩略图文件夹不是个文件夹----------"+suoLueTuWenJianJiaPath+"----------------");
            return;//该return是为了不再执行该方法return 以后的代码
        }

        //得到所有的带后缀名字的文件名字(其实是图片名字)
        List<String> fileNames1 = Arrays.asList(thumDic.list());


        //过滤是图片的文件,不是图片的不要给码隆
        List<String> fileNames=new ArrayList<String>();
        for(String s:fileNames1){
            if(p.isPic(s)){
                //此时是图片
                fileNames.add(s);
                l.info("-----------shi tuPian  keYiShangChuan----------------");
            }else{
                l.info("---buShi tuPian-------------------------");
            }
        }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //循环上传所有图片url
        for(String fileName:fileNames){
            //得到记录已经上传图片名字的文本
            String havenUpRecPath = daYangSuoLueTuAndFuJianZongPath+"havenUpRec.json";
            l.info("----jiLu shangChuan TuPian de wenBen LuJing----"+havenUpRecPath+"------------------------");
            /**
             *判断当前图片名字是否在文本中,在的话就不用上传了
             * */
            try {
                File havenUpFile=new File(havenUpRecPath);
                if(p.notExists(havenUpFile)){
                    //不存在,就创建
                    havenUpFile.createNewFile();
                }
                havenUpFile=new File(havenUpRecPath);
                if(p.exists(havenUpFile)){
                    List<String>fileNamess;
                    //存在,就判断当前文件名字在这个文件没有
                    String havaUpFileNameJson = p.readAllTxt(havenUpRecPath);
                    if(p.empty(havaUpFileNameJson)){
                        fileNamess=new LinkedList<>();
                    }else{
                        fileNamess=JSON.parseArray(havaUpFileNameJson,String.class);
                    }
                    if(fileNamess.contains(fileName)){

                        continue;//不再执行下面代码,进行下一个图片
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            /**
             *下面是url上传码隆的模块
             * */
            //得到url
            String url=picUrlBefore+fileName;
            //得到连接码隆索引库的连接类,这个类中主要设置了key和密码等
            IWebClient client = GetIWebClientOfMaLong.getIWebClient();
            //得到上传图片到码隆索引库的主类
            DataSetSingleModifyExample1 g = DataSetSingleModifyExample1.g();
            //上传单条数据的例子
            DataSetModifyResponse res = g.run(client, Cnst001.image_set_idOfWinWinPrdtSamp,url);
            if(null!=res){
                l.info("-----shangChuan--maLong--fanHui--xinXi-----"+res.getMessage()+"--------------------");
            }


            /**
             *下面是记录已经上传过的文件名到文件中的模块
             * */
            this.recAllReadyUpPic(havenUpRecPath,fileName);

        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    } catch (Exception e) {
        e.printStackTrace();
        l.error(e.getMessage(), e);
    }
}

public void recAllReadyUpPic(String havenUpRecPath,String currPicName){
    try {
        File havenUpFile = new File(havenUpRecPath);
        if (p.notExists(havenUpFile)) {
            //不存在,就创建
            havenUpFile.createNewFile();
        }
        havenUpFile = new File(havenUpRecPath);
        if (p.exists(havenUpFile)) {
            List<String> fileNamess;
            //存在,就向里面添加已经上传过的图片数据
            String havaUpFileNameJson = p.readAllTxt(havenUpRecPath);
            if (p.empty(havaUpFileNameJson)) {
                fileNamess = new LinkedList<>();
            } else {
                fileNamess = JSON.parseArray(havaUpFileNameJson, String.class);
            }
            fileNamess.add(currPicName);
            //得到添加内容后的json
            String jsonAlreadyAdd = JSON.toJSONString(fileNamess);
            //将 jsonAlreadyAdd 放入记录文本中
            p.writeToTxt(jsonAlreadyAdd, havenUpRecPath);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
