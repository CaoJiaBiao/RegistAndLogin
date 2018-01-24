<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%String path = request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>用户登录</title>
<style type="text/css">
body{
	text-align: center;
	background-image: url(img/login.jpg);
	background-size: 100% 800px;
}
div{
	border-radius: 20px;
	margin-top: 20px;
	height: 40px;
	border: 1px white solid;
}
#main {
	border-width: 0px;
	margin-top: 100px;
	margin-left: auto;
	margin-right: auto;
	width: 300px;
	height: 200px;
}
#login {
	letter-spacing: 30px;
	font-size: 20px;
	color: white;
	border: none;
	outline: none;
	height: 38px;
	width: 100px;
	background: transparent;
}
#registdiv{
	margin-top: 50px;
	text-align: center;
}
#username{
	background: transparent;
	color: white;
	border: none;
	font-size: 20px;
	text-align: center;
}
#password{
	background: transparent;
	color: white;
	border: none;
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<base href="<%=basePath%>">
<body>

<form action="${pageContext.request.contextPath }/login">
	<div id="main">
		<div>
			<input type="text" name="username" id="username" placeholder="请输入用户名">
		</div>
		<div>
			<input type="password" name="password" id="password" placeholder="请输入密码">
			<div id="showpwd" onmousedown="showPassword()"
					onmouseup="hiddenPassword()">
			</div>
		</div>
		<div style="border-width:0px;">
				记住密码:<input type="checkbox" name="rember"> 
				<input type="radio" name="rembertime" value="7" checked="checked" />一周 
				<input type="radio" name="rembertime" value="30" />一个月
		</div>
			<div id="logindiv">
				<input type="submit" value="登录" id="login">
			</div>
	</div>
</form>
<dir id="registdiv">
	<a href="regist.jsp">注册</a>
</dir>
<div align="center" style="color:red;border-width:0px;">
	${login_msg}
</div>
</body>
<script type="text/javascript">
	function showPassword() {
		document.getElementById("password").type="text";
	}
	function hiddenPassword() {
		document.getElementById("password").type="password";
	}
</script>
</html>