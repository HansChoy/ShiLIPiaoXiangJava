//package com.shixun.ihome.hourwork.service;
//
//import com.shixun.ihome.publicservice.pojo.IStaff;
//
//import java.util.List;
//import java.util.Map;
//
//public interface HourworkStaffService {
//    /**
//     * 通过状态（state）搜索员工
//     * @param state
//     * 0：空闲中  1：休假中   2：服务中
//     * @return 查询的员工列表
//     */
//    List<IStaff> selectStaffByState(int state);
//
//    /**
//     * 根据服务类型搜索员工
//     * @param servicetype_id 服务类型id
//     * @return 查询的员工列表
//     */
//    List<IStaff> selectStaffByServicetypeId(int servicetype_id);
//
//    /**
//     * 通过map查询员工
//     * @param istaff
//     * @return 查询的员工列表
//     */
//    List<IStaff> selectStaffs(IStaff istaff);
//
//    /**
//     * 删除员工，并非真正删除
//     * @param record    员工的旧记录
//     * @return 更改数据的数量
//     */
//    boolean deleteStaff(IStaff record, String byWho);
//
//    /**
//     * 修改员工信息
//     * @param newrecord 修改的员工新记录
//     * @param oldrecord 修改的员工旧记录
//     * @param byWho 修改人是谁
//     * @return 更改数据的数量
//     */
//    boolean updateStaff(IStaff newrecord,IStaff oldrecord, String byWho);
//
//    /**
//     * 新添员工信息
//     * @param record    员工信息
//     * @param byWho     添加人是谁
//     * @return 更改数据的数量
//     */
//    boolean addStaff(IStaff record, String byWho);
//
//    IStaff getOne(int id);
//}
