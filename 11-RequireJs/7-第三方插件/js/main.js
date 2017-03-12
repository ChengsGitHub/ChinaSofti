require.config({
	baseUrl: 'js', //如果是基于服务器环境，此处最好设置为相对于根目录的路径
	paths: {
		"jquery":"jquery.1.9",
		"datepicker":"datepicker/jquery.datetimepicker"		
	},
	shim:{
		"datepicker" : {
			deps : ["jquery"]  //指明插件的依赖关系，也可以简写为"datepicker" : ["jquery"]
		}
	}
});