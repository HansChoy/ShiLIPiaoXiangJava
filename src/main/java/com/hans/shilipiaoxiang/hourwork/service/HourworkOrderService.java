//package com.shixun.ihome.hourwork.service;
//
//import com.shixun.ihome.publicservice.pojo.IEvaluate;
//import com.shixun.ihome.publicservice.pojo.IOrder;
//import com.shixun.ihome.publicservice.pojo.IOrderComplaint;
//
//import java.util.List;
//
//public interface HourworkOrderService {
//    //下单
//    boolean addOrder(IOrder order);
//    //取消订单
//    boolean cancelOrder(int id);
//    //修改订单
//    boolean updateOrder(IOrder order);
//    //删除订单
//    boolean deleteOrder(int id);
//    //搜索订单
//    List<IOrder> selectOrder(IOrder order);
//    //获取某订单
//    IOrder getOrder(int id);
//
//
//    //OrderStaff
//    //为订单选择人
//    boolean choiceStaffs(int orderId, int staffId);
//    //删除某个人
//    boolean delStaff(int id);
//
//    //OrderComplaint
//
//    //投诉
//    boolean complaint(IOrderComplaint iOrderComplaint);
//
//
//    //Evaluate 评价
//    //评价只会出现一次 不删除
//    boolean orderEvaluate(IEvaluate iEvaluate);
//
//
//
//}
