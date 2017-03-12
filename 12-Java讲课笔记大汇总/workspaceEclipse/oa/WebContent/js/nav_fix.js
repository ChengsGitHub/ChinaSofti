// JavaScript Document
$(function () {
	var ie6 = /msie 6/i.test(navigator.userAgent)
	, dv = $('#mainNav'), st;
	dv.attr('otop', dv.offset().top); //存储原来的距离顶部的距离
	$(window).scroll(function () {
		st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
		if (st >= parseInt(dv.attr('otop'))) {			
			dv.addClass('navbar-fixed-top');	
			dv.css('top',$('#topNav').height());			
		} else if (dv.css('position') != 'static') {
			//dv.css({ 'position': 'static' });
			dv.removeClass('navbar-fixed-top');
		}
	});
});