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
			ul li a {
				font-size: 16px;
				font-weight: bold;
				color: #000;
				text-decoration: none;
			}
			
			ul li {
				margin-top: 20px;
			}
		</style>
		
		<script type="text/javascript">
			function checkLogOut() {
				var flag = window.confirm("确定要退出吗？")
				if (flag) {
					window.top.location.href='LogOut.jsp';
				}
			}		
		</script>
	</head>

	<body>
		<div>
			<ul>
				<li>
					<a href="index.jsp" target="right">首页</a>
				</li>
				<li>
					<a href="QueryDeptServlet" target="right">部门管理</a>
				</li>
				<li>
					<a href="QueryJobServlet" target="right">职务管理</a>
				</li>
				<li>
					<a href="QueryEmpServlet" target="right">员工管理</a>
				</li>
				<li>
					<a href="javascript:checkLogOut();" >退出登陆</a>
				</li>
			</ul>
		</div>
	</body>
</html>