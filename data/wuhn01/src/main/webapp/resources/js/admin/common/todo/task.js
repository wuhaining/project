/**
 * @author wuhn
 * @创建时间 2016-03-17
 * @功能 待办任务
 */

$(function(){
	//1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});


//表格初始化
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_task').bootstrapTable({
            url: '',         //请求后台的URL（*）
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
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "taskId",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: setColumnsPro,
                    
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
        };
        return temp;
    };
    
    //表格的列参数设置
    var setColumnsPro = [
    {
        checkbox: true,
        align:'center'
    }, {
        field: 'taskId',
        title: '任务Id',
        align:'center'
    }, {
        field: 'taskName',
        title: '任务名称',
        align:'center'
    }, {
        field: 'taskHandle',
        title: '任务的办理人',
        align:'center'
    }, {
        field: 'taskTime',
        title: '任务的申请时间',
        align:'center'
    }, {
        field: 'taskDelete',
        title: '删除',
        align:'center'
    }, {
        field: 'taskManage',
        title: '办理',
        align:'center'
    }			
    ];
    
    return oTableInit;
};