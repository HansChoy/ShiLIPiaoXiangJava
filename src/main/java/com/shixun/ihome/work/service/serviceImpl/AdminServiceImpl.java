package com.shixun.ihome.work.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shixun.ihome.publicservice.mapper.IAdministrationMapper;
import com.shixun.ihome.publicservice.pojo.IAdministration;
import com.shixun.ihome.publicservice.pojo.IAdministrationExample;
import com.shixun.ihome.work.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    IAdministrationMapper adminMap;



    @Override
    public int login(String account, String pwd) {
        IAdministration admin=adminMap.selectaccount(account);
        if (admin==null){
            return 1;
        }else{
            String pwd1 = admin.getPwd();
            if(!pwd1.equals(pwd)) return 2;
        }
        return 3;
    }

    @Override
    public IAdministration getOne(int id) {
        return adminMap.selectByPrimaryKey(id);
    }

    @Override
    public boolean addAdministrationRecord(IAdministration admin, String bywho) {
        int result = adminMap.insert(admin);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdministrationRecord(IAdministration newAdmin, IAdministration oldAdmin, String bywho) {
        int result = adminMap.updateByPrimaryKey(newAdmin);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<IAdministration> getAdmins(IAdministration admin, int pageSize, int pageNum) {
        IAdministrationExample example = new IAdministrationExample();
        IAdministrationExample.Criteria  criteria = example.createCriteria();
        if(admin.getName() != null){
            criteria.andNameLike(admin.getName() + "%");
        }
        if(admin.getPhone() != null){
//            criteria.andPhone
        }
        if(admin.getPositionId() != null){
            criteria.andPositionIdEqualTo(admin.getPositionId());
        }
        example.setOrderByClause("id");
        PageHelper.startPage(pageNum, pageSize );
        PageInfo<IAdministration> pages = new PageInfo<>(adminMap.selectByExample(example));
        return pages;
    }

    @Override
    public boolean deleteAdministrationRecord(IAdministration admin, String byWho) {
        int result = adminMap.deleteByPrimaryKey(admin.getId());
        if (result > 0){
            return true;
        }
        return false;
    }
}
