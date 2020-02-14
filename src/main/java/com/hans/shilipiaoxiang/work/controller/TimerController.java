package com.hans.shilipiaoxiang.work.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hans.shilipiaoxiang.config.ApiJsonObject;
import com.hans.shilipiaoxiang.config.ApiJsonProperty;
import com.hans.shilipiaoxiang.json.ResultBase;
import com.hans.shilipiaoxiang.publicservice.pojo.IStaff;
import com.hans.shilipiaoxiang.publicservice.pojo.RedisTimerInfo;
import com.hans.shilipiaoxiang.publicservice.util.Qutil;
import com.hans.shilipiaoxiang.work.service.RedisTimerService;
import com.hans.shilipiaoxiang.work.service.ServicetypeService;
import com.hans.shilipiaoxiang.work.service.TimeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "时间表模块",description = "时间表相关")
@RequestMapping("/json/timer")
public class TimerController {
    @Autowired
    private RedisTimerService redisTimerService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private ServicetypeService servicetypeService;

    @ApiOperation(value="动态生成可选日期和时间")
    @PostMapping("/getMessage")
    public ResultBase getMessage(@ApiJsonObject( name = "name",value = {
            @ApiJsonProperty(key="hours", example = "2", description = "时间"),
            @ApiJsonProperty(key = "serviceId", example = "1"),
            @ApiJsonProperty(key = "type", example = "0", description = "默认未0如果未1就返回只有上面时间")
    })@RequestBody JSONObject name){
        int serviceId = name.getInteger("serviceId");
        Integer type = name.getInteger("type");
        if (type != null && type == 1){
            List<RedisTimerInfo> timerInfos = redisTimerService.getMessageOther(serviceId);
            return ResultBase.success(timerInfos);
        }
        int hours=name.getInteger("hours");
        if (hours > 8 || hours <= 0){
            return ResultBase.fail("时间超出可以选择的范围");
        }
        //获取类型
        List<RedisTimerInfo> timerInfo = redisTimerService.getMessage(serviceId,hours);
        return ResultBase.success(timerInfo);
    }

    @ApiOperation(value = "获取空闲员工")
    @PostMapping("/getFreeStaffs")
    public ResultBase getFreeStaffs(@ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(key = "startTime", example = "订单开始日期"),
            @ApiJsonProperty(key = "serviceId", example = "1"),
            @ApiJsonProperty(key = "pageSize", example = "10"),
            @ApiJsonProperty(key = "pageNum", example = "1"),
    })@RequestBody JSONObject params){
        Map<String, Object> map = new HashMap<>();
        Integer serviceId = params.getInteger("serviceId");
        Integer pageSize = params.getInteger("pageSize");
        Integer pageNum = params.getInteger("pageNum");
        String startTime = params.getString("startTime");
        Date startDate = Qutil.toDateTime(startTime);
        if(!Qutil.before(startDate)){
            return ResultBase.fail("当前订单已过期");
        }
        //作日期检测
        Integer index = Qutil.consumDays(new Date(),startDate);
        map.put("pageSize",pageSize);
        map.put("pageNum",pageNum);
        map.put("index", index);
        map.put("serviceId", serviceId);
        PageInfo<IStaff> pageInfo = null;
        if (serviceId != 1){
            int time = 63 ;
            map.put("time", time);
            //如果存在服务大类id不为1就是不是钟点工，就搜索其他员工
            pageInfo = timeService.selectStaffByFree(map);
        }else{
            int time = Qutil.getTimer(startDate);
            map.put("time", time);
            pageInfo = timeService.selectStaffByFree(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("data", pageInfo.getList());
        data.put("pageNum", pageInfo.getPageNum());
        data.put("pageSize", pageInfo.getPageSize());
        data.put("index", index);

        return ResultBase.success(data);
    }




}
