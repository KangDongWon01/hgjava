package com.yedam.classes.abstracts;

//추상클래스.
public abstract class Animal {
	private String name;
	
	public Animal() {
		
	}
	public Animal(String name) {
		this.name = name;
	}
	
	public void eat() { // 실행 메소드, 구현 부분이있다.
		System.out.println("[Animal] 음식을 먹습니다.");
	}
	
	// 추상 메소드, 선언만 하고 구현 부분이 없다. 자식 클래스에서 반드시 overriding(재정의)해야함
	public abstract void sleep();
	
	
}
