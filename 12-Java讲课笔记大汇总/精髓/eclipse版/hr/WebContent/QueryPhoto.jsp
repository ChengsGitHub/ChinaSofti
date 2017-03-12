<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" target="text/css" href="css/style.css">

		<style type="text/css">
.img {
	float: left;
	width: 200px;
	heigth: 150px;
	margin-right: 5px;
	margin-bottom: 10px;
}
</style>
	</head>

	<body>

		<div id="main">

			<div align="center">
				<a href="InsertPhoto.jsp?empId=${param.empId }">添加${param.empId}号员工照片</a>
			</div>

			<c:forEach items="${list}" var="photo">

				<div class="img">
					<a href="upload/${photo.photoPath }" target="_blank" title="查看原图">
						<img width="200" height="150" src="upload/${photo.photoPath }" />
					</a>
					<br>
					<div align="center">
						<a
							href="DeletePhotoServlet?photoId=${photo.photoId }&photoPath=${photo.photoPath }&empId=${param.empId}">删除</a>
					</div>
				</div>

			</c:forEach>

		</div>
	</body>
</html>