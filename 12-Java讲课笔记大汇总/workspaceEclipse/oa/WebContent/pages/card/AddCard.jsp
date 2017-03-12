<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<li><a href="#">名片夹</a><span class="divider">/</span></li>
		<li><a href="#">名片夹分类</a><span class="divider">/</span></li>
		<li class="active">增加名片夹</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!--左侧导航菜单-->
				<div class="span3">
					<ul class="left_nav_menu">
                          <li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                          <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
					</ul>
				</div>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>请填写分类名称</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/Card/insert.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td>名称</td>
                    <td><input type="text" name="grouName" id="grouName"  datatype="*" errormsg="不能为空！"></td>
                  </tr>
                </table>
                <input type="submit" value="保存分类" class="btn btn-primary btn-large">
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>