package com.yedam.classes;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		//메뉴 : 1.등록 2.목록 3.수정 4.삭제 9.종료.
		Scanner scn = new Scanner(System.in);
		//사용자의 입력 / 처리결과 콘솔출력.
		FriendApp app = new FriendApp();
		UserApp uapp = new UserApp();
		
		
		//로그인 기능(id.pw.name)
		
		while(true) {
			System.out.println("id >>>");
			String id = scn.nextLine();
			
			System.out.println("pw >>>");
			String pw = scn.nextLine();
			
			System.out.println("name >>>");
			String name = scn.nextLine();
			
			if(uapp.login(id, pw)) {
				System.out.println("%s 님, 환영합니다." user.getName());
				break;
			}
			System.out.println("로그인 실패");
		}
		
		boolean run = true;
		while(run) {
		
		}
		
		boolean run = true;
		
		String fname = "";
		String ftel = "";
		int fage = 0;
		
		while(run) {
			System.err.println("1.등록 2.목록 3.수정 4.삭제 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:
				Friend ftd = new Friend(fname, ftel, fage);
				System.out.println("친구이름 >>> ");
				fname = scn.nextLine();
				System.out.println("친구번호 >>> ");
				ftel = scn.nextLine();
				System.out.println("친구나이 >>>");
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 9:
				
			}
		}
		
	}
}
