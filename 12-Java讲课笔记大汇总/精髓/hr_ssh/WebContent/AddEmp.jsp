<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>AddEmp.jsp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jquery.datepick.css">
		
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.datepick.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.datepick-zh-CN.js"></script>
		
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
	        
	        //验证表单
	        function checkForm() {
	        	
	        	var empName = document.form1.empName;
	        	
	        	if (empName.value == "" || empName.value.length>10) {
	        		alert("员工姓名不能为空且最多10字符");
	        		return false;
	        	}
	        	
	        	return true;
	        }
	    </script>
	</head>

	<body>
		<div id="content">
	
		<form name="form1" method="post" action="<%=request.getContextPath() %>/emp/add.action" onsubmit="return checkForm();">
			<table width="550" border="0" cellpadding="4" cellspacing="0" class="table_border">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC33">
						请填写员工信息
					</td>
				</tr>
				<tr>
					<td width="124" height="24" align="left">
						员工姓名
					</td>
					<td width="410" height="24">
						<input type="text" name="empName" id="empName">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						邮箱地址
					</td>
					<td height="24">
						<input type="text" name="empEmail" id="empEmail">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						电话号码
					</td>
					<td height="24">
						<input type="text" name="empPhone" id="empPhone">
						*&nbsp;例如123.456.789
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						入职日期
					</td>
					<td height="24">
						<input type="text" name="empHiredate" id="empHiredate">
						*&nbsp;yyyy-mm-dd
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						职务
					</td>
					<td height="24">
						<select name="jobId"  id="jobId" onchange="showSalary();">
							<option value="">
								请选择职务
							</option>
							<c:forEach items="${jobList}" var="job">
								<option value="${job.jobId }">
									${job.jobName }
								</option>
							</c:forEach>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工资范围
						<input name="jobMinSalary" type="text" id="jobMinSalary" size="8"
							maxlength="8" value="" readonly>
						~
						<input name="jobMaxSalary" type="text" id="jobMaxSalary" size="8"
							maxlength="8" value="" readonly>
							
							
						<!-- 存储职务的最低和最高工资 -->
						<c:forEach items="${jobList}" var="job">
							<input type="hidden" id="min${job.jobId }" name="min${job.jobId }" value="${job.jobMinSalary}">
							<input type="hidden" id="max${job.jobId }" name="max${job.jobId }" value="${job.jobMaxSalary}">
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						工资
					</td>
					<td height="24">
						<input type="text" name="empSalary" id="empSalary">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="left">
						部门
					</td>
					<td height="24">
						<select name="deptId" size="1" id="deptId">
							<option value="">
								请选择部门
							</option>
							<c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptId }">
									${dept.deptName }
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center">
						<input type="submit" name="button" id="button" value="提交">
						&nbsp;
						<input type="button" name="button2" id="button2" value="取消" onclick="history.back();">
					</td>
				</tr>
			</table>
		</form>

		</div>
	</body>
</html>
