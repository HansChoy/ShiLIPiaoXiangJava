//package com.shixun.ihome.hourwork.service.serviceImpl;
//
//import com.shixun.ihome.hourwork.service.HourworkOrderService;
//import com.shixun.ihome.publicservice.mapper.IEvaluateMapper;
//import com.shixun.ihome.publicservice.mapper.IOrderComplaintMapper;
//import com.shixun.ihome.publicservice.mapper.IOrderMapper;
//import com.shixun.ihome.publicservice.mapper.IOrderStaffMapper;
//import com.shixun.ihome.publicservice.pojo.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class HourworkOrderServiceImpl implements HourworkOrderService {
//    @Autowired
//    private IOrderMapper iOrderMapper;
//    @Autowired
//    private IOrderStaffMapper iOrderStaffMapper;
//    @Autowired
//    private IOrderComplaintMapper iOrderComplaintMapper;
//    @Autowired
//    private IEvaluateMapper iEvaluateMapper;
//
//
//    @Override
//    public boolean addOrder(IOrder order) {
//        return iOrderMapper.insertSelective(order) > 0;
//    }
//
//    @Override
//    public IOrder getOrder(int id) {
//        return iOrderMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public boolean choiceStaffs(int orderId, int staffId) {
//        IOrderStaff iOrderStaff = new IOrderStaff();
//        iOrderStaff.setOrderId(orderId);
//        iOrderStaff.setStaffId(staffId);
//        return iOrderStaffMapper.insert(iOrderStaff) > 0;
//    }
//
//    @Override
//    public boolean delStaff(int id) {
//        return iOrderStaffMapper.deleteByPrimaryKey(id) > 0;
//    }
//
//    @Override
//    public boolean cancelOrder(int id) {
//        IOrder iOrder = new IOrder();
//        iOrder.setId(id);
//        iOrder.setState(iOrderMapper.CANCEL);
//        return iOrderMapper.updateByPrimaryKeySelective(iOrder) > 0;
//    }
//
//    @Override
//    public boolean updateOrder(IOrder order) {
//        return iOrderMapper.updateByPrimaryKeySelective(order) > 0;
//    }
//
//    @Override
//    public boolean deleteOrder(int id) {
//        return iOrderMapper.deleteByPrimaryKey(id) > 0;
//    }
//
//    @Override
//    public List<IOrder> selectOrder(IOrder order) {
//        IOrderExample iOrderExample = new IOrderExample();
//        IOrderExample.Criteria criteria = iOrderExample.createCriteria();
//
//        return iOrderMapper.selectByExample(iOrderExample);
//    }
//
//    @Override
//    public boolean complaint(IOrderComplaint iOrderComplaint) {
//        //如果投诉的id为空就插入
//        if (iOrderComplaint.getId() != null) {
//            return iOrderComplaintMapper.updateByPrimaryKeySelective(iOrderComplaint) > 0;
//        }
//        return iOrderComplaintMapper.insertSelective(iOrderComplaint) > 0;
//    }
//
//    @Override
//    public boolean orderEvaluate(IEvaluate iEvaluate) {
//        return iEvaluateMapper.insertSelective(iEvaluate) > 0;
//    }
//}
