package com.yedam.interfaces.emp;

import java.util.Scanner;

import com.yedam.classes.singleton.EmployeeList;

public class EmployeeListApp {
	public static void main(String[] args) {
		EmployeeList app = EmployeeList.getInstance();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;

		while (run) {
			System.out.println("1.사원수 2.사원입력 3.사원리스트 4.검색 5.급여합계 9.종료");
			System.out.println("선택 >>");
			menu = scn.nextInt();

			if (menu == 1) {
				app.init();
			} else if (menu == 2) {
				app.input();
			} else if (menu == 3) {
				app.print();
			} else if (menu == 4) {
				System.out.println("조회할 사번 >>");
				int no = scn.nextInt();
				if (app.search(no).equals("")) {
					System.out.println("해당 사번은 없습니다.");
				} else {
					System.out.printf("해당 사원의 이름은 %s 입니다.", app.search(no));
				}
			} else if (menu == 5) {
				app.sum();
				System.out.printf("급여합계는 %d 입니다.\n", app.sum());
			} else if (menu == 9) {
				System.out.println("종료합니다.");
				run = false;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		System.out.println("end of program.");
	}
}
