package com.yedam.exceptions;

public class RuntimeExe {
	public static void main(String[] args) {
		
		//일반 예외
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//실행 예외
		String str = "ten"; //문자열 10을넣든, ten을 넣든 컴파일러가 빨간줄(일반예외)를 띄우지 않음
		try {
			int num = Integer.parseInt(str);
			System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변경 불가한 문자열.");
		}
		System.out.println("end of program.");
		
		
		//nillpointerExeception
//		String str1 = null;
//		System.out.println(str1.toString());
		
		String str2 = null;
		try {
		System.out.println(str2.toString());
		} catch (NullPointerException e) {
			System.out.println("참조하는 값이 없음.");
			str2 = "10";
		}
		System.out.println(str2.toString());
		
	}
}
