package com.yedam.variable;

import java.util.Scanner;

public class VariableExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("이름 입력>>>");
		String result1 = scn.nextLine(); // 입력값을 문자열로 반환
		System.out.println("당신의 이름은 " + result1 + "입니다");
		
		System.out.println("연락처 입력>>>");
		String result2 = scn.nextLine();
		System.out.println("당신의 연락처는 " + result2 + "입니다");
		
		System.out.println("나이 입력>>>");
		int result3 = scn.nextInt();
		System.out.println("당신의 나이는 " + result3 + "입니다");
		
		System.out.println("영어 점수 입력>>>");
		int eng = scn.nextInt();
		System.out.println("수학 점수 입력>>>");
		int mat = scn.nextInt();
		
		System.out.println("당신의 영어 점수는 " + (int)(eng) + "점 입니다");
		System.out.println("당신의 수학 점수는 " + (int)(mat) + "점 입니다");
		System.out.println("당신의 총 점수는 " + (int)(eng + mat) + "점 입니다");
		
		
	}
}
