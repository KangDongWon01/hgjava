package com.yedam;

public class ForLoopExe1 {
	public static void main(String[] args) {
		//
		for(int i=1; i<=10; i+=2) {
			System.out.println(i); // i는 반복문 안에서만 정의되며 의미를 갖는다.
			if (i > 5) {
				break;
			}
		}
	
//		System.out.println(i); // for 문 밖에서 sysout을 하면 오류남.
	
		// 1 ~ 10까지의 합을 게산.
		int sum = 0;
		for(int n=1; n<=10; n++) {
			if(n % 3 == 0)
			sum += n;
		}
		System.out.printf("누적된 값은 %d\n", sum);
		
		// 1 ~ 31까지 반복. 반복 횟수가 정해져 있으므로 for문을 쓰는게 합리적이다.
		System.out.printf("%3s", ""); //%3s 이런거 못알아먹겠네. 책에 표시해놔야겠다.
		for(int d = 1; d <= 31; d++) {
			System.out.printf("%3d", d);
			if(d % 7 == 6) {
				System.out.println();
			}
		}
		
		
	}
}
