//package com.shixun.ihome.hourwork.controller;
//
//
//import com.shixun.ihome.hourwork.service.HourworkToolService;
//import com.shixun.ihome.publicservice.pojo.ITool;
//import com.shixun.ihome.publicservice.pojo.IToolrecord;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@Api(description = "工具控制器")
//@RequestMapping("json/hourwork/tool")
//public class HourworkToolController {
//    @Autowired
//    private HourworkToolService toolService;
//
//    @ApiOperation("获取工具列表")
//    @ResponseBody
//    @RequestMapping("selectTools")
//    public List<ITool> selectTools(){
//        return toolService.selectTools();
//    }
//
//    @ApiOperation("获取工具")
//    @ApiImplicitParam(name="iToolrecord", required = true, dataType = "IToolrecord")
//    @ResponseBody
//    @RequestMapping("getTools")
//    public Object getTools(IToolrecord iToolrecord){
//        return toolService.getTool(iToolrecord);
//    }
//
//    @ApiOperation("归还工具")
//    @ApiImplicitParam(name="iToolrecord", required = true, dataType = "IToolrecord")
//    @ResponseBody
//    @RequestMapping("returnTools")
//    public Object returnTools(IToolrecord iToolrecord){
//        //检测是否有工具Id，有就是一键归还
//        Integer orderId = iToolrecord.getOrderId();
//        if (orderId != null) {
//            List<IToolrecord> iToolrecords = toolService.selectToolsByOrderId(orderId);
//            try{
//                for (IToolrecord record: iToolrecords
//                ) {
//                    toolService.returnTool(record);
//                }
//            }catch (Exception e){
//                return false;
//            }
//        }
//        return toolService.returnTool(iToolrecord);
//    }
//    @ApiOperation("损害工具报备")
//    @ApiImplicitParam(name="iToolrecord", required = true, dataType = "IToolrecord")
//    @ResponseBody
//    @RequestMapping("brokenTool")
//    public Object brokenTool(IToolrecord iToolrecord){
//        return toolService.brokenTool(iToolrecord);
//    }
//}
