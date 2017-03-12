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
			<form name="form1" method="post" action="InsertPhotoServlet?empId=${param.empId }"
				enctype="multipart/form-data">
				<table width="500" border="0" align="center" cellpadding="0"
					cellspacing="0" class="table_border1">
					<tr>
						<th height="24" align="center" bgcolor="#FFCC00">
							请选择要上传的员工的照片
						</th>
					</tr>
					<tr>
						<td height="24" align="center">
							<input type="file" name="photo" id="photo">
							<input type="submit" name="button" id="button" value="提交">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>