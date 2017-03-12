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
<script type="text/javascript">
	//删除确认
	function del(empId) {
		var flag = window.confirm("确定要删除此员工吗");
		if (flag) {
			location.href = "delete.action?empId=" + empId;
		}
	}
</script>
</head>
<body>

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
	<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">系统管理</a><span class="divider">/</span></li>
		<li><a href="#">员工管理</a><span class="divider">/</span></li>
		<li class="active">员工列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    
        	<p align="right"><a href="<%=request.getContextPath() %>/pages/systemMana/AddEmp.jsp" class="btn btn-large btn-primary">增加新员工</a>
        	<a href="<%=request.getContextPath() %>/pages/systemMana/searchOtherEmp.jsp" class="btn btn-large btn-primary">查询员工</a></p>
        	
            <table class="table table-striped">
              <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>所在部门</th>
                <th>职务名称</th>
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="emp">
              <tr>
                <td>${emp.EMP_ID }</td>
                <td>${emp.EMP_NAME }</td>
                <td>${emp.DEPT_NAME }</td>
                <td>${emp.JOB_NAME }</td>
                <td>
                	<a href="<%=request.getContextPath() %>/emp/toUpdate.action?empId=${emp.EMP_ID }">查看详细</a> 
                	<a href="javascript:del(${emp.EMP_ID });">删除</a>
                	<a href="<%=request.getContextPath() %>/emp/toSetAssign.action?empId=${emp.EMP_ID }">设置权限</a> 
                </td>
              </tr>
              </c:forEach>
            </table>		
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>