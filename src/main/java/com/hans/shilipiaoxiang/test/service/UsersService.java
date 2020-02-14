package com.hans.shilipiaoxiang.test.service;

import com.hans.shilipiaoxiang.test.pojo.Users;

import java.util.List;

public interface UsersService {
    List<Users> selectAll();
    Users selectById(int id);
}
