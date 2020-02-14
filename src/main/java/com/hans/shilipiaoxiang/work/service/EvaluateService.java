package com.hans.shilipiaoxiang.work.service;

import com.hans.shilipiaoxiang.publicservice.pojo.IEvaluate;

import java.util.List;
import java.util.Map;

public interface EvaluateService {
    List<IEvaluate> listAll(int userid);

    List<IEvaluate> listbystaff(int id);

    List<Map<String,Object>> listevaluate();
}
