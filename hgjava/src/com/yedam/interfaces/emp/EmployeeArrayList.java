package com.yedam.interfaces.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션 : ArrayList<Employee> 배열과 달리 크기가 가변적임. 
public class EmployeeArrayList implements EmployeeList {
	
	private static EmployeeArrayList instance = new EmployeeArrayList();
	ArrayList<Employee> list;
	Scanner scn = new Scanner(System.in);
	private EmployeeArrayList() {}
	public static EmployeeArrayList getInstance() {
		return instance;
	}
	
	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {
		System.out.printf("%d 사번 >>", list.size());
		int no = scn.nextInt();

		System.out.println("이름 >>");
		String name = scn.next(); // next든, nextLine이든 입력된 String을 가져온다.

		System.out.println("급여 >>");
		int sal = scn.nextInt();
		
		list.add(new Employee(no,name,sal));
	}
		
	@Override
	public String search(int empId) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getEmployeeId() == empId) {
				return list.get(i).getName();
			}
		}
		return null;
	}

	@Override
	public void print() {
		for (int i = 0; i < list.size(); i++) {
				System.out.printf("%4d \t %10s \t %7d\n",// 
						list.get(i).getEmployeeId(), list.get(i).getName(),
						list.get(i).getSalary());
			}
		}

	@Override
	public int sum() {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				result += list.get(i).getSalary();
			}
		}
		return result;

}
