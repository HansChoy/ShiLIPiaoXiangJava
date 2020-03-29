package com.hans.shilipiaoxiang.applet.controller;

import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypes;
import com.hans.shilipiaoxiang.applet.pojo.CShoppingCart;
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
//        System.out.println(data);
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
            flag=shoppingCartService.deleteGood(cartId,goodId,price,total);
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
        int j=0;
        for(CGoods c:saleGoods.getcGoods()){
            c.setDesc("月售"+c.getAmount()+"份");
            c.setTag("折");
            int index=c.getTypeId()-3;
            List<CGoods> cGoodsList=goods.get(index).getcGoods();
            int i=0;
            for(CGoods a:cGoodsList){
                if(c.getId()==a.getId()){
                    c.setIndex(i);
                    a.setIndex(j);
                }
                i++;
            }
            j++;
        }
        for(CGoodsTypes c:goods){
            for(CGoods cGoods:c.getcGoods()){
                if(cGoods.getIfsale()==1){
                    cGoods.setTag("折");
                }
                cGoods.setDesc("月售"+cGoods.getAmount()+"份");
            }
        }
        goods.add(0,saleGoods);
        response.setContentType("application/json;charset=utf-8");
        List<CCartGoods> cCartGoodsList=shoppingCartService.getCartGoods(cartId);
        for(int i=0;i<cCartGoodsList.size();i++){
            CCartGoods cCartGoods=cCartGoodsList.get(i);
            int num=cCartGoods.getNum();
            CGoods cGoods=cCartGoods.getcGoods();
            double goodPrice=cGoods.getPrice();
            int id=cGoods.getId();
            int typeId=cGoods.getTypeId();
            CGoodsTypes cGoodsTypes=goods.get(typeId-2);
            if(cGoods.getIfsale()!=1){
                int info=cGoodsTypes.getInfo();
                cGoodsTypes.setInfo(num+info);
            }else{
                int info=saleGoods.getInfo();
                saleGoods.setInfo(num+info);
            }
            List<CGoods> cGoodsList=cGoodsTypes.getcGoods();
            for(CGoods g:cGoodsList){
                if(g.getId()==id&&g.getIfsale()==1){
                    g.setNum(num);
                    saleGoods.getcGoods().get(g.getIndex()).setNum(num);
                }else if(g.getId()==id){
                    g.setNum(num);
                }
            }
        }
        CShoppingCart cShoppingCart=shoppingCartService.getPriceAndTotal(cartId);
        JSONObject data = new JSONObject();
        data.put("goods",goods);
        data.put("price",cShoppingCart.getPrice());
        data.put("total",cShoppingCart.getTotal());
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
        int i=0;
        for(CGoods c:cGoodsList){
            if(c.getIfsale()==1){
                c.setTag("折");
            }
        }
        CShoppingCart cShoppingCart=shoppingCartService.getPriceAndTotal(cartId);
        JSONObject data = new JSONObject();
        data.put("goods",cGoodsList);
        data.put("price",cShoppingCart.getPrice());
        data.put("total",cShoppingCart.getTotal());
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

    @ApiOperation(value = "商品详情（购物车）")
    @RequestMapping(value = "/getCartGoodsDetail", method = RequestMethod.POST)
    public void getCartGoodsDetail(@RequestBody JSONObject res,HttpServletResponse response) throws IOException {
        Integer cartId=res.getInteger("cartId");
        Integer goodId=res.getInteger("goodId");
        response.setContentType("application/json;charset=utf-8");
        CGoods cGoods=goodsService.getGoodDetail(goodId);
        CShoppingCart cShoppingCart=shoppingCartService.getPriceAndTotal(cartId);
        int total=0;
        double price=0;
        total=cShoppingCart.getTotal();
        price=cShoppingCart.getPrice();
        CCartGoods cCartGoods=shoppingCartService.getNum(cartId,goodId);
        if(cCartGoods!=null){
            cGoods.setNum(cCartGoods.getNum());
        }
        JSONObject data = new JSONObject();
        data.put("goods",cGoods);
        data.put("price",price);
        data.put("total",total);
        String json;
        json = Result.build(ResultType.Success).appendData("data", data).convertIntoJSON();
        response.getWriter().write(json);
    }
}
