package com.wuhn.utils;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2016-05-27
 * @功能 json转换格式
 * **/
public class JSONTools {
	/**
	 * @param <T>
	 * @功能 列表返回格式 不分页
	 * **/
	public static <T> String getListJSON(List<T> objectList){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "0");
		jsonObject.put("info", "未查询到数据！");
		if (objectList.size()>0) {
			jsonObject.put("result", "1");
			jsonObject.put("info", "查询成功！");
			jsonObject.put("rows", JSONArray.fromObject(objectList));
		}
		
		return jsonObject.toString();
	}
	
	
	/**
	 * @功能 列表返回格式 不分页
	 * @param <T>
	 * @param filter 过滤数据字段
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * **/
	public static <T> String getListJSON(List<T> objectList,String[] filter) throws NoSuchMethodException, SecurityException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "0");
		jsonObject.put("info", "未查询到数据！");
		if (objectList.size()>0) {
			jsonObject.put("result", "1");
			jsonObject.put("info", "查询成功！");
			JSONArray jsonArray = new JSONArray();
			for (T t : objectList) {
				JSONObject json = new JSONObject();
				for (String key : filter) {
					json.put(key, t.getClass().getMethod(key, null));
				}
				jsonArray.add(json);
			}
			jsonObject.put("rows", jsonArray);
			//jsonObject.put("rows", JSONArray.fromObject(objectList));
		}
		
		return jsonObject.toString();
	}
}
