package com.hans.shilipiaoxiang.work.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hans.shilipiaoxiang.config.ApiJsonObject;
import com.hans.shilipiaoxiang.config.ApiJsonProperty;
import com.hans.shilipiaoxiang.json.ResultBase;
import com.hans.shilipiaoxiang.work.service.OtherService;
import com.hans.shilipiaoxiang.work.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Api(description = "杂项")
@RestController
@RequestMapping("/json/other")
public class OtherController {
    @Autowired
    private UserService userService;
    @Autowired
    private OtherService otherService;

    @ApiOperation("根据用户手机号获取用户的微信id（添加员工使用）")
    @GetMapping("getWeixinIdFromUserPhone/{phone}")
    @ApiImplicitParam(name = "phone" ,value="11111111111", required = true, paramType = "path", dataTypeClass = String.class)
    public ResultBase getWeixinIdFromUserPhone(@PathVariable String phone){
        JSONArray arr = userService.getWeiXinId(phone + "%");
        return ResultBase.success(arr);
    }

    @ApiOperation(value = "登录")
    @PostMapping("/pcLogin")
    public ResultBase pcLogin (@ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(key = "name", example = "user", description = "用户名"),
            @ApiJsonProperty(key = "password", example = "密码", description = "密码")
    })@RequestBody JSONObject params, @ApiIgnore HttpSession session){
        String name = params.getString("name");
        String password = params.getString("password");

        if (password.equals("123456")){
            session.setAttribute("name", name);
            return ResultBase.success();
        }else {
            return ResultBase.fail("密码错误");
        }
    }


    @ApiOperation(value = "获取用户信息测试")
    @GetMapping("/getUserInfo")
    public ResultBase getUserInfo(@ApiIgnore HttpSession session){
        String name = (String) session.getAttribute("name");
        return ResultBase.success(name);
    }

    @ApiOperation(value = "获取职位信息")
    @GetMapping("/getPositions")
    public ResultBase getPosition(){
       JSONArray arr = otherService.getPositions();
        return ResultBase.success(arr);
    }

    @ApiOperation(value = "文件上传")
    @PostMapping("/fileUpload")
    public ResultBase fileUpload(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return ResultBase.fail("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        String filePath = "C:/Files/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return ResultBase.success();
        }catch (IOException e){
            e.printStackTrace();
            return ResultBase.fail("文件上传发生错误");
        }
    }

}
