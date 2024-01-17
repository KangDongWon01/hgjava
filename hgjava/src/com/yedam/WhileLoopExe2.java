package com.yedam;

import java.util.Scanner;

public class WhileLoopExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// 어떤 조건일 동안만 반복할때는 while 반복문을 사용하는것이 합리적이다.
	int random = (int)(Math.random() * 100) + 1; // 0 ~ 1 사이의 정수값을 표현. 여기에 10을 곱해주면, 1 ~ 10 임의의 정수값.
	int cnt = 0;
	while(true) {
		System.out.println("값입력>>");
		int input = scn.nextInt();
		if(random < input) {
			System.out.println("그 수보다는 작습니다.");
			cnt++;
		}
		if(random > input) {
			System.out.println("그 수보다는 큽니다.");
			cnt++;
		}
		if(random == input) {
			System.out.printf("임의의 값은 %d\n 이였습니다.", random);
			System.out.println("정답입니다!");
			cnt++;
			break;
		}
	}
	System.out.printf("%d 번 만에 맞추셨습니다.", cnt);
	System.out.println("end of prog...");
	}
}
