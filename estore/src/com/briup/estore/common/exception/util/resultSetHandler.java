package com.briup.estore.common.exception.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface resultSetHandler {

	Object process(ResultSet rs) throws SQLException;

}
