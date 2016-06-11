<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/public/common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户列表</title>
	<!-- bootstrap-table样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-table/bootstrap-table.css">
	<!-- jqueryValidate样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/jqueryValidation/css/adminValidate.css">
	<!-- bootstrap-daterangepicker时间控件 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-daterangepicker/bootstrap-datetimepicker.css">
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
        <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>
	<!-- table列表 -->
	<table id="tb_user"></table>
	
	</div>
	
	<!-- 新增用户模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="addModalLabel">新增用户</h4>
	      </div>
	      <div class="modal-body">
	        <form id="userAddId" class="form-horizontal" action="<%=basePath%>user/addUser" method="post">
                <div class="form-body">
                    <div class="form-group">
                        <label for="inputNickname" class="col-md-3 control-label">昵称</label>
                        <div class="col-md-6">
                            <input type="text" name="nickname" id="inputNickname" class="form-control  JV_Required" placeholder="请输入昵称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-md-3 control-label">电子邮箱</label>
                        <div class="col-md-6">                             
                             <input type="text" name="email" actionType="add" oldData="" id="inputEmail" class="form-control  JV_Required JV_Email JV_UniquenessEmail" placeholder="请输入电子邮箱"> </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-md-3 control-label">密码</label>
                        <div class="col-md-6">
                              <input type="password" name="password" id="inputPassword" class="form-control  JV_Required JV_Password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword" class="col-md-3 control-label">确认密码</label>
                        <div class="col-md-6">
                              <input type="password" name="comfirm_password" id="confirmPassword" class="form-control  JV_Required JV_ConfirmPassword" placeholder="请再一次输入密码">       
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <div class="input-icon">
                                <i class="fa fa-user"></i>
                                <input type="text" name="name" class="form-control " placeholder="请输入你的姓名"> </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">性别</label>
                        <div class="col-md-6">
                            <div class="radio-list">
                               <label class="radio-inline">
                                   <input type="radio" name="gender" id="" value=1> 男 </label>
                               <label class="radio-inline">
                                   <input type="radio" name="gender" id="" value=0> 女 </label>                                    
                           </div>
                                 
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">生日</label>
                        <div class="col-md-6">
					<input type="text" name="birthday" class="form-control datetimepicker" placeholder="生日" id="" >
                        </div>
                    </div>
                                
                </div>
                
            </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary"  id="userAddBtn">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 修改模态框 -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="editModalLabel">修改用户</h4>
	      </div>
	      <div class="modal-body">
	        <form id="userEditId" class="form-horizontal" action="<%=basePath%>user/editUser" method="post">
                <div class="form-body">
                    <div class="form-group">
                        <label for="editNickname" class="col-md-3 control-label">昵称</label>
                        <div class="col-md-6">
                            <input type="text" name="nickname" id="editNickname" value="" class="form-control JV_Required" placeholder="请输入昵称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="editEmail" class="col-md-3 control-label">电子邮箱</label>
                        <div class="col-md-6">                             
                             <input type="text" name="email" actionType="edit"  oldData="" id="editEmail" value="" class="form-control JV_Required JV_Email JV_UniquenessEmail_Edit" placeholder="请输入电子邮箱"> </div>
                    </div>
                    <div class="form-group">
                        <label for="editPassword" class="col-md-3 control-label">密码</label>
                        <div class="col-md-6">
                              <input type="password" name="password" id="editPassword" value="" class="form-control  JV_Required JV_Password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmEditPassword" class="col-md-3 control-label">确认密码</label>
                        <div class="col-md-6">
                              <input type="password" name="comfirm_password" id="confirmEditPassword" value="" class="form-control  JV_Required JV_ConfirmEditPassword" placeholder="请再一次输入密码">       
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">姓名</label>
                        <div class="col-md-6">
                            <div class="input-icon">
                                <i class="fa fa-user"></i>
                                <input type="text" name="name" id="editName" value="" class="form-control" placeholder="请输入你的姓名"> </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">性别</label>
                        <div class="col-md-6">
                            <div class="radio-list">
                               <label class="radio-inline">
                                   <input type="radio" name="gender" id="editMale" value=1> 男 </label>
                               <label class="radio-inline">
                                   <input type="radio" name="gender" id="editFemale" value=0> 女 </label>                                    
                           </div>
                                 
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">生日</label>
                        <div class="col-md-6">
							<input type="text" name="birthday" id="editBirthday" value="" class="form-control datetimepicker" placeholder="生日"  >
                       		<input type="hidden" name="userid" id="editUserid" value=""/>
                       		
                        </div>
                    </div>
                                
                </div>
                
            </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary"  id="userEditBtn">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 删除模态框 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="deleteModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      	<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3 class="modal-title text-center">提示信息</h3>
		    </div>
		    <div class="modal-body">
		        <p class="text-center" id="deleteModalText"></p>
		    </div>
		    <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-primary"  id="userDeleteBtn">提交</button>
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
	
	
	<!-- bootstrap-daterangepicker时间控件 -->
    <script src="<%=basePath%>resources/plugin/bootstrap-daterangepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/bootstrap-daterangepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/plugin/bootstrap-daterangepicker/common.js" type="text/javascript"></script>
    <!-- jquery校验 -->
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/jquery.validate.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/localization/messages_zh.js"></script>
	<script src="<%=basePath%>resources/plugin/jqueryValidation/dist/additional-methods.js"></script>
	<!-- jquery自定义-->
	<script src="<%=basePath%>resources/js/common/jqueryValidate.js"></script>
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/common/user/userList.js"></script>
	
</body>
</html>