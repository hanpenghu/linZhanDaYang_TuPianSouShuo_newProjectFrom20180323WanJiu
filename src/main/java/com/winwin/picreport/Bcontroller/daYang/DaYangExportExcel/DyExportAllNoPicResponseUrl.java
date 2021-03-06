package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.CustExample;
import com.winwin.picreport.Edto.CustWithBLOBs;
import com.winwin.picreport.Futils.hanhan.link;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import com.winwin.picreport.Futils.hanhan.pp;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
@SuppressWarnings("unchecked")
@CrossOrigin
@RestController
public class DyExportAllNoPicResponseUrl {
    private String 可以看到6个字段="yes";
    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Cnst cnst;

    private String jarPath;
    /**
     * 导出所有
     http://47.98.45.100:8070/dyExportExcelAllNoPic?tenantId=ipace&userEmail=hanpenghu&param=%7B%22ids%22%3A%5B%5D%2C%22fields%22%3A%5B%22salName%22%2C%22thum%22%2C%22cusName%22%2C%22cust.nm_eng%22%2C%22prdCode%22%2C%22idxName%22%2C%22fenLeiName%22%2C%22category%22%2C%22teamname%22%2C%22colour%22%2C%22size%22%2C%22mainUnit%22%2C%22noTransUpSaleBenBi%22%2C%22haveTransUpSaleBenBi%22%2C%22noTransUpSaleWaiBi%22%2C%22haveTransUpSaleWaiBi%22%2C%22financestartsellcount%22%2C%22financelittleorderprice%22%2C%22confirmtimestr%22%2C%22confirmman%22%2C%22sampRequ%22%2C%22sampMake%22%2C%22sampSend%22%5D%7D
     */
/*     * isCanSee6Column=yes,
            * 表示该用户可以导出下面6个字段,否则不导出
     *
             *
    startsellcount  采购起订量
    littleorderprice 采购小单费
    modelcost  采购模具费
    miniOrderAmt 采购起订金额
    采购含运费    haveTransUpBuyBenBi
    采购不含运费  noTransUpBuyBenBi


     设置所有人除三个人之外都不能导出6个指定字段
     Insert into model_users_spc(users_uuid,ctrl_id,spc_id,rem,model_uuid)
    select uuid,'exportExcelCanSee','F','信息导出6个字段不显示','10'
    from users where user_name not in('013','014','hanpenghu')


    select * from model_users_spc where rem ='信息导出6个字段不显示'

    */
    @RequestMapping(value = "dyExportExcelAllNoPic")//注意,下面这个param这玩意会自动解码decode
    public String 打样产品导出所有不带图片(@Param("param") String param,@Param("isCanSee6Column") String isCanSee6Column) throws Exception {
        try {
            jarPath = p.springBootJarPath();
            //String ss="\"ids\":[\"0000e1a2-ec00-4b06-94da-db80628473eb\",\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"],\"fields\":[\"salName\",\"thum\",\"prdCode\",\"mainUnit\",\"haveTransUpSaleBenBi\",\"haveTransUpSaleWaiBi\",\"noTransUpSaleBenBi\",\"noTransUpSaleWaiBi\"]}{";
//        p.p("----1-------------打样产品导出 excel, 刚进入接口 dyExportExcel 的参数 param 如下--------------------------------------");
//        p.p(param);
//        p.p("-------------------------------------------------------");
            log.info("《《类: 打样产品导出所有不带图片《《《《接口: dyExportExcelAllNoPic》前端穿过来参数是》param》{}》》》》",param);
            ExportXlsParam ep = null;
            try {
                ep = this.formatJsonFromFront(param);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("《《《《《《《《《《前端传过来的参数无法格式化成ExportXlsParam对象  param: 》{}》》》》》》》",param);
                log.info("《《《《《《《《前端传过来的参数无法格式化成ExportXlsParam对象.txt》》》》》》》");
    //           return pp.returnBrowserFileToDownLoad(p.createNewFile("前端传过来的参数无法格式化成ExportXlsParam对象.txt"));
                return "前端传过来的参数无法格式化成ExportXlsParam对象.txt";
            }
            if (null == ep) {
                log.info("《《《《《《《《《《null == ep》前端传过来的参数是null》》》》》》》》》");
                log.info("《《《《《《《《前端传过来的参数是null.txt》》》》》》》》");
    //           return pp.returnBrowserFileToDownLoad(p.createNewFile("前端传过来的参数是null.txt"));
                return "前端传过来的参数是null.txt";
            }

            List<String> list导出头信息 = this.f得到完整导出头信息();

            List<String> 前端穿过来要显示的fields = ep.getFields();
            //不再导出图片,把图片的头信息删掉
            if(p.notEmpty(前端穿过来要显示的fields)&&前端穿过来要显示的fields.contains("thum")){
                //确定不要显示thum
                前端穿过来要显示的fields.remove("thum");
            }
            if (p.notEmpty(前端穿过来要显示的fields)) {
                this.a干掉excel中不需要的字段(list导出头信息,前端穿过来要显示的fields);
            }
            try {
                log.info("前端传过来的关于6个字段是否可见的标识符是:{}",isCanSee6Column);
                //如果不是yes就干掉要显示的6个字段
                if(可以看到6个字段.equals(isCanSee6Column)){
                    this.add6Column(list导出头信息);
                }
            } catch (Exception e) {log.info(e.getMessage(),e);}
            log.info("《《{}《《《《从数据库拿到所有daoChus对象开始》》》》》》》》》",p.dtoStr(new Date(),p.d16));
            List<DaoChu> daoChus= cnst.a001TongYongMapper.getDaoChusOfAllNoPic();
            log.info("《《《{}《《《从数据库拿到所有daoChus对象结束》》》》》》》》》",p.dtoStr(new Date(),p.d16));


            if (   p.empty(daoChus)   ) {
                p.p("====daoChus是null=========");
                return null;
            }

            log.info("《《{}《《《《把所有字段写入excel开始》》》》》》》》》",p.dtoStr(new Date(),p.d16));
            //把字段写入excel
            String excel路径 = this.a写入excel(daoChus,list导出头信息);
            log.info("《《{}《《《《把所有字段写入excel结束》》》》》》》》》",p.dtoStr(new Date(),p.d16));

            log.info("《《{}《《《《把excel写入服务器硬盘开始》》》》》》》》》",p.dtoStr(new Date(),p.d16));
            File file = new File(excel路径);
            log.info("《《{}《《《《把excel写入服务器硬盘结束》》》》》》》》》",p.dtoStr(new Date(),p.d16));


            return cnst.dirUrl+Cnst.saveExcelTemp+"/"+file.getName();
        } catch (Exception e) {
            log.error("《《《《《《《《dyExportExcelAllNoPic导出所有打样价格接口发生未知异常》》{}》》》》》》",e.getMessage());
            return "《《《《《《《《dyExportExcelAllNoPic导出所有打样价格接口发生未知异常》》"+e.getMessage()+"》》》》》》";
        }
    }


//    public static void main(String[]args) throws IOException {
//        p.p("-------------------------------------------------------");
//        p.p(p.createNewFile("111.txt").getName());
//        p.p("-------------------------------------------------------");
//    }




    private  void add6Column(List<String> list导出头信息) {
        list导出头信息.add(Cnst.modelcostExportExcel);
        list导出头信息.add(Cnst.startsellcountExportExcel);
        list导出头信息.add(Cnst.littleorderpriceExportExcel);
        list导出头信息.add(Cnst.miniOrderAmtExportExcel);
        list导出头信息.add(Cnst.haveTransUpBuyBenBiExportExcel);
        list导出头信息.add(Cnst.noTransUpBuyBenBiExportExcel);
    }



    private ExportXlsParam formatJsonFromFront(String param) {
        ExportXlsParam ep = null;
        try {
            ep = JSON.parseObject(param, ExportXlsParam.class);
        } catch (Exception e) {
//            l.error("前端传过来到dyExportExcel打样导出excel的接口的《json》无法格式化", e);
            return null;
        }
        if (p.empty(ep)) {
            return null;
        }
        return ep;
    }




    private String a写入excel(List<DaoChu> daoChus, List<String> list导出头信息) {
        //一个sheet最大支持65536行,
        if(p.notEmpty(daoChus)&&daoChus.size()<=65535){
                return lessThan65535(daoChus,list导出头信息);
        }else{
            return moreThan65535(daoChus,list导出头信息);
        }

    }

    private String moreThan65535(List<DaoChu> daoChus, List<String> list导出头信息) {
        List<DaoChu> daoChus1 = daoChus.subList(0, 65535);
        List<DaoChu> daoChus2 = daoChus.subList(65535, daoChus.size());
        String excelName = "SampExport" + p.sj() + ".xls";
        String a临时目录不带杠绝对路径 = f创建存储excel的临时目录不带杠();
        String excelPath = a临时目录不带杠绝对路径 + File.separator + excelName;
        log.info("《《《《《《《《《《《保存excel的路径是》{}》》》》》》》》》》》》",excelPath);
        FileOutputStream fileOut = null;
        try {
            //创建excel
            HSSFWorkbook wb = new HSSFWorkbook();
            this.createSheetAndWrite(wb,daoChus1,list导出头信息,"sheet1");
            this.createSheetAndWrite(wb,daoChus2,list导出头信息,"sheet2");
            //此时文件不存在会自动创建
            fileOut = new FileOutputStream(excelPath);
            // 输出文件
            wb.write(fileOut);
            wb.close();
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return excelPath;


    }

//    public static void main(String[]args){
//        List<String>list1=new ArrayList<>();
//        list1.add("1");list1.add("2");list1.add("3");list1.add("4");
//        list1.add("5");
//        List<String> strings = list1.subList(0, 3);
//        List<String> strings1 = list1.subList(3, 5);
//        p.p("-------------------------------------------------------");
//        p.p(strings);
//        p.p(strings1);
//        p.p("-------------------------------------------------------");
//    }


    private String lessThan65535(List<DaoChu> daoChus, List<String> list导出头信息) {
        String excelName = "SampExport" + p.sj() + ".xls";
        String a临时目录不带杠绝对路径 = f创建存储excel的临时目录不带杠();
        String excelPath = a临时目录不带杠绝对路径 + File.separator + excelName;
        log.info("《《《《《《《《《《《保存excel的路径是》{}》》》》》》》》》》》》",excelPath);
        FileOutputStream fileOut = null;
        try {
            //创建excel
            HSSFWorkbook wb = new HSSFWorkbook();
            this.createSheetAndWrite(wb,daoChus,list导出头信息,"sheet1");
            //此时文件不存在会自动创建
            fileOut = new FileOutputStream(excelPath);
            // 输出文件
            wb.write(fileOut);
            wb.close();
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return excelPath;
    }

    private void createSheetAndWrite(HSSFWorkbook wb, List<DaoChu> daoChus, List<String> list导出头信息,String sheetNo) {
        //创建sheet1
        HSSFSheet sheet1 = wb.createSheet(sheetNo);
        HSSFCellStyle cellStyle = wb.createCellStyle();  //创建设置EXCEL表格样式对象 cellStyle
        cellStyle.setWrapText(true);//设置自动换行
        this.a写行列(daoChus, sheet1, cellStyle, wb, list导出头信息);
    }


    private void a写行列(List<DaoChu> daoChus, HSSFSheet sheet1, HSSFCellStyle cellStyle, HSSFWorkbook wb, List<String> list导出头信息) {
        a写行头(sheet1.createRow(0), sheet1, cellStyle, list导出头信息);//第0行写成行头
        //以下是写内容行
        int i行计数器 = 1;//
        if (p.notEmpty(daoChus)) {
            for (DaoChu daoChu : daoChus) {
                if (p.notEmpty(daoChu)) {
                    HSSFRow row = sheet1.createRow(i行计数器);
                    row.setHeightInPoints(40);
                    this.a写入内容行(daoChu, row, sheet1, cellStyle, i行计数器, wb, list导出头信息);
                    i行计数器 = i行计数器 + 1;
                } else {
//                    l.error("------a写行列-----daoChu-是null------------------");
                }
            }
        } else {
//            l.error("------a写行列-----daoChus-是null------------------");
        }
    }


    private void a写入内容行(DaoChu daoChu, HSSFRow row, HSSFSheet sheet1, HSSFCellStyle cellStyle, int i行计数器, HSSFWorkbook wb, List<String> list导出头信息) {

//        p.p("---------------------------daoChu.getMainUnit()------------------------");
//        p.p(daoChu.getMainUnit());
//        p.p("-------------------------------------------------------");
        int 列计数器 = 0;
        for (String s : list导出头信息) {
            sheet1.setColumnWidth(i行计数器, 20 * 256);
            Cell cell = row.createCell(列计数器);
            cell.setCellStyle(cellStyle);
            //设置 excel的cell中除了图片的cell
            DyExport2Thread.setOutOfThumExcel(s,cell,daoChu);
            if (Cnst.thumExportExcel.equals(s)) {//设置照片
//                p.p("=================设置照片=================================");
//                    cell.setCellValue(""); // 设置内容 8
//                p.p2(daoChu.getThum());
                try {
                    this.a设置照片(daoChu.getThum(), sheet1, row, wb, 列计数器, i行计数器);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            列计数器 = 列计数器 + 1;
        }
    }


    private void a设置照片(String thum, HSSFSheet sheet1, HSSFRow row, HSSFWorkbook wb, int a图所在列, int a行计数器) {

        BufferedImage bufferImg = null;
        try {
            try {
                //此try可以达到有缩略图的用缩略图,无缩略图的不用缩略图,避免了一堆复杂判断
                //用try是因为可能有很多截取出错的地方
                thum = jarPath
                        + (
                        cnst.daYangSuoLueTuAndFuJianZongPath.substring(2)
                                + p.chaiFenZuHeFenGeFu(thum.replace(";", p.zuHeFenGeFu)).get(0)
                ).replace("/", File.separator);
            } catch (Exception e) {
//                p.p1("wufa jiequ thum zifuchuan  ,keneng shi kongde,ye keneng shi null");
            }
            if(p.notExists(new File(thum)))return;
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            //加载图片
            bufferImg = ImageIO.read(new File(thum));

            //图片行高不在这里设置,避免出现太高的情况
            /*int height = bufferImg.getHeight();
            int width = bufferImg.getWidth();
            sheet1.setColumnWidth(a行计数器, width);
            row.setHeightInPoints(height);*/

            ImageIO.write(bufferImg, "jpg", byteArrayOut);
            //创建一个图片
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
            //制造图片的位置参数
            HSSFClientAnchor anchor = new HSSFClientAnchor
                    (0, 0, 0, 0, (short) a图所在列, a行计数器, (short) (a图所在列 + 1), a行计数器 + 1);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

            if (p.notEmpty(bufferImg)) {
                bufferImg.flush();
            }
            if (p.notEmpty(byteArrayOut)) {
                byteArrayOut.flush();
                byteArrayOut.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void a写行头(HSSFRow row, HSSFSheet sheet1, HSSFCellStyle cellStyle, List<String> list导出头信息) {
        int k计数器 = 0;
        for (String s : list导出头信息) {
            sheet1.setColumnWidth(k计数器, 20 * 256);
            Cell cell = row.createCell(k计数器);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(s); // 设置内容
            k计数器 = k计数器 + 1;
        }
    }


    private void a干掉excel中不需要的字段(List<String> daoChuExcelHeadList, List<String> a前端传过来需要显示的fields) {
       DyExport2Thread.a干掉excel中不需要的字段(daoChuExcelHeadList,a前端传过来需要显示的fields);
    }


    private String f创建存储excel的临时目录不带杠() {
        String s = p.strCutNoHead(cnst.daYangSuoLueTuAndFuJianZongPath, "./");
        String s1 = p.strCutEndNothave(s, "/");
        File file = new File(new File(s1).getAbsolutePath() + File.separator + Cnst.saveExcelTemp);
        if (p.notExists(file)) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }


    private void NmEngSet(DaoChu daoChu) {
        if (p.empty(daoChu.getNmEng())) {
            if (p.notEmpty(daoChu)) {
                if (p.notEmpty(daoChu.getCusNo())) {
                    CustWithBLOBs custWithBLOBs = cnst.custMapper.selectByPrimaryKey(daoChu.getCusNo());
                    if (custWithBLOBs == null) {
                        CustExample ce = new CustExample();
                        ce.createCriteria().andNameEqualTo(daoChu.getCusName());
                        List<CustWithBLOBs> custWithBLOBs1 = cnst.custMapper.selectByExampleWithBLOBs(ce);
                        if (p.notEmpty(custWithBLOBs1)) {
                            daoChu.setNmEng(custWithBLOBs1.get(0).getNmEng());
                        }
                    } else {
                        daoChu.setNmEng(custWithBLOBs.getNmEng());
                    }

                }
            }
        }

    }


    private String a缩略图全路径生成(DaoChu daoChu) {
        String thum = "";
        //顺便把thum的具体路径给设置好
        //            suoLueTuAndFuJian/636260305823469446.jpg;
        try {
            //此try可以达到有缩略图的用缩略图,无缩略图的不用缩略图,避免了一堆复杂判断
            //用try是因为可能有很多截取出错的地方
            thum = jarPath
                    + (
                    cnst.daYangSuoLueTuAndFuJianZongPath.substring(2)
                            + p.chaiFenZuHeFenGeFu(daoChu.getThum().replace(";", p.zuHeFenGeFu)).get(0)
            ).replace("/", File.separator);
        } catch (Exception e) {
//            p.p1("wufa jiequ thum zifuchuan  ,keneng shi kongde,ye keneng shi null");
        }
        return thum;
    }


    private void a复制daoChu对象(DaoChu daoChu, DaoChu daoChu1, DaoChu daoChu2, DaoChu daoChu3, DaoChu daoChu4) {
        //复制一个不是空的
        if (p.notEmpty(daoChu1)) {
            BeanUtils.copyProperties(daoChu1, daoChu);
            return;
        }
        if (p.notEmpty(daoChu2)) {
            BeanUtils.copyProperties(daoChu2, daoChu);
            return;
        }
        if (p.notEmpty(daoChu3)) {
            BeanUtils.copyProperties(daoChu3, daoChu);
            return;
        }
        if (p.notEmpty(daoChu4)) {
            BeanUtils.copyProperties(daoChu4, daoChu);
            return;
        }
    }


    private void a设置daoChu对象的各种价格(DaoChu daoChu, DaoChu daoChu1, DaoChu daoChu2, DaoChu daoChu3, DaoChu daoChu4) {
        if (p.notEmpty(daoChu1)) daoChu.setHaveTransUpSaleBenBi(daoChu1.getUp());
        if (p.notEmpty(daoChu2)) daoChu.setHaveTransUpSaleWaiBi(daoChu2.getUp());
        if (p.notEmpty(daoChu3)) daoChu.setNoTransUpSaleBenBi(daoChu3.getUp());
        if (p.notEmpty(daoChu4)) daoChu.setNoTransUpSaleWaiBi(daoChu4.getUp());
    }

//    public static void main(String[]args){
//        p.p2(p.chaiFenZuHeFenGeFu("suoLueTuAndFuJian/636260305823469446.jpg;".replace(";",p.zuHeFenGeFu)).get(0));
//    }


    private org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());

    @SuppressWarnings("unchecked")
    private List<String> f得到完整导出头信息() {
        return DyExport2Thread.f得到完整导出头信息();
    }

//    public static void main(String[]args) throws UnsupportedEncodingException {
//        String s="%7B\"ids\"%3A%5B\"0000e1a2-ec00-4b06-94da-db80628473eb\"%2C\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"%5D%2C\"fields\"%3A%5B\"salName\"%2C\"thum\"%2C\"prdCode\"%2C\"mainUnit\"%2C\"haveTransUpSaleBenBi\"%2C\"haveTransUpSaleWaiBi\"%2C\"noTransUpSaleBenBi\"%2C\"noTransUpSaleWaiBi\"%5D%7D";
//       s="{\"ids\":[\"0000e1a2-ec00-4b06-94da-db80628473eb\",\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"],\"fields\":[\"salName\",\"thum\",\"prdCode\",\"mainUnit\",\"haveTransUpSaleBenBi\",\"haveTransUpSaleWaiBi\",\"noTransUpSaleBenBi\",\"noTransUpSaleWaiBi\"],\"confirmtimestr\":\"2018-06-11\",\"confirmtimestrEnd\":\"2018-06-20\"}";
//
//       s=URLEncoder.encode(s,"UTF-8");
//        p.p("-------------------------------------------------------");
//        p.p(s);
//        s=URLDecoder.decode(s);
//        p.p(s);
//        p.p("-------------------------------------------------------");
//    }


}


/*

[DaoChu{id='0009c584-ff12-4c86-9392-8f5319df12cf', prdCode='WW-NEMT-3853', idxName='金属',
idxNo='704', fenLeiNo='', fenLeiName='金属件', markName='',
 markNo='b6442245-43ee-4c09-a2df-e40813eff40b', colour=' 喷漆，亮光OCEANSIDE BLUE', size='参考：WW-NEMT-2751',
 salName='雷钧', salNo='', cusNo='61', cusName='扬州光大帽业有限公司', isfenjie='n',
 sampMake='2017-03-23 00:00:00', sampSend='', sampRequ='', sampDesc='参考：WW-NEMT-2751',

 thum='E:\1\work_space\LINZHAN\LinZhan_Picture_ReportTable\daYangSuoLueTuAndFuJianZongPath\suoLueTuAndFuJian\636260305823469446.jpg'

 , attach='suoLueTuAndFuJian/201704131714203853.jpg;suoLueTuAndFuJian/20170325093338LIFE_SPR18_023_DALCOW.pdf;',
 insertdate='2017-03-25 09:23:02', confirmman='', confirmtimestr='', isconfirm='0', category='', teamname='', confirmrem='',
 unit='', businessdesc='', financedesc='', startsellcount='', modelcost='', estimateprice='',
 littleorderprice='', modelcostinvoiceno='', financestartsellcount='', financemodelcost='',
 financelittleorderprice='', buyerdesc='', prdNo='107005482', salemandesc='', stopusedate='', cusNoGive='',
  cusNameGive='', userName='', tenantId='', mainUnit='', up='', haveTransUpSaleBenBi='',
  haveTransUpSaleWaiBi='0.34960000', noTransUpSaleBenBi='2.12000000', noTransUpSaleWaiBi='0.33400000'}]
-------------------------------------------------------

*/
