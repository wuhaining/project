package com.wuhn.testMybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.module.Reply;
import com.wuhn.service.ReplyService;

/**
 * @author wuhn
 * @创建时间 2016-06-06
 * @功能 文章回复测试
 * **/
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class ReplyTest {
	@Resource
	private ReplyService replyService;
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	@Test
	public void testSaveReply(){
		System.out.println("**********文章回复保存***********");
		try {
			Reply reply = new Reply();
			reply.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
			reply.setArticleid("918058f7-2919-48b8-9e19-4d2ce78759d2");
			reply.setContent("回复一个！");
			reply.setTime("2016-06-06 11:14");
			System.out.println("结果："+replyService.saveReply(reply));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteReply(){
		System.out.println("**********文章回复删除***********");
		try {
			System.out.println("结果："+replyService.deleteReply(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUpdateReply(){
		System.out.println("**********文章回复修改***********");
		try {
			Reply reply = new Reply();
			reply.setReplyid(2);
			reply.setContent("回复一个！修改！！！");
			reply.setTime("2016-06-06 11:14");
			System.out.println("结果："+replyService.updateReply(reply));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetReply(){
		System.out.println("**********文章回复详情***********");
		try {
			Reply reply = replyService.getReply(2);
			System.out.println(reply.getArticleid());
			System.out.println(reply.getUserid());
			System.out.println(reply.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetByReply(){
		System.out.println("**********文章回复列表***********");
		try {
			Reply reply = new Reply();
			//reply.setReplyid(2);
			reply.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
			reply.setArticleid("918058f7-2919-48b8-9e19-4d2ce78759d2");
			List<Reply> list = replyService.getByReply(reply);
			if (list.size()>0) {
				for (Reply reply2 : list) {
					System.out.println(reply2.getArticleid());
					System.out.println(reply2.getUserid());
					System.out.println(reply2.getContent());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
