/**
 * @author wuhn
 * @创建时间 2016-03-17
 * @功能 设置bootstrap的一些默认功能
 */
$(function(){
	//提交成功之后，弹出的模态框
	$('#successModal').on('hidden.bs.modal', function (e) {window.location.reload();});
	//提交失败之后,弹出的模态框
	$('#failureModal').on('hidden.bs.modal', function (e) {window.location.reload();});
});
