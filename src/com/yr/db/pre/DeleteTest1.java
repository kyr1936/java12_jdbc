package com.yr.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {

	public static void main(String[] args) {
		// 부서번호를 입력 받아서
		// dept에서 삭제
		Connection con = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		int result=0;
	
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
	
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			
			String sql = "delete dept where deptno=?" ;
			st=con.prepareStatement(sql);		
			
			System.out.println("부서번호 입력");
			int deptno = sc.nextInt();
			
			st.setInt(1,deptno);
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
