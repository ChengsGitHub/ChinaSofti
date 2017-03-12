<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选择收件人</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript">

	var empId;
	var empName;
	
	//返回值到父窗口
	function returnPopValue() {			
		
		var ids = $('input[name=ids]:checked');
		
		var empList = $(window.parent.document).find('input[name=empList]')
		
		var sendList = $(window.parent.document).find('#sendList');
		
		$.each(ids,function(index,obj){
			
			var valueStr = obj.value.split(',');
			
			var flag = true;
			
			$.each(empList,function(i,v){
				if (v.value == valueStr[0])
					flag = false;
			});
			
			if(flag){
				var divObj = $('<tr>').appendTo(sendList);
				
				divObj.append('<input type="hidden" name="empList" value="' + valueStr[0] + '">');
				divObj.append('<td><input readonly value="' + valueStr[1] + '">');
				divObj.append('<td> <a id="delBtn' + index + '" href="javascript:delSend(\'delBtn' + index + '\');">删除</a></td>');
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


	    	<table class="table table-striped">
			  <tr>
			    <th width="100" height="24">选择</th>
			    <th width="129" height="24">员工编号</th>
			    <th width="177" height="24">员工姓名</th>   
			  </tr>
			
			  <c:forEach items="${requestScope.list }" var="emp">
			  <tr>
			    <td height="24"><input type="checkbox" name="ids" value="${emp.emp1Id },${emp.emp1Name}"></td>
			    <td height="24"><c:out value="${emp.emp1Id }"/></td>
			    <td height="24"><c:out value="${emp.emp1Name }"/></td>   
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