package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		
		
		
	}
	public static void method1() {
		int[] scores = new int[10];
		// 이 순간까지는, 10개의 공간에 0이라는 값이 각각 담겨 있다.
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		System.out.println(scores[4]);
		System.out.println(scores[5]);
		System.out.println(scores[6]);
		System.out.println(scores[7]);
		// 전부 0으로 나오는 상황
		scores = new int[5]; // 배열은 이렇게 따로 재선언해주어야 길이가 변경이 된다.
		scores[0] = 78;
		scores[1] = 82;
		scores[2] = 97;
		scores[3] = 90;
		scores[4] = 95;
		//예를 들어, scores = new int[5]; 에서 [7]번 인덱스를 읽으라 하면 오류가 발생한다.
		
		//80점 이상인 학생은 3명입니다. 라는 구문 출력
		//90점 초과인 학생은 없습니다. 라는 구문 출력
		int cnt = 0;
		int cnt2 = 0;
		for(int i=0; i<scores.length; i++) {
//			System.out.println("scores[" + i + "]=> " + scores[i]);
			if(scores[i] > 90) {
				cnt2++;
			}
			if(scores[i] >= 80) {
				System.out.println("인덱스 : " + i);
				cnt++;
//				continue;
			
			}
		}
		System.out.printf("80점 이상인 학생은 %d 명 입니다.", cnt);
		System.out.println();
		System.out.printf("90점을 초과한 학생은 %d 명 입니다.", cnt2);
		System.out.println("\n end of prog.");
		}
	public static void method2() {
		double[] dblAry = { 67.3, 72.5, 88.3, 79.3, 90.4 };
		//배열의 값 중에서 제일 큰 값을 출력. -> 메커니즘 : 하나씩 다 비교함.
		double max = 0;
		for(int i = 0; i < dblAry.length; i++) {
			if(max < dblAry[i]) {
				max = dblAry[i];
			}
		}
		System.out.printf("제일 무거운 몸무게 : %.1f \n", max);
			
			
			
		double avg = 0;
		double tot = 0;
		for(int i=0; i<dblAry.length; i++) {
			tot += dblAry[i];
			avg = (tot / 5);
		}
		System.out.printf("몸무게 총합은 %f, 몸무게 평균은 %f 입니다. ", tot, avg);
			
			
			
			
		System.out.println("\n end of prog.");
		}
	
	public static void method3() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("찾고 싶은 친구 입력 >>>");
		String name = scn.nextLine();
		boolean nosuchman = false;
		String friends[] = { "강동원", "최원영", "전영재", "홍길동", "김민수"};
		double dblAry[] = { 78.3, 78.5, 80.3, 79.3, 90.4 };
		int scores[] = new int[5]; // 배열은 이렇게 따로 재선언해주어야 길이가 변경이 된다.
		scores[0] = 100;
		scores[1] = 100;
		scores[2] = 100;
		scores[3] = 90;
		scores[4] = 95;
		// ***는 몇 번째에 있습니다.
		int max = 0;
		String name = "";
		double weight = 0;
		for(int i=0; i<friends.length; i++) {
			if(friends[i].equals(name)) {
				System.out.printf("%s 은(는) %d 번째에 있으며, 몸무게는 %.1f, 점수는 %d 입니다.", friends[i], i+1, dblAry[i], scores[i] );
				nosuchman = true;
			}
		}
		if(nosuchman == false) {
			System.out.println("그런 친구는 없습니다.");
		}
		System.out.println("\n end of prog.");
	}
	}
