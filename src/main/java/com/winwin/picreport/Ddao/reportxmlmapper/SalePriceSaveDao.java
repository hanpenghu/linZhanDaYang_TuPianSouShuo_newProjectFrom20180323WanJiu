package com.winwin.picreport.Ddao.reportxmlmapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/6/14.
 */
public interface SalePriceSaveDao {
    @Select({"select prd_no from prdt_samp where id=#{uuid}"})
    String getPrdNoFromPrdtSamp(@Param("uuid") String uuid);
}
