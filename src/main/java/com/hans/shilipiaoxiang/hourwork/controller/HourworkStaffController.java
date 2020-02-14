//package com.shixun.ihome.hourwork.controller;
//
//import com.shixun.ihome.hourwork.service.HourworkStaffService;
//import com.shixun.ihome.hourwork.service.HourworkTimerService;
//import com.shixun.ihome.publicservice.pojo.IStaff;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@Api(description = "员工类操作控制器")
//@RequestMapping("json/hourwork/staff")
//public class HourworkStaffController {
//    @Autowired
//    private HourworkStaffService staffService;
//    @Autowired
//    private HourworkTimerService timerService;
//
//    @ApiOperation(value = "寻找员工")
//    @ApiImplicitParam(name="map",value ="员工实体类", required = true, dataType ="HashMap")
//    @ResponseBody
//    @RequestMapping("FindStaffs")
//    public List<IStaff> FindStaffs(@RequestParam Map<String,String> map){
//
//        IStaff iStaff = new IStaff();
//        if(map.get("status") != null){
//            iStaff.setStatus(Integer.parseInt(map.get("status")));
//        }
//        if(map.get("sex") != null){
//            iStaff.setSex(Integer.parseInt(map.get("sex")));
//        }
//
//        List<IStaff> iStaffList = staffService.selectStaffs(iStaff);
//        return iStaffList;
//    }
//
//    @ApiOperation(value = "修改员工")
//    @ApiImplicitParam(name="iStaff", required = true, dataType ="IStaff")
//    @ResponseBody
//    @RequestMapping("updateStaff")
//    public Object updateStaff(IStaff iStaff) {
//        //获取旧记录
//        IStaff iStaff1 = staffService.getOne(iStaff.getId());
//        //获取session之中的修改人
//
//        String bywho = "";
//        //
//        if (staffService.updateStaff(iStaff1,iStaff,bywho)){
//            return "修改成功";
//        }
//       return "修改失败";
//    }
//
//
//
//}
