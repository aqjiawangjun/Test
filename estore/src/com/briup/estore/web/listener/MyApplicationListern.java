package com.briup.estore.web.listener;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.briup.estore.bean.Book;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.dao.impl.BookDaoImpl;


@WebListener
public class MyApplicationListern implements ServletContextListener{
	
	private IBookDao  bookDao = new BookDaoImpl();
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Book>list=bookDao.queryAll();
	
		
		ServletContext application=sce.getServletContext();
		application.setAttribute("books", list);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
