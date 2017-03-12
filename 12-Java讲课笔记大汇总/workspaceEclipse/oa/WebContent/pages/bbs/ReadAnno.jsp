<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>中软OA系统-在线信息</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/myInfo.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/common.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<jsp:include page="/pages/inc/Header.jsp"></jsp:include><!--导航路径-->
<div class="container">
<!--导航路径-->
<ul class="breadcrumb">
	<li><a href="#">当前位置</a><span class="divider">：</span></li>
	<li><a href="<%=request.getContextPath()%>/bbs/query.action">公司公告</a><span
		class="divider">/</span></li>
	<li><a href="#">阅读公告</a><span class="divider"></span></li>
</ul>

<!--网页主体内容-->
<div class="row" style="min-height: 400px;">
	<!--左侧导航菜单-->
	<!--左侧导航菜单-->
	<div class="span4">
<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	</div>
	<!--右侧内容-->
	<div class="span8 ">
		<table width="592" height="172" border="0">
			<tr>
				<td align="center"><b> ${bbs.bbsTitle} </b></td>
			</tr>
			<tr>
				<td>${bbs.bbsCont}</td>
			</tr>
			<tr>
				<td width="72" align="right">公告日期：${bbs.time}</td>
			</tr>
		</table>
		</div>
	</div>
</div>

<!--网页底部-->
<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
</body>
</html>