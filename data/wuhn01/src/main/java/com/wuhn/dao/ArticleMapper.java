package com.wuhn.dao;

import java.util.List;

import com.wuhn.module.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String articleid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> selectList(Article record);
}