<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>权限管理</title>
	<!-- bootstrap-table样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table.css">
	<!-- bootstrap-table-editable行编辑 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-table/bootstrap3-editable/css/bootstrap-editable.css">
</head>
<body>
	
	<!-- 搜索栏 -->
	<div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="txt_search_nickname">昵称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_nickname">
                        </div>
                        <label class="control-label col-sm-1" for="txt_search_email">电子邮箱</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_email">
                        </div>
                        <div class="col-sm-4" style="text-align:left;">
                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       
	
	<!-- 工具栏 -->
	<div id="toolbar" class="btn-group">
        <button id="btn_manager" type="button" class="btn btn-default" data-toggle="modal">
            <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>权限管理
        </button>
        
    </div>
	<!-- table列表 -->
	<table id="tb_permission">
		<!-- 
		<thead>
			<tr>
				<th data-checkbox="true" data-align="center" ></th>
				<th data-field="nickname" data-title="昵称" data-align="center" ></th>
				<th data-field="email" data-title="电子邮件" data-align="center" ></th>
				<th data-field="role" data-title="角色" data-align="center" data-editable="true"></th>
				<th data-field="name" data-title="真名" data-align="center" data-visible="false"></th>
				<th data-field="gender" data-title="性别" data-align="center" data-visible="false"></th>
				<th data-field="birthday" data-title="生日" data-align="center" data-visible="false"></th>
				<th data-field="userid" data-title="userId" data-align="center" data-visible="false"></th>
			</tr>
		</thead>
		-->
	</table>
	
	</div>
	
	<!-- 权限管理 -->
	<div class="modal fade" id="managerModal" tabindex="-1" role="dialog" aria-labelledby="managerModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="managerModalLabel">权限管理</h4>
	      </div>
	      <div class="modal-body">
	      	<form action="">
	      		<table class="table">
				   <caption>设置对应的角色</caption>
				   <thead>
				      <tr>
				         <th>昵称</th>
				         <th>角色</th>
				      </tr>
				   </thead>
				   <tbody id="managerRole">
				      
				   </tbody>
				</table>
	      	</form>	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
	        <!-- 
	        <button type="button" class="btn btn-primary"  id="userAddBtn">提交</button>
	        -->
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 用户【checkbox选中之前】 -->	
	<div class="modal fade" tabindex="-1" role="dialog" id="checkModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      	<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3 class="modal-title text-center">提示信息</h3>
		    </div>
		    <div class="modal-body">
		        <p class="text-center" id="checkModalText"></p>
		    </div>
		    <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
		    </div>
	    </div>
	  </div>
	</div>	
	
	
	<!-- bootstrap-table -->
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table.js"></script>
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	<!-- bootstrap-table-editable行编辑 -->
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table-editable.js"></script>
	<script src="<%=basePath%>resources/plugin/bootstrap-table/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
	
	
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/permission/permissionUser.js"></script>
</body>
</html>