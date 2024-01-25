package com.yedam.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		List<Employee> storage = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

		
		while(run) {
			System.out.println("1.등록 2.조회(입사일자) 9.종료");
			int menu = scn.nextInt(); scn.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			
			switch (menu) {
			case 1 :
				System.out.println("\"사원번호 이름 입사연월일 급여\" 순으로 작성.");
				String var = scn.nextLine();
				String[] valAry = var.split(" ");
//				System.out.println(valAry.toString());
				try {
					storage.add(new Employee(Integer.parseInt(valAry[0]), valAry[1], sdf.parse(valAry[2]), Integer.parseInt(valAry[3])));
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				catch (ParseException e) {
					e.printStackTrace();
				}		
				System.out.println("등록 완료.");
				break;
			case 2 : 
				System.out.println("조회할 사원의 입사연월일을 yy-MM-dd 로 입력.");
				try {
				Date hireDate = sdf.parse(scn.nextLine());
				} catch (Exception e) {
					System.out.println("날짜 입력 양식 오류. 재입력.");
				}
				for(int i = 0; i < storage.size(); i++) {
					
				}
				break;
			case 9 :
				System.out.println("종료.");
				run = false;
			}
			
		}
		
		System.out.println("end of program");
	}
	
	static void method() { //참고용
		// "101 홍길동 23-05-08 100"
		String val = "101 홍길동 23-05-08 100";
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		String[] valAry = val.split("_");
		
		// ★★★★★★★★★★★꿀기능인것같다.★★★★★★★★★★★★★
		for(String value : valAry) {
			System.out.println(value);
		}
		try {
			new Employee(Integer.parseInt(valAry[0]), valAry[1], sdf.parse(valAry[2]), Integer.parseInt(valAry[3]));
		}
		catch (NumberFormatException e) {
		}
		catch (ParseException e) {
			e.printStackTrace();
		}		
	}
}
