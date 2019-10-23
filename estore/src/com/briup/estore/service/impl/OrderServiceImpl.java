package com.briup.estore.service.impl;

import java.util.List;

import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.dao.IOrderDao;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	IOrderDao orderDao = new OrderDaoImpl();
	@Override
	public long confirmOrder(Order order) throws OrderException {
		orderDao.saveOrder(order);
		return orderDao.getMaxId();

	}

	@Override
	public void deleteOrder(Long id) throws OrderException {
		orderDao.deleteOrderById(id);

	}

	@Override
	public Order findById(Long id) throws OrderException {
		Order findOrderById = orderDao.findOrderById(id);
		return findOrderById;
	}

	@Override
	public List<Order> findByCustomerId(Long id) throws OrderException {
		List<Order> findOrderByCustomerId = orderDao.findOrderByCustomerId(id);
		return findOrderByCustomerId;
	}

}
