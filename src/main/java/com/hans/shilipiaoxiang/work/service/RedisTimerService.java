package com.hans.shilipiaoxiang.work.service;

import com.hans.shilipiaoxiang.publicservice.pojo.RedisTimerInfo;

import java.util.List;

//用于redis存储人员安排的信息
public interface RedisTimerService {
    //动态生成前端需要的时间表(钟点工）
    List<RedisTimerInfo> getMessage(Integer serviceId, Integer hours);
    //动态生成其他员工可选时间
    List<RedisTimerInfo> getMessageOther(Integer serviceId);
}
