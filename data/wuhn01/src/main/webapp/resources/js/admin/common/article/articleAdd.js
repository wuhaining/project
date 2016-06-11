/**
 * @author wuhn
 * @创建时间 2016-05-23
 * @功能 文章新增
 * @说明 ueditor【】
 * 		配置【/resources/plugin/ueditor/utf8-jsp/jsp/config.json】
 * 			"imageUrlPrefix": "http://localhost:8081/wuhn01/", //图片访问路径前缀
 **/

$(function(){
	//字典
	getDictByType("ARTICLE","add",$("#articletype"));
	
	var $formId = $("#articleAddId");//表单id
	var $formBtn = $("#articleAddBtn");//表单按钮
	var content;//编辑器内容
	var params;//
	/***jqueryValidate校验***/	
	$formId.validate();
	$formBtn.on("click", function() {
		content = ue.getContent(); 	
		params = {
				data:{articletype:$("#articletype").val(),articletitle:$("#articletitle").val(),articlecontent:content},
				url:$formId.attr("action"),
				formId:'#articleAddId',
				clickEvent:false
		}		
		$formBtn.submitAjax(params);
	});	
	
	//提交成功之后，弹出的模态框
	$('#successModal').on('hidden.bs.modal', function (e) {
		window.location.href = "/"+projectName+"/admin/common/article/articleList.jsp";
		});
});

