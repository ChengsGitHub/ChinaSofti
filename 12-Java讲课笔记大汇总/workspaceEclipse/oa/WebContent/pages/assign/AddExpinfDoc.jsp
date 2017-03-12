<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validform_v5.3.2.js"></script>
<%-- <script type="text/javascript">
	$(document).ready(function(e) {
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3,	
				callback:function(data){
				
				$.Showmsg("增加成功");
				
				setTimeout(function(){
					location.href="<%=request.getContextPath()%>/expinf/toUpdate.action?expinfId=${param.expinfId }";	
				},1000);
				
			}		
		});
		
	});
</script> --%>
<script type="text/javascript">
//取消文件
	function cancel() {
		location.href="<%=request.getContextPath()%>/pages/assign/AddExpinfDoc.jsp?expinfId="+${param.expinfId };
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
		<li><a href="#">外派人才管理</a><span class="divider">/</span></li>
		<li><a href="#">外派人才详细信息</a><span class="divider">/</span></li>
		<li class="active">上传外派人才简历</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		<li><a href="<%=request.getContextPath() %>/expinf/query.action">外派人才信息</a></li>
		      <li><a href="<%=request.getContextPath() %>/assigncom/query.action">外派公司信息</a></li>
			</ul>
	    </div>
	    
	    <div class="span6" style="min-height: 400px;">
	    	<h4>上传外派人才简历</h4>
	        <form id="form1" name="form1" method="post" action="<%=request.getContextPath() %>/expinf/uploadImg.action"  enctype="multipart/form-data">
	          <table class="table">	           	           
	            <tr>
	              <td height="24" align="center">选择文档</td>
	              <td height="24"><input type="file" name="imageData" id="imageData">
                  <input type="hidden" name="expinfId" id="expinfId" value="${param.expinfId }"></td>
	            </tr>
	            <tr>
	              <td height="24" colspan="2" align="center">
	              	<input type="submit" name="button" id="button" value="提交" onclick="history.back();" class="btn btn-primary">
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