package com.wuhn.service;

import java.util.List;

import com.wuhn.module.User;

public interface UserService {
	public int saveUser(User user);
	public int deleteUser(String userid); 
	public int updateUser(User user);
	public User getUser(String userid);
	public List<User> getAllUser();
}
