package com.yedam.classes;
//======================이하 필드 영역======================================
//친구 : 이름, 연락처, 나이 : 관리. 
public class Friend {
	private String fname;
	private String ftel;
	private int fage;
// 하나의 클래스이자, 객체이며, 데이터의 타입으로 볼 수도 있다.
//======================이하 생성자 영역=====================================
	public Friend() {
	//기본 생성자
	}
	
	public Friend(String name, String tel, int age) {
		this(name,tel);
		this.age = fage;
		
	}
	
//======================이하 메서드 영역===================================
	void showInfo() { //친구 목록 불러올때 쓸 메서드
		System.out.printf("이름은 %s, 연락처는 %s, 나이는 %d 입니다.\n",
		this.fname,this.ftel, this.fage);
	}
//======================getter / setter 정리==============================
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtel() {
		return ftel;
	}

	public void setFtel(String ftel) {
		this.ftel = ftel;
	}

	public int getFage() {
		return fage;
	}

	public void setFage(int fage) {
		this.fage = fage;
	}
	
	
	
	
}
