package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;

import com.briup.estore.service.impl.CustomerServiceImple;
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICustomerService  customerService =new CustomerServiceImple();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path;
		String msg;
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		try {
			@SuppressWarnings("unused")
			Customer customer=customerService.login(name, password);
			path="/index.jsp";
			msg="登录成功！";
			req.getSession().setAttribute("customer", customer);
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path="/login.jsp";
			msg="登录失败！"+e.getMessage();
		}
		req.setAttribute("msg",msg);
		req.getRequestDispatcher(path).forward(req, resp);
		
	}

}
