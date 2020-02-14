package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hans.shilipiaoxiang.publicservice.mapper.ITimerMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IOrder;
import com.hans.shilipiaoxiang.publicservice.pojo.ITimer;
import com.hans.shilipiaoxiang.publicservice.pojo.ITimerExample;
import com.hans.shilipiaoxiang.publicservice.util.Qutil;
import com.hans.shilipiaoxiang.work.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private ITimerMapper iTimerMapper;
    @Override
    public List<ITimer> selectFreeStaff(Date startTimer, Date endTimer) {
        //计算日期获得timer
        long timer = consumTimer(startTimer, endTimer);
        timer = timer << (timerLeft(startTimer) * 6);
        return iTimerMapper.selectFreeStaff(timer);
    }

    @Override
    public boolean updateTimerByOrder(int id, IOrder order, int serviceId) {
        //获取时间表
        ITimer timer1= getITimeByStaffId(id);
        Date now = new Date();
        int uTimer = Qutil.consumDays(now , timer1.getUpdateTime());
        long timer = timer1.getTimer();


        timer1.setUpdateTime(now);
        timer = timer >> (6 * uTimer);
        if(order.getFinalyTime() != null){
            long timer2 = consumTimer(order.getStartTime(), order.getFinalyTime());
            //计算订单的时间表
            //处理
            timer2 = worktimer(timer2);
            timer2 = timer2 << ((timerLeft(order.getStartTime()) ) * 6);
            //开始运算
            if ((timer & timer2) == 0){
                timer = (timer ^ timer2) & ITimerMapper.MAXTIMER;
            } else {
                throw new RuntimeException("该员工当前时间段没有空闲");
            }
        }else{
            //不是钟点工
            int t = 63 <<(Qutil.consumDays(order.getStartTime(), now) * 6 );
            if((timer & t) > 0){
                throw new RuntimeException("当前员工时间段没有空");
            }
            timer = (timer ^ t) & ITimerMapper.MAXTIMER;
        }

        timer1.setTimer(timer);

        if (iTimerMapper.updateByPrimaryKeySelective(timer1) == 0){
            throw new RuntimeException("时间表更新出错");
        }
        System.out.println(timer1);
        return true;
    }

    @Override
    public PageInfo selectStaffByFree(Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(iTimerMapper.selectStaffByFree(map));
        return pageInfo;
    }



    @Override
    public boolean removeTimerByOrder(int id, IOrder order, int serviceId) {
        //获取时间表
        ITimer timer = getITimeByStaffId(id);
        long timer1 = timer.getTimer();
        //更新时间表
        Date now = new Date();
        timer.setUpdateTime(now);
        //根据订单获得时间表
        if(order.getFinalyTime() != null){
            timer1 = timer1 << ( Qutil.consumDays(now, timer.getUpdateTime()) * 6);
            long timer2 = consumTimer(order.getStartTime(), order.getFinalyTime());
            timer2 = worktimer(timer2);
            timer2 = timer2 << ((timerLeft(order.getStartTime())) * 6);
            //开始运算
            timer1 =( timer1 & ~timer2) & ITimerMapper.MAXTIMER;
        }else{
            int t =  63 << (( Qutil.consumDays(order.getStartTime(), now)) * 6);
//            计算
            timer1 = (timer1 & ~t) & ITimerMapper.MAXTIMER;
        }

        System.out.println(timer1);
        //更新数据
        timer.setTimer(timer1);
        System.out.println(timer);
        if (iTimerMapper.updateByPrimaryKeySelective(timer) == 0){
            throw new RuntimeException("时间表更新出错");
        }

        return true;
    }


    @Override
    public String test(Date date1, Date date2) {
        int i = Qutil.consumDays(date1, date2);
        return  Integer.toString(i);
    }


    //更新时间表
    private boolean updateTime(Date date, long itimer, int id){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("updateTime", date);
        params.put("timer", itimer);
        params.put("staffId", id);
        if(iTimerMapper.updateStaffTime(params) == 0){
            throw new RuntimeException("时间表更新失败");
        }
        return true;
    }

    //根据员工Id获取该员工的时间表
    private ITimer getITimeByStaffId(int staffId){
        ITimerExample iTimerExample = new ITimerExample();
        ITimerExample.Criteria criteria = iTimerExample.createCriteria();
        criteria.andStaffIdEqualTo(staffId);
        ITimer iTimer = iTimerMapper.selectByExample(iTimerExample).get(0);
        return iTimer;
    }

    //安排工作时，下一格也默认标识为工作
    private long worktimer(long timer){
        timer = (((timer << 1 )| timer) & ITimerMapper.DAY);
        return timer;
    }

    //更新时间安排表
    private int timerLeft(Date order){
        //获取当前时间
        order = removeTime(order);
        Date now = removeTime(new Date());
        //获取两天相隔的天数
        int days = Qutil.consumDays(order, now);
        //获取时间表的时间安排
        return days;
    }

    //削去时间部分
    private Date removeTime(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nd = null;
        try {
            nd = sdf.parse(sdf.format(d));
        }catch (Exception e){
            throw new RuntimeException("取出日期失败");
        }
        return nd;
    }

    //计算日期 测试完成
    private int consumDate(Date d){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        //获取时间,并且处理
        int hour = calendar.get(Calendar.HOUR_OF_DAY) - 9;
        int minute = calendar.get(Calendar.MINUTE);
        if (minute > 0){
            hour += 1;
        }
        int timer = 0;
        switch (hour) {
            case -1:
            case 0:
            case 1:
                timer = 1;
                break;
            case 2:
            case 3:
                timer = 2;
                break;
            case 4:
            case 5:
                timer = 4;
                break;
            case 6:
            case 7:
                timer = 8;
                break;
            case 8:
            case 9:
                timer = 16;
                break;
            case 10:
            case 11:
                timer = 32;
                break;
            default: {
                throw new RuntimeException("请检测时间是否存在问题");
            }
        }
        return timer;
    }


    //将两个结果中间填一
    private int consumTwoTimer(int startTimer, int endTimer){
        return endTimer - startTimer + endTimer;
    }

    private int consumTimer(Date startTime, Date endTime){
        int startTimer = consumDate(startTime);
        int endTimer = consumDate(endTime);

        int timer = consumTwoTimer(startTimer,endTimer);

        return timer;
    }

    //时间前后加一
    private long addTailAndHeadOne(long timer){
        timer = ((timer >> 1) | (timer << 1)) & ITimerMapper.DAY;
        return timer;
    }

    @Override
    public boolean addTimer(int staffId) {
        ITimer timer = new ITimer();
        timer.setStaffId(staffId);
        timer.setTimer(0l);
        timer.setUpdateTime(new Date());
        if(iTimerMapper.insertSelective(timer) == 0) {
            throw new RuntimeException("员工时间表插入失败");
        }
        return true;
    }
}
