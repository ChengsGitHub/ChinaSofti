<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.job.po.*" %>

<%
	//取出范围中的数据
	Job job = (Job) request.getAttribute("job");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function checkForm(){
		var r;
		
		var jobId=document.form1.jobId;
		r=/^[A-Z]{2,3}$/;
		if(!r.test(jobId.value)){
			alert('职务编号必须为大写字母');
			jobId.select();
			return false;
			
		}
		var jobName = document.form1.jobName;
		if(jobName.value == '' || jobName.value.length>10){
			alert('职务名称不能为空且最多10字符');
			jobName.select();
			return false;
		}
		
		var jobMinSalary = document.form1.jobMinSalary;
		var mn=/^[1-9][0-9]{0,5}$/
		if(!mn.test(jobMinSalary.value)){
			alert('最低工资为数字且第一位不为0');
			jobMinSalary.focus();
			return false;
		}
		
		
		var jobMaxSalary = document.form1.jobMaxSalary;
		var mx=/^[1-9][0-9]{0,5}$/
		if(!mx.test(jobMaxSalary.value)){
			alert('最高工资为数字且第一位不为0');
			jobMaxSalary.focus();
			return false;
		}
		
		if(parseInt(jobMinSalary.value)>parseInt(jobMaxSalary.value)){
			alert('最低工资不能高于最高工资');
			jobMinSalary.focus();
			return false;

		
		return true;
	}
</script>
</head>
<body>
	<form name="form1" method="post" action="UpdateJobServlet" onsubmit="return checkForm();">
		<table class="table1" width="500" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="24" colspan="2" align="center" bgcolor="#3399FF">请修改职务信息</td>
			</tr>
			<tr>
				<td width="132" height="24" align="center">职务编号</td>
				<td width="368" height="24"><input type="text" name="jobId"
					id="jobId" readonly value="<%=job.getJobId()%>"></td>
			</tr>
			<tr>
				<td height="24" align="center">职务名称</td>
				<td height="24"><input type="text" name="jobName"
					id="jobName" value="<%=job.getJobName()%>"></td>
			</tr>
			<tr>
				<td height="24" align="center">最小工资</td>
				<td height="24"><input type="text" name="jobMinSalary" id="jobMinSalary"  value="<%=job.getJobMinSalary()%>"></td>
			</tr>
			<tr>
				<td height="24" align="center">最大工资</td>
				<td height="24"><input type="text" name="jobMaxSalary" id="jobMaxSalary" value="<%=job.getJobMaxSalary()%>"></td>
			</tr>
			<tr>
				<td height="24" colspan="2" align="center"><input type="submit"
					name="button" id="button" value="提交"> <input type="button"
					name="button2" id="button2" value="取消" onClick="history.back();"></td>
			</tr>
		</table>
	</form>

</body>
</html>