<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.hr.dept.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" target="text/css" href="css/style.css">
	
	<script type="text/javascript">
		/*删除确认*/
		function del(deptId) {
			var flag = window.confirm("确定要删除此部门吗");
			if (flag) {
				location.href = "<%=request.getContextPath()%>/DeleteDeptServlet?deptId=" + deptId;				
			}
		}
	
	</script>

  </head>
  
  <body>  
  <div id="main">
  <table width="600" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <th width="25%" height="24" align="center" bgcolor="#FFCC00">部门编号</th>
      <th width="25%" height="24" align="center" bgcolor="#FFCC00">部门名称</th>
      <th width="25%" height="24" align="center" bgcolor="#FFCC00">部门地址</th>
      <th width="25%" height="24" align="center" bgcolor="#FFCC00">操作</th>
    </tr>
    <c:forEach items="${list}" var="dept">
    <tr>
      <td height="24" bgcolor="#FFFFFF">${dept.deptId}</td>
      <td height="24" bgcolor="#FFFFFF"><c:out value="${dept.deptName}"/></td>
      <td height="24" bgcolor="#FFFFFF"><c:out value="${dept.deptLoc}"/></td>
      <td height="24" align="center" bgcolor="#FFFFFF">
      	<a href="<%=request.getContextPath() %>/ToUpdateDeptServlet?deptId=${dept.deptId}">修改</a>
      	<a href="javascript:del(${dept.deptId});">删除</a>
      </td>
    </tr>
    </c:forEach>
  </table>
  <p align="center"><a href="InsertDept.html">增加新部门</a></p>   
  
  </div>
  </body>
</html>