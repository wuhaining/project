package com.wuhn.controller.user;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.User;
import com.wuhn.service.UserService;
import com.wuhn.utils.ConstantEnum;

/**
 * @author wuhn
 * @创建时间 2016-01-27
 * @功能 用户注册
 * **/
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Resource
	private UserService userService; 
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addUser(User user){
		String resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
		try {
			user.setUserid(UUID.randomUUID().toString());
			int result = userService.saveUser(user);
			if (result==1) { 
				System.out.println("*****注册成功*****");
				resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
			} else {
				System.out.println("*****注册失败*****");	
				resultJson = ConstantEnum.FAILURE_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
}
