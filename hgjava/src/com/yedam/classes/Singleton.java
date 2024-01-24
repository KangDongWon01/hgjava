package com.yedam.classes;

//전체 프로그램에서 인스턴스를 하나만 생성하겠다(메모리 절약의 목적)
public class Singleton {
	// 싱글톤 클래스 생성 방법.
	// 1. 생성자를 private로 선언한다.	
	private Singleton() {
		
	}
	// 2. 싱글톤이라는 클래스의 타입으로 필드를 선언한다.
	private static Singleton instance = new Singleton();
	
	//인스턴스를 반환할 수 있도록 메소드 작성. 보통 getInstance() 관례적으로 짓는다.
	
	public static Singleton getInstance() {
		return instance;
	}
	
	
}
