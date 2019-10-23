package com.briup.estore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.util.JdbcUtils;
import com.briup.estore.common.exception.util.resultSetHandler;
import com.briup.estore.dao.IBookDao;
@SuppressWarnings("all")
public class BookDaoImpl implements IBookDao {

	@Override
	public List<Book> queryAll() {
		// TODO Auto-generated method stub
		String sql="select * from tbl_book ";
	return 	(List<Book>) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				List <Book>list=new ArrayList<>();
				Book book=null;
				while(rs.next()){
					book=new Book(
							rs.getLong("id"),
							rs.getString("name"),
							rs.getDouble("price")
							
							);
					
					list.add(book);
				}
				return list;
			}
		});
		
	}

	@Override
	public Book queryById(Long id) {
		String sql="select * from tbl_book where id="+id;
	return	(Book) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			public Object process(ResultSet rs) throws SQLException {
				Book book=null;
				while(rs.next()){
					book=new Book(
							rs.getLong("id"),
							rs.getString("name"),
							rs.getDouble("price"),
							rs.getString("witer"),
							rs.getString("press"),
							rs.getInt("page"),
							rs.getString("intro")
							);
					
				}
				return book;
			}
		});
		
	}

}
