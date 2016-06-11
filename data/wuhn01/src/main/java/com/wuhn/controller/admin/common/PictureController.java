package com.wuhn.controller.admin.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wuhn.module.Picture;
import com.wuhn.module.User;
import com.wuhn.service.PictureService;
import com.wuhn.service.UserService;
import com.wuhn.utils.ConstantEnum;

/**
 * @author wuhn
 * @创建时间 2016-06-09
 * @功能 图片
 * **/
@Controller
@RequestMapping("/image")
public class PictureController {
	
	@Resource
	private PictureService pictureService;
	
	@Resource
	private UserService userService;
	
	/**
	 * @功能 图片列
	 * **/
	@RequestMapping(value="/getImages",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getImages(HttpServletRequest request){
		try {
			User currentUser = (User) request.getSession().getAttribute("currentUser");//获取当前登陆者
			Picture picture = new Picture();
			if (!currentUser.getUserid().isEmpty()) {
				picture.setUserid(currentUser.getUserid());
			}		
			List<Picture> list = pictureService.getByPicture(picture);
			JSONObject json = new JSONObject();
			json.put("result", "1");
			json.put("info", "查询成功！");
			json.put("row", list);
			System.out.println(json);
			return json.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantEnum.FAILURE_SEARCHDATA;
		
		
	}

	/**
	 * @功能 图片编辑
	 * **/
	@RequestMapping(value="/editImage",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editImage(Picture picture){
		System.out.println("*********图片修改**********");
		try {
			if (pictureService.updatePicture(picture)) {
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  ConstantEnum.FAILURE_SUBMITDATA;
	}
}
