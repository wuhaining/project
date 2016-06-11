package com.wuhn.controller.utils;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.User;
import com.wuhn.service.UserService;

/**
 * @author wuhn
 * @创建时间 2016-05-06
 * @功能 页面+后台数据校验
 * @说明 因为前端使用jquery.validate的remote远程校验方式,
 * 	         所以远程地址只能输出 "true" 或 "false"，不能有其他输出。 
 * **/
@Controller
@RequestMapping("/validate")
public class ValidateController {
	@Resource
	private UserService userService;
	
	/**
	 * @功能 用户email唯一性 
	 * **/
	@RequestMapping(value="/email", method=RequestMethod.POST)
	@ResponseBody
	public boolean userEmail(@RequestParam("data") String data,
							 @RequestParam("oldData") String oldData,
							 @RequestParam("type") String type) {
		System.out.println("校验data："+data+"校验oldData："+oldData);
		try {
			if (oldData.equals(data)) {
				return true;
			}else{
				User user = new User();		
				user.setEmail(data);
				List<User> list = userService.getByUser(user);	
				if (list.size()==0) {
					return true;
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @功能 
	 * **/
}
