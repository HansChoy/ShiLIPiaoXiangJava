package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CShoppingCart;
import com.hans.shilipiaoxiang.applet.pojo.CShoppingCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CShoppingCartMapper {
    int countByExample(CShoppingCartExample example);

    int deleteByExample(CShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CShoppingCart record);

    int insertSelective(CShoppingCart record);

    List<CShoppingCart> selectByExample(CShoppingCartExample example);

    CShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CShoppingCart record, @Param("example") CShoppingCartExample example);

    int updateByExample(@Param("record") CShoppingCart record, @Param("example") CShoppingCartExample example);

    int updateByPrimaryKeySelective(CShoppingCart record);

    int updateByPrimaryKey(CShoppingCart record);

    CShoppingCart selectByOpenId(String wxId);


}