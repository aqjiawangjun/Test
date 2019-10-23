package com.briup.estore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.common.exception.LineException;
import com.briup.estore.dao.ILineDao;
import com.briup.estore.dao.impl.BookDaoImpl;
import com.briup.estore.dao.impl.LineDaoImpl;
import com.briup.estore.service.ILineService;

public class LineServiceImpl implements ILineService {
	ILineDao lineDao = new LineDaoImpl();

	@Override
	public void addLine(Line line) throws LineException {
		
		
	}

	@Override
	public void removeLine(int id) throws LineException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAllLine(Map<Long, Line> lineList,long id) throws LineException {
		for(Line li:lineList.values()){
			lineDao.savaLine(li, id);
		}
		
	}

	@Override
	public List<Line> findByOrderId(long id) {
		List<Line> list = lineDao.findLineByOrderId(id);
    	List<Line> list2 = new ArrayList<>();
		BookDaoImpl bd = new BookDaoImpl();
		 for(int i = 0 ; i<list.size();i++){
			 Line line = list.get(i);
			 
			 Line line2 = new Line();
			 long bid = line.getBook().getId();
			 Long id2 = line.getId();
			 Integer num = line.getNum();
			 Book book = bd.queryById(bid); 
			 line2.setBook(book);
			 line2.setId(id2);
			 line2.setNum(num);
			 list2.add(line2);
			 
			
			 
		 }
		return list2;
	}

}
