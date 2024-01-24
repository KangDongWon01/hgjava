package com.yedam.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExe {
	public static void main(String[] args) {
		final int num = 10;
		Calendar cal = Calendar.getInstance();
		drawCalendar(2024,4);
		System.out.println();
		Date date = new Date();//자바 유틸에서 가져온것. 1900년.
//		System.out.println(date.getYear()+1900);
//		date.setYear(123);
//		date.setMonth
//		System.out.println(date.getDate());
// 		위 클래스들은 유틸에서 제공하던 구식 클래스들이며 곧 사라진다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		date = sdf.parse("2024-01-01"); // String -> Date.
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 위 SimpleDateFormat이 신형이다.
		
//		System.out.println(Calendar.YEAR);
//		cal.set(2024, 1, 1);
//		System.out.println("year: "+ cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("last Date: "+ cal.getActualMaximum(Calendar.DATE));
//		
	}
	
	static void drawCalendar(Date date) {
		
	}
	
	static void drawCalendar(int year, int month) {
		//(2024, 1) 월은 0부터 시작 ~ 11에 끝
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		
		int pos = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		
		//요일 출력.
		System.out.println(" SUN MON TUE WHE THR FRI SAT");
		
		System.out.println();
		//1일의 요일 지정.
		for(int i=0; i<pos; i++) {
			System.out.printf("%4s", " "); 
		}
		// 날짜출력.
		for(int d=1; d<=lastDate; d++) {
			System.out.printf("%4d", d);
			if(d % 7 == (7-pos)) { //수정
				System.out.println();
			}
		}
		
	}
}
