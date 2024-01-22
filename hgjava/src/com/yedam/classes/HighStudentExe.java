package com.yedam.classes;

public class HighStudentExe {
	public static void main(String[] args) {
		HighStudent hiStd = new HighStudent("T001","홍길동",90,"김쌤");
		
		System.out.println(hiStd.getSno());
//		System.out.println(hiStd.getTeacher());
		hiStd.showInfo(); // 부모클래스의 멤버.
		
		//부모클래스의 참조변수에 자식클래스의 인스턴스를 대입.
		Student std = new HighStudent("T002","박길동",80,"김쌤");
		System.out.println(std.getTeacher());
		
		long ln1 = (int)10; // 큰 범위의 변수 = 작은 범위값.
		
		Student[] = Students = 10;
		
	}
}
