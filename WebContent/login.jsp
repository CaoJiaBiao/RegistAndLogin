<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
<title>登录</title>
<style type="text/css">
body{
	text-align: center;
	background-image: url("img/login.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
}
#top{
	margin-top:50px;
	font-size: 30px;
	color: #FFEB9D;
}
#main{
	border: none;
	margin-top: 50px;
}
input {
	background: transparent;
	border-radius: 20px;
	border: none;
	font-size: 20px;
	border: 1px blue solid;
	text-align: center;
	color: green;
}
#btn {
	margin-left: 10px;
}
#blank{
	height: 20px;
}
</style>
</head>
<body>
<div id="top">
	<span>欢迎登录</span>
</div>
<div id="main">
	<form action="${pageContext.request.contextPath }/loginServlet" method="post">
		<table align="center">
			<tr>
				<td align="right">用户名:</td>
				<td>
					<input type="text" name="username" id="username">
				</td>
			</tr>
			<tr>
				<td align="right">密码:</td>
				<td>
					<input type="text" name="password" id="password">
				</td>
			</tr>
			<tr>
			<td id="blank">&nbsp;</td>
			</tr>
		</table>
		<input id="btn" type="submit" value="登录" style="border: 1px black solid;">
	</form>
	${login_msg}
</div>
</body>
<script type="text/javascript">
	
</script>
</html>