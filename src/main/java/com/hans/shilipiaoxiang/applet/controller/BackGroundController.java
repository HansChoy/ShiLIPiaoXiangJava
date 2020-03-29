package com.hans.shilipiaoxiang.applet.controller;

import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.applet.Select.AmountResult;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.COrder;
import com.hans.shilipiaoxiang.applet.Select.SelectParams;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "后台模块")
@RequestMapping("json/background")
public class BackGroundController {
    @Autowired
    private backGroundService backGroundService;
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody JSONObject data, HttpServletResponse response) throws IOException {
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
    public void showGoods(HttpServletResponse response) throws IOException {
        List<CGoods> cGoodsList=backGroundService.showGoods();
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("data", cGoodsList).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "获取商品信息")
    @RequestMapping(value = "/showAmount", method = RequestMethod.POST)
    public void showAmount(@RequestBody JSONObject data,HttpServletResponse response) throws IOException {
        Long startTime=data.getLong("startTime");
        Long endTime=data.getLong("endTime");
        int typeId=data.getInteger("typeId");
        SelectParams selectParams=new SelectParams();
        selectParams.setStartTime(startTime);
        selectParams.setEndTime(endTime);
        selectParams.setTypeId(typeId);
        List<AmountResult> AmountResult=backGroundService.showAmout(selectParams);
        List<String> labels=new ArrayList<>();
        List<Integer> res1=new ArrayList<>();
        List<Double> res2=new ArrayList<>();
        JSONObject list=new JSONObject();
        JSONObject list1=new JSONObject();
        JSONObject list2=new JSONObject();
        if(typeId==0){
            labels.add("汤面");
            labels.add("饭类");
            labels.add("小炒");
            labels.add("饮品");
            labels.add("老火靓汤");
            labels.add("小食");
            list1.put("labels",labels);
            list1.put("type","bar");
            list2.put("labels",labels);
            list2.put("type","bar");
            JSONObject title1=new JSONObject();
            title1.put("text","各品类销量图");
            list1.put("title",title1);
            JSONObject title2=new JSONObject();
            title2.put("text","各品类销售金额图");
            list2.put("title",title2);
            for(int i=0;i<5;i++){
                res1.add(0);
                res2.add(0.0);
            }
            for(AmountResult a:AmountResult){
                res1.set(a.getTypeId()-3,a.getNum());
                res2.set(a.getTypeId()-3,a.getPrice());
            }
            List<JSONObject> datasets1=new ArrayList<>();
            JSONObject dataset1=new JSONObject();
            dataset1.put("label","销量(单位:份)");
            dataset1.put("data",res1);
            datasets1.add(dataset1);
            list1.put("datasets",datasets1);
            List<JSONObject> datasets2=new ArrayList<>();
            JSONObject dataset2=new JSONObject();
            dataset2.put("label","销售金额(单位:元)");
            dataset2.put("data",res2);
            datasets2.add(dataset2);
            list2.put("datasets",datasets2);
            list.put("options1",list1);
            list.put("options2",list2);
        }else{
           List<CGoods> cGoodsList=backGroundService.showGoodsName(typeId);
           int i=0;
           for(CGoods c:cGoodsList){
                labels.add(c.getTitle());
                res1.add(0);
                res2.add(0.0);
                for(AmountResult a:AmountResult){
                    if(a.getTypeId()==c.getId()){
                        res1.set(i,a.getNum());
                        res2.set(i,a.getPrice());
                        break;
                    }
                }
                i++;

           }
           list1.put("labels",labels);
           list1.put("type","bar");
           list2.put("labels",labels);
           list2.put("type","bar");
           JSONObject title1=new JSONObject();
           title1.put("text","商品销售量图");
           list1.put("title",title1);
           JSONObject title2=new JSONObject();
           title2.put("text","各品类销售金额图");
           list2.put("title",title2);
           List<JSONObject> datasets1=new ArrayList<>();
           JSONObject dataset1=new JSONObject();
           dataset1.put("label","销量(单位:份)");
           dataset1.put("data",res1);
           datasets1.add(dataset1);
           list1.put("datasets",datasets1);
           List<JSONObject> datasets2=new ArrayList<>();
           JSONObject dataset2=new JSONObject();
           dataset2.put("label","销售金额(单位:元)");
           dataset2.put("data",res2);
           datasets2.add(dataset2);
           list2.put("datasets",datasets2);
           list.put("options1",list1);
           list.put("options2",list2);
        }
        response.setContentType("application/json;charset=utf-8");
        String json;
        json = Result.build(ResultType.Success).appendData("data", list).convertIntoJSON();
        response.getWriter().write(json);
    }
}
