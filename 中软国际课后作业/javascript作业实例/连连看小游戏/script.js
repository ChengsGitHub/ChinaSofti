// 18对（36张）图片的隐含位置
var map = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 
12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18];

var finished = 0;//完成的数量
var finishedArray = [];//记录图片的状态（true已完成 false未完成）
var oktoclick;//是否允许单击图片
var click1,click2;//单击过的两张图片数组下标 click1是第一张 click2是第二张
var clickCount = 0;//单击次数

/*初始化函数*/
function init() {

	//开始按钮
	var startBtn = document.getElementById('startBtn');
	startBtn.value = '游戏进行中';
	startBtn.disabled = true;
	startBtn.style.color = '#666';

	// 默认所有图片都是未完成，所有图片都是默认图片img0.gif
	for (var i = 0;i < 36;i ++) {
		finishedArray[i] = false;
		document.getElementById('img' + i).src = 'img0.gif';
	}

	finished = 0;//完成数量清零
	oktoclick = true;//设置图片允许单击

	scramble();//混淆图片位置

	console.log(map);
}

/*混淆图片位置函数*/
function scramble() {

	var r;//0-35的随机下标
	var temp;//临时变量

	for (var i = 0;i < 36;i ++) {
		// 产生随机数
		r = parseInt( (35 - 0 + 1) * Math.random() + 0 );

		// 随机交换位置
		temp = map[i];
		map[i] = map[r];
		map[r] = temp;
	}
}

/*显示图片的函数*/
function showImage(imgNum) {	

	// 判断重复点击图片
	if (click1 == imgNum)
		return;

	// 判断是否点击已经完成的图片
	if (finishedArray[imgNum])
		return;

	// 如果图片允许点击
	if (oktoclick) {

		// 设置为不允许点击显示图片
		oktoclick = false;

		// 根据下标获得图片的对象
		var imgObj = document.getElementById('img' + imgNum);

		// 根据下标显示map数组中对应的图片
		imgObj.src = 'img' + map[imgNum] + '.gif';

		// 判断是第几次点开图片
		if (clickCount == 0) { //如果当前点击次数是0,表示是第一张
			clickCount ++; //点击次数+1
			click1 = imgNum;//记录图片1的下标
			oktoclick = true; //设置为允许点击显示图片

		} else {
			clickCount = 0;//计数清零
			click2 = imgNum;//记录图片2的下标

			//延迟调用判断函数，来判断当前结果
			setTimeout(finalCheck,600);
		}

	}

}

/*结果判断函数*/
function finalCheck() {

	// 判断两次单击的是否是相同图片，相同：完成数量+1，不相同：恢复成默认图片
	if ( map[click1] == map[click2] ) {

		// 设置图片为完成的状态
		finishedArray[click1] = true;
		finishedArray[click2] = true;

		finished ++;//完成数量+1
	} else {
		// 恢复为默认图片
		document.getElementById('img' + click1).src = 'img0.gif';
		document.getElementById('img' + click2).src = 'img0.gif';
	}

	// 复原click1和click2
	click1 = null;
	click2 = null;

	// 判断是否完成所有的图片
	if (finished == 18) {
		alert('恭喜你，过关！');

		//开始按钮
		var startBtn = document.getElementById('startBtn');
		startBtn.value = '再玩一次';
		startBtn.disabled = false;
		startBtn.style.color = '#000';
	} else {
		oktoclick = true;
	}

}