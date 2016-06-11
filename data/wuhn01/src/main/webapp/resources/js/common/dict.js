/**
 * @author wuhn
 * @时间 2016-05-27
 * @功能 字典
 */


/**
 * @功能 根据字典类型查询
 * @param dicttypeid 字典类型
 * @param type 操作类型：info/add/edit=>详情/新增/修改
 * @param $target 操作对象
 * @param currentData 当前数据 【注意：详情/修改需要用到这个参数】
 **/
function getDictByType(dicttypeid,type,$target,currentData){
	var params = {method:"get",url:"/"+projectName+"/dict/getDictByType",data:{dicttypeid:dicttypeid}};
	var datas = ajaxData(params);
	switch(type)
		{
		case "info":
			if(typeof(datas) != 'undefined'){
				  for(var obj in datas){
					  if(datas[obj]["dictid"]==currentData){ $target.text(datas[obj]["dictname"]);}					  
				  }
			  }
			break;
		case "add":
			  if(typeof(datas) != 'undefined'){
				  for(var obj in datas){
					  //console.log(datas[obj]["dictid"]);
					  $target.append('<option value ="'+datas[obj]["dictid"]+'">'+datas[obj]["dictname"]+'</option>');
				  }
			  }
			  
			  break;
		case "edit":
			if(typeof(datas) != 'undefined'){
				  for(var obj in datas){
					  $target.append('<option value ="'+datas[obj]["dictid"]+'">'+datas[obj]["dictname"]+'</option>');
					  $target.val(currentData);
				  }
			  }
			break;
		}
}


/**
 * @功能 ajax获取数据
 * @param params 参数集合
 * **/
var ajaxData = function(params){
	this.type = params.method;
	this.url = params.url;
	this.data = params.data;
	var datas = {};
	if(typeof(data) != 'undefined'){
		$.ajax({
			type: type,url: url,data: data,async: false,
			success: function(msg){
				 //console.log(msg);
				 datas = jQuery.parseJSON(msg);
			},
			error:function(){return datas = {result:"0",info:"系统错误!"};}
		});
	}
	return datas;
}
