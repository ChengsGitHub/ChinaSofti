$(document).ready(function(){
	
	// 滚动条事件
	$(window).scroll(function(event) {
		
		// 获得滚动条卷去的大小
		var sTop = $(window).scrollTop();		

		// 如果滚动条超过200像素，显示回到顶部的按钮
		if (sTop >= 200) {
			$('.toolbar-item-top').show();			
		} else {
			$('.toolbar-item-top').hide();
		}

	});

	// 滚动条回到顶部
	$('.toolbar-item-top').click(function(event) {
		
		$('html,body').animate({scrollTop:0}, 1000);

	});

});