<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<link rel="stylesheet" target="text/css" href="css/style.css">
		
		<style type="text/css">
			.bg_img1 {
				background-image: url(img/bannal_1.jpg);
			}
		</style>
	</head>
	<body>
	<div class="bg_img1"><img src="img/bannal.jpg" width="950" height="80"></div>
    <div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="24" align="right" bgcolor="#0099FF">
          	用户名：${adminVo.adminName }，登陆级别：${adminVo.adminLevel==1?'管理员':'操作员' }
          </td>
        </tr>
      </table>
    </div>
	</body>
</html>