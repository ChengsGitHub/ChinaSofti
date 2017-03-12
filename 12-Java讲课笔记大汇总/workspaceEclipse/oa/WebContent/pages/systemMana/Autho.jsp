<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/popwin.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		//选择角色模态窗口
		$('#roleBtn').click(function(){			
			popWin.showWin("600","500","选择角色","<%=request.getContextPath() %>/role/queryRoleSmall.action");	
			
		});
	});
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
		<li class="active">设置权限</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>员工信息</h3>
              <form name="form1" method="post" action="<%=request.getContextPath() %>/emp/insertUserRole.action" >
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工编号</td>
                    <td width="76%"><input type="text" name="empId" id="empId" readonly value="${emp.empId }"></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="empName" id="empName" readonly value="${emp.empName }"></td>
                  </tr>
                   </table>
             <table class="table table-bordered">
              <tr>          
                <th>员工角色</th>
                <th>操作</th>
              </tr>
              <c:forEach items="${list }" var="map">
              <tr>
                <td>${map.ROLE_NAME}</td>
                 <td>
                	<a href="<%=request.getContextPath() %>/emp/deleteRole.action?ur=${map.UR}&empId=${emp.empId }">删除</a>
                </td>
              </tr>
             
              </c:forEach>
            </table>
			<table>
			 <tr>
			        <td>角色</td>
			        <td>
			        	<input type="text" name="roleName" id="roleName">
			       		<input type="hidden" name="roleId" id="roleId">
				        <input type="button" name="button3" id="roleBtn" value="选择角色" class="btn btn-primary" >
				        <input type="submit" value="增加角色" class="btn btn-primary" >
			        </td>			         
			  </tr>
			</table>
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>