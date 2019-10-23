package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;
@WebServlet("/car")
public class AddOrderLineServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IBookService bookService =new BookServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String path = null;
		//@SuppressWarnings("unused")
		String msg=null;
		ShoppingCar shoppingcar=(ShoppingCar) req.getSession().getAttribute("shoppingcar");
		if(shoppingcar==null){
			shoppingcar=new ShoppingCar();
		}
		
		try {
			Book book=bookService.findById((long)bookId);
			Line line=new Line();
			line.setBook(book);
			shoppingcar.add(line);
			msg="加入购物车成功！";
			path="/user/shopcart.jsp"; 
		} catch (BookException e) {
			e.printStackTrace();
			msg="加入购物车失败！"+e.getMessage();
		}
		//req.setAttribute("msg", msg);
		req.getSession().setAttribute("shoppingcar",shoppingcar);
		resp.sendRedirect(req.getContextPath()+path);
		
		
	}

}
