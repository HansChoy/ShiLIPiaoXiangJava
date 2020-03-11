package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CGoodsMapper {
    int countByExample(CGoodsExample example);

    int deleteByExample(CGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CGoods record);

    int insertSelective(CGoods record);

    List<CGoods> selectByExample(CGoodsExample example);

    CGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CGoods record, @Param("example") CGoodsExample example);

    int updateByExample(@Param("record") CGoods record, @Param("example") CGoodsExample example);

    int updateByPrimaryKeySelective(CGoods record);

    int updateByPrimaryKey(CGoods record);

    List<CGoods> commitCartGoods(int cartId);

    List<CGoods> showRecommendGoods();

    List<CGoods> showOrderPreview(int cartId);
}