package com.wuhn.controller.utils;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.Dict;
import com.wuhn.service.DictService;
import com.wuhn.utils.ConstantEnum;
import com.wuhn.utils.JSONTools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2016-05-27
 * @功能 字典
 * **/
@Controller
@RequestMapping("/dict")
public class DictController {
	
	@Resource
	private DictService dictService;
	
	/**
	 * @功能 字典查询
	 * **/
	@RequestMapping(value="/getDictByType",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDictByType(@RequestParam("dicttypeid") String dicttypeid){
		System.out.println("*********字典查询*********");
		JSONArray jsonArray = new JSONArray();
		try {
			Dict dict = new Dict();
			dict.setDicttypeid(dicttypeid);
			List<Dict> list = dictService.getByDict(dict);
			/*
			String[] filter = {"getDictid","getDictname"};
			return JSONTools.getListJSON(list, filter);*/
			for (Dict dict2 : list) {
				JSONObject json = new JSONObject();
				json.put("dictid", dict2.getDictid());
				json.put("dictname", dict2.getDictname());
				jsonArray.add(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray.toString();
		//return ConstantEnum.FAILURE_SEARCHDATA;
	}
}
