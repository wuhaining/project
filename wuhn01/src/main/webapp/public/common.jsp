<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<!--bootstrap版本 3.3.5-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>wuhn</title>
    <!-- 公共方法 -->
	<!--title图标-->
	<link rel='icon' href="resources/images/common/title.ico" type="image/x-ico" /> 
    <!-- Bootstrap样式  cdn -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	
  	<!-- 对应的jquery -->
  	<script src="<%=basePath%>resources/js/jquery-1.11.3.min.js"></script>
    <!-- bootstrap核心js -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <!-- jquery校验 -->
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/jquery.validate.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/localization/messages_zh.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/additional-methods.js"></script>
    
    <!--百度分享代码-->
    <script>
	window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
	</script>
  </body>
  
</html>