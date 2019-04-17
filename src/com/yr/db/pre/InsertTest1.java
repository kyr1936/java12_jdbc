package com.yr.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest1 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);		
		int result = 0;

		//1. 로그인 정보 4가지
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		// 3. 로그인 후 Connection 받기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
		// 4. SQL문 작성 : 데이터베이스에게 미리 전달해서 준비
			String sql = "insert into dept values(?, ?, ?)"; // 입력받아야 할 데이터
								// 밸류값만 ? 가능
	
			st = con.prepareStatement(sql);
		
		
			System.out.println("부서번호 입력");
			int deptno=sc.nextInt();
			System.out.println("부서명 입력");
			String dname = sc.next();
			System.out.println("지역 입력");
			String loc = sc.next();
			
			// st.setXXX(?의 인덱스번호, 해당하는 값);
			st.setInt(1,deptno);
			st.setString(2, dname);
			st.setString(3, loc);
		// 7. 최종 전송 후 결과처리 // 이미 insert문을 보냈으므로 ()
			result = st.executeUpdate();

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
