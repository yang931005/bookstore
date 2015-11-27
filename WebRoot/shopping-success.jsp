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
    <title>My JSP 'shopping-success.jsp' starting page</title>
    
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
		<div class="userMenu">
			<ul>
				<li><a href="index">User首页</a></li>
				<li><a href="order.do?flag=show">我的订单</a></li>
				<li class="current"><a href="item.do?flag=show">购物车</a></li>
				<%@ include file="jsp/head.jsp" %>
			</ul>
		</div>
		<%@ include file="jsp/Top.jsp" %>
	</div>
</div>
<div id="content" class="wrap">
	<div class="success">
		<div class="information">
			<p>恭喜：购买成功！</p>
			<p><a href="order.do?flag=show">点此查看订单详情&gt;&gt;</a></p>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有</div>
  </body>
</html>
