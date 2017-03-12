
// 创建模块
var app = angular.module('app',[]);

// 创建控制器
app.controller('stuController', ['$scope', function($scope) {

	// 写死数据模型的数据
	$scope.data = [
		{
			id:100,
			name:'tom',
			age:27
		},
		{
			id:101,
			name:'jack',
			age:29
		},
		{
			id:102,
			name:'rose',
			age:17
		},
		{
			id:103,
			name:'张三',
			age:33
		},
		{
			id:104,
			name:'李四',
			age:23
		}
	];

	/*
		增加数据
	*/
	$scope.add = function() {

		var obj = {
			id:$scope.id,
			name:$scope.name,
			age:$scope.age
		}

		$scope.data.push(obj);

		reset();
	}

	/*
		删除数据
	*/
	$scope.del = function(index) {

		if (!window.confirm('确定要删除此数据吗？')) {
			return;
		}

		$scope.data.splice(index,1);

		reset();
	}


	/*
		获得数据
	*/
	$scope.get = function(index) {

		var obj = $scope.data[index];

		$scope.id = obj.id;
		$scope.name = obj.name;
		$scope.age = obj.age;

		// 记录本次选中的下标
		$scope.currIndex = index;
	}

	/*
		更新数据
	*/
	$scope.update = function() {

		var obj = {
			id:$scope.id,
			name:$scope.name,
			age:$scope.age
		}

		$scope.data[$scope.currIndex] = obj;

		reset();
	}

	/*
		清空数据
	*/
	function reset() {
		$scope.id = null;
		$scope.name = null;
		$scope.age = null;
		$scope.currIndex = null;
	}
	
}]); 