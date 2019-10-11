package com.shixun.ihome.work.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shixun.ihome.json.Result;
import com.shixun.ihome.json.ResultType;
import com.shixun.ihome.publicservice.pojo.IDetailtype;
import com.shixun.ihome.publicservice.pojo.IServicetype;
import com.shixun.ihome.work.service.ServicetypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Api(description = "服务模块")
@RequestMapping("json/order")
public class ServicetypeController {
    @Autowired
    private ServicetypeService servicetypeService;

    @ApiOperation(value = "服务类型页面数据")
    @ResponseBody
    @RequestMapping(value = "/servicelist",method = RequestMethod.POST)
    public void service(@RequestParam int serviceid, HttpServletResponse response)throws IOException {
        IServicetype servicetype=servicetypeService.selectByid(serviceid);
        response.setContentType("application/json;charset=utf-8");
        String json ;
        json = Result.build(ResultType.Success).appendData("servicetype", servicetype).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "详细类型页面数据")
    @ResponseBody
    @RequestMapping(value = "/typelist",method = RequestMethod.POST)
    public void servicetype(@RequestParam int typeid, HttpServletResponse response)throws IOException {
        IDetailtype detailtype =servicetypeService.selectBytypeid(typeid);
        response.setContentType("application/json;charset=utf-8");
        String json ;
        json = Result.build(ResultType.Success).appendData("detailtype", detailtype).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "查找服务详细类别")
    @ResponseBody
    @RequestMapping(value = "/selectBytypename",method = RequestMethod.POST)
    public void selectTypename(@RequestBody JSONObject name, HttpServletResponse response)throws IOException{
        String typename=name.getString("typename");
        System.out.println(typename);
        List<IDetailtype> listd=servicetypeService.selectByname(typename);
        response.setContentType("application/json;charset=utf-8");

        String json ;
        json = Result.build(ResultType.Success).appendData("listd", listd).convertIntoJSON();
        response.getWriter().write(json);
        System.out.println(json);

//        String jsonStr = JSON.toJSONString(listd);
//        System.out.println(jsonStr);
//        return jsonStr;
    }

    @ApiOperation(value = "根据服务大类分类")
    @ResponseBody
    @RequestMapping(value = "/selectByserviceid",method = RequestMethod.POST)
    public void selectServiceid(@RequestBody JSONObject name, HttpServletResponse response)throws IOException{
       // String serviceid=name.getString("serviceid");
        int id=name.getInteger("serviceid");
        //int id=Integer.parseInt(serviceid);
        System.out.println(id);
        List<IDetailtype> listss=servicetypeService.selectByServicetypeid(id);
        response.setContentType("application/json;charset=utf-8");

        String json ;
        json = Result.build(ResultType.Success).appendData("listss", listss).convertIntoJSON();
        response.getWriter().write(json);
        System.out.println(json);

    }


}