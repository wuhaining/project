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
    <jsp:include page="/public/navigation.jsp"></jsp:include>
	<!-- 底部footer -->
	<iframe frameborder="0" scrolling="no" width="100%" src="<%=basePath%>public/footer.jsp"></iframe>
  </body>
</html>
