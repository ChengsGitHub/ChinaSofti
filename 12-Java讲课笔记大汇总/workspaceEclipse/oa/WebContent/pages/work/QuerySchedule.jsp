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
			location.href = "delete.action?scheduleEmpid=${param.scheduleEmpid}&scheduleId=" +scheduleId;
		}
	}
	
	$(document).ready(function(e){
		
		/* //设置读者
		$.getJSON('../emp/getEmpJson.action',{empId: $('#empId').val() },function(data){
			//$('#empName').val(data.empName);
		});
		
		 //设置代办
		$.getJSON('../dept/getDeptJson.action',{deptId: $('#deptId').val() },function(data){
			$('#deptName').val(data.deptName);
		});		
		
		//选择读者模态窗口
		$('#empBtn').click(function(){			
			popWin.showWin("600","500","选择读者","../emp/querySmall.action");										
		}); */
		
		//日历框
		$('#scheduleBedate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		$('#scheduleEndate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		
		$('#form2').submit(function(){			
			if ($('#queryStr').val() == '') {
				alert("输入点东西好不");
				return false;
			}			
		});
		
		//显示隐藏搜索表单
		$('input[name=searchType]').click(function(){
			if(this.id == 'radioBtn1') {
				$('#form1').show();
				$('#form2').hide();
			} else {
				$('#form1').hide();
				$('#form2').show();
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
		<li><a href="<%=request.getContextPath() %>/pages/work/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${empId}">工作安排</a><span class="divider">/</span></li>
		<li class="active">自己已安排工作</li>    
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
	    	<div style="margin-bottom:10px;">
					<input type="radio" id="radioBtn1" name="searchType" checked>普通搜索
					<input type="radio" id="radioBtn2" name="searchType">全文搜索
				</div>
				<form name="form1" id="form1"  action="<%=request.getContextPath() %>
					/schedule/queryByCondition.action" method="get" style="display:blobk">
					<input type="text" name="scheduleSch" id="scheduleSch" style="width:400px;" placeholder="请输入工作安排关键字" value="${schedule.scheduleSch }">
					<input type="submit" value="检索工作" class="btn btn-primary">
					<input type="hidden" name="pageNum" id="pageNum" value="${pager.pageNum }"></form>
				<form name="form2" id="form2"  action="<%=request.getContextPath() %>
					/schedule/queryByIndex.action" method="post" style="display:none">
					<input type="text" name="queryStr" id="queryStr" style="width:400px;" placeholder="请输入工作安排关键字" value="${queryStr }">
					<input type="submit" value="全文检索" class="btn btn-primary"></form>
	    
        	<p align="right"><a href="<%=request.getContextPath() %>/pages/work/AddSchedule.jsp?scheduleEmpid=${param.scheduleEmpid}" class="btn btn-large btn-primary">增加新工作安排</a></p>
        	
            <table class="table table-striped">
              <tr>
                <th>工作安排编号</th>
                <th>工作安排</th>
                <th>工作开始时间</th>
                <th>工作结束时间</th>
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="schedule">
              <tr>
                <td>${schedule.scheduleId }</td>
                <td>${schedule.scheduleSch }</td>
                <td><fmt:formatDate value="${schedule.scheduleBedate }"/></td>
                <td><fmt:formatDate value="${schedule.scheduleEndate }"/></td>
                <td>
                	<a href="../schedule/toUpdate.action?scheduleId=${schedule.scheduleId }">查看详细</a>
                	<a href="javascript:del(${schedule.scheduleId });">删除</a>
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
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="?scheduleEmpid=${emp1Id}&pageNum=1">首页</a></li>
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="?scheduleEmpid=${emp1Id}&pageNum=${pager.pageNum-1 }">上页</a></li>
					<c:forEach begin="1" end="${pager.pageCount }" var="i">		  			
					  	<li ${pager.pageNum==i?'class="disabled"':''}><a href="?scheduleEmpid=${emp1Id}&pageNum=${i}">${i}</a></li> 		  			
					</c:forEach>		
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?scheduleEmpid=${emp1Id}&pageNum=${pager.pageNum+1 }">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?scheduleEmpid=${emp1Id}&pageNum=${pager.pageCount }">末页</a></li>		
				</ul>
			</div>	
			
			 <table>
               <%-- <tr>
                    <td>
                      <input type="hidden" name="empId" id="empId" value="${readsch.empId }">
                      <input type="button" name="button" id="empBtn" value="选择读者" class="btn btn-primary"></td>
                  </tr> --%>
                  <%-- <tr>
                  <td>
                  <p align="right"><a href="<%=request.getContextPath() %>/readsch/query.action" class="btn btn-primary">选择读者</a></p>
                  </td>
                  </tr>
                  <tr>
                  <td>
                  <p align="right"><a href="<%=request.getContextPath() %>/readsch/query2.action" class="btn btn-primary">查看被赋予查看权限的员工的工作安排</a></p>
                  </td>
                  </tr> --%>
                  <%-- <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName">
                    <input type="hidden" name="jobId" id="jobId" value="${emp.jobId }">
                    <input type="button" name="button2" id="jobBtn" value="选择职务" class="btn btn-primary"></td>
                  </tr> --%>
            </table>				
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>