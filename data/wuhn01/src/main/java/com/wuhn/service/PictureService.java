package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Picture;

/**
 * @author wuhn
 * @创建时间 2016-05-11
 * @功能 图片接口
 * **/
public interface PictureService {
	/**
	 * @功能 保存图片
	 * @param picture 图片
	 * **/
	public boolean savePicture(Picture picture);
	
	/**
	 * @功能 删除图片
	 * @param pictureid 图片主键
	 * **/
	public boolean deletePicture(String pictureid); 
	
	/**
	 * @功能 修改图片
	 * @param picture【一定要有pictureid】 图片
	 * **/
	public boolean updatePicture(Picture picture);
	
	/**
	 * @功能 获取图片详细信息
	 * @param pictureid 图片主键
	 * **/
	public Picture getPicture(String pictureid);
	
	
	
	/**
	 * @功能 根据条件查询
	 * @param List<Picture> 
	 * **/
	public List<Picture> getByPicture(Picture picture);
}
