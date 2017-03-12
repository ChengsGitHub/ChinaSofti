/**
 * Created by Administrator on 2016/11/22.
 * 控制器模块（控制器层）
 */
angular.module('stu.controller',[])
	.controller('stuController',['$scope','stuService',function($scope,stuService) {

		//调用业务功能获得数据
		var promise = stuService.query();

		promise.success(function(data){
			$scope.data = data; //绑定显式的数据
		});

		promise.error(function(){
			alert('获得数据失败');
		});

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
