/**
 * @author wuhn
 * @创建时间 2016-03-10
 * @功能 权限列表
 */
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    
    //2.条件查询
    var searchData = new tb_searchInit();
    searchData.Init();
    
    
    //3.角色修改
    $("#btn_manager").click(function(){
    	var checkArr = $('#tb_permission').bootstrapTable('getSelections', null);//获取
    	if(checkArr.length==""){
    		$("#checkModalText").text("请选择需要授权的用户");
    		$("#checkModal").modal('show');
    	}else{
    		$("#managerRole").html('');
    		for(var i=0;i<checkArr.length;i++){
    			var html = '<tr><td style="display:none;"><input type="hidden" value="'+checkArr[i].userid+'"/></td>'
    					   +'<td>'+checkArr[i].nickname+'</td>'
    					   +'<td><a id="userRoleValue_'+i+'" href="javascript:void(0);" class="userRole"></a></td></tr>';
    			
    			$("#managerRole").append(html);
    			userRoleUpdate();
    			$("#userRoleValue_"+i).editable('setValue', checkArr[i].role, false);
    			
    			
    		}
    		$("#managerModal").modal('show');
    	}
    	
    	
    });
    
});


/**
 * @功能 表格的列参数设置[父级]
 * **/
var setColumnsProOne = [
		{checkbox: true,align:'center'}, 
		{field: 'nickname',title: '昵称',align:'center'},
		{field: 'email',title: '电子邮件',align:'center'},
		{field: 'role',title: '角色',align:'center',
			formatter:function(value,row,index){
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
		},
		{field: 'name',title: '真名',visible:false}, 
		{field: 'gender',title: '性别',visible:false}, 
		{field: 'birthday',title: '生日',visible:false}, 
		{field: 'userid',title: 'userId',visible:false}
		];


/**
 * @功能 表格的列参数设置[子级]
 * **/
var setColumnsPro = [
         {field: 'nickname',title: '昵称',align:'center'}, 
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
         /*
         {field: 'role',title: '角色',align:'center',formatter:function(value,row,index){
             	if(row.role=="USER"){
             		return '<span style="color:red;">基本权限</span>';
             	}else if(row.role=="SYS_USER"){
             		return '<span style="color:blue;">系统管理员权限</span>';
             	}else if(row.role=="SYS_ADMIN"){
             		return '<span style="color:green;">系统最高权限</span>';
             	}else{
             		return '<span style="color:#9F978E;">未赋予任何权限</span>';
             	}
             	
             }		
         }
         */];




/**
 * @功能 表格初始化
 * **/
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_permission').bootstrapTable({
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
            detailView: true,                   //是否显示父子表
            columns: setColumnsProOne,
            onExpandRow:function(index, row, $detail){
            	//console.log(""+index);//父表当前行的行索引
            	//console.log(""+row.birthday);//父表当前行的Json数据对象
            	//console.log(""+$detail);//当前行下面创建的新行里面的td对象,第三个参数尤其重要，因为生成的子表的table在装载在$detail对象里面的。bootstrap table为我们生成了$detail这个对象，然后我们只需要往它里面填充我们想要的table即可。
            	oTableInit.InitSubTable(index, row, $detail);
            }
            
        });
    };

    
    
    //创建子表
    //初始化子表格(无线循环)
    oTableInit.InitSubTable = function (index, row, $detail) {
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable( {
            //url: "",
            //method: 'get',
            //queryParams: { strParentID: parentid },
            //ajaxOptions: { strParentID: parentid },
            //clickToSelect: true,
            //detailView: true,//父子表
            uniqueId: "",
            columns: setColumnsPro,
            data: [{nickname: row.nickname,email: row.email,name: row.name,gender: row.gender,birthday: row.birthday}],
            /*无线循环取子表，直到子表里面没有记录
            onExpandRow: function (index, row, $Subdetail) {
            	oTableInit.InitSubTable(index, row, $Subdetail);
            }*/
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
    
    return oTableInit;
};


/**
 * @功能 条件查询
 * **/
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
    			     console.log(parameter);
    			     $('#tb_permission').bootstrapTable('load', parameter);//bootstrap-table的重新加载数据	
    			     $('#tb_permission').bootstrapTable('selectPage', 1);//跳到第一页
    			   }
    			});
        	
        });
    }
    return btn_searchInit;
    
}


/**
 * @功能 权限管理的角色修改
 * **/
function userRoleUpdate(){
	$('.userRole').editable({
    	type: 'select',pk: 1,title: '请选择角色',showbuttons: false,
        source: "/"+projectName+"/permission/roleSelect",//加载下拉列数据
        sourceCache:true,
        sourceError:'数据加载失败。。。',
        url: "",//点击时提交
        success: function(response, newValue) {      		
            	var userid = $(this).parent().prev().prev().children('input').val();
            	$.ajax({
                    type: "get",
                    dataType: 'json',  
                    url: "/"+projectName+"/permission/userRole",
                    data: {userid:userid,role:newValue},
                    success: function (data, status) {
                    	if (status == "success") {
                    		console.log(data);
                    	}
                    }
                });
        }
        
    });
}