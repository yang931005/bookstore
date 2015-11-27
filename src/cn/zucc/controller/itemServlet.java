package cn.zucc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zucc.entity.Book;
import cn.zucc.entity.Order;
import cn.zucc.entity.Shopping;
import cn.zucc.entity.User;
import cn.zucc.service.itemService;
import cn.zucc.service.orderService;
import cn.zucc.service.shoppingService;

public class itemServlet extends HttpServlet {
	itemService itemService = new itemService();
	SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日");
	orderService orderService= new orderService();
	shoppingService shoppingService = new shoppingService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("booklist".equals(req.getParameter("flag"))){
			int state = 0;//订单未支付
			String[] list=req.getParameterValues("bookId");
			HttpSession session =req.getSession();
			User user = (User)session.getAttribute("users");
			String name = user.getUserName();
			Order order = orderService.findorderbyname(name,state);
			if(list==null){
				resp.sendRedirect("book.do");
			}else{
				if(order==null){
					Order neworder = new Order();
					neworder.setUserName(name);
					orderService.addorder(neworder);
					Order orders = orderService.findorderbyname(user.getUserName(), 0);
					for(int i =0;i<list.length;i++){
						Shopping shopping = new Shopping();
						int num = Integer.parseInt(list[i]);
						Book book =itemService.findBookById(num);
						int count = 1;
						if(shoppingService.find(book.getBookName(),orders.getOid())){
							shopping.setBookName(book.getBookName());
							shopping.setCount(count);
							shopping.setImages(book.getImages());
							shopping.setPrice(book.getPrice());
							shopping.setOid(orders.getOid());
							shoppingService.addshopping(shopping);
						}
						}
						show(req,resp);
				}
				else{
					for(int i =0;i<list.length;i++){
						Shopping shopping = new Shopping();
						int num = Integer.parseInt(list[i]);
						Book book =itemService.findBookById(num);
						int count = 1;
						book.getBid();
						if(shoppingService.find(book.getBookName(),order.getOid())){
							shopping.setBookName(book.getBookName());
							shopping.setCount(count);
							shopping.setImages(book.getImages());
							shopping.setPrice(book.getPrice());
							shopping.setOid(order.getOid());
							shoppingService.addshopping(shopping);
						}
					}
					show(req,resp);
				}
			}
		}else if("show".equals(req.getParameter("flag"))){
			show(req,resp);
		}else if("delete".equals(req.getParameter("flag"))){
			String name = req.getParameter("bookname");
			shoppingService.deleteshopping(name);
			show(req,resp);
		}
	}
	
	public void show(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		HttpSession session =req.getSession();
		int state = 0;//订单未支付
		User user = (User)session.getAttribute("users");
		String name = user.getUserName();
		Order order =orderService.findorderbyname(name,state);
		if(order==null){
			order = new Order();
			order.setUserName(name);
			orderService.addorder(order);
		}
		int oid = order.getOid();
		List<Shopping> shoppinglists = shoppingService.findshoppingByOid(oid);
		RequestDispatcher  rd1 = req.getRequestDispatcher("shopping.jsp");
		req.setAttribute("shoppinglists",shoppinglists );
		rd1.forward(req, resp);
	}

}
