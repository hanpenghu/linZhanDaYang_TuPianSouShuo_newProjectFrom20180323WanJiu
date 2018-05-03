package com.winwin.picreport.Ddao.reportxmlmapper;

import com.winwin.picreport.Edto.Cust;
import com.winwin.picreport.Edto.CustExample;
import com.winwin.picreport.Edto.CustWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustMapper {
    long countByExample(CustExample example);

    int deleteByExample(CustExample example);

    int deleteByPrimaryKey(String cusNo);

    int insert(CustWithBLOBs record);

    int insertSelective(CustWithBLOBs record);

    List<CustWithBLOBs> selectByExampleWithBLOBs(CustExample example);

    List<Cust> selectByExample(CustExample example);

    CustWithBLOBs selectByPrimaryKey(String cusNo);

    int updateByExampleSelective(@Param("record") CustWithBLOBs record, @Param("example") CustExample example);

    int updateByExampleWithBLOBs(@Param("record") CustWithBLOBs record, @Param("example") CustExample example);

    int updateByExample(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByPrimaryKeySelective(CustWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CustWithBLOBs record);

    int updateByPrimaryKey(Cust record);
}