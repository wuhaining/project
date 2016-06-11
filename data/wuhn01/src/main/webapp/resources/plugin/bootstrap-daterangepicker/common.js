/**
 * @author wuhn
 * @创建时间 2016-03-08
 * @功能 bootstrap-daterangepicker时间初始化设置
 * **/
$(function(){
		//bootstrap时间控件
		$('.datetimepicker').datetimepicker({
			format: 'yyyy-mm-dd',
			language: 'zh-CN',
			autoclose:true,
			startView:'decade',
			minView:'month'
		});
});	