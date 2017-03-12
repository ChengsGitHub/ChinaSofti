<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	session.invalidate();//销毁session
	response.sendRedirect("login.jsp");//重定向到登陆页
%>