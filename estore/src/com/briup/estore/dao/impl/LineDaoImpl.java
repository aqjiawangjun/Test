package com.briup.estore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.common.exception.util.JdbcUtils;
import com.briup.estore.common.exception.util.resultSetHandler;
import com.briup.estore.dao.ILineDao;

public class LineDaoImpl implements ILineDao {

	@Override
	public void savaLine(Line line, long id) {
		String sql = "insert into tbl_orderline(num,book_id,order_id) values("+line.getNum()+","+line.getBook().getId()+","+id+")";
		JdbcUtils.executeDML(sql);	
	}

	@Override
	public void deleteLineByOrderId(long orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savaLine(Line line) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Line> findLineByOrderId(long id) {
		String sql = "select * from tbl_orderline where order_id="+id;
	return	(List<Line>) JdbcUtils.executeQuery(sql, new resultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				List<Line> list = new ArrayList<>();
				while(rs.next()){
					Line line = new Line(rs.getLong("id"),rs.getInt("num"));
					Book book = new Book();
					book.setId(rs.getLong("book_id"));
					line.setBook(book);
					list.add(line);
				}
				return list;
			}
		});
		
		
	}

}
