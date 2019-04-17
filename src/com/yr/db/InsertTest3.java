package com.yr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {
		// emp 테이블에 insert
		// deptno=30; comm=0; sal=1000; hiredate=오늘날짜 mgr=empno중 1 
		String user="scott";
		String password = "tiger";
		String url="jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			System.out.println("사원번호 입력");
			int empno=sc.nextInt();
			System.out.println("사원명 입력");
			String ename = sc.next();
			System.out.println("직업입력");
			String job = sc.next();
			System.out.println("상사번호 입력");
			int mgr = sc.nextInt();
	
			String sql = "insert into emp values(" +empno+",'"+ename+"','"+job+"',"
					+ mgr +","+"sysdate, 1000,0,30)";
			st=con.createStatement();
			result=st.executeUpdate(sql);
		
		
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
		} else System.out.println("실패");
		
		
		
	}
}
