package com.shixun.ihome.work.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shixun.ihome.config.ApiJsonObject;
import com.shixun.ihome.config.ApiJsonProperty;
import com.shixun.ihome.json.Result;
import com.shixun.ihome.json.ResultBase;
import com.shixun.ihome.json.ResultType;
import com.shixun.ihome.publicservice.pojo.IOrderLong;
import com.shixun.ihome.publicservice.pojo.IStaff;
import com.shixun.ihome.work.service.OrderService;
import com.shixun.ihome.publicservice.pojo.IOrder;
import com.shixun.ihome.work.service.StaffService;
import com.shixun.ihome.work.service.TimeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@Api(description = "订单模块")
@RequestMapping("json/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private StaffService staffService;


    @ApiOperation(value = "增加订单")
    @Transactional
    @ApiImplicitParam(name = "order", value = "订单实体类", required = true, dataType = "IOrder")
    @PostMapping("addIOrder")
    public ResultBase addorder(@RequestBody IOrder order) {
        if (orderService.addOrderRecord(order, "乔哥")){
            return ResultBase.success();
        }
        return ResultBase.fail("添加订单失败");
    }

    @ApiOperation(value = "添加订单")
    public ResultBase addOrder(@RequestBody JSONObject params){
        return null;
    }


    @ApiOperation(value = "添加长期工的订单")
    @Transactional
    @ApiImplicitParam(name = "orderLong", value = "长期工订单实体类", dataType = "IOrderLong")
    @PostMapping("addLongOrder")
    public ResultBase addLongOrder(@RequestBody IOrderLong orderLong) {
        if( orderService.addOrderRecord(orderLong.getOrder(), "乔哥")){
            return new ResultBase(400,"长期工订单添加失败");
        }
        if (orderService.addOrderLong(orderLong)) {
            return new ResultBase(200, "插入成功");
        }
        return new ResultBase(400, "插入失败");

    }

    @ApiOperation(value = "取消维修订单")
    @ApiImplicitParam(name = "id", value = "订单id", required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public Boolean cancelOrder(@ApiJsonObject(name = "name", value = {
            @ApiJsonProperty(key = "id", example = "1", description = "订单id")
    })@RequestBody JSONObject name) {
        int id=name.getInteger("id");
        boolean success = orderService.cancelOrder(id);
        return success;
    }

    @ApiOperation(value = "填写维修详情")
    @RequestMapping(value = "/addDetail", method = RequestMethod.POST)
    public Boolean addOrderNew(@ApiJsonObject(name = "name", value = {
            @ApiJsonProperty(key="id", example= "维修情况订单id"),
            @ApiJsonProperty(key="describe", example= "维修的情况解释"),
            @ApiJsonProperty(key="solve", example= "作出的维修情报解决方案"),
            @ApiJsonProperty(key="price", example= "价格")
    })@RequestBody JSONObject name) {
        int id=name.getInteger("id");
        String describe=name.getString("describe");
        String solve=name.getString("solve");
        Double price=name.getDouble("price");
        boolean success = orderService.addDetail(id, describe, solve, price);
        return true;
    }


    @ApiOperation(value = "订单评价")
    @RequestMapping(value = "/addEvaluate", method = RequestMethod.POST)
    public Boolean addEvaluate(@ApiJsonObject(name = "name", value = {
            @ApiJsonProperty(key = "id", example = "1", description = "订单id"),
            @ApiJsonProperty(key = "quality_valuation", example = "服务质量（1-5星）", description = "服务质量"),
            @ApiJsonProperty(key = "attitude_valuation", example = "服务态度（1-5星）", description = "服务态度"),
            @ApiJsonProperty(key = "describe", example = "备注", description = "备注")
    })@RequestBody JSONObject name) {
        int id=name.getInteger("id");
        int quality_valuation=name.getInteger("quality_valuation");
        int attitude_valuation=name.getInteger("attitude_valuation");
        String describe=name.getString("describe");
        boolean success = orderService.addEvaluate(id, quality_valuation, attitude_valuation, describe);
        return true;
    }

    @ApiOperation(value = "查看所有订单")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void orderAll(HttpServletResponse response) throws IOException {

        List<IOrder> orderList = orderService.listAll();


        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("orderList", orderList).convertIntoJSON();

        response.getWriter().write(json);

    }


    @ApiOperation(value = "查看所有订单测试")
    @RequestMapping(value = "/listAllTest", method = RequestMethod.GET)
    public ResultBase orderAllTest() {

        List<IOrder> orderList = orderService.listAll();
        return ResultBase.success(orderList);


    }


    @ApiOperation(value = "移除订单中的某个员工")
    @Transactional
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "staffId", value = "员工id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("removeStaffFromOrder")
    public ResultBase removeStaffFromOrder (Integer orderId, Integer staffId) {
        IOrder order = orderService.getOrder(orderId);
        if (orderService.removeStaffForOrder(orderId, staffId)) {
            timeService.removeTimerByOrder(staffId, order);
            staffService.updateStaffStatus(staffId, 0);
            return new ResultBase(200, "员工移除成功");
        }

        return new ResultBase(400, "员工移除失败");
    }

    @ApiOperation(value = "删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    public void deleteorder(Integer id) {
        boolean success = orderService.deleteOrder(id);
    }

    @ApiOperation(value = "高级查询订单")
    @RequestMapping(value = "/listByType", method = RequestMethod.POST)
    public void orderAllByType(@RequestBody IOrder order, HttpServletResponse response) throws IOException {

        List<IOrder> orderList = orderService.listByCondition(order);
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("orderList", orderList).convertIntoJSON();
        response.getWriter().write(json);
    }


    @ApiOperation(value = "员工安排")
    @Transactional
    @PostMapping(value = "/plantOtherStaffs")
    public ResultBase plantOtherStaffs(@ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(key = "orderId", example = "1", description = "订单"),
            @ApiJsonProperty(key = "staffIds", example = "[1,2,3,4,5]", description = "员工Id"),
    })@RequestBody JSONObject params ) {
//        Integer orderId, @RequestParam(name = "staffIds") List<Integer> staffIds, Integer timer
        //为订单分配员工
        //获取订单
        Integer orderId = params.getInteger("orderId");
        JSONArray jsonArray = params.getJSONArray("staffIds");
        IOrder order = orderService.getOrder(orderId);
        //循环员工id
        if (!jsonArray.isEmpty()){
            List<Integer> staffIds = jsonArray.toJavaList(Integer.class);
            for(Integer id: staffIds){
                //插入到订单员工表之中
                orderService.addStaffForOrder(orderId, id);
                //更新员工的时间表
                timeService.updateTimerByOrder(id, order);
                //更新员工的状态(为服务中2)
                staffService.updateStaffStatus(id, 2);
            }

            return ResultBase.success();
        }else{
            return ResultBase.fail("员工序列id不能为空");
        }
    }


    @ApiOperation("订单完成")
    @ApiImplicitParam(name="orderId", value = "订单编号", dataType = "int", paramType = "query", required = true)
    @PostMapping(value = "finshOrder")
    public ResultBase finshOrder(@ApiJsonObject (name = "params", value = {
            @ApiJsonProperty(key = "orderId", example = "1", description = "订单Id")
    })@RequestBody JSONObject params){
        //检测时间，订单是否是在服务时间结束后完成
        Integer orderId = params.getInteger( "orderId");
        IOrder order = orderService.getOrder(orderId);
        //检测是否存在订单
        if (order == null){
            return ResultBase.fail("订单不存在");
        }
        Date date = new Date();
        Date finshDate = order.getFinalyTime();
        Boolean finish = (date.getTime() - finshDate.getTime()) > 0;
        //如果确定是在服务结束后点击订单完成的
        if (finish){
            //修改订单的状态为完成 4
            List<IStaff> staffs = staffService.selectStaffForOrder(orderId);
            for (IStaff staff :
                    staffs) {
                staffService.updateStaffStatus(staff.getId(), 0);
            }
            if(orderService.updateOrderState(orderId, 4)){
                return ResultBase.success();
            }


        }else {
            return ResultBase.fail("请不要在订单还没完成前，点击完成");
        }
        return ResultBase.fail("出现未知问题");
    }
}
