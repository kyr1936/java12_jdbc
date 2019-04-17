package com.yr.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.yr.db.util.DBConnector;

public class PointDAO {

	// 메서드명  delete
	public int delete() throws Exception {
		
		
		
		return 0;
		
	}
	
	
	public int insert(PointDTO dto) throws Exception {
		
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into point values(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getNum());
		st.setString(2, dto.getsId());
		st.setInt(3, dto.getKor());
		st.setInt(4, dto.getEng());
		st.setInt(5, dto.getMath());
		st.setInt(6, dto.getTotal());
		st.setDouble(7, dto.getAvg());
		st.setInt(8, dto.getBnum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
		
		
		
		
		
		
		
		
	}
}
