package com.hans.shilipiaoxiang.work.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.publicservice.mapper.IPositionMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.IPosition;
import com.hans.shilipiaoxiang.publicservice.pojo.IPositionExample;
import com.hans.shilipiaoxiang.work.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    private IPositionMapper positionMapper;

    @Override
    public JSONArray  getPositions() {
        IPositionExample example = new IPositionExample();
        example.setOrderByClause("id");
        List<IPosition> lists = positionMapper.selectByExample(example);
        JSONArray arr = new JSONArray(lists.size());
        for (IPosition pos : lists) {
            JSONObject object = new JSONObject(2);
            object.put("value",pos.getId());
            object.put("label",pos.getPosition());
            arr.add(object);
        }
        return arr;
    }
}
