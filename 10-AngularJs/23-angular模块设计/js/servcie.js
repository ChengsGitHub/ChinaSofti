/**
 * Created by Administrator on 2016/11/22.
 * 业务模块（模型层）
 * （在这里创建各种服务）
 */
angular.module('stu.service',[ ])
	/*学生操作的服务对象*/
	.service('stuService',['$http',function($http) {
		return {
			/**
			 * 查询数据功能
			 * @returns {HttpPromise}
			 */
			query:function() {
				var promise = $http.get('js/data.json');
				return promise;
			}
		}
	}]);
