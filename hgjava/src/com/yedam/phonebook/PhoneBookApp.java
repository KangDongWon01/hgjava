package com.yedam.phonebook;

//연락처 관리 앱
public class PhoneBookApp {
	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.getInstance();
		//사용자권한 체크.
		// userManager => userCheck(아이디, 비번)
		// 3번 연속으로 인증이 실패할 경우 프로그램 종료.
		
//		Thread mediaThread = new MediaThread();
		
		int menu = 1;
		while (true) {
			try {
				//Audio 스트림 실행
				
				MenuViewer.showMenu();
				menu = MenuViewer.Keyboard.nextInt();
				//엔터 
				MenuViewer.Keyboard.nextLine();
				if(menu < InitMenu.INPUT || menu > InitMenu.EXIT) {
					throw new MenuChoiceException(menu);
					// 사용자가 잘못된 값을 입력하면, 순환하면서 계속 객체가 생성된다.
					// 어딘가 좀 비효율적인 느낌이 있다고 함.
				}
				
				if(menu == InitMenu.INPUT) {
					manager.inputData();
					System.out.println("입력");
				} else if (menu == InitMenu.SEARCH) {
					manager.searchData();
					System.out.println("검색");
				} else if (menu == InitMenu.DELETE) {
					System.out.println("삭제");
					manager.deleteData();
				} else if (menu == InitMenu.EXIT) {
					System.out.println("종료");
					manager.storeToFile();
					break;
				}
			} catch(MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
		System.out.println("end of program.");
	}
}
