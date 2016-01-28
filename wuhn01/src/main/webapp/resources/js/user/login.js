/**
 * @author wuhn
 * @创建时间 2015-01-26
 * @功能 用户登陆
 */

/************************************************************/
$(function(){
	$('#loginBtn').click(function(){
		if($('#loginId').valid()){
			//<input type="submit" class="btn btn-primary" value="提交"/>  springmvc能够跳转
			//$(".loginForm").submit(); 不能跳转，因为需要交互。
			$.ajax({
				   type: "POST",
				   url: $("#loginId").attr("action"),
				   data: $("#loginId").serialize(),
				   success: function(msg){
				     var obj = jQuery.parseJSON(msg);
				     if(obj.result==1){
				    	 window.location.href = "/wuhn01/admin/index.jsp"
				     }else{
				    	 
				     }				     
				   }
				});
		}
	});
	
});
/************************************************************/
