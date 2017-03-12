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
	$('#updateDeviceBtn').click(function(){
		
		var i = $('input[name="ids"]:checked').length;
		if (i <= 0){
			alert("请选择要修改的设备！");
			return false;
		}
	});
	
	 $('#devDate1').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
	});
	 
	 $('#devDate2').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
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
		
		var devId = $(this).parent().parent().find('td').eq(2).text();
		var devName = $(this).parent().parent().find('td').eq(3).text();
		var devAmount = $(this).parent().parent().find('td').eq(4).text();
		var devPro = $(this).parent().parent().find('td').eq(5).text();
		var devDate = $(this).parent().parent().find('td').eq(6).text();
		var devAvailable = $(this).parent().parent().find('td').eq(7).text();
	   
	   $('#devId').val($.trim(devId));
	   $('#devName').val($.trim(devName));
	   $('#devAmount').val($.trim(devAmount));
	   $('#devPro').val($.trim(devPro));
	   //$('#devDate').val($.trim(devDate));
	 
	   $('#devAvailable').val($.trim(devAvailable));
	  
	   $('#devId2').val($.trim(devId));
	   $('#devName2').val($.trim(devName));
	   $('#devAmount2').val($.trim(devAmount));
	   $('#devPro2').val($.trim(devPro));
	   
	   $('#devDate2').val($.trim(devDate));
	   $('#devAvailable2').val($.trim(devAvailable));
    });
	
	
	  
		


	
});

function del() {
	var flag = window.confirm("确定要删除此设备吗");
	if (flag) {
		location.href = "delete.action?devId=" + $('#devId2').val() ;
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
		<li><a href="#">会议管理</a><span class="divider">/</span></li>
		<li class="active">设备管理</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8">
	  
				
				  <form  name="form1" method="post" action="<%=request.getContextPath()%>/device/query.action">
					<table width="90%" border="0" class="table table-striped">
					  <tr>
						<td width="">
							<th>全选</th>
						</td>
						<th width="">设备编号</th>
						<th width="">设备名称</th>
						<th width="">数量</th>
						<th width="">生产商</th>
						<th width="">购买日期</th>
						<th width="">可用数量</th>
					  </tr>
					  <c:forEach items="${list }" var="device">
			              <tr>
			              	<td>
								<td><input type="radio" name="ids"></td>
							</td>
							<td>${device.devId }</td>
			                <td>${device.devName }</td>
			                <td>${device.devAmount }</td>
			                <td>${device.devPro }</td>
			                <td><fmt:formatDate value="${device.devDate }" pattern="yyyy-MM-dd"/></td>
			                <td>${device.devAvailable }</td>
			              </tr>
		              </c:forEach>
					</table>
					
				  </form>
				  
				  
			
		<!--  <input type="submit" value="增加" class="btn btn-primary btn-small" >-->
				  	<div align="right">
				  <a href="#adddevice" class="btn btn-primary" id="addDeviceBtn" data-toggle="modal">增加</a>
			  
					  <!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  <div class="modal hide fade" id="adddevice" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">增加设备</h2>
						 </div>
						 <div class="modal-body">
							  <form class="form-horizontal" name="formadd" id="formadd" method="post" action="<%=request.getContextPath()%>/device/insert.action">
								<div class="control-group">
									<label class="control-label" for="devName">设备名称</label>
									<div class="controls" align="center">
										<input type="text" id="devName" name="devName"  datatype="s2-16" errormsg="设备名称为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devAmount">数量</label>
									<div class="controls" align="center">
										<input type="text" id="devAmount" name="devAmount" datatype="n" errormsg="必须输入数字！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devPro">生产商</label>
									<div class="controls" align="center">
										<input type="text" id="devPro" name="devPro"  datatype="s2-16" errormsg="生产商名称为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devDate">购买日期</label>
									<div class="controls" align="center">
										<input type="text" id="devDate1" name="devDate" value="<fmt:formatDate value="${device.devDate }" pattern="yyyy-MM-dd" />" datatype="*" errormsg="请输入日期！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devAvailable">可用数量</label>
									<div class="controls" align="center">
										<input type="text" id="devAvailable" name="devAvailable" datatype="n" errormsg="必须输入数字！">
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
							<a href="#updatedevice" class="btn btn-primary" id="updateDeviceBtn" data-toggle="modal">修改</a>
					<!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  <div class="modal hide fade" id="updatedevice" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">修改设备</h2>
						 </div>
						 <div class="modal-body">
							<form class="form-horizontal" name="formupdate" id="formupdate"  method="post" action="<%=request.getContextPath()%>/device/update.action">
								<div class="control-group">
									<label class="control-label" for="devId">设备编号</label>
									<div class="controls" align="center">
										<input type="text" id="devId2" name="devId" value="${device.devId}"readonly>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devName">设备名称</label>
									<div class="controls" align="center">
										<input type="text" id="devName2" name="devName" value="${device.devName }" datatype="s2-16" errormsg="设备名称为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devAmount">数量</label>
									<div class="controls" align="center">
										<input type="text" id="devAmount2" name="devAmount" value="${device.devAmount }" datatype="n" errormsg="必须输入数字！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devPro">生产商</label>
									<div class="controls" align="center">
										<input type="text" id="devPro2" name="devPro" value="${device.devPro }" datatype="s2-16" errormsg="生产商名称为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devDate">购买日期</label>
									<div class="controls" align="center">
										<input type="text" id="devDate2" name="devDate" value="<fmt:formatDate value="${device.devDate }" pattern="yyyy-MM-dd" />" datatype="*" errormsg="请输入日期！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="devAvailable">可用数量</label>
									<div class="controls" align="center">
										<input type="text" id="devAvailable2" name="devAvailable" value="${device.devAvailable }" datatype="n" errormsg="必须输入数字！">
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
				   <a type="btn" class="btn" href="javascript:del();">删除</a>
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