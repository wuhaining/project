package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Dict;

/**
 * @author wuhn
 * @创建时间 2016-05-05
 * @功能 字典接口
 * **/
public interface DictService {
	/**
	 * @功能 保存字典
	 * @param dict 字典
	 * **/
	public boolean saveDict(Dict dict);
	
	/**
	 * @功能 删除字典
	 * @param dictentryid 字典主键
	 * **/
	public boolean deleteDict(String dictentryid); 
	
	/**
	 * @功能 修改字典
	 * @param dict【一定要有dictentryid】 字典
	 * **/
	public boolean updateDict(Dict dict);
	
	/**
	 * @功能 获取字典详细信息
	 * @param dictentryid 字典主键
	 * **/
	public Dict getDict(String dictentryid);
	
	
	
	/**
	 * @功能 根据条件查询
	 * @param List<Dict> 
	 * **/
	public List<Dict> getByDict(Dict dict);
}
