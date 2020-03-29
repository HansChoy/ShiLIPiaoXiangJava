package com.hans.shilipiaoxiang.applet.mapper;

import com.hans.shilipiaoxiang.applet.pojo.CEvaluateReply;
import com.hans.shilipiaoxiang.applet.pojo.CEvaluateReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CEvaluateReplyMapper {
    int countByExample(CEvaluateReplyExample example);

    int deleteByExample(CEvaluateReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CEvaluateReply record);

    int insertSelective(CEvaluateReply record);

    List<CEvaluateReply> selectByExample(CEvaluateReplyExample example);

    CEvaluateReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CEvaluateReply record, @Param("example") CEvaluateReplyExample example);

    int updateByExample(@Param("record") CEvaluateReply record, @Param("example") CEvaluateReplyExample example);

    int updateByPrimaryKeySelective(CEvaluateReply record);

    int updateByPrimaryKey(CEvaluateReply record);

    List<CEvaluateReply> showEvaluateReply(int cartId);
}