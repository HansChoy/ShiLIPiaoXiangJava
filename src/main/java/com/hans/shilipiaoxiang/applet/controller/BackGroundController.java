package com.hans.shilipiaoxiang.applet.controller;

import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.service.backGroundService;
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
import java.util.List;

@RestController
@Api(description = "后台模块")
@RequestMapping("json/background")
public class BackGroundController {
    @Autowired
    private backGroundService backGroundService;
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void showGoodDetail(@RequestBody JSONObject data, HttpServletResponse response) throws IOException {
        String username=data.getString("username");
        String password=data.getString("password");
        CAdmin cAdmin=backGroundService.login(username);
        boolean flag=false;
        if(password.equals(cAdmin.getPassword())){
            flag=true;
        }
        JSONObject list = new JSONObject();
        list.put("flag",flag);
        list.put("CAdmin",cAdmin);
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("data", list).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "获取商品信息")
    @RequestMapping(value = "/showGoods", method = RequestMethod.GET)
    public void showGoodDetail(HttpServletResponse response) throws IOException {

        List<CGoods> cGoodsList=backGroundService.showGoods();
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("data", cGoodsList).convertIntoJSON();
        response.getWriter().write(json);
    }
}
