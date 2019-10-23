package com.briup.estore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.util.JdbcUtils;
import com.briup.estore.common.exception.util.resultSetHandler;
import com.briup.estore.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public void saveOrder(Order order) {
		Date now = new Date();		
		Timestamp timeStamp = new Timestamp(now.getTime()); 
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql = "insert into tbl_orderform(cost,orderdate,customer_id,state,pay) values("+order.getCost()+",'"+timeStamp+
				"',"+order.getCustomer().getId()+",'"+order.getState()+"','"+order.getPay()+"')";
		JdbcUtils.executeDML(sql);
	}

	@Override
	public Order findOrderById(Long id) {
		String sql = "select * from tbl_orderform where id="+id;
	return	(Order) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				Order order = null;
				while(rs.next()){
					Customer c = new Customer();
					c.setId(rs.getLong("customer_id"));
					order = new Order(rs.getLong("id"),rs.getDouble("cost"),rs.getTimestamp(3),
							rs.getString("state"),rs.getString("pay"),null,c);
					
				}
				return order;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderByCustomerId(Long id) {
		String sql = "select * from tbl_orderform where customer_id="+id;
	return	(List<Order>) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				List<Order> list = new ArrayList<>();
				while(rs.next()){
					Customer c = new Customer();
					c.setId(rs.getLong("customer_id"));
					Order order = new Order(rs.getLong("id"),rs.getDouble("cost"),rs.getTimestamp(3),
							rs.getString("state"),rs.getString("pay"),null,c);
					list.add(order);
					
				}
				return list;
			}
		});

	}

	@Override
	public void deleteOrderById(long orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getMaxId() {
		
		String sql = "select max(id) from tbl_orderform";
		return (long) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				long id=1;
				while(rs.next()){
					id = rs.getLong(1);
					
				}
					
				return id;
			}
		});
	}

}
