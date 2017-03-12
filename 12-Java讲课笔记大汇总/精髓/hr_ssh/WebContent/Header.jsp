<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<style type="text/css">
			.bg1 {
				background-image:url(img/bannal_1.jpg);
			 }
		
			.status {
				background-color: #0099CC;
				height: 24px;
				text-align: right;
				line-height: 24px;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/style.css"> 
	</head>

	<body>
		<div class="bg1"><img src="img/bannal.jpg"></div>
		<div class="status">
			当前用户：${adminName } 
			身份：
			<c:if test="${adminLevel == '1' }">
				管理员
			</c:if>
			<c:if test="${adminLevel == '2' }">
				操作员
			</c:if>
		</div>
	</body>
</html>