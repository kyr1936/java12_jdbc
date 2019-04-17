package com.yr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest1 {

	public static void main(String[] args) {
		// 1. DB연결 정보 준비
		String user = "scott";
		String pw = "tiger";
		String url= "jdbc:oracle:thin:@211.238.142.30:1521:xe";   // 접속하려는 이의 ip번호와 port번호 // SID - 바꿀 수 있음
		String driver = "oracle.jdbc.driver.OracleDriver"; // 어떤 jdbc를 쓸건지 (library) 데이터 연동할때 사용할 클래스
		Connection con=null;
		Statement st = null;
		int result = 0;

		// 2. driver를 메모리에 로딩하는 작업 // 객체를 생성 - 문자열을 객체로 생성할 수 있는 방법
		try {
			Class.forName(driver);   // driver로 된 이름을 객체로 만듬
			System.out.println("드라이버 로딩 성공");

			// 3. DB서비스에 접속해서 로그인해서 Connection 받기
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");

			// 4. Query(SQL)문 생성 - 문자열, 세미콜론 (;) 생략
			String sql = "insert into dept values(11, 'OFFICE', 'BUSAN')"; // insert문

			// 5. 전송
			st = con.createStatement(); //전송 준비
			result = st.executeUpdate(sql); // 실패하면 0

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(result>0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}



	}

}
