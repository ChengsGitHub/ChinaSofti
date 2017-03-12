<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获得请求的参数的值
	String callback = request.getParameter("callback");
	System.out.println(callback);	
%>

<%=callback%>({name:'tom',age:19});