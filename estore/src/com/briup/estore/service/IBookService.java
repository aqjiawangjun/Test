package com.briup.estore.service;
import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;

public interface IBookService {
	
	Book findById(Long id) throws BookException;
}
