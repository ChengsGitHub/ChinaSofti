<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%=request.getContextPath() %>
 
 <%=session.getId()%>
 
<%=application.getRealPath("/123/456.html")%>

<%
	out.println("hello,world");
%>

<%=pageContext.getSession().getId()%>