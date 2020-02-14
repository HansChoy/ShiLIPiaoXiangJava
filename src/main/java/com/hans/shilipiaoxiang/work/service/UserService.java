package com.hans.shilipiaoxiang.work.service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.hans.shilipiaoxiang.publicservice.pojo.IUser;
import com.hans.shilipiaoxiang.publicservice.pojo.IUserDetail;


import java.util.List;

public interface UserService {
    /*
    * 查询用户
    * */
    List<IUser> selectUsers(IUser iUser);

    IUser getOne(int id);

    List<IUserDetail> selectUserAddress(int id);

    IUserDetail selectUserDefaultAddress(int id);

    boolean addUserDetail(IUserDetail iUserDetail);

    boolean updateUserDetail(IUserDetail iUserDetail);

    //根据条件查询用户信息
    PageInfo<IUser> selectUserByCondition(IUser user, int pageNum, int pageSize);


    //获取用户的openid
    String getOpenId(int userId);

    JSONArray getWeiXinId(String phone);

    IUserDetail getOrderDetail(int orderId);

    List<IUser> selectAllUser(IUser iUser);
}
