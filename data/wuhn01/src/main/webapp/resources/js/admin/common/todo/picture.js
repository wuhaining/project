/**
 * @author wuhn
 * @创建时间 2016-05-10
 * @功能 图片上传
 */
$(function(){
	$("#input-id").fileinput({
		language: "zh",//本地化
		maxFileCount: 4,//一次最多上传图片
		autoReplace: true, //如果超过了maxFileCount设置的数量，会自动替换
		//msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		allowedFileExtensions: ["jpg", "png", "gif"], //允许的文件格式
		//minImageWidth: 50, //图片允许的最小宽度
	    //minImageHeight: 50, //图片允许的最小高度
	    //maxImageWidth: 250, //图片允许的最大宽度
	    //maxImageHeight: 250, //图片允许的最大高度
	    resizeImage: true, //调整图片的大小
	    uploadUrl: "/"+projectName+"/upload/image", //上传url
	    uploadAsync: true //异步上传
	});
	
	getImages();//加载图片
	var edit = new editPicture();
})



/**
 * @功能 显示图片列
 * **/
function getImages(){
	$.ajax({
		type: 'get',url:  "/"+projectName+"/image/getImages",data: {},async: false,
		success: function(msg){ 
			 //obj = JSON.stringify(msg)
			 var obj = jQuery.parseJSON(msg);
			 if(obj.result=='1'){
				 obj = obj.row;
				 for(var val in obj){
					 var path = '../../../../'+projectName + obj[val].directory + '/'+ obj[val].imagename;
					 var title = obj[val].title==undefined?"点击添加标题":obj[val].title;
					 var content = obj[val].describecontent==undefined?"点击添加描述":obj[val].describecontent;
					 var pictureid = obj[val].pictureid; 
					 var html = '<figure class="figurebase">'+
				  				'<img alt="" src="'+ path +'">'+
				  				'<figcaption>'+
				  					'<h2 class="title">'+title+'</h2>'+
				  					'<div class="content">'+content+'</div>'+
				  					'<input type="hidden" class="pictureid" value="'+pictureid+'"/>'+
				  				'</figcaption>'+
				  				'</figure>';
					     //imagesShow
						 $('#imagesShow').append(html); 
				 }			 
			 } 		 
		},
		error:function(){}
	});
}





/**
 * @功能 编辑图片
 * **/
var editPicture = function(){
	$('.figurebase').click(function(){
		var obj = $(this).children('figcaption');
		var title = obj.children('.title').text()=="点击添加标题"?"":obj.children('.title').text(); 
		var content = obj.children('.content').text()=="点击添加描述"?"":obj.children('.content').text(); 
		var pictureid = obj.children('.pictureid').val(); 
		//console.log(title);
		$('input[name=title]').val(title);
		$('textarea[name=describecontent]').val(content);
		$('input[name=pictureid]').val(pictureid);
		$('#editPictureModal').modal('show');
	});
	
	var $formId = $("#pictureEditId");//表单id
	var $formBtn = $("#pictureEditBtn");//表单按钮
	var params = {
			data:$formId.serialize(),
			url:$formId.attr("action"),
			formId:'#userEditId'
	}		
	$formBtn.click(function(){
		loading();
		$.ajax({
			type: "post",url: $formId.attr("action"),data: $formId.serialize(),
			success: function(msg){ 
				 var obj = jQuery.parseJSON(msg);
			     if(obj.result==1){$(successModal).modal('show');
			     }else{$(failureModal).modal('show');}
			     loading_stop();
			},
			error:function(){loading_stop();$(failureModal).modal('show');}
		});
		loading_stop();
	});
	
	
}
