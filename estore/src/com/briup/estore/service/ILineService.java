package com.briup.estore.service;

import java.util.List;
import java.util.Map;

import com.briup.estore.bean.Line;
import com.briup.estore.common.exception.LineException;

public interface ILineService {
	void addLine(Line line)throws LineException;
	void addAllLine(Map<Long,Line> lineList,long id)throws LineException;
	void removeLine(int id)throws LineException;
	List<Line> findByOrderId(long orderid);
}
