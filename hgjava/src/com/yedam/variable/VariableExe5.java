package com.yedam.variable;

public class VariableExe5 {
	public static void main(String[] args) {
		//char -> 문자 갯수 65546개를 전부 코드값으로 만들어 놓은 것.
		// 구글에서 유니코드 문자표를 검색하면 나옴.
		for(int i=0; i < 10; i++) {
		int temp = (int)(Math.random()*25) + 97;
		System.out.println((char)temp);
		
		
		double d1 = 10.0; // = 10.0d; 10.0더블;
		double result = d1 + (double) 20.0f;
		
		int sum = 60;
		result = sum / 7; //
		System.out.println(result);
		
		sum = Integer.parseInt("1") + 3 + 5; // 원하는 결과는 1 + 3 + 5인데,
		// 1이 문자열이라 나머지들이 걍 붙어서 135가 되어버린다
		// 이를 원하는대로 하기 위해 인티저라는 내장 클래스의 파스인트 라는 메소드를 사용,
		// "1"이라는 문자열을 int 타입으로 바꿔 더해준다.
		
		
		
		
		
	}
	}
}
