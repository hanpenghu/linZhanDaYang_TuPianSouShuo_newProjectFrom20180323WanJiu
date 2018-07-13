package com.winwin.picreport.Ddao.reportxmlmapper;

import com.winwin.picreport.Edto.ModelUsersSpc;
import com.winwin.picreport.Edto.ModelUsersSpcExample;
import com.winwin.picreport.Edto.ModelUsersSpcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelUsersSpcMapper {
    long countByExample(ModelUsersSpcExample example);

    int deleteByExample(ModelUsersSpcExample example);

    int deleteByPrimaryKey(ModelUsersSpcKey key);

    int insert(ModelUsersSpc record);

    int insertSelective(ModelUsersSpc record);

    List<ModelUsersSpc> selectByExample(ModelUsersSpcExample example);

    ModelUsersSpc selectByPrimaryKey(ModelUsersSpcKey key);

    int updateByExampleSelective(@Param("record") ModelUsersSpc record, @Param("example") ModelUsersSpcExample example);

    int updateByExample(@Param("record") ModelUsersSpc record, @Param("example") ModelUsersSpcExample example);

    int updateByPrimaryKeySelective(ModelUsersSpc record);

    int updateByPrimaryKey(ModelUsersSpc record);
}