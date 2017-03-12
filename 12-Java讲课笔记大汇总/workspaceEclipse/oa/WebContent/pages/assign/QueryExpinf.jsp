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
	function del(expinfId) {
		var flag = window.confirm("确定要删除此员工吗");
		if (flag) {
			location.href = "delete.action?expinfId=" +expinfId;
		}
	}
	
	$(document).ready(function(){
		
		$('#form2').submit(function(){			
			if ($('#queryStr').val() == '') {
				alert("输入点东西好不");
				return false;
			}			
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
		<li><a href="#">外派人才管理</a><span class="divider">/</span></li>
		<li class="active">外派人才信息管理</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		<li><a href="<%=request.getContextPath() %>/expinf/query.action">外派人才信息</a></li>
		      <li><a href="<%=request.getContextPath() %>/assigncom/query.action">外派公司信息</a></li>
		</ul>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
				<form name="form2" id="form2"  action="<%=request.getContextPath() %>
					/expinf/queryByIndex.action" method="post" >
					<input type="text" name="queryStr" id="queryStr" style="width:400px;" placeholder="请输入外派人才姓名，技能，和经历" value="${queryStr }">
					<input type="submit" value="全文检索" class="btn btn-primary"></form>
	    
        	<p align="right"><a href="<%=request.getContextPath() %>/pages/assign/AddExpinf.jsp" class="btn btn-large btn-primary">增加新员工</a></p>
        	
            <table class="table table-striped">
              <tr>
                <th>外派人才编号</th>
                <th>外派人才姓名</th>
                <th>外派人才学历</th>
                <th>外派人才技能</th>
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="expinf">
              <tr>
                <td>${expinf.expinfId }</td>
                <td>${expinf.expinfName }</td>
                <td>${expinf.expinfEdu }</td>
                <td>${expinf.expinfSki }</td>
                <td>
                	<a href="../expinf/toUpdate.action?expinfId=${expinf.expinfId }">查看详细</a>
                	<a href="../exphistory/toUpdate.action?exphistoryId1=${expinf.expinfId }">查看派遣记录</a> 
                	<a href="javascript:del(${expinf.expinfId });">删除</a>
                </td>
              </tr>
              </c:forEach>
            </table>
        
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>					
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>