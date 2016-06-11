/**
 * @功能 require.js全局配置
 * @页面 <script data-main="js/main" src="js/require.js"></script>
 **/


require.config({
    paths : {
        "jquery" : ["//cdn.bootcss.com/jquery/1.11.3/jquery.min", "js/jquery-1.11.3.min"],
        "bootstrap" : ["//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min", "../../resources/plugin/bootstrap/bootstrap.min"],
        "jqueryValidate" : ["./../js/common/jqueryValidate"],
        "jv" : ["./../js/plugin/jqueryValidation/dist/jquery.validate"],
        "jv.messages_zh" : ["../../resources/plugin/jqueryValidation/dist/localization/messages_zh"],
        "jv.additional-methods" : ["../../resources/plugin/jqueryValidation/dist/additional-methods"],
       
    },
	shim : {
		"bootstrap" : ["jquery"],
		"jv" : ["jquery"],
		"jv.messages_zh" : ["jquery"],
		"jv.additional-methods" : ["jquery"]
	}
})

require(["resources/js/common/bootstrapInit.js"])
require(["resources/js/common/routeMap.js"])