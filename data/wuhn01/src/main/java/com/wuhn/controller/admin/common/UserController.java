package com.wuhn.controller.admin.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.User;
import com.wuhn.service.UserService;
import com.wuhn.utils.ConstantEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2016-03-09
 * @功能 用户
 * **/
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService; 
	
	
	/**
	 * @功能 用户新增
	 * **/
	@RequestMapping(value="/addUser",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addUser(User user){
		System.out.println("*****用户新增*****");
		String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
		try {
			user.setUserid(UUID.randomUUID().toString());
			user.setRole("USER");//默认为一般用户
			if (userService.saveUser(user)) { 
				System.out.println("*****用户新增成功*****");
				resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
	
	
	/**
	 * @功能 用户修改
	 * **/
	@RequestMapping(value="/editUser",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editUser(User user){
		System.out.println("*****用户修改*****");
		String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
		try {
			if (userService.updateUser(user)) { 
				System.out.println("*****用户修改成功*****");
				resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
	
	
	/**
	 * @功能 用户删除
	 * **/
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@RequestBody List<User> users){
		System.out.println("*****用户删除*****");
		String resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
		try {
			//System.out.println("用户主键："+users);
			List<String> userids = new ArrayList<String>();
			for (User user : users) {
				userids.add(user.getUserid());
			}
			if (!userService.batchDeleteUser(userids)) {
				resultJson = ConstantEnum.FAILURE_SUBMITDATA;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(resultJson);
		return resultJson;
	}
	
	
	
	/**
	 * @功能 用户详细
	 * **/
	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public String getUserInfo(@RequestParam("userid") String userid,@RequestParam("type") String type,Model model){
		User user = new User();
		String result = "admin/common/user/userInfo";
		try {
			//System.out.println("用户主键："+userid);
			user = userService.getUser(userid);
			model.addAttribute(user);
			if (type!=null&&type.equals("edit")) {
				result = "admin/common/user/userEdit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(result);
		return result;
	}
	
	/**
	 * @功能 用户列表
	 * **/
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getUserList(@RequestParam("limit") int limit,
								  @RequestParam("offset") int offset,
								  @RequestParam("nickname") String nickname,
								  @RequestParam("email") String email,
								  @RequestParam("type") String type){
		/*
		try {
			System.out.println("解码："+URLDecoder.decode(nickname, "utf-8"));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		//System.out.println("limit:"+limit+" offset:"+offset+" nickname:"+nickname+" email:"+email);
		JSONObject jsonResult = new JSONObject();
		int total = 0;
		List<User> users = new ArrayList<User>();
		
		if(type!=null&&type.equals("Condition")){
			users = userService.getUserbyPages(limit, offset, 
					   nickname.equals("")?null:nickname, 
					   email.equals("")?null:email);
			total = users.size();
		}else{
			total = userService.getUserCount();
			if(total>0){
				users = userService.getUserbyPages(limit, offset, 
												   nickname.equals("")?null:nickname, 
												   email.equals("")?null:email);
			}			
		}
		
		jsonResult.put("total", total);	
		jsonResult.put("rows", JSONArray.fromObject(users));
		//System.out.println(jsonResult.toString());
		return jsonResult;
	}
	
	
	/**
	 * @功能 获取当前登录者信息
	 * **/
	@RequestMapping(value="/currentUser",method=RequestMethod.GET)
	@ResponseBody
	public User getCurrentUser(HttpSession httpSession){
		User user = new User();
		user = (User) httpSession.getAttribute("currentUser"); 
		//System.out.println("昵称:"+user.getNickname());
		//System.out.println("电子邮件:"+user.getEmail());
		return user;
	}
	
	
	
	/**
	 * @功能 行编辑
	 * **/
	@RequestMapping(value="/rowEdit",method=RequestMethod.POST)
	@ResponseBody
	public String rowEdit(@RequestBody User user){
		//System.out.println(user.getUserid());
		String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
		try {
			if (userService.updateUser(user)) { 
				System.out.println("*****用户修改成功*****");
				resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
}
