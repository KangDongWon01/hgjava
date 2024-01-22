package com.yedam.classes;

// 학생의 정보를 관리하는 기능 구현.
public class StudentApp {
	//================================================
	// 속성(필드).학생의 정보를 담아놓는 공간. 구조하는 공간.
	static Student[] students; // 초기값 : null.
	
	
	//================================================
	//생성자.
	public StudentApp() {
		students = new Student[10]; // 배열 길이를 10으로 재선언.
	}
	
	
	//================================================
	//메소드. 여기에 기본적인 CRUD 기능을 다 넣는다.
	//1. 등록
	public static boolean add(Student std) {
		for(int i=0; i<students.length; i ++) {
			if(students[i] == null) {
				students[i] = std;
				return true;
			}
		}
		return false;
	}
	//2. 목록 출력
	public Student[] list() {
		return students;
	}
	//3. 정보 수정.동명이인의 경우를 생각하여 (학생번호 - 점수)
	public boolean modify(String sno, int score) {
		for(int i=0; i<students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i].setScore(score);
				return true;
			}
		}
		return false;
	}
	//4. 정보 삭제 (학생번호)
	public boolean remove(String sno) {
		for(int i=0; i<students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	//5. 단건 조회(학생정보)
	public Student get(String sno) {
		for(int i=0; i<students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				return students[i];
			}
		}
		return null;
	}
}
