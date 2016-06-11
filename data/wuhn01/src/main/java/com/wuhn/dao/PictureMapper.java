package com.wuhn.dao;

import java.util.List;

import com.wuhn.module.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(String pictureid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(String pictureid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
    
    List<Picture> selectByPicture(Picture record);
}