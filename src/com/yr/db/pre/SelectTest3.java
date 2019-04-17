package com.yr.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest3 {

	public static void main(String[] args) {
		// dept 에서 부서의 개수는 총 몇 개?
		// 부서번호가 제일 큰 것과 제일 작은 것
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		//4가지
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 드라이버 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			// connection
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			// sql문 작성

			String sql = "select count(deptno), max(deptno), min(deptno) from dept";

			st = con.prepareStatement(sql);

			rs=st.executeQuery();
			
			rs.next(); // 무조건 1 row가 오기 때문에 if문 필요  X
			System.out.println("부서의 수: " + rs.getInt(1));
			System.out.println("가장 큰 부서 번호 : " + rs.getInt(2));
			System.out.println("가장 작은 부서 번호 : " + rs.getInt(3));

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
