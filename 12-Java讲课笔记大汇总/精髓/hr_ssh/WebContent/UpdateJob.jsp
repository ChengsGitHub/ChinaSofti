<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.job.po.Job" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="../css/style.css">

		<script type="text/javascript">
		
			/*表单验证*/
			function checkForm() {
				
				var r;
				
				var jobId = document.form1.jobId;
				r = /^[A-Z]{2,4}$/;
				if (!r.test(jobId.value)) {
					alert("部门编号必须是2到4位大写字母");
					return false;
				}
				
				return true;
			}
		
		</script>
	</head>
	<body>
		<div id="content">
	
		<form name="form1" method="post" action="<%=request.getContextPath() %>/job/update.action" onsubmit="return checkForm();">
			<table width="500" border="0" cellpadding="4"
				cellspacing="0" class="table_border">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
						请修改职务类型信息
					</td>
				</tr>
				<tr>
					<td width="132" height="24" align="center">
						职务编号
					</td>
					<td width="368" height="24">
						<input type="text" name="jobId" id="jobId" readonly value="${job.jobId}">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						职务名称
					</td>
					<td height="24">
						<input type="text" name="jobName" id="jobName"  value="${job.jobName}">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						最低工资
					</td>
					<td height="24">
						<input type="text" name="jobMinSalary" id="jobMinSalary"  value="${job.jobMinSalary}">
						*
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						最高工资
					</td>
					<td height="24">
						<input type="text" name="jobMaxSalary" id="jobMaxSalary"  value="${job.jobMaxSalary}">
						*
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center">
						<input type="submit" name="button" id="button" value="提交">
						<input type="button" name="button2" id="button2" value="取消" onclick="history.back();">
					</td>
				</tr>
			</table>
		</form>

		</div>
	</body>
</html>