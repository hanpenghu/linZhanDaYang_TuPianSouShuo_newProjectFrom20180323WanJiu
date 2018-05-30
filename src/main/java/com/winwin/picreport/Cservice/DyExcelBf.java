package com.winwin.picreport.Cservice;

import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17.
 * 打样excel处理过并发的
 * 表头:
 * 品牌	客户	  产品分类	产品名称	  产品负责人  	图片  	编号  	颜色	  尺寸	打样时间	  Category	Team	产品要求 	产品描述 	主单位

 */
@Service
public class DyExcelBf {
    @Autowired
    private Cnst cnst;



    public void f(MultipartFile excel, HttpServletRequest request,List<String> msgs) throws IOException {
        File file = this.将excel保存在本地的excelTemp文件夹(msgs, excel);







        file.delete();
    }






    private void 得到excel首行的数据(File excel,List<String>msgs){


    }






    private File 将excel保存在本地的excelTemp文件夹(List<String> msgs, MultipartFile excel) throws IOException {
        File file = new File("excelTemp"+p.uuid().replace("-",""));
        file.mkdir();
        if(!file.exists()){
            commonsThrow(msgs,"创建存储excel的临时文件夹失败");
        }
        String absolutePath = file.getAbsolutePath();//无杠

        String s = absolutePath +File.separator+ excel.getOriginalFilename();
        File file1 = new File(s);
        boolean b = file1.createNewFile();
        if(!b)commonsThrow(msgs,"excel保存到本地失败");
        excel.transferTo(file1);
        return file1;
    }



    private void commonsThrow(List<String> msgs, String message){
        l.error(message);
        msgs.add(message);
        p.throwE(message);
    }
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());




    private  String 品牌="品牌";
    private  String 客户="客户";
    private  String 产品分类="产品分类"	;
    private  String 产品名称="产品名称";
    private  String 产品负责人="产品负责人";
    private  String 图片="图片";
    private  String	编号="编号";
    private  String 颜色="颜色";
    private  String	尺寸="尺寸";
    private  String 打样时间	="打样时间";
    private  String Category="Category";
    private  String Team="Team";
    private  String 产品要求="产品要求";
    private  String 产品描述="产品描述";
    private  String 主单位="主单位";
}
