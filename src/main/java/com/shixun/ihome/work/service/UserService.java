package com.shixun.ihome.work.service;

import com.shixun.ihome.publicservice.pojo.IUser;
import com.shixun.ihome.publicservice.pojo.IUserDetail;


import java.util.List;

public interface UserService {
    /*
    * 查询用户
    * */
    List<IUser> selectUsers(IUser iUser);

    List<IUserDetail> selectUserAddress(int id);

    IUserDetail selectUserDefaultAddress(int id);

    boolean addUserDetail(IUserDetail iUserDetail);

    boolean updateUserDetail(IUserDetail iUserDetail);

    //获取用户的openid
    String getOpenId(int userId);
}
