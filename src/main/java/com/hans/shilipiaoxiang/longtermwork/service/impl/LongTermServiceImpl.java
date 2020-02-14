package com.hans.shilipiaoxiang.longtermwork.service.impl;

import com.hans.shilipiaoxiang.publicservice.mapper.IOrderLongMapper;
import com.hans.shilipiaoxiang.publicservice.mapper.IOrderMapper;
import com.hans.shilipiaoxiang.publicservice.mapper.IStaffMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IOrder;
import com.hans.shilipiaoxiang.publicservice.pojo.IOrderLong;
import com.hans.shilipiaoxiang.publicservice.pojo.IStaff;
import com.hans.shilipiaoxiang.longtermwork.service.LongTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LongTermServiceImpl implements LongTermService {



    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IOrderLongMapper orderLongMapper;
    @Autowired
    private IStaffMapper iStaffMapper;

    @Override
    public boolean addOrder(IOrder order) {
        orderMapper.insert(order);
        return true;
    }
    @Override
    public boolean cancelOrder(int id) {
        IOrder order =new IOrder();
        order.setId(id);
        order.setState(1);
        orderMapper.updateByPrimaryKeySelective(order);
        return true;
    }

    @Override
    public boolean addOrderDetails(IOrderLong orderLong) {
        return false;
    }

    @Override
    public boolean confirmOrder(int id) {
        IOrder order =new IOrder();
        order.setId(id);
        order.setState(4);
        orderMapper.updateByPrimaryKeySelective(order);
        return true;
    }

    @Override
    public boolean addOrderLong(IOrderLong orderLong) {
        orderLongMapper.insert(orderLong);
        return true;
    }

    @Override
    public List<IStaff> selectLongTermStaffs() {
        List<IStaff> iStaffList=iStaffMapper.selectFreeLongTermsWorks();
        return iStaffList;
    }
}
