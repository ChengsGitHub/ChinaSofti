<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>

	<body>
		
	
		<form name="form1" method="post" action="LoginServlet" target="_top">
			<table width="300" border="0" align="center" cellpadding="4"
				cellspacing="1" bgcolor="#CCCCCC">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
						管理登陆
					</td>
				</tr>
				<tr>
					<td width="80" height="24" align="center" bgcolor="#FFFFFF">
						账号
					</td>
					<td width="220" height="24" bgcolor="#FFFFFF">
						<input type="text" name="adminName" id="adminName" style="width:150px">
					</td>
				</tr>
				<tr>
					<td height="24" align="center" bgcolor="#FFFFFF">
						密码
					</td>
					<td height="24" bgcolor="#FFFFFF">
						<input type="password" name="adminPwd" id="adminPwd" style="width:150px">
					</td>
				</tr>
				<tr>
					<td height="24" align="center" bgcolor="#FFFFFF">
						级别
					</td>
					<td height="24" bgcolor="#FFFFFF">
						<input name="adminLevel" type="radio" id="radio" value="1"
							checked="CHECKED">
						管理员
						<input type="radio" name="adminLevel" id="radio2" value="2">
						操作员
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
						<input type="submit" name="button" id="button" value="进入系统">
					</td>
				</tr>
			</table>
		</form>

		
	</body>
</html>