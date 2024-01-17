package com.yedam;

import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		//변수: 월의 1이 위치.
		//변수: 월의 마지막 날짜
		int lastDate = 31;
		int pos = 1;
		Scanner scn = new Scanner(System.in); 
		System.out.println("불러올 달력 : 월을 입력하세요");
		int month = scn.nextInt();
		switch(month) {
			case 1: pos =1; lastDate = 31; break;
			case 2: pos =4; lastDate = 29; break;
			case 3: pos =5; lastDate = 31; break;
			case 4: pos =1; lastDate = 30; break;
			case 5: pos =3; lastDate = 31; break;
			case 6: pos =6; lastDate = 30; break;
			case 7: pos =1; lastDate = 31; break;
			case 8: pos =4; lastDate = 31; break;
			case 9: pos =0; lastDate = 30; break;
			case 10: pos =2; lastDate = 31; break;
			case 11: pos =5; lastDate = 30; break;
			case 12: pos =0; lastDate = 31; break;
		}
		// 수정 : 월이 변경될때마다 마지막날 계산
		
		System.out.println(" SUN MON TUE WHE THR FRI SAT");
//		String[] days = { "SUN", "MON","TUE", "WHE", "THR", "FRI", "SAT" };
//		for(int i = 0; i < days.length; i++) {
//			System.out.print(days[i]);
//		}
		for(int i=0; i<pos; i++) {
			System.out.printf("%4s", " "); 
		}
		for(int d=1; d<=lastDate; d++) {
			System.out.printf("%4d", d);
			if(d % 7 == (7-pos)) { //수정
				System.out.println();
			}
			if(d % 7 == 0) {
				System.out.println();
			}
		}
	}
}