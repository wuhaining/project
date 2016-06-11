/**
 * @author wuhn
 * @创建时间 2016-03-10
 * @功能 用户详细
 */

$(function(){
	//性别转换
	/*
	var gender = $("#genderHidden").val();
	if(gender=="1"){		
		$("#gender").text("男");
	}else{
		$("#gender").text("女");
	}*/
	getDictByType("SEX","info",$("#gender"),$("#gender").attr("data"));
	
	/***用户详细ajax提交***/
	$("#userInfoBtn").click(function(){
		//console.log("用户详细ajax提交");
		var userid = $("#userid").val();
		window.location.href = $("#userInfoId").attr("action")+"?type=edit&userid="+userid;
	});
});