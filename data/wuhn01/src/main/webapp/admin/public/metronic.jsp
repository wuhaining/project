<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8"/>
	<!-- Metronic 4.5.2 -->
	<title>管理中心</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1" name="viewport"/>
	<meta content="" name="description"/>
	<meta content="" name="author"/>
	<!-- BEGIN GLOBAL MANDATORY STYLES 
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
	-->
	<link href="<%=basePath%>resources/plugin/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>resources/plugin/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>resources/plugin/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>resources/plugin/metronic/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>resources/plugin/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
 	<!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=basePath%>resources/plugin/metronic/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="<%=basePath%>resources/plugin/metronic/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="<%=basePath%>resources/plugin/metronic/assets/layouts/layout2/css/layout.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>resources/plugin/metronic/assets/layouts/layout2/css/themes/blue.min.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="<%=basePath%>resources/plugin/metronic/assets/layouts/layout2/css/custom.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME LAYOUT STYLES -->
	<link rel="shortcut icon" href="<%=basePath%>resources/images/common/title.ico"/>
	<!-- 遮罩层 -->
    <link rel="stylesheet" href="<%=basePath%>resources/css/common/mask.css">
	
</head>
<!-- END HEAD -->
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

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
    <!-- BEGIN CORE PLUGINS -->
    <!--[if lt IE 9]>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/respond.min.js"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/excanvas.min.js"></script> 
    <![endif]-->
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->
    
    <!-- BEGIN THEME GLOBAL SCRIPTS -->
    <script src="<%=basePath%>resources/plugin/metronic/assets/global/scripts/app.min.js" type="text/javascript"></script>
    <!-- END THEME GLOBAL SCRIPTS -->
    
    <!-- BEGIN THEME LAYOUT SCRIPTS -->
    <script src="<%=basePath%>resources/plugin/metronic/assets/layouts/layout2/scripts/layout.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/layouts/layout2/scripts/demo.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/metronic/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
    <!-- END THEME LAYOUT SCRIPTS -->
    <!-- 公共部分 -->
    <script src="<%=basePath%>resources/js/common/common.js"></script>
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
    <!-- END JAVASCRIPTS -->
    
</body>
</html>