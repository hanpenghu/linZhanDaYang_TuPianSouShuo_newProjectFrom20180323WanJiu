package com.winwin.picreport.Bcontroller.daYang.DaYangExportExcel;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Edto.CustExample;
import com.winwin.picreport.Edto.CustWithBLOBs;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.linklistT;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Administrator on 2018/6/1.
 */
@SuppressWarnings("unchecked")
@CrossOrigin
@RestController
public class DyExport2Thread {

    @Autowired
    private Cnst cnst;

    private String jarPath;

    /**
     * param后面跟上一个URLEncode的json
     * http://localhost:8070/dyExportExcel?param=%7B%22ids%22%3A%5B%220000e1a2-ec00-4b06-94da-db80628473eb%22%2C%2200013fb7-ba16-4ad2-9ca6-7257c660f9a3%22%5D%2C%22fields%22%3A%5B%22salName%22%2C%22thum%22%2C%22prdCode%22%2C%22mainUnit%22%2C%22haveTransUpSaleBenBi%22%2C%22haveTransUpSaleWaiBi%22%2C%22noTransUpSaleBenBi%22%2C%22noTransUpSaleWaiBi%22%5D%2C%22confirmtimestr%22%3A%222018-06-11%22%2C%22confirmtimestrEnd%22%3A%222018-06-20%22%7D
     * 传参：
     * {"ids":["id1","id2","id3"],"fields":["field1","field2","field3"]}
     * 第一个list是确定下载那些行
     * 第二个列表是确定下载那些列
     * js请求:
     * Content-Type    application/json
     * //        List<DaoChu> prdtSamp001s = cnst.a001TongYongMapper.getPrdtSamp001(ids);
     *
     * @RequestBody ExportXlsParam ep
     * <p>
     * 0009c584-ff12-4c86-9392-8f5319df12cf  thum有东西
     * <p>
     * 0000436d-0797-4e7b-9d8d-3ff0a30ea5c0   thum是null或者""
     * <p>
     * 这种方式并不完美,完美的方式是返回一个url给前端下载,
     * <p>
     * 注意,这个方法还存在单位 mainUnit的问题,  因为我们的单位在界面是保存在up_def
     * 的hj_no中  ,  比如   主:pcs  副:pcs    这种
     * ,但是我现在取出的是  prdt中的ut主单位,   这就有点问题了,因为当时定价的单位是保存在up_def的hj_no的,虽然也检查了
     * prdt是否有单位,但是 到时候要看  客户要哪个了, 这是一开始系统跟erp系统融合后主副单位 不统一用prdt还是up_def表而导致的
     */

    @RequestMapping(value = "dyExportExcel2Thread", method = RequestMethod.GET)//注意,下面这个param这玩意会自动解码decode
    public Msg 打样产品导出(@Param("param") String param, @Param("tenantId") String tenantId, @Param("userEmail") String userEmail){
        p.p("-------------------------------------------------------");
        p.p("dyExportExcel2Thread");
        p.p("-------------------------------------------------------");
        List<String> msg = new LinkedList<String>();
        try {
            this.isIgll(tenantId, userEmail, msg);
            this.mainF(param, tenantId, userEmail, msg);
        } catch (Exception e) {
            String message = e.getMessage();
            if (msg.contains(message)) {
                return Msg.gmg().setStatus("0").setMsg("失败!" + message);
            } else {
                return Msg.gmg().setStatus("0").setMsg("失败!未知异常！" + message);
            }
        }
        return Msg.gmg().setStatus("1").setMsg("正在下载,下载完成后移至下载中心下载到本地！");
    }

    private void isIgll(String tenantId, String userEmail, List<String> msg) {
        if (p.empty(tenantId) || p.empty(userEmail)) {
            p.throwEAddToList("前端传过来的公司id或者用户名是空的", msg);
        }
    }

    private void mainF(String param, String tenantId, String userEmail, List<String> msg) throws Exception {
        String dateStr = p.sjc2StrDate(p.getTimeStamp());
        String excelName001 = p.ra3o();
        jarPath = p.springBootJarPath();
        //String ss="\"ids\":[\"0000e1a2-ec00-4b06-94da-db80628473eb\",\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"],\"fields\":[\"salName\",\"thum\",\"prdCode\",\"mainUnit\",\"haveTransUpSaleBenBi\",\"haveTransUpSaleWaiBi\",\"noTransUpSaleBenBi\",\"noTransUpSaleWaiBi\"]}{";
        //        p.p("----1-------------打样产品导出 excel, 刚进入接口 dyExportExcel 的参数 param 如下--------------------------------------");
        //        p.p(param);
        //        p.p("-------------------------------------------------------");
        ExportXlsParam ep = this.formatJsonFromFront(param);
        if (null == ep) {
            p.throwEAddToList("前端传过来的参数是null", msg);
        }
        List<String> idsFromConfirmTime = this.idsFromManyConditionSearch(ep);
        //        p.p("--------------------this.idsFromManyConditionSearch(ep, idsFromManyConditionSearch);-----------------------------------");
        //        p.p(idsFromConfirmTime);
        //        p.p("-------------------------------------------------------");
        List<String> list导出头信息 = this.f得到完整导出头信息();
        //注意  ep  是 空的,会直接报错给前端,不用管
        List<String> ids = ep.getIds();
        //为了装入 idsFromManyConditionSearch
        if (null == ids) {
            ids = new LinkedList<String>();
        }
        //下载的总条数是否超过6万
//        BigDecimal bbb=this.isDownLoadCountOverIgll(msg);
        //将确认时间得到的id放入  全局id集合
        this.perfectIds(ids, idsFromConfirmTime);
        if (p.empty(ids)) {
            p.throwEAddToList("《您所选则的条件没有任何记录》得到时间获得的ids和前端传过来的ids之后,ids是null或者空", msg);
        }

//        BigDecimal bb = p.b(ids.size());
//        this.writeThisDownCountIntoFile(  bbb.add(bb)   );

        //线程里面传不进去ids,放到对象里穿进去
        Map<String,List<String>> mapids=new HashMap();
        mapids.put("ids",ids);
        p.p("-------------------mapids.put(\"ids\",ids);------------------------------------");
        p.p(ids);
        p.p("-------------------------------------------------------");

        List<String> 前端穿过来要显示的fields = ep.getFields();
        if (p.notEmpty(前端穿过来要显示的fields)) {
            this.a干掉excel中不需要的字段(list导出头信息, 前端穿过来要显示的fields);
        }
        //超过2000条数据就会超过200M的图片, 会出问题, 每个图片按100K算
        this.igllManyPicOutOfMerory(ids,msg,list导出头信息);
        new Thread(() -> {
            p.p("-------------------------------------------------------");
            p.p("进入线程");
            p.p("-------------------------------------------------------");
            try {
                p.p("---------------------mapids.get(\"ids\").size()----------------------------------");
                p.p(mapids.get("ids").size());
                p.p("-------------------------------------------------------");
                List<DaoChu> daoChus = this.ids分批得到DaoChu(mapids.get("ids"));
                p.p("-------------List<DaoChu> daoChus = this.ids分批得到DaoChu(mapids.get(\"ids\"))------------------------------------------");
                p.p(daoChus.size());
                p.p("-------------------------------------------------------");
                if (p.empty(daoChus)) {
                    p.throwEAddToList("《您所选则的条件没有任何记录》daoChus是null", msg);
                }

                //把字段写入excel
                Map<String, String> m = this.a写入excel(daoChus, list导出头信息,excelName001);
                File file = new File(m.get(this.excelPath));
                file.createNewFile();
                //将创建的excel情况放入数据库
                this.dbRec(tenantId,userEmail,m,dateStr);
//                this.downCountSubstract( bb );
               } catch (Exception e) {
                //如果组装excel异常在数据库记录一个下载失败的对象
                    this.recErrorDownLoad(tenantId,userEmail,dateStr);
//                    this.downCountSubstract(bb);
            }
            p.p("-------------------------------------------------------");
            p.p("线程结束");
            p.p("-------------------------------------------------------");
        }).start();

    }

    private void igllManyPicOutOfMerory(List<String> ids, List<String> msg,List<String> list导出头信息) {
        //此时不用管,随便导出excel
        if(!list导出头信息.contains("Product Photo 打样产品照片或图籍"))return;
        if(ids!=null&&ids.size()>2000)p.throwEAddToList("您导出的excel带图片并且大于2000条,会导致jvm堆栈溢出,如果您真的要导出大于2000条的excel,建议设置不要选取图片选项",msg);
    }

//    private void downCountSubstract(BigDecimal bb) {
//        File file = new File(down);
//        String s = p.readAllTxt(file.getAbsolutePath());
//        if(p.b(s).compareTo(p.b(0))==1){
//            BigDecimal sb = p.b(s).subtract(bb);
//            if(sb.compareTo(p.b(0))==-1){
//                sb=p.b(0);
//            }
//            p.writeToTxt(String.valueOf(sb),new File(down).getAbsolutePath());
//        }
//    }

    private String down="down";
//    private void writeThisDownCountIntoFile(BigDecimal bbb) {
//        p.writeToTxt(String.valueOf(bbb),new File(down).getAbsolutePath());
//    }

//    private BigDecimal isDownLoadCountOverIgll(List<String> msg) throws Exception {
//        File file = new File(down);
//        if(p.notExists(file)){
//            file.createNewFile();
//        }
//        String s = p.readAllTxt(file.getAbsolutePath());
//        if(p.notEmpty(s)){
//            if(!p.isBd(s)){
//                p.throwEAddToList("统计后台下载数目不是数字",msg);
//            }else{
//                if(p.b(s).compareTo(p.b(59999))==1){
//                    p.throwEAddToList("已有超过6万条数据正在下载，请稍后重试",msg);
//                }
//            }
//        }else{
//            s="0";
//        }
//        return p.b(s);
//    }

//
//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(p.b(9999).compareTo(p.b(999000)));
//        p.p("-------------------------------------------------------");
//    }



    private void dbRec(String tenantId, String userEmail, Map<String, String> m, String dateStr) {
        String down = cnst.a001TongYongMapper.selectDown(tenantId, userEmail);
        List<GetDownLoadCenterEntity> list;
        if (p.empty(down)) {
            list = new LinkedList<GetDownLoadCenterEntity>();
        } else {
            list = JSON.parseArray(down, GetDownLoadCenterEntity.class);
        }
        GetDownLoadCenterEntity g = new GetDownLoadCenterEntity();
        g.setUrl(m.get(this.excelName));
        g.setStatus("1");
        g.setTime(dateStr);
        list.add(g);
        int i = cnst.a001TongYongMapper.updateDown(tenantId, userEmail, JSON.toJSONString(list));
    }


    private void recErrorDownLoad(String tenantId, String userEmail, String dateStr) {
        String down = cnst.a001TongYongMapper.selectDown(tenantId, userEmail);
        List<GetDownLoadCenterEntity> list;
        if (p.empty(down)) {
            list = new LinkedList<GetDownLoadCenterEntity>();
        } else {
            list = JSON.parseArray(down, GetDownLoadCenterEntity.class);
        }
        GetDownLoadCenterEntity g = new GetDownLoadCenterEntity();
        g.setUrl("下载失败");
        g.setStatus("0");
        g.setTime(dateStr);
        list.add(g);
        int i = cnst.a001TongYongMapper.updateDown(tenantId, userEmail, JSON.toJSONString(list));
    }


    private List<DaoChu> ids分批得到DaoChu(List<String> ids) {
        p.p("-------------------------------------------------------");
        p.p("ids分批得到DaoChu开始");
        p.p("-------------------------------------------------------");
        List<DaoChu> daoChus = new LinkedList<DaoChu>();
        p.p("-----------------------ids.size()--------------------------------");
        p.p(ids.size());
        p.p("-------------------------------------------------------");
        List<List<String>> lists = p.avgList(ids, 40);
        p.p("---------------阿斯顿发骄傲了是大家--------------List<List<String>> lists = p.avgList(ids, 40)--------------------------");
        p.p(lists);
        p.p("-------------------------------------------------------");
        int iiii=1;
        for (List<String> ls : lists) {
            p.p("第《"+iiii+"》次得到daoChus");
            p.p("-------------------------------------------------------");
            p.p("开始得到daoChus");
            p.p("-------------------------------------------------------");
            List<DaoChu> daoChus1 = cnst.a001TongYongMapper.getDaoChus(ls);
            p.p("----------------daoChus1---------------------------------------");
            p.p(daoChus1.size());
            p.p("-------------------------------------------------------");
            daoChus.addAll(daoChus1);
            p.p("-------------------------------------------------------");
            p.p("结束得到daoChus");
            p.p("-------------------------------------------------------");
            iiii=iiii+1;
        }
        p.p("-------------------------------------------------------");
        p.p("ids分批得到DaoChu结束");
        p.p("-------------------------------------------------------");
        return daoChus;
    }


    //完善ids,主要是从传入时间也得到的ids放进来
    private void perfectIds(List<String> ids, List<String> idsFromConfirmTime) {
        //        p.p("--perfectIds()----idsFromManyConditionSearch=" + idsFromConfirmTime + "----------------");
        //        p.p("---perfectIds()---ids=" + ids + "----------------");
        if (p.notEmpty(ids)) {
            //            l.error("----3---前端穿过来的ids不为空----------------");
        }
        if (ids != null && ids.size() == 0 && idsFromConfirmTime != null && idsFromConfirmTime.size() > 0) {
            ids.addAll(idsFromConfirmTime);
        }
        if (p.notEmpty(ids)) {
            //            l.error("-----4------最终得到的ids不为空--------------");
        }
        p.removeNull(ids);
    }


    private List<String> idsFromManyConditionSearch(ExportXlsParam ep) {
        List<ExportXlsParam> epList = new LinkedList<ExportXlsParam>();
        if (p.empty(ep.getFenLeiName())) {
            epList.add(ep);
        } else {
            List<String> fenLeiNameList = cnst.a001TongYongMapper.diGuiFenLeiName(ep.getFenLeiName());
            if (p.notEmpty(fenLeiNameList)) {
                for (String s : fenLeiNameList) {
                    if (p.notEmpty(s)) {
                        ExportXlsParam e = new ExportXlsParam();
                        BeanUtils.copyProperties(ep, e);
                        e.setFenLeiName(s);
                        epList.add(e);
                    }
                }
            }
        }

        List<String> ids来自多条件查询 = new LinkedList<>();
        for (ExportXlsParam ee : epList) {
            List<String> idList一次查询 = this.f得到一次多条件的ids(ee);
            if (p.notEmpty(idList一次查询)) {
                ids来自多条件查询.addAll(idList一次查询);
            }
        }

        return ids来自多条件查询;
    }

    private List<String> f得到一次多条件的ids(ExportXlsParam ep) {
//        p.p("---------idsFromManyConditionSearch--------------ExportXlsParam--------------------------------");
//        p.p(ep);
//        p.p("-------------------------------------------------------");
        List<String> ids来自多条件查询 = null;
        //起止时间有一个非空才取id//注意,sql限制最多取出500个
        //通过确认时间过得id
//        if(this.f多条件查询成立条件(ep)){
        ids来自多条件查询 = cnst.a001TongYongMapper.getIdUseConfirmTime(ep);
        if (p.notEmpty(ids来自多条件查询)) {
            //                l.error("--2----起止时间得到的ids不为空----------");
        } else {
            //                l.error("--2----起止时间得到的ids为null---idsFromManyConditionSearch=" + ids来自多条件查询 + "-------");
        }
        //            p.p("--idsFromManyConditionSearch= cnst.a001TongYongMapper.getIdUseConfirmTime-----------------------------------------------------");
        //            p.p(ids来自多条件查询);
        //            p.p("-------------------------------------------------------");
//        }
        return ids来自多条件查询;
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


    //    @Scheduled(initialDelay = 7200000,fixedDelay = 7200000)//2小时一次
    @Scheduled(cron = "0 0 23 * * ?")//每天23点执行
    public void a定时清空excel临时目录的内容() {
        try {
            new File(f创建存储excel的临时目录不带杠()).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String excelPath = "excelPath";
    private String excelName = "excelName";

    private Map<String, String> a写入excel(List<DaoChu> daoChus, List<String> list导出头信息,String excelName001) {
        String excelName = Cnst.SampExport + excelName001 + ".xls";
        String a临时目录不带杠绝对路径 = f创建存储excel的临时目录不带杠();
        String excelPath = a临时目录不带杠绝对路径 + File.separator + excelName;
        FileOutputStream fileOut = null;
        try {
            //创建excel
            HSSFWorkbook wb = new HSSFWorkbook();
            //创建sheet1
            HSSFSheet sheet1 = wb.createSheet("sheet1");
            HSSFCellStyle cellStyle = wb.createCellStyle();  //创建设置EXCEL表格样式对象 cellStyle
            cellStyle.setWrapText(true);//设置自动换行
            this.a写行列(daoChus, sheet1, cellStyle, wb, list导出头信息);
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
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put(this.excelPath, excelPath);
        map.put(this.excelName, excelName);
        return map;
    }


    private void a写行列(List<DaoChu> daoChus, HSSFSheet sheet1, HSSFCellStyle cellStyle, HSSFWorkbook wb, List<String> list导出头信息) {
       this.a写行头(sheet1.createRow(0), sheet1, cellStyle, list导出头信息);//第0行写成行头
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
            if ("Win Win Merchandiser WinWin 负责业务员".equals(s)) {
                cell.setCellValue(daoChu.getSalName()); // 设置内容 0
            }
            if ("Inquiry Source 帽厂/NE".equals(s)) {
                cell.setCellValue(daoChu.getCusName()); // 设置内容  1
            }
                /*NE CODE
                NE编码*/
            if ("NE CODE NE编码".equals(s)) {
                cell.setCellValue(daoChu.getNmEng()); // 设置内容  2
            }

            if ("Win Win Model# WinWin编号".equals(s)) {
                cell.setCellValue(daoChu.getPrdCode()); // 设置内容  3
            }
            if ("产品大中类（中文）".equals(s)) {
                cell.setCellValue(daoChu.getFenLeiName()); // 设置内容  4
            }
            if ("产品大中类（英文）".equals(s)) {
                cell.setCellValue(""); // 设置内容  5
            }
            if ("产品子中类（中文）".equals(s)) {
                cell.setCellValue(daoChu.getIdxName()); // 设置内容 6
            }
            if ("产品子中类（英文）".equals(s)) {
                cell.setCellValue(""); // 设置内容 7
            }
            if ("Product Photo 打样产品照片或图籍".equals(s)) {//设置照片
                p.p("=================设置照片=================================");
//                    cell.setCellValue(""); // 设置内容 8
//                p.p2(daoChu.getThum());
                try {
                    this.a设置照片(daoChu.getThum(), sheet1, row, wb, 列计数器, i行计数器);
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
            if ("Category Name".equals(s)) {
                cell.setCellValue(daoChu.getCategory()); // 设置内容 9
            }
            if ("Team Name".equals(s)) {
                cell.setCellValue(daoChu.getTeamname()); // 设置内容 10
            }
            if ("颜色".equals(s)) {
                cell.setCellValue(daoChu.getColour()); // 设置内容11
            }
            if ("尺寸".equals(s)) {
                cell.setCellValue(daoChu.getSize()); // 设置内容12
            }
            if ("单位".equals(s)) {                          ///////////////////////////////
                cell.setCellValue(daoChu.getMainUnit()); // 设置内容13
            }
            if ("Price 单价美元".equals(s)) {
                String noTransUpSaleWaiBi = daoChu.getNoTransUpSaleWaiBi();
//                p.p("------------------noTransUpSaleWaiBi-------------------------------------");
//                p.p(noTransUpSaleWaiBi);
//                p.p("-------------------------------------------------------");
                if (p.notEmpty(noTransUpSaleWaiBi)) {
                    noTransUpSaleWaiBi = p.del0(noTransUpSaleWaiBi);
                    noTransUpSaleWaiBi = p.dollor + noTransUpSaleWaiBi;
                }
                cell.setCellValue(noTransUpSaleWaiBi); // 设置内容--14
//                p.p("----------------------noTransUpSaleWaiBi---------------------------------");
//                p.p(noTransUpSaleWaiBi);
//                p.p("-------------------------------------------------------");
            }
            if ("Price 单价(Lisa填写)".equals(s)) {
                String noTransUpSaleBenBi = daoChu.getNoTransUpSaleBenBi();
                if (p.notEmpty(noTransUpSaleBenBi)) {
                    noTransUpSaleBenBi = p.del0(noTransUpSaleBenBi);
                    noTransUpSaleBenBi = p.rmb + noTransUpSaleBenBi;
                }
                cell.setCellValue(noTransUpSaleBenBi); // 设置内容--15
            }
            if ("含运费价格 美元".equals(s)) {
                String haveTransUpSaleWaiBi = daoChu.getHaveTransUpSaleWaiBi();
//                p.p("-------------------------haveTransUpSaleWaiBi------------------------------");
//                p.p(haveTransUpSaleWaiBi);
//                p.p("-------------------------------------------------------");
                if (p.notEmpty(haveTransUpSaleWaiBi)) {
                    haveTransUpSaleWaiBi = p.del0(haveTransUpSaleWaiBi);
                    haveTransUpSaleWaiBi = p.dollor + haveTransUpSaleWaiBi;
                }
                cell.setCellValue(haveTransUpSaleWaiBi); // 设置内容--  16
//                p.p("---------------------haveTransUpSaleWaiBi----------------------------------");
//                p.p(haveTransUpSaleWaiBi);
//                p.p("-------------------------------------------------------");
            }
            if ("含运费价格".equals(s)) {
                String haveTransUpSaleBenBi = daoChu.getHaveTransUpSaleBenBi();
                if (p.notEmpty(haveTransUpSaleBenBi)) {
                    haveTransUpSaleBenBi = p.del0(haveTransUpSaleBenBi);
                    haveTransUpSaleBenBi = p.rmb + haveTransUpSaleBenBi;
                }
                cell.setCellValue(haveTransUpSaleBenBi); // 设置内容--17
            }
            if ("MOQ 起订量要求 (Lisa填写)".equals(s)) {
                String financestartsellcount = daoChu.getFinancestartsellcount();
                if (p.isBd(financestartsellcount)) {
                    financestartsellcount = p.del0(financestartsellcount);
                }
                cell.setCellValue(financestartsellcount); // 设置内容--18
            }
            if ("财务小单费".equals(s)) {
                String financelittleorderprice = daoChu.getFinancelittleorderprice();
                if (p.isBd(financelittleorderprice)) {
                    financelittleorderprice = p.del0(financelittleorderprice);
                }
                cell.setCellValue(financelittleorderprice); // 设置内容--19
            }
            if ("Sample Approved Date 样品确认日期".equals(s)) {
                cell.setCellValue(daoChu.getConfirmtimestr()); // 设置内容--20
            }
            if ("NE Approval Person NE 确认人员".equals(s)) {
                cell.setCellValue(daoChu.getConfirmman()); // 设置内容--21
            }
            if ("Description 样品要求".equals(s)) {
                cell.setCellValue(daoChu.getSampRequ()); // 设置内容--22
            }
            if ("Sample Date 打样日期".equals(s)) {
                cell.setCellValue(daoChu.getSampMake()); // 设置内容23
            }
            if ("样品卡寄出日期".equals(s)) {
                cell.setCellValue(daoChu.getSampSend()); // 设置内容24
            }
            if ("停用日期".equals(s)) {
                cell.setCellValue(daoChu.getStopusedate()); // 设置内容24
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
            if(!new File(thum).exists())return;
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
        if (!a前端传过来需要显示的fields.contains("salName")) {
            daoChuExcelHeadList.remove("Win Win Merchandiser WinWin 负责业务员");
        }
        if (!a前端传过来需要显示的fields.contains("cusName")) {
            daoChuExcelHeadList.remove("Inquiry Source 帽厂/NE");
        }
        if (!a前端传过来需要显示的fields.contains("cust.nm_eng")) {
            daoChuExcelHeadList.remove("NE CODE NE编码");
        }
        if (!a前端传过来需要显示的fields.contains("prdCode")) {
            daoChuExcelHeadList.remove("Win Win Model# WinWin编号");
        }
        if (!a前端传过来需要显示的fields.contains("idxName")) {
            daoChuExcelHeadList.remove("产品大中类（中文）");
        }
        if (!a前端传过来需要显示的fields.contains("idxNameE")) {
            daoChuExcelHeadList.remove("产品大中类（英文）");
        }

        if (!a前端传过来需要显示的fields.contains("fenLeiName")) {
            daoChuExcelHeadList.remove("产品子中类（中文）");
        }
        if (!a前端传过来需要显示的fields.contains("fenLeiNameE")) {
            daoChuExcelHeadList.remove("产品子中类（英文）");
        }

        if (!a前端传过来需要显示的fields.contains("thum")) {
            daoChuExcelHeadList.remove("Product Photo 打样产品照片或图籍");
        }
        if (!a前端传过来需要显示的fields.contains("category")) {
            daoChuExcelHeadList.remove("Category Name");
        }
        if (!a前端传过来需要显示的fields.contains("teamname")) {
            daoChuExcelHeadList.remove("Team Name");
        }
        if (!a前端传过来需要显示的fields.contains("colour")) {
            daoChuExcelHeadList.remove("颜色");
        }
        if (!a前端传过来需要显示的fields.contains("size")) {
            daoChuExcelHeadList.remove("尺寸");
        }
        if (!a前端传过来需要显示的fields.contains("mainUnit")) {
            daoChuExcelHeadList.remove("单位");
        }
        if (!a前端传过来需要显示的fields.contains("noTransUpSaleWaiBi")) {
            daoChuExcelHeadList.remove("Price 单价美元");
        }
        if (!a前端传过来需要显示的fields.contains("noTransUpSaleBenBi")) {
            daoChuExcelHeadList.remove("Price 单价(Lisa填写)");
        }
        if (!a前端传过来需要显示的fields.contains("haveTransUpSaleWaiBi")) {
            daoChuExcelHeadList.remove("含运费价格 美元");
        }
        if (!a前端传过来需要显示的fields.contains("haveTransUpSaleBenBi")) {
            daoChuExcelHeadList.remove("含运费价格");
        }
        if (!a前端传过来需要显示的fields.contains("financestartsellcount")) {
            daoChuExcelHeadList.remove("MOQ 起订量要求 (Lisa填写)");
        }
        if (!a前端传过来需要显示的fields.contains("financelittleorderprice")) {
            daoChuExcelHeadList.remove("财务小单费");
        }
        if (!a前端传过来需要显示的fields.contains("confirmtimestr")) {
            daoChuExcelHeadList.remove("Sample Approved Date 样品确认日期");
        }
        if (!a前端传过来需要显示的fields.contains("confirmman")) {
            daoChuExcelHeadList.remove("NE Approval Person NE 确认人员");
        }
        if (!a前端传过来需要显示的fields.contains("sampRequ")) {
            daoChuExcelHeadList.remove("Description 样品要求");
        }
        if (!a前端传过来需要显示的fields.contains("sampMake")) {
            daoChuExcelHeadList.remove("Sample Date 打样日期");
        }
        if (!a前端传过来需要显示的fields.contains("sampSend")) {
            daoChuExcelHeadList.remove("样品卡寄出日期");
        }
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


    //对于销售定价,每次找到up_def中最近s_dd的一个
    private List<DaoChu> a根据id找到对应的要导出的来自打样主表的excel信息_主要是销售的定价和缩略图的绝对路径(List<String> ids) {
        List<DaoChu> daoChuList = new LinkedList<DaoChu>();
//        p.p("------------a根据id找到对应的要导出的来自打样主表的excel信息_主要是销售的定价和缩略图的绝对路径   的ids-------------------------------------------");
//        p.p(ids);
//        p.p("-------------------------------------------------------");
        for (String id : ids) {
            DaoChu daoChu = new DaoChu();
            //得到 haveTransUpSaleBenBi
            DaoChu daoChu1 = cnst.a001TongYongMapper.getPrdtSamp002(Cnst.saleBilTypeHaveTrans, Cnst.benBi, Cnst.salPriceId, id);
//            p.p("---------------------------daoChu1.getMainUnit()----------------------------");
            if (null != daoChu1) {
//                p.p(daoChu1.getMainUnit());
            }
//            p.p("-------------------------------------------------------");
            //haveTransUpSaleWaiBi
            DaoChu daoChu2 = cnst.a001TongYongMapper.getPrdtSamp002(Cnst.saleBilTypeHaveTrans, Cnst.USD, Cnst.salPriceId, id);
            //noTransUpSaleBenBi
            DaoChu daoChu3 = cnst.a001TongYongMapper.getPrdtSamp002(Cnst.saleBilTypeNoTrans, Cnst.benBi, Cnst.salPriceId, id);
            //noTransUpSaleWaiBi
            DaoChu daoChu4 = cnst.a001TongYongMapper.getPrdtSamp002(Cnst.saleBilTypeNoTrans, Cnst.USD, Cnst.salPriceId, id);

//            p.p("------------------------所有价格-------------------------------");
//            p.p(daoChu1.getUp());
//            p.p(daoChu2.getUp());
//            p.p(daoChu3.getUp());
//            p.p(daoChu4.getUp());
//            p.p("-------------------------------------------------------");
            this.a复制daoChu对象(daoChu, daoChu1, daoChu2, daoChu3, daoChu4);
            this.a设置daoChu对象的各种价格(daoChu, daoChu1, daoChu2, daoChu3, daoChu4);
            daoChu.setUp("");
            p.strValeOfNullSpace(daoChu);
            String thum = this.a缩略图全路径生成(daoChu);
            daoChu.setThum(thum);
            this.NmEngSet(daoChu);
            daoChuList.add(daoChu);

        }
        return daoChuList;
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
        List<String> daoChuExcelHeadList =
                new linklistT<String>()
                        .a("Win Win Merchandiser WinWin 负责业务员")//salName   0
                        .a("Inquiry Source 帽厂/NE")//cusName    1
                        .a("NE CODE NE编码")//   2   x.nm_eng
                        .a("Win Win Model# WinWin编号")//prdCode  3
                        .a("产品大中类（中文）")//4
                        .a("产品大中类（英文）")//5
                        .a("产品子中类（中文）")//idxName    6
                        .a("产品子中类（英文）")//7
                        .a("Product Photo 打样产品照片或图籍")//  8 thum
                        .a("Category Name")//category   9
                        .a("Team Name")//teamname  10
                        .a("颜色")//colour  11
                        .a("尺寸")//size  12
                        .a("单位")//mainUnit  13
                        .a("Price 单价美元")//noTransUpSaleWaiBi--  14
                        .a("Price 单价(Lisa填写)")//noTransUpSaleBenBi--  15
                        .a("含运费价格 美元")//haveTransUpSaleWaiBi--  16
                        .a("含运费价格")//haveTransUpSaleBenBi--  17
                        .a("MOQ 起订量要求 (Lisa填写)")//18
                        .a("财务小单费")//financelittleorderprice--19
                        .a("Sample Approved Date 样品确认日期")//confirmtimestr--20
                        .a("NE Approval Person NE 确认人员")//confirmman--21
                        .a("Description 样品要求")//sampRequ---22
                        .a("Sample Date 打样日期")//sampMake--23
                        .a("样品卡寄出日期").a("停用日期").g();//sampSend--24
        return daoChuExcelHeadList;
    }

    public static void main(String[] args) throws Exception {
        String s = "%7B\"ids\"%3A%5B\"0000e1a2-ec00-4b06-94da-db80628473eb\"%2C\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"%5D%2C\"fields\"%3A%5B\"salName\"%2C\"thum\"%2C\"prdCode\"%2C\"mainUnit\"%2C\"haveTransUpSaleBenBi\"%2C\"haveTransUpSaleWaiBi\"%2C\"noTransUpSaleBenBi\"%2C\"noTransUpSaleWaiBi\"%5D%7D";
        s = "{\"ids\":[\"0000e1a2-ec00-4b06-94da-db80628473eb\",\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"],\"fields\":[\"salName\",\"thum\",\"prdCode\",\"mainUnit\",\"haveTransUpSaleBenBi\",\"haveTransUpSaleWaiBi\",\"noTransUpSaleBenBi\",\"noTransUpSaleWaiBi\"],\"confirmtimestr\":\"2018-06-11\",\"confirmtimestrEnd\":\"2018-06-20\"}";
        s = "{\"ids\":[\"0000e1a2-ec00-4b06-94da-db80628473eb\",\"00013fb7-ba16-4ad2-9ca6-7257c660f9a3\"],\"fields\":[\"prdCode\",\"idxName\",\"noTransUpSaleWaiBi\"]}";
       s="{\"ids\"：[],\"fields\":[\"thum\",\"prdCode\",\"idxName\",\"noTransUpSaleWaiBi\"],\"confirmtimestr\":\"2018-06-11\",\"confirmtimestrEnd\":\"2018-06-20\"}";
        s = URLEncoder.encode(s, "UTF-8");
        p.p("-------------------------------------------------------");
        p.p(s);
        p.p("\n");
        s = URLDecoder.decode(s);
        p.p(s);
        p.p("-------------------------------------------------------");
    }


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
