package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CAdminMapper {
    int countByExample(CAdminExample example);

    int deleteByExample(CAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CAdmin record);

    int insertSelective(CAdmin record);

    List<CAdmin> selectByExample(CAdminExample example);

    CAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CAdmin record, @Param("example") CAdminExample example);

    int updateByExample(@Param("record") CAdmin record, @Param("example") CAdminExample example);

    int updateByPrimaryKeySelective(CAdmin record);

    int updateByPrimaryKey(CAdmin record);

    CAdmin login(String username);
}