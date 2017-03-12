<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

		var setting = {
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {				
					onClick: folderClick
				}
			};
		
		//单击目录节点事件回调
		function folderClick(event, treeId, treeNode, clickFlag) {	
			$('#folderName').val(treeNode.name);
			$('#folderId').val(treeNode.id);
			$('#parentId').val(treeNode.id);
			
			//显示文件列表
			window.open('<%=request.getContextPath()%>/document/queryByFolderId.action?folderId='+treeNode.id,'right');
		}
		
		function loadFolderList() {
			//异步加载文件夹列表
			$.getJSON('<%=request.getContextPath()%>/folder/queryByEmpId.action',function(data){
				
				$.fn.zTree.init($("#folderList"), setting, data);
				
			});
		}
		
		//初始化列表
		loadFolderList();
		
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		
	});
	
	//修改
	function update() {
		$('#form1').attr('action','<%=request.getContextPath()%>/folder/update.action');	
		$('#form1').submit();
	}

	//删除子文件夹
	function del() {
		var flag = window.confirm("确定要删除此文件夹吗");
		if (flag) {
			var folderId = $('#folderId').val();
			location.href='<%=request.getContextPath()%>/folder/delete.action?folderId=' + folderId;	
		}
	}

	//设置共享
	function sharing() {
		$('#form1').attr('action','<%=request.getContextPath()%>/folder/updateSharing.action?sharing=1');	
		$('#form1').submit();
	}
	//查询文件
	function queryByFolderId(){
		  var folderId=document.getElementById('folderId').value;
		  location.href="queryByFolderId.action?folderId=" + folderId;
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
		<li><a href="/oa/pages/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">个人文件夹</a><span class="divider">/</span></li>
		<li class="active">文件夹列表</li>    
	</ul>

	<div class="row">
		<div class="span4" style="min-height: 400px;">
				<ul id="folderList" class="ztree"></ul>
			</div>		
		    <div class="span8" style="min-height: 400px;">
		     <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/folder/insert.action">
			     	
            	<input type="text" name="folderName" id="folderName">
               	<input type="button" value="修改" class="btn btn-primary" onclick="update();">	
            	<input type="button" value="删除" class="btn btn-primary" onclick="del();">
            	<input type="button" value="共享" class="btn btn-primary" onclick="sharing();">
            	<br>
            	<input type="hidden" name="parentId" id="parentId">
            	<input type="hidden" name="folderId" id="folderId">
            	<input type="text" name="subFolderName" id="subFolderName">
            	<input type="submit" value="添加子文件夹" class="btn btn-primary">   
            </form>	
          
           	<iframe id="iframe1" width="100%" height="500" name="right" src="" frameborder="0"></iframe>
			 	      
	   	 </div>
		</div>

	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>