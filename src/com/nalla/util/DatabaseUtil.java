package com.nalla.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	 static final String driver="oracle.jdbc.driver.OracleDriver";
	static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	 static final String userName="anunaresh";
	 static final String pwd="naresh";
	public DatabaseUtil() {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			new RuntimeException("something went worng"+e);
		}
		
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, pwd);
	}
}
