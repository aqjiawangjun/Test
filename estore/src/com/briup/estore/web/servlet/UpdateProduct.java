package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShoppingCar;

@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		ShoppingCar shoppingcar = (ShoppingCar) req.getSession().getAttribute("shoppingcar");
		shoppingcar.update(bookId, num);
		req.getSession().setAttribute("shoppingcar", shoppingcar);
		resp.sendRedirect(req.getContextPath()+"/user/shopcart.jsp");
		
}

}
