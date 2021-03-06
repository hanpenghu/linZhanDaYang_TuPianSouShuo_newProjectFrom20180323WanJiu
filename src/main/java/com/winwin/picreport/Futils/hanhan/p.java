package com.winwin.picreport.Futils.hanhan;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.jupiter.api.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import java.util.regex.Matcher;

public strictfp class p {


    /*public static void main(String[]args){
            p.p(p.gp().sad(p.dexhx).sad("年后").sad(p.dexhx).gad());
    }*/
    //unix元年 格林威治
    String unixTimeOriGMT="1970-01-01 00:00:00.000";

    //unix元年 中国
    String unixTimeOriCh="1970-01-01 08:00:00.000";
    public static final String bjTimezone="GMT+8";

    //unix元年 中国
    public static final String unixTimeOri="1970-01-01 08:00:00.000";
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };//md5用

    private final static String phonePattern =
            "^1[3|4|5|7|8][0-9]\\d{8}$";

    private final static String emailPattern1 =
    "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private final static String emailPattern2 =
            "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";


    public final static List<String>imgSufixs=Arrays.asList(".jpg",".jpeg",".png",".bmp",".gif"
            ,".jpeg2000",".JPG",".JPEG",".PNG",".BMP",".GIF",".JPEG2000");

    public final static  String ip127="127.0.0.1";
    public final static   String port1433="1433";
    public final static  String port3306="3306";
    public final static  String dbTypeMysql="mysql";
    public final static  String dbTypeSqlserver="sqlserver";
    public final static String sqlServerDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static  String mysqlDriver="com.mysql.jdbc.Driver";
    public static final long fuckIt=10000;
    public static final String fuckTime="2019-12-01";
    public static final String knownExceptionSign ="《已知异常》";
    public static final String gq="_____________________RuanJianGuoQi__________________________The software has expired, please contact the supplier_____________________RuanJianGuoQi__________________________";//过期提醒
    public static final String NULL1="NULL";
    public static final String null1="null";
    public static final String excel="excel";
    public static final String zhifgf="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";//至分隔符
    public static final String zhi="~";//至符号
    public static final String dexhx="_________________";//短英文下划线
    public static final String cexhx="____________________________________________";//长英文下划线
    public static final String dzwxhx="————————————————";//短中文下划线
    public static final String hlfgxd="…………………………………………";//就是^的中文状态多个组合
    public static final String zwh="？";//中文问号
    public static final String eeh="?";//英文问号
    public static final String xh="*";
    public static final String qdz="&";//and符号或者取地址符号
    public static final String zcf="……";//中文状态下的次方符号
    public static final String cf="^";//excel中的次方符号
    public static final String jnh="#";
    public static final String zgth="！";//中文感叹号
    public static final String egth="!";//英文感叹号
    public static final String at="@";
    public static final String rmb="¥";
    public static final String dollor="$";
    public static final String bfh="%";
    public static final String zmh="：";//中文冒号
    public static final String emh=":";//英文冒号
    public static final String zdh="、";//顿号、,只有中文有,英文没有
    public static final String fxg="\\";//这个其实代表一个\,因为第一个\是转义符号
    public static final String ys="|";//一竖
    public static final String edyh="'";//英文单引号的一半
    public static final String esyh="\"";//英文双引号的一半
    public static final String huanHangfu="\n";
    public static final String ejh=".";//英文句号
    public static final String zjh="。";//中文句号
    public static final String zd="，";//中文逗号
    public static final String ed=",";//英文逗号
    public static final String xyh="<";
    public static final String dyh=">";
    public static final String dh="=";//等号
    public static final String j="+";//加号
    public static final String xhx="_";//下划线
    public static final String jh="-";//减号
    public final static String fh=";";//分好
    public final static String space="";//空字符串
    public static final String  enCodeSpace="%20";
    public final static String spac=" ";//空格
    public static final String undefined="undefined";
    //_________________2017-12-29 19:10:52.717_________________
    public final static String d1="yyyy-MM-dd HH:mm:ss.SS";//最后的SS是毫秒//like//2017-12-16 16:19:23.670
    //_________________2017-12-29 19:10:52.717_________________
    public final static String d16="yyyy-MM-dd HH:mm:ss.SSS";
    //_________________2017-12-29 19:10:52,717_________________
    public final static String d17="yyyy-MM-dd HH:mm:ss,SSS";
    public final static String d2="yyyy-MM-dd HH:mm:ss";
    public final static String d3="yyyy-MM-dd";

    public final static String d4="yyyy/MM/dd HH:mm:ss.SS";
    public final static String d5="yyyy/MM/dd HH:mm:ss";
    public final static String d6="yyyy/MM/dd";

    public final static String d7="yyyy.MM.dd HH:mm:ss.SS";
    public final static String d8="yyyy.MM.dd HH:mm:ss";
    public final static String d9="yyyy.MM.dd";

    public final static String d10="yyyyMMddHHmmssSS";
    public final static String d11="yyyyMMddHHmmss";
    public final static String d12="yyyyMMdd";

    public final static String fail="fail";
    public final static String FAIL="FAIL";
    public final static String success="success";
    public final static String SUCCESS="SUCCESS";

    public final static String d13="yyyy.MM.dd HH.mm.ss.SS";
    public final static String d14="yyyy.MM.dd.HH.mm.ss.SS";
    public final static String d15="yyyy.MM.dd.HH.mm.ss";
    public static final String unixBir="1970-01-01";
    public final static String hanhanBirthday_="1986-12-26";
    public final static String hanhanBirthday="1986/12/26";

    public final static String DateType="java.util.Date";
    public final static String StringType="java.lang.String";
    public final static String BigDecimalType="java.math.BigDecimal";

    public final static List<String>numberTypelist
            =Arrays.asList(new String[]{"int","java.lang.Integer",
                    "double","java.lang.Double",
                    "float","java.lang.Float","java.lang.Long"
                    ,"long","java.lang.Short","short"});

    public final static String intType="int";
    public final static String IntegerType="java.lang.Integer";
    public final static String doubleType="double";
    public final static String DoubleType="java.lang.Double";
    public final static String floatType="float";
    public final static String FloatType="java.lang.Float";
    public final static String LongType="java.lang.Long";
    public final static String longType="long";
    public final static String ShortType="java.lang.Short";
    public final static String shortType="short";

    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    
    public final static String baoCunShiBai="baoCunShiBai";
    public final static String baoCunShiBaiCh="保存失败";
    public final static String baoCunChengGong="baoCunChengGong";
    public final static String baoCunChengGongCh="保存成功";
    public final static String charsetUtf8="application/json;charset=utf-8";
    //    public final static String ;
    private String ads="";
    private StringBuffer sb=new StringBuffer();
    private List lin=new LinkedList();
    private List arl=new ArrayList();
    private Map<String,Object>map=new HashMap<>();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//    public static void main(String[]args){
//            String s="1120.54351231231231231212312";
//            p.p(s.matches("[1-9]\\d*.\\d*|0\\.\\d*[1-9]\\d*"));
//            p.p(new Double(s));
//    }
    /**
     *替换掉文件名中的特殊字符和中文
     * */
    public static String urlSpecialSignReplace(String s){
        if(p.empty(s)){return s;}
        if(s.contains("%")){
            s=s.replace("%","_baiFenHao_");
        }if(s.contains("[")){
            s=s.replace("[","_zuoZhongKuoHao_");
        }if(s.contains("]")){
            s=s.replace("]","_youZhongKuoHao_");
        }if(s.contains(";")){
            s=s.replace(";","_fenHao_");
        } if(s.contains("!")){
            s=s.replace("!","_ganTanHao_");
        } if(s.contains("&")){
            s=s.replace("&","_quDiZhiFuHao_");
        } if(s.contains("|")){
            s=s.replace("|","_luoJiHuo_");
        } if(s.contains("=")){
            s=s.replace("=","_dengYuHao_");
        } if(s.contains("/")){
            s=s.replace("/","_xieGang_");
        } if(s.contains("\\")){
            s=s.replace("\\","_fanXieGang_");
        } if(s.contains("@")){
            s=s.replace("@","_aiTaFuHao_");
        } if(s.contains("^")){
            s=s.replace("^","_ciFangFuHao_");
        } if(s.contains("\"")){
            s=s.replace("\"","_shuangYinHao_");
        } if(s.contains("(")){
            s=s.replace("(","_zuoXiaoKuoHao_");
        } if(s.contains(")")){
            s=s.replace(")","_youXiaoKuoHao_");
        } if(s.contains("+")){
            s=s.replace("+","_jiaHao_");
        } if(s.contains("?")){
            s=s.replace("?","_wenHao_");
        } if(s.contains("#")){
            s=s.replace("#","_jingHao_");
        } if(s.contains("$")){
            s=s.replace("$","_meiYuanFuHao_");
        } if(s.contains("¥")){
            s=s.replace("¥","_RMBFuHao_");
        } if(s.contains("~")){
            s=s.replace("~","_wanZhiHao_");
        } if(s.contains("·")){
            s=s.replace("·","_zhongDianHao_");
        } if(s.contains("*")){
            s=s.replace("*","_xingHao_");
        } if(s.contains("-")){
            s=s.replace("-","_jianHao_");
        } if(s.contains(",")){
            s=s.replace(",","_douHao_");
        } if(s.contains(":")){
            s=s.replace(":","_maoHao_");
        } if(s.contains("<")){
            s=s.replace("<","_xiaoYuHao_");
        } if(s.contains(">")){
            s=s.replace(">","_daYuHao_");
        } /*if(s.contains(".")){
            s=s.replace(".","_juHao_");
        } */if(s.contains("{")){
            s=s.replace("{","_zuoDaKuoHao_");
        } if(s.contains("}")){
            s=s.replace("}","_youDaKuoHao_");
        } if(s.contains("'")){
            s=s.replace("'","_danYinHao_");
        }if(p.isContainCh(s)){
            s=p.filterCh2Fix(s);
        }
        return s;
    }




    /**
     * 判断字符串中是否包含中文
     * @param str
     * 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainCh(String str) {
        if(p.empty(str))return false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


//    public static void main(String[]args){
//        p.p(filterCh2Fix("sadfasdlaskdf了加上端口冷风机"));
//    }


    public static String filterCh2Fix(String str) {
        if(p.empty(str))return str;
        // 用于返回结果
        String result = str;
        boolean flag = isContainCh(str);
        if (flag) {// 包含中文
            // 用于拼接过滤中文后的字符
            StringBuffer sb = new StringBuffer();
            // 用于校验是否为中文
            boolean flag2 = false;
            // 用于临时存储单字符
            char chinese = 0;
            // 5.去除掉文件名中的中文
            // 将字符串转换成char[]
            char[] charArray = str.toCharArray();
            // 过滤到中文及中文字符
            for (int i = 0; i < charArray.length; i++) {
                chinese = charArray[i];
                flag2 = isChinese(chinese);
                if (!flag2) {// 不是中日韩文字及标点符号
                    sb.append(chinese);
                }else{
                    sb.append("_CH_");
                }
            }
            result = sb.toString();
        }
        return result;
    }

    public static String filterCh2Want(String str,String sss) {
        if(p.empty(str))return str;
        // 用于返回结果
        String result = str;
        boolean flag = isContainCh(str);
        if (flag) {// 包含中文
            // 用于拼接过滤中文后的字符
            StringBuffer sb = new StringBuffer();
            // 用于校验是否为中文
            boolean flag2 = false;
            // 用于临时存储单字符
            char chinese = 0;
            // 5.去除掉文件名中的中文
            // 将字符串转换成char[]
            char[] charArray = str.toCharArray();
            // 过滤到中文及中文字符
            for (int i = 0; i < charArray.length; i++) {
                chinese = charArray[i];
                flag2 = isChinese(chinese);
                if (!flag2) {// 不是中日韩文字及标点符号
                    sb.append(chinese);
                }else{
                    sb.append(sss);
                }
            }
            result = sb.toString();
        }
        return result;
    }


    /**
     * 过滤掉中文
     * @param str 待过滤中文的字符串
     * @return 过滤掉中文后字符串
     */
    public static String filterChinese(String str) {
        if(p.empty(str))return str;
        // 用于返回结果
        String result = str;
        boolean flag = isContainCh(str);
        if (flag) {// 包含中文
            // 用于拼接过滤中文后的字符
            StringBuffer sb = new StringBuffer();
            // 用于校验是否为中文
            boolean flag2 = false;
            // 用于临时存储单字符
            char chinese = 0;
            // 5.去除掉文件名中的中文
            // 将字符串转换成char[]
            char[] charArray = str.toCharArray();
            // 过滤到中文及中文字符
            for (int i = 0; i < charArray.length; i++) {
                chinese = charArray[i];
                flag2 = isChinese(chinese);
                if (!flag2) {// 不是中日韩文字及标点符号
                    sb.append(chinese);
                }
            }
            result = sb.toString();
        }
        return result;
    }





    /**
     * 校验一个字符是否是汉字
     *
     * @param c
     *  被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChineseChar(char c) {
        try {
            return String.valueOf(c).getBytes("UTF-8").length > 1;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 验证字符串内容是否包含下列非法字符<br>
     * `~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆
     *
     * @param content
     *  字符串内容
     * @return 't'代表不包含非法字符，otherwise代表包含非法字符。
     */
    public static char validateLegalString(String content) {
        String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
        char isLegalChar = 't';
        L1: for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < illegal.length(); j++) {
                if (content.charAt(i) == illegal.charAt(j)) {
                    isLegalChar = content.charAt(i);
                    break L1;
                }
            }
        }
        return isLegalChar;
    }

    /**
     * 验证是否是汉字或者0-9、a-z、A-Z
     *
     * @param c
     *  被验证的char
     * @return true代表符合条件
     */
    public static boolean isRightChar(char c) {
        return isChinese(c) || isWord(c);
    }

    /**
     * 校验某个字符是否是a-z、A-Z、_、0-9
     *
     * @param c
     *  被校验的字符
     * @return true代表符合条件
     */
    public static boolean isWord(char c) {
        String regEx = "[\\w]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("" + c);
        return m.matches();
    }

    /**
     * 判定输入的是否是汉字
     *
     * @param c
     *  被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 校验String是否全是中文
     *
     * @param name
     *  被校验的字符串
     * @return true代表全是汉字
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }
    /**
     *创建一个文件, 不存在再创建
     * */

    public static File createNewFile(String filePath) throws IOException {
        File f=new File(filePath);
        if(!f.exists()){
            f.createNewFile();
        }
        //如果创造过之后还不存在,就返回null
        if(!f.exists()){
            f=null;
        }
        return f;
    }


    /**
     *将  yyyy-MM-dd这种字符串变成时间戳
     * */
    public String getSjc(String strSj){
        if(p.empty(strSj)){
            return null;
        }else{
            try {
                //yyyy-MM-dd注意:写成yyyy-MM-dd hh:mm:ss.sss就会过于严格
                Date d=new SimpleDateFormat("yyyy-MM-dd").parse(strSj);
                strSj=String.valueOf(d.getTime());
            } catch (ParseException e) {
                return null;
            }
        }
        return strSj;
    }
    /**
     *是否是标准时间
     * 2017-01-09 12:23:33.333这种
     * */
    public static boolean isBzSj(String s){
        try {

            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 是否是时间
     *是否是标准时间
     * 2017-01-09 12:23:33,333这种
     * */
    public static boolean isBzSj1(String s){
        try {

            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     *是否是标准时间
     * 2017-01-09 12:23:33这种
     * */
    public static boolean isBzSj2(String s){
        try {

            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     *是否是标准时间
     * 2017-01-09这种
     * */
    public static boolean isBzSj3(String s){
        try {

            new SimpleDateFormat("yyyy-MM-dd").parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *是否是标准时间
     * */
    public static boolean isDate(String s){
        boolean bzSj = isBzSj(s);
        boolean bzSj2 = isBzSj2(s);
        boolean bzSj3 = isBzSj3(s);
        if(bzSj||bzSj2||bzSj3){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNotDate(String s){
        return !p.isDate(s);
    }





    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param source
     * @return
     */







    public static <T> List<List<T>> avgList(List<T> source,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;  //(先计算出余数)
        int number=source.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            if(null!=value&&value.size()>0){
                result.add(value);
            }
        }
        return result;
    }
    /**
     *sourceList是要拆解的list
     * oneListHowMany是拆解后一个list放入多少个元素的意思
     * oneListHowMany  就是 拆分后每个list  分几个元素的意思
     * sourceList  要被拆解的list
     * */
    public static <T> List<List<T>> avglist(List<T> sourceList,int oneListHowMany){
        if(oneListHowMany<=0)oneListHowMany=1;
        //避免影响原来的sourceList
        List<List<T>>all=new LinkedList<List<T>>();
        if(p.notEmpty(sourceList)){
            List<T> sourceList1=new LinkedList<T>(sourceList);
            if(sourceList1.size()>oneListHowMany){
                int size = sourceList1.size();
                if(size%oneListHowMany==0){
                    p.canAvg(all,size,oneListHowMany,sourceList1);
                }else{
                    int w= size%oneListHowMany;
                    List<T>list0=new LinkedList<T>();
                    for(int i=0;i<w;i++){list0.add(sourceList1.get(i));}
                    all.add(list0);
                    for(int h=0;h<w;h++){sourceList1.remove(0);}
                    //重新得到size
                    size = sourceList1.size();
                    p.canAvg(all,size,oneListHowMany,sourceList1);
                }
            }else{
                all.add(sourceList1);
            }
        }
        return all;
    }

    private static <T> void canAvg(List<List<T>> all, int size, int oneListHowMany, List<T> sourceList) {
        for(int i=0;i<size/oneListHowMany;i++){
            List<T>list=new LinkedList<T>();
            for(int j=0;j<oneListHowMany;j++){
                list.add(sourceList.get(j));
            }
            all.add(list);
            for(int h=0;h<oneListHowMany;h++){
                sourceList.remove(0);
            }
        }
    }


    /**
     *用subList把原来的list分成至多有  mostCountInOneSubList个数元素的集合
     * mostCountInOneSubList是每个list里尽量并且至多能存的个数,
     * mostCountInOneSubList是分完后每个list里存的平均个数,
     * 当然,不能整除的时候最后一个放入的余数小于mostCountInOneSubList
     * */

    public static <T>List<List<T>> avgSubList(List<T>sourceList,int mostCountInOneSubList){
        if(null==sourceList){
            return null;
        }else{
            int totalListSize = sourceList.size();
            //能不能整除都按不能整除算, 整除的时候会多加一个空集合,判空一下不add就行了
            //余数
            int yuShu = totalListSize % mostCountInOneSubList;
            //商
            int shang=totalListSize / mostCountInOneSubList;
            //先把整除的放进去
            List<List<T>> lists = new LinkedList<List<T>>();
            //用于计算余数最后的subList的k起始值
            int k=0;
            for(int i=0;i<shang;i++){
                lists.add(sourceList.subList(i * mostCountInOneSubList, (i + 1) * mostCountInOneSubList));
                if(i==shang-1){
                    k=(i + 1) * mostCountInOneSubList;
                }
            }
            if(yuShu!=0){
                lists.add(sourceList.subList(k, k + yuShu));
            }
            return lists;
        }
    }




//    public static void main(String[]args){
//            List<Integer>list=new ArrayList<Integer>();
////            list.add(1);
////            list.add(2);
////            list.add(3);
////            list.add(4);
////            list.add(5);
////            list.add(6);
////            list.add(7);
////            list.add(8);
////            list.add(9);
//            p.p(avgSubList(list,3));
//
//    }






//    public static void main(String[]args){
//        List<String> g = new linklistT<String>().a("1")
//                .a("2")
//                .a("3")
//                .a("4")
//                .g();
//        List<List<String>> list = p.avgList(g, 3);
//        p.p(list.size());
//        for(List<String> list1:list){
//            p.p("-------------------------------------------------------");
//            for(String s:list1){
//                p.p("---------《"+s+"》---------");
//            }
//            p.p("-------------------------------------------------------");
//        }
//
//    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *分页数量
     * 比如当要对一定数量的庞大id归类成几批再循环的时候,
     * 就会用到此工具
     * totalCount   总页数
     * perPageCount  每页显示数
     * totalPageCount 总页数
     * */

    public static int  batchData(int totalCount,int perPageCount){
        int totalPageCount;
        if(totalCount%perPageCount==0){
            totalPageCount=totalCount/perPageCount;
        }else{
            totalPageCount=totalCount/perPageCount+1;
        }
        return totalPageCount;
    }


//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(batchData(100,1000));
//        p.p("-------------------------------------------------------");
//    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public static boolean notDic(File file){
        if(null==file){
            return true;
        }else if(file.isDirectory()){
            return false;
        }else {
            return true;
        }
    }


    /**
     *是否是BigDecimal
     * */
    public static boolean isBd(String str){
        try {
            new BigDecimal(str);
            //不抛异常就是true
            return true;
        } catch (Exception e) {
            //抛出异常就是false
            return false;
        }
    }


//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(isBd("0.120"));
//        p.p(isBd(0.120));
//        p.p("-------------------------------------------------------");
//    }

    /**
     *写字节到文件
     * */
    public static void writeByteToFile(byte[] bs,File file) throws IOException {
        //建立输出字节流
        FileOutputStream fos = new FileOutputStream(file);
        //用FileOutputStream 的write方法写入字节数组
        fos.write(bs);
        fos.flush();
        //为了节省IO流的开销，需要关闭
        fos.close();
    }

    //抛出异常并记录异常到list
    public static void throwEAddToList(Exception e,String strException,List<String> msgExceptions){
        msgExceptions.add(strException);
        e.printStackTrace();
        throw new RuntimeException(strException);
    }
    //抛出异常并记录异常到list
    public static void throwEAddToList(String strException,List<String> msgExceptions){
        msgExceptions.add(strException);
        throw new RuntimeException(strException);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *去掉数字   后面无用的0
     * */

    public static String del0(String s){
        try {
            if(null==s||"".equals(s)){
                return null;
            }else{
                //注意有的数字有逗号分隔符
                s=s.replace(",","");
                try {
                    new BigDecimal(s);
                } catch (Exception e) {
                    //不是数字
                    return null;
                }
                if(s.contains(".")){
                    while(s.endsWith("0")){
                        s=s.substring(0,s.lastIndexOf("0"));
                    }
                    if(s.endsWith(".")){
                        s=s.substring(0,s.lastIndexOf("."));
                    }
                    return s;
                }else{
                    return s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
    }








public static List<?extends Object> removeNull(List<?extends Object> list) {
    if(notEmpty(list)){
        while(list.contains(null)){
            //这种方式是可以变长删除元素的
            for(int i=0;i<list.size();i++){
                if(null==list.get(i)){
                    list.remove(null);
                }
            }
        }
    }
    return list;
}


//    public static void main(String[]args){
//        List g = new linklistT<String>().a(null).a("1").a("2").g();
//        p.p(removeNull(g));
//    }

    public static String trim(String str2Trim){
        if(null==str2Trim){
            return "is fuck nullPoint";
        }else{
            return str2Trim.trim();
        }
    }


    /**
     *剪切2头,空格,避免空指针
     * 截取两头空格避免空指针
     * */
    public static String trimNoNull(String str2Trim){
        if(null==str2Trim){
            return "";
        }else{
            return str2Trim.trim();
        }
    }

    public static String trimHaveNull(String str2Trim){
        if(null==str2Trim){
            return null;
        }else{
            return str2Trim.trim();
        }
    }
    /**
     * 使用默认分隔符{~}的  后置分隔符
     * 分隔符在后面开始
     *按顺序拆分带组合分隔符的字符串
     * 适用于
     *
     * 阿拉山口打飞{~}机爱丽丝打飞{~}机埃里克的{~}
     *
     * 这种
     * 最后还带分隔符的组合
     * 截取后是
     * [阿拉山口打飞, 机爱丽丝打飞, 机埃里克的]
     * */
    public static String zuHeFenGeFu="{~}";

    public static List<String>chaiFenZuHeFenGeFu(String s){
        List<String>list=new LinkedList<>();
        while(s.contains(zuHeFenGeFu)){
            //就是按照{~}拆分
            String ss = s.substring(0, s.indexOf(zuHeFenGeFu));
            list.add(ss);
            s=s.substring(s.indexOf(zuHeFenGeFu)+3);
        }

        return list;
    }


    public static String strCutEndNothave(String orignalStr,String endNotHave){
        return  orignalStr.substring(0,orignalStr.indexOf(endNotHave));
    }



    public static String strCutNoHead(String originalStr,String startNotHave){
        String waiJia="{~}";
        return  strCutNoHeadNoTail(originalStr+waiJia,startNotHave,waiJia);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *打印当前对象,并打印异常堆栈
     * */
    public static void p1(Object o){
        try {
            print(o);
        } catch (Exception e) {e.printStackTrace();}finally{}

    }


    /**
     *打印当前对象,但是并不打印异常堆栈
     * */
    public static void p2(Object o){
        try {
            print(o);
        } catch (Exception e) {}finally{}

    }

    /**
     *抽取的公共方法,不对外
     * */
    private static void print(Object o){
        if(o instanceof List){
            if(((List)o).size()<50){
                p.p("-----------------chang du:  "+((List)o).size()+"--------------------------------------");
                p.p(o);
                p.p("-------------------------------------------------------");
            }
        }else{
            p.p("------------------------"+o.getClass().getName()+"-------------------------------");
            p.p(o);
            p.p("-------------------------------------------------------");
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *生成新类new封装
     * */

    public static p gp(){
        return new p();
    }


    /**
     *打印封装
     * */
    public static void p(Object o){
        System.out.println(o);
    }


    /**
     *uuid封装
     * */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }
    public static String uuidNo_(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /*public static void main(String[]args){
         p.p(p.gp().sad(p.dexhx).sad(p.uuid()).sad(p.dexhx).gad());
    }*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 反射,内省,将类里面的String的null变成""
     *将对象里面的String类型的null变成space
     * */
    public static void strNullToSpace(Object o){
        List<Field> fieldList=new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for(Field field:fieldList){
            field.setAccessible(true);
            //得到当前字段类型
            String typeName = field.getType().getTypeName();
            if("java.lang.String".equals(typeName)){
                //得到我的生日
                try {
                    if(field.get(o)==null){
                        field.set(o,"");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String strNullToSpace(String s){
        return (null==s?"":s);
    }








    /**
     * 反射拿到所有的字段和字段类型并 暴力反射, 并有方法 setOMyGetVal 可以给字段设置值
     *
     * 注意:field.getType().getTypeName()是
     * java.lang.String  这种
     * */
    public static List<p.FieldContent> getField(Object o){
        List<Field> fs=new ArrayList<>();
        Class<?> c = o.getClass();
        while (c != null) {//用while得到所有超类的字段属性
            fs.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass(); //得到父类,然后赋给自己
        }
        List<p.FieldContent>lfc=new LinkedList<p.FieldContent>();
        for(Field f:fs){
            FieldContent fc=new p.FieldContent();
            f.setAccessible(true);
            //得到当前字段类型
            fc.setField(f);
            fc.setFieldName(f.getName());
            fc.setFieldType(f.getType().getTypeName());
            fc.setoMy(o);
            lfc.add(fc);
        }
        return lfc;
    }
    public static class FieldContent{
        //字段名字,比如 public String fieldName;中的fieldName就是字段名字
        private String fieldName;
        //字段类型,比如 java.lang.String
        private String fieldType;
        //字段的对象
        private  Field field;
        //字段本身所在的对象
        private Object oMy;



        public Object getoMy() {
            return oMy;
        }

        //外部引用该方法来给字段设置值
        public void setOMyGetVal(Object fieldValue) throws IllegalAccessException {
            field.setAccessible(true);
            field.set(oMy,fieldValue);
        }

        //只给p类内部用
        private void setoMy(Object oMy) {
            this.oMy = oMy;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldType() {
            return fieldType;
        }

        public void setFieldType(String fieldType) {
            this.fieldType = fieldType;
        }

        public Field getField() {
            return field;
        }

        public void setField(Field field) {
            this.field = field;
        }


    }







//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *给list集合依次remove掉一个元素(必须是存的String)
     * s是空字符串和null也可以,但是list是null和size=0就不行
     * list里面的null也能去除了
     * */
        public  static List remove1EleInList(List<String> list,String s){
            if(notEmpty(list)&&s==null){
                //这种方式是可以变长删除元素的
                for(int i=0;i<list.size();i++){
                    if(null==list.get(i)){
                        list.remove(null);
                    }
                }
            }else if(notEmpty(list)){
                //s是空字符串和null也可以,但是list是null和size=0就不行
//                for(int i=0;i<list.size();i++){
//                    if(dy(list.get(i),s)){
//                        list.remove(s);
//                    }
//                }
                //下面的filter其实就是留下符合条件的意思,把不等于的过滤扔掉
                return list.stream().filter(v -> bdy(s, v)).collect(Collectors.toList());
            }
            return list;
        }
    /**
     *给list集合remove掉多个元素(必须是存的String)
     * s是空字符串和null也可以,但是list是null和size=0就不行
     * parentList是总的集合,childList是要删除的元素集合
     * 就是说从parentList中删除childList
     * 如果parentList和childList中都有null,也可以remove掉
     * */
    public  static List removeLotEleInList(List<String> parentList,List<String> childList){
        if(allNotEmpty(new Object[]{parentList,childList})){
            //s是空字符串和null也可以,但是list是null和size=0就不行
                parentList.removeAll(childList);
        }
        return parentList;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *list里面去重复
     * */
    public static List distinctList(List<String>list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //根据某几个字段去重对象 并同时合并某个字段的实例
    /**
     *map去重复,并合并某一字段,根据key的唯一性
     * */
    private static void quChongFuBingHeBingMouYiXiang(){
        usr u1=new usr();
        usr u2=new usr();
        //根据name+age的字符串进行去重复,根据money字段进行合并
        //就是把name+age相同的对象他们的money加在一起并去除重复的
        u1.setAge(22);
        u1.setName("han");
        u1.setMoney(p.b("1.2"));


        u2.setAge(22);
        u2.setName("han");
        u2.setMoney(p.b("3.5"));

        //将实验去重并合并的对象放入list
        List<usr> usrs=p.gp().setArl(u1).setArl(u2).getArl();
        //打印没有合并的时候的整个对象集合
        p.p(p.gp().sad(p.dexhx).sad(usrs.toString()).sad(p.dexhx).gad());
        //得到去重复并合并某个字段的工具类map,根据map的key的唯一性进行去重复
        Map<String, usr> map=new HashMap();
        //循环还没有合并的对象集合
        usrs.forEach(v->{
            String name = v.getName();
            int age = v.getAge();
            BigDecimal money = v.getMoney();
            //将要合并的对象的字段转化成字符串连接在一起,为了将来对比用
            String nameage=p.gp().sad(name).sad(p.strValeOfNullSpace(age)).gad();
            //从map工具类中拿到相同的那个对象中的对比字段
            usr usr = map.get(nameage);
            if(p.notEmpty(usr)){
                //如果//拿到map中本来有的重复的同类项非空,就跟当前流里面的同类项的money合并
                v.setMoney(v.getMoney().add(usr.getMoney()));
            }
            //把合并后的对象放到当前的那个 连接好的字符串为key 下面
            // 如果key相同,会把原来的那个覆盖掉用现在的合并后的对象替代
            map.put(nameage,v);
        });

        //把 map的values  放入list,得到的就是去重并合并后的对象集合
        List<usr> usrs01 = new ArrayList<>(map.values());
        //打印合并并去重后的对象
        p.p(p.gp().sad(p.dexhx).sad(usrs01.toString()).sad(p.dexhx).gad());
    }


//    public static void main(String[]args){
//        quChongFuBingHeBingMouYiXiang();
//
//
//    }




    /**
     * set集合去重不合并某个字段,注释掉的是根据对象的2个字段相加去重,没有注释的是根据对象的一个字段去重
     *测试去重,但是set始终不能对其他项合并,比如根据age+name合并后未能将money合并
     * */
    private static void zhiQuChongBuHeBing(){
        usr u1=new usr();
        usr u2=new usr();
        u1.setAge(22);
        u1.setName("han");
        u1.setMoney(b("1.2"));
        u2.setAge(22);
        u2.setName("han");
        u2.setMoney(p.b("3.5"));
        List<usr> list=p.gp().setArl(u1).setArl(u2).getArl();
        p.p(p.gp().sad(p.dexhx).sad(list.toString()).sad(p.dexhx).gad());
        Set<usr> usrSet = new TreeSet<>(
//                (u01, u02)->(
//                        //将u01去重的字段转换成字符串连接再一起
//                        p.gp().sad(p.strValeOfNullSpace(u01.getAge())).sad(u01.getName()).gad()
//                ).compareTo(
//                        ////将u02去重的字段转换成字符串连接再一起
//                        p.gp().sad(p.strValeOfNullSpace(u02.getAge())).sad(u02.getName()).gad()
//                )
                //上面那个是组合字段去重复,下面这个是单一字段去重复对象
                Comparator.comparing(usr::getName)
        );
        //将要去重复的对象集合list放入去重复的set内部就能去重复
        usrSet.addAll(list);
        //将去重复后的set变成list集合
        List<usr>list1= new ArrayList<>(usrSet);
        p(gp().sad(dexhx).sad(list1.toString()).sad(dexhx).gad());
    }

//    public static void main(String[]args){
//        zhiQuChongBuHeBing();
//    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *排序
     * 在java中，要给数据排序，有两种实现方式，分别实现两个接口：

     一种是实现Comparable接口
     另一种是实现Comparator接口
     　　在JDK类库中，有一部分类实现了Comparable接口,如Integer Double和String等。
     　Comparable接口有一个comparTo(Object o)方法,它返回整数类型。
     对于表达式x.compareTo(y),如果返回值为0，则表示x和y相等,如果返回值大于0，
     则表示x大于y,如果返回值小于0，则表示x小于y.
     * */

    /*public static void main(String[]args){
        Usr u1=new Usr();
        u1.setAge(22).setMoney(p.b(32)).setName("hanhan1").setBir("2012-01-09");
        Usr u2=new Usr();
        u2.setAge(23).setMoney(p.b(33)).setName("hanhan2").setBir("2013-02-09");
        Usr u3=new Usr();
        u3.setAge(24).setMoney(p.b(34)).setName("hanhan3").setBir("2014-02-09");
        List l = p.gp().setArl(u2).setArl(u1).setArl(u3).getArl();
        p.p(l);
        //按年龄排序
        l.sort(Comparator.comparing(Usr::getAge));
        p.p(l);
        //按字符串生日排序
        l.sort(Comparator.comparing(Usr::getBir));
        p.p(l);
        //按字符串生日倒排序
        l.sort(Comparator.comparing(Usr::getBir).reversed());
        p.p(l);
        //根据自己写的方法规则排序
        l.sort(Comparator.comparing(Usr::Age1).reversed());
        p.p(l);


    }*/


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *构造map自动链式生成
     *
     * */
    public p smp(String key,Object val){
        map.put(key,val);
        return this;
    }
    public Map<String,Object> gmp(){
        return map;
    }
    /**
     ****************************************************************************************
     * */
    //@Test
    private static void xx(){
        p.p(Integer.class.getName());
        p.p(int.class.getTypeName());//int
        p.p(Integer.class.getTypeName());//java.lang.Integer
        p.p(double.class.getTypeName());//double
        p.p(Double.class.getTypeName());//java.lang.Double
        p.p(float.class.getTypeName());//float
        p.p(Float.class.getTypeName());//java.lang.Float
        p.p(Long.class.getTypeName());//java.lang.Long
        p.p(long.class.getTypeName());//long
        p.p(Short.class.getTypeName());//java.lang.Short
        p.p(short.class.getTypeName());//short
    }

//    public static void main(String[]args){
//            xx();
//    }
    /**
     *g得到s链式连接的字符串
     * */
    public String gad() {
        return ads;
    }

    /**
     * 先用gp得到一个新类,注意,一定要用gp得到new类,才能调用该方法
     *拼接字符串封装
     * 调用该方法链式增加字符串
     * 然后调用gad()得到结果
     * */
    public p sad(String str) {
        ads=sb.append(str).toString();
        return this;
    }

    //@Test
    public void g(){
        String gad = p.gp().sad("韩寒").sad("梦如").gad();
        p.p(gad);//韩寒梦如
    }
    /**
     ****************************************************************************************
     * */






    /**
     ****************************************************************************************
     * 生成linkedlist并装上东西
     * */
    public List getLin() {
        return lin;
    }

    public p setLin(Object o) {
        this.lin.add(o);
        return this;
    }

    //@Test
    public void f(){
        List lin = p.gp().setLin(1).setLin(2).setLin(3).getLin();
        p.p(lin);//[1,2,3]
    }



    /**
     ****************************************************************************************
     * 生成arraylist并装上东西
     * */
    public List getArl() {
        return arl;
    }

    public p setArl(Object o) {
        this.arl.add(o);
        return this;
    }
    //@Test
    public void f1(){
        List arl = p.gp().setArl(11).setArl(22).setArl(33).getArl();
        p.p(arl);////[11,22,33]

    }
    /**
     ****************************************************************************************
     * */
    /**
     *equals缩写,判断两个字符串如果等于返回true
     * */
       public static boolean dy(String str1 ,String str2){
           if(str1!=null){
               if(str1.equals(str2)){
                   return true;
               }else{
                   return false;
               }
           }else if(str2!=null){
               if(str2.equals(str1)){
                   return true;
               }else{
                   return false;
               }
           }else if(str1==null&&str2==null){
               p("str1和str2都是null");
               return false;
           }else{
               //这种情况基本不会发生
               return false;
           }
       }

    //equals缩写,判断两个字符串如果不等于返回true
    public static boolean bdy(String str1 ,String str2){
           if(dy(str1,str2)){
               return false;
           }else{
               return true;
           }

    }


//    public static void main(String[]args){
//        p.p(p.bdy(null,null));
//    }



    public static void make1970null(Object o){
        List<Field> fieldList=new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for(Field field:fieldList){
            field.setAccessible(true);
            //得到当前字段类型
            String typeName = field.getType().getTypeName();
            if("java.util.Date".equals(typeName)){
                //得到我的生日
                try {
                    if(field.get(o)!=null){
                        Date date=null;
                        try {  date = new SimpleDateFormat("yyyy-MM-dd").parse("1986-12-26"); } catch (ParseException e) { e.printStackTrace(); }
                        long mybrith = date.getTime();
                        long time = ((Date) field.get(o)).getTime();
                        if(time<=mybrith){
                            //如果这个时间小于我的生日,证明这个时间是在1986年以前的时间,需要变成NULL
                            field.set(o,null);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     *解决字段set方法的时候需要null变空的问题
     * null变空
     * 一般用于插入数据库不想有空的情况或者字段返回前端不想有空的情况
     * */
    public String fieldNull2Space(String str) {
        return str==null?"":str;
    }

    /**
     *这种用于插入数据库的时候想insertSelective(空的不插入的情况)
     * */
    public String fieldSpace2Null(String str) {
        return "".equals(str)?null:str;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(String s){
        if(null==s){
            return null;
        }else{
            try {
                return new BigDecimal(s);
            } catch (Exception e) {
                   return null;
            }
        }
    }


    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Double d){
        if(null==d){
            return null;
        }else{
            try {
                return new BigDecimal(d);
            } catch (Exception e) {
                return null;
            }
        }
    }
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Integer i){
        if(null==i){
            return null;
        }else{
            try {
                return new BigDecimal(i);
            } catch (Exception e) {
                return null;
            }
        }
    }
    //new 一个BigDecimal//非正常情况返回null
    public static BigDecimal b(Long L){
        if(null==L){
            return null;
        }else{
            try {
                return new BigDecimal(L);
            } catch (Exception e) {
                return null;
            }
        }
    }


    /**
     *bigdecimal变String
     * */

    public static String bigDecimal2StringSpace(BigDecimal b){
        if(b==null){
            return "";
        }else{
            return String.valueOf(b);
        }
    }
    public static String bigDecimal2String0(BigDecimal b){
        if(b==null){
            return "0";
        }else{
            return String.valueOf(b);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    /**
     ****************************************************************************************
     * */

    /**
     *得到当前的Date格式的时间
     * */
    public static Date getDate(){
        return new Date();
    }


    /**
     *得到当前的Long格式的时间戳
     * */
    public static Long getTimeStamp(){
        return new Date().getTime();
    }


    /**
     *2个日期相减得到的毫秒数量
     * */
        public static Long xjms(Date bigDate,Date samllDate){
            if(bigDate==null||samllDate==null){
                return null;
            }else{
                return bigDate.getTime()-samllDate.getTime();
            }
        }

    /**
     *2个日期相减得到的秒数量
     * 相减second
     * */
    public static Long xjs(Date bigDate,Date samllDate){
        Long xjms = xjms(bigDate, samllDate);
        if(xjms ==null){
            return null;
        }else{
            return xjms/1000;
        }
    }

    /**
     *2个日期相减得到的分钟数量
     * */
    public static  Long xjmin(Date bigDate,Date samllDate){
        Long xjs = xjs(bigDate, samllDate);
        if(xjs ==null){
            return null;
        }else{
            return xjs/60;
        }
    }

    /**
     *2个日期相减得到的小时数量
     * */
    public  static Long xjh(Date bigDate,Date samllDate){
        Long xjmin = xjmin(bigDate, samllDate);
        if(xjmin ==null){
            return null;
        }else{
            return xjmin/60;
        }
    }

    /**
     *2个日期相减得到的天数
     * */
    public static Long xjd(Date bigDate,Date samllDate){
        Long xjh = xjh(bigDate, samllDate);
        if(xjh ==null){
            return null;
        }else{
            return xjh/24;
        }
    }


    //@Test
    public void testDD() throws ParseException {
        p.p(xjh(new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-14"),new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-13")));
    }
    /**
     ****************************************************************************************
     * */


    /**
     *字符串日期转化成date
     * yyyy-MM-dd HH:mm:ss.SS
     * */

    public static Date tod(String strDate,String geshi) {
        if(strDate==null){
            return null;
        }
        try {
            return new SimpleDateFormat(geshi).parse(strDate);
        } catch (ParseException e) {
//            e.printStackTrace();
            return null;
        }
    }

    public static Date todAll(String strDate) {
        if(strDate==null){
            return null;
        }
        try {
            return new SimpleDateFormat(d16).parse(strDate);
        } catch (ParseException e) {
            try {
                return  new SimpleDateFormat(d1).parse(strDate);
            } catch (ParseException e1) {
                try {
                    return  new SimpleDateFormat(d2).parse(strDate);
                } catch (ParseException e2) {
                    try {
                        return  new SimpleDateFormat(d3).parse(strDate);
                    } catch (ParseException e3) {
                        try {
                            return  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").parse(strDate);
                        } catch (ParseException e4) {
                            try {
                                return  new SimpleDateFormat(d5).parse(strDate);
                            } catch (ParseException e5) {
                                try {
                                    return  new SimpleDateFormat(d6).parse(strDate);
                                } catch (ParseException e6) {
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    /**
     *将excel里面的距离1900/1/1的时间转为
     * unix标准时间,
     * excelDayNumStr就是excel里的时间 比如  43333  就是距离 1900-01-01   43333天的时间
     * */
    public static Date excelData2Date(String excelDayNumStr) throws ParseException {
        try {
            //得到excel起始值计算的毫秒数
            long time = new SimpleDateFormat(d16).parse("1900-1-1 00:00:00.000").getTime();
            //得到excel中的毫秒数
            BigDecimal b = p.b(excelDayNumStr).multiply(p.b(24)).multiply(p.b(3600)).multiply(p.b(1000));
            BigDecimal add = b.add(b(time)).subtract(p.b(2*24*3600*1000));//不知道为啥多了2天,后面减掉2天
            if(String.valueOf(add).contains(".")){
                return  new Date(new Long(String.valueOf(add).substring(0,String.valueOf(add).indexOf("."))));
            }else{
                return  new Date(new Long(String.valueOf(add)));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }





//
//    public static void main(String[]args) throws ParseException {
//        p.p("-------------------------------------------------------");
//        p.p(p.dtoStr(excelData2Date("43353.5690740741")));
//        p.p("-------------------------------------------------------");
//    }



    /**
     *yyyy-MM-dd转换成默认日期的
     * */
    public static Date tod(String strDate) {
        if(strDate==null){
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *Date 变成 String异常的时候转换成yyyy-MM-dd HH:mm:ss.SSS
     * */
    public static String  dtoStr(Date date,String geshi) {
        if(date==null){
            return null;
        }

        try {
            return new SimpleDateFormat(geshi).format(date);
        } catch (Exception e) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
        }

    }

    /**
     *Date 变成 String默认格式
     * yyyy-MM-dd HH:mm:ss.SS
     * */
    public static String  dtoStr(Date date) {
        if(date==null){
            return null;
        }
        String format = null;
        try {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            format= null;
            e.printStackTrace();
        }
        return format;
    }




    public String  dtoStrs(Date date) {
        if(date==null){
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(date);
    }
    /**
     ****************************************************************************************
     * */
    //@Test
    public void f2(){
        p(dtoStrs(new Date()));
    }

    /**
     ****************************************************************************************
     * */

    /**
     *小于等于我的生日,精确到日,因为我的生日只能精确到日,这玩意可以用来处理1970和1899的判断
     * */

    public static boolean isSmallOrEqMybirth(Date date){
        if(date==null){
            return false;
        }else{
            if((date.getTime())<=(p.tod(p.hanhanBirthday_).getTime())){
                return true;
            }else{
                return false;
            }
        }
    }


    /**
     *大于我的生日,精确到日,因为我的生日只能精确到日,这玩意可以用来处理1970和1899的判断
     * */

    public static boolean isBiggerThenMybirth(Date date){
        return !isSmallOrEqMybirth(date);
    }

//    public static void main(String[]args){
//          p.p(isBiggerThenMybirth(new Date()));
//        p.p(isSmallOrEqMybirth(new Date()));
//    }
    /**
     *时间比大小,精确到时间戳毫秒
     * */
    public static boolean isFirstDateBig(Date first,Date second){
        if(first==null || second==null){
            return false;
        }else{
            if(first.getTime()>second.getTime()){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     *时间比大小,精确到时间戳毫秒
     * */
    public static boolean isFirstDateSmall(Date first,Date second){
        return !isFirstDateBig(first,second);
    }
    /**
     *默认是"yyyy-MM-dd"的str格式才能比较,精确到日
     * */
    public static boolean isFirstDateBig_(String firstStr,String  secondStr){
        Date first= tod(firstStr);
        Date second=tod(secondStr);
        return isFirstDateBig(first,second);
    }

    /**
     *默认是"yyyy-MM-dd"的str格式才能比较,精确到日
     * */
    public static boolean isFirstDateSamll_(String firstStr,String  secondStr){
        Date first= tod(firstStr);
        Date second=tod(secondStr);
        return !isFirstDateBig(first,second);
    }

/**
 *默认是"yyyy/MM/dd"的str格式才能比较
 * 这里说的大小是字面大小,距离1970越远越大
 * 精确到日
 * */
public static boolean isFirstDateBig(String firstStr,String  secondStr){
    Date first= tod(firstStr,"yyyy/MM/dd");
    Date second=tod(secondStr,"yyyy/MM/dd");
    return isFirstDateBig(first,second);
}

    /**
     *默认是"yyyy/MM/dd"的str格式才能比较
     * 这里说的大小是字面大小,距离1970越远越大
     * 精确到日
     * */
    public static boolean isFirstDateSmall(String firstStr,String  secondStr){
        Date first= tod(firstStr,"yyyy/MM/dd");
        Date second=tod(secondStr,"yyyy/MM/dd");
        return !isFirstDateBig(first,second);
    }
    //@Test
   public void f3() {
    p(isFirstDateBig("2017/12/24", "2017/12/23"));//true
}
    /**
     ****************************************************************************************
     * */

    public static boolean isFirstDateBig(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy/MM/dd");
        return isFirstDateBig(first,second);
    }

    public static boolean isFirstDateBig_(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy-MM-dd");
        return isFirstDateBig(first,second);
    }
    public static boolean isFirstDateSmall(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy/MM/dd");
        return !isFirstDateBig(first,second);
    }

    public static boolean isFirstDateSmall_(Date first,String  secondStr){
        Date second=tod(secondStr,"yyyy-MM-dd");
        return !isFirstDateBig(first,second);
    }
    public static boolean isFirstDateBig(String firstStr,Date  second){
//        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy/MM/dd");
            return isFirstDateBig(first,second);
//        }
    }

    public static boolean isFirstDateBig_(String firstStr,Date  second){
//        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy-MM-dd");
            return isFirstDateBig(first,second);
//        }
    }
    public static boolean isFirstDateSmall(String firstStr,Date  second){
//        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy/MM/dd");
            return !isFirstDateBig(first,second);
//        }
    }

    public static boolean isFirstDateSmall_(String firstStr,Date  second){
//        synchronized (ThreadLocal.class) {
            Date first= tod(firstStr,"yyyy-MM-dd");
            return !isFirstDateBig(first,second);
//        }
    }
    //@Test
    public void f4() {
        p(isFirstDateBig(new Date(), "2017/12/02"));//true
    }
    /**
     ****************************************************************************************
     * */





    /**
     *生成0到999之间的随机数,顺序循环,spring容器启动后顺序循环
     * */
    private static int orderRandom=0;
    public  static  int orderRandom999(){
        int i=0;
        i=orderRandom;
        orderRandom=orderRandom+1;
        if(orderRandom>=1000)orderRandom=0;
        return i;
    }

//    public static String  r(){
//
//    }
//
    /**
     *随机冒号变分号23位,冒号做文件名字在路径里不行,分号也不行
     *2018-08-17@16-46-06.006
     * */
    public static String r(){
        return new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.sss").format(new Date());
    }

//    public static void main(String[]args){
//            System.out.println(r());
//    }

    /**
     *
     * 2018-08-17@16-44-34.034@826
     * */
    public static String ra3(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()).replace(":","-").replace(" ","@")+"@"+String.valueOf(p.random0_999());
    }

    /**
     *最后3位是容器循环随机
     * 2018-08-17@16-38-31.031@0
     * */
    public static String ra3o(){
        return new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.sss").format(new Date())+"@"+String.valueOf(p.orderRandom999());
    }

    /**
     *无20头
     *18-08-17@16-40-07.007
     * */
    public static String raNoH(){
        return new SimpleDateFormat("yy-MM-dd@HH-mm-ss.sss").format(new Date());
    }

    /**
     *无20头加三位随机
     * 18-08-17@16-41-35.035@403
     * */
    public static String raNoH3(){
        return new SimpleDateFormat("yy-MM-dd@HH-mm-ss.sss").format(new Date())+"@"+String.valueOf(p.random0_999());
    }

    /**
     *最后三位是容器循环随机(在容器 中运行的时候才会随机)
     * 18-08-17@16-43-09.009@0
     * */
    public static String rfNoH3o(){
        return new SimpleDateFormat("yy-MM-dd@HH-mm-ss.sss").format(new Date())+"@"+String.valueOf(p.orderRandom999());
    }




    /**
     *时间戳转换成Date
     * */
    public static Date sjc2Date(String shiJianChuoStr){
        if(null==shiJianChuoStr||"".equals(shiJianChuoStr)){
            return null;
        }else{
            long lt = new Long(shiJianChuoStr);
            Date date= new Date(lt);
            return  date;
        }

    }

    public static Date sjc2Date(Long shiJianChuo){
        if(null==shiJianChuo){
            return null;
        }else{
            Date date= new Date(shiJianChuo);
            return  date;
        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //时间戳变成str格式时间

    public static String sjc2StrDate(String strSjc){
       return p.dtoStr(p.sjc2Date(strSjc),p.d16);

    }
    public static String sjc2StrDate(String strSjc,String geShi){
        return p.dtoStr(p.sjc2Date(strSjc),geShi);

    }
    public static String sjc2StrDate(Long longSjc){
        return p.dtoStr(p.sjc2Date(longSjc),p.d16);

    }

    public static String sjc2StrDate(Long longSjc,String geShi){
        return p.dtoStr(p.sjc2Date(longSjc),geShi);

    }
    /*public static void main(String[]args){
        //1970-01-01 08:02:01.344得到这种形式
         p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(sjc2StrDate("121344"))).sad(p.dexhx).gad());
        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(sjc2StrDate(121344L))).sad(p.dexhx).gad());
        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(sjc2StrDate(121344L,d16))).sad(p.dexhx).gad());
    }*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *把所有是类中所有是null的字段,如果是String类型,变成""
     * */
    public static Object StringTypeNull2Space(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (StringType.equals(type.getName())) {
                if(null==field.get(o)){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,space);
                }

            }
        }
        return o;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Object StringTypeSpace2Null(Object o) throws IllegalAccessException {
    List<Field> fieldList = new ArrayList<>();
    Class<?> aClass = o.getClass();
    while (aClass != null) {//用while得到所有超类的字段属性
        fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
        aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
    }
    for (Field field : fieldList) {
        field.setAccessible(true);
        Class<?> type = field.getType();
        if (StringType.equals(type.getName())) {
            if(space.equals(field.get(o))){//把o穿进去,得到o的属性值
                //设置o的属性值
                field.set(o,null);
            }

        }
    }
    return o;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *当日期小于我的生日的时候,证明这个日期不太正确,设置为null
     * 这个是针对某些框架内部会把Date设置为1970或者1899的情况
     * */
    public static Object dateTypeSamll2Null(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (DateType.equals(type.getName())) {
                if(isFirstDateBig(hanhanBirthday,(Date)field.get(o))){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,null);
                }

            }
        }
        return o;
    }


    /**
     *把字段是Date的小于1986的都设置为null
     * 把字段是String的是""的都设置为null
     * */
    public static Object dateTypeSamllAndStringTypeSpace2Null(Object o) throws IllegalAccessException {
        List<Field> fieldList = new ArrayList<>();
        Class<?> aClass = o.getClass();
        while (aClass != null) {//用while得到所有超类的字段属性
            fieldList.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (DateType.equals(type.getName())) {
                if(isFirstDateBig(hanhanBirthday,(Date)field.get(o))){//把o穿进去,得到o的属性值
                    //设置o的属性值
                    field.set(o,null);
                }

            }else if(StringType.equals(type.getName())){
                if(space.equals(field.get(o))){
                    field.set(o,null);
                }
            }
        }
        return o;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
    public void f5(){
        p(Date.class.getName());
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *关于list去除一个元素变长问题
     *
     * 这个工具主要是解决  从list元素里删除若干个符合条件的元素,list装的是基本类型的时候比较基本类型,是对象的时候比较对象
     * 的某一个参数值来决定是否删除list中的该对象
     *
     *
     * 参数  list 是一个装满  listEleType 类型的list
     * 参数 listEleType  是list里面装的元素的类型,注意,一定要装的是同一类型才能用该工具
     * 参数 comparedFieldName就是将来要删除的元素中如果是对象类型的,comparedFieldName就是该对象的属性名的字符串形式
     * 如果 list里装的不是对象,compareContentToFieldValue可以写个""或者NULL,因为不会走到比较对象那一步
     *
     * compareContentToFieldValue是将来安排的"比较内容",比如,你要删除的元素的属性值是compareContentToFieldValue的才删除,
     * 其他不删除,  如果list装的是一般类型不是对象,这个值就代表了list里面的元素值
     *
     *
     * compareContentToFieldValue填入的是NULL的时候删除的就是属性值是NULL的那个元素
     * */
    public static void removeSameEle(List<?> list ,Class listEleType,String comparedFieldName,Object compareContentToFieldValue) throws IllegalAccessException {

        //如果list里面没东西,直接不进行了
        if(list==null||list.size()==0){
           return;
        }
        Object listFirstObj = list.get(0);

        //此时是String类型
        if(StringType.equals(listEleType.getTypeName())||BigDecimalType.equals(listEleType.getTypeName())){
            Iterator<?> iterator = list.iterator();
            while(iterator.hasNext()){
                Object next = iterator.next();
                if(compareContentToFieldValue==null){
                    iterator.remove();
                }else if(next.equals(compareContentToFieldValue)){
                    iterator.remove();
                }
            }
        //此时是数字类型
       }else if(numberTypelist.contains(listEleType.getTypeName())) {
            Iterator<?> iterator = list.iterator();
            while(iterator.hasNext()){
                Object next = iterator.next();
                if(compareContentToFieldValue==null){
                    iterator.remove();
                }else if(next==(compareContentToFieldValue)){
                    iterator.remove();
                }
            }
       //此时是普通对象带元素的类型
       }else if(listFirstObj.getClass().getTypeName().equals(listEleType.getTypeName())){
           Iterator<?> iterator = list.iterator();
           while(iterator.hasNext()){
               Object next = iterator.next();
               Field[] declaredFields = next.getClass().getDeclaredFields();
               for(Field field:declaredFields){
                   field.setAccessible(true);
                   Object o = field.get(next);
                   String fieldName = field.getName();
                   String typeName = o.getClass().getTypeName();
                   //此时是删除是某个元素属性是NULL的那个元素
                   if(comparedFieldName.equals(fieldName)&&StringType.equals(typeName)&&o==null&&compareContentToFieldValue==null){
                       iterator.remove();
                       //属性值是String的情况
                   }else if(comparedFieldName.equals(fieldName)&&StringType.equals(typeName)&&o.equals(compareContentToFieldValue)){
                       iterator.remove();
                       //属性值是BigDecimal的情况
                   }else if(comparedFieldName.equals(fieldName)&&BigDecimalType.equals(typeName)&&o.equals(compareContentToFieldValue)){
                       iterator.remove();
                       //属性是数字类型的情况,数字类型就是numberTypelist里的所有类型
                   }else if(comparedFieldName.equals(fieldName)&&numberTypelist.contains(typeName)&&o==compareContentToFieldValue){
                       iterator.remove();
                   }else{

                   }
               }
           }
       }else{
           p.p("此时的list里面装的类型是："+listEleType.getTypeName()+"无法进行比对,请优化工具对类型的处理情况");
       }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
    public void f8() throws IllegalAccessException {
        List<x>list=new ArrayList<>();
        list.addAll(p.gp().setArl(new x().setStr("str")).setArl(new x().setStr("str")).setArl(new x().setStr("xxx")).getArl());
        p.p(list);
        //删除字段str属性值是"xxx"的
        removeSameEle(list,x.class,"str","xxx");
        p.p(list);

    }

    //@Test
    public void f9() throws IllegalAccessException {
        List<x>list=new ArrayList<>();
        list.addAll(p.gp().setArl(new x().setStr("str")).setArl(new x().setStr("str")).setArl(new x().setStr("xxx")).getArl());
        p.p(list);
        //删除子弹str属性值是"xxx"的
        removeSameEle(list,x.class,"str","str");
        p.p(list);

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //@Test
    public void f6(){
        p.p("".getClass().getTypeName());
        p.p(new Integer(5).getClass().getTypeName());
        p.p(new BigDecimal(5).getClass().getTypeName());
        p.p(new BigDecimal(5).equals(new BigDecimal(6)));//false
        p.p(new BigDecimal(5).equals(new BigDecimal(5)));//true
    }




    /**
     *System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
     * */
    public class x{
        public int x=1;
        public String str="str";

        public int getX() {
            return x;
        }

        public x setX(int x) {
            this.x = x;
            return this;
        }

        public String getStr() {
            return str;
        }

        public x setStr(String str) {
            this.str = str;
            return this;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("com.winwin.picreport.Futils.hanhan.p.x{");
            sb.append("x=").append(x);
            sb.append(", str='").append(str).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     *
     * */
    //@Test
    private void f7(){
        Field[] declaredFields = x.class.getDeclaredFields();
        for(Field field:declaredFields){
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
//            p.p(field.getName());
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~实验~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }
 /**
     *输入一个字符串格式的数字,然后四舍五入到max和min的小数位数,一般max
     * 和min的值都写一样,比如max=min=4就是说四舍五入后小数后面留4位
     * */
    public static String getNum(int max,int min,String num){
        if(num==null){
            return null;
        }
        num=num.replace(",","");
        BigDecimal b;
        try {
            b = new BigDecimal(num);
        } catch (Exception e) {
            p("p.getNum yao format de bu shi shuZi001 ----  public static String getNum(int max,int min,String num)");
            return null;
        }
        try {
            java.text.NumberFormat  f  =  java.text.DecimalFormat.getInstance();
            f.setMaximumFractionDigits(max);
            f.setMinimumFractionDigits(min);
            return f.format(b).replace(",","");
        } catch (Exception e) {
            p("p.getNum yao format de bu shi shuZi002 ------ public static String getNum(int max,int min,String num)");
            return null;
        }
    }





    /**
     *下面一个方法是为了解决String.valueOf(str)当str=null的情况的方法
     * */
    public static String strValeOfNullSpace(Object o){
        if (null==o){
            return "null";
        }else {
            return String.valueOf(o);
        }
    }

    public static String strValeOfSpace(Object o){
        if (null==o){
            return "";
        }else {
            return String.valueOf(o);
        }
    }
    public static String strValeOf0(Object o){
        if (null==o){
            return "0";
        }else {
            return String.valueOf(o);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static BigDecimal b(Object o){
    if(null==o){
        return null;
    }else{
        try {
            return new BigDecimal(String.valueOf(o));
        } catch (Exception e) {
            return null;
        }
    }
}

    /**
     *是否是BigDecimal
     * */
    public static boolean isBd(Object o){
        try {
            new BigDecimal(String.valueOf(o));
            //不抛异常就是true
            return true;
        } catch (Exception e) {
            //抛出异常就是false
            return false;
        }
    }

    public static boolean isBigDecimal(String str){
        if(null==str||"".equals(str)||str.contains(" ")){return false;}
        if(str.contains("-")){
            if(str.indexOf("-")!=str.lastIndexOf("-")){
                //含有多个负号
                return false;
            }else if(str.indexOf("-")!=0){
                //负号不在第一位
                return false;
            }
            return  whenNoPlusOrMinus(str.replace("-",""));
        }else if(str.contains("+")){
            if(str.indexOf("+")!=str.lastIndexOf("+")){
                //含有多个负号
                return false;
            }else if(str.indexOf("+")!=0){
                //负号不在第一位
                return false;
            }
            return  whenNoPlusOrMinus(str.replace("+",""));
        }else{
            return  whenNoPlusOrMinus(str);
        }
    }

    private static boolean whenNoPlusOrMinus(String str){
        if(str.contains(".")){
            //开始和结尾有.是可以做小数点的
            /*if(str.startsWith(".")||str.endsWith(".")){
                //不应该在开头或者结束有小数点
                return false;
            }*/
            //当最后一个点和最前面一个点不是一个点的时候,说明有2个点,不是数字
            if(str.indexOf(".")!=str.lastIndexOf(".")){
                //此时有2个或者2个以上小数点,明显不是数字
                return false;
            }else{
                String strTemp = str.replace(".", "");
                //有一个点的时候考虑去掉点后是不是全都是数字
                for (int i = strTemp.length();--i>=0;){
                    if (!Character.isDigit(strTemp.charAt(i))){
                        return false;
                    }
                }
            }
        }else{
            for (int i = str.length();--i>=0;){
                if (!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     *BigDecimal相加
     * */
    public static BigDecimal badd(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).add(p.b(o2));
        }else{
            return null;
        }
    }
    /**
     *BigDecimal相减,前减去后面
     * */
    public static BigDecimal bsub(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).subtract(p.b(o2));
        }else{
            return null;
        }
    }
    /**
     *BigDecimal乘,前乘以后面
     * */
    public static BigDecimal bmul(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).multiply(p.b(o2));
        }else{
            return null;
        }
    }
    /**
     *BigDecimal除法,前面除以后面,后面是除数,前面被除数
     * */
    public static BigDecimal bdiv(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).divide(p.b(o2));
        }else{
            return null;
        }
    }

    /**
     * BigDecimal
     *前面比后面大
     * */
    public static boolean bbig(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).compareTo(p.b(o2))==1;
        }else{
            return false;
        }
    }
    /**
     * BigDecimal
     *前面比后面小
     * */
    public static boolean bsml(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).compareTo(p.b(o2))==-1;
        }else{
            return false;
        }
    }

    /**
     * BigDecimal
     *两数字相等
     * */
    public static boolean beql(Object o1,Object o2){
        if(p.notEmpty(o1)&&p.notEmpty(o2)&&p.isBd(o1)&&p.isBd(o2) ){
            return p.b(o1).compareTo(p.b(o2))==0;
        }else{
            return false;
        }
    }
    /**
     *删除文件
     * */
    public static void Del(File file){
        if(file!=null&&file.exists()){
            file.delete();
        }
    }


    /**
     *根据文件判断文件是否存在
     * */
    public static boolean exists(File file){
        if(file==null){
            return false;
        }else{
            if(file.exists()){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean notExists(File file){
        return !exists(file);
    }
    /**
     *根据路径判断文件是否存在
     * */
    public static boolean notExists(String filePath){
        return !exists(filePath);
    }
    public static boolean exists(String filePath){
        if(null==filePath||"".equals(filePath)){
            return false;
        }else{
            File file=new File(filePath);
            if(file==null){
                return false;
            }else{
                if(file.exists()){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *是否是email
     * */

    public static boolean isEmail1(String emailStr){
        if (Pattern.compile(emailPattern1).matcher(emailStr).find()) {
            return true;
        }
        return false;
    }
    public static boolean isEmail2(String emailStr){
        if (Pattern.compile(emailPattern2).matcher(emailStr).find()) {
            return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *null和undefined变成""
     * */
    public static String nullUndefinedToSpace(String str){
        str=(str==null?"":str);
        str=("undefined".equals(str)?"":str);
        return str;
    }
    /**
     *前提是数字的时候null变成0,undefined变成0
     * */
    public static String NumNullUndefinedToStrZero(String str){
        str=(str==null?"0":str);
        str=("undefined".equals(str)?"0":str);
        return str;
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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *n倍相同字符串的设计
     * */

    public static String nStr(String s,int n){
        StringBuilder ss=new StringBuilder();
        for(int i=0;i<n;i++){
            ss.append(s);
        }
        return ss.toString();
    }

    /*public static void main(String[]args){
        p.p(p.gp().sad(p.dexhx).sad(p.nStr("草",5)).sad(p.dexhx).gad());
    }*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *计算整型的长度
     * */

    public static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

//    public static void main(String[]args){
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(p.sizeOfInt(213123))).sad(p.dexhx).gad());
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *是否是电话号码
     * */

    public static boolean isPhoneNo(String phoneNoStr){
        if (Pattern.compile(phonePattern).matcher(phoneNoStr).find()) {
            return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * addDate是负数就代表减去几天,addDate是正数代表加上几天
     * */
    public static Date getNextDay(Date date,int addDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,addDate);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

//    public static void main(String[] args) {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date date =new Date( );
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(getNextDay(date,3)));
//
//    }
////统计小数点后面位数//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *统计小数点后面位数
     * */

    public static Integer dianHouWeiShu(String shuZi){
        //得到点号后面的位数索引//从0开始//ejh是English句号的意思
        int i = shuZi.indexOf(p.ejh) + 1;
        //截取到shuZi小数点后面(不包括)所有的位数
        shuZi = shuZi.substring(i);
        //这个长度说的是字符长度,汉字跟字母数字都一样
        Integer length = shuZi.length();
        if(i==0) {
            //此时没有.号//点号后面肯定是0
            length=0;
        }
        if(Integer.valueOf(shuZi)==0){
            //针对123.0000D这种
            length=0;
        }
        return length;
    }
    public static Integer dianHouWeiShu(Double shuZi){
        return dianHouWeiShu(String.valueOf(shuZi));
    }

//    public static void main(String[]args){
//             p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(p.dianHouWeiShu(123123.001D))).sad(p.dexhx).gad());
//    }
    /**
     *截取字符串
     * 注意索引start是从0开始,
     * 截取是
     * 包括startHave
     * 不包括endNotHave
     *
     * 如果被截取对象是空的,就返回空
     *
     *
     *
     * 注意当endNotHave已经超过最大能索引到的东西的时候
     * ,直接截取 startHave后面所有的
     * */
    public static String strCut(String originalStr,int startHave,int endNotHave){
        int length = originalStr.length();
        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(startHave>length){
            return"";
        }else if(startHave==length){
            return "";
        }else if(startHave<length&&endNotHave>length){
            return originalStr.substring(startHave);
        }else{
            return originalStr.substring(startHave,endNotHave);
        }
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(strCut("eer",2,4));
//        p.p("eer".indexOf(3));//-1
//        p.p("-------------------------------------------------------");
//    }

    /**
     *截取originalStr中从startHave(包括)到endNotHave(不包括)的字符串
     *
     * 注意这个方法使用的前提是:  startHave和endNotHave只出现过一次
     * dsfasdfa使用该函数
     * strCut("dsfasdfa","sf","df")
     * 后变成
     * sfas
     * 可以发现,截取的是从sf开始并包括sf
     * 从df结束,并不包括df
     *
     * 这个是跟官方截取一直的[)方式
     *
     * 有头无尾
     * */
    public static String strCut(String originalStr,String startHave,String endNotHave){
        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(!originalStr.contains(startHave)||!originalStr.contains(endNotHave)){
            //此时没法截取,因为不包含要 截取的头或者尾部
            return "";
        }else{
            return originalStr.substring(originalStr.indexOf(startHave),originalStr.indexOf(endNotHave));
        }
    }


    /**
     * 注意这个方法使用的前提是:  startHave和endNotHave只出现过一次
     * (]
     *strCutNoHead("sdabkjwp","da","jw")
     * 得到的是
     * bkjw
     * 无头有尾
     * */

    public static String strCutNoHead(String originalStr,String startNotHave,String endHave){
        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(!originalStr.contains(startNotHave)||!originalStr.contains(endHave)){
            //此时没法截取,因为不包含要 截取的头或者尾部
            return "";
        }else{
            return originalStr.substring(
                    p.strIndxTail(originalStr,startNotHave)+1
                    ,p.strIndxTail(originalStr,endHave)+1
            );
        }
    }
//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(strCutNoHead("sdabkjwp","da","jw"));
//        p.p("-------------------------------------------------------");
//    }

    /**
     *注意这个方法使用的前提是:  startHave和endNotHave只出现过一次
     * 无头无尾
     *()方式截取
     * strCutNoHeadTail("sdabkj","da","j")
     * 得到的是bk,就是截取da和j之间的东西
     * */

    public static String strCutNoHeadNoTail(String originalStr,String startNotHave,String endNotHave){

        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(!originalStr.contains(startNotHave)||!originalStr.contains(endNotHave)){
            //此时没法截取,因为不包含要 截取的头或者尾部
            return "";
        } else{
            p.p("-------------------------strCutNoHeadNoTail------------------------------");
            p.p2(p.strIndxTail(originalStr,startNotHave));
            p.p2(originalStr.indexOf(endNotHave));
            p.p("-----------------strCutNoHeadNoTail--------------------------------------");

            return originalStr.substring(p.strIndxTail(originalStr,startNotHave)+1,originalStr.indexOf(endNotHave));
        }

    }

    /**
     * 注意这个方法使用的前提是:  startHave和endNotHave只出现过一次
     * 有头有尾
     *[]这种截取方式
     * strCutHaveHeadAndTail("sdabkjwp","da","jw")
     * 得到的结果是
     * dabkjw
     * */
    public static String strCutHaveHeadAndTail(String originalStr,String startHave,String endHave){

        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(!originalStr.contains(startHave)||!originalStr.contains(endHave)){
            //此时没法截取,因为不包含要 截取的头或者尾部
            return "";
        } else{
            return originalStr.substring(
                    p.strIndxHead(originalStr,startHave)
                    ,p.strIndxTail(originalStr,endHave)+1
            );
        }

    }




    /**
     * 注意这个方法使用的前提是:  startHave只出现过一次
     * 从头带头到底
     * [------最后这种
     *从  索引startHave开始(包括startHave索引处的字符)
     * 到字符串结束为止
     * */
    public static String strCut(String originalStr,int startHave){
        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(originalStr.length()-1<startHave){
            return "";
        }else{
            return originalStr.substring(startHave);
        }
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(strCut("sdfasdf",7));
//        p.p("-------------------------------------------------------");
//    }

    /**注意这个方法使用的前提是:  startHave只出现过一次
     * [------这种
     * 从头带头到尾
     *截取字符串originalStr从startHave(包括)开始
     * 到最后结束
     *
     * */
    public static String strCut(String originalStr,String startHave){
        if(null==originalStr||"".equals(originalStr)){
            return "";
        }else if(!originalStr.contains(startHave)){
            return "";
        }else{
            return originalStr.substring(originalStr.indexOf(startHave));
        }
    }

    /**
     *
     * 索引要索引字符串的头
     *字符串中字符的索引,该索引从0开始的
     * strIndxHead("dsfasdfa","sf")得到的结果是1,
     * 因为d是第0位,sf就是第1位,这里是将sf当成整体,
     * 其实是索引的sf中的s的索引作为sf整体的索引了
     *
     * 其实官方的不包含要索引的字符串的时候,返回的也是-1
     *
     *
     *
     * strIndxHead("1211221","1")=1证明  索引的是第一次出现的位置,毕竟1有那么多,他只索引了第一个
     * */

    public static int strIndxHead(String strOrignal,String strIndx){
        if(null==strOrignal){
            return -1;
        }else if(!strOrignal.contains(strIndx)){
            return -1;
        }else{
            return strOrignal.indexOf(strIndx);
        }

    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(strIndxHead("1211221","1"));//0 ,证明索引的是第一次出现的位置
//        p.p("-------------------------------------------------------");
//    }


    /**
     * 索引要索引字符串的尾部
     * tail是尾巴的意思
     *得到strIndx索引的最后一位索引
     * strIndxTail("dsfa_sdfa","sfa")=3
     * */
    public static int strIndxTail(String strOrignal,String strIndx){
        if(null==strOrignal){
            return -1;
        }else if(!strOrignal.contains(strIndx)){
            return -1;
        }else{
            return strOrignal.indexOf(strIndx)+strIndx.length()-1;
        }

    }
//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(strIndxTail("dsfa_sdfa","sfa"));
//        p.p("-------------------------------------------------------");
//    }
    /**
     * 索引整个字符串的下一个字符串的索引
     *
     *strNextIndx("dsfa_sdfa","fa")得到的结果是4
     * 因为这个我设计的是得到"_"的索引,
     * 通过第一个"fa"所在位置推断"_"的索引是4
     * */
    public static int strNextIndx(String strOrignal,String strIndx){
        if(null==strOrignal){
            return -1;
        }else if(!strOrignal.contains(strIndx)){
            return -1;
        }else{
            return strOrignal.indexOf(strIndx)+strIndx.length();
        }

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     * 判断每一位是否是数字,如果是小数有小数点,返回的是false
     * 如果每一个字符都是数字,返回true
     */
    public static boolean isNumeric(String str){
        if(null==str){
            return false;
        }else if("".equals(str)){
            return false;
        }else{
            if(Pattern.compile("[0-9]*").matcher(str).matches()){
                return true;
            }else{
                return false;
            }
        }
    }
    public static boolean isPic(String jueDuiLuJing){
        try {
            String s=jueDuiLuJing.substring(jueDuiLuJing.lastIndexOf("."));
            if(p.imgSufixs.contains(s)){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPic(File file){
        return isPic(file.getAbsolutePath());
    }
//    public static void main(String[]args){
//        //_________________true_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isNumeric("11231212333333333333333333333333333333"))).sad(p.dexhx).gad());
//       //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isNumeric("1123.213123"))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isNumeric(""))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isNumeric(null))).sad(p.dexhx).gad());
//    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*方法二：推荐，速度最快
  * 判断是否为整数
  * @param str 传入的字符串
  * @return 是整数返回true,否则返回false//实际上超过long的都返回true
*/

    public static boolean isInteger(String str) {
        if(empty(str)){
            return false;
        }else{
            return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
        }

    }

//    public static void main(String[]args){
//        //_________________true_________________
//         p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isInteger("11111111111111111111111111111111111111111111111111111111111111111111"))).sad(p.dexhx).gad());
//        //_________________false_________________
//         p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isInteger("11.1"))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isInteger(""))).sad(p.dexhx).gad());
//        //_________________false_________________
//        p.p(p.gp().sad(p.dexhx).sad(p.strValeOfNullSpace(isInteger(null))).sad(p.dexhx).gad());
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *将字符串写入文本,注意会覆盖原来的文本内容
     * 注意,这个写入文件,如果文件不存在,会自动创建并写入,但是文件 路径中的文件夹必须存在
     * */
    public static boolean  writeToTxt(String strToWrite,String txtPath) {

        FileWriter writer=null;
        try {
            writer = new FileWriter(txtPath);
            writer.write(strToWrite);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    public static void main(String[]args){
//        boolean b = writeToTxt("[\"1\",\"2\"]", "C:/123");
//        System.out.println(b);
//    }
    /**
     *读文本的所有内容变为字符串
     * */
    public static String readAllTxt(String txtPath){
        File file=null; FileReader fr=null;BufferedReader br=null;
        try {
            file=new File(txtPath);
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String str="";
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            return sb.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[]args){
//         p.p(p.gp().sad(p.dexhx).sad(readAllTxt("E:\\1\\新建文本文档.txt")).sad(p.dexhx).gad());
//
//    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *springBoot  jarPath
     * 得到springboot  jar所在路径,最后带杠的
     *E:\1\work_space\LINZHAN\LinZhan_Picture_ReportTable\
     * 这种
     * //注意这种路径只是得到springboot  的jar所在的路径
     * */

    public static  String  springBootJarPath(){
            //创建一个文件//注意这个文件直接会生成在springboot  jar所在的文件夹中
            String s="hanhan"+UUID.randomUUID().toString();
            File file = new File(s);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String absolutePath = file.getAbsolutePath();
            //去掉最后一个文件名,得到的就是文件夹最后带杠的路径
            String jarPath=absolutePath.substring(0,absolutePath.length()-s.length());
            if(file .exists()) {
                file.delete();
            }
            return jarPath;
    }

    /**
     *得到springboot打包后的jar路径
     * */
    public static String jarPath() {
        /**
         *得到类似路径
         * E:/1/000/LinZhan
         * 我们打包后的springboot 的jar包就在LinZhan文件夹里面
         * */
        String path = p.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        synchronized (p.class) {
            path = path.replace("file:/", "");
            int i = path.lastIndexOf("!");
            i = i - 18;
            path = path.substring(0, i);
            path = path.substring(0, path.lastIndexOf("/"));
//        }
        //处理路径中的%20为 " "
        if(path!=null&&path.contains(enCodeSpace)){
            path=path.replace(enCodeSpace,space);
        }
//       String path="E:/";
        return path;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/**
 *response跨域设置
 * */
    public static void kuaYuAndUtf8Response(HttpServletResponse response, String Content_type, String charset){
    //        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding(charset);
    //        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setHeader("Content-type", Content_type);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
    }
    //////////md5////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        public static void main(String[] args){
//           System.out.println(md5Up32("ceshi0051657786").length());
//            System.out.println(md5_32("ceshi0051657786"));
//        }

    /**
     * 把字符串变成MD5加密码,顺便大写了
     * */
    public static String md5Up32(String inputString) {
        return generatePasswordToUpperCase(inputString);
    }

    /**
     * 把字符串变成MD5加密码,不大写
     * */
    public static String md5_32(String inputString) {
        return encodeByMD5(inputString);
    }

    public static String generatePasswordToUpperCase(String inputString) {
        return encodeByMD5(inputString).toUpperCase();
    }
    //////////////////////////////////////////////////////////////////////////////
    public static String generatePassword(String inputString) {
        return encodeByMD5(inputString);
    }
    //////////////////////////////////////////////////////////////////////////////
    public static String generateHexString(byte[] inputByte) {
        return encodeByMD5(inputByte);
    }

    private static String encodeByMD5(byte[] originByte) {
        if (originByte != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originByte);
                String resultString = byteArrayToHexString(results);
                String pass = resultString.toUpperCase();
                return pass;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originString.getBytes());
                String resultString = byteArrayToHexString(results);
                String pass = resultString;
                return pass;
            } catch (Exception ex) {
                ex.printStackTrace();//TODO change to use logger?
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     *图片和base64互转
     * */

    //图片转化成base64字符串
    public static String GetImageStr(String imagePath)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imagePath;//待处理的图片
        InputStream in = null;
        byte[] data = null;
//读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,String pathToGenerateImg)
    { //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
//Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
//生成jpeg图片
//新生成的图片
            OutputStream out = new FileOutputStream(pathToGenerateImg);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    ///////////////////////////////////////////////////////////////////////
//base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,File file)

    {
//        System.out.println("开始把图片放入文件夹");
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
//Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
//生成jpeg图片
//新生成的图片
//            System.out.println("==============="+file.getAbsolutePath());
            OutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //异常抛出
    public static void throwE(String s){
        throw new RuntimeException(s);
    }

    //去除空白符
    public static String replaceBlank(String str){
        String dest = null;
        if(str == null){
            return dest;
        }else{
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
            return dest;
        }
    }

    /**
     *
     * */
    public static void fuckIt(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {

        }
    }



    /*【群主】变色龙 2018-04-08 15:52:41
    一般 秒级 + 3位随机数*/


    /**
     *生成2数字之间的随机数,其实是[min,max],其实就是这个区间包括min,也包括max
     * */
    public static int randomDigit(int min,int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
    /**
     *生成0到100之间的随机数
     * */
    public static int random0_100(){
        Random random = new Random();
        int s = random.nextInt(100);
        return s;
    }

    /**
     *简化成下面这种
     * 180621202154373-767
     * 17到19位
     * */
    public static String sj(){
        return timeAndRandom0_999NoSymbolRemoveHead_();
    }
    /**
     *生成0到999之间的随机数
     * */
    public static int random0_999(){
        Random random = new Random();
        int s = random.nextInt(999);
        return s;
    }

    /**
     *大写英文字母随机
     * */

    public static String strARandom(){
        String str = "";
        for (int i = 0;i<1;i++){
            str = str+ (char)(Math.random()*26+'A');
        }
        return str;
    }

    /**
     *小写英文字母随机
     * */

    public static String straRandom(){
        String str = "";
        for (int i = 0;i<1;i++){
            str = str+ (char)(Math.random()*26+'a');
        }
        return str;
    }

    /**
     * 根据时间奇偶数决定26字母
     *大小写随机
     * */

    public static String aOrARandom(){
        long timeStamp = p.getTimeStamp();
        if(timeStamp%2==0){
            return straRandom();
        }
        return strARandom();
    }

//    public static void main(String[]args){
//        p.p(straRandom());
//    }

    /**
     * 带毫秒
     *带字母带时间的随机,非常随机 21位
     * 18b08I17z17L20v40J040
     * */
    public static String  ss(){
        String s="yy$MM+dd@HH!mm;ss#sss";
        return new SimpleDateFormat(s).format(new Date())
                .replace("$",aOrARandom())
                .replace("+",aOrARandom())
                .replace("@",aOrARandom())
                .replace("!",aOrARandom())
                .replace(";",aOrARandom())
                .replace("#",aOrARandom());
    }


    /**
     * 去掉毫秒
     *带字母带时间的随机,非常随机 17位
     * 18Q08c17g17x36w14
     * */
    public static String  s(){
        String s="yy$MM+dd@HH!mm;ss";
        return new SimpleDateFormat(s).format(new Date())
                .replace("$",aOrARandom())
                .replace("+",aOrARandom())
                .replace("@",aOrARandom())
                .replace("!",aOrARandom())
                .replace(";",aOrARandom());
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(random0_999AndTime());
//        p.p("-------------------------------------------------------");
//    }

//    public static void main(String[]args) throws InterruptedException {
//        while(true){
//            String s = timeStampRandom0999();
//            p.p("---------------------------"+s.length()+"----------------------------");
//            p.p(s);
//            p.p("-------------------------------------------------------");
////            Thread.sleep(2000);
//        }
//
//    }



    /**
     *时间戳+0到999之间随机码做id
     * 毫秒级时间戳13位+1到3位随机   共14到16位
     * 152318040010237
     * 这种
     * */
    public static String timeStampRandom0999(){
        return String.valueOf(p.getTimeStamp())+String.valueOf(p.random0_999());
    }

    /**
     * 毫秒级时间戳13位
     *时间戳+"-"+0到999之间随机码做id
     * 1523180466849-593
     * 这种
     * 13位时间戳+"-"+1到3位随机数共15到17位
     * */
    public static String timeStamp_Random0999(){
        return String.valueOf(p.getTimeStamp())+"-"+String.valueOf(p.random0_999());
    }

    /**
     *毫秒级时间+0到999之间的随机数
     * 180531223635864906
     * yyMMddHHmmssSSS+  1到3位随机码
     * 共16到18位
     * */

    public static String  suiji01(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.dtoStr(p.getDate(),"yyMMddHHmmssSSS")+p.strValeOf(s);
        return s101;
    }

    /**
     *秒级时间+0到999之间的随机数
     * 180531223913822
     * yyMMddHHmmss+  1到3位随机码
     * 共13到15位
     * */
    public static String  suiji02(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.dtoStr(p.getDate(),"yyMMddHHmmss")+p.strValeOf(s);
        return s101;
    }



    /**
     *
     *毫秒级时间+0到999之间的随机数
     * 2018-04-08 17:20:18.507 84
     * */
    public static String  timeAndRandom0_999(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.dtoStr(p.getDate(), d16)+" "+p.strValeOf(s);
        return s101;
    }
//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(timeAndRandom0_999NoHead());
//        p.p("-------------------------------------------------------");
//    }
    /**
     *
     * 这种
     *18-04-08 17:22:57.666 634
     * */
    public static String  timeAndRandom0_999NoHead(){

        return p.timeAndRandom0_999().substring(2);
    }

    /**
     * 推荐1给傻逼项目用,
     * 这种:  毫秒级时间+"-"+ 0到999的随机数
     *23位到 25位
     *
     *18-04-08 17:25:23.646 670
     *
     * */
    public static String  timeAndRandom0_999NoHead_(){

        return p.timeAndRandom0_999NoHead();
    }
//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(timeAndRandom0_999NoHead_1());
//        p.p("-------------------------------------------------------");
//    }

    /**
     * 推荐3给傻逼项目
     *下面这种23到25位是上面的变形版
     * ,主要是用于文件名的时候冒号不行的改进
     * 18-04-09 12_03_56_108 347
     * 这种
     * */
    public static String  timeAndRandom0_999NoHead_1(){
        return p.timeAndRandom0_999NoHead_().replace(":","_").replace(".","_");
    }

//
//    public static void main(String[]args){
//        p.p(timeAndRandom0_999NoHead_1());
//    }

    /**
     * 用于角色权限id的角色id
     * 推荐3给傻逼项目
     *下面这种30到32位是上面的变形版
     * ,主要是用于文件名的时候冒号不行的改进
     * roleId-18-04-15-12_56_37.487-392
     * 这种
     * */
    public static String  timeRoleId(){

        return "roleId"+"-"+p.timeAndRandom0_999NoHead_().replace(":","_");
    }


    /**
     * 用于角色权限id的用户id
     * 推荐3给傻逼项目
     *下面这种29到31位是上面的变形版
     * ,主要是用于文件名的时候冒号不行的改进
     * usrId-18-04-15-12_58_27.402-396
     * 这种
     * */
    public static String  timeUsrId(){

        return "usrId"+"-"+p.timeAndRandom0_999NoHead_().replace(":","_");
    }

    /**
     * 用于角色权限id的权限id
     * 推荐3给傻逼项目
     *下面这种28到30位是上面的变形版
     * ,主要是用于文件名的时候冒号不行的改进
     * qxId-18-04-15-13_00_15.477-365
     * 这种
     * */
    public static String  timeQxId(){

        return "qxId"+"-"+p.timeAndRandom0_999NoHead_().replace(":","_");
    }


//    public static void main(String[]args){
//
//        p.p("-------------------------------------------------------");
//        p.p(timeQxId());
//        p.p("-------------------------------------------------------");
//    }

    /**
     * 推荐
     *保险的id
     * 时间+八位随机数
     * 2018-04-09 11:37:35.982 11074079
     * 固定带2个空格是32位
     * 其中时间23位
     * */

    public static String timeAnd8Wei(){
        byte[] lock = new byte[0];
        // 位数，默认是8位
        long w = 100000000;
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        return p.dtoStr(p.getDate(),p.d16) +" "+ String.valueOf(r).substring(1);
    }
//    public static void main(String[]args){
//
//
//        p.p("-------------------------------------------------------");
//        p.p(timeAnd8Wei());
//        p.p("-------------------------------------------------------");
//
//
//    }

    /**
     *0到999之间的随机数 跟上生成的毫秒级时间
     * 24 2018-04-08 17:19:40.397
     * */
    public static String  random0_999AndTime(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.strValeOf(s)+" "+ p.dtoStr(p.getDate(), d16);
        return s101;
    }
    /**
     *毫秒级时间去掉符号+" "+随机码
     * Symbol是随机码的意思
     * 20180408165527961 737
     * 上面这种
     * */
    public static String  timeAndRandom0_999NoSymbol(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.dtoStr(p.getDate(), d16).replace(" ","")+" "+p.strValeOf(s);
        s101=s101.replace("-","");
        s101=s101.replace(":","");
        s101=s101.replace(".","");
        return s101;
    }
    /**
     *下面一个方法是为了解决String.valueOf(str)当str=null的情况的方法
     * */
    public static String strValeOf(Object o){
        if (null==o){
            return "null";
        }else {
            return String.valueOf(o);
        }
    }
    public static String strValeOfNull(Object o){
        if (null==o){
            return null;
        }else {
            return String.valueOf(o);
        }
    }

//    public static void main(String[]args){
//        p.p("-------------------------------------------------------");
//        p.p(timeAndRandom0_999NoSymbol());
//        p.p("-------------------------------------------------------");
//    }


    /**
     * 种17位到19位随机数
     *   180408170201088 878
     *   上面这种 15位+一位空格+  1到3位随机数
     * */
    public static String  timeAndRandom0_999NoSymbolRemoveHead(){
        return p.timeAndRandom0_999NoSymbol().substring(2);
    }
    /**
     * 推荐2给一般项目用
     * 这种17位到19位随机数
     *   180408171524866-547
     *   上面这种 15位+ - +  1到3位随机数
     * */
    public static String  timeAndRandom0_999NoSymbolRemoveHead_(){
        return p.timeAndRandom0_999NoSymbolRemoveHead().replace(" ","-");
    }

    /**
     *毫秒级时间去掉符号+" "+随机码
     * Symbol是随机码的意思
     * 20180408165748545179
     * 上面这种
     * */
    public static String  timeAndRandom0_999NoSymbolNoSpace(){
        Random random = new Random();
        int s = random.nextInt(999);
        String s101 = p.dtoStr(p.getDate(), d16).replace(" ","")+p.strValeOf(s);
        s101=s101.replace("-","");
        s101=s101.replace(":","");
        s101=s101.replace(".","");
        return s101;
    }





    /**
     * 16到18位
     *180408170814386251
     * 这种,时间去掉20这个头后+0到999之间的随机数
     * */
    public static String  timeAndRandom0_999NoSymbolNoSpaceRemoveHead(){

        return p.timeAndRandom0_999NoSymbolNoSpace().substring(2);
    }

    /**
     *封装三目运算符号
     * */
    public static Object threeEyeCalculate(boolean condition,Object trueIt,Object falseIt){

        return condition?trueIt:falseIt;

    }
    public static String threeEyeCalculate(boolean condition,String trueIt,String falseIt){

        return condition?trueIt:falseIt;

    }
    public static int threeEyeCalculate(boolean condition,int trueIt,int falseIt){

        return condition?trueIt:falseIt;

    }
    public static Integer  threeEyeCalculate(boolean condition,Integer trueIt,Integer falseIt){

        return condition?trueIt:falseIt;

    }
    public static Double  threeEyeCalculate(boolean condition,Double trueIt,Double falseIt){

        return condition?trueIt:falseIt;

    }
    public static double  threeEyeCalculate(boolean condition,double trueIt,double falseIt){

        return condition?trueIt:falseIt;

    }
    public static float  threeEyeCalculate(boolean condition,float trueIt,float falseIt){

        return condition?trueIt:falseIt;

    }
    public static Float  threeEyeCalculate(boolean condition,Float trueIt,Float falseIt){

        return condition?trueIt:falseIt;

    }
    public static BigDecimal  threeEyeCalculate(boolean condition,BigDecimal trueIt,BigDecimal falseIt){

        return condition?trueIt:falseIt;

    }
    public static Long  threeEyeCalculate(boolean condition,Long trueIt,Long falseIt){

        return condition?trueIt:falseIt;

    }
    public static long  threeEyeCalculate(boolean condition,long trueIt,long falseIt){

        return condition?trueIt:falseIt;

    }
    public static short  threeEyeCalculate(boolean condition,short trueIt,short falseIt){

        return condition?trueIt:falseIt;

    }
    public static Short  threeEyeCalculate(boolean condition,Short trueIt,Short falseIt){

        return condition?trueIt:falseIt;

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Connection getCon(String ip, String port
            , String dbType, String dbName, String usr, String pwd)
            throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "";
        String driver="";
        if("sqlserver".equals(dbType)){
            url="jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+dbName;
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }else if("mysql".equals(dbType)){
            url="jdbc:mysql://"+ip+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
            driver="com.mysql.jdbc.Driver";
        }
//        //mydb为数据库
//        String user = "sa";
//        String password = "root";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, usr, pwd);
        if (p.empty(conn)) {
            return null;
        } else {
            return conn;
        }
    }

    public static void conClose(Connection c) throws SQLException {
        if (p.notEmpty(c)) {
            c.close();
        } else {

        }

    }

    public static void resultSetClose(ResultSet c) throws SQLException {
        if (p.notEmpty(c)) {
            c.close();
        } else {

        }

    }

    public static void preparedStatementClose(PreparedStatement c) throws SQLException {
        if (p.notEmpty(c)) {
            c.close();
        } else {

        }

    }


    public static void closeAll(Connection c,PreparedStatement p1, ResultSet r) {
        try {
            p.preparedStatementClose(p1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            p.resultSetClose(r);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            p.conClose(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




/**
 *去掉文件名中 字符串中 的路径特殊符号
 * 比如
 * #   影响访问路径
 * ?   影响 路径跟参数
 * &   路径分隔符
 * =   路径参数等号符号
 * * */

    /**
     * 这里参数str指的是文件名
     *这个是路径中绝对不能有的符号去除
     * */
    public  static String delNotPath(String fileName){
        if(null==fileName){
            return fileName;
        }else{
            return fileName.replace("#","_jh_")
                    .replace("?","_wh_")
                    .replace("&","_bq_")
                    .replace("=","_dy_");
        }
    }

    /**
     * 这里参数str指的是文件名
     *加强到sqlServer不能模糊查询要去掉  [   和   ]
     *
     * */

    public  static String delNotPathNotSql(String fileName){
        if(null==fileName){
            return fileName;
        }else{
            return fileName.replace("#","_jh_")
                    .replace("?","_wh_")
                    .replace("&","_bq_")
                    .replace("=","_dy_")
                    .replace("[","_zzkh_")
                    .replace("]","_yzkh_");
        }
    }


    /**
     * 这里参数str指的是文件名
     *加强到sqlServer不能模糊查询要去掉  [   和   ]
     *并且加强到我常用的  !  做分隔符号要去掉
     * !  一般做路径和唯一id分隔
     * ;  一般做2个路径之间的分隔
     * */

    public  static String delNotPathNotSqlNotSplit(String fileName){
        if(null==fileName){
            return fileName;
        }else{
            return fileName.replace("#","_jh_")
                    .replace("?","_wh_")
                    .replace("&","_bq_")
                    .replace("=","_dy_")
                    .replace("[","_zzkh_")
                    .replace("]","_yzkh_")
                    .replace("!","_gth_")
                    .replace(";","_fh_");
        }
    }



    /**
     *封装三目运算符号
     * */
    public static Object sm(boolean condition,Object trueIt,Object falseIt){

        return condition?trueIt:falseIt;

    }
    public static String sm(boolean condition,String trueIt,String falseIt){

        return condition?trueIt:falseIt;

    }
    public static int sm(boolean condition,int trueIt,int falseIt){

        return condition?trueIt:falseIt;

    }
    public static Integer  sm(boolean condition,Integer trueIt,Integer falseIt){

        return condition?trueIt:falseIt;

    }
    public static Double  sm(boolean condition,Double trueIt,Double falseIt){

        return condition?trueIt:falseIt;

    }
    public static double  sm(boolean condition,double trueIt,double falseIt){

        return condition?trueIt:falseIt;

    }
    public static float  sm(boolean condition,float trueIt,float falseIt){

        return condition?trueIt:falseIt;

    }
    public static Float  sm(boolean condition,Float trueIt,Float falseIt){

        return condition?trueIt:falseIt;

    }
    public static BigDecimal  sm(boolean condition,BigDecimal trueIt,BigDecimal falseIt){

        return condition?trueIt:falseIt;

    }
    public static Long  sm(boolean condition,Long trueIt,Long falseIt){

        return condition?trueIt:falseIt;

    }
    public static long  sm(boolean condition,long trueIt,long falseIt){

        return condition?trueIt:falseIt;

    }
    public static short  sm(boolean condition,short trueIt,short falseIt){

        return condition?trueIt:falseIt;

    }
    public static Short  sm(boolean condition,Short trueIt,Short falseIt){

        return condition?trueIt:falseIt;

    }
//    public static void main(String[]args){
//        String s=p.readAllTxt("E:\\1\\work_space\\LinZhan_Picture_ReportTable\\src\\main\\java\\com\\winwin\\picreport\\Bcontroller\\loginRegistModul\\auth\\权限的json.json");
//
//        p(replaceBlank(s));
//    }


    //去掉字符串数字末尾的0
//    public static void main(String[]args){
//            p(new BigDecimal("0.10000"));
//    }







//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	int	n0	=	0	;
    public	final	static	int	n1	=	1	;
    public	final	static	int	n2	=	2	;
    public	final	static	int	n3	=	3	;
    public	final	static	int	n4	=	4	;
    public	final	static	int	n5	=	5	;
    public	final	static	int	n6	=	6	;
    public	final	static	int	n7	=	7	;
    public	final	static	int	n8	=	8	;
    public	final	static	int	n9	=	9	;
    public	final	static	int	n10	=	10	;
    public	final	static	int	n11	=	11	;
    public	final	static	int	n12	=	12	;
    public	final	static	int	n13	=	13	;
    public	final	static	int	n14	=	14	;
    public	final	static	int	n15	=	15	;
    public	final	static	int	n16	=	16	;
    public	final	static	int	n17	=	17	;
    public	final	static	int	n18	=	18	;
    public	final	static	int	n19	=	19	;
    public	final	static	int	n20	=	20	;
    public	final	static	int	n21	=	21	;
    public	final	static	int	n22	=	22	;
    public	final	static	int	n23	=	23	;
    public	final	static	int	n24	=	24	;
    public	final	static	int	n25	=	25	;
    public	final	static	int	n26	=	26	;
    public	final	static	int	n27	=	27	;
    public	final	static	int	n28	=	28	;
    public	final	static	int	n29	=	29	;
    public	final	static	int	n30	=	30	;
    public	final	static	int	n31	=	31	;
    public	final	static	int	n32	=	32	;
    public	final	static	int	n33	=	33	;
    public	final	static	int	n34	=	34	;
    public	final	static	int	n35	=	35	;
    public	final	static	int	n36	=	36	;
    public	final	static	int	n37	=	37	;
    public	final	static	int	n38	=	38	;
    public	final	static	int	n39	=	39	;
    public	final	static	int	n40	=	40	;
    public	final	static	int	n41	=	41	;
    public	final	static	int	n42	=	42	;
    public	final	static	int	n43	=	43	;
    public	final	static	int	n44	=	44	;
    public	final	static	int	n45	=	45	;
    public	final	static	int	n46	=	46	;
    public	final	static	int	n47	=	47	;
    public	final	static	int	n48	=	48	;
    public	final	static	int	n49	=	49	;
    public	final	static	int	n50	=	50	;
    public	final	static	int	n51	=	51	;
    public	final	static	int	n52	=	52	;
    public	final	static	int	n53	=	53	;
    public	final	static	int	n54	=	54	;
    public	final	static	int	n55	=	55	;
    public	final	static	int	n56	=	56	;
    public	final	static	int	n57	=	57	;
    public	final	static	int	n58	=	58	;
    public	final	static	int	n59	=	59	;
    public	final	static	int	n60	=	60	;
    public	final	static	int	n61	=	61	;
    public	final	static	int	n62	=	62	;
    public	final	static	int	n63	=	63	;
    public	final	static	int	n64	=	64	;
    public	final	static	int	n65	=	65	;
    public	final	static	int	n66	=	66	;
    public	final	static	int	n67	=	67	;
    public	final	static	int	n68	=	68	;
    public	final	static	int	n69	=	69	;
    public	final	static	int	n70	=	70	;
    public	final	static	int	n71	=	71	;
    public	final	static	int	n72	=	72	;
    public	final	static	int	n73	=	73	;
    public	final	static	int	n74	=	74	;
    public	final	static	int	n75	=	75	;
    public	final	static	int	n76	=	76	;
    public	final	static	int	n77	=	77	;
    public	final	static	int	n78	=	78	;
    public	final	static	int	n79	=	79	;
    public	final	static	int	n80	=	80	;
    public	final	static	int	n81	=	81	;
    public	final	static	int	n82	=	82	;
    public	final	static	int	n83	=	83	;
    public	final	static	int	n84	=	84	;
    public	final	static	int	n85	=	85	;
    public	final	static	int	n86	=	86	;
    public	final	static	int	n87	=	87	;
    public	final	static	int	n88	=	88	;
    public	final	static	int	n89	=	89	;
    public	final	static	int	n90	=	90	;
    public	final	static	int	n91	=	91	;
    public	final	static	int	n92	=	92	;
    public	final	static	int	n93	=	93	;
    public	final	static	int	n94	=	94	;
    public	final	static	int	n95	=	95	;
    public	final	static	int	n96	=	96	;
    public	final	static	int	n97	=	97	;
    public	final	static	int	n98	=	98	;
    public	final	static	int	n99	=	99	;
    public	final	static	int	n100	=	100	;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public	final	static	String	s0	=	"0"	;
    public	final	static	String	s1	=	"1"	;
    public	final	static	String	s2	=	"2"	;
    public	final	static	String	s3	=	"3"	;
    public	final	static	String	s4	=	"4"	;
    public	final	static	String	s5	=	"5"	;
    public	final	static	String	s6	=	"6"	;
    public	final	static	String	s7	=	"7"	;
    public	final	static	String	s8	=	"8"	;
    public	final	static	String	s9	=	"9"	;
    public	final	static	String	s10	=	"10"	;
    public	final	static	String	s11	=	"11"	;
    public	final	static	String	s12	=	"12"	;
    public	final	static	String	s13	=	"13"	;
    public	final	static	String	s14	=	"14"	;
    public	final	static	String	s15	=	"15"	;
    public	final	static	String	s16	=	"16"	;
    public	final	static	String	s17	=	"17"	;
    public	final	static	String	s18	=	"18"	;
    public	final	static	String	s19	=	"19"	;
    public	final	static	String	s20	=	"20"	;
    public	final	static	String	s21	=	"21"	;
    public	final	static	String	s22	=	"22"	;
    public	final	static	String	s23	=	"23"	;
    public	final	static	String	s24	=	"24"	;
    public	final	static	String	s25	=	"25"	;
    public	final	static	String	s26	=	"26"	;
    public	final	static	String	s27	=	"27"	;
    public	final	static	String	s28	=	"28"	;
    public	final	static	String	s29	=	"29"	;
    public	final	static	String	s30	=	"30"	;
    public	final	static	String	s31	=	"31"	;
    public	final	static	String	s32	=	"32"	;
    public	final	static	String	s33	=	"33"	;
    public	final	static	String	s34	=	"34"	;
    public	final	static	String	s35	=	"35"	;
    public	final	static	String	s36	=	"36"	;
    public	final	static	String	s37	=	"37"	;
    public	final	static	String	s38	=	"38"	;
    public	final	static	String	s39	=	"39"	;
    public	final	static	String	s40	=	"40"	;
    public	final	static	String	s41	=	"41"	;
    public	final	static	String	s42	=	"42"	;
    public	final	static	String	s43	=	"43"	;
    public	final	static	String	s44	=	"44"	;
    public	final	static	String	s45	=	"45"	;
    public	final	static	String	s46	=	"46"	;
    public	final	static	String	s47	=	"47"	;
    public	final	static	String	s48	=	"48"	;
    public	final	static	String	s49	=	"49"	;
    public	final	static	String	s50	=	"50"	;
    public	final	static	String	s51	=	"51"	;
    public	final	static	String	s52	=	"52"	;
    public	final	static	String	s53	=	"53"	;
    public	final	static	String	s54	=	"54"	;
    public	final	static	String	s55	=	"55"	;
    public	final	static	String	s56	=	"56"	;
    public	final	static	String	s57	=	"57"	;
    public	final	static	String	s58	=	"58"	;
    public	final	static	String	s59	=	"59"	;
    public	final	static	String	s60	=	"60"	;
    public	final	static	String	s61	=	"61"	;
    public	final	static	String	s62	=	"62"	;
    public	final	static	String	s63	=	"63"	;
    public	final	static	String	s64	=	"64"	;
    public	final	static	String	s65	=	"65"	;
    public	final	static	String	s66	=	"66"	;
    public	final	static	String	s67	=	"67"	;
    public	final	static	String	s68	=	"68"	;
    public	final	static	String	s69	=	"69"	;
    public	final	static	String	s70	=	"70"	;
    public	final	static	String	s71	=	"71"	;
    public	final	static	String	s72	=	"72"	;
    public	final	static	String	s73	=	"73"	;
    public	final	static	String	s74	=	"74"	;
    public	final	static	String	s75	=	"75"	;
    public	final	static	String	s76	=	"76"	;
    public	final	static	String	s77	=	"77"	;
    public	final	static	String	s78	=	"78"	;
    public	final	static	String	s79	=	"79"	;
    public	final	static	String	s80	=	"80"	;
    public	final	static	String	s81	=	"81"	;
    public	final	static	String	s82	=	"82"	;
    public	final	static	String	s83	=	"83"	;
    public	final	static	String	s84	=	"84"	;
    public	final	static	String	s85	=	"85"	;
    public	final	static	String	s86	=	"86"	;
    public	final	static	String	s87	=	"87"	;
    public	final	static	String	s88	=	"88"	;
    public	final	static	String	s89	=	"89"	;
    public	final	static	String	s90	=	"90"	;
    public	final	static	String	s91	=	"91"	;
    public	final	static	String	s92	=	"92"	;
    public	final	static	String	s93	=	"93"	;
    public	final	static	String	s94	=	"94"	;
    public	final	static	String	s95	=	"95"	;
    public	final	static	String	s96	=	"96"	;
    public	final	static	String	s97	=	"97"	;
    public	final	static	String	s98	=	"98"	;
    public	final	static	String	s99	=	"99"	;
    public	final	static	String	s100	=	"100"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	int	n_100	=	-100	;
    public	final	static	int	n_99	=	-99	;
    public	final	static	int	n_98	=	-98	;
    public	final	static	int	n_97	=	-97	;
    public	final	static	int	n_96	=	-96	;
    public	final	static	int	n_95	=	-95	;
    public	final	static	int	n_94	=	-94	;
    public	final	static	int	n_93	=	-93	;
    public	final	static	int	n_92	=	-92	;
    public	final	static	int	n_91	=	-91	;
    public	final	static	int	n_90	=	-90	;
    public	final	static	int	n_89	=	-89	;
    public	final	static	int	n_88	=	-88	;
    public	final	static	int	n_87	=	-87	;
    public	final	static	int	n_86	=	-86	;
    public	final	static	int	n_85	=	-85	;
    public	final	static	int	n_84	=	-84	;
    public	final	static	int	n_83	=	-83	;
    public	final	static	int	n_82	=	-82	;
    public	final	static	int	n_81	=	-81	;
    public	final	static	int	n_80	=	-80	;
    public	final	static	int	n_79	=	-79	;
    public	final	static	int	n_78	=	-78	;
    public	final	static	int	n_77	=	-77	;
    public	final	static	int	n_76	=	-76	;
    public	final	static	int	n_75	=	-75	;
    public	final	static	int	n_74	=	-74	;
    public	final	static	int	n_73	=	-73	;
    public	final	static	int	n_72	=	-72	;
    public	final	static	int	n_71	=	-71	;
    public	final	static	int	n_70	=	-70	;
    public	final	static	int	n_69	=	-69	;
    public	final	static	int	n_68	=	-68	;
    public	final	static	int	n_67	=	-67	;
    public	final	static	int	n_66	=	-66	;
    public	final	static	int	n_65	=	-65	;
    public	final	static	int	n_64	=	-64	;
    public	final	static	int	n_63	=	-63	;
    public	final	static	int	n_62	=	-62	;
    public	final	static	int	n_61	=	-61	;
    public	final	static	int	n_60	=	-60	;
    public	final	static	int	n_59	=	-59	;
    public	final	static	int	n_58	=	-58	;
    public	final	static	int	n_57	=	-57	;
    public	final	static	int	n_56	=	-56	;
    public	final	static	int	n_55	=	-55	;
    public	final	static	int	n_54	=	-54	;
    public	final	static	int	n_53	=	-53	;
    public	final	static	int	n_52	=	-52	;
    public	final	static	int	n_51	=	-51	;
    public	final	static	int	n_50	=	-50	;
    public	final	static	int	n_49	=	-49	;
    public	final	static	int	n_48	=	-48	;
    public	final	static	int	n_47	=	-47	;
    public	final	static	int	n_46	=	-46	;
    public	final	static	int	n_45	=	-45	;
    public	final	static	int	n_44	=	-44	;
    public	final	static	int	n_43	=	-43	;
    public	final	static	int	n_42	=	-42	;
    public	final	static	int	n_41	=	-41	;
    public	final	static	int	n_40	=	-40	;
    public	final	static	int	n_39	=	-39	;
    public	final	static	int	n_38	=	-38	;
    public	final	static	int	n_37	=	-37	;
    public	final	static	int	n_36	=	-36	;
    public	final	static	int	n_35	=	-35	;
    public	final	static	int	n_34	=	-34	;
    public	final	static	int	n_33	=	-33	;
    public	final	static	int	n_32	=	-32	;
    public	final	static	int	n_31	=	-31	;
    public	final	static	int	n_30	=	-30	;
    public	final	static	int	n_29	=	-29	;
    public	final	static	int	n_28	=	-28	;
    public	final	static	int	n_27	=	-27	;
    public	final	static	int	n_26	=	-26	;
    public	final	static	int	n_25	=	-25	;
    public	final	static	int	n_24	=	-24	;
    public	final	static	int	n_23	=	-23	;
    public	final	static	int	n_22	=	-22	;
    public	final	static	int	n_21	=	-21	;
    public	final	static	int	n_20	=	-20	;
    public	final	static	int	n_19	=	-19	;
    public	final	static	int	n_18	=	-18	;
    public	final	static	int	n_17	=	-17	;
    public	final	static	int	n_16	=	-16	;
    public	final	static	int	n_15	=	-15	;
    public	final	static	int	n_14	=	-14	;
    public	final	static	int	n_13	=	-13	;
    public	final	static	int	n_12	=	-12	;
    public	final	static	int	n_11	=	-11	;
    public	final	static	int	n_10	=	-10	;
    public	final	static	int	n_9	=	-9	;
    public	final	static	int	n_8	=	-8	;
    public	final	static	int	n_7	=	-7	;
    public	final	static	int	n_6	=	-6	;
    public	final	static	int	n_5	=	-5	;
    public	final	static	int	n_4	=	-4	;
    public	final	static	int	n_3	=	-3	;
    public	final	static	int	n_2	=	-2	;
    public	final	static	int	n_1	=	-1	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public	final	static	String	s_100	=	"-100"	;
    public	final	static	String	s_99	=	"-99"	;
    public	final	static	String	s_98	=	"-98"	;
    public	final	static	String	s_97	=	"-97"	;
    public	final	static	String	s_96	=	"-96"	;
    public	final	static	String	s_95	=	"-95"	;
    public	final	static	String	s_94	=	"-94"	;
    public	final	static	String	s_93	=	"-93"	;
    public	final	static	String	s_92	=	"-92"	;
    public	final	static	String	s_91	=	"-91"	;
    public	final	static	String	s_90	=	"-90"	;
    public	final	static	String	s_89	=	"-89"	;
    public	final	static	String	s_88	=	"-88"	;
    public	final	static	String	s_87	=	"-87"	;
    public	final	static	String	s_86	=	"-86"	;
    public	final	static	String	s_85	=	"-85"	;
    public	final	static	String	s_84	=	"-84"	;
    public	final	static	String	s_83	=	"-83"	;
    public	final	static	String	s_82	=	"-82"	;
    public	final	static	String	s_81	=	"-81"	;
    public	final	static	String	s_80	=	"-80"	;
    public	final	static	String	s_79	=	"-79"	;
    public	final	static	String	s_78	=	"-78"	;
    public	final	static	String	s_77	=	"-77"	;
    public	final	static	String	s_76	=	"-76"	;
    public	final	static	String	s_75	=	"-75"	;
    public	final	static	String	s_74	=	"-74"	;
    public	final	static	String	s_73	=	"-73"	;
    public	final	static	String	s_72	=	"-72"	;
    public	final	static	String	s_71	=	"-71"	;
    public	final	static	String	s_70	=	"-70"	;
    public	final	static	String	s_69	=	"-69"	;
    public	final	static	String	s_68	=	"-68"	;
    public	final	static	String	s_67	=	"-67"	;
    public	final	static	String	s_66	=	"-66"	;
    public	final	static	String	s_65	=	"-65"	;
    public	final	static	String	s_64	=	"-64"	;
    public	final	static	String	s_63	=	"-63"	;
    public	final	static	String	s_62	=	"-62"	;
    public	final	static	String	s_61	=	"-61"	;
    public	final	static	String	s_60	=	"-60"	;
    public	final	static	String	s_59	=	"-59"	;
    public	final	static	String	s_58	=	"-58"	;
    public	final	static	String	s_57	=	"-57"	;
    public	final	static	String	s_56	=	"-56"	;
    public	final	static	String	s_55	=	"-55"	;
    public	final	static	String	s_54	=	"-54"	;
    public	final	static	String	s_53	=	"-53"	;
    public	final	static	String	s_52	=	"-52"	;
    public	final	static	String	s_51	=	"-51"	;
    public	final	static	String	s_50	=	"-50"	;
    public	final	static	String	s_49	=	"-49"	;
    public	final	static	String	s_48	=	"-48"	;
    public	final	static	String	s_47	=	"-47"	;
    public	final	static	String	s_46	=	"-46"	;
    public	final	static	String	s_45	=	"-45"	;
    public	final	static	String	s_44	=	"-44"	;
    public	final	static	String	s_43	=	"-43"	;
    public	final	static	String	s_42	=	"-42"	;
    public	final	static	String	s_41	=	"-41"	;
    public	final	static	String	s_40	=	"-40"	;
    public	final	static	String	s_39	=	"-39"	;
    public	final	static	String	s_38	=	"-38"	;
    public	final	static	String	s_37	=	"-37"	;
    public	final	static	String	s_36	=	"-36"	;
    public	final	static	String	s_35	=	"-35"	;
    public	final	static	String	s_34	=	"-34"	;
    public	final	static	String	s_33	=	"-33"	;
    public	final	static	String	s_32	=	"-32"	;
    public	final	static	String	s_31	=	"-31"	;
    public	final	static	String	s_30	=	"-30"	;
    public	final	static	String	s_29	=	"-29"	;
    public	final	static	String	s_28	=	"-28"	;
    public	final	static	String	s_27	=	"-27"	;
    public	final	static	String	s_26	=	"-26"	;
    public	final	static	String	s_25	=	"-25"	;
    public	final	static	String	s_24	=	"-24"	;
    public	final	static	String	s_23	=	"-23"	;
    public	final	static	String	s_22	=	"-22"	;
    public	final	static	String	s_21	=	"-21"	;
    public	final	static	String	s_20	=	"-20"	;
    public	final	static	String	s_19	=	"-19"	;
    public	final	static	String	s_18	=	"-18"	;
    public	final	static	String	s_17	=	"-17"	;
    public	final	static	String	s_16	=	"-16"	;
    public	final	static	String	s_15	=	"-15"	;
    public	final	static	String	s_14	=	"-14"	;
    public	final	static	String	s_13	=	"-13"	;
    public	final	static	String	s_12	=	"-12"	;
    public	final	static	String	s_11	=	"-11"	;
    public	final	static	String	s_10	=	"-10"	;
    public	final	static	String	s_9	=	"-9"	;
    public	final	static	String	s_8	=	"-8"	;
    public	final	static	String	s_7	=	"-7"	;
    public	final	static	String	s_6	=	"-6"	;
    public	final	static	String	s_5	=	"-5"	;
    public	final	static	String	s_4	=	"-4"	;
    public	final	static	String	s_3	=	"-3"	;
    public	final	static	String	s_2	=	"-2"	;
    public	final	static	String	s_1	=	"-1"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	String	stra	=	"a"	;
    public	final	static	String	strb	=	"b"	;
    public	final	static	String	strc	=	"c"	;
    public	final	static	String	strd	=	"d"	;
    public	final	static	String	stre	=	"e"	;
    public	final	static	String	strf	=	"f"	;
    public	final	static	String	strg	=	"g"	;
    public	final	static	String	strh	=	"h"	;
    public	final	static	String	stri	=	"i"	;
    public	final	static	String	strj	=	"j"	;
    public	final	static	String	strk	=	"k"	;
    public	final	static	String	strl	=	"l"	;
    public	final	static	String	strm	=	"m"	;
    public	final	static	String	strn	=	"n"	;
    public	final	static	String	stro	=	"o"	;
    public	final	static	String	strp	=	"p"	;
    public	final	static	String	strq	=	"q"	;
    public	final	static	String	strr	=	"r"	;
    public	final	static	String	strs	=	"s"	;
    public	final	static	String	strt	=	"t"	;
    public	final	static	String	stru	=	"u"	;
    public	final	static	String	strv	=	"v"	;
    public	final	static	String	strw	=	"w"	;
    public	final	static	String	strx	=	"x"	;
    public	final	static	String	stry	=	"y"	;
    public	final	static	String	strz	=	"z"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public	final	static	String	strA	=	"A"	;
    public	final	static	String	strB	=	"B"	;
    public	final	static	String	strC	=	"C"	;
    public	final	static	String	strD	=	"D"	;
    public	final	static	String	strE	=	"E"	;
    public	final	static	String	strF	=	"F"	;
    public	final	static	String	strG	=	"G"	;
    public	final	static	String	strH	=	"H"	;
    public	final	static	String	strI	=	"I"	;
    public	final	static	String	strJ	=	"J"	;
    public	final	static	String	strK	=	"K"	;
    public	final	static	String	strL	=	"L"	;
    public	final	static	String	strM	=	"M"	;
    public	final	static	String	strN	=	"N"	;
    public	final	static	String	strO	=	"O"	;
    public	final	static	String	strP	=	"P"	;
    public	final	static	String	strQ	=	"Q"	;
    public	final	static	String	strR	=	"R"	;
    public	final	static	String	strS	=	"S"	;
    public	final	static	String	strT	=	"T"	;
    public	final	static	String	strU	=	"U"	;
    public	final	static	String	strV	=	"V"	;
    public	final	static	String	strW	=	"W"	;
    public	final	static	String	strX	=	"X"	;
    public	final	static	String	strY	=	"Y"	;
    public	final	static	String	strZ	=	"Z"	;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//实验类
 class usr{
    private String name;
    private int age;
    private BigDecimal money;


    public BigDecimal getMoney() {
        return money;
    }

    public usr setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public String getName() {
        return name;
    }

    public usr setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public usr setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("usr{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }
}

/**
 ****************************************************************************************
 * */
class Usr {
    private String name;
    private int age;
    private BigDecimal money;
    private String bir;

    //排序用
    public int Age1(){
        return this.age+1;
    }

    public String getBir() {
        return bir;
    }

    public Usr setBir(String bir) {
        this.bir = bir;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Usr setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public String getName() {
        return name;
    }

    public Usr setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public  Usr setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", money=").append(money);
        sb.append(", bir='").append(bir).append('\'');
        sb.append('}');
        return sb.toString();
    }


}