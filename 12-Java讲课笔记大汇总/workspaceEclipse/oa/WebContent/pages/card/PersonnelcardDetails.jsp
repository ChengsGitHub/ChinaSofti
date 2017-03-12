<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="../js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/popwin.js"></script>
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
		<li><a href="#">个人名片夹</a><span class="divider">/</span></li>
		<li class="active">个人名片信息</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<div class="span3">
				<ul class="left_nav_menu">
                         <li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                         <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
				</ul>
			</div>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>个人名片信息</h3>
              <form name="form1" id="form1" method="post" action="../Personnelcard/update.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工名片编号</td>
                    <td width="76%"><input type="text" name="cardId" id="cardId" readonly value="${Personnelcard.cardId }"></td>
                  </tr>
                   <tr>
                    <td>所属分组</td>
                    <td><input type="text" name="groupId" id="groupId" readonly value="${Personnelcard.groupId }"></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="cardName" id="cardName" value="${Personnelcard.cardName }" datatype="s2-8" errormsg="请输入长度2-8位的字符！"></td>
                  </tr>
                  <tr>
                    <td>性别</td>
                    <td>
                    	<select name="sex">
                    		<option value="男" ${Personnelcard.sex=='男'?'selected':'' }>男</option>
                    		<option value="女" ${Personnelcard.sex=='女'?'selected':'' }>女</option>
                    	</select>
                    </td>
                  </tr>
                  <tr>
                    <td>移动电话</td>
                    <td><input type="text" name="mobilephone" id="mobilephone" value="${Personnelcard.mobilephone}" datatype="m" errormsg="请输入移动电话！"></td>
                  </tr>
                  <tr>
                    <td>办公电话</td>
                    <td><input type="text" name="telephone" id="telephone" value="${Personnelcard.telephone }"></td>
                  </tr>
                  <tr>
                    <td>电子邮件</td>
                    <td><input type="text" name="mailaddr" id="mailaddr" value="${Personnelcard.mailaddr }" datatype="e" errormsg="请输入邮件地址！"></td>
                  </tr>
                  <tr>
                    <td>住址</td>
                    <td><input type="text" name="addr" id="addr" placeholder="目前家庭详细住址" value="${Personnelcard.addr }"></td>
                  </tr>
                  <tr>
                    <td>所属部门</td>
					<td><input type="text" name="deptname" id="deptname" value="${Personnelcard.deptname }"></td>
                  </tr>
                  <tr>
                    <td>职务</td>
					<td><input type="text" name="position" id="position" value="${Personnelcard.position }"></td>
                  </tr>
                </table>
                <input type="submit" value="保存个人信息" class="btn btn-primary btn-large">
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>