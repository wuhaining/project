/**
 * @author wuhn
 * @创建时间 2016-03-10
 * @功能 用户列表
 */
$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    
    //2.条件查询
    var searchData = new tb_searchInit();
    searchData.Init();
    
    //3.jqueryvalidate校验
    $("#userAddId").validate();	
    $("#userEditId").validate();
    
    btnAjax("userAddId","userAddBtn");//新增ajax提交
    btnAjax("userEditId","userEditBtn");//修改ajax提交 
    
    beforeEditUser();//修改用户之前处理
    beforeDeleteUser();//删除用户之前处理
     
    deleteAjax();//删除用户
    
    
    
});


//表格初始化
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_user').bootstrapTable({
            url: "/"+projectName+"/user/userList",         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination:true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [5,10, 15, 20],        //可供选择的每页的行数（*）
            //search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            //strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: setColumnsPro,
            onCheckAll:function(){
            	//alert("点击全选");
            },
            onEditableSave:function(field, row, oldValue, $el){
            	//console.log("field:"+field);
            	//console.log("row:"+row.nickname);
            	//console.log("oldValue:"+oldValue);
            	//console.log("$el:"+$el);
            	var params = "{\"userid\":\""+row.userid+"\",\"nickname\":\""+row.nickname+"\"}";
            	 $.ajax({
                     type: "post",
                     contentType : 'application/json',  
                     url: "/"+projectName+"/user/rowEdit",
                     data: params,
                     success: function (data, status) {
                         if (status == "success") {
                        	 var obj = jQuery.parseJSON(data);
                        	 //console.log(obj.result);
                             if(obj.result=='1'){
                            	 $("#checkModalText").text("修改成功");
                         		 $("#checkModal").modal('show');
                             }else{
                            	 $("#checkModalText").text("修改失败");
                         		 $("#checkModal").modal('show');
                             }
                        	 
                         }
                     },
                     error: function () {
                    	 $("#checkModalText").text("系统问题");
                 		 $("#checkModal").modal('show');
                     },
                     complete: function () {

                     }

                 });
            }
            
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            nickname: $("#txt_search_nickname").val(),
            email: $("#txt_search_email").val(),
            type:"noCondition" //标识：判断是否条件查询
        };
        return temp;
    };
    
    //表格的列参数设置
    var setColumnsPro = [
    {checkbox: true,align:'center'},
    {field: 'nickname',title: '昵称',align:'center',editable:true},
    {field: 'email',title: '电子邮件',align:'center'}, 
    {field: 'name',title: '真名',align:'center'}, 
    {field: 'gender',title: '性别',align:'center',formatter:function(value,row,index){
        	if(row.gender==1){
        		return "男";
        	}else if(row.gender==0){
        		return "女";
        	}else{
        		return "未知";
        	}     	
        }	
    }, 
    {field: 'birthday',title: '生日',align:'center'},
    {field: 'role',title: '角色',align:'center',formatter:function(value,row,index){
        	if(row.role=="USER"){
        		return '<span style="color:red;">一般用户</span>';
        	}else if(row.role=="SYS_USER"){
        		return '<span style="color:blue;">管理员</span>';
        	}else if(row.role=="SYS_ADMIN"){
        		return '<span style="color:green;">系统管理员</span>';
        	}else{
        		return '<span style="color:#9F978E;">未赋予任何权限</span>';
        	}  	
        }		
    }];
    
    return oTableInit;
};


//条件查询
var tb_searchInit=function () {
    var btn_searchInit = new Object();
    btn_searchInit.Init = function () {
    	$('#btn_query').click(function(){
        	console.log("查询");
        	//请求参数
        	var $nickname = $("#txt_search_nickname").val();
        	var $email = $("#txt_search_email").val()
        	var $type = $nickname==""&$nickname==""?"noCondition":"Condition";
        	var temp = {   
                    limit: 10,   //页面大小
                    offset: 0,  //页码
                    nickname: $nickname,
                    email: $email,
                    type:$type
                };
        	//ajax请求
        	$.ajax({
    			   type: "GET",
    			   async:true,
    			   url: "/"+projectName+"/user/userList",
    			   data: temp,
    			   success: function(parameter){
    			     //console.log(parameter);
    			     $('#tb_user').bootstrapTable('load', parameter);//bootstrap-table的重新加载数据	
    			     $('#tb_user').bootstrapTable('selectPage', 1);//跳到第一页
    			   }
    			});
        	
        });
    }
    return btn_searchInit;
    
}


/**
 *@功能 新增、修改ajax提交
 *@param formId  form表单id
 *@param submitId  提交按钮id
 ***/
function btnAjax(formId,submitId){
	$("#"+submitId).click(function(){
		if($("#"+formId).valid()){
			loading();
			$.ajax({
				   type: "POST",
				   url: $("#"+formId).attr("action"),
				   data: $("#"+formId).serialize(),
				   success: function(msg){
				     //console.log(msg);
				     var obj = jQuery.parseJSON(msg);
				     if(obj.result==1){
				    	 $('#successModal').modal('show');
				     }else{
				    	 $('#failureModal').modal('show');
				     }				     
				   }
				});
			loading_stop();
		}
		
	});
	
}


/**
 * @功能 在修改用户之前做相应的处理
 * 
 **/
function beforeEditUser(){
	$("#btn_edit").click(function(){
    	var checkArr = $('#tb_user').bootstrapTable('getSelections', null);//获取
    	//console.log(checkArr);
    	if(checkArr.length==""){
    		$("#checkModalText").text("请选择一个需要修改的用户");
    		$("#checkModal").modal('show');
    	}else if(checkArr.length>=2){
    		$("#checkModalText").text("只能一次需要修改一个用户");
    		$("#checkModal").modal('show');
    	}else{
    		$("#editNickname").val(checkArr[0].nickname);
    		$("#editEmail").val(checkArr[0].email);
    		$("#editEmail").attr("oldData",checkArr[0].email);
    		$("#editPassword").val(checkArr[0].password);
    		$("#confirmEditPassword").val(checkArr[0].password);
    		$("#editName").val(checkArr[0].name);
    		$("#editBirthday").val(checkArr[0].birthday);
    		$("#editUserid").val(checkArr[0].userid);
    		if(checkArr[0].gender==1){
    			$('#editMale').attr("checked", true);
    		}else{
    			$('#editFemale').attr("checked", true);
    		}
    		
    		$("#editModal").modal('show');
    	}
    });
    
}

/**
 * @功能 在删除用户之前做相应的处理
 * 
 **/
function beforeDeleteUser(){
	$('#btn_delete').click(function(){
    	var checkArr = $('#tb_user').bootstrapTable('getSelections', null);//获取
    	if(checkArr.length==0){
    		$("#checkModalText").text("请选择需要删除的用户");
    		$("#checkModal").modal('show');
    	}else{
    		$("#deleteModalText").html("你将删除 <span style='color:red;'>"+checkArr.length+"</span>条数据");
    		$("#deleteModal").modal('show');
    	}
    });
}

/**
* @功能 删除用户[ajax提交]
**/
function deleteAjax(){
	$('#userDeleteBtn').click(function(){
    	var userList= new Array();
    	userList = $('#tb_user').bootstrapTable('getSelections', null);
    	for(i=0;i<userList.length;i++){
    		delete userList[i][0];
    	}
    	loading();
    	//ajax请求
    	$.ajax({
			   type: "POST",
			   url: "/"+projectName+"/user/deleteUser",
			   async:true,
			   dataType:"json",
			   contentType:"application/json", 
			   data: JSON.stringify(userList),
			   success: function(msg){
				   //var obj = jQuery.parseJSON(msg);
				   //console.log(msg);
				   if(msg.result==1){
				    	 $('#successModal').modal('show');
				     }else{
				    	 $('#failureModal').modal('show');
				     }	
				   
			   }
		});
    	loading_stop();
    	
    });
}
