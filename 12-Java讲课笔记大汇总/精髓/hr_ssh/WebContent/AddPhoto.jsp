<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="css/style.css">

	</head>

	<body>
		<div id="content">
			<form name="form1" method="post" action="<%=request.getContextPath()%>/photo/add.action?empId=${param.empId }"
				enctype="multipart/form-data">
				<table width="500" border="0" cellspacing="0" cellpadding="0"
					class="table_border">
					<tr>
						<td height="24" align="center" bgcolor="#FFCC00">
							请选择要上传的员工照片（*.jpg 或者*.gif）
						</td>
					</tr>
					<tr>
						<td height="24" align="center">
							<input type="file" name="photo" id="photo">							
							<input type="submit" value="添加员工图片">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>