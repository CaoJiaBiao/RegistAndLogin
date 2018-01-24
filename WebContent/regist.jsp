<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<style type="text/css">
body {
	background-image: url("img/registimg.jpg");
	text-align: center;
	background-repeat: no-repeat;
	background-size: 100% 717px;
}

#username,#registButton{
	border-radius: 20px;
	background: transparent;
	color: #237358;
	border: none;
	font-size: 20px;
	text-align: center;
	border: 1px black solid;
}
#password3,#password1,#password2{
	background: transparent;
	border-radius: 20px;
	color: #237358;
	border: none;
	font-size: 20px;
	text-align: center;
	border: 1px black solid;
}
#top{
	color: #237358;
	font-size: 50px;
	margin-top: 100px;
}


</style>
<title>注册</title>
<script type="text/javascript" src="js/myJS.js"></script>
</head>
<body>
<dir id="top">
	<span>欢迎注册</span>
</dir>
<div id="main">
	<form action="${pageContext.request.contextPath}/registServlet" method="post">
		<table align="center">
			<tr>
				<td>用户名:</td>
				<td>
					<input type="text" name="username" onblur="ckName()" id="username" placeholder="请输入姓名" >
					<span id="span1"></span>
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td>
					<input type="password" name="password1" id="password1" placeholder="请输入密码">
					<span id="span2"></span>
				</td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td>
					<input type="password" name="password2" id="password2" onblur="passwordConfirm()" placeholder="请确认密码">
					<span id="span3"></span>
				</td>
			</tr>
			<tr>
				<td>
				<img src="${pageContext.request.contextPath}/checkCodeServlet"
						onclick="changeCode()" id="imgcode" /></td>
				<td>
					<input type="text" name="password3" id="password3" placeholder="请输入验证码">
					<span id="span4"></span>
				</td>
			</tr>
		</table>
		<input type="submit" value="注册" id="registButton">
	</form>
	<span>${msg}</span>
</div>
<div id="bottom">
	<h5>JiaBiao先生</h5>
</div>
</body>
<script type="text/javascript">
	function passwordConfirm() {
		var tempword1=document.getElementById("password1");
		var tempword2=document.getElementById("password2");
		var temp1=document.getElementById("span3");
//		alert("passwordConfirm");
		if (tempword1.value==tempword2.value) {
			temp1.innerHTML="<font color='green'>√</font>";
		}else {
			temp1.innerHTML="<font color='red'>×</font>"
		}
	}
	function ckName() {
		//获取用戶名
		var name = document.getElementById("username");
		//创建XMLhttpRequest对象
		//alert(name);
		var xhr = getXMLHttpRequest();
		//处理结果
		xhr.onreadystatechange = function () {
			if(xhr.readyState==4){
				if(xhr.status==200){
					//alert(xhr.responseText);
					var msg = document.getElementById("span1");
					if(xhr.responseText=="yes"){
						msg.innerHTML =  "可以使用";
					}
					if(xhr.responseText=="no"){
						//alert("false");
						msg.innerHTML = "<font color='red'>不能使用</font>";
					}
				}
			}
		}
		//创建链接
		xhr.open("get","checkNameServlet?name="+name.value);
		//发送请求
		xhr.send(null);
	}


	function checkName() {
		var temp1=document.getElementById("username").value;
		var reg=/^[a-zA-Z]{1,5}$/;
		var flag=reg.test(temp1);
	}
	function showPassword() {
		document.getElementById("password").type="text";
	}
	function hiddenPassword() {
		document.getElementById("password").type="password";
	}
	function changeCode() {
		document.getElementById("imgcode").src="${pageContext.request.contextPath}/checkCodeServlet?imgpath="+Math.random();
	}
</script>
</html>