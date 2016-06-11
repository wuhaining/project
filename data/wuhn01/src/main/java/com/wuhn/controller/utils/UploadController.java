package com.wuhn.controller.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wuhn.module.Picture;
import com.wuhn.module.User;
import com.wuhn.service.PictureService;
import com.wuhn.service.UserService;
import com.wuhn.utils.ConstantEnum;

/**
 * @author wuhn
 * @创建时间 2016-05-09
 * @功能 上传
 * **/
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Resource
	private PictureService pictureService;
	
	@Resource
	private UserService userService; 
	
	/**
	 * @功能 保存图片数据
	 * **/
	@SuppressWarnings("unused")
	private String uploadSave(MultipartHttpServletRequest multipartRequest,
							   HttpSession httpSession) {
		
		return "";
	}
	
	
	/**
	 * @功能 图片上传
	 * **/
	@RequestMapping(value="/image",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String uploadImage(HttpServletRequest request,HttpSession httpSession) {
		String result = "{\"result\":\"1\",\"info\":\"数据提交成功！\"}";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		User user = (User) httpSession.getAttribute("currentUser");//获取当前登陆者
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");     
		//构建图片保存的目录
		String imagePathDir = "/files/images"+ dateformat.format(new Date())+"/"+user.getEmail();
		//得到图片保存目录的真实路径
		String imageRealPathDir = request.getSession().getServletContext().getRealPath(imagePathDir);
		//根据真实路径创建目录
		File imageSaveFile = new File(imageRealPathDir);
		if (!imageSaveFile.exists()) {
			imageSaveFile.mkdirs();
		}
		MultipartFile multipartFile = multipartRequest.getFile("file");
		//获取文件的后缀
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		//使用UUID生成文件名称
		String imageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
		//String imageName = multipartFile.getOriginalFilename();
		//拼成完整的文件保存路径加文件
		String fileName = imageRealPathDir + File.separator + imageName;
		System.out.println(fileName);
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);//上传
			Picture picture = new Picture();
			picture.setPictureid(UUID.randomUUID().toString());
			picture.setUserid(user.getUserid());
			picture.setDirectory(imagePathDir);
			picture.setImagename(imageName);
			//picture.setIdentity(1);
			pictureService.savePicture(picture);//保存数据
		} catch (IllegalStateException e) {
			e.printStackTrace();
			result = "{\"result\":\"0\",\"info\":\"数据提交失败！\"}";
		} catch (IOException e) {
			e.printStackTrace();
			result = "{\"result\":\"0\",\"info\":\"数据提交失败！\"}";
		}
		return result;
	}
	
	
	/**
	 * @功能 多图片上传
	 * **/
	public String filesUpload(HttpServletRequest request,
							  @RequestParam("files") MultipartFile[] files) {  
		
		return "";
	}
	
	
	/**
	 * @throws IOException 
	 * @功能 个人头像
	 * @说明 使用blob上传图片 
	 * 	·TINYBLOB:仅255个字符
　　		·BLOB:最大限制到65K字节
　　		·MEDIUMBLOB:限制到16M字节
　　		·LONGBLOB:可达4GB
	 * **/
	@RequestMapping(value="/profile",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String profile(@RequestParam("file") MultipartFile file,
							HttpServletRequest request) throws IOException{
		try {
			System.out.println("******个人头像*****");
			System.out.println("图片类型："+file.getContentType());
			InputStream isPictureFile = file.getInputStream();
			byte[] pictureData = new byte[(int) file.getSize()];  
			isPictureFile.read(pictureData);
			
			User currentUser = (User) request.getSession().getAttribute("currentUser");//获取当前登陆者
			
			User user = new User();
			user.setUserid(currentUser.getUserid());
			user.setPicture(pictureData);
			if (userService.updateUser(user)) {
				System.out.println("****个人头像保存成功****");
				return ConstantEnum.SUCCESS_SUBMITDATA;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return ConstantEnum.FAILURE_SUBMITDATA;
	}


	/**
	 * @throws IOException 
	 * @功能 个人头像显示
	 * **/
	@RequestMapping(value="/getProfile",method=RequestMethod.GET)
	public void getProfile(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		User currentUser = (User) request.getSession().getAttribute("currentUser");//获取当前登陆者
		User user = new User();
		if (!currentUser.getUserid().isEmpty()) {
			user = userService.getUser(currentUser.getUserid());
		}
		
		byte[] blob = user.getPicture();
    	//response.setContentType("image/jpeg");  
        response.setCharacterEncoding("UTF-8");  
        OutputStream outputSream = response.getOutputStream();  
        InputStream in = new ByteArrayInputStream(blob);  
        int len = 0;  
        byte[] buf = new byte[1024];  
        while ((len = in.read(buf, 0, 1024)) != -1) {  
            outputSream.write(buf, 0, len);  
        }  
        outputSream.close(); 
        
	}
}
