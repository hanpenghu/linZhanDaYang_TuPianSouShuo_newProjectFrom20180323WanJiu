package com.winwin.picreport.AllConstant;
import com.winwin.picreport.Acomponent.GetPriceModelUpdef;
import com.winwin.picreport.Acomponent.GetPriceModelUpdef20180512;
import com.winwin.picreport.Acomponent.JieJue20180831YiHouDaYangFenLeiNoBuChanShengWenTi.GenFenLeiNo;
import com.winwin.picreport.Acomponent.SapsoChongfu;
import com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert.servicesBatchRefactor.OrderToErp.CommonDaoRuDBZhiQianZhengLi;
import com.winwin.picreport.Bcontroller.SaleOrderExportAndInsert.servicesBatchRefactor.OrderToErp.CommonOrderBatchToDb;
import com.winwin.picreport.Bcontroller.daYang.AlterPrice.DingJiaXiuGaiSaleService;
import com.winwin.picreport.Bcontroller.loginRegistModul.auth.UserAuth;
import com.winwin.picreport.Cservice.*;
import com.winwin.picreport.Ddao.reportxmlmapper.*;
import com.winwin.picreport.Futils.GeneratePrdNo.GPrdNo;
import com.winwin.picreport.Futils.GeneratePrdNo.GetMaxPrdNo;
import com.winwin.picreport.Futils.SpringbootJarPath;
import com.winwin.picreport.Futils.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

@Order(2)
@Component("cnst")
public class Cnst {




    //数字数据库置空标记
    public static final BigDecimal toNullFlagNum=new BigDecimal(-1);
    //日期数据库置空标记
    public static final String toNullFlagDate="1970-01-01 08:00:00.000";



    public static final String returnException="0";
    public static final String returnRight="1";


    //此时是  1  紫色背景   //对比 up_def,有单价低于销售定价的行,紫色背景 代号 1
    public static final String salePriceColorOfSmall="1";
    //货号在up_def不存在  蓝色背景(没有对应价格就是蓝色,  2和3都显示蓝色)
    public static final String salePriceColorOfNoPrdNo="2";
    //该币别该运费的销售定价在up_def不存在(显示蓝色)
    public static final String salePriceColorOfNoThisCurIdAndBilType="3";



    public static final String saveExcelTemp="saveExcelTemp";
    //保留小数位数
    public static final int pointAfter=4;

    //下面3个是打样的审核流程
    public static final String weiTiJiao="0";//已经保存但未提交
    public static final String yiTiJiao="1";
    public static final String yiShenHe="2";



    public static final String SUCCESS="1";
    public static final String FAIL="0";

    public static final String SamplesSys="SamplesSys";//产品打样的时候我们插入系统表prdt和up_def(定价)的时候做的标记,该标记证明了是打样系统产生的记录
    public static final String imgUrl="imgUrl";
    public static final String salPriceId="1";//销售的定价表中的priceId是1
    public static final String buyPriceId="2";//采购的是2

    public static final String saleBilTypeHaveTrans="2";//销售有运费代码
    public static final String saleBilTypeNoTrans="1";//销售不含运费

    public static final String buyBilTypeHaveTrans="";//采购有运费
    public static final String buyBilTypeNoTrans="1";//采购无运费

    public static final String benBi="RMB";//本币是RMB 外币直接是不等于RMB的
    public static final String USD="USD";
    public static final String waiBi="";




    public static final String deskPath="C:\\Users\\Administrator\\Desktop\\";
    public static final String  xlsHouZhuiWuDian="xls";
    public static final String  javaXieGang="/";
    public static final String  shuangMsXieGang="\\";
    public static final String  xlsxHouZhuiWuDian="xlsx";
    public static final String  pngWuDian="png";
    public static final String  xlsxHouZhui=".xlsx";
    //保存excel中的数据为打样数据的时候一般是第0个sheet
    public static final String  sheetNo="0";
    //保存excel中的数据为打样数据的时候图片固定在第5列(从0)
    public static final String  picColumn="5";
    //保存excel中的数据为打样数据的时候图片位置三维分隔符,网上复制的代码用的这个分隔符
    public static final String  picFgf="_";

    public static final String  dian=".";
    public static final String emptyStr ="";
    public static final String spaceStr =" ";
    public static final String  ganTanHao="!";
    public static final String  fenHao=";";
    public static final String  enCodeSpace="%20";
    public static final String fenLeiNo="fenLeiNo";
    public static final String fenLeiName="fenLeiName";
    public static final String ten0="0000000000";
    public static final String dingJiaXiuGai="dingJiaXiuGai";
    public static final String bilType="bilType";
    public static final String curId="curId";
    public static final String dingJiaGuanLian="dingJiaGuanLian";
    public static final String qty="qty";
    public static final String up="up";
    public static final String unit="unit";
    public static final String remFront="remFront";//对应up_def的rem
    public static final String sDd="sDd";
    public static final String dingJiaZhuJian="dingJiaZhuJian";
    public static final String zhu="主:";
    public static final String fu="副:";
    public static final String curIdBefore="curIdBefore";
    public static final String dingJiaXiuGaiSale="dingJiaXiuGaiSale";
    public static final String ADMIN="ADMIN";
    public static final String SampExport="SampExport";

    //    E:\1\work_space\LINZHAN\LinZhan_Picture_ReportTable  这种最后无杠的
    public static String getProjectPath(){
//        String jarPath = SpringbootJarPath.JarLuJingGet();
        String jarPath = p.springBootJarPath();
        //截取调最后一个 路径分隔符
        jarPath=jarPath.substring(0,jarPath.length()-1);
        System.out.println("++++++++getProjectPath()++++++++"+jarPath+"+++++++++++++");
        return jarPath;
    }

    //这个路径是springbootjar运行后深入到缩略图文件夹中的路径最后带个/
    public  String getSpringbootJarSuoLueTuFilePath(){
       return  Cnst.getProjectPath()+daYangSuoLueTuAndFuJianZongPath.replace(Cnst.dian, Cnst.emptyStr)+suoLueTuWenJianJia;
    }


    @Autowired
    public PrdtUtMapper prdtUtMapper;

    @Autowired
    public GenFenLeiNo genFenLeiNo;

    @Autowired
    public A12 a12;

    @Autowired
    public UserAuth userAuth;

    @Autowired
    public ModelUsersSpcMapper modelUsersSpcMapper;

    @Autowired
    public DingJiaXiuGaiSaleService dingJiaXiuGaiSaleService;

    @Autowired
    public SalePriceSaveDao salePriceSaveDao;

    @Autowired
    public DyExcelBf dyExcelBf;

    @Autowired
    public DyDeleteOneImg dyDeleteOneImg;


    @Autowired
    public DyDeleteOneAttach dyDeleteOneAttach;

    @Autowired
    public GetPriceModelUpdef20180512 getPriceModelUpdef20180512;

    @Autowired
    public DaYangBatUploadAttach daYangBatUploadAttach;

    @Autowired
    public CustMapper custMapper;

    @Autowired
    public IndxMapper indxMapper;

    @Autowired
    public TfPssMapper tfPssMapper;


    @Autowired
    public TfPssZMapper tfPssZMapper;




    @Autowired
    public CommonOrderBatchToDb commonOrderBatchToDb;

    @Autowired
    public CommonDaoRuDBZhiQianZhengLi commonDaoRuDBZhiQianZhengLi;
    @Autowired
     public  AlterPriceRecMapper alterPriceRecMapper;

    @Autowired
    public GPrdNo gPrdNo;

    @Autowired
    public UpDefMapper upDefMapper;

    @Autowired
    public SapsoMapper sapsoMapper;

    @Autowired
    public GetMaxPrdNo getMaxPrdNo;

    @Autowired
    public GetPriceModelUpdef getPriceModelUpdef;

    @Autowired
    public D3SaleOrderUpLoadFromExcelService d3SaleOrderUpLoadFromExcelService;

    @Autowired
    public A1ReportRestService a1;
    @Autowired
    public MfPosMapper mfPosMapper;

    @Autowired
    public TfPosMapper tfPosMapper;

    @Autowired
    public TfPosZMapper tfPosZMapper;

    @Autowired
    public A001TongYongMapper a001TongYongMapper;

    @Autowired
    public SaveSaleOrBuyPrice saveSaleOrBuyPrice;

    public Date getDbDate(){
        return a001TongYongMapper.selectDbDate();
    }

    @Autowired
    public Z100TestPageBeanService zt;
    @Autowired
    public  D1DaYangServiceDataSaveByExcel d1DaYangServiceDataSaveByExcel;
    @Autowired
    public PrdtSampMapper prdtSampMapper;
    @Autowired
    public PrdtMapper prdtMapper;
    @Autowired
    public D1DaYangService_ImageUpLoadAndDataSave001_InfoEdit infoEdit;

    @Autowired
    public D1DaYangService_ConfirmOrder dco;

    @Autowired
    public InfoEdit_ManyAttach infoEditOfManyAttach;

    @Value("${tokenShiXiaoShiJian_haoMiao}")
    public String tokenShiXiaoShiJian_haoMiao;

    @Value("${excelDaoRuDaYangPicLinShiMulu}")
    public String excelDaoRuDaYangPicLinShiMulu;

    @Autowired
    public D1DaYangService d1DaYangService;

    @Value(Cnst.dirUrlStr)
    public String dirUrl;

    public static final String dirUrlStr="${dirUrl}";

    @Value("${dataSource001PORT}")
    public  String dataSource001PORT;

    @Value("${Database001Name}")
    public String Database001Name;

    @Value("${spring.datasource.username}")
    public String dBUserName;

    @Value("${spring.datasource.password}")
    public String dBPWd;

    @Value("${dataSource001IP}")
    public  String dataSource001IP;

    @Value("${suoLueTuWenJianJia}")
    public String suoLueTuWenJianJia;

    @Value("${fuJianWenJianJia}")
    public String fuJianWenJianJia;

    //软件过期时间//字符串毫秒时间戳
    @Value("${fuckTime}")
    public String guoQiShiJian;

    //daYangSuoLueTuAndFuJianZongPath=./daYangSuoLueTuAndFuJianZongPath/
    @Value("${daYangSuoLueTuAndFuJianZongPath}")//./1234567/
    public String daYangSuoLueTuAndFuJianZongPath;


    @Autowired
    public SapsoChongfu sapsoChongfu;

    @Autowired
    public D1DaYangS fenLei;
    @Autowired
    public ManyTabSerch manyTabSerch;


    //    @Autowired
//    public PrdtSampMapper prdtSampMapper;
    @Autowired
    public D1DaYangServiceOfDeleteSome deleteSome;


    @Autowired
    public DingJiaXiuGaiService dingJiaXiuGaiService;


    @Autowired
    public D1DaYangServiceOfDeleteOneImg deleteOneImg;

    /**
     *下面是mybatis分页插件要用的东西
     * */

    public static final String offsetAsPageNum= "offsetAsPageNum";
    public static final String trueStr= "true";
    public static final String falseStr= "false";
    public static final String rowBoundsWithCount= "rowBoundsWithCount";
    public static final String reasonable= "reasonable";
    public static final String dialect= "dialect";
    public static final String mysql= "mysql";
    public static final String sqlServer= "sqlServer";






    /**
     *下面是杂项
     * */
    public static final String testDataCurrentCode="实验数据货币代号";
    public static final String testDataCurrentName="实验数据货币名称";
    public static final String testDataUnit="实验数据单位";


}
