package com.briup.estore.service.impl;


import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.dao.impl.CustomerDaoImpl;
import com.briup.estore.service.ICustomerService;


public class CustomerServiceImple implements ICustomerService {
     private ICustomerDao customerDao=new CustomerDaoImpl();
	@Override
	public void register(Customer customer) throws CustomerException {
		String name=customer.getName();
		
		if(customerDao.findByName(name)!=null){
			throw  new CustomerException("用户名已经被占用");
		}else {
			customerDao.saveCustomer(customer);
		}
	}

	@Override
	public Customer login(String name, String password) throws CustomerException {
		if(name==null||"".equals(name)){
			throw new CustomerException("用户名不能为空");
		}
		if(password==null||"".equals(password)){
			throw new CustomerException("密码不能为空");
		}
		Customer customer =customerDao.findByName(name);
		if(customer==null){
			throw new CustomerException("用户名不存在");
		}
		if(! customer.getPassword().equals(password)){
			throw new CustomerException("密码错误");
		}
		return  customer;
		
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {

	}
}
