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
    
    <!-- 遮罩层 -->
    <link rel="stylesheet" href="<%=basePath%>resources/css/common/mask.css">
  </head>
  <body>
  
  	<!-- 提交成功提示模态框[默认] -->
   	<div class="modal fade" id="successModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h3 class="modal-title text-center">提示信息</h3>
	      </div>
	      <div class="modal-body">
	        <p  class="text-center">提交成功！</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- 提交失败提示模态框[小] -->
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
		        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
		    </div>
	    </div>
	  </div>
	</div>
	
  
  
  	
  	<!-- 公共部分 -->
    <script src="<%=basePath%>resources/js/common/common.js"></script>
    
  	<!-- 对应的jquery -->
  	<script src="<%=basePath%>resources/js/jquery-1.11.3.min.js"></script>
    <!-- bootstrap核心js -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <!-- jquery校验 -->
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/jquery.validate.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/localization/messages_zh.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/additional-methods.js"></script>
	
	<!-- 设置bootstrap的一些默认项 -->
    <script src="<%=basePath%>resources/js/common/bootstrapInit.js"></script>
    <!-- 路径调度 -->
    <script src="<%=basePath%>resources/js/common/routeMap.js"></script>
    <!-- loading -->
    <script src="<%=basePath%>resources/js/common/spin.js"></script>
    <!-- jqueryPlugin -->
    <script src="<%=basePath%>resources/js/common/jqueryPlugin.js"></script>
    <!-- 字典 -->
    <script src="<%=basePath%>resources/js/common/dict.js"></script>
    <!-- ajax -->
    <script src="<%=basePath%>resources/js/common/ajaxExtends.js"></script>
    <!--百度分享代码-->
    <script>
	window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
	</script>
  </body>
  
</html>