<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文章详情</title>
	
</head>
<body>
	
	<div class="container">
		<!-- 返回首页 -->
  		<hr>
  		<div class="row">
  			<div class="col-md-6 text-left" >
  				<!-- 按钮 -->		
				<button type="button"class="btn btn-info" onclick="javascript:window.location.href = '<%=basePath%>article/articleInfo?type=edit&articleid=${article.articleid}'">
				 <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改文章
				</button>
  			</div>
  			<div class="col-md-6 text-right" >
	  			<a href="<%=basePath%>admin/common/article/articleList.jsp">
		  			<span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>返回
		  		</a>
  			</div>
  		</div>
  		
		<hr>
		<div class="row">
		  <div class="col-md-12 text-center" >
		  	<h4><b>${article.articletitle}</b></h4>			  	
		  </div>
		</div>	
		<hr>
		<div class="row">
		  <div class="col-md-12" >
		  	${article.articlecontent}		  	
		  </div>
		</div>
		<hr>
		<div class="row">
		  <div class="col-md-12 text-right" >
		  	<span id="articletype" data="${article.articletype}"></span>&nbsp;&nbsp;&nbsp;&nbsp;发表于<u><em>${article.articletime}</em></u>		  	
		  </div>
		</div>		
		<hr>
		
	</div>
	
	<script type="text/javascript">
		$(function(){
			getDictByType("ARTICLE","info",$("#articletype"),$("#articletype").attr("data"));
		});
	</script>
	
</body>
</html>