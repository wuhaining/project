/**
 * @author wuhn
 * @创建时间 2016-05-09
 * @功能 jquery插件初始化+扩展extend
 */

$(function(){
/**
 * @功能 loading预加载 
 * @说明 使用spin.js插件
 * 		如果使用jquery必须加上以下这段代码
 * **/
$.fn.spin = function(opts) {
	  this.each(function() {
	    var $this = $(this),
	        data = $this.data();

	    if (data.spinner) {
	      data.spinner.stop();
	      delete data.spinner;
	    }
	    if (opts !== false) {
	      data.spinner = new Spinner($.extend({color: $this.css('color')}, opts)).spin(this);
	    }
	  });
	  return this;
};

});

/**
 * @param element 目标元素 默认body
 * @param color 颜色 默认#fff
 * **/
function loading($element,color){
	var obj = $.extend({},{element:$('body'),color:'#26C281'},{element:$element,color:color});
	var html = '<div id="mask" class="mask"></div>';	
	obj.element.append(html);
	showMask();
	obj.element.spin();//初始化loading
	obj.element.spin({color: obj.color});//设置颜色	
}
//隐藏loading
function loading_stop($element){
	var obj = $.extend({},{element:$('body')},{element:$element});
	obj.element.spin(false);//消除loading
	hideMask();
}

//显示遮罩层    
function showMask(){     
    $("#mask").css("height",$(document).height());     
    $("#mask").css("width",$(document).width());     
    $("#mask").show();     
}  
//隐藏遮罩层  
function hideMask(){           
    $("#mask").remove();     
}  