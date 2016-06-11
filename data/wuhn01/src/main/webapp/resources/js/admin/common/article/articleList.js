/**
 * @author wuhn
 * @创建时间 2016-05-27
 * @功能 文章列表
 **/
$(function(){
	var table='<div class="table-responsive"><table class="table table-hover"><thead><tr><th>标题</th><th>发表时间</th><th>操作</th></tr></thead><tbody  class="articleList"></tbody></table></div>';
	$("#one").html(table);
	$("#two").html(table);
	
	$.ajax({
		   type: "get",url: "/"+projectName+"/article/articleList",data: {articleType:""},
		   success: function(msg){
		     var obj = jQuery.parseJSON(msg);
		     if(obj.result=="0"){
		    	 return false;
		     }
		     
		     obj = obj.rows;
		     for(var val in obj){
		    	 var tr = "<tr><td><a href='"+"/"+projectName+"/article/articleInfo?type=info&articleid="+obj[val]["articleid"]+"'>"+obj[val]["articletitle"]+"</a></td><td>"+obj[val]["articletime"]+"</td><td>"
			  				+"<a href='javascript:articleDelete(\""+obj[val]["articleid"]+"\");'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>"
			  				+"&nbsp;&nbsp;&nbsp;<a href='"+"/"+projectName+"/article/articleInfo?type=edit&articleid="+obj[val]["articleid"]+"'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a>"
			  				+"</td></tr>";
		    	if(obj[val]["articletype"]=="1"){$("#one").find(".articleList").append(tr);}
		     	if(obj[val]["articletype"]=="2"){$("#two").find(".articleList").append(tr);}
		     }			     
		   },
		   error:function(){}
	});
});



/**
 * @功能 文章删除
 * @param articleid 文章主键
 **/
function articleDelete(articleid){
	$('#deleteModal').modal('show');
	$('#deleteBtn').click(function(){
		$.post("/"+projectName+"/article/articleDelete", {articleid: articleid},
			function(data){
				var obj = jQuery.parseJSON(data);
				if(obj.result=="0"){$('#failureModal').modal('show');return false;}
				else{$('#successModal').modal('show');}		
		});
	});
	
}