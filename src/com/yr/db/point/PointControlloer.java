package com.yr.db.point;

import java.util.Scanner;

public class PointControlloer {
	private Scanner sc;
	private PointInput pi;
	private PointDAO pa;
	private PointView pv;
	public PointControlloer() {
		sc = new Scanner(System.in);
		pi = new PointInput();
		pa = new PointDAO();
		pv = new PointView();
	}
	public void start() throws Exception {
		// 1. 점수 정보 등록
		// 2. 종  료
		boolean check = true;
		
		while(check) {
			System.out.println("1. 점수 정보 등록");
			System.out.println("2. 종   료");
			int select = sc.nextInt();

			switch(select) {
			case 1: 
				PointDTO dto = pi.setPoint();
				int result = pa.insert(dto);
				
				String message = "등록 실패";
				
				if(result>0) {
					message = "등록 성공";
				}
				pv.view(message);
				break;
			case 2:
				check =!check;
				System.out.println("종료합니다");
			}

		}	







	}
}
