<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("tom");
	list.add("jack");
	list.add("rose");
	list.add("张三");
	list.add("李四");
	list.add("王五");
	list.add("赵柳");
	
	request.setAttribute("list", list);
%>

<c:forEach items="${list}" var="s" varStatus="sta">
	${s} | ${sta.index} | ${sta.count } | ${sta.first } | ${sta.last } <br>
</c:forEach>