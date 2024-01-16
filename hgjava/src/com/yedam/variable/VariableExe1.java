package com.yedam.variable;

public class VariableExe1 {
	public void sum() {
		int n2;
	}
	public static void main(String[] args) {
		// let n = '10';
		// const obj = {name:"홍길동", age:20, showInfo(){} }
		int n1 = 2147483647; // int(기본데이터타입) wraooer클래스 : Integer.
		n1 = -2147483648;
		System.out.println(Integer.MAX_VALUE);
		// 위 범위보다 큰 범위의 수를 담고 싶다면 long 타입 밝혀주고 숫자 끝에 L 붙임
		long n2 = 2147483648L;
		n2 = -2147483648L;
		
		double n3 = Math.random(); // 0 ~ 1 임의실수.
		
		int n4 = (int)(Math.random()*10); // 0 ~ 10 임의실수. 
		
		String str = "홍길동";
		//앞글자가 대문자면 클래스이다.
		
		// int n2; 두번 선언이 불가.
		byte b1 = 127; //양의 값에서는 0이라는 것도 포함해야 해서, 0이상 128개, 0미만 128개로 범위가 확정된다.
		
		System.out.println(Short.MAX_VALUE);
		short s1 = 32767;
		
		short s3 = s1 - 30; //감당되는 범위임에도 왜 빨간줄(에러)가 뜨는가?
		//연산의 기준 (-)이 int타입인데, short와 int의 타입이 다르기 때문에 연산이 안되는것이다.
		short s4 = (short) (s1 - 30); //왼쪽항 = 오른쪽항 : 항상 타입이 동일해야 연산됨.
		double d1 = 40; //오류가 없는 이유 : 
		
		
		
		
		
		
		
		
	}
}
