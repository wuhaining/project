package com.wuhn.dao;

import java.util.List;

import com.wuhn.module.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
    
    List<Reply> selectListByReply(Reply record);
}