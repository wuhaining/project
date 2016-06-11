<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>代办任务</title>
	<!-- bootstrap-table样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table.css">
</head>
<body>
	
	<!-- table列表 -->
	<table id="tb_task"></table>
	
	<!-- bootstrap-table -->
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table.js"></script>
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/common/todo/task.js"></script>
</body>
</html>