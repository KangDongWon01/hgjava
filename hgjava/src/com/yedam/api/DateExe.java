package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(today));
		
		try {
			sdf.parse("2020/01/05 12:12:12"); // String 타입의 문자열을 Date 타입으로 바꿔주었음.
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
		
		Date now = new Date();
		
		System.out.println(today.after(now));
		
		// 구시대
		System.out.println("아래는 구시대적 방법-비권장");
		System.out.println(today.toLocaleString());
		
		
		// LocalDate, LocalTime, LocalDateTime --> 신형 Date 관련 클래스.
		LocalDate ld = LocalDate.now();
		System.out.println(ld.toString());
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt.toString());
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.toString());
		
		String result = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(result);
		
	}
	
}
