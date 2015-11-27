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
    
    <title>My JSP 'shopping.jsp' starting page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
	
<script type="text/javascript">
 		function totalprice() {
 		var totalprice = 0;
 		var price = 0;
 		var num = 0;
 		var myTableTr = document.getElementById("table1").getElementsByTagName("tr");
 		for ( var i = 1; i < myTableTr.length; i++) {
 			num = myTableTr[i].getElementsByTagName("td")[2]
 					.getElementsByTagName("input")[0].value;
 			price = myTableTr[i].getElementsByTagName("td")[3]
 					.getElementsByTagName("span")[0].innerHTML;
 			totalprice = totalprice + num * price;
 		}
 		if(totalprice!=""){
 			document.getElementById("totalprice").innerHTML = totalprice.toFixed(2);}
 	
 	}
	function checkDel()
{     
 if(confirm("确定要删除吗？"))
 {           
  action="<%=request.getContextPath()%>/DeleteNoticeServlet";
  }
 }
    </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  <body onload="totalprice()">
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
	<div class="list bookList">
		<form method="post" name="shopping" action="order.do">
		<input type="hidden" name="flag" value = "addorder" />
		<input type = "hidden" name = "shoppinglist" value = "${shoppinglists }"/>
		
			<table id="table1">
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
					<th class="operate">操作</th>
				</tr>
				<c:forEach items="${shoppinglists}" var="shopping">
				<tr>
					<td class="thumb"><img src="${shopping.images}" /></td>
					<td class="title">${shopping.bookName }</td>
					<td>
						<input class="input-text" type="text" name = "count" value="${shopping.count}" onblur="totalprice()"/>
						<input type="hidden" name="shoppingid" value="${shopping.id }"/>
						<input type="hidden" name="shoppingcount" value="${shopping.count }"/>
					</td>
					<td>￥<span>${shopping.price}</span></td>
					<td><a href="item.do?flag=delete&bookname=${shopping.bookName} ">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="button">
				<h4>总价：￥<span id="totalprice"></span>元</h4>&nbsp; 
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	网上书城 &copy; 版权所有

</div>
  </body>
</html>
