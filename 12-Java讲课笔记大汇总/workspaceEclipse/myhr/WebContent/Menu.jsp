<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.menu1 {
		list-style: none;
		padding-left: 5px;
	}
	
	.menu1 li {
		margin-bottom: 10px;
		width: 160px;
		height: 36px;
		background-color: #C9E4FF;
		text-align: center;
		line-height: 36px;
		border-radius:20px;
	}
	
	.menu1 li a {
		color: #ffffff;
		font-size: 18px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<ul class="menu1">
		<li><a href="index.html" target="content">首页</a></li>
		<li><a href="QueryDeptServlet" target="content">部门管理</a></li>
		<li><a href="QueryJobServlet" target="content">职务管理</a></li>
		<li><a href="QueryEmpServlet" target="content">员工管理</a></li>
		<li><a href="Logout.jsp" target="_top">退出登陆</a></li>
	</ul>
</body>
</html>