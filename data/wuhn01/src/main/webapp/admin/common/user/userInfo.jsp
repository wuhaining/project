<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/public/metronic.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户详细</title>
	<!-- 用户公共样式 -->
	<link href="<%=basePath%>resources/css/admin/common/user/userCommon.css" rel="stylesheet" type="text/css"/>
	
</head>
<body>
	<div class="userLayout">
    	<div class="portlet box green">
             <div class="portlet-title">
                 <div class="caption">
                     <i class="fa fa-user"></i>用户详细 </div>
                 <div class="tools">
                     <a href="javascript:void(0);" class="collapse" data-original-title="折叠" title="折叠"> </a>
                     <a href="javascript:void(0)" onclick="window.location.reload();" class="reload" data-original-title="刷新" title="刷新"> </a>
                 </div>
                 
             </div>
             <div class="portlet-body form">
                 <!-- BEGIN FORM-->
                 <form id="userInfoId" class="form-horizontal" action="<%=basePath%>user/userInfo" method="get">
                     <div style="display:none;">
                     	<input type="hidden" value="${user.gender}" id="genderHidden"/> 
                     	<input type="hidden" value="${user.userid}" id="userid"/> 
                     </div>
                     <div class="form-body">
                         <div class="form-group">
                             <label class="col-md-3 control-label">昵称:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle">${user.nickname}</div> 
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">电子邮箱:</label>
                             <div class="col-md-4">    
                             	<div class="infoUser-tyle">${user.email}</div>                          
                         	</div>
                         </div>	
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">密码:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle">******</div> 
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">姓名:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle">${user.name}</div> 
                                 
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">性别:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle" id="gender" data="${user.gender}"></div> 
                                
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">生日:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle">${user.birthday}</div> 
                             </div>
                         </div>
                         <hr>
                         <div class="form-group">
                             <label class="col-md-3 control-label">个人头像:</label>
                             <div class="col-md-4">
                             	<div class="infoUser-tyle"><img alt="个人头像" style="width:15%;height:10%;" src="<%=basePath%>upload/getProfile"/></div> 
                             </div>
                         </div>            
                     </div>
                     <div class="form-actions">
                         <div class="row">
                             <div class="col-md-offset-3 col-md-9">
                             	<input type="hidden" value="${user.userid}" />
                                 <button type="button" id="userInfoBtn" class="btn btn-circle green">修改</button>
                                  
                                  <!-- <input type="submit" value="test" />-->
                             </div>
                         </div>
                     </div>
                 </form>
                 <!-- END FORM-->
             </div>
         </div>
         
         
         
		
    </div>
    
    
	<!-- 自定义 -->
	<script src="<%=basePath%>resources/js/admin/common/user/userInfo.js"></script>
	
</body>
</html>