<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文章修改</title>
	
</head>
<body>
	
	<div class="container">
		<!-- form -->
		<form id="articleEditId" action="<%=basePath%>article/articleEdit" method="post">
			<!-- 返回首页 -->
	  		<hr>
	  		<div class="text-right">
	  			<a href="javascript:window.history.back();">
		  			<span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>返回
		  		</a>
	  		</div>
	  		<hr>
			<div class="row">
			  <div class="col-md-3 text-right">文章类型：</div>
			  <div class="col-md-6 text-left">
			  	<select name="articletype" class="form-control JV_Required"  id="articletype" data="${article.articletype}">				  
				 	
				 </select>
			  </div>
			  <div class="col-md-3"></div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-3 text-right">文章标题：</div>
			  <div class="col-md-6 text-left">
			  	<input type="text" id="articletitle" name="articletitle" class="form-control JV_Required" id="Name" placeholder="请输入标题" value="${article.articletitle}">	
			  </div>
			  <div class="col-md-3"></div>			  
			</div>	
			<hr>
			<div class="row">
			  <div class="col-md-12 text-center" >
			  	<!-- 加载编辑器的容器 -->
		    	<script id="container"  class="JV_Required" type="text/plain" style="height:500px;">

			    </script>
			  	
			  </div>
			</div>
			<hr>
			<div class="row">
			  <div class="col-md-12 text-center" >
			  	<input type="hidden" id="articlecontent" value='${article.articlecontent}'/>
			  	<input type="hidden" id="articleid" name="articleid" value="${article.articleid}"/>
			  	<button type="button" id="articleEditBtn" class="btn btn-info">保存</button>
			  </div>
			</div>  
			<hr>
		</form>
		
	</div>	
	
	
	
	<!-- ueditor -->
	<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/plugin/ueditor/ueditor.config.js"></script>
   	<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/plugin/ueditor/ueditor.all.min.js"> </script>
   	<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
	<!-- jqueryValidate自定义-->
	<script src="<%=basePath%>resources/js/common/jqueryValidate.js"></script>
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/common/article/articleEdit.js"></script>
	<script type="text/javascript">
		var ue = UE.getEditor("container",{
			autoHeightEnabled: true,
		    autoFloatEnabled: true
		});
		ue.ready(function() {
		    //设置编辑器的内容
		    ue.setContent($("#articlecontent").val());
		});
	</script>
	
	
</body>
</html>