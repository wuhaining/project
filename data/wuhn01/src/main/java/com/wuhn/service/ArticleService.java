package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Article;

/**
 * @author wuhn
 * @创建时间 2016-05-23
 * @功能 文章接口
 * **/
public interface ArticleService {
	/**
	 * @功能 保存文章
	 * @param article 文章
	 * **/
	public boolean saveArticle(Article article);
	
	/**
	 * @功能 删除文章
	 * @param articleid 文章主键
	 * **/
	public boolean deleteArticle(String articleid); 
	
	/**
	 * @功能 修改文章
	 * @param Article【一定要有articleid】 文章
	 * **/
	public boolean updateArticle(Article article);
	
	/**
	 * @功能 获取文章详细信息
	 * @param articleid 文章主键
	 * **/
	public Article getArticle(String articleid);
	
	
	/**
	 * @功能 文章列表
	 * @param article 文章
	 * **/
	public List<Article> getArticleList(Article article);
}
