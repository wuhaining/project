package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.ArticleMapper;
import com.wuhn.module.Article;
import com.wuhn.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Resource
	private ArticleMapper articleDao;
	
	public boolean saveArticle(Article article) {
		if (articleDao.insertSelective(article)==1) {
			return true;
		}
		return false;
	}

	public boolean deleteArticle(String articleid) {
		if (articleDao.deleteByPrimaryKey(articleid)==1) {
			return true;
		}
		return false;
	}

	public boolean updateArticle(Article article) {
		if (articleDao.updateByPrimaryKeySelective(article)==1) {
			return true;
		}
		return false;
	}

	public Article getArticle(String articleid) {		
		return articleDao.selectByPrimaryKey(articleid);
	}

	public List<Article> getArticleList(Article article) {		
		return articleDao.selectList(article);
	}

}
