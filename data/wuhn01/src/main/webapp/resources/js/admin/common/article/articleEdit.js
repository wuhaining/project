/**
 * @author wuhn
 * @创建时间 2016-05-27
 * @功能 文章修改
 * @说明 ueditor【】
 * 		配置【/resources/plugin/ueditor/utf8-jsp/jsp/config.json】
 * 			"imageUrlPrefix": "http://localhost:8081/wuhn01/", //图片访问路径前缀
 **/

$(function(){
	//字典
	getDictByType("ARTICLE","edit",$("#articletype"),$("#articletype").attr("data"));
	
	//提交
	var $formId = $("#articleEditId");//表单id
	var $formBtn = $("#articleEditBtn");//表单按钮
	var content;
	var params;
	/***jqueryValidate校验***/	
	$formId.validate();
	$formBtn.on("click", function() {
		content = ue.getContent(); 	
		params = {
				data:{articleid:$("#articleid").val(),articletype:$("#articletype").val(),articletitle:$("#articletitle").val(),articlecontent:content},
				url:$formId.attr("action"),
				formId:'#articleEditId',
				clickEvent:false
		}		
		$formBtn.submitAjax(params);
	});		
	
	$('#successModal').on('hidden.bs.modal', function (e) {
		window.location.href = "/"+projectName+"/article/articleInfo" + "?type=info&articleid="+$("#articleid").val();
	});
});