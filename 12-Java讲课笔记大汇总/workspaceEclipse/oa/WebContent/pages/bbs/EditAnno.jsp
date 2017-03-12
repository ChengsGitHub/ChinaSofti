<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.icss.oa.system.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/kindeditor/themes/default/default.css" />
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/kindeditor/zh_CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/kindeditor/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">

		$(document).ready(function(){
							
			//转换textarea到kindeditor，简化类型编辑器
	    	var editor2 = KindEditor.create('#bbsCont', {	    		
	    		items : [
	    			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
	    			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
	    			'insertunorderedlist', '|', 'emoticons', 'link']
	    	});	
		
		});
			$(function(){
	$(".registerform").Validform({
		tiptype:3
	});
})
	</script>
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>
<div class="container">
<!--导航路径-->
<ul class="breadcrumb">
	<li><a href="#">当前位置</a><span class="divider">：</span></li>
	<li><a href="全部留言.html">公司公告</a><span class="divider">/</span></li>
	<li><a href="#">发布公告</a><span class="divider"></span></li>
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
	<c:if test="${a!=1}">
			<form id="form1" name="form1" method="post" class="registerform"
				action="<%=request.getContextPath()%>/bbs/insert.action">
				<table width="690" height="345" border="0">
					<tr>
						<td width="81" height="45">主题:</td>
						<td width="599"><input type="text" name="bbsTitle" rows="1"
							style="width: 80%;" datatype="s4-37" nullmsg="请输入标题！"
							errormsg="中文名为4~37个字符！" value="${bbs.bbsTitle }"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><textarea name="bbsCont" id="bbsCont" rows="20"
								cols="100">${bbs.bbsCont }</textarea></td>
					</tr>
				</table>
				<div align="center">
					<input type="submit" name="button" id="button" value="发布"
						class="btn btn-primary"> <a
						href="<%=request.getContextPath()%>/bbs/queryByTime1.action"> <input
						type="button" name="button2" id="button2" value="取消" class="btn  ">
					</a>
				</div>
				</table>
			</form>
			</c:if>
			<c:if test="${a==1}">
						<form id="form1" name="form1" method="post" class="registerform"
				action="<%=request.getContextPath()%>/bbs/update.action">
				<table width="690" height="345" border="0">
					<tr>
						<td width="81" height="45">主题:</td>
						<td width="599"><input type="text" name="bbsTitle" rows="1"
							style="width: 80%;" datatype="s4-37" nullmsg="请输入标题！"
							errormsg="中文名为4~37个字符！" value="${bbs.bbsTitle }"></td>
						<input type="hidden" name="bbsId" value="${bbs.bbsId }">
                        <input type="hidden" name="bbsTop" value="${bbs.bbsTop }">
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><textarea name="bbsCont" id="bbsCont" rows="20"
								cols="100">${bbs.bbsCont }</textarea></td>
					</tr>
				</table>
				<div align="center">
					<input type="submit" name="button" id="button" value="发布"
						class="btn btn-primary"> <a
						href="<%=request.getContextPath()%>/bbs/queryByTime1.action"> <input
						type="button" name="button2" id="button2" value="取消" class="btn  ">
					</a>
				</div>
				</table>
			</form>
			</c:if>
			
		</div>
	</div>
</div>
<!--网页底部-->
<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
</body>
</html>