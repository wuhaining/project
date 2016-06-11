package com.wuhn.dao;

import com.wuhn.module.Test;

public interface TestMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKeyWithBLOBs(Test record);

    int updateByPrimaryKey(Test record);
}