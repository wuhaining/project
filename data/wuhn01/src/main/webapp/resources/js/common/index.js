/**
 * @author wuhn
 * @创建时间 2016-03-18
 * @功能 后台框架
 */

$(function(){
	navigation();//导航处理
	
	//获取当前登陆者信息
	$.get("/"+projectName+"/user/currentUser", function(data){
		  //console.log(data);
		  $('.username').text(data.nickname);
		  $('#userid').val(data.userid);
		});
	
	//跳转到个人信息页面
	$('#goUserInfo').click(function(){
		$('#iframe_link').attr("src","/"+projectName+"/user/userInfo?type=info&userid="+$('#userid').val());
	});
	
	//个人头像编辑
	$('#profileId').click(function(){
		$('#iframe_link').attr("src","/"+projectName+"/admin/common/todo/profile.jsp");
		//window.location.href = "/"+projectName+"/admin/common/todo/profile.jsp";
	});
});



/**
 * @功能 导航处理
 **/
function navigation(){
	//页面跳转【左边导航栏】
	$('.linkPage').click(function(){
		$(this).each(function(){
			var linktype = $(this).attr("linktype");
			$('#iframe_link').attr("src",routemap[linktype]);	
			//1.清除原有样式
			$('.nav-item').removeClass("start active open");
			$('.arrow').removeClass("open");
			$('.selected').remove();
			
			//2.添加新的样式
			$(this).parent().addClass('start')
				   .parent().parent().addClass('start active open')
				   .children('a').children('.title').after('<span class="selected"></span>')
				   .siblings('.arrow').addClass('open');
			
			//3.修改标题
			//大标题
			$('.page-title').text(routetitle[linktype].seconLevel)
							.append('<small>&nbsp;'+routetitle[linktype].seconLevel+'</small>');
			//小标题
			navigationCSS(linktype);
			
		});
	
	});
	
	
	//页面跳转【右上下拉导航】
	$("#goUserInfo,#profileId").click(function(){
		$('#iframe_link').attr("src",routemap["personalInfo"]);						
		//1.修改标题
		//大标题
		$('.page-title').text(routetitle["personalInfo"].seconLevel)
						.append('<small>&nbsp;'+routetitle["personalInfo"].seconLevel+'</small>');
		//小标题
		navigationCSS("personalInfo");
	});
}


/**
 *@功能 导航功能的样式改变 
 **/
function navigationCSS(linktype){
	//小标题
	var pageTitle = $('.page-breadcrumb').children("li");
	pageTitle.eq(0).children().eq(0).attr('class',routetitle[linktype].firstLevelImage);
	pageTitle.eq(0).children().eq(1).text(routetitle[linktype].firstLevel);
	pageTitle.eq(1).children().eq(0).attr('class',routetitle[linktype].seconLevelImage);
	pageTitle.eq(1).children().eq(1).text(routetitle[linktype].seconLevel);
}