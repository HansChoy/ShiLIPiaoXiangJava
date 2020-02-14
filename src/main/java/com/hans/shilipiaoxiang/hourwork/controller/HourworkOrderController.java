//package com.shixun.ihome.hourwork.controller;
//
//import com.shixun.ihome.hourwork.service.HourworkOrderService;
//import com.shixun.ihome.hourwork.service.HourworkStaffService;
//import com.shixun.ihome.publicservice.mapper.IOrderMapper;
//import com.shixun.ihome.publicservice.pojo.IEvaluate;
//import com.shixun.ihome.publicservice.pojo.IOrder;
//import com.shixun.ihome.publicservice.pojo.IOrderComplaint;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@Api(description = "订单控制器")
//@RequestMapping("json/hourwork/order")
//public class HourworkOrderController {
//    @Autowired
//    private HourworkOrderService orderService;
//    @Autowired
//    private HourworkStaffService staffService;
//    @ApiOperation(value = "插入新订单")
//    @ApiImplicitParam(name="iOrder", required = true, dataType ="IOrder")
//    @ResponseBody
//    @RequestMapping("AddOrder")
//    public Object addOrder(IOrder iOrder){
//        return orderService.addOrder(iOrder);
//    }
//
//    @ApiOperation("取消订单")
//    @ApiImplicitParam(name="id", required = true, dataType = "Integer")
//    @ResponseBody
//    @RequestMapping("CancelOrder")
//    public Object cancelOrder(int id) {
//
//        IOrder iOrder = orderService.getOrder(id);
//        //检测订单是否存在
//        if(iOrder == null){
//            return "订单不存在";
//        }
//        //检测订单是否是0（提交中）或2（待服务）
//        int status = iOrder.getState();
//        if( status == 0 || status == 2 ){
//            return orderService.cancelOrder(id);
//        }
//
//        return "订单无法取消";
//    }
//
//    @ApiOperation("删除订单")
//    @ApiImplicitParam(name="id", required = true, dataType = "Integer")
//    @ResponseBody
//    @RequestMapping("DeleteOrder")
//    public Object deleteOrder(int id){
//        //检测订单是否存在
//        IOrder iOrder = orderService.getOrder(id);
//        if (iOrder == null) return "订单不存在";
//        //检测订单是否是已完成
//        int status = iOrder.getState();
//        if (status != IOrderMapper.FINISH) {
//            return "订单无法删除";
//        }
//        return orderService.deleteOrder(id);
//    }
//
//    @ApiOperation(value = "获取订单根据自己的id和session")
//    @ResponseBody
//    @RequestMapping("getOrders")
//    public List<IOrder> getOrders(){
//        List<IOrder> iOrders = null;
//        IOrder iOrder = new IOrder();
//        //获取session
//
//        //还没做完
//        try {
//            iOrders = orderService.selectOrder(null);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//        return iOrders;
//    }
//
//    @ApiOperation(value = "为订单分配员工")
//    @ApiImplicitParams({@ApiImplicitParam(name="staffIds", required = true, dataType = "List"),
//            @ApiImplicitParam(name="orderId", required = true, dataType ="Integer")})
//    @ResponseBody
//    @RequestMapping("addStaffs")
//    public Object addStaffs(List<Integer> staffIds, int orderId) {
//        //检测选择是否为空
//        if (staffIds.isEmpty()){
//            return "请至少选择一个员工";
//        }
//        int c = 0;
//        for (int id : staffIds ){
//            if(!orderService.choiceStaffs(orderId, id)){
//                throw new RuntimeException();
//
//            }
//        }
//        return "插入员工成功";
//
//    }
//    @ApiOperation("删除订单之中的员工")
//    @ApiImplicitParam(name="id", required = true, dataType = "Integer")
//    @ResponseBody
//    @RequestMapping("delStaff")
//    public Object delStaff(int id) {
//        if(orderService.delStaff(id)){
//            return "删除成功";
//        }
//        return "删除失败";
//    }
//
//
//    @ApiOperation("投诉")
//    @ApiImplicitParam(name="iOrderComplaint", required = true, dataType = "IOrderComplaint")
//    @ResponseBody
//    @RequestMapping("orderComplaint")
//    public Object orderComplaint(IOrderComplaint iOrderComplaint){
//        if(orderService.complaint(iOrderComplaint)){
//            return "投诉成功";
//        }
//        return "投诉失败";
//    }
//
//    @ApiOperation("订单评价")
//    @ApiImplicitParam(name="iEvaluate", required = true, dataType = "IEvaluate")
//    @ResponseBody
//    @RequestMapping("orderEvaluate")
//    public Object orderEvaluate(IEvaluate iEvaluate){
//        if (orderService.orderEvaluate(iEvaluate)){
//            return "订单评价成功";
//        }
//        return "订单评价失败";
//    }
//
//}
