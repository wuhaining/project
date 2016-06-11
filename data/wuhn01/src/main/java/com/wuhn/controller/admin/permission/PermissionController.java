package com.wuhn.controller.admin.permission;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.Dict;
import com.wuhn.module.Role;
import com.wuhn.module.User;
import com.wuhn.service.DictService;
import com.wuhn.service.RoleService;
import com.wuhn.service.UserService;
import com.wuhn.utils.ConstantEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2016-05-04
 * @功能 权限管理
 * **/
@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Resource  
	private DictService dictService;
	
	@Resource
	private UserService userService; 
	
	/**
	 * @功能 角色选择
	 * **/
	@RequestMapping(value="/roleSelect",method=RequestMethod.GET)
	@ResponseBody
	public String getRoleSelect(){
		JSONArray jsonArray = new JSONArray();	
		List<Dict> list = new ArrayList<Dict>();
		Dict dictParam = new Dict();
		dictParam.setDicttypeid("USER_ROLE");
		try {
			list = dictService.getByDict(dictParam);
			for (Dict dict : list) {
				JSONObject json = new JSONObject();
				json.put("value", dict.getDictid());
				json.put("text", dict.getDictname());
				jsonArray.add(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("角色选择:"+jsonArray);
		return jsonArray.toString();
	}
	
	/**
	 * @功能 用户角色修改
	 * **/
	@RequestMapping(value="/userRole",method=RequestMethod.GET)
	@ResponseBody
	public String updateUserRole(@RequestParam("userid") String userid,
								 @RequestParam("role") String role) {
		//System.out.println("userid:"+userid+" role:"+role);
		User user = new User();
		user.setUserid(userid);
		user.setRole(role);
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
