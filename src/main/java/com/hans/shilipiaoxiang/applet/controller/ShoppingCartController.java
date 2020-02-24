package com.hans.shilipiaoxiang.applet.controller;

import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypes;
import com.hans.shilipiaoxiang.applet.service.GoodsService;
import com.hans.shilipiaoxiang.applet.service.ShoppingCartService;
import com.hans.shilipiaoxiang.json.Result;
import com.hans.shilipiaoxiang.json.ResultType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "购物车模块")
@RequestMapping("json/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "添加商品到购物车")
    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public void addGoods(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer cartId=data.getInteger("cartId");
        Integer goodId=data.getInteger("goodId");
        Integer num=data.getInteger("num");
        Double price=data.getDouble("price");
        Integer total=data.getInteger("total");
        System.out.println(data);
        boolean flag=false;
        if(num==1){
            flag=shoppingCartService.insertGood(cartId,goodId,price,total);
        }else {
            flag=shoppingCartService.addGood(cartId,goodId,num,price,total);
        }
        if(flag==true){
            String json;
            json = Result.build(ResultType.Success).appendData("flag",flag).convertIntoJSON();
            response.getWriter().write(json);
        }

    }

    @ApiOperation(value = "删除购物车的商品")
    @RequestMapping(value = "/subGoods", method = RequestMethod.POST)
    public void subGoods(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer cartId=data.getInteger("cartId");
        Integer goodId=data.getInteger("goodId");
        Integer num=data.getInteger("num");
        Double price=data.getDouble("price");
        Integer total=data.getInteger("total");
        boolean flag=false;
        if(num==0){
            flag=shoppingCartService.deleteGood(cartId,goodId);
        }else {
            flag=shoppingCartService.subGood(cartId,goodId,num,price,total);
        }
        if(flag==true){
            String json;
            json = Result.build(ResultType.Success).appendData("flag",flag).convertIntoJSON();
            response.getWriter().write(json);
        }

    }

    @ApiOperation(value = "获取商品（购物车）")
    @RequestMapping(value = "/showCartGoods", method = RequestMethod.POST)
    public void showCartGoods(@RequestBody JSONObject res,HttpServletResponse response) throws IOException {
        Integer cartId=res.getInteger("cartId");
        List<CGoodsTypes> goods =new ArrayList<>();
        CGoodsTypes saleGoods;
        saleGoods=goodsService.getSaleGoods();
        goods=goodsService.getGoods();
        goods.add(0,saleGoods);
        response.setContentType("application/json;charset=utf-8");
        List<CCartGoods> cCartGoodsList=shoppingCartService.getCartGoods(cartId);
        int total=0;
        double price=0;
        for(int i=0;i<cCartGoodsList.size();i++){
            CCartGoods cCartGoods=cCartGoodsList.get(i);
            int num=cCartGoods.getNum();
            CGoods cGoods=cCartGoods.getcGoods();
            double goodPrice=cGoods.getPrice();
            price=goodPrice*num+price;
            int id=cGoods.getId();
            int typeId=cGoods.getTypeId();
            CGoodsTypes cGoodsTypes=goods.get(typeId-2);
            total=num+total;
            int info=cGoodsTypes.getInfo();
            cGoodsTypes.setInfo(num+info);
            List<CGoods> cGoodsList=cGoodsTypes.getcGoods();
            for(CGoods g:cGoodsList){
                if(g.getId()==id){
                    g.setNum(num);
                }
            }
        }
        System.out.println(price);
        System.out.println(total);
        JSONObject data = new JSONObject();
        data.put("goods",goods);
        data.put("price",price);
        data.put("total",total);
        String json;
        json = Result.build(ResultType.Success).appendData("data", data).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "结算商品（购物车）")
    @RequestMapping(value = "/commitCartGoods", method = RequestMethod.POST)
    public void commitCartGoods(@RequestBody JSONObject res,HttpServletResponse response) throws IOException {
        Integer cartId=res.getInteger("cartId");
        response.setContentType("application/json;charset=utf-8");
        List<CGoods> cGoodsList=shoppingCartService.getCommitCartGoods(cartId);
        int total=0;
        double price=0;
        for(int i=0;i<cGoodsList.size();i++){
            CGoods cGoods=cGoodsList.get(i);
            double goodPrice=cGoods.getPrice();
            int num=cGoods.getNum();
            price=goodPrice*num+price;
            total=num+total;
        }
        System.out.println(price);
        System.out.println(total);
        JSONObject data = new JSONObject();
        data.put("goods",cGoodsList);
        data.put("price",price);
        data.put("total",total);
        String json;
        json = Result.build(ResultType.Success).appendData("data", data).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "清空购物车")
    @RequestMapping(value = "/deleteCartGoods", method = RequestMethod.POST)
    public void deleteCartGoods(@RequestBody JSONObject res,HttpServletResponse response) throws IOException {
        Integer cartId=res.getInteger("cartId");
        response.setContentType("application/json;charset=utf-8");
        boolean flag=shoppingCartService.deleteCartGoods(cartId);
        String json;
        json = Result.build(ResultType.Success).appendData("flag", flag).convertIntoJSON();
        response.getWriter().write(json);
    }
}
