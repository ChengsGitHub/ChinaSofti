<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
			
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
		
		<script type="text/javascript">
			function del(photoId,empId,photoPath) {
			
				var flag = window.confirm("确定要删除此照片吗")
				if (flag) {
					location.href = "<%=request.getContextPath()%>/photo/delete.action?photoId=" + photoId + "&empId=" + empId + "&photoPath=" + photoPath;
				}
			}
		</script>

	</head>

	<body>
		<div id="content">
	
		<table width="500" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="24" align="center">
					<a href="../AddPhoto.jsp?empId=${param.empId}">添加员工照片</a>
					<a href="<%=request.getContextPath()%>/emp/query.action">关闭窗口</a>
				</td>
			</tr>
		</table>
		

		<c:forEach items="${list}" var="photo">
			<div style="float: left;margin-right: 10px;margin-bottom: 10px;">
				<a href="<%=request.getContextPath()%>/upload/${photo.photoPath}" target="_blank">
				<img width="180" height="150" src="<%=request.getContextPath()%>/upload/${photo.photoPath}" border="0">
				</a>			
				<br><a href="javascript:del(${photo.photoId},${param.empId},'${photo.photoPath}');">删除此图片</a>
			</div>
		</c:forEach>
		
		</div>
	</body>
</html>
