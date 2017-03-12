<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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
	$('#updateRoomBtn').click(function(){
		
		var i = $('input[name="ids"]:checked').length;
		if (i <= 0){
			alert("请选择要修改的会议室！");
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
		
		var roomId = $(this).parent().parent().find('td').eq(2).text();
		var roomName = $(this).parent().parent().find('td').eq(3).text();
		var roomAddr = $(this).parent().parent().find('td').eq(4).text();
		var roomAmount = $(this).parent().parent().find('td').eq(5).text();
		var roomAir = $(this).parent().parent().find('td').eq(6).text();
		var roomState = $(this).parent().parent().find('td').eq(7).text();
	   
	   $('#roomId').val($.trim(roomId));
	   $('#roomName').val($.trim(roomName));
	   $('#roomAddr').val($.trim(roomAddr));
	   $('#roomAmount').val($.trim(roomAmount));
	   $('#roomAir').val($.trim(roomAir));
	   $('#roomState').val($.trim(roomState));
	  
	   $('#roomId2').val($.trim(roomId));
	   $('#roomName2').val($.trim(roomName));
	   $('#roomAddr2').val($.trim(roomAddr));
	   $('#roomAmount2').val($.trim(roomAmount));
	   $('#roomAir2').val($.trim(roomAir));
	   $('#roomState2').val($.trim(roomState));
    });
	
});

function del() {
	var flag = window.confirm("确定要删除此会议室吗");
	if (flag) {
		location.href = "delete.action?roomId=" + $('#roomId2').val() ;
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
		<li class="active">会议室管理</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8">
	  				
	  				<form name="form3" id="form3" action="<%=request.getContextPath() %>/meetingroom/queryByCondition.action" method="get">
			        	<input type="text" name="roomName" id="roomName" placeholder="请输入会议室名称" value="${meetingroom.roomName }">
			        	<input type="submit" value="按名称检索" class="btn btn-primary">	   
	        		</form> 
					
				
			  		<p>&nbsp;</p>
				  <form  name="form1" method="post" action="<%=request.getContextPath()%>/meetingroom/query.action">
					<table width="90%" border="0" class="table table-striped">
					  <tr>
						<th width="">
							<th>全选</th>
						</th>
						<th width="">会议室编号</th>
						<th width="">会议室名称</th>
						<th width="">会议室地点</th>
						<th width="">容纳人数</th>
						<th width="">有无空调</th>
						<th width="">使用状态</th>
					  </tr>
					  <c:forEach items="${list }" var="meetingroom">
			              <tr>
			              	<td>
								<td><input type="radio" name="ids"></td>
							</td>
							<td>${meetingroom.roomId }</td>
			                <td>${meetingroom.roomName }</td>
			                <td>${meetingroom.roomAddr }</td>
			                <td>${meetingroom.roomAmount }</td>
			                <td>
			                	<c:if test="${meetingroom.roomAir ==0}">有</c:if>
                				<c:if test="${meetingroom.roomAir ==1}">无</c:if>
                			</td>
			                <td>
			                	<c:if test="${meetingroom.roomState ==0}">可用</c:if>
                				<c:if test="${meetingroom.roomState ==1}">不可用</c:if>
                			</td>
			              </tr>
		              </c:forEach>
					</table>
					
				  </form>
				  
				  
			
		<!--  <input type="submit" value="增加" class="btn btn-primary btn-small" >-->
				  	<div align="right">
				  <shiro:hasAnyRoles name="行政负责人,超级用户">
				  	<a href="#addroom" class="btn btn-primary" id="addRoomBtn" data-toggle="modal">增加</a>
			      </shiro:hasAnyRoles>
					  <!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  <div class="modal hide fade" id="addroom" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">增加会议室</h2>
						 </div>
						 <div class="modal-body">
							  <form class="form-horizontal" name="formadd" id="formadd" method="post" action="<%=request.getContextPath()%>/meetingroom/insert.action">
								<div class="control-group">
									<label class="control-label" for="roomName">会议室名称</label>
									<div class="controls" align="center">
										<td><input type="text" id="roomName" name="roomName" value="${meetingroom.roomName }" datatype="s2-16" errormsg="名称为2-16位字符！"></td>
										<td>&nbsp;</td>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAddr">会议室地点</label>
									<div class="controls" align="center">
										<input type="text" id="roomAddr" name="roomAddr" value="${meetingroom.roomAddr }" datatype="s2-16" errormsg="地点为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAmount">容纳人数</label>
									<div class="controls" align="center">
										<input type="text" id="roomAmount" name="roomAmount" value="${meetingroom.roomAmount }" datatype="n" errormsg="请输入数字！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAir">有无空调</label>
									<div class="controls" align="center">
										<select  name="roomAir" id="roomAir" >
					                    		<option  value=0>有</option>
					                    		<option value=1>无</option>
			                    		</select >
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomState">使用状态</label>
									<div class="controls" align="center">
										<select  name="roomState" id="roomState" >
					                    		<option  value=0>可用</option>
					                    		<option value=1>不可用</option>
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
							 <shiro:hasAnyRoles name="行政负责人,超级用户">
								<a href="#updateroom" class="btn btn-primary" id="updateRoomBtn" data-toggle="modal">修改</a>
							</shiro:hasAnyRoles>
					<!--模态对话框内容  data-backdrop="static"表示用户点击黑色区域不会关闭对话框-->
					  
					  <div class="modal hide fade" id="updateroom" data-backdrop="static" aria-hidden="true">
					  
						 <div class="modal-header">
							<a href="#" class="close" data-dismiss="modal">&times;</a>
							<h2 class="text-center" style="color:#000000">修改会议室</h2>
						 </div>
						 <div class="modal-body">
							<form class="form-horizontal" name="formupdate" id="formupdate" method="post" action="<%=request.getContextPath()%>/meetingroom/update.action">
								<div class="control-group">
									<label class="control-label" for="roomId">会议室编号</label>
									<div class="controls" align="center">
										<input type="text" id="roomId2" name="roomId" value="${meetingroom.roomId}"readonly>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomName">会议室名称</label>
									<div class="controls" align="center">
										<input type="text" id="roomName2" name="roomName" value="${meetingroom.roomName }" datatype="s2-16" errormsg="名称为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAddr">会议室地点</label>
									<div class="controls" align="center">
										<input type="text" id="roomAddr2" name="roomAddr" value="${meetingroom.roomAddr }" datatype="s2-16" errormsg="地点为2-16位字符！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAmount">容纳人数</label>
									<div class="controls" align="center">
										<input type="text" id="roomAmount2" name="roomAmount" value="${meetingroom.roomAmount }" datatype="n" errormsg="请输入数字！">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomAir">有无空调</label>
									<div class="controls" align="center">
										<select  name="roomAir" id="roomAir2" >
					                    		<option  value=0>有</option>
					                    		<option value=1>无</option>
			                    		</select >
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="roomState">使用状态</label>
									<div class="controls" align="center">
										<select  name="roomState" id="roomState2" >
					                    		<option  value=0>可用</option>
					                    		<option value=1>不可用</option>
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
				<shiro:hasAnyRoles name="行政负责人,超级用户">
				   <a type="btn" class="btn" href="javascript:del();">删除</a>
				 </shiro:hasAnyRoles>
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