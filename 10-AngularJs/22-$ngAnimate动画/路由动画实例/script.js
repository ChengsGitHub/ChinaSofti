// 注入路由和动画
var myapp = angular.module('myapp', ['ngRoute', 'ngAnimate']);

myapp.config(['$routeProvider', function ($routeProvider) {

	/*配置路由,otherwise表示不符合以上路由地址的默认跳转地址*/
	$routeProvider
		.when('/', {
			templateUrl: 'pages/home.html',
			controller: 'mainController'
		})
		.when('/about', {
			templateUrl: 'pages/about.html',
			controller: 'aboutController'
		})
		.when('/contact/:cid/:cname', { //可以传递参数
			templateUrl: 'pages/contact.html',
			controller: 'contactController'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);

/*run方法是初始化作用域的一些数据的*/
myapp.run(['$rootScope', function ($rootScope) {

	/*路由事件，可以在路由发生时触发事件，用处不大
	 $routeChangeStart 路由开始时
	 $routeChangeSuccess 路由完成时
	 $routeChangeError 路由发生错误时

	 回调函数三个参数：event事件对象 current当前路由页面对象 pre路由前上一个页面对象
	 */
	$rootScope.$on('$routeChangeStart', function (event, current, pre) {
		console.log('路由开始');
		console.log(event);
		console.log(current);
		console.log(pre);
	});

}]);

/*设置三个不同的控制器*/
myapp.controller('mainController', function ($scope) {
	$scope.message = 'Everyone come and see how good I look!!!';
});

myapp.controller('aboutController', function ($scope) {
	$scope.message = 'Look! I am an about page.';
});

// 通过$routeParams这个对象可以获得路由参数
myapp.controller('contactController', function ($scope, $routeParams) {
	$scope.message = 'Contact us! JK. This is just a demo.';
	$scope.cid = $routeParams.cid;
	$scope.cname = $routeParams.cname;
});