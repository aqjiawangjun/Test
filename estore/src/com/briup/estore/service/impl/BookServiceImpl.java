package com.briup.estore.service.impl;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.dao.impl.BookDaoImpl;
import com.briup.estore.service.IBookService;

public class BookServiceImpl implements IBookService {
	private IBookDao bookdao=new BookDaoImpl();
	@Override
	public Book findById(Long id) throws BookException {
		Book book=null;
		book=bookdao.queryById(id);
		if(book==null){
			throw new BookException("找不到书"); 
		}
		return book;
	}

}
