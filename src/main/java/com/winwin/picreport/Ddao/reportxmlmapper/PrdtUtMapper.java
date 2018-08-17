package com.winwin.picreport.Ddao.reportxmlmapper;

import com.winwin.picreport.Edto.PrdtUt;
import com.winwin.picreport.Edto.PrdtUtExample;
import com.winwin.picreport.Edto.PrdtUtKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrdtUtMapper {
    long countByExample(PrdtUtExample example);

    int deleteByExample(PrdtUtExample example);

    int deleteByPrimaryKey(PrdtUtKey key);

    int insert(PrdtUt record);

    int insertSelective(PrdtUt record);

    List<PrdtUt> selectByExample(PrdtUtExample example);

    PrdtUt selectByPrimaryKey(PrdtUtKey key);

    int updateByExampleSelective(@Param("record") PrdtUt record, @Param("example") PrdtUtExample example);

    int updateByExample(@Param("record") PrdtUt record, @Param("example") PrdtUtExample example);

    int updateByPrimaryKeySelective(PrdtUt record);

    int updateByPrimaryKey(PrdtUt record);
}