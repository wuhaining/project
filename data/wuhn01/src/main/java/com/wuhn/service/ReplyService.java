package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Reply;;

/**
 * @author wuhn
 * @创建时间 2016-06-06
 * @功能 文章回复接口
 * **/
public interface ReplyService {
	/**
	 * @功能 保存文章回复
	 * @param reply 文章回复
	 * **/
	public boolean saveReply(Reply reply);
	
	/**
	 * @功能 删除文章回复
	 * @param Replyid 文章回复主键
	 * **/
	public boolean deleteReply(Integer replyid); 
	
	/**
	 * @功能 修改文章回复
	 * @param reply【一定要有Replyid】 文章回复
	 * **/
	public boolean updateReply(Reply reply);
	
	/**
	 * @功能 获取文章回复详细信息
	 * @param replyid 文章回复主键
	 * **/
	public Reply getReply(Integer replyid);
	
	
	/**
	 * @功能 根据条件查询
	 * @param reply 
	 * **/
	public List<Reply> getByReply(Reply reply);
}
