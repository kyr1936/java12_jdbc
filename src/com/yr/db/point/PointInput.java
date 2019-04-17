package com.yr.db.point;

import java.util.Scanner;

public class PointInput {

	public PointDTO setPoint() {
		Scanner sc = new Scanner(System.in);
		
		PointDTO dto = new PointDTO();
		
		System.out.println("번호 입력");
		dto.setNum(sc.nextInt());
		System.out.println("학생 id 입력");
		dto.setsId(sc.next());
		System.out.println("국어점수 입력");
		dto.setKor(sc.nextInt());
		System.out.println("영어점수 입력");
		dto.setEng(sc.nextInt());
		System.out.println("수학점수 입력");
		dto.setMath(sc.nextInt());
		System.out.println("반 번호 입력");
		dto.setBnum(sc.nextInt());

		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAvg(dto.getTotal()/3.0);
		
		return dto;
	}
	
	public void s() {
		
	}
	
}
