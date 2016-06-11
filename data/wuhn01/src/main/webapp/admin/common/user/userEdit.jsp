<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/public/metronic.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户修改</title>
	<!-- 用户公共样式 -->
	<link href="<%=basePath%>resources/css/admin/common/user/userCommon.css" rel="stylesheet" type="text/css"/>
	<!-- jqueryValidate样式 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/jqueryValidation/css/adminValidate.css">
	<!-- bootstrap-daterangepicker时间控件 -->
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap-daterangepicker/bootstrap-datetimepicker.css">
</head>
<body>
	<div class="userLayout">
    	<div class="portlet box green">
             <div class="portlet-title">
                 <div class="caption">
                     <i class="fa fa-edit"></i>用户修改 </div>
                 <div class="tools">
                     <a href="javascript:void(0);" class="collapse" data-original-title="折叠" title="折叠"> </a>
                     <a href="javascript:void(0)" onclick="window.location.reload();" class="reload" data-original-title="刷新" title="刷新"> </a>
                 </div>
                 
             </div>
             <div class="portlet-body form">
                 <!-- BEGIN FORM-->
                 <form id="userEditId" class="form-horizontal" action="<%=basePath%>user/editUser" method="post">
                     <div style="display:none;">
                     	<input type="hidden" value="${user.gender}" id="gender"/> 
                     </div>
                     <div class="form-body">
                         <div class="form-group">
                             <label for="inputNickname" class="col-md-3 control-label">昵称</label>
                             <div class="col-md-4">
                                 <input type="text" name="nickname" value="${user.nickname}" id="inputNickname" class="form-control input-circle JV_Required" placeholder="请输入昵称">
                             </div>
                         </div>
                         <div class="form-group">
                             <label for="inputEmail" class="col-md-3 control-label">电子邮箱</label>
                             <div class="col-md-4">                             
                                  <input type="text" name="email"  actionType="edit" oldData="${user.email}"  value="${user.email}" id="inputEmail" class="form-control input-circle JV_Required JV_Email JV_UniquenessEmail_Edit" placeholder="请输入电子邮箱"> </div>
                         </div>
                         <div class="form-group">
                             <label for="inputPassword" class="col-md-3 control-label">密码</label>
                             <div class="col-md-4">
                                   <input type="password" name="password" value="${user.password}" id="inputPassword" class="form-control input-circle JV_Required JV_Password" placeholder="请输入密码">
                             </div>
                         </div>
                         <div class="form-group">
                             <label for="confirmPassword" class="col-md-3 control-label">确认密码</label>
                             <div class="col-md-4">
                                   <input type="password" name="comfirm_password" value="${user.password}" id="confirmPassword" class="form-control input-circle JV_Required JV_ConfirmPassword" placeholder="请再一次输入密码">       
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="col-md-3 control-label">姓名</label>
                             <div class="col-md-4">
                                 <div class="input-icon">
                                     <i class="fa fa-user"></i>
                                     <input type="text" name="name" value="${user.name}" class="form-control input-circle" placeholder="请输入你的姓名"> </div>
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="col-md-3 control-label">性别</label>
                             <div class="col-md-4">
                                 <div class="radio-list">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="male" value=1> 男 </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="female" value=0> 女 </label>                                    
                                </div>
                                      
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="col-md-3 control-label">生日</label>
                             <div class="col-md-4">
  								<input type="text" name="birthday" value="${user.birthday}" class="form-control input-circle datetimepicker" placeholder="生日" id="" >
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">个人头像:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle">
                             		<a href="<%=basePath%>/admin/common/todo/profile.jsp"><img alt="个人头像" style="width:15%;height:10%;" src="<%=basePath%>upload/getProfile"/></a>
                             	</div> 
                             </div>
                         </div>              
                     </div>
                     <div class="form-actions">
                         <div class="row">
                             <div class="col-md-offset-3 col-md-9">
                             	 <input type="hidden" id="userid" name="userid" value="${user.userid}"  >
                             	 <input type="hidden" id="userInfo" value="<%=basePath%>user/userInfo"/>
                                 <button type="button" id="userEditBtn" class="btn btn-circle green">提交</button>
                                 <button type="button" id="userInfoBtn" class="btn btn-circle purple">取消</button>
                             </div>
                         </div>
                     </div>
                 </form>
                 <!-- END FORM-->
             </div>
         </div>
         
         
         
		
    </div>
    
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
	<script src="<%=basePath%>resources/js/admin/common/user/userEdit.js"></script>
	
</body>
</html>