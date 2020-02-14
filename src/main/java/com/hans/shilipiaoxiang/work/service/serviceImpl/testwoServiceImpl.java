package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IPositionMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IPosition;
import com.hans.shilipiaoxiang.work.service.testwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testwoServiceImpl implements testwoService {
    @Autowired
    private IPositionMapper iPositionMapper;

    @Override
    public List<IPosition> iPositionListAll() {
        return iPositionMapper.selectByExample(null);
    }
}
