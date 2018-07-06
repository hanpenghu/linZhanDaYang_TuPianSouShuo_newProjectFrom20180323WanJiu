package com.winwin.picreport.Futils.excelHan;
//import com.alibaba.fastjson.JSON;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFRenderer;
import org.freehep.graphicsio.emf.gdi.BitmapInfoHeader;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
//import org.freehep.graphicsio.emf.EMFInputStream;
//import org.freehep.graphicsio.emf.EMFRenderer;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 *注意整个工具的核心框架是 excel的要求:
 * 1  sheet必须只有一个,即sheet的索引只有0
 * 2  必须有表头,就是第一行是表头,计算是从第二行(索引是1)算有效数据的
 * 3  以每一行为一个单位,就是说把Excel的一行看成一条将要入数据库的一条数据来看待
 *
 * //当没有一行的时候,List<ExcelPicTxtTemplate>为[]
 //当没有一行文字只有图片的时候 List<ExcelPicTxtTemplate>为[]也为空

 //该行的所有图片//当没有图片的时候List<ExcelPicTemplate>为空[]
 * */
public class Excel2007 {
    private final static String emf="image/x-emf";
    public static void main(String[]args) throws IOException {



        Excel2007 g = Excel2007.g();
        String s="E:\\image87.emf";
     s="E:\\2.emf";
        EMFInputStream inputStream = new EMFInputStream(new FileInputStream(s), EMFInputStream.DEFAULT_VERSION);
        byte[] bytes = g.emfToPng(inputStream);
        System.out.println(bytes);
        p.writeByteToFile(bytes,new File("E:/12.jpg"));
//        File file=new File("E:/打样上传模板20180310.xlsx");
//        File file=new File(s);
//        List<ExcelPicTxtTemplate> excelPicTxt = g.getExcelPicTxt(file);
//        for(ExcelPicTxtTemplate e:excelPicTxt){
//            PictureData pictureData = e.getTxtRowPicDataList().get(0).getPictureData();
//            if(emf.equals(pictureData.getMimeType())){
////                g.emfToPng(new ByteArrayInputStream(pictureData.getData()));
//            }else{
//                System.out.println(pictureData.getMimeType());
//            }
//        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //建造者
    public static Excel2007 g(){
        return new Excel2007();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //得到所有行的文本和图片的list
    public  List<ExcelPicTxtTemplate> getExcelPicTxt(File excelFile) throws IOException {
        //得到所有的文本行
        List<List<ExcelTxtTemplate>> excelTxt = this.getExcelTxt(excelFile);
        //得到所有的带属性的图片
        List<ExcelPicTemplate> excelPic = this.getExcelPic(excelFile);
        List<ExcelPicTxtTemplate> list=new LinkedList<>();
        for(List<ExcelTxtTemplate> list1:excelTxt){
            //注意一个list1代表excel中的一行数据
            ExcelPicTxtTemplate eptt=new ExcelPicTxtTemplate();
            eptt.setTxtRowList(list1);
            List<ExcelPicTemplate> txtRowPicDataList= this.packagePic(list1,excelPic);
            eptt.setTxtRowPicDataList(txtRowPicDataList);
            list.add(eptt);
        }
        return list;
    }

    private List<ExcelPicTemplate> packagePic(List<ExcelTxtTemplate> list1, List<ExcelPicTemplate> excelPic) {
        ExcelTxtTemplate excelTxtTemplate = list1.get(0);
        int txtSheetNum = excelTxtTemplate.getTxtSheetNum();
        int txtRowNum = excelTxtTemplate.getTxtRowNum();
        List<ExcelPicTemplate> txtRowPicDataList=new LinkedList<>();
        for(ExcelPicTemplate ept:excelPic){
            int picRowNum = ept.getPicRowNum();
            int picSheetNum = ept.getPicSheetNum();
            if(txtSheetNum==picSheetNum&&txtRowNum==picRowNum){
                txtRowPicDataList.add(ept);
            }
        }
        return txtRowPicDataList;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //注意内层的List<ExcelTxtTemplate>代表了一行,外层的List<List<ExcelTxtTemplate>>代表所有行,就是整个sheet内容
    //其实是从索引为1的行开始存入,因为第一行为表头
    public  List<List<ExcelTxtTemplate>> getExcelTxt(File excelFile) throws IOException {
        // 创建流
        InputStream input = new FileInputStream(excelFile);
        // 获取文件后缀名(不带点)
        String fileExt =  excelFile.getName().substring(excelFile.getName().lastIndexOf(".") + 1);
        if ("xlsx".equals(fileExt)) {
            //继续,不做任何处理
        }else{
            throw new RuntimeException("你的xlsx不是2007以上版本或者根本不是excel");
        }
        // 创建Workbook,就是整个excel
        Workbook wb  = new XSSFWorkbook(input);
        // 创建sheet,默认只有一个sheet
        Sheet sheet0  = wb.getSheetAt(0);
        //变成2007以上版本的Sheet
        XSSFSheet sheet=(XSSFSheet)sheet0;
        //////////////通过表头找到总列数////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //得到第一行表头,为将来判断有几列做准备
        XSSFRow row0 = sheet.getRow(0);
        int zongLieShu=0;
        while(true){
            String str = null;
            try {
                str = row0.getCell(zongLieShu).getRichStringCellValue().getString();
            } catch (Exception e) {}
            if(null!=str&&!"".equals(str)){
                zongLieShu++;
            }else {
                zongLieShu=zongLieShu;//注意zongLieShu是从1开始数的总列数
                break;
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 得到总行数//包括表头的,从0开始的索引
        int rowNum = sheet.getLastRowNum();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //下面的循环是为了去除空行,以从0开始所有列为准,如果不都是空的,代表本行有数据
        int ak47=0;//ak47代表某一行//最后ak47++后代表的是行数的所有索引
        while(true){
            String str = null;
            //将来用来判断某一行是否都是空的内容集合
            List<String>strs=new ArrayList<>();
            try {
                for(int i=0;i<zongLieShu;i++){
                    str = sheet.getRow(ak47).getCell(i).getRichStringCellValue().getString();
                    strs.add(str);
                }
            } catch (Exception e) {}
            if(notAllEmpty(strs.toArray())){//不是所有的都为空的,意思是只要有不是空的
                ak47++;
            }else {
                rowNum=ak47;////注意rowNum是从1开始数的总行数
                break;
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //创建存储文本及其属性的list//存储所有列
        List<List<ExcelTxtTemplate>> txtss=new LinkedList<>();
        // 正文内容应该从第二行(索引为1)开始,第一行为表头的标题
        for (int i = 1; i < rowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            //存储某一列
            List<ExcelTxtTemplate>txts=new LinkedList<>();
            //注意zongLieShu其实是总列数,所以我们列的索引是从0开始
            for(int j=0;j<zongLieShu;j++){
                ExcelTxtTemplate ett=new ExcelTxtTemplate();
                XSSFCell cell = row.getCell(j);
                String txt;

                if (cell != null) {
                    // 判断当前Cell的Type
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC//如果case中没有break,那么下面继续执行case但是不再判断条件
                            System.out.println("!!!!!!!!!!!cell.getNumericCellValue()="+cell.getNumericCellValue()+"!!!!!!!!!!!!!!!!!!!!!!!");
                            txt = String.valueOf(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_FORMULA: {
                            // 判断当前的cell是否为Date
                            if (DateUtil.isCellDateFormatted(cell)) {
                                // 如果是Date类型则，转化为Data格式
                                // data格式是带时分秒的：2013-7-10 0:00:00
                                // cellvalue = cell.getDateCellValue().toLocaleString();
                                // data格式是不带带时分秒的：2013-7-10
                                Date date = cell.getDateCellValue();
                                txt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                            } else {// 如果是纯数字

                                // 取得当前Cell的数值//这里会被格式化数字  成为  1.3E7这种,不如走最上面那个case
                                txt = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        }
                        case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                            // 取得当前的Cell字符串
                            txt = cell.getRichStringCellValue().getString();
                            break;
                        default:// 默认的Cell值
                            txt = "";
                    }
                } else {
                    txt = "";
                }
                //1.1853156E7
                if(null!=txt&&txt.contains("E")&&txt.contains(".")){
                    System.out.println("===========xxx1==============");
                    txt=this.changeScienceNum2CommonNum(txt);
                }
                System.out.println("-----------txt是数字的时候txt="+txt+"----------------------");
                ett.setTxt(txt);
                ett.setTxtRowNum(i);
                ett.setTxtColumnNum(j);
                //sheet固定是第0个索引
                ett.setTxtSheetNum(0);
                //下面是找该单元格对应的表头
                XSSFRow row1 = sheet.getRow(0);
                String txtColumnNameOfTableHead = row1.getCell(j).getRichStringCellValue().getString();
                ett.setTxtColumnNameOfTableHead(txtColumnNameOfTableHead);
                txts.add(ett);
            }
            //将某一列放入整个sheet的list里面,一行一放
            txtss.add(txts);
        }
        input.close();
        return txtss;
    }

    //将科学
    private String changeScienceNum2CommonNum(String txt) {
        if(this.isBigDecimal(txt.substring(0,txt.indexOf("E")))){
            //得到.到E之间的位数
            int k=txt.substring(txt.indexOf(".")+1,txt.indexOf("E")).length();
            //得到E后面的数字
            int j=Integer.valueOf(txt.substring(txt.indexOf("E")+1));
            String  h="";//将来要拼接的一堆0
            //如果.到E之间的位数小于  E后面的数字, 得到将来要补的0
            if(k<j){
                for(int i=0;i<j-k;i++){
                     h=h+"0";
                }
            }
            txt=txt.substring(0,txt.indexOf("E")).replace(".","")+h;
            System.out.println("#################"+txt+"##############3");
            return txt;
        }else{
            return txt;
        }

    }



    private boolean isBigDecimal(String str){
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //得到图片及其属性,本方法只适用于只有一个sheet的excel,并且适用于必须有表头的Excel
    //注意写死了sheet索引是0,只支持只有一个sheet的excel
    //注意row行从0开始索引
    //注意column列也是从0开始索引
    public  List<ExcelPicTemplate>
        getExcelPic(File excelFile)
            throws IOException {
        // 创建流
        InputStream input = new FileInputStream(excelFile);
        // 获取文件后缀名(不带点)
        String fileExt =  excelFile.getName()
                .substring(excelFile.getName().lastIndexOf(".") + 1);
        if ("xlsx".equals(fileExt)) {
            //继续,不做任何处理
        }else{
            throw new RuntimeException("你的xlsx不是2007以上版本或者根本不是excel");
        }
        // 创建Workbook,就是整个excel
        Workbook wb  = new XSSFWorkbook(input);
        // 创建sheet,默认只有一个sheet
        Sheet sheet0  = wb.getSheetAt(0);
        //变成2007以上版本的Sheet
        XSSFSheet sheet=(XSSFSheet)sheet0;
        //创建存储图片及其属性的list
        List<ExcelPicTemplate> pics=new LinkedList<>();
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            //循环sheet里面的所有图片
            if (dr instanceof XSSFDrawing) {
                //如果是图片继续执行
                //得到所有的图像
                XSSFDrawing drawing = (XSSFDrawing) dr;
                //得到所有图片
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    //循环所有图像
                    //得到xlsx图片
                    XSSFPicture pic = (XSSFPicture) shape;
                    //得到图片作者
                    XSSFClientAnchor anchor = pic.getPreferredSize();
                    //得到图片的标志
                    CTMarker ctMarker = anchor.getFrom();
                    //得到图片二进制数据
                    PictureData pictureData = pic.getPictureData();
//                    System.out.println("-------图片类型-----pictureData.getMimeType()--------------"+pictureData.getMimeType()+"-------------------");
                    //得到图片所在行
                    int row = ctMarker.getRow();
                    //得到图片所在列
                    int col = ctMarker.getCol();
                    ExcelPicTemplate ept=new ExcelPicTemplate();
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //下面是找到picColumnName(该图片所在的表头内容)
                    //表头是第0行
                    int biaoTouRow=0;
                    //当前图片所在的表头列
                    int biaoTouCol=col;
                    //得到图片所在的表头的行数据
                    Row rowTxtData = sheet.getRow(biaoTouRow);
                    //得到图片所在的表头的单元格数据
                    Cell cell = rowTxtData.getCell(biaoTouCol);
                    // 取得当前的Cell字符串//图片对应的表头内容
                    String cellvalue = cell.getRichStringCellValue().getString();
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //设置图片所在表头的内容
                    ept.setPicColumnNameOfTableHead(cellvalue);
                    //设置图片二进制数据
                    ept.setPictureData(pictureData);
                    //第0个sheet索引
                    ept.setPicSheetNum(0);
                    //设置列号
                    ept.setPicColumnNum(col);
                    //设置行号
                    ept.setPicRowNum(row);
                    //将当前的图片及其属性放到list集合
                    pics.add(ept);
                }
            }else{
                //如果不是图片就抛出异常
            }

        }
        input.close();
        return pics;
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *以下是空判断和非空判断以及所有非空判断和所有空的判断,如果是包含空的
     * 判断请用   !allNotEmpty
     * */

    public static boolean empty(Object ob){

        if(notEmpty(ob)){
            return false;
        }else{
            return true;
        }

    }




    public static boolean notEmpty(Object ob){
        if(ob==null){
            return false;
        }else{
            if(ob instanceof String){
                if("".equals(ob)){return false;}else{return true;}
            }else if(ob instanceof Collection){
                if(((Collection) ob).size()>0){return true;}else{return false;}
            }else if(ob instanceof Map){
                if(((Map) ob).size()>0){return true;}else{return false;}
            }/*else if(ob instanceof JSONObject){
                if(((JSONObject) ob).isEmpty()){return false;}else{
                    if(((JSONObject) ob).size()==0){return false;}else{return true;}
                }
            }else if(ob instanceof JSONArray){
                if(((JSONArray) ob).isEmpty()){return false;}else{
                    if(((JSONArray) ob).size()==0){return false;}else{return true;}
                }
            }*/else{return true;}
        }
    }

    //所有的非空
    public static boolean allNotEmpty(Object[ ]obs){
        for(Object ob:obs){
            if(!notEmpty(ob)){return false;}
        }
        return true;
    }

    //不是所有的是空的,有不为空的
    public static boolean notAllEmpty(Object[ ]obs){
        int i=0;
        for(Object ob:obs){
            if(notEmpty(ob)){i++;}
        }
        if(i>0){
            return true;
        }else{
            return false;
        }

    }
    //测试notAllEmpty
//    public static void main(String[]args){
//           p.p(notAllEmpty(p.gp().setArl("1").setArl(null).getArl().toArray()));
//    }

    public static boolean allEmpty(Object[ ]obs){
        for(int i=1;i<=obs.length;i++){
            /**
             *循环所有,如果有一个不是空的,就代表有不是空的,不是所有是空的,返回false
             * */
            if(notEmpty(obs[i])){
                return false;
            }
            /**
             *如果到了最后一个,也是空的,就返回true,代表所有的都空了
             * */
            if(empty(obs[i])&&i==obs.length){
                return true;
            }
        }
        return false;
    }

    private byte[] emfToPng(InputStream is) {
        byte[] by = null;
        EMFInputStream emfis = null;
        EMFRenderer emfRenderer = null;
//创建储存图片二进制流的输出流
        ByteArrayOutputStream baos = null;
//创建ImageOutputStream流
        ImageOutputStream imageOutputStream = null;
        try {
            System.out.println(is==null);
            emfis = new EMFInputStream(is, EMFInputStream.DEFAULT_VERSION);
            System.out.println(emfis==null);

            System.out.println("--------我日1-----------");
            final int width = (int) emfis.readHeader().getBounds().getWidth();
            final int height = (int) emfis.readHeader().getBounds().getHeight();
            System.out.println(width+"："+height);

            final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = (Graphics2D) result.createGraphics();
//            BitmapInfoHeader headerInfo = new BitmapInfoHeader(emfis);
//
//            System.out.println("&&&&&&&headerInfo.getHeight()&&&&&&&&&&&&《"+headerInfo.getHeight()+"》&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//            System.out.println("&&&&&&&&&&&headerInfo.getWidth()&&&《"+headerInfo.getWidth()+"》&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            emfRenderer = new EMFRenderer(emfis);
            emfRenderer.paint(g2);
            System.out.println("--------我日2-----------");
//创建储存图片二进制流的输出流
            baos = new ByteArrayOutputStream();
//创建ImageOutputStream流
            imageOutputStream = ImageIO.createImageOutputStream(baos);
//将二进制数据写进ByteArrayOutputStream
            ImageIO.write(result, "png", imageOutputStream);
//inputStream = new ByteArrayInputStream(baos.toByteArray());
            by = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (imageOutputStream != null) {
                    imageOutputStream.close();
                }
                if (baos != null) {
                    baos.close();
                }
                if (emfRenderer != null) {
                    emfRenderer.closeFigure();
                }
                if (emfis != null) {
                    emfis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return by;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
