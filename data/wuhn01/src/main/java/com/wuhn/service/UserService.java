package com.wuhn.service;

import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.apache.ibatis.annotations.Param;

import com.wuhn.module.User;

/**
 * @author wuhn
 * @创建时间 2016-01-12
 * @功能 用户接口
 * **/
public interface UserService {
	/**
	 * @功能 保存用户
	 * @param user 用户
	 * **/
	public boolean saveUser(User user);
	
	/**
	 * @功能 删除用户 
	 * @param userid 用户主键
	 * **/
	public boolean deleteUser(String userid);
	
	/**
	 * @功能 修改用户
	 * @param user【必须有userid】
	 * **/
	public boolean updateUser(User user);
	
	/**
	 * @功能 获取用户详细信息
	 * @param userid 用户主键
	 * **/
	public User getUser(String userid);
	
	/**
	 * @功能 查询所有用户【不分页】 
	 * @param null
	 * **/
	public List<User> getAllUser();
	
	/**
	 * @功能 查询用户信息【包括权限】
	 * @param userid
	 * **/
	public User getAllUserRole(String userid);
	
	/**
	 * @功能 根据email查询用户
	 * @param email 电子邮箱
	 * **/
	public User getUserByName(String email);
	
	/**
	 * @功能 获取用户总数
	 * @param null
	 * **/
	public int getUserCount();
	
	/**
	 * @功能 分页、条件查询
	 * @param limit 页面大小
	 * @param offset 页码
	 * @param nickname 昵称
	 * @param email 电子邮箱
	 * **/
	public List<User> getUserbyPages(int limit,int offset,String nickname,String email);
	
	/**
	 * @功能 批量删除用户 
	 * @param userids 用户主键
	 * **/
	public boolean batchDeleteUser(List<String> userids);
	
	/**
	 * @功能 根据某一属性查询用户 
	 * @param User user
	 * **/
	public List<User> getByUser(User user);
}
