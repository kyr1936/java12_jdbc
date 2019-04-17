package com.yr.db.point;



public class PointInsert {

	
	public static void main(String[] args) {
		// id, 국어, 영어, 수학 입력 합/평균 계산
		// point table에 insert
		
		try {
			new PointControlloer().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
