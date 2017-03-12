<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">

	.bg_img {
		background-image: url(img/bannal_1.jpg);
	}

</style>
</head>
<body>
	<div class="bg_img">
		<img src="img/bannal.jpg">
	</div>
	<div style="background-color: #0099CC;height: 26px;text-align: right;line-height: 26px;">
		用户名：${admin.adminName }，级别：${admin.adminLevel==1?'管理员':'操作员' }
	</div>
</body>
</html>