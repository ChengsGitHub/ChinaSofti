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
			location.href = "delete.action?expinfId=" + expinfId;
		}
	}	
		
	/*分页显示*/
	var pageNum =${pager.pageNum};//第几页
	var recordCount = ${queryResult.recordCount};//总记录数
	var pageSize = ${pager.pageSize };//每页多少条
	var pageCount = parseInt((recordCount - 1) / pageSize) + 1;//共几页
	
	$(document).ready(function(){
		
		$('#form1').submit(function(){			
			if ($('#queryStr').val() == '') {
				alert("输入点东西好不");
				return false;
			}			
		});
		
		
		$('#prevBtn').click(function(){	
			if (pageNum <= 1 ) {
				alert("已经是第一页了");
				return false;
			}
			
			$('#pageNum').val(pageNum - 1);
			$('#form1').submit();				
		});
		
		$('#nextBtn').click(function(){
			
			if (pageNum >= pageCount) {
				alert("后面没有了");
				return false;
			}
			
			$('#pageNum').val(pageNum + 1);
			$('#form1').submit();
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
		<li class="active">全文检索员工</li>    
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
	        <form name="form1" id="form1"  action="<%=request.getContextPath() %>/expinf/queryByIndex.action" method="post">
	        	<input type="text" name="queryStr" id="queryStr" style="width:400px;" placeholder="请输入员工姓名，电话，自我介绍关键字" value="${queryStr }">	        	
	        	<input type="hidden" name="pageNum" id="pageNum" value="${pager.pageNum }">
	        	<input type="submit" value="全文检索" class="btn btn-primary">
	        </form>
	        	        
            <table class="table table-striped">
             
             <c:forEach items="${queryResult.recordList }" var="expinf">
              <tr>
                <td>
                	<h4>${expinf.expinfName }</h4>
                	<p>${expinf.expinfExp }</p>
                </td>                          
                <td>               	
                	<div class="btn-group">	                		
                		<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></a>                	
				        <ul class="dropdown-menu">
				            <li><a href="../expinf/toUpdate.action?expinfId=${expinf.expinfId }">查看详细</a></li>
				            <li><a href="javascript:del(${expinf.expinfId });">删除</a></li>
				           </ul>
			        </div>      	
                </td>
              </tr>
              </c:forEach>
              
            </table>
             					
			<!-- 分页栏 -->
			<table width="95%" border="0">
			  <tr>
			    <td align="center">    	
			    	<div class="pagination">
					      <ul>
					        <li><a href="#" id="prevBtn">上页</a></li>
					        <li><a>共检索出${queryResult.recordCount }记录，每页${pager.pageSize }条，当前是第${pager.pageNum }页</a></li>
					        <li><a href="#" id="nextBtn">下页</a></li>		        
					      </ul>
					 </div> 
			    </td>
			  </tr>
			</table>
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>