package com.wuhn.controller.admin.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.Article;
import com.wuhn.module.User;
import com.wuhn.service.ArticleService;
import com.wuhn.utils.ConstantEnum;
import com.wuhn.utils.JSONTools;

/**
 * @author wuhn
 * @创建时间 2016-05-23
 * @功能 文章
 * **/
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Resource
	private ArticleService articleService;
	
	/**
	 * @功能 文章新增
	 * **/
	@RequestMapping(value="/articleAdd",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String articleAdd(Article article,HttpServletRequest request){
		System.out.println("*******文章新增*******");
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			User user = (User) request.getSession().getAttribute("currentUser");
			article.setArticleid(UUID.randomUUID().toString());
			article.setStatus("启用");
			article.setArticletime(simpleDateFormat.format(new Date()));
			article.setUserid(user.getUserid());
			if (articleService.saveArticle(article)) {
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ConstantEnum.FAILURE_SUBMITDATA;
	}
	
	
	/**
	 * @功能 文章修改
	 * **/
	@RequestMapping(value="/articleEdit",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String articleEdit(Article article){
		System.out.println("*******文章修改*******");
		try {
			if (articleService.updateArticle(article)) {
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantEnum.FAILURE_SUBMITDATA;
	}
	
	/**
	 * @功能 文章删除
	 * **/
	@RequestMapping(value="/articleDelete",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String articleDelete(@RequestParam("articleid") String articleid){
		System.out.println("*******文章删除*******");
		try {
			if (articleService.deleteArticle(articleid)) {
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantEnum.FAILURE_SUBMITDATA;
	}
	
	
	/**
	 * @功能 文章列表
	 * **/
	@RequestMapping(value="/articleList",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String articleList(@RequestParam("articleType") String articleType,HttpServletRequest request){
		System.out.println("*******文章列表*******");
		try {
			Article article = new Article();
			User user = (User) request.getSession().getAttribute("currentUser");
			article.setUserid(user.getUserid());
			if (!"".equals(articleType)) {
				article.setArticletype(articleType);
			}		
			List<Article> list = articleService.getArticleList(article);
			if (list.size()>0) {
				return JSONTools.getListJSON(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConstantEnum.FAILURE_SEARCHDATA;
	}
	
	/**
	 * @功能 文章详细
	 * **/
	@RequestMapping(value="/articleInfo",method=RequestMethod.GET)
	public String articleInfo(@RequestParam("articleid") String articleid,
							  @RequestParam("type") String type,Model model){
		String result = "admin/common/article/articleInfo";
		Article article = new Article();
		try {
			article = articleService.getArticle(articleid);
			model.addAttribute(article);
			if (type!=null&&type.equals("edit")) {
				result = "admin/common/article/articleEdit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(result);
		return result;
	}
}
