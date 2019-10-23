package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Order;
import com.briup.estore.dao.IOrderDao;
import com.briup.estore.dao.impl.OrderDaoImpl;
@WebServlet("/showline")
public class ShowLine extends HttpServlet{
	private static final long serialVersionUID = 1L;
    IOrderDao orderdao=new OrderDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Order order=(Order) req.getSession().getAttribute("order");
    	List<Order> list=new ArrayList<>();
    }
}
