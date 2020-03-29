package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CEvaluate;
import com.hans.shilipiaoxiang.applet.pojo.CEvaluateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CEvaluateMapper {
    int countByExample(CEvaluateExample example);

    int deleteByExample(CEvaluateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CEvaluate record);

    int insertSelective(CEvaluate record);

    List<CEvaluate> selectByExample(CEvaluateExample example);

    CEvaluate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CEvaluate record, @Param("example") CEvaluateExample example);

    int updateByExample(@Param("record") CEvaluate record, @Param("example") CEvaluateExample example);

    int updateByPrimaryKeySelective(CEvaluate record);

    int updateByPrimaryKey(CEvaluate record);

    List<CEvaluate> showEvaluate(int userId);

    List<CEvaluate> showAllEvaluate();
}