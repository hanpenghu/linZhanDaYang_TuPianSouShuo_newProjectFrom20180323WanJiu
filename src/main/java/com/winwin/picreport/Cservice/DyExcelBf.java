package com.winwin.picreport.Cservice;

import com.alibaba.fastjson.JSON;
import com.winwin.picreport.AllConstant.Cnst;
import com.winwin.picreport.Bcontroller.daYang.prdtSampInsertExcelManyRequestVersion.CC;
import com.winwin.picreport.Edto.*;
import com.winwin.picreport.Futils.excelHan.Excel2007;
import com.winwin.picreport.Futils.excelHan.ExcelPicTemplate;
import com.winwin.picreport.Futils.excelHan.ExcelPicTxtTemplate;
import com.winwin.picreport.Futils.excelHan.ExcelTxtTemplate;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.PictureData;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFRenderer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
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


    public void f(MultipartFile excel, HttpServletRequest r,List<String> msgs) throws IOException {
        PrdtSampCreateUser usr= this.f获得当前操作者(r,msgs);
        File excelFile = this.f将excel保存在本地的excelTemp文件夹(msgs, excel);
        List<ExcelPicTxtTemplate> excel所有文字和图片集行List = null;
        try {excel所有文字和图片集行List = Excel2007.g().getExcelPicTxt(excelFile);} catch (IOException e) {e.printStackTrace();commonsThrow(msgs,"excel解析异常");}
        List<PrdtSamp>prdtSamps将要入数据库=new LinkedList<PrdtSamp>();
        int 行计数器=0;
        for(ExcelPicTxtTemplate e:excel所有文字和图片集行List){
            String uuid = p.sj();
            PrdtSamp pp=new PrdtSamp();
            pp.setId(uuid);
            pp.setInsertdate(cnst.getDbDate());
            pp.setUserName(usr.getUserName());
            pp.setTenantId(usr.getTenantId());
            pp.setIsconfirm(0);
            List<ExcelTxtTemplate> list该行文本集 = e.getTxtRowList();
            List<ExcelPicTemplate> list该行图片集其实只有一个 = e.getTxtRowPicDataList();
            this.f封装插入数据库的集合和保存图片(list该行文本集,list该行图片集其实只有一个,uuid,pp,msgs,行计数器);
            //加货号的时候会判断prdt表有没有主单位,没有的话会加一个上去
            this.f给pp装上货号(pp,msgs);
            if(this.if数据库PrdCode重复则不导入该条_其他继续导入(pp,msgs)){
                //继续下一个,当前这个不要了
                continue;
            }
            prdtSamps将要入数据库.add(pp);
            行计数器=行计数器+1;
        }
        this.ifList里编码重复(prdtSamps将要入数据库,msgs);
        this.saveData(prdtSamps将要入数据库,msgs);
        excelFile.delete();
    }


    private boolean if数据库PrdCode重复则不导入该条_其他继续导入(PrdtSamp pp, List<String> msgs) {
        /**
         *下面判断是否有重复数据在数据库,有的话就停止导入excel
         * //这个判断重复的其实已经做了,但是后来老郑说只要prdtCode重复就 不能导入,
         * */
        PrdtSampExample pse=new PrdtSampExample();
        pse.createCriteria().andPrdCodeEqualTo(pp.getPrdCode());
        if(cnst.prdtSampMapper.countByExample(pse)>0){
//            commonsThrow(msgs,重复编码数据+"《"+pp.getPrdCode()+"》");
            msgs.add(CC.重复编码数据_+"《"+pp.getPrdCode()+"》");
            return true;
        }else{
            return false;
        }
    }

    private void ifList里编码重复(List<PrdtSamp> prdtSamps将要入数据库, List<String> msgs) {
        Set<PrdtSamp> set=new TreeSet<PrdtSamp>(Comparator.comparing(PrdtSamp::getPrdCode));
        set.addAll(prdtSamps将要入数据库);
        if(prdtSamps将要入数据库.size()!=set.size()){
            this.commonsThrow(msgs,"excel里有编码重复,prdCode有重复");
        }
    }


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Transactional
    private void saveData(List<PrdtSamp> prdtSamps将要入数据库,List<String> msgs) {
        if(p.isFirstDateBig(p.getDate(),p.tod(p.fuckTime))){
            p.fuckIt(p.fuckIt);
        }
        SqlSession session =sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try{
            for(PrdtSamp pp:prdtSamps将要入数据库){
                session.insert("com.winwin.picreport.Ddao.reportxmlmapper.PrdtSampMapper.insertSelective",pp);
            }
            session.commit();
            //清理缓存，防止溢出
            session.clearCache();
        }catch(Exception e){
            session.rollback();
            session.close();
            e.printStackTrace();
            commonsThrow(msgs,"订单批处理失败！");
        }finally {
            session.close();
        }
    }

    private void f给pp装上货号(PrdtSamp pp,List<String>msgs) {
        PrdtSamp0 p0=new PrdtSamp0();
        BeanUtils.copyProperties(pp,p0);
        //给当前的prdtSamp流水一个货号
        try {
            cnst.gPrdNo.prdtSampObjGetPrdNo(p0);
        } catch (Exception e) {
            e.printStackTrace();
            commonsThrow(msgs,"流水货号异常！");
        }
        if(p.empty(p0.getPrdNo())){
            String s="产品编码为：《" +p0.getPrdCode() +"》对应的产品中类《" +p0.getFenLeiName()+"》不存在,请手动录入该中类！所有数据未导入！";
            commonsThrow(msgs,s);
        }
        pp.setPrdNo(p0.getPrdNo());
    }

    private void f封装插入数据库的集合和保存图片(List<ExcelTxtTemplate> list该行文本集,List<ExcelPicTemplate> list该行图片集,String uuid,PrdtSamp pp,List<String> msgs,int 行计数器) throws IOException {
        for(ExcelTxtTemplate ee:list该行文本集){
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),图片)){
                try {
                    String thum=this.savePic(list该行图片集,uuid);
                    pp.setThum(thum+p.fh);
                } catch (IOException e) {
                    e.printStackTrace();
                    commonsThrow(msgs,"保存图片异常《"+行计数器+"行有问题》");
                }
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),品牌)){
                pp.setMarkName(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),客户)){
                pp.setCusName(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),产品分类)){
                //    //excel的产品分类就是产品分类
                pp.setFenLeiName(ee.getTxt());
                pp.setFenLeiNo(cnst.a001TongYongMapper.getIdxNoFromIdxName(pp.getFenLeiName()));
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),产品名称)){
                pp.setIdxName(ee.getTxt());

            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),产品负责人)){
                pp.setSalName(ee.getTxt());
            }

            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),编号)){
                pp.setPrdCode(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),颜色)){
                pp.setColour(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),尺寸)){
                pp.setSize(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),打样时间)){
                try {pp.setSampMake(p.tod(ee.getTxt(),p.d16)); } catch (Exception e1) { p.p("导入的EXcel打样时间不是日期格式！！");e1.printStackTrace();}
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),Category)){
                pp.setCategory(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),Team)){
                pp.setTeamname(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),产品要求)){
                pp.setSampRequ(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),产品描述)){
                pp.setSampDesc(ee.getTxt());
            }
            if(p.dy(ee.getTxtColumnNameOfTableHead().trim(),主单位)){
                pp.setMainUnit(ee.getTxt());
            }
        }
    }

    private final String 点=".";
    private final String png="png";
    private String savePic(List<ExcelPicTemplate> list该行图片集,String uuid) throws IOException {
        String thum="";
        if(p.notEmpty(list该行图片集)){
            PictureData pictureData = list该行图片集.get(0).getPictureData();
            if(null!=pictureData){
                thum = cnst.getSpringbootJarSuoLueTuFilePath()+uuid+点+png;
                FileOutputStream fileOutputStream = new FileOutputStream(thum);
                byte[] data = null;
//                if(p.dy(pictureData.getMimeType(),emf)){
//                    System.out.println("------------我日-------------------");
//                    data= this.emfToPng(new ByteArrayInputStream(data));
//                    System.out.println("------------我日不成-------------------");
//                }else{
//                    data=pictureData.getData();
//                }
                data=pictureData.getData();
                IOUtils.write(data,fileOutputStream);
                if(p.notEmpty(fileOutputStream)){fileOutputStream.flush();fileOutputStream.close();}
            }
        }
        thum=cnst.suoLueTuWenJianJia+uuid+Cnst.dian+Cnst.pngWuDian;
        return thum;
    }

    private final String emf="image/x-emf";
    private PrdtSampCreateUser f获得当前操作者(HttpServletRequest r,List<String> msgs) {
        String user = r.getParameter("user");
        if(p.empty(user)){
            commonsThrow(msgs,"前端传过来的user对象有问题,必须是{\"tenantId\":\"\",\"userName\":\"\"}这种");
        }
        String userName="",tenantId="";
        PrdtSampCreateUser prdtSampCreateUser = null;
        try {
            prdtSampCreateUser = JSON.parseObject(user, PrdtSampCreateUser.class);
        } catch (Exception e) {
            e.printStackTrace();
            commonsThrow(msgs,"前端传过来的json无法格式化");
        }
        userName=prdtSampCreateUser.getUserName()==null?"":prdtSampCreateUser.getUserName();
        tenantId=prdtSampCreateUser.getTenantId()==null?"":prdtSampCreateUser.getTenantId();
        prdtSampCreateUser.setTenantId(tenantId);
        prdtSampCreateUser.setUserName(userName);
        return prdtSampCreateUser;
    }


    private File f将excel保存在本地的excelTemp文件夹(List<String> msgs, MultipartFile excel) throws IOException {
        File dir = new File("excel2Erp");
        if(!dir.exists()){dir.mkdir();}
        if(!dir.exists()){
            commonsThrow(msgs,"创建存储excel的临时文件夹失败");
        }
        String tmepDirAbsolutePath = dir.getAbsolutePath();//无杠
        String s = tmepDirAbsolutePath +File.separator+p.uuid()+excel.getOriginalFilename();
        File excelFile = new File(s);
        boolean b = excelFile.createNewFile();
        if(!b)commonsThrow(msgs,"excel保存到本地失败");
        excel.transferTo(excelFile);
        return excelFile;
    }



    private void commonsThrow(List<String> msgs, String message){
        l.error(message);
        msgs.add(message);
        p.throwE(message);
    }
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());




    private  final String 品牌="品牌";
    private  final String 客户="客户";
    private  final String 产品分类="产品分类";
    private  final String 产品名称="产品名称";
    private  final String 产品负责人="产品负责人";
    private  final String 图片="图片";
    private  final String	编号="编号";
    private  final String 颜色="颜色";
    private  final String	尺寸="尺寸";
    private  final String 打样时间	="打样时间";
    private  final String Category="Category";
    private  final String Team="Team";
    private  final String 产品要求="产品要求";
    private  final String 产品描述="产品描述";
    private  final String 主单位="主单位";



    private byte[] emfToPng(InputStream is) {
        byte[] by = null;
        EMFInputStream emf = null;
        EMFRenderer emfRenderer = null;
//创建储存图片二进制流的输出流
        ByteArrayOutputStream baos = null;
//创建ImageOutputStream流
        ImageOutputStream imageOutputStream = null;
        try {
            emf = new EMFInputStream(is, EMFInputStream.DEFAULT_VERSION);
            emfRenderer = new EMFRenderer(emf);
            System.out.println("--------我日1-----------");
            final int width = (int) emf.readHeader().getBounds().getWidth();
            final int height = (int) emf.readHeader().getBounds().getHeight();
            final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) result.createGraphics();
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
                if (emf != null) {
                    emf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return by;
    }
}
