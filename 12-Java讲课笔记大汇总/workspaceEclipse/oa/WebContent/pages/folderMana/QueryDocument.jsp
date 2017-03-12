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
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript">
	//删除确认
	function del(documentId) {

			var flag = window.confirm("确定要删除此文件吗");
			if (flag) {
				var folderId=${param.folderId};
				location.href = "delete.action?folderId="+folderId+"&documentId=" + documentId;
			}
	}
	
	//判断修改内容是否为空
	/*$('#button').click(function(){
		
		var i = ${param.folderId }.length;
		if (i <= 0){
			alert("请选择文件！");
			return false;
		}
	});
	*/
	//下载文件
	function download(documentId) {
		location.href="downloadDocument.action?documentId=" + documentId;
	}
	
	//取消文件
	function cancel() {
		location.href="<%=request.getContextPath()%>/document/queryByFolderId.action?folderId="+${param.folderId };
	}

</script>
</head>
<body>
			<form id="form2" name="form2" method="post" action="<%=request.getContextPath() %>/document/uploadDocument.action"  enctype="multipart/form-data">
	          <table class="table">	           	           
	            <tr>
	              <td height="24" align="center">选择文件</td>
	              <td height="24"><input type="file" name="documentDataForm" id="documentDataForm">
                  <input type="hidden" name="folderId" id="folderId" value="${param.folderId }"></td>
	            </tr>
	            <tr>
	              <td height="24" colspan="2" align="center">
	              	<input type="submit" name="button" id="button" value="提交" class="btn btn-primary">
	                <input type="button" name="button2" id="button2" value="取消" onclick="cancel();" class="btn btn-success">
	              </td>
	            </tr>
	          </table>
	        </form>

	
	    	<table width="100%" class="table">
	              <tr>
	                <th>文件名称</th>
	                <th>文件大小</th>
	                <th>操作</th>
	              </tr>
		             <c:forEach items="${list }" var="document">
		              <tr>
		                <td>${document.documentName }</td>
		                <td><fmt:formatNumber value="${document.documentSize }"  type="number"/></td>
		                <td>
		                	
		                	<a href="javascript:download(${document.documentId });">下载</a> 
		                	<a href="javascript:del(${document.documentId });">删除</a>
              		    </td>
		              </tr>
		              </c:forEach>
		              
	         </table>
	   
	  


</body>
</html>