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
@WebServlet("/updatecustomer")
public class UpdateCustomerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICustomerDao customerdao=new CustomerDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name=req.getParameter("name");
		    String password=req.getParameter("password");
		    String address = req.getParameter("address");
		    String telephone= req.getParameter("telephone");
		    String zip = req.getParameter("zip");
		    String email = req.getParameter("email");
		    Customer customer=new Customer(name,password,zip,address,telephone,email);
		    String path = null;
		    String msg;
		    try {
				customerdao.updateCustomer(customer);
				msg="修改成功！";
				req.getSession().setAttribute("customer", customer);
				path="/index.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg="修改失败！"+e.getMessage();
				path="/userinfo.jsp";
			}
		    req.setAttribute("msg", msg);
		    resp.sendRedirect(req.getContextPath()+path);
	}
}
