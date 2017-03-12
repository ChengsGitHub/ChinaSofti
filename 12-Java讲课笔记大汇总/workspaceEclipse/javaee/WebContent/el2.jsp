<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("username", "tom");
	request.setAttribute("key", "username");
%>

用户名：${requestScope[requestScope.key]}

<br>
${pageContext.request.contextPath}
<br>
<%=request.getContextPath()%>