package com.yedam.reference;

import java.util.Scanner;

//친구의 정보 = 저장 - 변경 - 관리
//CRUD = 생성 - 수정 - 변경 - 삭제
public class FriendExe {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = new Friend[5];
		
		int score = 0;
		double weight = 0;
		
		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 5.점수조회 6.분석 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			//등록하기
			case 1: 
				System.out.print("이름>>");
				String name = scn.nextLine();
				if(name == "") {
					System.out.println("이름은 반드시 입력하셔야 합니다.");
				break;}
				System.out.print("몸무게>>");
				weight = Double.parseDouble(scn.nextLine());
				System.out.print("점수>>");
				score = Integer.parseInt(scn.nextLine());
				//객체생성
				Friend friend = new Friend();
				friend.name = name;
				friend.weight = weight;
				friend.score = score;

				for(int i = 0; i < friends.length; i++) {
					if(friends[i] == null) {
						friends[i] = friend;
						break;
					}
				}
				System.out.println("정상적으로 입력.");
				break;
			//조회하기
			case 2: 
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {						
						System.out.printf("이름:%s(님) / 몸무게:%.1f(kg) / 점수:%d(점)\n", friends[i].name, friends[i].weight, friends[i].score);
					}
				}
				break;
			//수정하기	
			case 3: 
				System.out.println("조회할 이름 입력>>");
				String fname = scn.nextLine();
				boolean isExist = false;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null && friends[i].name.equals(fname)) {
						System.out.println("수정할 몸무게 입력>>");
						double fweight = Double.parseDouble(scn.nextLine());
						System.out.println("수정할 점수 입력>>");
						int fscore = Integer.parseInt(scn.nextLine());
						friends[i].weight = (fweight != 0) ? fweight : friends[i].weight;
						friends[i].score = (fscore != 0) ? fscore : friends[i].score;
						isExist = true;
						System.out.println("수정을 완료했습니다.");
					}
				}
				if(isExist == false) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			//삭제하기
			case 4: 
				System.out.println("삭제할 이름 입력>>");
				String dname = scn.nextLine();
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null && friends[i].name.equals(dname)) {
						friends[i] = null;
						System.out.println("삭제를 완료했습니다.");
						break;
					}
				}
				break;
			//점수조회 입력점수 이상인 친구
			case 5:
				System.out.println("점수 입력>>");
				int score2 = Integer.parseInt(scn.nextLine());
				if(score2 >= 0) {
					for( int i = 0; i < friends.length; i++) {
						if(friends[i] != null && score2 < friends[i].score) {
							System.out.printf("이름:%s(님) / 몸무게:%.1f(kg) / 점수:%d(점)\n", friends[i].name, friends[i].weight, friends[i].score);
						}
					}
				}
				else {
					System.out.println("0이상의 점수를 입력하세요.\n");
				}
				break;
			//분석 평균점수 최고점수
			case 6:
				int sum = 0;
				int max = 0;
				int cnt = 0;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {					
						sum += friends[i].score;
						cnt++;
						if(max < friends[i].score) {
							max = friends[i].score;
						}
					}
				}
				System.out.printf("친구들의 평균 점수는 %d점이고, 최고점수는 %d점입니다.\n", sum/cnt, max);
				break;
			//종료하기
			case 9: 
				run = false;
				System.out.println("종료합니다.");
			}
		}
		System.out.println("end of program..");
	}
}