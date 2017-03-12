<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="../css/style.css">
		
		<script type="text/javascript">
			function del(empId) {
				var flag = window.confirm("确定要删除此员工吗")
				if (flag) {
					location.href="<%=request.getContextPath()%>/emp/delete.action?empId=" + empId;
				}
			}
		</script>
	</head>

	<body>

		<div id="content">
			请输入员工姓名<input type="text">请输入员工邮箱<input type="text"><input type="submit" value="检索">
			<table width="1000" border="0" align="center" cellpadding="4"
				cellspacing="0" class="table_border">
				<tr>
					<th width="70" height="24" bgcolor="#FFCC00">
						员工编号
					</th>
					<th width="95" height="24" bgcolor="#FFCC00">
						员工姓名
					</th>
					<th width="142" height="24" bgcolor="#FFCC00">
						邮箱
					</th>
					<th width="128" height="24" bgcolor="#FFCC00">
						电话
					</th>
					<th width="150" height="24" bgcolor="#FFCC00">
						入职时间
					</th>
					<th width="108" height="24" bgcolor="#FFCC00">
						职务
					</th>
					<th width="70" height="24" bgcolor="#FFCC00">
						工资
					</th>
					<th width="89" height="24" bgcolor="#FFCC00">
						部门
					</th>
					<th width="148" height="24" bgcolor="#FFCC00">
						操作
					</th>
				</tr>
				<c:forEach items="${list}" var="emp">
					<tr>
						<td height="24">
							${emp.empId }
						</td>
						<td height="24">
							<c:out value="${emp.empName}" />
						</td>
						<td height="24">
							<a href="#" title="点击此处给员工发送邮件"><c:out value="${emp.empEmail}" /></a>
						</td>
						<td height="24">
							<c:out value="${emp.empPhone}" />
						</td>
						<td height="24">
							<c:out value="${emp.empHiredate}" />
						</td>
						<td height="24">
							<c:out value="${emp.job.jobName}" />
						</td>
						<td height="24">
							￥<c:out value="${emp.empSalary}" />
						</td>
						<td height="24">
							<c:out value="${emp.dept.deptName}" />
						</td>
						<td height="24" align="center">
							<a href="<%=request.getContextPath() %>/emp/toUpdate.action?empId=${emp.empId }">修改</a>
							<a href="javascript:del(${emp.empId });">删除</a>
							<a href="<%=request.getContextPath() %>/photo/query.action?empId=${emp.empId }">照片</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="24" align="center">
						共${pager.recordCount }条数据，每页显示${pager.pageSize }条， 
						共${pager.pageCount }页，当前是第${pager.pageNum }页
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="24" align="center">
						<c:if test="${pager.pageNum != 1}">
							<a href="?pageNum=1">首页</a>
							<a href="?pageNum=${pager.pageNum-1 }">上页</a>
						</c:if>
						<c:if test="${pager.pageNum == 1}">
							<span style="color:gray">首页</span>
							<span style="color:gray">上页</span>
						</c:if>
						
						<c:if test="${pager.pageNum != pager.pageCount}">
							<a href="?pageNum=${pager.pageNum+1 }">下页</a>
							<a href="?pageNum=${pager.pageCount }">末页</a>
						</c:if>
						<c:if test="${pager.pageNum == pager.pageCount}">
							<span style="color:gray">下页</span>
							<span style="color:gray">末页</span>
						</c:if>
						
						到第
						<select onchange="location.href='?pageNum=' + this.value;">
							<c:forEach var="i" begin="1" end="${pager.pageCount }">
								<option value="${i }" ${pager.pageNum==i?'selected':'' }>${i }</option>
							</c:forEach>
						</select>
						页
						<br>
						<c:forEach var="i" begin="1" end="${pager.pageCount }">
								<c:choose>
									<c:when test="${pager.pageNum != i}">
										<a href="?pageNum=${i }">${i }</a>&nbsp;
									</c:when>
									<c:otherwise>
										<span style="color:red;font-weight: bold;">${i }</span>&nbsp;
									</c:otherwise>
								</c:choose>
						</c:forEach>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="24" align="center">
						<a href="<%=request.getContextPath()%>/emp/toAdd.action">增加新员工</a>
					</td>
				</tr>
			</table>

		</div>
	</body>
</html>