package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IUserDetailMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IUserDetail;
import com.hans.shilipiaoxiang.work.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private IUserDetailMapper userDetailMapper;
    @Override
    public IUserDetail getOne(int id) {
        return userDetailMapper.selectByPrimaryKey(id);
    }
}
