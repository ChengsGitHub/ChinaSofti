(function(){

	function m1() {
		alert('a.js m1');
	}

	m1();

	//定义一个输出变量返回
	if ( typeof define === "function" && define.amd ) {
		define( "a", [], function () { return "hello,a.js"; } );
	}

})();