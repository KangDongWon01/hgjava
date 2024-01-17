package com.yedam;

public class ArrayExe {
	public static void main(String[] args) {
		
		// int intAry -> 이름만 intAry이지, 괄호가 없기에 배열이 아닌 하나의 변수가 됨.
		int[] intAry = { 10, 20, 30 }; 
		intAry[2] = 40;
		// Java에서는, 처음 선언한 배열의 크기를 변경할 수 없다. 바꾸려면, 재선언해야한다.
		intAry = new int[] { 10, 20, 30, 40, 50 };
		intAry = new int[10]; // <- 10개짜리 공간을 만들겠다. 그러면 {} 안에는 0이 10개가 들어 있는 형태가 된다.
		
		System.out.println(intAry[0] + ", 크기:" + intAry.length);
		intAry[0] = 100;
		
		for(int i = 0; i < 10; i++) {
			intAry[i] = (int)(Math.random()*10);
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(intAry[i]);
		}
		
		// 2와 3의 배수의 값을 각각 int sum2, sum3에저장.
		int sum2, sum3;
		sum2 = sum3 = 0;
		for(int i = 0; i < 10; i++) {
			if(intAry[i] % 2 == 0 && intAry[i] % 3 ==0) {
			sum2 += intAry[i];
			sum3 += intAry[i];
			}else if(intAry[i] % 2 == 0) {
				sum2 += intAry[i];
			}else if(intAry[i]%3 ==0) {
				sum3 += intAry[i];
			}else {
				continue;
			}
			System.out.printf("2의 배수합 : %d, 3의 배수합 : %d", sum2, sum3);
		}
		
		String[] strAry = { "Kang", "Choi", "Jeon", "3강의실"};
		for(int i = 0; i < strAry.length; i++) {
			System.out.println(strAry[i]);
		}
	}
}
