/*
	WebWorker多线程程序
	每隔1秒钟执行一次定时器语句
*/
var i = 1;

setInterval(function(){
	console.log(i);
	postMessage(i);//回传数据给主程序（产生onmessage事件行为）
	i ++;
},1000);