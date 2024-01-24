package com.yedam.classes.abstracts;

public class AnimalExe {
	public static void main(String[] args) {
		
//		Animal animal = new Animal(); 추상 클래스이므로, 인스턴스를 만들 수 없다.
		//자식 클래스의 규칙을 정하기 위해 만든 용도이다.
		
		Animal animal = null;
		animal = new Bird("제비"); //근데 참조변수에 인스턴스 넣어서 뭐 하지?..
		// 참조변수에 인스턴스를 넣음으로서 얻는 효과 - 직접적 연관은 없는 자식 메소드들의 성질을
		// 한데 묶는 역할 등을 할 수 있다.
		animal.eat();
		animal.sleep();
		
		Bird bird = new Bird("참새");
		bird.eat();
		bird.sleep();
		
		Animal[] animals = new Animal[10];
	}
}
