<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>中软OA-系统登陆</title>
<script type="text/javascript" src="js/jquery.js"></script>

<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript">

	$(document).ready(function(e) {
        
		/*用户登录*/
		$('#submitBtn').click(function(e) {
			
			var usernameVal = $('#username').val();
			var passwordVal = $('#password').val();
            
			$.post('login/checkLogin.action',{username:usernameVal,password:passwordVal},function(data){
				if (data == '1') {
					alert("用户名不存在");
				} else if (data == '2') {
					alert("密码输入错误");
				} else if (data == '3') {
					window.top.location.href = 'pages/index.jsp';
				}
					
			});
			
        });
		
    });

</script>
</head>
<body>
<div id="container1"><img src="images/1.bmp"></div>

  <div id="container">
<form name="form1" method="post" action="login/checkLogin.action">
                    
                    <div id="img1"><img src="images/login4.jpg"></div>
<div class="login">系统登录</div>
                    <div class="username-text">用户名:</div>
                    <div class="password-text">密码:</div>
                    <div class="username-field">
                        <input type="text" name="username" id="username" value="<shiro:principal/>">
                    </div>
                    <div class="password-field">
                        <input type="password" name="password" id="password" value="">
                    </div>
                    <div id="container1"><input type="button" id="submitBtn" name="button" value="GO" /></div>
                
                    
            
            </form>
        </div>







</body>
</html>