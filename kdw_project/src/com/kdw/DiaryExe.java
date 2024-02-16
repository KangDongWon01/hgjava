package com.kdw;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DiaryExe {
	public static void main(String[] args) {
		//스위치문으로 실행하는 메인 클래스.
		//필드
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		DiaryMethods dm = new DiaryMethods();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		boolean run2 = true;
		//회원 체크
		while(run) {
			System.out.println("=======================");
			System.out.println("||    일기장  프로그램    ||");
			System.out.println("=======================");
			System.out.println("       회원이신가요?");
			System.out.println("=======================");
			System.out.println("1.예    2.아니오   3.종료");
			int checkUser = scn.nextInt();
			scn.nextLine();
			switch (checkUser) {
			case 1:
//				Login(); //로그인 기능 구현.
				System.out.println("=======================");
				System.out.println("||일기장 프로그램 로그인 화면||");
				System.out.println("=======================");

				System.out.println("    ID를 입력하세요.>> ");
				String du_id = scn.nextLine();
				System.out.println("    PW를 입력하세요.>> ");
				String du_pw = scn.nextLine();
				
				if(dm.Login(du_id, du_pw)) {
					System.out.println("=======================");
					System.out.println("||    ♬♪로그인 성공♬♪    ||");
					System.out.println("=======================");
					run = false;
				} else {
					System.out.println("!!!!!!!!로그인 실패!!!!!!!!");
					System.out.println("    초기 화면으로 돌아갑니다.");

				}
				break;
			case 2:
//				Registeruser(); //회원가입 기능 구현.
				System.out.println("========================");
				System.out.println("||일기장 프로그램 회원가입 화면||");
				System.out.println("========================");
				System.out.println("    회원가입을 시작합니다.");
				
				break;
			case 3:
				System.out.println("     종료합니다.");
				run = false;
			}	
		}
		
		//메인메소드 시작
		while(run2) {
			System.out.println("=======================");
			System.out.println("1.일기 작성 2.목록조회 및 관리");
			System.out.println("  3.나만의 카테고리 만들기");
			System.out.println("=======================");
			Connection conn = DiaryDAO.getConn();

			int menu = Integer.parseInt(scn.nextLine());
			scn.nextLine();
			
			switch (menu) {
			case 1: //일기 작성
				System.out.println("=========================");
				System.out.println("||    ♩일기를 작성합니다.    ||");
				System.out.println("||   날짜는 자동저장됩니다.   ||");
				System.out.println("=========================");
				//이 기능을 통해 생성하는 DiaryObject 객체에게, 속성을 부여하기.
				// 제목 부여.
				System.out.println("제목 작성 >> ");
				String title = scn.nextLine();
				scn.nextLine();
				// 내용 부여.
				System.out.println("내용 작성 >> ");
				String cont = scn.nextLine();
				scn.nextLine();
				// 작성일자 부여.
				Date regDate = new Date();
				// 수정일자는 이 시점에 쓸 내용이 아니므로 null처리.
				Date updateDate = null;
				
				DiaryObject doj = new DiaryObject(title, cont);
				
				DiaryMethods dm2 = new DiaryMethods();
				
				if(dm2.insertDiary(title, cont)) {
					
				}
				break;
			
			case 2:
				System.out.println("회원 가입을 시작합니다.");
//				registuser();
				break;
				
			case 3:
				System.out.println("종료합니다.");
				run = false;
			}	
			//switch 문 종료.
		}
		//while 문 종료.
		
	}
}
