/**
 * @author wuhn
 * @创建时间 2016-03-17
 * @功能 导航
 */


//页面跳转
var routemap = {
		todo:"/"+projectName+"/admin/common/todo/task.jsp",
		picture:"/"+projectName+"/admin/common/todo/picture.jsp",
		user:"/"+projectName+"/admin/common/user/userList.jsp",
		permission:"/"+projectName+"/admin/permission/permissionUser.jsp",
		personalInfo:"/"+projectName+"/admin/common/user/userInfo.jsp",
		article:"/"+projectName+"/admin/common/article/articleList.jsp",
}


//导航标题
var routetitle = {
	todo:{
		firstLevel:"首页",
		firstLevelImage:"icon-home",
		seconLevel:"代办任务",
		seconLevelImage:"fa fa-tasks"
	},
	picture:{
		firstLevel:"首页",
		firstLevelImage:"icon-home",
		seconLevel:"个人图片",
		seconLevelImage:"fa fa-photo"
	},
	user:{
		firstLevel:"用户中心",
		firstLevelImage:"icon-user",
		seconLevel:"用户列表",
		seconLevelImage:"fa fa-group"
	},
	permission:{
		firstLevel:"系统管理",
		firstLevelImage:"icon-settings",
		seconLevel:"权限管理",
		seconLevelImage:"fa fa-cogs"
	},
	personalInfo:{
		firstLevel:"个人管理",
		firstLevelImage:"fa fa-reorder",
		seconLevel:"个人信息",
		seconLevelImage:"fa fa-user"
	},
	article:{
		firstLevel:"用户中心",
		firstLevelImage:"fa fa-reorder",
		seconLevel:"发表文章",
		seconLevelImage:"fa fa-list-ul"
	}
}