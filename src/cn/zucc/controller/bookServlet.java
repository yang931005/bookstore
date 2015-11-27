package cn.zucc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zucc.entity.Book;
import cn.zucc.service.bookService;
import cn.zucc.util.Page;

public class bookServlet extends HttpServlet {
	bookService bookService=new bookService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("search".equals(req.getParameter("flag"))){
				int PageNo="".equals(req.getParameter("PageNo"))? 1 :Integer.parseInt(req.getParameter("PageNo"));
				String keywords = req.getParameter("keywords");
				int totalPage=Page.totalCount(bookService.pagecount(keywords));
				List<Book> booklist = bookService.findBook(keywords,Page.pageNo(PageNo));
				RequestDispatcher  rd = req.getRequestDispatcher("index.jsp");
				req.setAttribute("totalPage", totalPage-1);
				req.setAttribute("PageNo", PageNo);
				req.setAttribute("booklist", booklist);
				rd.forward(req, resp);
			}else if("searchkeyword".equals(req.getParameter("flag"))){
				String keywords = req.getParameter("keywords");
				List<String> list = bookService.keywordbook(keywords);
				StringBuilder result = new StringBuilder();
				if(list!=null){
				for(int i = 0;i<list.size();i++){
					result.append((String)list.get(i)+"#");
				}
				PrintWriter out = resp.getWriter();
				out.println(result.toString());
				out.flush();
				out.close();
			}
				}
		else{
			show(req,resp);
		}
	}
	public void show(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int PageNo="".equals(req.getParameter("PageNo"))? 1 :Integer.parseInt(req.getParameter("PageNo"));
		int totalPage=Page.totalCount(bookService.pagecount());
		List<Book> booklist=bookService.findall(Page.pageNo(PageNo));
		RequestDispatcher  rd = req.getRequestDispatcher("index.jsp");
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("PageNo", PageNo);
		req.setAttribute("booklist", booklist);
		rd.forward(req, resp);
	}
}
