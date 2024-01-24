package com.yedam.interfaces.emp;

import java.util.ArrayList;

public class ArrayListExe {
	public static void main(String[] args) {
		
	//배열
	//배열에 객체 생성, 인덱스 번호 지정해서 추가.
//	int[], String[]
	Employee[] employeeAry = new Employee[10];
	employeeAry[0] = new Employee(101,"홍길동");
	employeeAry[1] = new Employee(102,"김민석");
	Employee emp = new Employee(103,"황인만");
	employeeAry[2] = emp;
	employeeAry[2] = null; //삭제.

	for(int i =0; i < employeeAry.length; i++) {
		if(employeeAry[i] != null) {
			System.out.println(employeeAry[i].getName());
		}
	}
	
	
	
	//컬렉션. 자바 유틸이라는 패키지에 있는 클래스다. 클래스로서 다루는 배열이라고 생각하자.
	//초기값으로 10개 생김. 이상이 생기면 확장.
	//메소드로 배열에 추가 및 삭제, 자동으로 다음 위치에 추가.
	//중간 인덱스를 지우면 자동으로 당겨진다.
	ArrayList<Employee> employeeAryList = new ArrayList<Employee>();
	employeeAryList.add(new Employee(104,"최홍길"));
	employeeAryList.add(new Employee(105,"이만기"));
	employeeAryList.add(emp);
	employeeAryList.remove(2); // 삭제.
	
	for(int i =0; i < employeeAryList.size(); i++) {
		System.out.println(employeeAryList.get(i).getName());
	}
	
	}
}