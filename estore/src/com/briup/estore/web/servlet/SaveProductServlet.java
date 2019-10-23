package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.dao.impl.CustomerDaoImpl;
@WebServlet("/save")
public class SaveProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICustomerDao customerdao=new CustomerDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		String name=req.getParameter("name");
		String path="/confirmOrder.jsp";
		customerdao.findByName(name);
		req.getSession().setAttribute("customer", customer);
		resp.sendRedirect(req.getContextPath()+path);
	}

}
