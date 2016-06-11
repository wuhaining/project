/**
 * @author wuhn
 * @时间 2015-11-25
 * @功能 校验
 * 		使用jquery插件：jquery-validation-1.14.0
 * @参考 http://www.runoob.com/jquery/jquery-plugin-validate.html
 **/

/***********初始化加载开始**************/
$(function(){
	/* @公用校验
	 * @class格式 JV_Xxx
	 * */
	$.validator.addClassRules({
		JV_Required:{
			required:true	//必须输入的字段。插件自带校验
		},
		JV_Email:{
			email:true	//必须输入正确格式的电子邮件。插件自带校验
		},
		JV_Url:{
			url:true	//必须输入正确格式的网址。插件自带校验
		},
		JV_Number:{
			number:true		//必须输入合法的数字（负数，小数）。	插件自带校验
		},
		JV_Digits:{
			digits:true		//必须输入整数。插件自带校验
		},
		JV_ZipCode:{
			isZipCode:true		//邮政编码。自定义校验
		},
		JV_Mobile:{
			mobile:true		//手机号码。自定义校验
		},
		JV_Password:{
			maxlength:20,	//密码。自定义校验
		},
		JV_ConfirmPassword:{
			maxlength:20,	//确认密码。自定义校验
			equalTo:'#inputPassword'
		},
		JV_ConfirmEditPassword:{
			maxlength:20,	//确认密码。自定义校验
			equalTo:'#editPassword'
		},
		JV_UniquenessEmail:{
			remote: {		//校验邮箱唯一性
			    url: "/"+projectName+"/validate/email",     //后台处理程序
			    type: "post",               //数据发送方式
			    dataType: "json",           //接受数据格式   
			    data: {                     //要传递的数据
			    	data: function() {return $('input[name=email][actionType=add]').val();},
			    	oldData:"",
			    	type:"add"
			    }
			}
		},
		JV_UniquenessEmail_Edit:{
			remote: {		//校验邮箱唯一性 [修改] 
			    url: "/"+projectName+"/validate/email",     //后台处理程序
			    type: "post",               //数据发送方式
			    dataType: "json",           //接受数据格式   
			    data: {                     //要传递的数据
			    	data: function() {return $('input[name=email][actionType=edit]').val();},
			    	oldData:function(){return $('input[name=email][actionType=edit]').attr("oldData");},
			    	type:"edit"
			    }
			}
		}
	});
	
	
	/*@添加新的校验
	 *@注意：要在 additional-methods.js 文件中添加或者在 jquery.validate.js 文件中添加。建议一般写在 additional-methods.js 文件中。
	 *@注意：在 messages_cn.js 文件中添加：isZipCode: "只能包括中文字、英文字母、数字和下划线"。调用前要添加对 additional-methods.js 文件的引用 
	 *@新的校验放在	../jqueryValidate/dist/additional-methods.js
	 * */
	
	
	
	
	/************************默认设置****************************/
	/*
	 * @样式
	 * */
	
	/*
	 * @修改默认message【显示信息】为中文
	 * @引入本地化js文件 <script src="../js/messages_zh.js" type="text/javascript"></script>
	 * */
	jQuery.extend(jQuery.validator.messages, {
	    required: "*必填",
		remote: "已存在",
		email: "请输入正确格式的电子邮件",
		url: "请输入合法的网址",
		date: "请输入合法的日期",
		dateISO: "请输入合法的日期 (ISO).",
		number: "请输入合法的数字",
		digits: "只能输入整数",
		creditcard: "请输入合法的信用卡号",
		equalTo: "密码不一致，请再次输入相同的密码",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
		minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
		rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
		range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: jQuery.validator.format("请输入一个最大为{0} 的值"),
		min: jQuery.validator.format("请输入一个最小为{0} 的值")
	});
	
	/*
	 * 设置jquery的默认值
	 * */
	$.validator.setDefaults({
		debug:true //调试模式，校验但不提交。
	});
	
});

/***********初始化加载结束**************/
