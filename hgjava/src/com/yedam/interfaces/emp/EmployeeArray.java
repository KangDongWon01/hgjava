package com.yedam.interfaces.emp;

import java.util.Scanner;

import com.yedam.classes.singleton.Employee;

// 배열[]
public class EmployeeArray implements EmployeeList {
	//싱글톤 패턴
	private static EmployeeArray instance = new EmployeeArray();
	Employee[] list;
	int empNum;
	Scanner scn = new Scanner(System.in);
	
	
	private EmployeeArray() {
		
	}
	public static EmployeeArray getInstance() {
		return instance;
	}
	
	
	@Override
	public void init() {
		System.out.println("사원수 >> ");
		int num = scn.nextInt();
		list = new Employee[num];
	}

	@Override
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

	@Override
	public String search(int empId) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				if (list[i].getEmployeeId() == empId) {// ★★★★★★
					list[i].getName(); // ★★★★★★
				}
			}
		}
		return "";
	}
	@Override
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

	@Override
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
