package com.yedam.classes.nested;


class Parent{
	String name;
	
	void showName() {
		System.out.println("이름은 " + name);
	}
}

interface Runnable{
	void run(); //함수형 인터페이스 => (구현해야할 메소드가 하나만 존재.)
}

public class AnonymousExe {
	public static void main(String[] args) {
		//익명구현객체
		Runnable runnable = () -> System.out.println("나는 달립니다.");
		runnable.run();
		runnable = () -> System.out.println("너는 달립니다.");
		runnable.run();
		//자바스크립트의 화살표 함수와 느낌이 비슷하다.
		
		
		Parent parent = new Parent() {
			int age;
			
			void showInfo(String name, int age) {
				this.name = name;
				this.age = age;
				System.out.println("이름은 " + name + ", 나이는 " + age);
			}
			@Override
			void showName() {
				System.out.println("이름은 " + name + "입니다.");
				showInfo("홍길동", 20);
			}
			
			
		};
		parent.showName();
				
	}
}
