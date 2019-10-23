package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;
@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		List<Order> list_order = new ArrayList<>();
		String msg = null;
		try {
			list_order = orderService.findByCustomerId(customer.getId());
			msg="红楼梦";
		} catch (OrderException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.getSession().setAttribute("list_order", list_order);
		resp.sendRedirect(req.getContextPath()+"/user/order.jsp");
	}

}
