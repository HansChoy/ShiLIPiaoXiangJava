//package com.shixun.ihome.hourwork.service.serviceImpl;
//
//import com.shixun.ihome.hourwork.service.HourworkStaffService;
//import com.shixun.ihome.publicservice.mapper.IRecordMapper;
//import com.shixun.ihome.publicservice.mapper.IStaffMapper;
//import com.shixun.ihome.publicservice.pojo.IRecord;
//import com.shixun.ihome.publicservice.pojo.IStaff;
//import com.shixun.ihome.publicservice.pojo.IStaffExample;
//import com.shixun.ihome.publicservice.util.Qutil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HourworkStaffServiceImpl implements HourworkStaffService {
//    @Autowired
//    private IStaffMapper iStaffMapper;
//    @Autowired
//    private IRecordMapper iRecordMapper;
//
//    @Override
//    public List<IStaff> selectStaffByState(int state) {
//        IStaffExample iStaffExample = new IStaffExample();
//        IStaffExample.Criteria criteria = iStaffExample.createCriteria();
//        criteria.andStatusEqualTo(state);
//        List<IStaff> iStaffs = iStaffMapper.selectByExample(iStaffExample);
//        return iStaffs;
//    }
//
//
//
//    @Override
//    public List<IStaff> selectStaffByServicetypeId(int servicetype_id) {
//        return iStaffMapper.selectStaffByServicetypeId(servicetype_id);
//    }
//
//    @Override
//    public IStaff getOne(int id) {
//        return iStaffMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public List<IStaff> selectStaffs(IStaff istaff) {
//        IStaffExample iStaffExample = new IStaffExample();
//        IStaffExample.Criteria criteria = iStaffExample.createCriteria();
//        if (istaff.getId()!= null) {
//            criteria.andIdEqualTo(istaff.getId());
//        }
//        if(istaff.getDetailtypeId() != null) {
//            criteria.andIdEqualTo(istaff.getDetailtypeId());
//        }
//        if (istaff.getHealth() != null){
//            criteria.andHealthEqualTo(istaff.getHealth());
//        }
//        if(istaff.getIdCard() != null) {
//            criteria.andIdCardEqualTo(istaff.getIdCard());
//        }
//        if(istaff.getName() != null) {
//            criteria.andNameEqualTo(istaff.getName());
//        }
//        if (istaff.getPhone() != null ){
//            criteria.andPhoneEqualTo(istaff.getPhone());
//        }
//        if(istaff.getQualification() != null){
//            criteria.andQualificationEqualTo(istaff.getQualification());
//        }
//        if(istaff.getSex() != null) {
//            criteria.andSexEqualTo(istaff.getSex());
//        }
//        if(istaff.getStatus() != null) {
//            criteria.andStatusEqualTo(istaff.getStatus());
//        }
//        if(istaff.getWechatId() != null) {
//            criteria.andWechatIdEqualTo(istaff.getWechatId());
//        }
//        iStaffExample.setOrderByClause("id desc");
//        return iStaffMapper.selectByExample(iStaffExample);
//    }
//
//    @Override
//    public boolean addStaff(IStaff record, String byWho) {
//        return iStaffMapper.insert(record) > 0;
//    }
//
//    @Override
//    public boolean deleteStaff(IStaff record,String byWho) {
//        record.setStatus(IStaffMapper.IVALID);
//        return iStaffMapper.updateByPrimaryKeySelective(record) > 0;
//    }
//
//    @Override
//    public boolean updateStaff(IStaff newrecord,IStaff oldrecord, String byWho) {
//
//        return iStaffMapper.updateByPrimaryKeySelective(newrecord) > 0;
//    }
//
//
//}
