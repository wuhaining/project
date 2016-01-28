<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    <link href="<%=basePath%>resources/css/user/login.css" rel="stylesheet">
	<!-- 公共样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/common/common.css">
	<!-- jqueryValidate样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/jqueryValidation/css/loginValidate.css">
  </head>
  
  <body>
  	<!-- 导航栏 
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/navigation.jsp"></iframe>
    -->
    <jsp:include page="/public/navigation.jsp"></jsp:include>
    
    <div class="container text-center loginContainer">
  		<form class="form-horizontal loginForm" action="<%=path%>/login/loginUser" method="post" id="loginId">
  			<div class="form-group">
			    	<div class="input-group">
				      <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>  					
				      <input type="text" name="username" class="form-control JV_Required" id="inputName" placeholder="请输入账号" aria-describedby="basic-addon1">		      
			    	</div>
			</div>
		  <div class="form-group">
		    	<div class="input-group">
				    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>  					
		      		<input type="password" name="password" class="form-control JV_Required" id="inputPassword" placeholder="请输入密码" aria-describedby="basic-addon2">
		      	</div>
		  </div>
		  <div class="form-group">
		      <button type="button" id="loginBtn" class="btn btn-primary btnSubmit">登陆</button>
		  </div>
		  <div class="form-group">
		  	<a target="_blank" href="<%=basePath%>user/register.jsp">没有账号？立刻注册</a>
		  </div>
  		</form> 	
  	</div>
    
    
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/footer.jsp"></iframe>
  	
    <!-- jquery自定义-->
	<script src="<%=basePath%>resources/js/common/jqueryValidate.js"></script>
	<script src="<%=basePath%>resources/js/user/login.js"></script>
	<script type="text/javascript">
	$(function(){
		/***jqueryValidate校验***/	
		$("#loginId").validate();			 
	});
  </body>
</html>
