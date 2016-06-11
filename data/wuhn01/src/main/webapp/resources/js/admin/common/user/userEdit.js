/**
 * @author wuhn
 * @创建时间 2016-03-10
 * @功能 用户修改
 */

$(function(){
	//性别checkbox
	var gender = $("#gender").val();
	if(gender=="1"){
		$("#male").parent().addClass("checked");
	}else{
		$("#female").parent().addClass("checked");
	}
	
	var $formId = $("#userEditId");//表单id
	var $formBtn = $("#userEditBtn");//表单按钮
	/***jqueryValidate校验***/	
	$formId.validate();
	var params = {
			data:$formId.serialize(),
			url:$formId.attr("action"),
			formId:'#userEditId'
	}		
	$formBtn.submitAjax(params);//用户修改ajax提交
	
	
	//userid
	var userid = $("#userid").val();
	
	//提交
	$('#successModal').on('hidden.bs.modal', function (e) {
		window.location.href = $("#userInfo").val() + "?type=info&userid="+userid;
		});
	
	//取消
	$("#userInfoBtn").click(function(){
		window.location.href = $("#userInfo").val() + "?type=info&userid="+userid;
	});
});

