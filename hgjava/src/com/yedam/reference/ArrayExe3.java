package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {
	public static void main(String[] args) {
		// 이전 단계에서 배열을 3개 만들어 관리했으나,
		// 이번에는 한 배열에 모두 담아보는 목적.
		// "속성"개념에 대해 자세히 다루어지는 듯.
		Friend f1 = new Friend(); // 초기화. 공간=객체=인스턴스를 만든다.
		f1.name = "홍길동";
		f1.weight = 67.8;
		f1.score = 80;
		
		Friend f2 = new Friend();
		f2.name = "김길동";
		f2.weight = 77.8;
		f2.score = 86;
		
		Friend f3 = new Friend();
		f3.name = "김민석";
		f3.weight = 79.8;
		f3.score = 88;
		//새로운 친구.
		String name = "김말숙";
		double weight = 55.5;
		int score = 88;
		
		Friend f4 = new Friend();
		f4.name = name;
		f4.weight = weight;
		f4.score = score;
		
		
		Friend[] friends = { f1, f2, f3 };
		friends = new Friend[5]; // 이 코드로 인해 { null,null,null,null,null }로 초기화된 상태. 
		//위 라인을 주석으로 하면 다시 실행된다.
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3; //{ f1, f2, f3, null, null }
		friends[4] = f4; //{ f1, f2, f3, f4, null }
		
		// 김말숙 => score 88 -> 90 변경.
		Scanner scn = new Scanner(System.in);
		System.out.println("찾을 친구 입력 >>>");
		String fname = scn.nextLine();
		System.out.println("바꿀 점수 >>>");
		int fscore = scn.nextInt();
		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(fname)) {
				friends[i].score = fscore;
			}
		}
			
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(fname)) {
		System.out.printf("몸무게는 %.1fkg 점수는 %d", friends[i].weight, friends[i].score);
			
			
			
	}
}
	}
}
