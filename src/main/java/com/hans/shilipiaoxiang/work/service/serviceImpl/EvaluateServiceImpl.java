package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.hans.shilipiaoxiang.publicservice.mapper.IEvaluateMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IEvaluate;
import com.hans.shilipiaoxiang.work.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private IEvaluateMapper iEvaluateMapper;

    @Override
    public List<Map<String, Object>> listevaluate() {
        return iEvaluateMapper.listEvaluete();
    }

    @Override
    public List<IEvaluate> listAll(int userid) {
        return iEvaluateMapper.listByid(userid);
    }

    @Override
    public List<IEvaluate> listbystaff(int id) {
        return iEvaluateMapper.listBystaffid(id);
    }
}
