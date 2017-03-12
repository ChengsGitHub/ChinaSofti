<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>login.html</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="css/style.css">

	</head>

	<body>
		<div id="content" style="margin: 10px auto">
	
		<form name="form1" method="post" action="<%=request.getContextPath() %>/admin/login.action" target="_top">
			<table width="300" border="0" align="center" cellpadding="4"
				cellspacing="0" class="table_border">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
						管理员登陆
					</td>
				</tr>
				<tr>
					<td width="90" height="24" align="center">
						账号
					</td>
					<td width="210" height="24">
						<input type="text" name="adminName" id="adminName">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						密码
					</td>
					<td height="24">
						<input type="password" name="adminPwd" id="adminPwd">
					</td>
				</tr>
				<tr>
					<td height="24" align="center">
						管理级别
					</td>
					<td height="24">
						<input name="adminLevel" type="radio" id="radio" value="1"
							checked="CHECKED">
						管理员
						<input type="radio" name="adminLevel" id="radio2" value="2">
						操作员
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center">
						<input type="submit" name="button" id="button" value="进入系统">
					</td>
				</tr>
			</table>
		</form>

		</div>
	</body>
</html>