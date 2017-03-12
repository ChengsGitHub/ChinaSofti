<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	Date d = new Date();
	request.setAttribute("d", d);
%>

现在的时间是：<fmt:formatDate value="${d}"/>
<br>
现在的时间是：<fmt:formatDate value="${d}" pattern="yyyy-MM-dd HH:mm:ss"/>