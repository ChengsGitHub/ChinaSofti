<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会议记录上传</title>
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
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
	});
	//取消文件
	function cancel() {
		location.href="<%=request.getContextPath()%>/pages/meeting/UploadRecord.jsp?orderId="+${param.orderId };
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
		<li><a href="#">会议记录</a><span class="divider">/</span></li>
		<li class="active">上传会议记录</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h4>上传会议记录</h4>
	        <form id="form1" name="form1" method="post" action="<%=request.getContextPath() %>/meetingrecord/insert.action"  enctype="multipart/form-data">
	          <table class="table">	           	           
	            <tr>
	              <td height="24" align="center">选择文件</td>
	              <td height="24"><input type="file" name="fileData" id="fileData">
                  <input type="hidden" name="orderId" id="orderId" value="${param.orderId }"></td>
	            </tr>
	            <tr>
	              <td height="24" colspan="2" align="center">
	              	<input type="submit" name="button" id="button" value="提交" class="btn btn-primary">
	                <input type="button" name="button2" id="button2" value="取消" onclick="cancel();" class="btn btn-success">
	              </td>
	            </tr>
	          </table>
	        </form>
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>