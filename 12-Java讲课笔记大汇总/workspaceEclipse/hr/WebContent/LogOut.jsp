<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	session.removeAttribute("adminVo");
	response.sendRedirect("Login.jsp");
%>