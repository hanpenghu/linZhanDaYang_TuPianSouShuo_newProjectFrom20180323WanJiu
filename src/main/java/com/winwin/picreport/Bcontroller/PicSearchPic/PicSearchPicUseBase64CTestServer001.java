package com.winwin.picreport.Bcontroller.PicSearchPic;

import cn.productai.api.example.TestExample;
import cn.productai.api.pai.entity.search.ImageSearchResponse;
import cn.productai.api.pai.response.SearchResult;
import com.winwin.picreport.Bcontroller.PicSearchPic.dto.SimplePrdtSamp;
import com.winwin.picreport.Bcontroller.PicSearchPic.utils.Cnst;
import com.winwin.picreport.Bcontroller.PicSearchPic.utils.Cnst001;
import com.winwin.picreport.Edto.Base64Image;
import com.winwin.picreport.Futils.ImageAndBase64;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//import org.apache.commons.lang.StringUtils;

@CrossOrigin
@RestController
@RequestMapping("/b2")
public class PicSearchPicUseBase64CTestServer001 {
    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
    @Autowired
    private com.winwin.picreport.AllConstant.Cnst  cnst;
//    @Value("${tupianserviceId}")
    private String  tupianserviceId= Cnst001.serviceIdOfWinWinPrdtSamp;
    @Value("${tupianFanHuiCount}")
    private int tupianFanHuiCount;

    @Value("${filePath}")//./1234567/
    private String filePath;

    @Value("${dirUrl}")
    private String dirUrl;
    @Value("${suoLueTuWenJianJia}")//   suoLueTuAndFuJian/
    private String suoLueTuWenJianJia;
////////////////////////////////////////////////consumes是请求类型,/////produces是返回类型//////////////////////////

    /**
     *接受前端传过来的一张图片传给码隆,然后返回给前端所有相似的图片的信息,参数是Base64字符串
     * 这个后来应该不用了
     * */

//    @RequestMapping(value="jieShouQianduanChuanGuoLaiDeYiZhangTuPian",method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SearchResult> jieShouQianduanChuanGuoLaiDeYiZhangTuPian
    (@RequestBody Base64Image base64Image){
        //将来用来装入 码隆的图片url信息和我们数据库的到的商品名和商品码
        List<SearchResult> searchPicResultList=new ArrayList<>();
        if (p.empty(base64Image)){return searchPicResultList;}
        try {
            A临时url和file a临时url和file = this.f得到给码隆下载的临时图片url以及文件(base64Image);
            SearchResult[] maLongResult = this.getMaLongResult(a临时url和file);
            Long timeStamp1 = p.getTimeStamp();
            //主要结果都在返回的Results对象中,其他地方没有
            for(SearchResult searchResult: maLongResult){
                String infoWillUseInDbSelect = this.getInfoWillUseInDbSelect(searchResult);
                //通过得到的相似图片的url中的包含信息,去找到对应的数据库中的 货号和品名 放入SimplePrdtSamp对象,虽然是list,其实一般只有一个
              if(p.notEmpty(infoWillUseInDbSelect)){
                  List<SimplePrdtSamp>simplePrdtSampList=cnst.a001TongYongMapper.getSimplePrdtSamps("%"+infoWillUseInDbSelect+"%");
                  if(p.empty(simplePrdtSampList)){
                      SimplePrdtSamp simplePrdtSamp = new SimplePrdtSamp();
                      //-------------------下面是后来加的给老郑给客户演示的-------------------------------
                      //2018_8_12   weekday(0)   16:05:12 add
                      simplePrdtSamp.setPrdtCode(infoWillUseInDbSelect);
                      simplePrdtSamp.setPrdtName(infoWillUseInDbSelect);
                      //---------------上面是后来加的给老郑给客户演示的-----------------------------------

                      simplePrdtSampList.add(simplePrdtSamp);

                  }
                  searchResult.setSimplePrdtSamp(simplePrdtSampList);
              }
                searchPicResultList.add(searchResult);
            }
            Long timeStamp2 = p.getTimeStamp();
            p.p("-----------从数据库返回10条 数据信息需要时间--------------------------------------------");
            p.p((timeStamp2-timeStamp1)/1000);
            p.p("---------------------------秒----------------------------");
            //删除指定目录的图片(用完就删掉)
            FileUtils.forceDelete(a临时url和file.getFile());
        } catch (Exception e) {e.printStackTrace(); }
        return searchPicResultList;
    }







    public A临时url和file  f得到给码隆下载的临时图片url以及文件(Base64Image base64Image){
        String uuidFileName= UUID.randomUUID().toString().replace("-","");
        //创造给码隆临时搜索的林展服务器图片的url   http://61.177.44.218:8070/111.jpg
        String fileUrlForMaLongDownLoad=dirUrl+uuidFileName+".jpeg";
        //E:\CloudPlatformBackstage\winwin\.\1234567\WW-VSUP5950-778.jpg
        File dest = new File(filePath, uuidFileName+".jpeg");
        //上传到指定目录,为码隆下载找相似做准备
        ImageAndBase64.GenerateImage(base64Image.getBase64str(),dest);
        A临时url和file a临时url和file=new A临时url和file();
        a临时url和file.setUrl(fileUrlForMaLongDownLoad);
        a临时url和file.setFile(dest);
        return a临时url和file;
    }







    //得到码隆返回的结果集
    public  SearchResult[] getMaLongResult(A临时url和file a临时url和file){
        //连接码隆//得到结果
        ImageSearchResponse imageSearchResponse =
                new TestExample().fullFlowExample
                        (a临时url和file.getUrl(), tupianserviceId, tupianFanHuiCount);

        //得到返回的结果集
        SearchResult[] results = imageSearchResponse.getResults();
        p.p("------------------------相似度-------------------------------");
        for(SearchResult s:results){
            p.p(s.getScore());
        }
        p.p("-------------------------------------------------------");
        return results;
    }





    //通过码隆的某个结果集中的url,  剪切出要去数据库拿到商品名和商品码的信息
    public String getInfoWillUseInDbSelect(SearchResult searchResult){
        //添加简单的prdtSamp打样字段
        String url = searchResult.getUrl();
        String urlAfter="我日";
        try {
            urlAfter=url.substring(url.indexOf(suoLueTuWenJianJia));
        } catch (Exception e) {}
        return urlAfter;
    }








    class A临时url和file{
        private String  url;
        private File file;

        public String getUrl() {
            return url;
        }

        public A临时url和file setUrl(String url) {
            this.url = url;
            return this;
        }

        public File getFile() {
            return file;
        }

        public A临时url和file setFile(File file) {
            this.file = file;
            return this;
        }
    }
}
////////////////////////////////////////////////////////////////////////////////



//返回结果


/*

[
        {
            "simplePrdtSamp":
            [
                {
                    "prdtName": "金属件",
                    "prdtCode": "WW-NEMT-1170"
                }
            ],
            "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150204102127WW-NEMT-1170.jpg",
            "score": 1,
            "metadata": null
        },




        {
            "simplePrdtSamp":
            [
                {
                    "prdtName": "",
                    "prdtCode": ""
                }
            ],
            "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150414103450WW-NEEL-WW2190.JPG",
            "score": 0.7015969157218933,
            "metadata": null
        },



        {
        "simplePrdtSamp": [
        {
        "prdtName": "绣花标",
        "prdtCode": "WW-NEEL-WW2298"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/201504271359173.jpg",
        "score": 0.7015726566314697,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "绣花标",
        "prdtCode": "WW-NEEL-WW2213"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150408143125WW-NEEL-WW2213.png",
        "score": 0.6941250562667847,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "绣花标",
        "prdtCode": "WW-NEEL-WW2206"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150408142207WW-NEEL-WW2206.png",
        "score": 0.6922326385974884,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "对折织标",
        "prdtCode": "WW-NE-A2067"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150415132329WW-NE-A2067.jpg",
        "score": 0.6910213530063629,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "对折织标",
        "prdtCode": "WW-NE-A1947"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150325074546A1947.jpg",
        "score": 0.6894269287586212,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "转印标",
        "prdtCode": "WW-NE-HSL0730"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150305111950WW-NE-HSL0730 layout.jpg",
        "score": 0.6871278584003448,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "",
        "prdtCode": ""
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150427170003WW-NEFL-F0557.jpg",
        "score": 0.6867406070232391,
        "metadata": null
        },
        {
        "simplePrdtSamp": [
        {
        "prdtName": "绣花标",
        "prdtCode": "WW-NEEL-WW2202"
        }
        ],
        "url": "http://61.177.44.218:8070/suoLueTuAndFuJian/20150408141538WW-NEEL-WW2202.png",
        "score": 0.6864574551582336,
        "metadata": null
        }
        ]*/
