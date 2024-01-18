package com.yedam.reference;

public class ArrayExe1 {
	public static void main(String[] args) {
		//선언.
		int[] intAry = { 10, 20, 30 }; // <- 정수타입을 모아놓는다.는 의미, 단순히 int랑 다르다.
		// 이 안에 있는 요소 하나의 값 타입은 int가 맞다.
		
		//intAry[] != int
		//intAry[0] === int
		int[][] intArray = { {10,20}, {30,40}, {50} }; //자주 쓰는 형태는 아니나, 반드시 존재한다.
		// intArray[0] !== int
		// intArray[0] === int[], intArray[0][0] === int
		
		String[] strAry = new String[5]; // 크기만 선언
		strAry = new String[] {"Hello", "World", "Nice"};		
		
		for(String elem : strAry) {
			System.out.println(elem);
		}
	
	
	
	
	}
	
}
