window.onload = function() {

	// 轮播容器
	var container = document.getElementById('container');
	// 图片列表
	var list = document.getElementById('list');
	// 切换按钮组
	var buttons = document.getElementById('buttons').getElementsByTagName('span');
	// 左右箭头
	var prev = document.getElementById('prev');
	var next = document.getElementById('next');

	// 单幅图片宽度
	var imageWidth = 600;
	// 图片数量
	var imageCount = list.getElementsByTagName('img').length;
	// 当前索引
	var currIndex = 0;


	// 左箭头单击事件
	prev.onclick = function() {

		// 索引递增
		currIndex --;

		if (currIndex < 0)
			currIndex = imageCount - 1;

		animate(imageWidth);//运动

		highlight();//高亮
	}

	// 右箭头单击事件
	next.onclick = function() {

		// 索引递减
		currIndex ++;

		if (currIndex > imageCount - 1)
			currIndex = 0;

		animate(-imageWidth); //运行

		highlight();//高亮
	}

	// 遍历切换按钮组
	for (var i = 0;i < buttons.length;i ++) {

		(function(index){

			buttons[i].onclick = function() {						

				animate( -imageWidth * (index - currIndex) ); //运动
				currIndex = index;//记录当前索引
				highlight();//高亮
			}

		})(i);

	}

	/*运动函数*/
	function animate(offset) {		

		// 计算出新的位置
		var newLeft = parseInt(list.style.left) + offset;

		// 如果超过第一张，设置到最后一张的位置
		if (newLeft > 0)
			newLeft = -(imageCount - 1) * imageWidth;

		// 如果超过最后一张，设置到第一张的位置
		if (newLeft < -(imageCount - 1) * imageWidth)
			newLeft = 0;
		
		// 设置list图片列表的新位置
		list.style.left = newLeft + 'px';
	}

	/*高亮函数*/
	function highlight() {

		// 去掉所有高亮
		for (var i = 0;i < buttons.length;i ++) {
			buttons[i].className = '';
		}

		// 当前按钮高亮
		buttons[currIndex].className = 'on';

	}
}