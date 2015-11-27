<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquary-1.9.1/jquery-1.9.1.js" ></script>
    <script type="text/javascript" src="jquary-1.9.1/jquery-1.9.1.min.js" ></script>
<script type="text/javascript">

function createXMLHttpRequest(){
	try {
		return new XMLHttpRequest();
	} catch (e) {
	}try {
		return ActvieXObject("Msxm12.XMLHTTP");
	} catch (e) {
	}try {
		return ActvieXObject("Microsoft.XMLHTTP");
	} catch (e) {
		throw e;
	}
}
function check(){
	var userEle = document.getElementById("userName");
		var xmlHttp = createXMLHttpRequest();
		var url="register?flag=check";
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttp.send("username="+userEle.value);
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState ==4 && xmlHttp.status ==200){
				var text = xmlHttp.responseText;
				if(text=="1"){
					var span = document.getElementById("errorSpan");
					span.innerHTML ="用户名已被注册！";
					return false;
				}else if(text=="0"){
					var span = document.getElementById("errorSpan");
					span.innerHTML ="";
					return true;
				}
			
		}
	}
}
function checkpassword(){
	var password1 =document.getElementById("password1");
	var password2 =document.getElementById("password2");
	if(password1.value!=password2.value){
		var span = document.getElementById("errorpassword");
		span.innerHTML = "密码不一致!";
		return false;
	}else{
		var span = document.getElementById("errorpassword");
		span.innerHTML = "";
		return true;
	}
}
function checkEmail()
		{
			var email = document.getElementById("email").value;
			var check = /^\w+@\w+\.(com|cn)$/;
			if(!check.test(email))
			{	
				document.getElementById("checkEmail").innerHTML ="邮箱格式不正确!";
				return false;
			}else{
			document.getElementById("checkEmail").innerHTML = "";
			return true;
			}
		}
function checklength(){
	var password = document.getElementById("password1").value;
	if(password.length<6){
		var span = document.getElementById("length");
		span.innerHTML="密码不能小于6位!";
		return false;
	}else{
		var span = document.getElementById("length");
		span.innerHTML="";
		return true;
	}
}

function checkform(form1)  
                    {  
                       
                         if(!checkpassword())  
                        {  
                            alert("请输入正确的密码");  
                            return false;  
                        }else if(!checkEmail())  
                        {  
                            alert("请输入正确的邮箱");  
                            return false;  
                        }else if(!checklength())  
                        {  
                            alert("请输入正确的密码长度");  
                            return false;  
                        }    
                        return true;  
                    }   
</script>
  </head>
  <body>
<div id="header" class="wrap">
	<div id="logo">网上书城</div>
	<div id="navbar">
		<%@ include file="jsp/Top.jsp" %>
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form method="post" action="login" name = "form1" onsubmit="return checkform(this)">
	<input type="hidden" name = "flag" value ="regist"/>
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" id = "userName" name="userName" onblur = "check()"/><span id = "errorSpan"></span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" id="password1" onblur="checklength()"/><span id="length"></span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" type="password" name="rePassWord" id="password2" onblur = " checkpassword()"/><span id="errorpassword"></span></dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" name="email" id = "email"  onblur = "checkEmail()"/><span id="checkEmail"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有

</div>
</body>
</html>
