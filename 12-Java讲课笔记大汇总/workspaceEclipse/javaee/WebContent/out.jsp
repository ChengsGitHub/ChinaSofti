<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="hello,world"/>

<c:out value="${param.username}" default="暂无"></c:out>

<c:out value="水平线是<hr>标签"></c:out>