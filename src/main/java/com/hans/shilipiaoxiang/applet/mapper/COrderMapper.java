package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.Select.AmountResult;
import com.hans.shilipiaoxiang.applet.pojo.COrder;
import com.hans.shilipiaoxiang.applet.pojo.COrderExample;
import com.hans.shilipiaoxiang.applet.Select.SelectParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderMapper {
    int countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    COrder showOrder(int orderId);

    List<COrder> showOrders(COrder record);

    List<AmountResult> showAmount(SelectParams record);

    List<AmountResult> showAmountDetail(SelectParams record);

    List<AmountResult> showToday(SelectParams record);
}