<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.icss.hr.job.po.*"%>
<%@page import="java.util.*"%>
<%
	//从request范围中取出数据,request.getAttribute()返值为Object类型，需要强转
	ArrayList<Job> list = (ArrayList<Job>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>职务管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function del(jobId) {
		var flag = window.confirm("确定删除?");
		if (flag) {
			location.href = 'DeleteJobServlet?jobId=' + jobId;
		}
	}
</script>
</head>
<body>

	<table border="0" cellspacing="0" width="800" class="table1" align="center">
		<tr id="tr1">
			<th width="20%" height="24" bgcolor="#00CCFF">职务编号</th>
			<th width="20%" height="24" bgcolor="#00CCFF">职务名称</th>
			<th width="20%" height="24" bgcolor="#00CCFF">最低工资</th>
			<th width="20%" height="24" bgcolor="#00CCFF">最高工资</th>
			<th width="20%" height="24" bgcolor="#00CCFF">操作</th>
		</tr>
		<%for (Job job : list) {%>
		<tr>
		  <td width="20%" height="24"><%=job.getJobId()%></td>
		  <td width="20%" height="24"><%=job.getJobName()%></td>
		  <td width="20%" height="24">￥<%=job.getJobMinSalary()%></td>
		  <td width="20%" height="24">￥<%=job.getJobMaxSalary()%></td>
			<td width="20%" height="24">
				<a href="ToUpdateJobServlet?jobId=<%=job.getJobId()%>">修改</a> 
				<a href="javascript:del('<%=job.getJobId()%>');">删除</a>
			</td>
		</tr>
		<%}%>
	</table>

	<p align="center">
		<a href="AddJob.html">增加新职务</a>
	</p>

</body>
</html>