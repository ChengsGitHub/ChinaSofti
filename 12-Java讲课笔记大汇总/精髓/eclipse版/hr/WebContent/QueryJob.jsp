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
		
		<script type="text/javascript">
			function del(jobId) {
				var flag = window.confirm("确定要删除此职务吗？")
				if (flag) {
					location.href="DeleteJobServlet?jobId=" + jobId;
				}
			}
			
		</script>
	</head>

	<body>

		<div id="main">

			<table width="700" border="0" align="center" cellpadding="4"
				cellspacing="1" bgcolor="#CCCCCC">
				<tr>
					<th width="20%" height="24" align="center" bgcolor="#FFCC00">
						职务编号
					</th>
					<th width="20%" height="24" align="center" bgcolor="#FFCC00">
						职务名称
					</th>
					<th width="20%" height="24" align="center" bgcolor="#FFCC00">
						最低工资
					</th>
					<th width="20%" height="24" align="center" bgcolor="#FFCC00">
						最高工资
					</th>
					<th width="20%" height="24" align="center" bgcolor="#FFCC00">
						操作
					</th>
				</tr>

				<c:forEach items="${list}" var="job">
					<tr>
						<td width="20%" height="24" bgcolor="#FFFFFF">
							<c:out value="${job.jobId}" />
						</td>
						<td width="20%" height="24" bgcolor="#FFFFFF">
							<c:out value="${job.jobName}" />
						</td>
						<td width="20%" height="24" bgcolor="#FFFFFF">
							<c:out value="${job.jobMinSalary}" />
						</td>
						<td width="20%" height="24" bgcolor="#FFFFFF">
							<c:out value="${job.jobMaxSalary}" />
						</td>
						<td width="20%" height="24" align="center" bgcolor="#FFFFFF">
							<a href="ToUpdateJobServlet?jobId=${job.jobId}">修改</a>
							<a href="javascript:del('${job.jobId}');">删除</a>
						</td>
					</tr>
				</c:forEach>

			</table>
			<p align="center">
				<a href="InsertJob.jsp">增加新职务</a>
			</p>

		</div>

	</body>
</html>