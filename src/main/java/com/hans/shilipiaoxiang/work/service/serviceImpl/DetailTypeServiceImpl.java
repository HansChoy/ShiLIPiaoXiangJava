package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IDetailtypeMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IDetailtype;
import com.hans.shilipiaoxiang.work.service.DetailTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailTypeServiceImpl implements DetailTypeService {
    @Autowired
    private IDetailtypeMapper detailtypeMapper;
    @Override
    public IDetailtype getOne(int id) {
        return detailtypeMapper.selectByPrimaryKey(id);
    }
}
