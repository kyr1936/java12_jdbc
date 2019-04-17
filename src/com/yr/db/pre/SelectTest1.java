package com.yr.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs = null;
		
		String user="scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver= "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			String sql = "select*from dept order by deptno desc";
			
			st=con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 :" + rs.getString("dname"));
				System.out.println("지역명: " + rs.getString("loc"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		

		
	}
}
