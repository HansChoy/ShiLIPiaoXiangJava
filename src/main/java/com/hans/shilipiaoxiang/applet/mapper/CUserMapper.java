package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CUser;
import com.hans.shilipiaoxiang.applet.pojo.CUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CUserMapper {
    int countByExample(CUserExample example);

    int deleteByExample(CUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CUser record);

    int insertSelective(CUser record);

    List<CUser> selectByExample(CUserExample example);

    CUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateByExample(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateByPrimaryKeySelective(CUser record);

    int updateByPrimaryKey(CUser record);

    CUser selectByOpenId(String openId);
}