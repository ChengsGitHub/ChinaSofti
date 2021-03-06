<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>

<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/popwin.js"></script>
<script type="text/javascript">
	//删除确认
	function del(scheduleId) {
		var flag = window.confirm("确定要删除此工作安排吗");
		if (flag) {
			location.href = "delete.action?scheduleId=" +scheduleId;
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
		<li><a href="<%=request.getContextPath() %>/pages/work/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${empId}">工作安排</a><span class="divider">/</span></li>
		<li class="active">可替别人安排工作</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		<li><a href="<%=request.getContextPath() %>/readsch/query.action">读者设置</a></li>
		      <li><a href="<%=request.getContextPath() %>/readsch/query2.action">查看别人工作安排</a></li>
</ul>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
        	
            <table class="table table-striped">
              <tr>
                <th>编号</th>
                <th>所在部门</th>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>查看工作安排</th>
              </tr>
             <c:forEach items="${list }" var="readsch">
              <tr>
                <td>${readsch.READSCH_ID }</td>
                <td>${readsch.DEPT_NAME }</td>
                <td>${readsch.EMP_ID }</td>
                <td>${readsch.EMP_NAME }</td>
                <td>
                	<a href="../schedule/queryOther.action?scheduleEmpid=${readsch.EMP_ID }">查看详细</a>
                </td>
              </tr>
              </c:forEach>
            </table>
        
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>	
			
			<%--  <table>
               <tr>
                    <td>
                      <input type="hidden" name="empId" id="empId" value="${readsch.empId }">
                      <input type="button" name="button" id="empBtn" value="选择读者" class="btn btn-primary"></td>
                  </tr>
                  <tr>
                  <td>
                  <p align="right"><a href="<%=request.getContextPath() %>/readsch/query.action" class="btn btn-primary">选择读者</a></p>
                  </td>
                  </tr>
                  <tr>
                  <td>
                  <p align="right"><a href="<%=request.getContextPath() %>/readsch/queryById.action" class="btn btn-primary">查看被赋予查看权限的员工的工作安排</a></p>
                  </td>
                  </tr>
                  <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName">
                    <input type="hidden" name="jobId" id="jobId" value="${emp.jobId }">
                    <input type="button" name="button2" id="jobBtn" value="选择职务" class="btn btn-primary"></td>
                  </tr>
            </table> --%>				
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>