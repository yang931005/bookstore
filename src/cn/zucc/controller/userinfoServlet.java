package cn.zucc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zucc.entity.User;
import cn.zucc.service.userService;

public class userinfoServlet extends HttpServlet{

	userService userService = new userService();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("login".equals(req.getParameter("flag"))){
			login(req,resp);
		}
		else if("regist".equals(req.getParameter("flag"))){
			regist(req,resp);
		}
		else if("remove".equals(req.getParameter("flag"))){
			remove(req,resp);
		}else if("check".equals(req.getParameter("flag"))){
			String username = req.getParameter("username");
			if(userService.userCheck(username)){
				resp.getWriter().print("0");
			}else{
				resp.getWriter().print("1");
			}
	}
	}
		public void remove(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			HttpSession session = req.getSession();
			session.removeAttribute("users");
			resp.sendRedirect("index");
		}
		public void login(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			User user = new User();
			user.setUserName(req.getParameter("userName"));
			user.setPassword(req.getParameter("passWord"));
			if(userService.userLogin(user)){
				HttpSession session = req.getSession();
				session.setAttribute("users", user);
				RequestDispatcher  rd1 = req.getRequestDispatcher("index");
				rd1.forward(req, resp);
			}else{resp.sendRedirect("login.jsp");}
		}
		public void regist(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			User user = new User();
			user.setUserName(req.getParameter("userName"));
			user.setPassword(req.getParameter("passWord"));
			user.setEmail(req.getParameter("email"));
			if(userService.adduser(user)){
				resp.sendRedirect("register_success.jsp");
			}	else{
				resp.sendRedirect("register.jsp");
			}
		}
		
}
