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
<link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">

	var empId;
	var empName;
	
	//返回值到父窗口
	function returnPopValue() {	
		
		var empList = $(':checkbox:checked');		
		var selectList = $(window.parent.document).find('#selectList');		
		var ids = $(window.parent.document).find('input[name=ids]');
				
		$.each(empList,function(index,obj){
			
			var str = obj.value.split(',');
			
			//判断是否以及选择过			
			var flag = true;
			
			$.each(ids,function(i,v){
				if (v.value == str[0])
					flag = false;
			});
			
			if (flag) {
				selectList.append('<span>' + str[1] + '</span>;');
				selectList.append('<input type=hidden name=ids value=' + str[0] + '>');
			}
			
		});
		
		$(window.parent.document).find('#popWinClose').click();
	}
	
	//关闭当前窗口
	function closeWin(){
		$(window.parent.document).find('#popWinClose').click();
	}
	
	$(document).ready(function(){
		$('input[name="ids"]').click(function(){
			empId = $.trim( $(this).parent().parent().find('td').eq(1).text() );
			empName = $.trim( $(this).parent().parent().find('td').eq(2).text() );
		});		
	});
</script>
</head>
<body>


	
	    	<table class="table table-striped" width="100%">
			  <tr>
			    <th width="100" height="24">选择</th>
			    <th width="129" height="24">读者编号</th>
			    <th width="177" height="24">读者名字</th>   
			  </tr>
			
			  <c:forEach items="${requestScope.list }" var="emp">
			  <tr>
			    <td height="24"><input type="checkbox" name="ids" id="inlineCheckbox1" value="${emp.empId },${emp.empName }"></td>
			    <td height="24"><c:out value="${emp.empId }"/></td>
			    <td height="24"><c:out value="${emp.empName }"/></td>  
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