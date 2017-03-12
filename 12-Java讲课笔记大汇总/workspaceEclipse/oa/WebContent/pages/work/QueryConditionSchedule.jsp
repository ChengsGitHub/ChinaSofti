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
	function del(scheduleId) {
		var flag = window.confirm("确定要删除此员工吗");
		if (flag) {
			location.href = "delete.action?scheduleId=" + scheduleId;
		}
	}	
	
	//分页函数
	function jumpPage(pageNum) {		
		$('#pageNum').val(pageNum);		
		$('#form1').submit();		
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
		<li><a href="<%=request.getContextPath() %>/pages/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${emp1Id}">工作安排</a><span class="divider">/</span></li>
		<li class="active">检索结果</li>    
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
	        
	        <form name="form1" id="form1" action="<%=request.getContextPath() %>/schedule/queryByCondition.action" method="get">
	        	<input type="text" name="scheduleSch" id="scheduleSch" placeholder="请输入关键字" value="${schedule.scheduleSch }">
	        	<input type="submit" value="检索工作" class="btn btn-primary">
	        	<input type="hidden" name="pageNum" id="pageNum" value="${pager.pageNum }">
	        </form> 
	        
            <table class="table table-striped">
              <tr>
                <th>编号</th>
                <th>工作安排</th>                
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="schedule">
              <tr>
                <td>${schedule.scheduleId}</td>
                <td>${schedule.scheduleSch }</td>               
                <td>               	
                	<div class="btn-group">	                		
                		<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></a>                	
				        <ul class="dropdown-menu">
				            <li><a href="../schedule/toUpdate.action?scheduleId=${schedule.scheduleId }">查看详细</a></li>
				            <li><a href="javascript:del(${schedule.scheduleId });">删除</a></li>
				        </ul>
			        </div>      	
                </td>
              </tr>
              </c:forEach>
            </table>
        
        	<!-- 分页条 -->
			<div class="pagination" style="text-align: center;">
				<ul>
					<li><a href="#">共${pager.recordCount }条数据，每页${pager.pageSize }条，共${pager.pageCount }页，当前是第${pager.pageNum }页</a></li>	
				</ul>
			</div>
			    
			<div class="pagination pagination-centered">
				<ul>
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="javascript:jumpPage(1);">首页</a></li>
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="javascript:jumpPage(${pager.pageNum-1 });">上页</a></li>
					<c:forEach begin="1" end="${pager.pageCount }" var="i">		  			
					  	<li ${pager.pageNum==i?'class="disabled"':''}><a href="javascript:jumpPage(${i});">${i}</a></li> 		  			
					</c:forEach>		
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="javascript:jumpPage(${pager.pageNum+1 });">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="javascript:jumpPage(${pager.pageCount });">末页</a></li>		
				</ul>
			</div>							
			
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>