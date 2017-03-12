<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.dept.po.Dept" %>
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
			/*删除确认*/
			function del(deptId) {
				var flag = window.confirm("确定要删除此部门吗？");
				if (flag) {
					location.href="delete.action?deptId=" + deptId;					
				}
			}
		</script>
	</head>

	<body>

		<div id="content">
			<table width="100%" border="0" cellspacing="0" cellpadding="4" class="table_border">
				<tr>
					<th width="25%" height="24" align="center" bgcolor="#FFCC00">
						部门编号
					</th>
					<th width="25%" height="24" align="center" bgcolor="#FFCC00">
						部门名称
					</th>
					<th width="25%" height="24" align="center" bgcolor="#FFCC00">
						部门地址
					</th>
					
					<c:if test="${sessionScope.adminLevel==1 }">
					<th width="25%" height="24" align="center" bgcolor="#FFCC00">
						操作
					</th>
					</c:if>					
				</tr>
				<c:forEach items="${list}" var="dept">
				<tr>
					<td height="24">
						${dept.deptId}
					</td>
					<td height="24">
						<c:out value="${dept.deptName}"/>
					</td>
					<td height="24">
						<c:out value="${dept.deptLoc}"/>
					</td>
					<c:if test="${sessionScope.adminLevel==1 }">
					<td height="24" align="center">
						<a href="toUpdate.action?deptId=${dept.deptId}">修改</a>
						<a href="javascript:del(${dept.deptId});">删除</a>
					</td>
					</c:if>
				</tr>
				</c:forEach>
			</table>
			
			<c:if test="${sessionScope.adminLevel==1 }">
				<p align="center">
					<a href="../AddDept.html">增加新部门</a>
				</p>			
			</c:if>

		</div>

	</body>
</html>