package com.yedam.classes.nested;

public class Outer {
	String field1;
	
	class NestClass{ //중첩 클래스.
		String field2;
		
		void method2() {
			System.out.println("method2()");
		}
	}
	
	// 정적 멤버 클래스.
	static class StaticClass{
		static String field3;
		static void method3() {
			System.out.println("method3()");
		}
	}
	
	
	
	void method1() {
		NestClass nest = new NestClass(); // 인스턴스 생성.
		nest.field2 = "method1에서, NestClass의 필드 field2에 이 문자열을 저장";
		System.out.println(nest.field2);
		nest.method2();
	}
	
}

