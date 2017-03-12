/*
	cookie操作的常用方法集中到一个对象
*/
var cookie = {
	// 增加功能（参数，key键，value值，隔多少小时失效）
	add:function(key,val,hour) {
		if (hour > 0) {
			var date = new Date();	
			date.setTime(date.getTime() + hour * 60 * 60 * 1000);	
			document.cookie = key + '=' + val + ';expires=' + date.toGMTString();
		} else {
			document.cookie = key + '=' + val;
		}		
	},
	// 查询功能（传入键，返回值，如果不存在，返回null）
	get:function(key) {		
		var arrStr = document.cookie.split('; ');

		for (var i = 0;i < arrStr.length;i ++) {
			var temp = arrStr[i].split('=');

			if (key == temp[0]) {
				return temp[1];
			}
		}

		return null;
	},
	// 删除功能，删除指定键的cookie
	del:function(key) {
		var date = new Date();

		var index = document.cookie.indexOf(key);

		if (index == -1)
			alert('要删除的cookie不存在');
		else
			document.cookie = key + '=xxxx;expires=' + date.toGMTString();
	},
	// 返回当前域的所有cookie，返回一个对象，键作为属性名，值作为属性值  
	getAll:function() {
		var obj = {};

		var arrStr = document.cookie.split('; ');

		for (var i = 0;i < arrStr.length;i ++) {
			var temp = arrStr[i].split('=');

			obj[temp[0]] = temp[1];
		}

		return obj;
	}
}