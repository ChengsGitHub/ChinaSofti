<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${param.score>=90}">
		优秀
	</c:when>
	<c:when test="${param.score>=80}">
		良好
	</c:when>
	<c:when test="${param.score>=60}">
		及格
	</c:when>
	<c:otherwise>
		不及格
	</c:otherwise>
</c:choose>