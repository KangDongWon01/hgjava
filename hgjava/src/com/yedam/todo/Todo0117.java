package com.yedam.todo;

import java.util.Scanner;

public class Todo0117 {
	public static void main(String[] args) {
		//친구 3명의 이름과 연락처를 입력하도록.. 메세지 출력.
		//입력완료.
		
		// 이름 : 홍길동
		// 연락처 : 010 - 1111 - 2222
		// ========================
		// 이름 : 김길동
		// 연락처 : 010 - 2222 - 3333
		// ========================
		// 이름 : 박길동
		// 연락처 : 010 - 3333 - 4444
		// ========================
		
		String name[] = new String[3];
		String tel[] = new String[3];
		
		Scanner scn = new Scanner(System.in);
		for(int i=0; i < 3; i++) {
			System.out.println("이름 입력");
			name[i] = scn.next();
			System.out.println("연락처 입력");
			tel[i] = scn.next();
		}
		for(int i=0; i < 3; i++) {
			System.out.println("이름: " + name[i]);
			System.out.println("연락처: " + tel[i]);
			System.out.println("=================");
		}
	}
}
