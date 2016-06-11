<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 公共样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/common/common.css">
  </head>
  
  <body>
  	<!-- 导航栏
    <iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/navigation.jsp"></iframe>
     -->
     
     <!-- 中间内容 -->
     <div class="jumbotron text-center">
	  <h1>您&nbsp;&nbsp;好！</h1>
	  <p>本网站只是一个不完善的例子，请不要干坏事！</p>
	  <p><a class="btn btn-success" href="https://github.com/wuhaining/project" role="button">项目代码</a></p>
	  <p><a class="btn btn-primary btn-lg" href="<%=basePath%>user/login.jsp" role="button">登陆</a></p>
	</div>
     
     
    <jsp:include page="/public/navigation.jsp"></jsp:include>
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/footer.jsp"></iframe>
  </body>
</html>
