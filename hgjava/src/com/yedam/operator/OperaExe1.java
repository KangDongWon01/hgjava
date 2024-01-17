package com.yedam.operator;

import java.util.Scanner;

public class OperaExe1 {

	public static void main(String[] args) {
		int result = 0;
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("정수값을 쓰시오. 끝내고 싶으면 quit을 치시오.>>>");
			String input = scn.nextLine(); // 넥스트라인의 의미를 다시 알아보자.
			if(input.equals("quit")) {
				break;
			}
			// 사용자에게 값을 입력할 수 있도록 : 정수입력.
			try {
			result += Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("잘못 적었음.");
			}
		}
		// 누적값은 15입니다.
		System.out.printf("누적값 : %d \n", result); //printf => 받는값이 
		System.out.println("end of prog."); 
		// 코드 흐름상, 만약 이 라인에 진입할 일이 없다 -> called 데드코드
		
	}

	public static void method1() {
		int sum = (1 + 2) * 3; //연산 순서. ()로 감싸면 먼저 처리함
		sum = sum + 5;
		sum += 5;
		String str = "";
		Scanner scn = new Scanner(System.in);
		while(true ) {
			System.out.println("문자열 입력하시오>>>");
			String input = scn.nextLine();
			if(input.equals("quit")) {
				break;
			}
			str += input + " ";
		}
		System.out.printf("누적내용 : %s\n", str);
	}
}