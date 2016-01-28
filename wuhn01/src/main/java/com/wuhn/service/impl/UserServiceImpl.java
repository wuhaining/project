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
	
	public int saveUser(User user) {
		return userDao.insertSelective(user);
	}

	public int deleteUser(String userid) {
		return userDao.deleteByPrimaryKey(userid);
	}

	public int updateUser(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	public User getUser(String userid) {
		return userDao.selectByPrimaryKey(userid);
	}

	public List<User> getAllUser() {
		return userDao.selectAll();
	}

}
