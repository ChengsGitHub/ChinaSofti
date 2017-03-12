<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" target="text/css" href="css/style.css">
		
		<script type="text/javascript">
			function del(empId) {
				var flag = window.confirm("确定要删除此员工吗？");
				if (flag) {
					location.href='DeleteEmpServlet?empId=' + empId;
				}
			}
		</script>
	</head>

	<body>
		<div id="main">
	
		<table width="800" border="0" align="center" cellpadding="4"
			cellspacing="0" class="table_border1">
			<tr>
				<th width="65" height="24" bgcolor="#FFCC00">
					员工编号
				</th>
				<th width="69" height="24" bgcolor="#FFCC00">
					员工姓名
				</th>
				<th width="109" height="24" bgcolor="#FFCC00">
					邮箱
				</th>
				<th width="101" height="24" bgcolor="#FFCC00">
					电话
				</th>
				<th width="125" height="24" bgcolor="#FFCC00">
					入职时间
				</th>
				<th width="71" height="24" bgcolor="#FFCC00">
					职务
				</th>
				<th width="61" height="24" bgcolor="#FFCC00">
					工资
				</th>
				<th width="86" height="24" bgcolor="#FFCC00">
					部门
				</th>
				<th width="113" height="24" bgcolor="#FFCC00">
					操作
				</th>
			</tr>
			
			<c:forEach items="${list}" var="emp">
			<tr>
				<td height="24">
					<c:out value="${emp.empId}"/>
				</td>
				<td height="24">
					<c:out value="${emp.empName}"/>
				</td>
				<td height="24">
					<c:out value="${emp.empEmail}"/>
				</td>
				<td height="24">
					<c:out value="${emp.empPhone}"/>
				</td>
				<td height="24">
					<c:out value="${emp.empHiredate}"/>
				</td>
				<td height="24">
					<c:out value="${emp.job.jobName}"/>
				</td>
				<td height="24">
					￥<c:out value="${emp.empSalary}"/>
				</td>
				<td height="24">
					<c:out value="${emp.dept.deptName}"/>
				</td>
				<td height="24" align="center">
					<a href="ToUpdateEmpServlet?empId=${emp.empId}">修改</a>
					<a href="javascript:del(${emp.empId});">删除</a>
					<a href="QueryPhotoServlet?empId=${emp.empId}">照片</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="24" align="center">
					共${pager.recordCount }条数据，
					每页${pager.pageSize }条，
					共${pager.pageCount }页，
					当前是第${pager.pageNum }页
				</td>
			</tr>
		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="24" align="center">
					<c:if test="${pager.pageNum!=1}">
						<a href="?pageNum=1">首页</a>
						<a href="?pageNum=${pager.pageNum-1 }">上页</a>
					</c:if>
					
					<c:if test="${pager.pageNum==1}">
						首页
						上页
					</c:if>
					
					<c:if test="${pager.pageNum!=pager.pageCount}">
						<a href="?pageNum=${pager.pageNum+1 }">下页</a>
						<a href="?pageNum=${pager.pageCount }">末页</a>
					</c:if>
					
					<c:if test="${pager.pageNum==pager.pageCount}">
						下页
						末页
					</c:if>
					
					到第
					<select onchange="location.href='?pageNum=' + this.value;">
						<c:forEach begin="1" end="${pager.pageCount }" var="i">
							<option value="${i }" ${pager.pageNum==i?'selected':''}> ${i} </option>
						</c:forEach>	
					</select>
					页
				</td>
			</tr>
		</table>
		<p align="center">
			<a href="ToInsertEmpServlet">增加新员工</a>
		</p>

		</div>
	</body>
</html>