package com.yedam;

public class IFCondition {
	public static void main(String[] args) {
		boolean isTrue = true;
		isTrue = isTrue != true;
		
		if(!!isTrue) { // isTrue 앞의 ! 유무에 따라 결과가 달라진다.
			//실행구문
			System.out.println("참값입니다.");
		} else {
			System.out.println("거짓값입니다.");
		}
		
		int score = 95;
		if(score >= 90); {
			System.out.println("A학점");
		} if(score >= 80) {
			System.out.println("B학점");
		} else {
			System.out.println("C학점");
		}
		
		
		
		System.out.println("end of prog.");
	}
}
