package com.wuhn.controller.admin.common;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.Reply;
import com.wuhn.service.ReplyService;
import com.wuhn.utils.ConstantEnum;

/**
 * @author wuhn
 * @创建时间 2016-06-06
 * @功能 文章
 * **/
@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Resource
	private ReplyService replyService;
	
	/**
	 * @功能 文章回复新增
	 * **/
	@RequestMapping(value="/replyAdd",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String replyAdd(Reply reply){
		System.out.println("*******文章回复新增*******");
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if (replyService.saveReply(reply)) {
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantEnum.FAILURE_SUBMITDATA;
	}
}
