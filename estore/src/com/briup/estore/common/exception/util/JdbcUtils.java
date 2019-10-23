package com.briup.estore.common.exception.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.briup.bean.User;
import com.mysql.jdbc.Statement;

public class JdbcUtils {
	
	private static String driverClass = "com.mysql.jdbc.Driver";

	private static String url = "jdbc:mysql://localhost:3306/estore";

	private static String username = "root";

	private static String password = "123";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		return conn;
	}
     public static Object executeDML(String sql) {
    	 Connection conn=null;
    	 Statement stmt=null;
    	 Object obj=null;
    	 try {
			conn = getConnection();
			stmt= (Statement) conn.createStatement();
			obj=stmt.execute(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(conn,stmt);
		}
		return obj;
     }
     public static Object executeQuery(String sql,resultSetHandler handler){
    	 Object obj=null;
    	 Connection conn=null;
    	 java.sql.Statement stmt=null;
    	 ResultSet rs=null;
    	 
			try {
				try {
					conn=getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=conn.createStatement();
			    rs=stmt.executeQuery(sql);
			    obj=handler.process(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
    	 return obj;
     }
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	public void close(Connection conn) {
		close(conn, null, null);
	}
}
