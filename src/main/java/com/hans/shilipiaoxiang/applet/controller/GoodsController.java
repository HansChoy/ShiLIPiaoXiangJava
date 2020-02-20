package com.hans.shilipiaoxiang.applet.controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hans.shilipiaoxiang.config.ApiJsonObject;
import com.hans.shilipiaoxiang.json.Result;
import com.hans.shilipiaoxiang.json.ResultBase;
import com.hans.shilipiaoxiang.json.ResultType;
import com.hans.shilipiaoxiang.applet.pojo.*;
import com.hans.shilipiaoxiang.config.ApiJsonProperty;
import com.hans.shilipiaoxiang.applet.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Api(description = "商品模块")
@RequestMapping("json/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "显示所有商品")
    @RequestMapping(value = "/showGoods", method = RequestMethod.GET)
    public void showGoods(HttpServletResponse response) throws IOException {
        List<CGoodsTypes> goods =new ArrayList<>();
        CGoodsTypes saleGoods;
        saleGoods=goodsService.getSaleGoods();
        goods=goodsService.getGoods();
        goods.add(0,saleGoods);
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("goods", goods).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "显示商品详情")
    @RequestMapping(value = "/showGoodDetail", method = RequestMethod.POST)
    public void showGoodDetail(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Integer id=data.getInteger("id");
        CGoods cGoods=goodsService.getGoodDetail(id);
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("cGoods", cGoods).convertIntoJSON();
        response.getWriter().write(json);
    }
}
