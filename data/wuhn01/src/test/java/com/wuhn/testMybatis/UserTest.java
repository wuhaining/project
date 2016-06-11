package com.wuhn.testMybatis;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.wuhn.module.Role;
import com.wuhn.module.User;
import com.wuhn.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2016-02-14
 * @功能 用户测试
 * **/
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
	
	
	@Test
	public void testGetUserRole(){
		System.out.println("**********获取***********");
		User user = new User();
		try {
			user = userService.getAllUserRole("1123456");
			System.out.println(user.getUserid());
			System.out.println(user.getNickname());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getRole());
			//System.out.println(user.getPicture().getPictureid());
			//System.out.println(user.getPicture().getUserid());
			//System.out.println(user.getPicture().getDirectory());
			//System.out.println(user.getPicture().getImagename());
			for(Role role:user.getRoles()){
				System.out.println(role.getRolepermission());
				System.out.println(role.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUserByName(){
		System.out.println("**********获取***********");
		User user = new User();
		try {
			user = userService.getUserByName("123456@qq.com");
			System.out.println(user.getUserid());
			System.out.println(user.getNickname());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getRole());
			for(Role role:user.getRoles()){
				System.out.println(role.getRolepermission());
				System.out.println(role.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUserCount(){
		System.out.println("**********用户总数***********");
		try {
			System.out.println("用户总数:"+userService.getUserCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testGetUserbyPages(){
		System.out.println("***********分页、条件查询**************");
		try {
			List<User> users = userService.getUserbyPages(10, 0, null, null);
			System.out.println("数量："+users.size());
			System.out.println("json："+JSONArray.fromObject(users));
			for (User user : users) {
				System.out.println("email:"+user.getEmail());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey(){
		System.out.println("**************批量删除****************");
		try {
			List<String> userids = new ArrayList<String>();
			userids.add("32a13b9a-5d05-4a54-beeb-08e6ec72b96a");
			userids.add("3546f24e-c326-4190-b266-d1c77ed64d44");
			System.out.println("批量删除结果："+userService.batchDeleteUser(userids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetByUser(){
		System.out.println("**************根据某一属性查询用户 ****************");
		try {
			User user = new User();
			user.setEmail("123444456@qq.com");
			List<User> list = userService.getByUser(user);
			System.out.println("用户数量："+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
