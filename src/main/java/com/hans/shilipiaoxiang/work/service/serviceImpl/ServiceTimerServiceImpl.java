package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IServiceTimerMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IServiceTimer;
import com.hans.shilipiaoxiang.publicservice.util.Qutil;
import com.hans.shilipiaoxiang.work.service.ServiceTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ServiceTimerServiceImpl implements ServiceTimerService {
    @Autowired
    private IServiceTimerMapper serviceTimerMapper;
    @Override
    public IServiceTimer getOne(int serviceId) {
        //获取时间表
        IServiceTimer iServiceTimer = serviceTimerMapper.selectByPrimaryKey(serviceId);
        Date updateTimer = iServiceTimer.getUpdatetimer();
        Date now = new Date();
        if(!Qutil.assertDate(updateTimer, now)){
            //如果日期不同
            //执行时间表更新
            now = Qutil.removeTimer(now);
            iServiceTimer.setUpdatetimer(now);
            List<Integer> timers = timerSpilt(iServiceTimer.getAdate());
            timers = updateTimer(timers,Qutil.consumDays(now, updateTimer), 6);
            iServiceTimer.setAdate(toText(timers));
            //更新时间表
            int result = serviceTimerMapper.updateByPrimaryKeySelective(iServiceTimer);

        }
        return  iServiceTimer;
    }

    @Override
    public Long toTimer(IServiceTimer timer) {
        int staffNum = timer.getStaffnum();
        int num = timer.getNum();
        double index = timer.getAindex();
        int result = (int)((staffNum * num * index )/6);
        List<Integer> list = timerSpilt(timer.getAdate());
        Collections.reverse(list);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i  = 0; i < list.size(); i++){
            stringBuffer.append(list.get(i) <= result?0:1);
        }
        return Long.parseLong(stringBuffer.toString(), 2);
    }

    public List<Integer> toTimerList(Long value, int serviceId){
        int pos = 63;
        int index = 6;
        List<Integer> list = new ArrayList<>();
       for(int i = 0; i < 8; i++) {
           list.add((int)((value >> (i* index)) & pos));
       }
       return list;
    }

    @Override
    public boolean changeTimer(IServiceTimer timer, Date date, int type) {
        //计算日期
        Date now = new Date();
        int day = Qutil.consumDays(now , date);
        //计算所占的格
        int s = Qutil.getTimer(date);
        List<Integer> list = timerSpilt(timer.getAdate());
        int pos = 6;
        int index = day * pos + s - 1;
        int value = list.get(index);
        list.set(index, value + type);
        timer.setAdate(toText(list));
        serviceTimerMapper.updateByPrimaryKeySelective(timer);
        return true;
    }

    @Override
    public List<Integer> getlist(int serviceId) {
        IServiceTimer serviceTimer = getOne(serviceId);
        List<Integer> list = timerSpilt(serviceTimer.getAdate());
        return list;
    }

    @Override
    public boolean changeStaff(int serviceId, int num) {
        IServiceTimer serviceTimer = getOne(serviceId);
        int staffNum = serviceTimer.getStaffnum();
        serviceTimer.setStaffnum(staffNum + num);
        int result = serviceTimerMapper.updateByPrimaryKeySelective(serviceTimer);
        if (result > 0)return true;
        else throw new RuntimeException("修改员工失败");
    }


    //-----------------------------------------------------------------------------------------------------

    //转换成List<integer>
    private List<Integer> timerSpilt(String text){
        String [] s = text.split("\\|");
        List<Integer> timers = new ArrayList<>();
        for (String s1 :s) {
            Integer i = Integer.parseInt(s1);
            timers.add(i);
        }
        if(timers.size() != 48){
            throw new RuntimeException("时间分割存在问题");
        }
        return timers;
    }
    //将list转String
    private String toText(List<Integer>timers){
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < timers.size(); i++){
            s.append(timers.get(i));
            s.append('|');
        }
        return s.substring(0, s.length()-1);
    }
    //更新天数
    private List<Integer> updateTimer(List<Integer> timers, int day, int pos){
        List<Integer> newTimers = new ArrayList<>();
        int start =  timers.size() - day * pos ;

        //前部添加0
        for ( int i = 0 ; i < day * pos ; i++){
            newTimers.add(0);
        }
        //将旧数据转移到新list中
        for (int i  = 0; i < start; i++){
            newTimers.add(timers.get(i));
        }
        if (newTimers.size() != 48){
            throw new RuntimeException("更新日期存在问题");
        }
        return newTimers;

    }



}
