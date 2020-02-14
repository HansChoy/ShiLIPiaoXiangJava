//package com.shixun.ihome.hourwork.service.serviceImpl;
//
//import com.shixun.ihome.hourwork.service.HourworkToolService;
//import com.shixun.ihome.publicservice.mapper.IToolMapper;
//import com.shixun.ihome.publicservice.mapper.IToolrecordMapper;
//import com.shixun.ihome.publicservice.pojo.ITool;
//import com.shixun.ihome.publicservice.pojo.IToolrecord;
//import com.shixun.ihome.publicservice.pojo.IToolrecordExample;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HourworkToolServiceImpl implements HourworkToolService {
//    @Autowired
//    private IToolMapper iToolMapper;
//    @Autowired
//    private IToolrecordMapper iToolrecordMapper;
//    @Override
//    public List<ITool> selectTools() {
//        return iToolMapper.selectByExample(null);
//    }
//    @Override
//    public List<IToolrecord> selectToolsByOrderId(int id){
//        IToolrecordExample iToolrecordExample = new IToolrecordExample();
//        IToolrecordExample.Criteria criteria = iToolrecordExample.createCriteria();
//        criteria.andOrderIdEqualTo(id);
//        return iToolrecordMapper.selectByExample(iToolrecordExample);
//    }
//
//    @Override
//    public boolean getTool(IToolrecord iToolrecord) {
//        //获取工具数量
//        ITool iTool = iToolMapper.selectByPrimaryKey(iToolrecord.getToolId());
//        if (iTool.getCount() < iToolrecord.getCount()){
//            return false;
//        }
//        iTool.setCount(iTool.getCount() - iToolrecord.getCount());
//        try{
//            iToolMapper.updateByPrimaryKeySelective(iTool);
//            iToolrecordMapper.insertSelective(iToolrecord);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//
//        return true;
//    }
//
//    @Override
//    public boolean returnTool(IToolrecord iToolrecord) {
//        //获取原本工具
//        ITool iTool = iToolMapper.selectByPrimaryKey(iToolrecord.getToolId());
//        iTool.setCount(iTool.getCount() + iToolrecord.getCount());
//        iToolMapper.updateByPrimaryKeySelective(iTool);
//        //更新记录状态
//        iToolrecord.setState(2);
//        return iToolrecordMapper.updateByPrimaryKeySelective(iToolrecord)> 0;
//
//    }
//
//    @Override
//    public boolean brokenTool(IToolrecord iToolrecord) {
//        iToolrecord.setState(3);
//        return iToolrecordMapper.updateByPrimaryKey(iToolrecord) > 0;
//    }
//}
