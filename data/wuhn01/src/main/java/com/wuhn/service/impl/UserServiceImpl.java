package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.UserMapper;
import com.wuhn.module.User;
import com.wuhn.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource  
    private UserMapper userDao; 
	
	public boolean saveUser(User user) {
		if (userDao.insertSelective(user)==1) {
			return true;
		}
		return false;
	}

	public boolean deleteUser(String userid) {
		if (userDao.deleteByPrimaryKey(userid)==1) {
			return true;
		}
		return false;
	}

	public boolean updateUser(User user) {
		if (userDao.updateByPrimaryKeySelective(user)==1) {
			return true;
		}
		return false;
	}

	public User getUser(String userid) {
		return userDao.selectByPrimaryKey(userid);
	}

	public List<User> getAllUser() {
		return userDao.selectAll();
	}

	public User getAllUserRole(String userid) {
		return userDao.selectAllUserRoleByPrimaryKey(userid);
	}

	public User getUserByName(String email) {
		return userDao.selectUserRoleByName(email);
	}

	public int getUserCount() {
		return userDao.selectUserCount();
	}
	
	/**
	 * @param limit 页面大小
	 * @param offset 页码
	 * @param nickname 昵称
	 * @param email 电子邮箱
	 * **/
	public List<User> getUserbyPages(int limit, int offset, String nickname, String email) {
		return userDao.selectUserbyPages(limit, offset, nickname, email);
	}

	public boolean batchDeleteUser(List<String> userids) {
		if (userDao.batchDeleteByPrimaryKey(userids)>=1) {
			return true;
		}
		return false;
	}

	public List<User> getByUser(User user) {
		return userDao.selectByUser(user);
	}

}
