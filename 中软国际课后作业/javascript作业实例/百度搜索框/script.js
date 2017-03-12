window.onload = function() {

	// 获得元素对象
	var searchInput = document.getElementById('searchInput');
	var searchTips = document.getElementById('searchTips');
	var tipsItems = searchTips.getElementsByTagName('li');

	// 选中元素索引
	var keyIndex = -1;

	// 文本框获得焦点事件显示提示内容
	searchInput.onfocus = function(e) {		
		searchTips.style.display = 'block';
	}

	// 阻止文本框单击事件冒泡
	searchInput.onclick = function(e) {
		e = e || window.event;
		e.stopPropagation?e.stopPropagation():e.cancelBubble=true;
	}

	// document单击事件隐藏提示内容
	document.onclick = function(e) {
		resetSearchTips();
	}

	// 文档键盘按下事件
	document.onkeydown = function(e) {

		// 判断提示框是否显示
		if (searchTips.style.display != 'block')
			return;

		e = e || window.event;

		// esc键隐藏提示内容
		if (e.keyCode == 27) {
			resetSearchTips();
			searchInput.blur();
		}

		// 下箭头
		if (e.keyCode == 40) {

			keyIndex ++;

			if (keyIndex > tipsItems.length - 2)
				keyIndex = 0;

			highlightItem(keyIndex);//调用高亮功能
		}

		// 上箭头
		if (e.keyCode == 38) {

			keyIndex --;

			if (keyIndex < 0)
				keyIndex = tipsItems.length - 2;

			highlightItem(keyIndex);//调用高亮功能
		}

		// 回车键
		if (e.keyCode == 13) {
			searchInput.value = tipsItems[keyIndex].getElementsByTagName('span')[0].innerText;
			resetSearchTips();
		}
	}

	//遍历li，循环添加事件
	for (var i = 0;i < tipsItems.length - 1;i ++) {

		//元素单击事件
		tipsItems[i].onclick = function(e) {
			searchInput.value = this.getElementsByTagName('span')[0].innerText;
		};

		(function(currIndex){

			// 元素鼠标悬停事件
			tipsItems[i].onmouseover = function() {
				highlightItem(-1);
				keyIndex = currIndex; // 当前的li的下标索引赋值给keyIndex
			}

		})(i);

		// 获得li中的删除按钮对象
		var a = tipsItems[i].getElementsByTagName('a')[0];

		//删除按钮单击事件
		a.onclick = function(e) {
			e = e || window.event;
			e.stopPropagation?e.stopPropagation():e.cancelBubble=true;
			searchTips.removeChild(this.parentNode);
			keyIndex = -1;
		}
	}

	/*
		元素高亮
	*/
	function highlightItem(index) {

		// 去掉所有高亮
		for (var i = 0;i < tipsItems.length - 1;i ++) {
			tipsItems[i].className = '';
		}

		//单独给指定索引元素加高亮
		try {
			tipsItems[index].className = 'active';
		} catch (e) {

		}	
	}

	/*
		重置提示框
	*/
	function resetSearchTips() {
		searchTips.style.display = 'none';
		highlightItem(-1);
		keyIndex = -1;
	}

}