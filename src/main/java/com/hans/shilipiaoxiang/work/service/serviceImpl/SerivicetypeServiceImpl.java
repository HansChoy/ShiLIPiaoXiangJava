package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IDetailtypeMapper;
import com.hans.shilipiaoxiang.publicservice.mapper.IServicetypeMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IDetailtype;
import com.hans.shilipiaoxiang.publicservice.pojo.IServicetype;
import com.hans.shilipiaoxiang.work.service.ServicetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerivicetypeServiceImpl implements ServicetypeService {
    @Autowired
    private IServicetypeMapper iServicetypeMapper;
    @Autowired
    private IDetailtypeMapper iDetailtypeMapper;

    @Override
    public IServicetype selectByid(int serviceid) {

        return iServicetypeMapper.selectByPrimaryKey(serviceid);
    }


    @Override
    public IDetailtype selectBytypeid(int typeid) {

        return iDetailtypeMapper.selectByid(typeid);
    }

    @Override
    public List<IDetailtype> selectByname(String typename) {

        return iDetailtypeMapper.selectByname(typename);
    }

    @Override
    public List<IDetailtype> selectByServicetypeid(int serviceid) {
        return iDetailtypeMapper.selectByServicetypeid(serviceid);
    }

    @Override
    public List<IDetailtype> selectAll() {
        return iDetailtypeMapper.selectByExample(null);
    }


    @Override
    public Integer getServiceType(int detailTypeId) {
        IDetailtype iDetailtype = iDetailtypeMapper.selectByid(detailTypeId);

        return iDetailtype.getServicetpyeId();
    }


    @Override
    public List<IDetailtype> getDetailsByDetailId(int detailtypeId) {
        List<IDetailtype> list = iDetailtypeMapper.selectServiceIdByDetailId(detailtypeId);
        return list;
    }
}
