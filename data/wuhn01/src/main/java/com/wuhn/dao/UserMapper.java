package com.wuhn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuhn.module.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAll();
    
    User selectAllUserRoleByPrimaryKey(String userid);
    
    User selectUserRoleByName(String email);
    
    int selectUserCount();
    
    List<User> selectUserbyPages(@Param("limit")int limit,
    		@Param("offset")int offset,
    		@Param("nickname")String nickname,
    		@Param("email")String email);
    
    int batchDeleteByPrimaryKey(List<String> userids);
    
    List<User> selectByUser(User record);
}