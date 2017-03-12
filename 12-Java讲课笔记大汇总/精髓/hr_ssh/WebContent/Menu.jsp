<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>       
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<style type="text/css"> 
		.ul1 li {
			margin-top: 10px;
			font-size: 14px;
		}	
	</style>
  </head>
  
  <body>
   
   	<ul class="ul1">
    	<li><a href="index.jsp">主页</a></li>
        <li><a href="<%=request.getContextPath() %>/dept/query.action" target="right">部门管理</a></li>
        <li><a href="<%=request.getContextPath() %>/job/query.action" target="right">职务管理</a></li>
        <li><a href="<%=request.getContextPath() %>/emp/query.action" target="right">员工管理</a></li>
        <li><a href="logout.jsp" target="_top">退出登录</a></li>
    </ul>
   
  </body>
</html>