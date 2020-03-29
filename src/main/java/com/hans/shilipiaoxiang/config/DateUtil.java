package com.hans.shilipiaoxiang.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {

    //当前时间
    //public static  Date DATE_NOW=new Date();


    /**
     * 将时间戳转化成时间，格式:yyyyMMddHHmmss(年月日时分秒毫秒)
     * @return 完整的时间戳（十三位）
     */
    public static String getDate(Long time){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time)) ;
    }

    /**
     * 得到简单的时间戳，格式:yyyyMMdd(年月日)
     * @return 简单的时间戳
     */
    public static String getSimpleDate(Long time){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)) ;
    }

    /**
     * 根据指定的格式得到时间戳
     * @param pattern 指定的格式
     * @return 指定格式的时间戳
     */
    public static String getTimeStampByPattern(String pattern){
        return new SimpleDateFormat(pattern).format(new Date()) ;
    }

    /**
     * 得到当前日期格式化后的字符串，格式：yyyy-MM-dd(年-月-日)
     * @return 当前日期格式化后的字符串
     */
    public static String getTodayStr(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ;
    }

    /**
     * 时间戳，格式:yyyy-MM-dd HH:mm:ss(年-月-日  时：分：秒)
     * @return 简单的时间戳
     */
    public static String getDateTimeStamp(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) ;
    }

    public static Date getDateByString(String str){
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateTime = null;
        try {
            dateTime = sim.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

}