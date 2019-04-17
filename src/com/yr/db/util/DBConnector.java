package com.yr.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	// Connection 


	public static Connection getConnect() throws Exception {
		String user="user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
	

		return con;
	}
	public static void disConnect(PreparedStatement st, Connection con) throws Exception {
		st.close();
		con.close();

	}

	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		rs.close();
	//	st.close();
	//	con.close();
	//  this -> 자기 자신의 객체주소
		DBConnector.disConnect(st, con);
		
	}




}


