<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chapter11.Dept" %>

<%
	request.setAttribute("username", "tom");
	session.setAttribute("password", "123456");	
	request.setAttribute("number", 100);
	
	Dept dept = new Dept(10,"NEC","大连");
	request.setAttribute("dept", dept);
%>

用户名：<%=request.getAttribute("username")%>
<br>
用户名：${requestScope.username}
<br>
用户名：${username}

<hr>

密码：<%=session.getAttribute("password")%>
<br>
密码：${sessionScope.password}

<hr>

数字：<%=(Integer)request.getAttribute("number") + 50%>
<br>
数字：${requestScope.number+50}

<hr>
部门名称：<%=((Dept)request.getAttribute("dept")).getDeptName()%>
<br>
部门名称：${dept.deptName}

<hr>

id：<%=request.getParameter("id")%>
<br>
id：${param.id}

<hr>
name：${paramValues.name[0]}
