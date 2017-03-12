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
			tiptype:3,
			ajaxPost:true,
			callback:function(data){
				
				$.Showmsg("增加成功");
				
				setTimeout(function(){
					location.href="<%=request.getContextPath()%>/expinf/query.action";	
				},2);
				
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
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">外派人才管理</a><span class="divider">/</span></li>
		<li><a href="#">外派人才信息管理</a><span class="divider">/</span></li>
		<li class="active">外派人才详细信息</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		<li><a href="<%=request.getContextPath() %>/expinf/query.action">外派人才信息</a></li>
		      <li><a href="<%=request.getContextPath() %>/assigncom/query.action">外派公司信息</a></li>
</ul>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>请填写新员工信息</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/expinf/insert.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">外派人才编号</td>
                    <td width="76%"><input type="text" name="expinfId" id="expinfId" readonly></td>
                  </tr>
                  <tr>
                    <td>外派人才姓名</td>
                    <td><input type="text" name="expinfName" id="expinfName" datatype="s1-20" errormsg="姓名必须是1到20个字符！"></td>
                  </tr>
                  <tr>
                    <td>外派人才学历</td>
                    <td><input type="text" name="expinfEdu" id="expinfEdu" placeholder="员工所获最高学历" datatype="s1-50" errormsg="学历必须是1到50个字符！"></td>
                  </tr>
                  <tr>
                    <td>外派人才技能</td>
                    <td><input type="text" name="expinfSki" id="expinfSki" datatype="s1-50" errormsg="技能必须是1到50个字符！"></td>
                  </tr>
                  <tr>
                    <td>外派人才户口</td>
                    <td><input type="text" name="expinfAcc" id="expinfAcc" datatype="s1-100" errormsg="户口必须是1到100个字符！"></td>
                  </tr>
                  <tr>
                    <td>外派人才薪金</td>
                    <td><input type="text" name="expinfSal" id="expinfSal" datatype="n1-8" errormsg="薪金必须是1到8位数字"></td>
                  </tr>
                  <tr>
                    <td>外派人才工作经历</td>
                    <td><textarea name="expinfExp" rows="7" id="expinfExp" style="width:100%;"></textarea></td>
                  </tr>
                </table>
                <input type="submit" value="保存外派人才信息" class="btn btn-primary btn-large">
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>