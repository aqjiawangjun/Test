package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShoppingCar;

@WebServlet("/removeall")
public class RemoveAll extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShoppingCar shoppingcar=(ShoppingCar) req.getSession().getAttribute("shoppingcar");
		String path="/user/shopcart.jsp";
		shoppingcar.clear();
		req.getSession().setAttribute("shoppingcar", shoppingcar);
		resp.sendRedirect(req.getContextPath()+path);
	}
	
}
