<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript">
	//下载文件
	function download(documentId) {
		location.href="downloadDocument.action?documentId=" + documentId;
	}

</script>
</head>
<body>
	    	<table width="100%" class="table">
	              <tr>
	                <th>文件名称</th>
	                <th>文件大小</th>
	                <th>操作</th>
	              </tr>
		             <c:forEach items="${list }" var="document">
		              <tr>
		                <td>${document.documentName }</td>
		                <td><fmt:formatNumber value="${document.documentSize/1024 }" pattern="0.00" type="number"/>M</td>
		                <td>
		                	<a href="javascript:download(${document.documentId });">下载</a> 		        
              		    </td>
		              </tr>
		              </c:forEach>
		              
	         </table>
	   
	  


</body>
</html>