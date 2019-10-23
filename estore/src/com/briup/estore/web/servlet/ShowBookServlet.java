package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.dao.impl.BookDaoImpl;

@WebServlet("/showbook")
public class ShowBookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBookDao bookdao=new BookDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book=(Book) req.getSession().getAttribute("book");
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		String path="/user/productDetail.jsp";
		book=bookdao.queryById((long)bookId);
		req.getSession().setAttribute("book", book);
		resp.sendRedirect(req.getContextPath()+path);
		
	}

}
