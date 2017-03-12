//定义了一个模块,依赖了jquey模块，模块之间也可以依赖
define(['jquery'],function($){

	return {
		isEmpty:function() {

		},
		checkLength:function() {

		},
		isEqual:function(str1,str2) {
			return str1 === str2;
		}
	}

});