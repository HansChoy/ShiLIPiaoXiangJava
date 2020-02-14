package com.hans.shilipiaoxiang.test.controller;


import com.hans.shilipiaoxiang.json.Result;
import com.hans.shilipiaoxiang.json.ResultType;
import com.hans.shilipiaoxiang.test.pojo.Users;
import com.hans.shilipiaoxiang.test.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@Api(description = "框架测试")

@RequestMapping("json/test")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @ApiOperation(value="列举所有")
    @GetMapping("/aaa")
    @ResponseBody
    public void listAll(HttpServletResponse response)throws IOException {
        response.setContentType("application/json;charset=utf-8");

        List<Users> listu=usersService.selectAll();
        String json ;
        json = Result.build(ResultType.Success).appendData("examines", listu).convertIntoJSON();

        response.getWriter().write(json);


    }

    @ApiOperation(value="高并发测试")
    @GetMapping("/aaabbb")
    @ResponseBody
    public void listAlltest(HttpServletResponse response)throws IOException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                usersService.selectAll();
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(25);
        for (int i=0;i<1000;i++){
            executorService.submit(runnable);
        }
    }
}
