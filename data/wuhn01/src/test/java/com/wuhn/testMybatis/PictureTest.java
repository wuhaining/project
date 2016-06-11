package com.wuhn.testMybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.module.Picture;
import com.wuhn.service.PictureService;


/**
 * @author wuhn
 * @创建时间 2016-05-11
 * @功能 图片测试
 * **/
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class PictureTest {
	
	@Resource
	private PictureService pictureService;
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	
	@Test
	public void testSavePicture(){
		System.out.println("**********保存图片测试***********");
		Picture picture = new Picture();
		picture.setPictureid(UUID.randomUUID().toString());
		picture.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
		picture.setDirectory("2015/02/11/09");
		picture.setImagename("test.jpg");
		//picture.setIdentity(1);
		try {
			System.out.println("结果:"+pictureService.savePicture(picture));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePicture(){
		System.out.println("**********删除图片测试***********");
		try {
			System.out.println("结果:"+pictureService.deletePicture("e60774a9-eeed-44b5-bca0-7c0c97780ae9"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdatePicture(){
		System.out.println("**********更新图片测试***********");
		Picture picture = new Picture();
		picture.setPictureid("a1e3ac24-12cb-4f91-9ad0-97a9167cac5b");
		picture.setIdentity(1);
		try {
			System.out.println("结果:"+pictureService.updatePicture(picture));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPicture(){
		System.out.println("**********更加id获取图片测试***********");
		try {
			Picture picture = pictureService.getPicture("4d2c8ce6-aab6-4699-89b8-0114da514076");
			System.out.println(picture.getPictureid());
			System.out.println(picture.getUserid());
			System.out.println(picture.getDirectory());
			System.out.println(picture.getImagename());
			System.out.println(picture.getIdentity());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetByPicture(){
		System.out.println("**********根据条件查询测试***********");
		Picture picture = new Picture();
		//picture.setPictureid("a1e3ac24-12cb-4f91-9ad0-97a9167cac5b");
		picture.setUserid("0fca2be9-dcb9-4711-8df3-f3a4a37b26f0");
		//picture.setDirectory("2015/02/11/09");
		//picture.setImagename("test.jpg");
		//picture.setIdentity(1);
		try {
			List<Picture> list = new ArrayList<Picture>();
			list = pictureService.getByPicture(picture);
			for (Picture picture2 : list) {
				System.out.println(picture2.getPictureid());
				System.out.println(picture2.getUserid());
				System.out.println(picture2.getDirectory());
				System.out.println(picture2.getImagename());
				System.out.println(picture2.getIdentity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
