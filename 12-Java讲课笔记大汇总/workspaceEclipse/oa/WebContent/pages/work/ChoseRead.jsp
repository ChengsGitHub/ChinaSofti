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
<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/popwin.js"></script>
<script type="text/javascript">
	//删除确认
	function del(readschId) {
		var flag = window.confirm("确定要删除这条读者吗");
		if (flag) {
			location.href = "delete.action?readschId=" + readschId;
		}
	}
	
$(document).ready(function(e){
		
		 //设置读者
		$.getJSON('<%=request.getContextPath()%>/emp/getEmpJson.action',{empId: $('#empId').val() },function(data){
			//$('#empName').val(data.empName);
		});
		
	
		//选择读者模态窗口
		$('#empBtn').click(function(){			
			popWin.showWin("600","500","选择读者","<%=request.getContextPath()%>/emp/querySmall.action");										
		}); 
		
		//清空多选（仅作测试）
		$('#deptBtn3').click(function(){			
			$('#selectList').empty();				
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
		<li><a href="<%=request.getContextPath() %>/pages/work/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${empId}">工作安排</a><span class="divider">/</span></li>
		<li class="active">读者设置</li>    
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
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="readsch">
              <tr>
                <td>${readsch.READSCH_ID }</td>
                <td>${readsch.DEPT_NAME }</td>
                <td>${readsch.EMP_ID }</td>
                <td>${readsch.EMP_NAME }</td>
                <td>               	             	
				      <a href="javascript:del(${readsch.READSCH_ID });">删除</a>
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
		<li ${pager.pageNum==1?'class="disabled"':''}><a href="?readschEmpid=${emp1Id}&pageNum=1">首页</a></li>
		<li ${pager.pageNum==1?'class="disabled"':''}><a href="?readschEmpid=${emp1Id}&pageNum=${pager.pageNum-1 }">上页</a></li>
		<c:forEach begin="1" end="${pager.pageCount }" var="i">		  			
		<li ${pager.pageNum==i?'class="disabled"':''}><a href="?readschEmpid=${emp1Id}&pageNum=${i}">${i}</a></li> 		  			
					</c:forEach>		
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?readschEmpid=${emp1Id}&pageNum=${pager.pageNum+1 }">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?readschEmpid=${emp1Id}&pageNum=${pager.pageCount }">末页</a></li>		
				</ul>
			</div>				
			
			<table>
			<tr>
                    <td>
	                    <form action="<%=request.getContextPath() %>/readsch/insert.action" method="post" id="form1">
	                      <div id="selectList">
                      	
                      	  </div> 
	                      <input type="hidden" name="readschEmpid" id="readschEmpid" value="${sessionScope.empId }">
	                      <input type="button" name="button" id="empBtn" value="选择读者" class="btn btn-primary">
	                      <input type="button" name="button" id="deptBtn3" value="清空" class="btn btn-primary">
	                      <input type="submit" value="增加已选择的读者" class="btn">
	                    </form>                             
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