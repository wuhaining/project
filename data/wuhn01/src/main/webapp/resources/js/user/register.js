/**
 * @author wuhn
 * @创建时间 2015-01-26
 * @功能 用户注册
 */

/************************************************************/
$(function(){
	/*用户注册提交*/
	$("#registerBtn").click(function(){
		if($("#registerId").valid()){
			loading();
			$.ajax({
				   type: "POST",
				   url: $("#registerId").attr("action"),
				   data: $("#registerId").serialize(),
				   success: function(msg){
				     console.log(msg);
				     var obj = jQuery.parseJSON(msg);
				     if(obj.result==1){
				    	 $('#successModal').modal('show');
				     }else{
				    	 $('#failureModal').modal('show');
				     }				     
				   },
				   error:function(){
					   $('#failureModal').modal('show');
				   }
			});
			loading_stop();
		}
		
	});
	
	/*测试
	$('#test').click(function(){
		$('#successModal').modal('show');
	});	
	$('#test1').click(function(){
		$('#failureModal').modal('show');
	});
	*/
	$('#successModal').on('hidden.bs.modal', function (e) {
		window.location.href = "/wuhn01/user/login.jsp";
		});
	$('#failureModal').on('hidden.bs.modal', function (e) {
		window.location.reload();
		});
});
/************************************************************/
