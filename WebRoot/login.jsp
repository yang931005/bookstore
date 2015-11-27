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
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <body>
<div id="header" class="wrap">
	<div id="logo">网上书城</div>
	<div id="navbar">
			<%@ include file="jsp/Top.jsp" %>

	</div>
</div>
<div id="login">
	<h2>用户登陆</h2>
	<form method="post" action="login">
	<input type="hidden" name="flag" value="login"></input>
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" name="userName" /></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" /></dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.jsp';" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有</div>

  </body>
</html>
