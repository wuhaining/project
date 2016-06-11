package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.DictMapper;
import com.wuhn.module.Dict;
import com.wuhn.service.DictService;

@Service("dictService")
public class DictServiceImpl implements DictService {
	
	@Resource
	private DictMapper dictDao;
	
	public boolean saveDict(Dict dict) {
		 if (dictDao.insertSelective(dict)==1) {
			return true;
		}
		 return false;
	}

	public boolean deleteDict(String dictentryid) {
		if (dictDao.deleteByPrimaryKey(dictentryid)==1) {
			return true;
		}
		return false;
	}

	public boolean updateDict(Dict dict) {
		if (dictDao.updateByPrimaryKeySelective(dict)==1) {
			return true;
		}
		return false;
	}

	public Dict getDict(String dictentryid) {
		return dictDao.selectByPrimaryKey(dictentryid);
		
	}

	public List<Dict> getByDict(Dict dict) {		
		return dictDao.selectByDict(dict);
	}

}
