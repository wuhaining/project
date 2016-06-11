package com.wuhn.testMybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.module.Dict;
import com.wuhn.service.DictService;


/**
 * @author wuhn
 * @创建时间 2016-02-14
 * @功能 字典测试
 * **/
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class DictTest {
	@Resource  
	private DictService dictService;
	
	@Before
	public void testBefore(){
		System.out.println("**********测试开始***********");
	}
	
	@After
	public void testAfter(){
		System.out.println("**********测试结束***********");
	}
	
	@Test
	public void getByDict(){
		System.out.println("**********根据条件查询***********");
		List<Dict> list = new ArrayList<Dict>();
		Dict dictParam = new Dict();
		dictParam.setDicttypeid("USER_ROLE");
		try {
			list = dictService.getByDict(dictParam);
			for (Dict dict : list) {
				System.out.println(dict.getDictid());
				System.out.println(dict.getDictname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
