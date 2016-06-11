package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.PictureMapper;
import com.wuhn.module.Picture;
import com.wuhn.service.PictureService;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	
	@Resource
	private PictureMapper pictureDao;
	
	public boolean savePicture(Picture picture) {
		if (pictureDao.insertSelective(picture)==1) {
			return true;
		}
		return false;
	}

	public boolean deletePicture(String pictureid) {
		if (pictureDao.deleteByPrimaryKey(pictureid)==1) {
			return true;
		}
		return false;
	}

	public boolean updatePicture(Picture picture) {
		if (pictureDao.updateByPrimaryKeySelective(picture)==1) {
			return true;
		}
		return false;
	}

	public Picture getPicture(String pictureid) {
		return pictureDao.selectByPrimaryKey(pictureid);
	}

	public List<Picture> getByPicture(Picture picture) {
		return pictureDao.selectByPicture(picture);
	}

}
