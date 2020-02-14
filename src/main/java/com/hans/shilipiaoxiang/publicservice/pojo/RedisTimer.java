package com.hans.shilipiaoxiang.publicservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hans.shilipiaoxiang.publicservice.util.Qutil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisTimer implements Serializable {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date lastUpdateDate;
    List<Integer> timers;


    public RedisTimer (){
        lastUpdateDate = new Date();
        timers = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            timers.add(0);
        }
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<Integer> getTimers() {
        return timers;
    }

    public void setTimers(List<Integer> timers) {
        this.timers = timers;
    }

    //更新日期
    public boolean update(){
        Date date = new Date();
        if (Qutil.assertDate(date, this.lastUpdateDate)){
            return false;
        }
        System.out.println("他妈又更新了");
        lastUpdateDate = date;
        timers.remove(0);
        timers.add(0);
        return true;

    }


    @Override
    public String toString() {
        return "RedisTimer{" +
                "lastUpdateDate=" + lastUpdateDate +
                ", timers=" + timers +
                '}';
    }
}
