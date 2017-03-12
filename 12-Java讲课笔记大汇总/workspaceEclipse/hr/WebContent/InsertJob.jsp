<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<link rel="stylesheet" target="text/css" href="css/style.css">
	</head>

	<body>

		<div id="main">

			<form name="form1" method="post" action="InsertJobServlet">
				<table width="500" border="0" align="center" cellpadding="4"
					cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
							增加新职务
						</td>
					</tr>
					<tr>
						<td width="120" height="24" align="center" bgcolor="#FFFFFF">
							职务编号
						</td>
						<td width="380" height="24" bgcolor="#FFFFFF">
							<input type="text" name="jobId" id="jobId">
							*
						</td>
					</tr>
					<tr>
						<td height="24" align="center" bgcolor="#FFFFFF">
							职务名称
						</td>
						<td height="24" bgcolor="#FFFFFF">
							<input type="text" name="jobName" id="jobName">
							*
						</td>
					</tr>
					<tr>
						<td height="24" align="center" bgcolor="#FFFFFF">
							最低工资
						</td>
						<td height="24" bgcolor="#FFFFFF">
							<input type="text" name="jobMinSalary" id="jobMinSalary">
							*
						</td>
					</tr>
					<tr>
						<td height="24" align="center" bgcolor="#FFFFFF">
							最高工资
						</td>
						<td height="24" bgcolor="#FFFFFF">
							<input type="text" name="jobMaxSalary" id="jobMaxSalary">
							*
						</td>
					</tr>
					<tr>
						<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
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