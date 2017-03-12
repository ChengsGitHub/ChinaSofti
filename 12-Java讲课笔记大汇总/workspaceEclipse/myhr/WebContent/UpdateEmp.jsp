<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="js/jquery.datetimepicker.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2.js"></script>

<script type="text/javascript">
	/*显示工资范围*/
	function showSal() {
		var jobId = document.form1.jobId;
		
		if (jobId.value == '') {
			document.form1.minSalary.value = "";
			document.form1.maxSalary.value = "";
		} else {
			document.form1.minSalary.value = document.getElementById("minSalary" + jobId.value).value;
			document.form1.maxSalary.value = document.getElementById("maxSalary" + jobId.value).value;
		}
	}
	
	/*JQUERY插件*/
	$(document).ready(function(e) {
		    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		//日历框
		$('#empHiredate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});		
	
	});	
</script>
</head>
<body onload="showSal();">
<form name="form1" id="form1" method="post" action="UpdateEmpServlet">
  <table class="table1" width="500" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="24" colspan="2" align="center" bgcolor="#00CCFF">请修改员工信息</td>
    </tr>
    <tr>
      <td width="121" height="24" align="center">员工姓名</td>
      <td width="379" height="24"><input value="${emp.empName }" datatype="*1-10" errormsg="姓名必须是1-10个字符" type="text" name="empName" id="empName"></td>
    </tr>
    <tr>
      <td height="24" align="center">邮箱地址</td>
      <td height="24"><input value="${emp.empEmail }" datatype="e" errormsg="这不是一个合法的邮箱"  type="text" name="empEmail" id="empEmail"></td>
    </tr>
    <tr>
      <td height="24" align="center">电话号码</td>
      <td height="24"><input value="${emp.empPhone }" datatype="m" errormsg="这不是一个合法的手机号码" type="text" name="empPhone" id="empPhone"></td>
    </tr>
    <tr>
      <td height="24" align="center">入职日期</td>
      <td height="24"><input value="${emp.empHiredate }" datatype="*" errormsg="必须选择日期" type="text" name="empHiredate" id="empHiredate"></td>
    </tr>
    <tr>
      <td height="24" align="center">职务</td>
      <td height="24">
      <select datatype="*" name="jobId" id="jobId" onchange="showSal();">
        <option value="">请选择职务</option>
        <!-- 动态生成职务列表 -->
        <c:forEach items="${jobList}" var="job">
        	<option value="${job.jobId}" ${emp.job.jobId==job.jobId?'selected':'' }>${job.jobName}</option>
        </c:forEach>
      </select>
      
      <!--隐藏域，存储工资范围数据  -->
      <c:forEach items="${jobList}" var="job">
      	  <input type="hidden" id="minSalary${job.jobId}" value="${job.jobMinSalary }">
      	  <input type="hidden" id="maxSalary${job.jobId}" value="${job.jobMaxSalary }">
      </c:forEach>
      
                工资范围
      <input name="minSalary" type="text" id="minSalary" size="8" readonly="readonly">
      ~
      <input name="maxSalary" type="text" id="maxSalary" size="8" readonly="readonly"></td>
    </tr>
    <tr>
      <td height="24" align="center">工资</td>
      <td height="24"><input value="${emp.empSalary }" datatype="n1-6" errormsg="工资必须是1-6位数字" type="text" name="empSalary" id="empSalary"></td>
    </tr>
    <tr>
      <td height="24" align="center">部门</td>
      <td height="24">
      <select datatype="*" name="deptId" id="deptId">
        <option value="">请选择部门</option>
        <!-- 动态生成部门列表 -->
        <c:forEach items="${deptList}" var="dept">
        	<option value="${dept.deptId}"  ${emp.dept.deptId==dept.deptId?'selected':''}>${dept.deptName}</option>
        </c:forEach>        
      </select>
      </td>
    </tr>
    <tr>
      <td height="24" colspan="2" align="center">
      <input type="hidden" name="empId" value="${emp.empId }">
      <input type="submit" name="button" id="button" value="提交">
      <input type="button" name="button2" id="button2" value="取消" onClick="history.back();">
      </td>
    </tr>
  </table>
</form>
</body>
</html>