package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.ITimerMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IServiceTimer;
import com.hans.shilipiaoxiang.publicservice.pojo.LabelValue;
import com.hans.shilipiaoxiang.publicservice.pojo.RedisTimerInfo;
import com.hans.shilipiaoxiang.work.service.RedisTimerService;
import com.hans.shilipiaoxiang.work.service.ServiceTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisTimerServiceImpl implements RedisTimerService {
    @Autowired
    private ITimerMapper timerMapper;
    @Autowired
    private ServiceTimerService serviceTimerService;

    @Override
    public List<RedisTimerInfo> getMessageOther(Integer serviceID) {
        //获取时间表
        IServiceTimer serviceTimer = serviceTimerService.getOne(serviceID);
        List<Integer> timers = serviceTimerService.toTimerList(serviceTimerService.toTimer(serviceTimer), serviceTimer.getServicelid());
        System.out.println(timers);
        List<RedisTimerInfo> timerInfos = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        for ( int i = 1; i <= 7; i++){
            //获取时间
            int t = timers.get(i);
            if (t != 1){
                RedisTimerInfo redisTimerInfo = new RedisTimerInfo();
                String weekDay = toWeekDay(calendar);
                int pos = weekDay.indexOf("(");
                String value = weekDay.substring(0,pos);
                redisTimerInfo.setDate(weekDay);
                redisTimerInfo.setValue(value);
                List<LabelValue> time = null;
                time = toTimersOther(t,value);
                redisTimerInfo.setTimer(time);
                timerInfos.add(redisTimerInfo);
            }
            calendar.add(Calendar.DAY_OF_MONTH ,1);
        }


        return timerInfos;
    }

    @Override
    public List<RedisTimerInfo> getMessage(Integer serviceId, Integer hours) {
        //获取时间表
        IServiceTimer serviceTimer = serviceTimerService.getOne(serviceId);
        List<Integer>  timers = serviceTimerService.toTimerList(serviceTimerService.toTimer(serviceTimer), serviceTimer.getServicelid());
        System.out.println(timers);
        List<RedisTimerInfo> timerInfos = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        for ( int i = 1; i <= 7; i++){
            //获取时间
            int t = timers.get(i);
            //判读时间表是否为满 63:二进制111111
            if (t != 63){
                RedisTimerInfo redisTimerInfo = new RedisTimerInfo();
                String weekDay = toWeekDay(calendar);
                int pos = weekDay.indexOf('(');
                String value = weekDay.substring(0, pos);
                redisTimerInfo.setDate(weekDay);
                redisTimerInfo.setValue(value);
                List<LabelValue> time = null;
                time = toTimers(t, hours, value);
                redisTimerInfo.setTimer(time);
                timerInfos.add(redisTimerInfo);
            }
            calendar.add(Calendar.DAY_OF_MONTH  ,1);
        }
        return timerInfos;
    }

    private List<LabelValue> toTimersOther(int timer, String date){
        List<LabelValue> timers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE ,0);
        for (int i = 0; i <= 5; i++){
            int t =( timer >> i) &1;
            if(t == 0){
                for (int j= 0; j< 4;j++){
                    if(!checkTimer(calendar, 0, 18))break;
                    String label = String.format("%d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
                    LabelValue labelValue = new LabelValue(label, date + " " +  label);
                    timers.add(labelValue);
                    calendar.add(Calendar.MINUTE, 30);
                }
            }else{
                calendar.add(Calendar.HOUR_OF_DAY,2);
            }

            if(!checkTimer(calendar, 0, 18))break;
        }
        return timers;
    }



    //将时间分割
    private List<Integer> timeSpilt(Long timer, Integer type){
        System.out.println(timer);
        List<Integer> timers = new ArrayList<>();
        int index = 1;
        int pos = 1;
        if (type == 0){
            //钟点工
            index = 6;
            pos = 63;
        }
        for (int i = 1; i <= 8; i++){
            System.out.println(Long.toBinaryString(timer));
            timers.add( (int)(timer & pos) );//获取6位数字
            timer = timer >>index;
        }
        return timers;
    }


    private List<LabelValue> toTimers(int timer, int hours, String date){
        List<LabelValue> timers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);

        for (int i =0; i <= 5;i++){
          int t = (timer >> i) & 1;
          if(t == 0){
              for (int j = 0; j < 4; j++){
                  if(!checkTimer(calendar, hours, 20))break;
                  int hour = calendar.get(Calendar.HOUR_OF_DAY);
                  int min = calendar.get(Calendar.MINUTE);
                  String startTime= String.format("%d:%02d",hour, min);
                  String endTime = String.format("%d:%02d", hour + hours, min);
                  String value = date +" "+ startTime+ "|" + date + " " + endTime;
                  LabelValue labelValue = new LabelValue(startTime+"-"+endTime, value);
                  timers.add(labelValue);
                  calendar.add(Calendar.MINUTE, 30);
              }
          }else{
              calendar.add(Calendar.HOUR_OF_DAY,2);
          }
          if(!checkTimer(calendar, 2, 20)){
              break;
          }


        }
        return timers;
    }

    private boolean checkTimer(Calendar calendar, int hours, int maxhours){
        int current = calendar.get(Calendar.HOUR_OF_DAY) + (calendar.get(Calendar.MINUTE) > 0?1:0);
        if (hours + current > maxhours){
            return false;
        }
        return true;
    }

    private String toWeekDay(Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String s = null;
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 2: s = "周一";break;
            case 3: s = "周二";break;
            case 4: s = "周三";break;
            case 5: s = "周四";break;
            case 6: s = "周五";break;
            case 7: s = "周六";break;
            case 1: s = "周日";break;
        }
        return String.format("%d年%d月%d日(%s)", year, month, day, s);
    }
}
