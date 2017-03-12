<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>中软OA系统-在线信息</title>
<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../../css/myInfo.css" rel="stylesheet" type="text/css">
<link href="../../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
<script type="text/javascript" src="../../js/popwin.js"></script>
<script type="text/javascript" src="../../js/Validform_v5.3.2_ncr_min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(e) {
		
		//添加表单验证
		$('#form1').Validform();
		
        //选择部门模态窗口
		$('#empBtn').click(function(){		
			
			popWin.showWin("600","500","选择收件人","<%=request.getContextPath() %>/emp1/querySmall.action");				
		});
        
		//发送信息
		$('#sendNewBtn').click(function(e) {
			
			if($('input[name=empList]').length==0){
				alert('请选择收件人！');
				return;				
			}
			
            $('#form1').attr('action','<%=request.getContextPath() %>/message/sendManyNew.action');
			$('#form1').submit();
        });
		
		//增加数据
		$('#insertBtn').click(function(e) {
            $('#form1').attr('action','<%=request.getContextPath() %>/message/insertMany.action');
			$('#form1').submit();
        });
				
		$('#cancelBtn').click(function(){
			
		});
				
    });
	
	function delSend(objId) {
		$('#'+objId).parent().parent().remove();
	}
</script>


</head>
<body>


<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">
  <!--导航路径-->
  <ul class="breadcrumb">
    <li><a href="#"><font color="#000000">当前位置</font></a><span class="divider">：</span></li>
    <li><a href="#"><font color="#000000">在线信息</font></a><span class="divider">/</span></li>
    <li class="active">发送新信息</li>
  </ul>
  
  <!--网页主体内容-->
  <div class="row" style="min-height:400px;"> 
    <!--左侧导航菜单-->
    <div class="span4">
    	<ul class="left_nav_menu">
        	<li><a href="<%=request.getContextPath() %>/pages/message/AddMessage.jsp">新建留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryRead.action">收件箱</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryNoRead.action">未阅留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryReadYet.action">已阅留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/querySendYet.action">已发留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryNoSend.action">草稿箱</a></li>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="span8">
    
       <h3>发送新留言</h3>
       <form id ="form1" name="form1" method="post">
	       <table width="500" border="0" align="center" class="table">
	          <tr>
	      	    <td>收件人</td>
	      	    <td>
	      	    <input type="hidden" name="sendId" id="sendId" value ="${emp1Id}" >	      	    
	      	    <table id="sendList">
	      	    </table>      	    
	            <input type="button" name="button" id="empBtn" value="选择收件人" class="btn btn-primary">
	           </td>
	   	      </tr>
		      <tr>
		        <td height="24" align="center">内容</td>
		        <td><textarea name="messageCont" rows="8" id="messageCont" style="width:100%;" datatype="*" nullmsg="留言内容不可为空" placeholder="请输入消息内容"></textarea></td>
		      </tr>
		    </table>
		    <div align="center">
			    <input type="button" name="sendNewBtn" id="sendNewBtn" value="发送" class="btn btn-primary">
			    <input type="button" name="insertBtn" id="insertBtn" value="保存为草稿" class="btn btn-primary">
		    </div>
    	</form>
    </div>
  </div>
  
  <!--网页底部-->
  <jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
  
  
</div>
</body>
</html>