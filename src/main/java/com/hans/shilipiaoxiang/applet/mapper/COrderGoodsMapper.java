package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.COrderGoods;
import com.hans.shilipiaoxiang.applet.pojo.COrderGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderGoodsMapper {
    int countByExample(COrderGoodsExample example);

    int deleteByExample(COrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(COrderGoods record);

    int insertSelective(COrderGoods record);

    List<COrderGoods> selectByExample(COrderGoodsExample example);

    COrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") COrderGoods record, @Param("example") COrderGoodsExample example);

    int updateByExample(@Param("record") COrderGoods record, @Param("example") COrderGoodsExample example);

    int updateByPrimaryKeySelective(COrderGoods record);

    int updateByPrimaryKey(COrderGoods record);

    COrderGoods showOrderPreview(int cartId);
}