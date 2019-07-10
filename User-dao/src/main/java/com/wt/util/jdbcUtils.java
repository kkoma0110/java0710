package com.wt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcUtils {
    private static String driver ="com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String pwd = "123456";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConn() throws SQLException {
			return DriverManager.getConnection(url,user,pwd);
	}
	
	public static void free(ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}finally {
			try {
				if(stat!=null){
					stat.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}finally {
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException();
				}
			}
		}
	}
	
	
}
