// 创建模块
var myApp = angular.module('myApp',[]);

// 创建控制器
myApp.controller('cartController', ['$scope', function($scope) {

	// 写死数据模型
	$scope.data = [
		{
			id:1000,
			name:'iphone6',
			quantity:9,
			price:5999
		},
		{
			id:1001,
			name:'iphone7',
			quantity:2,
			price:6999
		},
		{
			id:1002,
			name:'充电宝',
			quantity:4,
			price:129
		},
		{
			id:1003,
			name:'牛仔裤',
			quantity:3,
			price:99
		}
	];

	/*
		计算总数量
	*/
	$scope.getQty = function() {

		var totalQty = 0;//总数量

		// angularjs自带的遍历语句
		angular.forEach($scope.data,function(item){
			totalQty += parseInt(item.quantity); //转换为数字累加
		});

		return totalQty;
	}

	/*
		计算总价格
	*/
	$scope.getTotalPrice = function() {

		var totalPrice = 0;

		// angularjs自带的遍历语句
		angular.forEach($scope.data,function(item){
			totalPrice += parseInt(item.quantity) * item.price; //累加数量*单价
		});

		return totalPrice;
	}

	/*
		修改数量
	*/
	$scope.updateQty = function(index,val) {

		// 判断是否小于等于0
		if ( parseInt($scope.data[index].quantity) + val <= 0) {
			if ( confirm('是否删除此商品') ) {
				$scope.data.splice(index,1);				
			}

			return;
		}

		// 判断是否大于10
		if ( parseInt($scope.data[index].quantity) + val > 10) {
			alert('购买数量不能超过10个');
			return;
		}

		// 更新数量
		$scope.data[index].quantity = parseInt($scope.data[index].quantity) + val;
	}

	/*
		检测data中数量的变化
	*/
	$scope.$watch('data',function(newVal,oldVal) {

		// 遍历数组进行数据合法性检查
		angular.forEach($scope.data,function(item,index) {			

			// 判断是否为空，非数字，带小数点
			if ( !item.quantity || isNaN(item.quantity) || item.quantity.toString().indexOf('.') != -1) {				
				item.quantity = oldVal[index].quantity; //修改为之前的值
			}

			//判断是否小于等于0或者大于10
			if ( parseInt(item.quantity) <= 0 || parseInt(item.quantity) > 10 ) {
				alert('数量只能是1~10之间');
				item.quantity = oldVal[index].quantity; //修改为之前的值
			}

		});

	},true);

	/*
		移除商品
	*/
	$scope.del = function(index) {

		$scope.data.splice(index,1);
		
	}
	
}]);