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
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript">
	//删除确认
	function del(deptId) {
		var flag = window.confirm("确定要删除此部门吗");
		if (flag) {
			location.href = "delete.action?deptId=" + deptId;
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
		<li><a href="#">部门管理</a><span class="divider">/</span></li>
		<li class="active">部门列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    		    
			<table class="table table-striped">
			  <tr class="info">
			    <th width="100" height="24">部门编号</th>
			    <th width="129" height="24">部门名称</th>
			    <th width="177" height="24">部门地址</th>
			    <th width="176" height="24">操作</th>
			  </tr>
			
			  <c:forEach items="${requestScope.list }" var="dept">
			  <tr>
			    <td height="24">${dept.deptId }</td>
			    <td height="24"><c:out value="${dept.deptName }"/></td>
			    <td height="24"><c:out value="${dept.deptLoc }"/></td>
			    <td height="24" align="center"><a href="<%=request.getContextPath() %>/dept/toUpdate.action?deptId=${dept.deptId }">修改</a> <a href="javascript:del(${dept.deptId });">删除</a></td>
			  </tr>
			  </c:forEach>
			</table>
			
			<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>		
			
			<p align="center"><a href="<%=request.getContextPath() %>/pages/systemMana/AddDept.jsp" class="btn btn-primary btn-large">增加新部门</a></p>
	    </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>