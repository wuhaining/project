package com.wuhn.testMybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.dao.UserMapper;
import com.wuhn.module.User;
import com.wuhn.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class UserTest {
	private static Logger logger = Logger.getLogger(UserTest.class);  
	
	@Resource  
    private UserService userService; 
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	@Test
	public void testUserSave(){
		System.out.println("**********保存***********");
		User user = new User();
		user.setUserid(UUID.randomUUID().toString());
		user.setNickname("名字");
		user.setEmail("123456@qq.com");
		user.setPassword("123456");	
		try {
			System.out.println("保存："+userService.saveUser(user));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testUserDelete(){
		System.out.println("**********删除***********");
		try {
			System.out.println("删除："+userService.deleteUser("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUser(){
		System.out.println("**********获取***********");
		User user = new User();
		try {
			user = userService.getUser("1123456");
			System.out.println(user.getUserid());
			System.out.println(user.getNickname());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUserUpdate(){
		System.out.println("**********更新***********");
		User user = new User();
		user.setUserid("1123456");
		user.setNickname("名字");
		user.setEmail("123456@qq.com");
		user.setPassword("123456");	
		try {
			System.out.println("更新："+userService.updateUser(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAll(){
		System.out.println("**********获取所有***********");
		List<User> userList = new ArrayList<User>();
		try {
			userList = userService.getAllUser();
			System.out.println("总记录数："+userList.size());
			for(User user:userList){
				System.out.println(user.getUserid());
				System.out.println(user.getNickname());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println("*****************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
