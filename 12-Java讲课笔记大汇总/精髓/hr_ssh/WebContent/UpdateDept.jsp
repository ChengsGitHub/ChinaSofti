<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.dept.po.Dept" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
        
        <script type="text/javascript">
			/*表单验证*/
			function checkForm() {
				
				var r;
				
				var deptId = document.form1.deptId;
				r = /^\d{1,6}$/;
				
				if (!r.test(deptId.value)) {
					alert("部门编号必须是1到6位数字");
					deptId.focus();
					return false;
				}
				
				var deptName = document.form1.deptName;
								
				if (deptName.value == "" || deptName.value.length>15) {
					alert("部门名称不能为空，且15字符之内");
					deptName.focus();
					return false;
				}
				
				var deptLoc = document.form1.deptLoc;
				
				if (deptLoc.value == "" || deptLoc.value.length>30) {
					alert("部门地址不能为空，且30字符之内");
					deptLoc.focus();
					return false;
				}
				
				return true;
			}
		
		</script>
	</head>

	<body>
		<div id="content">
	
		<form name="form1" method="post" action="update.action" onSubmit="return checkForm();">
			<table width="500" border="0" cellpadding="4"
				cellspacing="0" class="table_border">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
					<strong>修改部门 </strong></td>
				</tr>
				<tr>
					<td width="131" height="24" align="center">
						部门编号
					</td>
					<td width="369" height="24">
						<input type="text" name="deptId" id="deptId" readonly value="${dept.deptId}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						部门名称
					</td>
					<td height="24">
						<input type="text" name="deptName" id="deptName" value="${dept.deptName}">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						部门地址
					</td>
					<td height="24">
						<input type="text" name="deptLoc" id="deptLoc" value="${dept.deptLoc}">
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
