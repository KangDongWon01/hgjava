package com.yedam.classes;

public class SingletonExe {
	public static void main(String[] args) {
		// Singleton s1 = new Singleton();
		// 위 코드는 실행불가. 싱글톤은 new생성자로 못 부르고,
		// getInstance() 메소드를 통하여 호출
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
