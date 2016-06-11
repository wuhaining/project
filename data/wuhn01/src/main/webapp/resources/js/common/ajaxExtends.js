/**
 * @author wuhn
 * @时间 2016-05-30
 * @功能 ajax拓展 
 * @说明 在jquery基础上拓展
 */


/**
 * @功能 修改、新增 ajax插件 
 * @param validate 是否需要校验 boolean
 * @param formId 表单id
 * @param type 提交类型 get/post
 * @param url 访问url
 * @param data 提交数据 {}
 * @param async 异步、同步 boolean
 * @param successModal 成功模态框id
 * @param failureModal 失败模态框id
 * @param clickEvent 是否需要click
 * @使用说明   
 * 			@param $formId 表单id
 * 			@param $formBtn 提交按钮
 * 			$formBtn.submitAjax({validate:false,type:'post',data:{},async:false,url:url});
 **/
(function($){
	$.fn.submitAjax = function(options){
		//1.设置参数
		var settings = $.extend({},$.fn.submitAjax.defaultParams,options);
		//2.执行部分
		var setAjax = function(element){
			loading();
			$.ajax({
				type: settings.type,url: settings.url,data: settings.data,async: settings.async,
				success: function(msg){ 
					 var obj = jQuery.parseJSON(msg);
				     if(obj.result==1){$(successModal).modal('show');
				     }else{$(failureModal).modal('show');}
				     loading_stop();
				},
				error:function(){loading_stop();$(failureModal).modal('show');}
			});
			loading_stop();
		};
		//3.如果在 each 循环前使用 return 关键字，就可以使用您的插件维护链接性。
		return $(this).each(function() { 
			if(settings.clickEvent){
				$(this).click(function(){
					if(settings.validate){
						if($(settings.formId).valid()){setAjax($(this)); }
						return false;
					}
					setAjax($(this));  
				});
			}else{
				if(settings.validate){
					if($(settings.formId).valid()){setAjax($(this)); }
					return false;
				}
				setAjax($(this));  
			}
			
			
        });
	};
	
	//默认参数
	$.fn.submitAjax.defaultParams = {
			clickEvent:true,validate:true,type:'post',data:{},async:false,successModal:'#successModal',failureModal:'#failureModal'
	};
	
	
	//
	
})(jQuery);
