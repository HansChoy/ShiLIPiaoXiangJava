package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypes;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CGoodsTypesMapper {
    int countByExample(CGoodsTypesExample example);

    int deleteByExample(CGoodsTypesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CGoodsTypes record);

    int insertSelective(CGoodsTypes record);

    List<CGoodsTypes> selectByExample(CGoodsTypesExample example);

    CGoodsTypes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CGoodsTypes record, @Param("example") CGoodsTypesExample example);

    int updateByExample(@Param("record") CGoodsTypes record, @Param("example") CGoodsTypesExample example);

    int updateByPrimaryKeySelective(CGoodsTypes record);

    int updateByPrimaryKey(CGoodsTypes record);

    List<CGoodsTypes> showGoods();

    CGoodsTypes showSaleGoods();
}