package com.winwin.picreport.Bcontroller.PicSearchPic.utils;

import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import cn.productai.api.core.exceptions.ClientException;
import cn.productai.api.pai.entity.dataset.DataSetModifyResponse;
import cn.productai.api.pai.entity.dataset.DataSetSingleAddByImageUrlRequest;
import com.alibaba.fastjson.JSON;
import com.winwin.picreport.Futils.hanhan.p;

/**
 * Created by Zhong Wang on 2017/8/15.
 * 数据集操作 - 向数据集增加单条数据
 * https://api-doc.productai.cn/doc/pai.html#向数据集增加单条数据
 */
public class DataSetSingleModifyExample1 {

//    public static void main(String[]args){
//        IWebClient client = GetIWebClientOfMaLong.getIWebClient();
//        DataSetModifyResponse res= g().run(client, Cnst.image_set_idOfWinWinPrdtSamp, Cnst.testPicUrl);
//        p.p("-------------------------------------------------------");
//        p.p(JSON.toJSONString(res));
//        p.p("-------------------------------------------------------");
//    }


    public static DataSetSingleModifyExample1 g(){
        return new DataSetSingleModifyExample1();
    }
    public DataSetModifyResponse  run(IWebClient client,String image_set_id,String imageUrl) {

        p.p("==>  Demo - xiang shuJuJi tianJia yiTiao jiLu  <==");
        p.p("See https://api-doc.productai.cn/doc/pai.html#---xiang shuJuJi tianJia danTiao shuJu    ---- for details.\r\n");
        //参数1是image_set_id
        DataSetSingleAddByImageUrlRequest request = new DataSetSingleAddByImageUrlRequest(image_set_id,null,null);
//        request.setImageUrl("http://test.waltercrow.co.nz/wp/wp-content/uploads/2010/06/muji-clothes.jpg");
        request.setImageUrl(imageUrl);
        request.setLanguage(LanguageType.Chinese);
        DataSetModifyResponse response =null;
        try {
           response = client.getResponse(request);
            p.p("==============================Result==============================");

            // access the response directly
            p.p(String.format("LastModifiedTime - %s", response.getLastModifiedTime()));

            p.p("==============================Result==============================");
        } catch (cn.productai.api.core.exceptions.ServerException e) {
            p.p(String.format("ServerException occurred. ErrorCode: %s \r\n ErrorMessage: %s",
                    e.getErrorCode(),
                    e.getErrorMessage()));
            e.printStackTrace();

        } catch (ClientException e) {
            p.p(String.format("ClientException occurred. ErrorCode: %s \r\n ErrorMessage: %s \r\n RequestId: %s",
                    e.getErrorCode(),
                    e.getErrorMessage(),
                    e.getRequestId()));
            e.printStackTrace();

        } catch (Exception e) {
            p.p(String.format("%s occurred. ErrorMessage: %s", e.getClass().getName(), e.getMessage()));
            e.printStackTrace();
        }
        return response;
    }
}
