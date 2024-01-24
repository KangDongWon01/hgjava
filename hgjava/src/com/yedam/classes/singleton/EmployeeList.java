package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeList {
	// 싱글톤 방식으로 인스턴스를 제공하겠음.
	private static EmployeeList instance = new EmployeeList();

	Employee[] list; // 사원을 담아놓기 위한 배열.
	int empNum; // 현재의 사원수.
	Scanner scn = new Scanner(System.in);

	private EmployeeList() {
	}

	public static EmployeeList getInstance() {
		return instance;
	}

	// 사원수를 입력받도록 하기 위한(사원수를 초기화하기 위한) 기능.
	public void init() {
		System.out.println("사원수 >> ");
		int num = scn.nextInt();
		list = new Employee[num];
	}

	// 사원정보를 입력하면 배열에 추가하는 기능.
	public void input() {
		if (empNum == list.length) {
			System.out.println("입력 초과");
			return; // 메소드의 종료를 의미하는 키워드.
		}
		System.out.printf("%d 사번 >>", empNum);
		int no = scn.nextInt();

		System.out.println("이름 >>");
		String name = scn.next(); // next든, nextLine이든 입력된 String을 가져온다.

		System.out.println("급여 >>");
		int sal = scn.nextInt();

		list[empNum++] = new Employee(no, name, sal);
	}

	// 사번을 입력하면 해당하는 이름 출력.
	public String search(int empId) {
		// 해당 사번이 있으면 이름 반환. 없으면 공백 반환.
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				if (list[i].getEmployeeId() == empId) {// ★★★★★★
					list[i].getName(); // ★★★★★★
				}
			}
		}
		return "";
	}

	public void print() {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.print("사번 \t 이름 \t 급여\n");
				System.out.printf("%4d \t %10s \t %7d\n", list[i].getEmployeeId(), list[i].getName(),
						list[i].getSalary());
			}
		}
		return;
		// 사원번호, 이름, 급여 출력.
	}

	public int sum() {
		int result = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				result += list[i].getSalary();
			}
		}
		return result; //cntl + shift + f 누르면 {}등 모양 정리해줌
	}
}
