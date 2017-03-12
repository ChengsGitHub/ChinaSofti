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
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript">

	//删除确认
	function del(brecordId) {
		var flag = window.confirm("确定要删除这条记录吗？");
		if (flag) {
			location.href = "delete.action?brecordId=" + brecordId;
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
		<li><a href="#">车辆管理</a><span class="divider">/</span></li>
		<li><a href="#">用车记录</a><span class="divider">/</span></li>
		<li class="active">用车记录列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/BusMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    
        <form name="formrcd" method="post" action="<%=request.getContextPath() %>/busrecord/query.action">
            <table width="90%" border="0" class="table table-striped">
              <tr>
                <th width="">记录编号</th>
                <th width="">使用人</th>
                <th width="">驾驶员</th>
                <th width="">用途</th>
                <th width="">路线</th>
                <th width="">用车时间</th>
                <th width="">操作</th>
              </tr>
             <c:forEach items="${list }" var="busrecord">
              <tr>
                <td>${busrecord.brecordId }</td>
                <td>${busrecord.userName }</td>
                <td>${busrecord.driver }</td>
                <td>${busrecord.useReason }</td>
                <td>${busrecord.path }</td>
                <td><fmt:formatDate value="${busrecord.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                	
                	<div class="btn-group">
									<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">
										操作
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li>
											<a  href="<%=request.getContextPath()%>/busrecord/toUpdate.action?brecordId=${busrecord.brecordId }">修改</a>
										</li>
										
										<li>
											<a href="javascript:del(${busrecord.brecordId });">删除</a>
										</li>
									</ul>
								</div>
                </td>
              </tr>
              </c:forEach>
            </table>
        </form>
        
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>					
			<p align="center"><a href="<%=request.getContextPath() %>/pages/bus/AddBusRecord.jsp" class="btn btn-large btn-primary">添加用车记录</a></p>
      </div>
	</div>
	<hr>
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>