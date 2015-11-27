package cn.zucc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zucc.entity.Book;
import cn.zucc.entity.Item;
import cn.zucc.entity.Order;
import cn.zucc.entity.Shopping;
import cn.zucc.entity.User;
import cn.zucc.service.bookService;
import cn.zucc.service.itemService;
import cn.zucc.service.orderService;
import cn.zucc.service.shoppingService;
import cn.zucc.util.Page;

public class orderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	bookService bookService = new bookService();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		orderService orderService = new orderService();
		SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日");
		shoppingService shoppingService = new shoppingService();
		itemService itemService = new itemService();
		HttpSession session =req.getSession();
		int state = 0;//订单还没支付
		User user = (User)session.getAttribute("users");
		Order order = orderService.findorderbyname(user.getUserName(),state);
		String[] listid=req.getParameterValues("shoppingid");
		String[] listcount=req.getParameterValues("count");
		if("addorder".equals(req.getParameter("flag"))){
			for(int i = 0; i<listid.length;i++){
				int shoppingid = Integer.parseInt(listid[i]);
				int count = Integer.parseInt(listcount[i]);
				Shopping shopping = orderService.findsById(shoppingid);
				Item item = new Item();
				item.setOid(order.getOid());
				int bookid = shoppingService.findbookname(shopping.getBookName()).getBid();
				int booknum = itemService.findBookById(bookid).getStock();
				int stock = booknum-count;
				bookService.update(bookid, stock);
				item.setBid(bookid);
				item.setCount(count);
				item.setCreatDate(sdf.format(new Date()));
				item.setPrice(shopping.getPrice());
				item.setTotalPrice(count*shopping.getPrice());
				item.setUsername(user.getUserName());
				itemService.add(item);
			}
			orderService.updateState(order.getOid());
			shoppingService.delete(order.getOid());
			resp.sendRedirect("shopping-success.jsp");
			
		}else if("show".equals(req.getParameter("flag"))){
			int PageNo="".equals(req.getParameter("PageNo"))? 1 :Integer.parseInt(req.getParameter("PageNo"));
			int totalPage=Page.totalCount(orderService.pagecount(user.getUserName()));
			List<Item> items  = itemService.findByName(user.getUserName(),Page.pageNo(PageNo));
			for(Item i : items){
				String imageUrl = itemService.findBookById(i.getBid()).getImages();
				i.setImageUrl(imageUrl);
			}
			RequestDispatcher  rd1 = req.getRequestDispatcher("orderlist.jsp");
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("PageNo", PageNo);
			req.setAttribute("items",items);
			rd1.forward(req, resp);
		}
		
	}

}
