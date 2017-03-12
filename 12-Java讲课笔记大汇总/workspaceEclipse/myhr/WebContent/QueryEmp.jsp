<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript">
	/*删除确认*/
	function del(empId) {
		var flag = window.confirm("你确定要删除此员工吗");
		if (flag) {
			location.href='<%=request.getContextPath()%>/DeleteEmpServlet?empId=' + empId;
		}
	}
</script>
</head>
<body>
<table class="table1" width="900" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <th width="66" height="24" align="center" bgcolor="#00CCFF">员工编号</th>
    <th width="82" height="24" align="center" bgcolor="#00CCFF">员工姓名</th>
    <th width="122" height="24" align="center" bgcolor="#00CCFF">邮箱</th>
    <th width="120" height="24" align="center" bgcolor="#00CCFF">电话</th>
    <th width="111" height="24" align="center" bgcolor="#00CCFF">入职时间</th>
    <th width="82" height="24" align="center" bgcolor="#00CCFF">职务</th>
    <th width="71" height="24" align="center" bgcolor="#00CCFF">工资</th>
    <th width="79" height="24" align="center" bgcolor="#00CCFF">部门</th>
    <th width="167" height="24" align="center" bgcolor="#00CCFF">操作</th>
  </tr>
  <c:forEach items="${list}" var="emp">
  <tr>
    <td height="24">${emp.empId }</td>
    <td height="24">${emp.empName }</td>
    <td height="24">${emp.empEmail }</td>
    <td height="24">${emp.empPhone }</td>
    <td height="24">${emp.empHiredate }</td>
    <td height="24">${emp.job.jobName } </td>
    <td height="24">${emp.empSalary }</td>
    <td height="24">${emp.dept.deptName }</td>
    <td height="24" align="center">
    	<a href="ToUpdateEmpServlet?empId=${emp.empId }">修改</a>
    	<a href="javascript:del(${emp.empId});">删除 </a>
    	<a href="#">照片</a>
    </td>
  </tr>
  </c:forEach>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="24" align="center">
    	共${pager.recordCount }条数据，
    	每页${pager.pageSize}条，
    	共${pager.totalPage }页，
    	当前是第${pager.pageNum }页
    </td>
  </tr>
</table>

<!-- 分页工具栏 -->
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="24" align="center">    
    	<c:if test="${pager.pageNum != 1}">
	    	<a href="?pageNum=1">首页</a>
	    	<a href="?pageNum=${pager.pageNum-1}">上页</a>
    	</c:if>
    	    	
    	<c:forEach begin="${pager.pageNum<=2?1:pager.pageNum-2}" end="${pager.pageNum>=pager.totalPage-1?pager.totalPage:(pager.pageNum<=2?5:pager.pageNum+2) }" var="i">
    		<c:if test="${pager.pageNum != i}">
    			<a href="?pageNum=${i}">${i}</a>
    		</c:if>
    		<c:if test="${pager.pageNum == i}">
    			<span style="color:red;font-weight:bold;">${i}</span>
    		</c:if>
    	</c:forEach>    	    	    	
    	
    	<c:if test="${pager.pageNum != pager.totalPage}">
	    	<a href="?pageNum=${pager.pageNum+1}">下页</a>
	    	<a href="?pageNum=${pager.totalPage }">末页</a>
    	</c:if>
    	
    	<select onchange="location.href='?pageNum='+this.value;">
    		<c:forEach begin="1" end="${pager.totalPage}" var="i">
    			<option value="${i}" ${pager.pageNum==i?'selected':''}>第${i}页</option>
    		</c:forEach>
    	</select>
    </td>
  </tr>
</table>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="24" align="center"><a href="ToAddEmpServlet">增加新员工</a></td>
  </tr>
</table>

</body>
</html>