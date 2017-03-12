<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.job.po.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script type="text/javascript">
	function del(jobId) {
		var flag = window.confirm("确认删除" + jobId + "此职务么");
		if(flag) {
			location.href="<%=request.getContextPath()%>/job/delete.action?jobId=" + jobId;
		}
	}
</script>
<html>
	<head>


		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">


		<link rel="stylesheet" type="text/css" href="../css/style.css">


	</head>

	<body>
		<div id="content">
			<table width="100%" border="0" cellpadding="4" class="table_border">
				<tr>
					<th width="20%" height="24" bgcolor="#FFCC33">
						职务编号
					</th>
					<th width="20%" height="24" bgcolor="#FFCC33">
						职务名称
					</th>
					<th width="20%" height="24" bgcolor="#FFCC33">
						最低工资
					</th>
					<th width="20%" height="24" bgcolor="#FFCC33">
						最高工资
					</th>
					<th width="20%" height="24" bgcolor="#FFCC33">
						操作
					</th>
				</tr>
				<c:forEach items="${list}" var="job">
					<tr>
						<td width="20%" height="24">
							${job.jobId}
						</td>
						<td width="20%" height="24">
							<c:out value="${job.jobName}"/>
						</td>
						<td width="20%" height="24">
							<c:out value="${job.jobMinSalary}"/>
						</td>
						<td width="20%" height="24">
							<c:out value="${job.jobMaxSalary}"/>
						</td>
						<td width="20%" height="24">
							<a href="<%=request.getContextPath() %>/job/toUpdate.action?jobId=${job.jobId}">修改</a>
							<a href="javascript:del('${job.jobId}');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p align="center"><a href="../AddJob.jsp">增加新职务</a></p>
		</div>
	</body>
</html>
