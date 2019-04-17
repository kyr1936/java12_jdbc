package com.yr.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;


import org.junit.Test;

import com.yr.db.point.PointDAO;
import com.yr.db.point.PointDTO;

public class PointDAOTest {

	@Test
	public void test()  {
		PointDAO dao = new PointDAO();
		PointDTO dto = new PointDTO();
		int result=0;
		try {
			result = dao.insert(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, result);
		
	}

}
