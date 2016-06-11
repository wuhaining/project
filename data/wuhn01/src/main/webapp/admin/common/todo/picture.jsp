<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人图片</title>
	<!-- Bootstrap样式  cdn -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- bootstrap-fileinput -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-fileinput/css/fileinput.min.css">
	<!-- 自定义 -->
	<link rel="stylesheet" href="<%=basePath%>resources/css/admin/common/todo/picture.css">
</head>
<body>
	<!-- 
	<form action="<%=basePath%>upload/image" method="post" enctype="multipart/form-data">  
        <input type="hidden" name="method" value="upload"/>   
        <input type="file" name="file"/>  
        <input type="submit" value="upload"/>  
    </form>  
     -->
     
     <div class="container-fluid">
	     <hr>
	     <!-- 上传图片 -->
	     <input id="input-id" type="file" name="file" multiple class="file-loading" >
	     <hr>
	     <!-- 图片展示 -->
	     <div id="imagesShow">
	     
	     
	     </div>
	     
     </div>
     <hr>
     
     
     <!-- 编辑图片框 -->
     <!-- Modal -->
	<div class="modal fade" id="editPictureModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">编辑图片信息</h4>
	      </div>
	      <div class="modal-body">
	        <form id="pictureEditId" action="<%=basePath%>image/editImage" method="post">
	        	<div class="row">
				  <div class="col-md-3 text-right">图片标题：</div>
				  <div class="col-md-6 text-left">
				  	<input type="text" id="title" name="title" class="form-control"placeholder="请输入标题" value="">	
				  </div>
				  <div class="col-md-3"></div>
				</div>
				<hr>
				<div class="row">
				  <div class="col-md-3 text-right">图片描述：</div>
				  <div class="col-md-6 text-left">
				  	<textarea id="describecontent" name="describecontent" class="form-control" placeholder="请输入描述" rows="5" cols="20">
				  	
				  	</textarea>
				  </div>
				  <div class="col-md-3"></div>
				</div>
				<input type="hidden" name="pictureid" />
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="pictureEditBtn">保存修改</button>
	      </div>
	    </div>
	  </div>
	</div>
     
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
     
     
     <!-- bootstrap核心js -->
     <script src="<%=basePath%>resources/plugin/bootstrap-fileinput/js/jquery-2.2.3.min.js"></script>
     <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
     <!-- bootstrap-fileinput -->
     <script src="<%=basePath%>resources/plugin/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js"></script>
     <script src="<%=basePath%>resources/plugin/bootstrap-fileinput/js/fileinput.min.js"></script>
     <script src="<%=basePath%>resources/plugin/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
     <!-- 公共部分 -->
     <script src="<%=basePath%>resources/js/common/common.js"></script>
     <!-- 设置bootstrap的一些默认项 -->
    <script src="<%=basePath%>resources/js/common/bootstrapInit.js"></script>
     <!-- loading -->
    <script src="<%=basePath%>resources/js/common/spin.js"></script>
    <!-- jqueryPlugin -->
    <script src="<%=basePath%>resources/js/common/jqueryPlugin.js"></script>
     <!-- 自定义 -->
     <script src="<%=basePath%>resources/js/admin/common/todo/picture.js"></script>
</body>
</html>