<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<script type="text/javascript">

$(document).ready(function(e) {
	
	//判断修改内容是否为空
	$('#updateBusBtn').click(function(){
				
		var i = $('input[name="ids"]:checked').length;
		if (i <= 0){
			alert("请选择要修改的车辆！");
			return false;
		}
	});
	//判断删除内容是否为空
	$('#btn').click(function(){
				
		var i = $('input[name="ids"]:checked').length;
		if (i <= 0){
			alert("请选择要删除的车辆！");
			return false;
		}
	});
	//一行代码搞定，提交表单的时候会自动触发验证程序
	$('#formadd').Validform({
		tiptype:3
	});
	$('#formupdate').Validform({
		tiptype:3
	});
	
	//选择单选设置表单数据
	$('input[name="ids"]').click(function(e) {
		
		var busId = $(this).parent().parent().find('td').eq(2).text();
		var busType = $(this).parent().parent().find('td').eq(3).text();
		var busLicense = $(this).parent().parent().find('td').eq(4).text();
		var busState = $(this).parent().parent().find('td').eq(5).text();
	   
	   $('#busId').val($.trim(busId));
	   $('#busType').val($.trim(busType));
	   $('#busLicense').val($.trim(busLicense));
	   $('#busState').val($.trim(busState));
	  
	   $('#busId2').val($.trim(busId));
	   $('#busType2').val($.trim(busType));
	   $('#busLicense2').val($.trim(busLicense));
	   $('#busState2').val($.trim(busState));
    });
	
});

function del() {
	var flag = window.confirm("确定要删除此车辆吗");
	if (flag) {
		location.href = "delete.action?busId=" + $('#busId2').val() ;
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
		<li class="active">车辆信息</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/BusMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	  	
	  				<form name="form3" id="form3" action="<%=request.getContextPath() %>/bus/queryByCondition.action" method="get">
			        	<input type="text" name="busType" id="busType" placeholder="请输入车辆类型" value="${bus.busType }">
			        	<input type="submit" value="按类型检索" class="btn btn-primary">	   
	        		</form> 
					
				
			  		<p>&nbsp;</p>
				  <form  name="form1" method="post" action="<%=request.getContextPath()%>/bus/query.action">
					<table width="90%" border="0" class="table table-striped">
					  <tr>
						<th width="">
							<th>全选</th>
						</th>
						<th width="">车辆编号</th>
						<th width="">车辆类型</th>
						<th width="">车辆牌照</th>
						<th width="">车辆状态</th>
					  </tr>
					  <c:forEach items="${list }" var="bus">
			              <tr>
			              	<td>
								<td><input type="radio" name="ids"></td>
							</td>
							<td>${bus.busId }</td>
			                <td>${bus.busType }</td>
			                <td>${bus.busLicense }</td>
			                <td>
			                	<c:if test="${bus.busState ==0}">可用</c:if>
                				<c:if test="${bus.busState ==1}">使用中</c:if>
                			</td>
			              </tr>
		              </c:forEach>
					</table>
					
				  </form>
				  
				  
			
		<!--  <input type="submit" value="增加" class="btn btn-primary btn-small" >-->
				  	<div align="right">
				  <a href="#addbus" class="btn btn-primary" id="addBusBtn" data-toggle="modal">增加</a>
			  
					  <!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  <div class="modal hide fade" id="addbus" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">添加新车辆</h2>
						 </div>
						 <div class="modal-body">
							  <form class="form-horizontal" name="formadd" id="formadd" method="post" action="<%=request.getContextPath()%>/bus/insert.action">
								<div class="control-group">
									<label class="control-label" for="busType">车辆类型</label>
									<div class="controls" align="center">
										<td><input type="text" id="busType" name="busType" value="${bus.busType }" datatype="s2-16" errormsg="类型为2-16位字符！"></td>
										<td>&nbsp;</td>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="busLicense">车辆牌照</label>
									<div class="controls" align="center">
										<input type="text" id="busLicense" name="busLicense" value="${bus.busLicense }" datatype="s6-7" errormsg="牌照为6-7位字符！">
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="busState">车辆状态</label>
									<div class="controls" align="center">
										<select  name="busState" id="busState" >
					                    		<option  value=0>可用</option>
					                    		<option value=1>使用中</option>
			                    		</select >
									</div>
								</div>
								<div class="control-group">
									<div class="controls">                          
										<button type="submit" class="btn btn-primary">提交</button>
										<a href="">
										<button type="button" class="btn">返回</button>
									</a>									</div>
								</div>
							</form>
						</div>
					  </div>
					
						   <!-- <input type="submit" value="修改" class="btn btn-primary btn-small">-->
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#updatebus" class="btn btn-primary" id="updateBusBtn" data-toggle="modal">修改</a>
					<!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  <div class="modal hide fade" id="updatebus" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">修改车辆信息</h2>
						 </div>
						 <div class="modal-body">
							<form class="form-horizontal" name="formupdate" id="formupdate" method="post" action="<%=request.getContextPath()%>/bus/update.action" >
								<div class="control-group">
									<label class="control-label" for="busId">车辆编号</label>
									<div class="controls" align="center">
										<input type="text" id="busId2" name="busId" value="${bus.busId}"readonly>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="busType">车辆类型</label>
									<div class="controls" align="center">
										<input type="text" id="busType2" name="busType" value="${bus.busType }" datatype="s2-16" errormsg="类型为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="busLicense">车辆牌照</label>
									<div class="controls" align="center">
										<input type="text" id="busLicense2" name="busLicense" value="${bus.busLicense }" datatype="s6-7" errormsg="牌照为6-7位字符！">
									</div>
								</div>
							
								
								<div class="control-group">
									<label class="control-label" for="busState">车辆状态</label>
									<div class="controls" align="center">
										<select  name="busState" id="busState2" >
					                    		<option  value=0>可用</option>
					                    		<option value=1>使用中</option>
			                    		</select >
									</div>
								</div>
								<div class="control-group">
									<div class="controls">                          
										<button type="submit" class="btn btn-primary">提交</button>
										<a href="">
										<button type="button" class="btn">返回</button>
									</a>									</div>
								</div>
							</form>
						</div>
					  </div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
				   <a id="btn" type="btn" class="btn" href="javascript:del();">删除</a>
				</div>
			<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
				</div>
	</div>
	<hr>
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>