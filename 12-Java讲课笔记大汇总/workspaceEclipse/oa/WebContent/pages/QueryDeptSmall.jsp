<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">

	var deptId;
	var deptName;
	
	//返回值到父窗口
	function returnPopValue() {		
				
		$(window.parent.document).find('#deptId').val(deptId);
		$(window.parent.document).find('#deptName').val(deptName);	
		$(window.parent.document).find('#popWinClose').click();
	}
	
	//关闭当前窗口
	function closeWin(){
		$(window.parent.document).find('#popWinClose').click();
	}
	
	$(document).ready(function(){
		$('input[name="ids"]').click(function(){
			deptId = $.trim( $(this).parent().parent().find('td').eq(1).text() );
			deptName = $.trim( $(this).parent().parent().find('td').eq(2).text() );			
		});		
	});
</script>
</head>
<body>


	    	<table class="table table-striped">
			  <tr>
			    <th width="100" height="24">选择</th>
			    <th width="129" height="24">部门编号</th>
			    <th width="177" height="24">部门名称</th>   
			  </tr>
			
			  <c:forEach items="${requestScope.list }" var="dept">
			  <tr>
			    <td height="24"><input type="radio" name="ids"></td>
			    <td height="24"><c:out value="${dept.deptId }"/></td>
			    <td height="24"><c:out value="${dept.deptName }"/></td>   
			  </tr>
			  </c:forEach>
			</table>
			
			<div class="text-center">			
				<input type="button" value="确定" class="btn btn-primary" onclick="returnPopValue();">
				<input type="button" value="取消" class="btn" onclick="closeWin();">
			</div>
			
			<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>		    
	

</body>
</html>