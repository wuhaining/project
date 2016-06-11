package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.ReplyMapper;
import com.wuhn.module.Reply;
import com.wuhn.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private ReplyMapper replyDao;
	
	public boolean saveReply(Reply reply) {
		if (replyDao.insertSelective(reply)==1) {
			return true;
		}
		return false;
	}

	public boolean deleteReply(Integer replyid) {
		if (replyDao.deleteByPrimaryKey(replyid)==1) {
			return true;
		}
		return false;
	}

	public boolean updateReply(Reply reply) {
		if (replyDao.updateByPrimaryKeySelective(reply)==1) {
			return true;
		}
		return false;
	}

	public Reply getReply(Integer replyid) {
		return replyDao.selectByPrimaryKey(replyid);
	}

	public List<Reply> getByReply(Reply reply) {
		return replyDao.selectListByReply(reply);
	}

}
