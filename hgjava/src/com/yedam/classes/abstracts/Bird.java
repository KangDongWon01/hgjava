package com.yedam.classes.abstracts;

public class Bird extends Animal {
//추상 클래스로부터 상속받은 추상 메소드가 있음에도 구현을 하지 않으면 컴파일 에러가 난다.
	public Bird(String name) {
		super(name);
	}
	@Override
	public void sleep() {
		System.out.println("[Bird] 나뭇가지에 서서 잡니다.");
	}
	
	
	
	
}
