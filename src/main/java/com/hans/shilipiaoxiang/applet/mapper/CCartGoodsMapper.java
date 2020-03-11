package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CCartGoodsMapper {
    int countByExample(CCartGoodsExample example);

    int deleteByExample(CCartGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCartGoods record);

    int insertSelective(CCartGoods record);

    List<CCartGoods> selectByExample(CCartGoodsExample example);

    CCartGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCartGoods record, @Param("example") CCartGoodsExample example);

    int updateByExample(@Param("record") CCartGoods record, @Param("example") CCartGoodsExample example);

    int updateByPrimaryKeySelective(CCartGoods record);

    int updateByPrimaryKey(CCartGoods record);

    int update(CCartGoods record);

    CCartGoods selectByIds(CCartGoods record);

    List<CCartGoods> showCartGoods(int cartId);

    int deleteCartGoods(int cartId);

    CCartGoods getNum(CCartGoods record);

    List<CCartGoods> getGoodsId(int cartId);
}