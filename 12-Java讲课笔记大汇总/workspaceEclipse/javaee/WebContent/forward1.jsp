<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
forward1.jsp
<jsp:forward page="/forward2.jsp">
	<jsp:param value="tom" name="username"/>
</jsp:forward>