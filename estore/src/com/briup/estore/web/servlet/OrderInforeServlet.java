package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.service.ILineService;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.LineServiceImpl;
import com.briup.estore.service.impl.OrderServiceImpl;
@WebServlet("/orderinfor")
public class OrderInforeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ILineService lineService = new LineServiceImpl();
	IOrderService orderService =  new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderid = Integer.parseInt(req.getParameter("orderid"));
		List<Line> list_line = new ArrayList<>();
		Order order = new Order();
		try {
			list_line = lineService.findByOrderId((long)orderid);
			order = orderService.findById((long)orderid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("order", order);
		req.getSession().setAttribute("list_line", list_line);
		resp.sendRedirect(req.getContextPath()+"/user/orderinfor.jsp");
		
	}

}
