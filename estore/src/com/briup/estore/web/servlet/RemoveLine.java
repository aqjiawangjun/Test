package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShoppingCar;

@WebServlet("/removeProduct")
public class RemoveLine extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productid = Integer.parseInt(req.getParameter("productid"));
		ShoppingCar shoppingcar = (ShoppingCar) req.getSession().getAttribute("shoppingcar");
		String path = "/user/shopcart.jsp";
		shoppingcar.delete((long)productid);
		req.getSession().setAttribute("shopingcar", shoppingcar);
		resp.sendRedirect(req.getContextPath()+path);
	}

}
