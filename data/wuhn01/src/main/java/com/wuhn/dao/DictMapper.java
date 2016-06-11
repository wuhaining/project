package com.wuhn.dao;

import java.util.List;

import com.wuhn.module.Dict;

public interface DictMapper {
    int deleteByPrimaryKey(String dictentryid);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(String dictentryid);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
    
    List<Dict> selectByDict(Dict record);
}