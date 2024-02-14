package co.kdw;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DiaryApp {
	public static void main(String[] args) {
		//스위치문으로 실행하는 메인 클래스.
		//필드
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
//				Login(); //로그인 기능 구현.
				System.out.println("ID를 입력하세요.>> ");
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
		
		//메인메소드 시작
		while(run) {
			System.out.println("1.메인으로 2.무사히 3.넘어왔음");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:
//				login();
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
