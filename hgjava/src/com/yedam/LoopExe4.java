package com.yedam;

public class LoopExe4 {
	public static void main(String[] args) {
		for(int j=2; j<=10; j++) {
			for(int i=1; i<j; i++) {
			System.out.print("*");
			}
			System.out.println();
		}
	}
		
		
		
		//구구단 출력.
		//반복되는 값이 무엇인지 파악하고, for이나 while 등 맞는 문을 선택함.
		//중첩 반복에 대한 공부.
		public static void method1() {
		for(int j=2; j<=9; j++) {
			//시작.
		int num = j; //단 정보. 2단, 3단  . . . 9단까지.
			System.out.printf("구구단 %d단\n ", j);
			for(int i=1; i<=9; i++) {
			// 3 * 1 = 3
			System.out.printf("%d * %d = %d\n", num, i, (num*i));
			}
		//끝.
		}
	}
}
//=====================================================================
//		public static void method2() {
//		for(int i=1; i<=9; i++) {
//			for(int j=2; j<=9; j++) {
//			System.out.printf("%2d * %2d = %2d\t", j, i, (j*i));
//			}
//			System.out.println();
//		}
//	}
//}