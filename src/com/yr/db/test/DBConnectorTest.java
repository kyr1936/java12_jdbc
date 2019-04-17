package com.yr.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.yr.db.util.DBConnector;

public class DBConnectorTest {
	// Annotation : 설명+실행 기능
	@Test 
	public void test() throws Exception {
		// 테스트할 코드
		Connection con = DBConnector.getConnect();
		assertNotNull(con); // con 이 null이 아닌지.. null이 아니면 성공
								//(con은 null이 아니어야함)		
	//	assertEquals(1, 0);
	}

}
