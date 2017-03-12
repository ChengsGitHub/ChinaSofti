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
	function del(cardId) {
		var flag = window.confirm("确定要删除此员工吗");
		if (flag) {
			location.href = "delete.action?cardId=" + cardId;
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
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">名片夹</a><span class="divider">/</span></li>
		<li><a href="#">个人名片夹</a><span class="divider">/</span></li>
		<li class="active">检索好友</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<div class="span3">
					<ul class="left_nav_menu">
                          <li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                          <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
					</ul>
			</div>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;"> 
	        
            <table class="table table-striped">
              <tr>
                <th>员工编号</th>
                <th>员工姓名</th>                
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="personnelcard">
              <tr>
                <td>${personnelcard.cardId}</td>
                <td>${personnelcard.cardName }</td>               
                <td>               	
                	<div class="btn-group">	                		
                		<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></a>                	
				        <ul class="dropdown-menu">
				            <li><a href="../Personnelcard/toUpdate.action?cardId=${personnelcard.cardId }">查看详细</a></li>
				            <li><a href="javascript:del(${personnelcard.cardId });">删除</a></li>
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