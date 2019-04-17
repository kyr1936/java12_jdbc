package com.yr.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		// 조회할 부서번호 입력받기

		Connection con = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		// 1. 4가지 정ㅂ
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			// 2. 드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			// 3. Connection	
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			// 4. sql문	
			String sql = "select*from dept where deptno=?";

			// 5. 미리 전송	
			st = con.prepareStatement(sql);
			// 6. ? 세팅	
			System.out.println("부서번호 입력");
			int deptno = sc.nextInt();
			st.setInt(1, deptno);
			// 7. 최종 전송 후 처리	
			rs = st.executeQuery();

			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 :" + rs.getString("dname"));
				System.out.println("지역명: " + rs.getString("loc"));
			} else System.out.println("없는 부서번호입니다.");


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
