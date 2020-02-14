package com.hans.shilipiaoxiang.work.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.config.ApiJsonObject;
import com.hans.shilipiaoxiang.config.ApiJsonProperty;
import com.hans.shilipiaoxiang.json.Result;
import com.hans.shilipiaoxiang.json.ResultBase;
import com.hans.shilipiaoxiang.json.ResultType;
import com.hans.shilipiaoxiang.publicservice.pojo.IDetailtype;
import com.hans.shilipiaoxiang.publicservice.pojo.IServicetype;
import com.hans.shilipiaoxiang.work.service.ServicetypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Api(description = "服务模块")
@RequestMapping("json/order")
public class ServicetypeController {
    @Autowired
    private ServicetypeService servicetypeService;

    @ApiOperation(value = "服务类型页面数据")
    @RequestMapping(value = "/servicelist",method = RequestMethod.POST)
    public void service(@RequestBody JSONObject name, HttpServletResponse response)throws IOException {
        int typeid=name.getInteger("typeid");
        IServicetype servicetype=servicetypeService.selectByid(typeid);
        response.setContentType("application/json;charset=utf-8");
        String json ;
        json = Result.build(ResultType.Success).appendData("servicetype", servicetype).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "详细类型页面数据")
    @RequestMapping(value = "/typelist",method = RequestMethod.POST)
    public void servicetype(@RequestBody JSONObject name, HttpServletResponse response)throws IOException {
        int id=name.getInteger("id");
        IDetailtype detailtype =servicetypeService.selectBytypeid(id);
        response.setContentType("application/json;charset=utf-8");
        String json ;
        json = Result.build(ResultType.Success).appendData("detailtype", detailtype).convertIntoJSON();
        response.getWriter().write(json);
    }

    @ApiOperation(value = "查找服务详细类别")
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
    }

    @ApiOperation(value="查找服务详细类别测试")
    @RequestMapping(value = "/selectBytypenameTest", method = RequestMethod.POST)
    public ResultBase selectTypenameTest(@ApiJsonObject(name = "params2", value={
            @ApiJsonProperty(key = "typename", example = "清洁工", description = "服务类型名称"),
    })@RequestBody  Map<String, Object> params2) {
        String typename = (String)params2.get("typename");
        System.out.println(typename);
        List<IDetailtype> listd = servicetypeService.selectByname(typename);
        return ResultBase.success(listd);
    }

    @ApiOperation(value = "根据服务大类分类")
    @RequestMapping(value = "/selectByserviceid",method = RequestMethod.POST)
    public void selectServiceid(@RequestBody JSONObject name, HttpServletResponse response)throws IOException{
       // String serviceid=name.getString("serviceid");
        int typeid=name.getInteger("typeId");
        List<IDetailtype> listss=new ArrayList<>();
        if(typeid!=0) {

            listss = servicetypeService.selectByServicetypeid(typeid);
        }else {
            listss = servicetypeService.selectAll();
        }
        response.setContentType("application/json;charset=utf-8");
        String json ;
        json = Result.build(ResultType.Success).appendData("listss", listss).convertIntoJSON();
        response.getWriter().write(json);
        System.out.println(json);
    }

    @ApiOperation(value = "根据服务大类分类测试")
    @RequestMapping(value = "/selectByserviceidTest",method = RequestMethod.POST)
    public ResultBase selectServiceidTest(@ApiJsonObject(name = "params1", value = {
            @ApiJsonProperty(key = "serviceid", example = "1", description = "服务id"),
    }) @RequestBody Map<String, String> params1){
        int id = Integer.parseInt(params1.get("serviceid"));
        System.out.println(id);
        List<IDetailtype> listss = servicetypeService.selectByServicetypeid(id);
        JSONArray arr = new JSONArray();
        for (IDetailtype detail:listss) {
            JSONObject object = new JSONObject(3);
            object.put("label", detail.getTypename());
            object.put("value",detail.getId());
            object.put("leaf", true);
            arr.add(object);
        }
        return ResultBase.success(arr);
    }


    @ApiOperation(value = "根据详细服务类id获取详细服务类")
    @GetMapping("/getDetailsBydetailId/{detailId}")
    @ApiImplicitParam(name = "detailId", value = "1", required = true, paramType = "path", dataType = "int")
    public ResultBase getDetailsBydetailId(@PathVariable int detailId){
        List<IDetailtype> list = servicetypeService.getDetailsByDetailId(detailId);
        JSONObject data= new JSONObject(2);
        JSONArray arr = new JSONArray();
        for (IDetailtype detail:list) {
            JSONObject object = new JSONObject(3);
            object.put("label", detail.getTypename());
            object.put("value",detail.getId());
            object.put("leaf", true);
            arr.add(object);
        }
        data.put("arr",arr);
        data.put("index",list.get(0).getServicetpyeId());
        return ResultBase.success(data);
    }
}
