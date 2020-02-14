package com.hans.shilipiaoxiang.publicservice.pojo;


import java.io.Serializable;
import java.util.Calendar;

/**
 * 订单和时间表的中间类
 */
public class OrderTimer implements Serializable {
    //时间安排
    private String timer;
    //订单表
    private IOrder order;
    //今天和订单的预约时间的天数
    private Integer days;


    public String getTimer() {
        if (this.timer != null){
            return this.timer;
        }
        int t = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(order.getStartTime());
        Calendar finish = Calendar.getInstance();
        finish.setTime(order.getFinalyTime());
        int startHour = start.get(Calendar.HOUR_OF_DAY);
        int endHour = finish.get(Calendar.HOUR_OF_DAY);
        //开始时间在中午
        if(startHour > 14){
            t = 2; //意味着 二进制10  下午被占用
        }else {
            //开始时间在上午
            if (endHour > 14){
                //结束时间在下午,一整天都会被使用
                t = 3; //代表二进制11
            }else{
                t = 1; //代表01; 早上被占用
            }
        }
        //根据相隔天数进位
        t = (t << (days * 2)) & 16383;
        this.timer = Integer.toBinaryString(t);
        //获取开始时间和结束时间
        //"0000000000000000" 14个零一
        return timer;
    }

    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
