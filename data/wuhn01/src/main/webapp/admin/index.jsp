<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/public/metronic.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理页面</title>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
    <!-- BEGIN HEADER -->
    <div class="page-header navbar navbar-fixed-top">
        <!-- BEGIN HEADER INNER -->
        <div class="page-header-inner ">
            <!-- BEGIN LOGO -->
            <div class="page-logo">
                    <img src="<%=basePath%>resources/images/logo.png" alt="logo" class="logo-default" />
                <div class="menu-toggler sidebar-toggler">
                    <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
                </div>
            </div>
            <!-- END LOGO -->
            <!-- BEGIN RESPONSIVE MENU TOGGLER -->
            <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
            <!-- END RESPONSIVE MENU TOGGLER -->
            
            <!-- BEGIN PAGE TOP -->
            <div class="page-top">
               
                <!-- BEGIN TOP NAVIGATION MENU -->
                <div class="top-menu">
                    <ul class="nav navbar-nav pull-right">
                        <!-- BEGIN NOTIFICATION DROPDOWN -->
                        <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                        <li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <i class="icon-bell"></i>
                                <span class="badge badge-default"> 0 </span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="external">
                                    <h3>
                                        <span class="bold">0 条</span> 通知</h3>
                                </li>
                                <li>
                                    <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
                                        
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <!-- END NOTIFICATION DROPDOWN -->
                        <!-- BEGIN INBOX DROPDOWN -->
                        <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                        <li class="dropdown dropdown-extended dropdown-inbox" id="header_inbox_bar">
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <i class="icon-envelope-open"></i>
                                <span class="badge badge-default"> 0 </span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="external">
                                    <h3>你有
                                        <span class="bold">0 新</span> 信息</h3>
                                </li>
                                <li>
                                    <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                        
                                       
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <!-- END INBOX DROPDOWN -->
                        <!-- BEGIN TODO DROPDOWN -->
                        <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                        <li class="dropdown dropdown-extended dropdown-tasks" id="header_task_bar">
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <i class="icon-calendar"></i>
                                <span class="badge badge-default"> 0 </span>
                            </a>
                            <ul class="dropdown-menu extended tasks">
                                <li class="external">
                                    <h3>你有
                                        <span class="bold">0 条</span> 任务</h3>
                                </li>
                                <li>
                                    <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                                                        
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <!-- END TODO DROPDOWN -->
                        <!-- BEGIN USER LOGIN DROPDOWN -->
                        <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                        <li class="dropdown dropdown-user">
                            <a href="<%=basePath%>admin/common/todo/profile.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <img alt="个人头像" id="profileId" class="img-circle" src="<%=basePath%>upload/getProfile" />
                                <span class="username username-hide-on-mobile"></span>
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-default">
                                <li>
                                    <a href="javascript:void(0);" id="goUserInfo">
                                    	<!--  -->
                                    	<input type="hidden" id="userid" value=""/>
                                        <i class="icon-user"></i> 个人信息 </a>
                                </li>
                                
                                
                                <li class="divider"> </li>
                                
                                <li>
                                    <a href="<%=basePath%>login/logout">
                                        <i class="icon-key"></i> 退出 </a>
                                </li>
                            </ul>
                        </li>
                        <!-- END USER LOGIN DROPDOWN -->
                        
                    </ul>
                </div>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END PAGE TOP -->
        </div>
        <!-- END HEADER INNER -->
    </div>
    <!-- END HEADER -->
    <!-- BEGIN HEADER & CONTENT DIVIDER -->
    <div class="clearfix"> </div>
    <!-- END HEADER & CONTENT DIVIDER -->
    <!-- BEGIN CONTAINER -->
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar-wrapper">
            <!-- END SIDEBAR -->
            <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
            <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
            <div class="page-sidebar navbar-collapse collapse">
                <!-- BEGIN SIDEBAR MENU -->
                <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
                <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
                <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
                <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
                <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                <ul class="page-sidebar-menu  page-header-fixed" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200"  style="padding-top: 20px">
                    <li class="nav-item active open">
                        <a href="javascript:void(0);" class="nav-link nav-toggle">
                            <i class="icon-home"></i>
                            <span class="title">首页</span>
							<span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item start">
                                <a href="javascript:void(0);" class="nav-link linkPage" linktype="todo">
                                    <i class="fa fa-tasks"></i>
                                    <span class="title">代办任务</span>
                                </a>
                            </li>
                             <li class="nav-item">
                                <a href="javascript:void(0);" class="nav-link linkPage" linktype="picture">
                                    <i class="fa fa-photo"></i>
                                    <span class="title">个人图片</span>
                                </a>
                            </li>                    
                        </ul>
                    </li>                     
                    <li class="nav-item">
                        <a href="javascript:void(0);" class="nav-link nav-toggle">
                            <i class="icon-user"></i>
                            <span class="title">用户中心</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="javascript:void(0);" class="nav-link linkPage" linktype="user">
                                    <i class="fa fa-group"></i>
                                    <span class="title">用户列表</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="javascript:void(0);" class="nav-link linkPage" linktype="article">
                                    <i class="fa fa-list-ul"></i>
                                    <span class="title">发表文章</span>
                                </a>
                            </li> 
                        </ul>
                        
                        
                    </li>    
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-settings"></i>
                            <span class="title">系统管理</span>                               
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item  ">
                                <a href="javascript:void(0);" class="nav-link linkPage" linktype="permission">
                                    <i class="fa fa-cogs"></i>
									<span class="title">权限管理</span>
                                </a>
                            </li>
                            
                        </ul>
                    </li>
		<!--
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="icon-folder"></i>
                            <span class="title">文件管理</span>
                            <span class="arrow "></span>
                        </a>
                        
                    </li>
		-->
                </ul>
                <!-- END SIDEBAR MENU -->
            </div>
            <!-- END SIDEBAR -->
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <!-- BEGIN CONTENT BODY -->
            <div class="page-content">
                <!-- BEGIN PAGE HEADER-->
               
                <h3 class="page-title">待办任务
                    <small>待办任务</small>
                </h3>
	
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="javascript:void(0);">首页</a>
                            <i class="fa fa-angle-right"></i>
                        </li>
                        <li>
                        	<i class="icon-bar-chart"></i>
                            <span>代办任务</span>
                        </li>
                    </ul>
                    
                </div>
	
                <!-- END PAGE HEADER-->
                <div>
					<iframe id="iframe_link" style="" frameborder="0" scrolling="yes" width="100%" height="700px" src="<%=basePath%>admin/common/todo/task.jsp"></iframe>
				</div>
            </div>
            <!-- END CONTENT BODY -->
        </div>
        <!-- END CONTENT -->
        
    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
    <div class="page-footer">
        <div class="page-footer-inner"> 2016 &copy;project by wuhnning           
        </div>
        <div class="scroll-to-top">
            <i class="icon-arrow-up"></i>
        </div>
    </div>
    <!-- END FOOTER -->
	
	
	
	<!-- javascript -->
	<script src="<%=basePath%>resources/js/common/index.js"></script>
	
</body>
</html>