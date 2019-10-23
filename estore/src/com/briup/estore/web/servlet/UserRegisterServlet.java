package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;

import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImple;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerService customerService =new CustomerServiceImple();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		Customer customer=new Customer(name, password, zip, address,telephone, email);
		String path;
		String msg;
		try {
			customerService.register(customer);
			path="/login.jsp";
			msg="注册成功！请登录";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path="/register.jsp";
			msg="注册失败！"+e.getMessage();
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(path).forward(req, resp);
		

	}

}
