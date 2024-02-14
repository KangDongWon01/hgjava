package com.kdw;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.kdw.DiaryDAO;

public class DiaryExe {
	public static void main(String[] args) {
		
		//로그인 메소드 호출
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		DiaryDAO ddao = new DiaryDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		//회원 체크
		while(run) {
			System.out.println("<< 일기장 프로그램 >>");
			System.out.println("회원이신가요?");
			System.out.println("1.예 2.아니오 3.종료");
			int checkUser = scn.nextInt();
			switch (checkUser) {
			case 1:
				Login(); //로그인 기능 구현.

				break;
			case 2:
//				Registeruser(); //회원가입 기능 구현.
				System.out.println("회원가입을 시작합니다.");

				break;
			case 3:
				System.out.println("종료합니다.");
				run = false;
			}	
		}
		
		//회원가입 메소드 호출
		
		//메뉴 메소드 작성
		
	}
}
