package com.wuhn.testMybatis;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.module.Article;
import com.wuhn.service.ArticleService;


/**
 * @author wuhn
 * @创建时间 2016-05-23
 * @功能 文章测试
 * **/
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class ArticleTest {
	
	@Resource
	private ArticleService articleService;
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	@Test
	public void saveArticle(){
		System.out.println("**********文章保存***********");
		Article article = new Article();
		article.setArticleid(UUID.randomUUID().toString());
		article.setArticletype("1");
		article.setArticletime("2016-05-01 00:20");
		article.setArticletitle("test");
		article.setStatus("启用");
		article.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
		article.setArticlecontent("内容");
		try {
			System.out.println("文章保存结果:"+articleService.saveArticle(article));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateArticle(){
		System.out.println("**********文章更新***********");
		Article article = new Article();
		article.setArticleid("c6b6f943-0e82-4ff3-875d-8201d9b46338");
		article.setArticletype("2");
		article.setArticletime("2016-05-01 00:20");
		article.setArticletitle("testUpdate");
		article.setStatus("启用");
		article.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
		article.setArticlecontent("内容");
		try {
			System.out.println("文章更新结果:"+articleService.updateArticle(article));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getArticle(){
		System.out.println("**********文章查询详情***********");
		try {
			Article article = articleService.getArticle("c6b6f943-0e82-4ff3-875d-8201d9b46338");
			System.out.println(article.getArticleid());
			System.out.println(article.getArticletime());
			System.out.println(article.getArticletitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deleteArticle(){
		System.out.println("**********文章删除***********");
		try {
			System.out.println("文章删除结果:"+articleService.deleteArticle("9bf0c15f-a879-46b7-ad57-cac31db15384"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getArticleList(){
		System.out.println("**********文章列表***********");
		try {
			Article article = new Article();
			article.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
			
			List<Article> list = articleService.getArticleList(article);
			if (list.size()>0) {
				for (Article a : list) {
					System.out.println(a.getArticleid());
					System.out.println(a.getArticletime());
					System.out.println(a.getArticletitle());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
