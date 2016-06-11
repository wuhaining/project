package com.wuhn.utils;

/**
 * @author wuhn
 * @创建时间 2016-01-27
 * @功能 统一返回信息 
 * **/
public class ConstantEnum {
	public static final String ERROR_JSONFORMAT ="{\"result\":\"0\",\"info\":\"JSON格式不正确！\"}";
    public static final String SUCCESS_SUBMITDATA ="{\"result\":\"1\",\"info\":\"数据提交成功！\"}";
    public static final String FAILURE_SUBMITDATA ="{\"result\":\"0\",\"info\":\"数据提交失败！\"}";
    public static final String SUCCESS_SEARCHDATA ="{\"result\":\"1\",\"info\":\"数据查询成功！\"}";
    public static final String FAILURE_SEARCHDATA ="{\"result\":\"0\",\"info\":\"未查询到相关数据！\"}";
    public static final String ERROR_SEARCHDATA ="{\"result\":\"0\",\"info\":\"数据查询失败！\"}";
    public static final String ERROR_ABNORMAL ="{\"result\":\"2\",\"info\":\"数据异常！\"}";
    public static final String NULL_PARAMS = "{\"result\":\"0\",\"info\":\"传来的形参为空\"}";
}
