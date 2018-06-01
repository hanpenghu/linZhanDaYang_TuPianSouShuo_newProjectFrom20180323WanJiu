package com.winwin.picreport.Bcontroller.daYang.打样产品导出Excel;

import com.winwin.picreport.AllConstant.InterFaceCnst;
import com.winwin.picreport.Futils.MsgGenerate.Msg;
import com.winwin.picreport.Futils.hanhan.p;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
@CrossOrigin
@RestController
public class DyExport {

    /**
     *传参：
     * {"ids":["id1","id2","id3"],"fields":["field1","field2","field3"]}
     * 第一个list是确定下载那些行
     * 第二个列表是确定下载那些列
     *js请求:
     * Content-Type    application/json
     * */

    @RequestMapping(value="dyExportExcel")
    public ResponseEntity<byte[]> 打样产品导出(@RequestBody ExportXlsParam ep) throws Exception {
        p.p2(ep);
        //注意  ep  是 空的,会直接报错给前端,不用管
        List<String> ids = ep.getIds();
        List<String> fields = ep.getFields();





        return null;
    }



























    private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
}
