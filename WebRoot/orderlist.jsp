<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <title>My JSP 'orderlist.jsp' starting page</title>
    
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
				<li class="current"><a href="order.do?flag=show">我的订单</a></li>
				<li><a href="item.do?flag=show">购物车</a></li>
				<%@ include file="jsp/head.jsp" %>
			</ul>
		</div>
			<%@ include file="jsp/Top.jsp" %>

	</div>
</div>
<div id="content" class="wrap">
	<div class="list orderList">
			<table>
				<tr class="title">
					<th class="orderId">订单编号</th>
					<th>订单商品</th>
					<th class="userName">收货人</th>
					<th class="price">订单金额</th>
					<th class="createTime">下单时间</th>
					<th class="status">订单状态</th>
					<th class="status">评论</th>
				</tr>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.oid}</td>
						<td class="thumb"><img src="${item.imageUrl}" /></td>
						<td>${users.userName }</td>
						<td>${item.totalPrice}</td>
						<td>${item.creatDate }</td>
						<td>已完成</td>
						<td><a href="comment.do?flag=comment&bid=${item.bid}">评论</a></td>
					</tr>
				</c:forEach>
				
			</table>
			<p align="right"> 当前页数:[${PageNo }/${totalPage}]&nbsp;
      <c:choose>
      <c:when test="${PageNo == 1&&totalPage>1}">
     	<a href="order.do?flag=show&PageNo=${PageNo + 1 }">下一页</a> &nbsp;<a href="order.do?flag=show&PageNo=${totalPage}">末页</a> 
      </c:when>
      <c:when test="${totalPage == 1}">
       <a href="order.do?flag=show&PageNo=1">首页</a>&nbsp;<a href="order.do?flag=show&PageNo=${totalPage}">末页</a> 
      </c:when>
      <c:when test="${PageNo == totalPage }">
       <a href="order.do?flag=show&PageNo=1">首页</a>&nbsp;<a href="order.do?flag=show&PageNo=${PageNo - 1 }">上一页</a> 
      </c:when>
      <c:otherwise>
      	<a href="order.do?flag=show&PageNo=1">首页</a>&nbsp;<a href="order.do?flag=show&PageNo=${PageNo - 1 }">上一页</a>&nbsp;<a href="order.do?flag=show&PageNo=${PageNo + 1 }">下一页</a>&nbsp;<a href="order.do?flag=show&PageNo=${totalPage }">末页</a>
      </c:otherwise>
      </c:choose>
      </p>
			<div class="button"><input class="input-gray" type="submit" name="submit" value="查看一个月前的订单" /><input class="input-gray" type="submit" name="submit" value="查看一个月前的订单" /></div>
	</div>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有</div>
</body>
</html>
