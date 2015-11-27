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
    <title>My JSP 'index.jsp' starting page</title>
    
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
				<li class="current"><a href="index">User首页</a></li>
				<li><a href="order.do?flag=show">我的订单</a></li>
				<li><a href="item.do?flag=show">购物车</a></li>
				<%@ include file="jsp/head.jsp" %>
			</ul>
			</div>
			<%@ include file="jsp/Top.jsp" %>
		</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" action="item.do">
		<input type="hidden" name="flag" value = "booklist">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th>书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>
				<c:forEach items="${booklist}" var="Book">
				<tr>
					<td><input type="checkbox" name="bookId" value="${Book.bid }" /></td>
					<td class="title">${Book.bookName}</td>
					<td>￥${Book.price }</td>
					<td>${Book.stock }</td>
					<td class="thumb"><img src="${Book.images}" /></td>
				</tr>
				</c:forEach>
			</table>
			<p align="right"> 当前页数:[${PageNo }/${totalPage}]&nbsp;
      <c:choose>
       <c:when test="${totalPage == 1}">
      </c:when>
      <c:when test="${PageNo == 1}">
     	<a href="book.do?PageNo=${PageNo+1  }">下一页</a> &nbsp;<a href="book.do?PageNo=${totalPage}">末页</a> 
      </c:when>
      <c:when test="${PageNo == totalPage }">
       <a href="book.do?PageNo=1">首页</a>&nbsp;<a href="book.do?PageNo=${PageNo - 1 }">上一页</a> 
      </c:when>
      <c:otherwise>
      	<a href="book.do?PageNo=1">首页</a>&nbsp;<a href="book.do?PageNo=${PageNo - 1 }">上一页</a>&nbsp;<a href="book.do?PageNo=${PageNo + 1 }">下一页</a>&nbsp;<a href="book.do?PageNo=${totalPage }">末页</a>
      </c:otherwise>
      </c:choose>
      </p>
			<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有

</div>
  </body>
</html>
