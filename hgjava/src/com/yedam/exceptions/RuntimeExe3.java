package com.yedam.exceptions;

import java.util.Scanner;

public class RuntimeExe3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (true) {
			int menu = 0;
			//
			while (true) {
				System.out.println("1.실행 2.종료");
				try {
					menu = Integer.parseInt(scn.nextLine());//여기서 읽은값이 문제없으면. try
					break; // 브레이크로 이 while문을 탈출.
				} catch (NumberFormatException ne) {// parseInt에서 읽은값이 문제있으면 여기로.
					System.out.println("메뉴에 해당하는 번호만 입력하세요.");
					//띄우고 다시 while 반복문으로 돌아감.
				}
			}

			if (menu == 1) {
				System.out.println("실행합니다.");
			} else if (menu == 2) {
				System.out.println("종료합니다.");
				break;
			}

		}

	}
}
