package com.hans.shilipiaoxiang.applet.service;

import com.hans.shilipiaoxiang.applet.pojo.CUser;
import com.hans.shilipiaoxiang.publicservice.pojo.IStaff;
import com.hans.shilipiaoxiang.publicservice.pojo.IUser;

import java.util.List;

public interface WechatService {
    List<Integer> wechatLogin(String openId, CUser cUser);

    int userid(String openid);

    String havaphone(int userid);


    Boolean addphone(int userid,String phone);

    Boolean addusernews(int userid,String name,int gender,String country,String language,String province,String city);

    IUser selectuser(int userid);

    IStaff selectbyopenid(String openid);
}
