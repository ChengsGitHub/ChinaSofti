<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		$('#startTime').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d H:i:s'
		});
		$('#endTime').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d H:i:s'
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
		<li><a href="#">车辆管理</a><span class="divider">/</span></li>
		<li><a href="#">用车记录</a><span class="divider">/</span></li>
		<li class="active">更新用车记录</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/BusMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>使用详情</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/busrecord/update.action">
                <table width="100%" border="0" class="table table-striped" align="center">
                  <tr>
                    <td width="24%">编号</td>
                    <td width="76%"><input type="text" name="brecordId" id="brecordId" value="${busrecord.brecordId }"readonly></td>
                  </tr>
                  <tr>
                    <td>使用人</td>
                    <td>
                    	<input type="text" name="userName" id="userName" value="${busrecord.userName }" datatype="s2-18" errormsg="姓名是2-18位字符！">
                    </td>
                  </tr>
                  <tr>
                    <td>驾驶员</td>
                    <td>
                    	<input type="text" name="driver" id="driver" value="${busrecord.driver}" datatype="s2-18" errormsg="姓名是2-18位字符！">
                    </td>
                  </tr>
                  <tr>
                    <td>用途</td>
                    <td>
                    	<input type="text" name="useReason" id="useReason" value="${busrecord.useReason }"datatype="*" errormsg="必须输入内容！">
                    </td>
                  </tr>
                  <tr>
                    <td>路线</td>
                    <td>
                    	
                    	<input type="text" name="path" id="path" value="${busrecord.path }" datatype="*" errormsg="必须输入内容！">
                    </td>
                  </tr>
                  <tr>
                    <td>用车时间</td>
                    <td>
                    	<input type="text" name="startTime" id="startTime" value="<fmt:formatDate value="${busrecord.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" placeholder="请输入用车时间" datatype="*" errormsg="请输入字符串！">--
                    	<input type="text" name="endTime" id="endTime" value="<fmt:formatDate value="${busrecord.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" placeholder="请输入用车时间" datatype="*" errormsg="请输入字符串！">
                    </td>
                  </tr>
               </table>
                <p align="center">
                <input type="submit" value="修改" class="btn btn-primary ">
                <input type="button"  value="返回" class="btn btn-primary " onclick="history.back();">
                </p>
          </form>

      </div>
	</div>
	<hr>
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>