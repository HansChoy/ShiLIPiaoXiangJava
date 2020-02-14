//package com.shixun.ihome.maintenance.controller;
//
//import com.shixun.ihome.config.RedisCache;
//import com.shixun.ihome.json.Result;
//import com.shixun.ihome.json.ResultType;
//import com.shixun.ihome.maintenance.service.testwoService;
//import com.shixun.ihome.publicservice.pojo.IPosition;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Controller
//@Api(description = "模块测试")
//@RequestMapping("json/test")
//public class testwoController {
//    @Autowired
//    private testwoService testwoService1;
//    @Autowired
//    private RedisCache cache;
//
//    static class CacheNameHeleper{
//        public static final String listall="postlistall";
//    }
//
//    @ApiOperation(value="列举职位")
//    @GetMapping("/IPositionAll")
//    public void listAll(HttpServletResponse response)throws IOException {
//        response.setContentType("application/json;charset=utf-8");
//        String json =cache.get(CacheNameHeleper.listall);
//        if(json==null) {
//            List<IPosition> listp=testwoService1.iPositionListAll();
//            json = Result.build(ResultType.Success).appendData("listp", listp).convertIntoJSON();
//            cache.set(CacheNameHeleper.listall,json);
//        }
//        response.getWriter().write(json);
//    }
//
//
//
//
//
//
//}
