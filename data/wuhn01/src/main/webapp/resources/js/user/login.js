/**
 * @author wuhn
 * @创建时间 2015-01-26
 * @功能 用户登陆
 */

/************************************************************/
$(function(){
	//jqueryValidate校验
	$("#loginId").validate();	
	
	//点击登录按钮实现登录
	$('#loginBtn').click(function(){
		loginVA();
	});
	
	//按下回车键实现登录
	$(window).keydown(function(){
		if (event.which == 13) {
			loginVA();
		   }
	});
});
/************************************************************/


/**
 * @功能 登录 + 校验validate +ajax
 * **/
function loginVA(){
	if($('#loginId').valid()){
		//<input type="submit" class="btn btn-primary" value="提交"/>  springmvc能够跳转
		//$(".loginForm").submit(); 不能跳转，因为需要交互。
		loading();
		$.ajax({
			   type: "POST",
			   url: $("#loginId").attr("action"),
			   data: $("#loginId").serialize(),
			   success: function(msg){
			     var obj = jQuery.parseJSON(msg);
			     if(obj.result==1){
			    	 window.location.href = "/"+projectName+"/admin/index.jsp"
			     }else{
			    	 $('.loginTip').text('用户名或密码不正确');
			     }				     
			   }
		});
		loading_stop();
	}
}
