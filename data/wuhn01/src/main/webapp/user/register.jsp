<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>resources/css/user/register.css" rel="stylesheet">
	<!-- 公共样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/common/common.css">
	<!-- jqueryValidate样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/jqueryValidation/css/validate.css">
	
  </head>
  
  <body>
    <!-- 导航栏
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/navigation.jsp"></iframe>
     -->
    <jsp:include page="/public/navigation.jsp"></jsp:include>
    
    <div class="container text-left regitsterContainer">
    	<form id="registerId" class="form-horizontal regitsterForm" action="<%=basePath%>register/registerUser" method="post">
    	  <div class="form-group">
		    <label for="inputNickname" class="col-sm-2 col-sm-offset-2 control-label">昵称</label>
		    <div class="col-sm-6">
		      <input type="text" name="nickname" class="form-control JV_Required" id="inputNickname" placeholder="请输入昵称">
		    </div>
		    <div class="col-sm-2">
		    	
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputEmail" class="col-sm-2 col-sm-offset-2 control-label">电子邮箱</label>
		    <div class="col-sm-6">
		      <input type="text" name="email" actionType="add" oldData="" class="form-control JV_Required JV_Email JV_UniquenessEmail" id="inputEmail" placeholder="请输入你的电子邮箱">
		    </div>
		    <div class="col-sm-2">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputPassword" class="col-sm-2 col-sm-offset-2 control-label">密码</label>
		    <div class="col-sm-6">
		      <input type="password" name="password" class="form-control JV_Required JV_Password" id="inputPassword" placeholder="请输入密码">
		    </div>
		    <div class="col-sm-2">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="confirmPassword" class="col-sm-2 col-sm-offset-2 control-label">确认密码</label>
		    <div class="col-sm-6">
		      <input type="password" name="comfirm_password" class="form-control JV_Required JV_ConfirmPassword" id="confirmPassword" placeholder="请再一次输入密码">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-6">
		      <button type="button" id="registerBtn" class="btn btn-info btn-block">注册</button>
		    </div>
		  </div>
    	</form>
    	
    	<!-- 
    		<input type="button" id="test" value="默认"/>
    		<input type="button" id="test1" value="小"/>
    	 -->
    	<!-- 注册成功提示模态框[默认] -->
    	<div class="modal fade" id="successModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3 class="modal-title text-center">提示信息</h3>
		      </div>
		      <div class="modal-body">
		        <p  class="text-center">恭喜！注册成功！请登陆邮箱查看邮件，完成账号激活。</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<!-- 注册失败提示模态框[小] -->
		<div class="modal fade" tabindex="-1" role="dialog" id="failureModal">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      	<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h3 class="modal-title text-center">提示信息</h3>
			    </div>
			    <div class="modal-body">
			        <p class="text-center">对不起，系统错误。请重新填写提交。</p>
			    </div>
			    <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			    </div>
		    </div>
		  </div>
		</div>
		
		
    </div>
    
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/footer.jsp"></iframe>
	
	<!-- jquery自定义-->
	<script src="<%=basePath%>resources/js/common/jqueryValidate.js"></script>
	<script src="<%=basePath%>resources/js/user/register.js"></script>
	<script type="text/javascript">
	$(function(){
		/***jqueryValidate校验***/	
		$("#registerId").validate();	
		 
	});
	</script>
  </body>
</html>
