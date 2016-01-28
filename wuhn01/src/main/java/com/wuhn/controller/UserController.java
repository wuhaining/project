package com.wuhn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wuhn.module.User;
import com.wuhn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService; 
	
	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public String getUserInfo(@RequestParam("userid") String userid,Model model){
		User user = new User();
		try {
			System.out.println("用户主键："+userid);
			user = userService.getUser(userid);
			model.addAttribute(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userInfo";
	}
}
