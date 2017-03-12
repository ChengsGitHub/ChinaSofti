<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.hr.dept.po.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	//删除确认
	function del(deptId) {
		var flag = window.confirm("确定要删除此部门吗？");
		if (flag) {
			location.href='DeleteDeptServlet?deptId=' + deptId;
		}
	}
</script>

</head>
<body>
<table class="table1" width="800" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <th width="25%" height="24" bgcolor="#00CCFF">部门编号</th>
    <th width="25%" height="24" bgcolor="#00CCFF">部门名称</th>
    <th width="25%" height="24" bgcolor="#00CCFF">部门地址</th>
    <th width="25%" height="24" bgcolor="#00CCFF">操作</th>
  </tr>
  
  <c:forEach items="${list}" var="dept">
  <tr>
    <td width="25%" height="24"><c:out value="${dept.deptId }"/></td>
    <td width="25%" height="24"><c:out value="${dept.deptName }"/></td>
    <td width="25%" height="24"><c:out value="${dept.deptLoc }"/></td>
    <td width="25%" height="24" align="center">
    	<a href="ToUpdateDeptServlet?deptId=${dept.deptId }">修改</a>
    	<a href="javascript:del(${dept.deptId });">删除</a>
    </td>
  </tr>
  </c:forEach>  
</table>

<c:if test="${admin.adminLevel==1 }">
	<p align="center"><a href="AddDept.html">增加新部门</a></p>
</c:if>

</body>
</html>