package com.hans.shilipiaoxiang.work.service;

import com.hans.shilipiaoxiang.publicservice.pojo.IServiceTimer;

import java.util.Date;
import java.util.List;

public interface ServiceTimerService {
    //获取ServiceTimer并且检测更新
    IServiceTimer getOne(int serviceId);
    //转换成Long时间表
    Long toTimer(IServiceTimer timer);
    //添加订单时更新时间表
    boolean changeTimer(IServiceTimer timer, Date date, int type);
    //获取List<Integer>
    List<Integer> getlist(int serviceId);
    //装成能用的时间表列表
    List<Integer> toTimerList(Long value, int serviceId);
    //修改员工
    boolean changeStaff(int serviceId, int num);
}
