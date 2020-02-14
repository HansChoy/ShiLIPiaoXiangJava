package com.hans.shilipiaoxiang.work.service;

import com.github.pagehelper.PageInfo;
import com.hans.shilipiaoxiang.publicservice.pojo.IAdministration;

public interface AdminService {

    /**
     * 登录
     * @param account
     * @param pwd
     * @return 1:账号不存在， 2：密码不正确，3：登录成功
     */
    IAdministration login(String account);
    //获取单个数据
    IAdministration getOne(int id);
    //添加管理员
    boolean addAdministrationRecord(IAdministration admin, String bywho);
    //修改管理员
    boolean updateAdministrationRecord(IAdministration newAdmin, IAdministration oldAdmin, String bywho);
    //根据条件查询管理员
    PageInfo<IAdministration> getAdmins(IAdministration admin, int pageSize, int pageNum);
    //删除管理员
    boolean deleteAdministrationRecord(IAdministration admin, String byWho);

}
