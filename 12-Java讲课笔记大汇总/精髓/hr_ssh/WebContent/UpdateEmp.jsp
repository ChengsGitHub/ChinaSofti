<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.icss.hr.job.po.*"%>
<%@page import="com.icss.hr.dept.po.*"%>
<%@page import="com.icss.hr.emp.po.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>addEmp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
		<link rel="stylesheet" type="text/css" href="css/jquery.datepick.css">
		
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.datepick.js"></script>
		<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>

		<script type="text/javascript">

 			$(function(){
	            $("#empHiredate").datepick({dateFormat: 'yy-mm-dd'});	            
	        });
	        
	        //动态显示工资
	        function showSalary() {
	        	        	        	
	        	var jobId = document.form1.jobId;
	        	
	        	if (jobId.value == "") {
	        		document.form1.jobMinSalary.value = "";	    
	        		document.form1.jobMaxSalary.value = "";
	        	} else {
	        		document.form1.jobMinSalary.value = document.getElementById("min"+jobId.value).value;
	        		document.form1.jobMaxSalary.value = document.getElementById("max"+jobId.value).value;
	        	}	        		        	
	        }
	        
			function checkSubmit(){
				
				var empId = document.getElementById("empId");
				var empName = document.getElementById("empName");
				var empEmail = document.getElementById("empEmail");
				var empPhone = document.getElementById("empPhone");
				var empHir = document.getElementById("empHiredate");
				var empSal = document.getElementById("empSalary");
				var jobMinSaray = document.getElementById("jobMinSaray")
				var jobMaxSaray = document.getElementById("jobMaxSaray")
				var deptName = document.form1.deptName;
				var jobName = document.form1.jobName;
				
				var id = /^\d{1,6}$/;
				
				var email = /^(([a-zA-Z0-9]+)(@[a-zA-Z0-9]+)\.)(com|cn)$/;
				
				var phone = /^\d{3}\.\d{3}\.\d{3}$/;
				
				var date = /^\d{4}-\d{2}-\d{2}$/;
				var sal = /^0|([1-9]\d{1,5})$/;
				
				if(id.test(empId.value) == false){
					alert("请填写6位数字的员工编号");
					empId.focus();
					return false;
				}
				
				if(empName.value == ""){
					alert("请填写员工姓名");
					empName.focus();
					return false;
				}
				if(email.test(empEmail.value) == false){
					alert("邮箱格式填写不正确");
					empEmail.focus();
					return false;
				}
				if(phone.test(empPhone.value) == false){
					alert("电话号码格式填写不正确");
					empPhone.focus();
					return false;
				}
				if(date.test(empHir.value) == false){
					alert("日期格式填写不正确");
					empHir.focus();
					return false;
				}
				
				if(jobMaxSaray.value == ""){
					alert("请选择职务");
					jobName.focus();
					return false;
				}
			
				if(sal.test(empSal.value) == false
					|| parseInt(empSal.value) < parseInt(jobMinSaray.value)
					|| parseInt(empSal.value) > parseInt(jobMaxSaray.value) ){
					alert("工资填写不正确");
					empSal.focus();
					return false;
				}
				if(deptName.value == "请选择部门"){
					alert("请选择部门");
					deptName.focus();
					return false;
				}
				return true;
			}
			
		</script>

	</head>

	<body onload="showSalary();">
		<div id="content">
			<form name="form1" method="post" action="<%=request.getContextPath() %>/emp/update.action"
				onSubmit="return checkSubmit()">
				<table width="500" border="0" align="center" class="table_border">
					<tr id="title">
						<td height="30" colspan="2" align="center" bgcolor="#FFCC33">
							请填写以下员工信息
						</td>
					</tr>					
					<tr>
						<td width="30%" height="30" align="center">
							员工姓名
						</td>
						<td width="70%" height="30">
							<input type="text" name="empName" id="empName"
								value="${emp.empName}">
							*
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							邮箱地址
						</td>
						<td width="70%" height="30">
							<input type="text" name="empEmail" id="empEmail"
								value="${emp.empEmail}">
							*
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							电话号码
						</td>
						<td width="70%" height="30">
							<input type="text" name="empPhone" id="empPhone"
								value="${emp.empPhone}">
							* 例如123.456.789
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							入职日期
						</td>
						<td width="70%" height="30">
							<input type="text" name="empHiredate" id="empHiredate"
								value="${emp.empHiredate}">
							 *yyyy-mm-dd
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务
						</td>
						<td width="70%" height="30">
							<select name="jobId" id="jobId" onchange="showSalary();">
								<option value="">
									请选择职务
								</option>							
								<c:forEach items="${jobList}" var="job">
									<option value="${job.jobId}" ${job.jobId == emp.job.jobId?'selected':''}>${job.jobName}</option>
								</c:forEach>
							</select>

							工资范围							
							<input type="text" name="jobMinSalary" id="jobMinSalary" size="8"
								readonly>
							~
							<input type="text" name="jobMaxSalary" id="jobMaxSalary" size="8"
								readonly>
								
							<!-- 存储职务的最低和最高工资 -->
							<c:forEach items="${jobList}" var="job">
								<input type="hidden" id="min${job.jobId }" name="min${job.jobId }" value="${job.jobMinSalary}">
								<input type="hidden" id="max${job.jobId }" name="max${job.jobId }" value="${job.jobMaxSalary}">
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资
						</td>
						<td width="70%" height="30">
							<input name="empSalary" type="text" id="empSalary"
								value="${emp.empSalary}">
							*
						</td>
					</tr>
					<tr>
						<td width="30%" height="30" align="center">
							部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门
						</td>
						<td width="70%" height="30">
							<select name="deptId" id="deptId">
								<option>
									请选择部门
								</option>								
								<c:forEach items="${deptList}" var="dept">
									<option value="${dept.deptId}" ${dept.deptId==emp.dept.deptId?'selected':''}>${dept.deptName}</option>
								</c:forEach>
								
							</select>
							<input type="hidden" name="empId" id="empId" value="${emp.empId}">
						</td>
					</tr>
					<tr>
						<td height="30" colspan="2" align="center">
							<input type="submit" name="button" id="button" value="提交">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="button2" id="button2" value="取消"
								onClick="history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
