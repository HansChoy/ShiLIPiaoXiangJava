package com.hans.shilipiaoxiang.applet.controller;


import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.applet.pojo.*;
import com.hans.shilipiaoxiang.applet.service.GoodsService;
import com.hans.shilipiaoxiang.applet.service.OrderService;
import com.hans.shilipiaoxiang.applet.service.ShoppingCartService;
import com.hans.shilipiaoxiang.json.Result;
import com.hans.shilipiaoxiang.json.ResultType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import com.hans.shilipiaoxiang.config.DateUtil;

@RestController
@Api(description = "订单模块")
@RequestMapping("json/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private GoodsService goodsService;
    @ApiOperation(value = "提交订单")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public void addOrder(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer cartId=data.getInteger("cartId");
        Double price=data.getDouble("price");
        Integer total=data.getInteger("total");
        Integer userId=data.getInteger("userId");
        String note=data.getString("note");
        Integer type=data.getInteger("type");
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV<0){
            hashCodeV=-hashCodeV;
        }
        char str1=(char) ('A'+Math.random()*('Z'-'A'+1));
        char str2=(char) ('A'+Math.random()*('Z'-'A'+1));
        String code1= str1+""+str2+String.format("%010d", hashCodeV);
        Calendar now = Calendar.getInstance();
        String minute=String.format("%02d",now.get(Calendar.MINUTE));
        String second=String.format("%02d",now.get(Calendar.SECOND));
        char str3=(char) ('A'+Math.random()*('D'-'A'+1));
        String code2=str3+minute+second;
        long t=System.currentTimeMillis();
        COrder cOrder=new COrder();
        cOrder.setOrderno(code1);
        cOrder.setCode(code2);
        cOrder.setWxId(userId);
        cOrder.setTotal(total);
        cOrder.setPrice(price);
        cOrder.setNote(note);
        cOrder.setType(type);
        cOrder.setState(1);
        cOrder.setOrdertime(t);
        int orderId=orderService.addOrder(cOrder);
        List<CCartGoods> list=new ArrayList<>();
        list=orderService.getGoodsId(cartId);
        for(CCartGoods c:list){
            COrderGoods cOrderGoods=new COrderGoods();
            CGoods cGoods=c.getcGoods();
            CGoods cGoods1=new CGoods();
            cGoods1.setAmount(c.getNum());
            cGoods1.setId(cGoods.getId());
            goodsService.updateAmount(cGoods1);
            if(cGoods.getIfsale()==1){
                if(c.getNum()>cGoods.getTagNum()){
                    double price1=(cGoods.getTagNum()*cGoods.getPrice()+(c.getNum()-cGoods.getTagNum())*cGoods.getOriginPrice());
                    cOrderGoods.setPrice(price1);
                }else{
                    cOrderGoods.setPrice(c.getNum()*cGoods.getPrice());
                }
            }else{
                cOrderGoods.setPrice(c.getNum()*cGoods.getPrice());
            }

            cOrderGoods.setGoodId(c.getGoodId());
            cOrderGoods.setOrderId(orderId);
            cOrderGoods.setNum(c.getNum());
            orderService.addOrderGoods(cOrderGoods);
        }
        shoppingCartService.deleteCartGoods(cartId);
        String json;
        json = Result.build(ResultType.Success).appendData("code",code2).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "获取订单预览信息")
    @RequestMapping(value = "/showOrderPreview", method = RequestMethod.POST)
    public void showOrderPreview(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer state=data.getInteger("state");
        Integer userId=data.getInteger("userId");
        response.setContentType("application/json;charset=utf-8");
        COrder cOrder1=new COrder();
        cOrder1.setState(state);
        cOrder1.setWxId(userId);
        List<COrder> cOrderList=orderService.getOrders(cOrder1);
        List<JSONObject> res = new ArrayList<>();
        for(COrder o:cOrderList) {
            int orderId = o.getId();
            List<CGoods> cGoodsList = orderService.getGoodsName(orderId);
            String goodsName = null;
            int i = 0;
            for (CGoods c : cGoodsList) {
                if (i == 0)
                    goodsName = c.getTitle() + ',';
                else if (i < cGoodsList.size() - 1)
                    goodsName = goodsName + c.getTitle() + ',';
                else
                    goodsName = goodsName + c.getTitle();
                i++;
            }
            COrder cOrder = orderService.getOrder(orderId);
            String time = DateUtil.getDate(cOrder.getOrdertime());
            JSONObject list = new JSONObject();
            list.put("goodsName",goodsName);
            list.put("cOrder",cOrder);
            list.put("orderTime",time);
            res.add(list);
        }
        String json;
        json = Result.build(ResultType.Success).appendData("data", res).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "获取订单信息")
    @RequestMapping(value = "/showOrder", method = RequestMethod.POST)
    public void showOrder(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer orderId=data.getInteger("orderId");
        response.setContentType("application/json;charset=utf-8");
//        List<CGoods> cGoodsList=orderService.getGoodsName(orderId);
//        String goodsName=null;
//        int i=0;
//        for(CGoods c:cGoodsList){
//            if(i==0)
//                goodsName=c.getTitle()+',';
//            else if(i<cGoodsList.size()-1)
//                goodsName=goodsName+c.getTitle()+',';
//            else
//                goodsName=goodsName+c.getTitle();
//            i++;
//        }
        COrder cOrder=orderService.getOrderDetail(orderId);
        String time=DateUtil.getDate(cOrder.getOrdertime());
        JSONObject list = new JSONObject();
//        list.put("goodsName",goodsName);
        list.put("cOrder",cOrder);
        list.put("orderTime",time);
        String json;
        json = Result.build(ResultType.Success).appendData("data", list).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "添加评价")
    @RequestMapping(value = "/makeEvaluate", method = RequestMethod.POST)
    public void makeEvaluate(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer orderId=data.getInteger("orderId");
        Integer userId=data.getInteger("userId");
        Integer rate=data.getInteger("rate");
        String text=data.getString("text");
        long t=System.currentTimeMillis();
        response.setContentType("application/json;charset=utf-8");
        COrder cOrder=new COrder();
        cOrder.setId(orderId);
        cOrder.setState(3);
        CEvaluate cEvaluate=new CEvaluate();
        cEvaluate.setOrderId(orderId);
        cEvaluate.setUserId(userId);
        cEvaluate.setRate(rate);
        cEvaluate.setText(text);
        cEvaluate.setEvaluatedTime(t);
        cEvaluate.setState(1);
        orderService.makeEvaluate(cEvaluate);
        orderService.updateOrder(cOrder);
//        orderService.
        String json;
        json = Result.build(ResultType.Success).appendData("data", "success").convertIntoJSON();
        response.getWriter().write(json);
    }
    @ApiOperation(value = "展示我的评价")
    @RequestMapping(value = "/showEvaluate", method = RequestMethod.POST)
    public void showEvaluate(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer userId=data.getInteger("userId");
        response.setContentType("application/json;charset=utf-8");
        List<CEvaluate> cEvaluateList= orderService.showEvaluate(userId);
        List<JSONObject> res = new ArrayList<>();
        for(CEvaluate c:cEvaluateList){
            List<CGoods> cGoodsList = orderService.getGoodsName(c.getOrderId());
            JSONObject list = new JSONObject();
            String time = DateUtil.getSimpleDate(c.getEvaluatedTime());
            String goodsName = null;
            int i = 0;
            for (CGoods a : cGoodsList) {
                if (i == 0)
                    goodsName = a.getTitle() + ',';
                else if (i < cGoodsList.size() - 1)
                    goodsName = goodsName + a.getTitle() + ',';
                else
                    goodsName = goodsName + a.getTitle();
                i++;
            }
            List<CEvaluateReply> cEvaluateReplyList=c.getcEvaluateReplyList();
            for(CEvaluateReply r:cEvaluateReplyList){
                String replyTime = DateUtil.getSimpleDate(r.getReplyTime());
                r.setReplyDate(replyTime);
            }
            list.put("goodsName",goodsName);
            list.put("cEvaluate",c);
            list.put("evaluateTime",time);
            res.add(list);
        }
        String json;
        json = Result.build(ResultType.Success).appendData("data", res).convertIntoJSON();
        response.getWriter().write(json);
    }
    @ApiOperation(value = "添加追评")
    @RequestMapping(value = "/addEvaluateReply", method = RequestMethod.POST)
    public void addEvaluateReply(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer userId=data.getInteger("userId");
        Integer orderId=data.getInteger("orderId");
        String text=data.getString("text");
        long t=System.currentTimeMillis();
        CEvaluateReply cEvaluateReply=new CEvaluateReply();
        cEvaluateReply.setOrderId(orderId);
        cEvaluateReply.setUserId(userId);
        cEvaluateReply.setText(text);
        cEvaluateReply.setReplyTime(t);
        cEvaluateReply.setType(0);
        orderService.addEvaluateReply(cEvaluateReply);
        response.setContentType("application/json;charset=utf-8");
        List<CEvaluate> cEvaluateList= orderService.showEvaluate(userId);
        JSONObject list = new JSONObject();
        for(CEvaluate c:cEvaluateList){
            if(c.getOrderId()==orderId) {
                List<CGoods> cGoodsList = orderService.getGoodsName(c.getOrderId());
                String time = DateUtil.getSimpleDate(c.getEvaluatedTime());
                String goodsName = null;
                int i = 0;
                for (CGoods a : cGoodsList) {
                    if (i == 0)
                        goodsName = a.getTitle() + ',';
                    else if (i < cGoodsList.size() - 1)
                        goodsName = goodsName + a.getTitle() + ',';
                    else
                        goodsName = goodsName + a.getTitle();
                    i++;
                }
                List<CEvaluateReply> cEvaluateReplyList = c.getcEvaluateReplyList();
                for (CEvaluateReply r : cEvaluateReplyList) {
                    String replyTime = DateUtil.getSimpleDate(r.getReplyTime());
                    r.setReplyDate(replyTime);
                }
                list.put("goodsName", goodsName);
                list.put("cEvaluate", c);
                list.put("evaluateTime", time);
                break;
            }
        }
        String json;
        json = Result.build(ResultType.Success).appendData("data", list).convertIntoJSON();
        response.getWriter().write(json);
    }
    @ApiOperation(value = "展示所有评价")
    @RequestMapping(value = "/showAllEvaluate", method = RequestMethod.GET)
    public void showAllEvaluate(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<CEvaluate> cEvaluateList= orderService.showAllEvaluate();
        List<JSONObject> res = new ArrayList<>();
        for(CEvaluate c:cEvaluateList){
            List<CGoods> cGoodsList = orderService.getGoodsName(c.getOrderId());
            JSONObject list = new JSONObject();
            String time = DateUtil.getSimpleDate(c.getEvaluatedTime());
            String goodsName = null;
            int i = 0;
            for (CGoods a : cGoodsList) {
                if (i == 0)
                    goodsName = a.getTitle() + ',';
                else if (i < cGoodsList.size() - 1)
                    goodsName = goodsName + a.getTitle() + ',';
                else
                    goodsName = goodsName + a.getTitle();
                i++;
            }
            List<CEvaluateReply> cEvaluateReplyList=c.getcEvaluateReplyList();
            for(CEvaluateReply r:cEvaluateReplyList){
                String replyTime = DateUtil.getSimpleDate(r.getReplyTime());
                r.setReplyDate(replyTime);
            }
            list.put("goodsName",goodsName);
            list.put("cEvaluate",c);
            list.put("evaluateTime",time);
            res.add(list);
        }
        String json;
        json = Result.build(ResultType.Success).appendData("data", res).convertIntoJSON();
        response.getWriter().write(json);
    }
}
