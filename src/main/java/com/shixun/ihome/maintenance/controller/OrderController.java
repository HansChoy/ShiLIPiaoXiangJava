package com.shixun.ihome.maintenance.controller;

import com.shixun.ihome.config.RedisCache;
import com.shixun.ihome.json.Result;
import com.shixun.ihome.maintenance.service.OrderService;
import com.shixun.ihome.publicservice.pojo.IOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(description = "订单维修模块测试")
@RequestMapping("json/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisCache cache;

    @ApiOperation(value = "增加维修订单")
    @ApiImplicitParam(name="order",value ="订单实体类", required = true, dataType ="IOrder")
    @PostMapping("addIOrder")
    @ResponseBody
    public Boolean addorder(@RequestBody IOrder order){
        boolean success=orderService.addOrder(order);

        return true;
    }

    @ApiOperation(value = "取消维修订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public Boolean cancelOrder(int id){
         boolean success=orderService.cancelOrder(id);
         return true;

    }

    @ApiOperation(value = "填写维修详情")
    @RequestMapping(value="/addDetail",method=RequestMethod.POST)
    @ResponseBody
    public Boolean addOrderNew(int id,String odescribe,String sovle,Double price){
           boolean success=orderService.addDetail(id,odescribe,sovle,price);
           return true;
    }


    @ApiOperation(value ="订单评价")
    @RequestMapping(value="/addEvaluate",method = RequestMethod.POST)
    @ResponseBody
    public Boolean addEvaluate(int id, int quality_valuation, int attitude_valuation, String describe){
        boolean success=orderService.addEvaluate(id,quality_valuation,attitude_valuation,describe);
        return true;
    }

    @ApiOperation(value ="查看所有订单")
    @RequestMapping(value="/listAll",method = RequestMethod.GET)
    @ResponseBody
    public Boolean addEvaluate(){
        boolean success=
        return true;
    }



}
