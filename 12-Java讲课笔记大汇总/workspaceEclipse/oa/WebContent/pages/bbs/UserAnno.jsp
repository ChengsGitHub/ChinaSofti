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
	src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript">
function a(val){
document.location.href=val;
}
</script>
<jsp:include page="/pages/inc/Header.jsp"></jsp:include><!--导航路径-->
<div class="container">
<!--导航路径-->
<ul class="breadcrumb">
	<li><a href="#">当前位置</a><span class="divider">：</span></li>
	<li><a href="">公司公告</a></li>
</ul>

<!--网页主体内容-->
<div class="row" style="min-height: 400px;">

<div class="span3">
</div>
	<!--右侧内容-->
	<div class="span9">
	  <table width="561" border="0" align="center">
			<tr>
				<td><select onChange="a(this[selectedIndex].value);" style="width: 150px;">
							<option style="color: #000000" ${a ==3?"selected= 'selected'" : ""} value="">请选择查询条件</option>
				  <option style="color: #000000" id="button1" value="<%=request.getContextPath() %>/bbs/queryByTime1.action?source=1" ${a ==1?"selected= 'selected'" : ""}>按时间倒序</option>
				  <option style="color: #000000" id="button2" value="<%=request.getContextPath() %>/bbs/query.action?source=1"  ${a ==2?"selected= 'selected'" : ""}>按时间顺序</option>
				    </select></td>
                    
			  <form name="form1" id="form1" action="queryByCondition.action" method="get">
					<td><input type="text" class="input-medium search-query"
						name="bbsCont" id="bbsCont" placeholder="输入关键字"
						value="${bbs.bbsCont}">
                        <input type="hidden" name="source" value=1>
                </td>
					<td><button type="submit" class="btn">查找</button></td>
				</form>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table width="561" border="0" align="center">
			<td width="53"><div align="left">
				<c:forEach items="${requestScope.list }" var="bbs">
					<c:if test="${bbs.bbsTop==1}">
						<tr>
							<td><img
								src="<%=request.getContextPath()%>/images/3.jpg" width="20"
								height="20"></td>
							<td width="399" align="left"><a href="<%=request.getContextPath() %>/bbs/queryOne.action?bbsId=${bbs.bbsId}" style="color: #F00"><c:out
									value="${bbs.bbsTitle }" /></a></td>
							<td width="80"><c:out value="${bbs.time}" /></td>
						</tr>
					</c:if>
				</c:forEach>
				<c:forEach items="${requestScope.list }" var="bbs">
					<c:if test="${bbs.bbsTop!=1}">
						<div style="color: #F00">
							<tr>
								<td><img
									src="<%=request.getContextPath()%>/images/3.jpg"
									width="20" height="20"></td>
								<td align="left"><a href="<%=request.getContextPath() %>/bbs/queryOne.action?bbsId=${bbs.bbsId}" style="color:#000"><c:out value="${bbs.bbsTitle }" /></a></td>
								<td width="80"><c:out value="${bbs.time}" /></td>
								<td width="11">&nbsp;</td>
							</tr>
						</div>
					</c:if>
				</c:forEach>
		</table>
		<div class="pagination" style="text-align: center;">
			<ul>
				<li><a href="#">共${pager.recordCount }条数据，每页${pager.pageSize }条，共${pager.pageCount }页，当前是第${pager.pageNum }页</a>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;跳至</td> <select
					onChange="a(this[selectedIndex].value);" style="width: 70px;">
						<c:forEach begin="1" end="${pager.pageCount}" var="i">
							<c:if test="${a==3}">
								<option style="color: #000000"
									value="?pageNum=${i}&&bbsCont=${bbsCont}&source=1"  ${i==pager.pageNum?"selected= 'selected'" : ""}>${i}</option>
							</c:if>
							<c:if test="${a==1||a==2}">
								<option style="color: #000000" value="?pageNum=${i}&source=1" ${i==pager.pageNum?"selected= 'selected'" : ""}>${i}</option>
							</c:if>
						</c:forEach>
				</select></li>
			</ul>
		</div>
		<c:if test="${a==1||a==2}">
			<div class="pagination pagination-centered">
				<ul>
					<li ${pager.pageNum==1?'class="disabled"':''}><a
						href="?pageNum=1&source=1">首页</a></li>
					<li ${pager.pageNum==1?'class="disabled"':''}><a
						href="?pageNum=${pager.pageNum-1 }&source=1">上页</a></li>
					<c:forEach begin="1" end="${pager.pageCount }" var="i">
						<c:if test="${i==pager.pageNum-3}">
							<li><a href="#">┅ </a></li>
						</c:if>
						<c:if test="${i==pager.pageNum-2}">
							<li><a href="?pageNum=${i}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum-1}">
							<li><a href="?pageNum=${i}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum}">
							<li class="disabled"><a href="?pageNum=${i}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+1}">
							<li><a href="?pageNum=${i}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+2}">
							<li><a href="?pageNum=${i}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+3}">
							<li><a href="#">┅ </a></li>
						</c:if>
					</c:forEach>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a
						href="?pageNum=${pager.pageNum+1 }&source=1">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a
						href="?pageNum=${pager.pageCount }&source=1">末页</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${a==3}">
			<div class="pagination pagination-centered">
				<ul>
					<li ${pager.pageNum==1?'class="disabled"':''}><a
						href="?pageNum=1&source=1&bbsCont=${bbsCont}">首页</a></li>
					<li ${pager.pageNum==1?'class="disabled"':''}><a
						href="?pageNum=${pager.pageNum-1 }&source=1&bbsCont=${bbsCont}">上页</a></li>
					<c:forEach begin="1" end="${pager.pageCount }" var="i">
						<c:if test="${i==pager.pageNum-3}">
							<li><a href="#">┅ </a></li>
						</c:if>
						<c:if test="${i==pager.pageNum-2}">
							<li><a href="?pageNum=${i}&&bbsCont=${bbsCont}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum-1}">
							<li><a href="?pageNum=${i}&&bbsCont=${bbsCont}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum}">
							<li class="disabled"><a
								href="?pageNum=${i}&&bbsCont=${bbsCont}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+1}">
							<li><a href="?pageNum=${i}&&bbsCont=${bbsCont}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+2}">
							<li><a href="?pageNum=${i}&&bbsCont=${bbsCont}&source=1">${i}</a></li>
						</c:if>
						<c:if test="${i==pager.pageNum+3}">
							<li><a href="#">┅ </a></li>
						</c:if>
					</c:forEach>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a
						href="?pageNum=${pager.pageNum+1 }&bbsCont=${bbsCont}&source=1">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?pageNum=${pager.pageCount}&bbsCont=${bbsCont}&source=1">末页</a></li>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
</div>

<!--网页底部-->
<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
</body>
</html>