/**
 * @author wuhn
 * @创建时间 2016-03-09
 * @功能 用户新增
 */

$(function(){
	
	var $formId = $("#userAddId");//表单id
	var $formBtn = $("#userAddBtn");//表单按钮
	/***jqueryValidate校验***/	
	$formId.validate();
	var params = {
			data:$formId.serialize(),
			url:$formId.attr("action"),
			formId:'#userAddId'
	}		
	$formBtn.submitAjax(params);//用户新增ajax提交
	
	
});

