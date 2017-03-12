require.config({
	paths: {
		"jquery": ["http://libs.baidu.com/jquery/2.0.3/jquery", "jquery.1.9"],
		"a": "a"
	}
});

//引用上面的jquery.js和本地的a.js
require(["jquery","a"],function($,a){
	
	$(document).ready(function() {
		alert('加载完毕,' + a);	
	});

});