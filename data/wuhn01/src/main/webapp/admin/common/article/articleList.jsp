<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文章列表</title>
	
</head>
<body>
	
	<div class="container-fluid">
		<hr>
		<!-- 按钮 -->		
		<button type="button" class="btn btn-info" onclick="javascript:window.location.href = '<%=basePath%>admin/common/article/articleAdd.jsp'">
		 <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>发表新文章
		</button>
		
						
		<hr>
		<!-- 手机端话题 -->
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="#one" aria-controls="one" role="tab" data-toggle="tab" aria-expanded="true">公共文章</a></li>
 				<li role="presentation"><a href="#two" aria-controls="two" role="tab" data-toggle="tab" aria-expanded="true">私人文章</a></li>
		</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="one"></div>
			<div role="tabpanel" class="tab-pane" id="two">	</div>			       
        </div>
	</div>
	
	<!-- 删除 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="deleteModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      	<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3 class="modal-title text-center">提示信息</h3>
		    </div>
		    <div class="modal-body">
		        <p class="text-center">您确认要删除这篇文章吗？</p>
		    </div>
		    <div class="modal-footer">
		    	<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel">取消</button>
		        <button type="button" class="btn btn-info" data-dismiss="modal" id="deleteBtn">确认</button>
		    </div>
	    </div>
	  </div>
	</div>
	
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/common/article/articleList.js"></script>
	
	
</body>
</html>