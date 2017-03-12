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
		<link rel="stylesheet" target="text/css" href="css/jquery.datepick.css">
				
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.datepick.js"></script>
		<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>
		
		<script type="text/javascript">
			//日历框
			$(document).ready(function(){				
				$('#empHiredate').datepick({dateFormat: 'yy-mm-dd'});				
			});					
			
			//设置最低和最高工资
			function showSalary() {
				var jobId = document.form1.jobId;
				
				if (jobId.value == "") {
					document.form1.jobMinSalary.value = "";
					document.form1.jobMaxSalary.value = "";
				} else {
					document.form1.jobMinSalary.value = eval("document.form1.minSalary" + jobId.value + ".value");
					document.form1.jobMaxSalary.value = eval("document.form1.maxSalary" + jobId.value + ".value");
				}							
			}
		</script>
	</head>

	<body onload="showSalary();">
		<div id="main">
	
		<form name="form1" method="post" action="UpdateEmpServlet">
			<table width="550" border="0" align="center" cellpadding="4"
				cellspacing="0" class="table_border1">
				<tr>
					<th height="24" colspan="2" align="center" bgcolor="#FFCC00">
						请修改员工信息
					</th>
				</tr>
				<tr>
					<td width="140" height="24" align="center">
						员工姓名
					</td>
					<td width="410" height="24">
						<input type="text" name="empName" id="empName" value="${emp.empName}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						邮箱地址
					</td>
					<td height="24">
						<input type="text" name="empEmail" id="empEmail"  value="${emp.empEmail}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						电话号码
					</td>
					<td height="24">
						<input type="text" name="empPhone" id="empPhone"  value="${emp.empPhone}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						入职日期
					</td>
					<td height="24">
						<input type="text" name="empHiredate" id="empHiredate"  value="${emp.empHiredate}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						职务
					</td>
					<td height="24">
						<select name="jobId" id="jobId" onchange="showSalary();">
							<option value="">
								请选择职务
							</option>
							
							<c:forEach items="${jobList}" var="job">
								<option value="${job.jobId}"  ${emp.job.jobId==job.jobId?'selected':''} >${job.jobName}</option>
							</c:forEach>
						</select>
						工资范围
						<input name="jobMinSalary" type="text" id="jobMinSalary" size="6"
							readonly="readonly">
						~
						<input name="jobMaxSalary" type="text" id="jobMaxSalary" size="6"
							readonly="readonly">
							
							
						<!-- 最低和最高工资数据 -->
						<c:forEach items="${jobList}" var="job">
							<input type="hidden" name="minSalary${job.jobId}" value="${job.jobMinSalary}"/>
							<input type="hidden" name="maxSalary${job.jobId}" value="${job.jobMaxSalary}"/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						工资
					</td>
					<td height="24">
						<input type="text" name="empSalary" id="empSalary" value="${emp.empSalary}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						部门
					</td>
					<td height="24">
						<select name="deptId" id="deptId">
							<option value="">
								请选择部门
							</option>
							
							<c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptId}"  ${emp.dept.deptId==dept.deptId?'selected':''}>${dept.deptName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center">
						<input type="hidden" name="empId" value="${emp.empId}">
						<input type="submit" name="button" id="button" value="提交">
						<input type="button" name="button2" id="button2" value="取消"
							onClick="history.back();">
					</td>
				</tr>
			</table>
		</form>

		</div>
	</body>
</html>
