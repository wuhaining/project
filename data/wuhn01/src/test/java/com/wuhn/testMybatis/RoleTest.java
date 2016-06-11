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

import com.wuhn.module.Role;
import com.wuhn.service.RoleService;
import com.wuhn.service.UserService;

/**
 * @author wuhn
 * @创建时间 2016-02-14
 * @功能 角色测试
 * **/
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class RoleTest {
private static Logger logger = Logger.getLogger(UserTest.class);  
	
	@Resource  
    private RoleService roleService; 
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	@Test
	public void testRoleSave(){
		System.out.println("**********保存***********");
		Role role = new Role();
		try {
			role.setRoleid(UUID.randomUUID().toString());
			role.setIdentify("test");
			role.setOrderno(1);
			role.setRolepermission("test");
			if (roleService.saveRole(role)) {
				System.out.println("**插入成功**");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testRoleDelete(){
		System.out.println("**********删除***********");
		try {
			if (roleService.deleteRole("dddd")) {
				System.out.println("**删除成功**");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void testRoleGet(){
		System.out.println("**********获取***********");
		Role role = new Role();
		try {
			role = roleService.getRole("0a04c0be-d52f-4275-9c6d-f86cb40e91ca");
			System.out.println(role.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	@Test
	public void testRoleUpdate(){
		System.out.println("**********修改***********");
		Role role = new Role();
		try {
			role.setRoleid("");
			role.setIdentify("test1");
			role.setOrderno(1);
			role.setRolepermission("test1");
			if (roleService.updateRole(role)) {
				System.out.println("**修改成功**");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
			
	}
	
	@Test
	public void testRoleGetAll(){
		System.out.println("**********查询所有***********");
		List<Role>	roleList = new ArrayList<Role>();
		try {
			roleList = roleService.getAllRole();
			for (Role role : roleList) {
				System.out.println(role.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetByRole(){
		System.out.println("**********根据条件查询***********");
		List<Role>	roleList = new ArrayList<Role>();
		Role roleParam = new Role();
		roleParam.setIdentify("SYS_ADMIN");
		try {
			roleList = roleService.getByRole(roleParam);
			System.out.println("总数:"+roleList.size());
			for (Role role : roleList) {
				System.out.println(role.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
