<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
	<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="/pages/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="/oa/pages/searchOtherEmp.jsp">查找员工</a><span class="divider">/</span></li>
		<li class="active">员工列表</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
	      <li><a href="<%=request.getContextPath()%>/emp1/read.action">维护个人信息</a></li>
	      <li><a href="/oa/pages/searchOtherEmp.jsp">查找员工</a></li>
	     	</ul>
	    </div>
	    	    	    
	    <div class="span8" style="min-height: 400px;">
	        	
            <table class="table table-striped">
              <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>所在部门</th>
                <th>职务名称</th>
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="emp1">
              <tr>
                <td>${emp1.EMP_ID }</td>
                <td>${emp1.EMP_NAME }</td>
                <td>${emp1.DEPT_NAME }</td>
                <td>${emp1.JOB_NAME }</td>
                <td>
                	<a href="../emp1/readEmp.action?emp1Id=${emp1.EMP_ID }">查看详细</a> 
                	<a href="<%=request.getContextPath()%>/pages/folderMana/QueryOthersSharingDir.jsp?emp1Id=${emp1.EMP_ID}">查看共享目录</a>
                </td>
              </tr>
              </c:forEach>
            </table>
        
        	
      </div>
	</div>
 <!--网页底部-->
  <jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
</div>

</body>
</html>