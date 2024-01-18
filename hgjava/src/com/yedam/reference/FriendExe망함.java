package com.yedam.reference;
// 

import java.util.Scanner;

//Create, Read, Update, Delete - CRUD라고 불림.
// 생성, 수정, 변경, 삭제.
//친구의 정보를 저장 변경, 관리
public class FriendExe망함 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = new Friend[5]; // { null,null,null,null,null }
		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제. 5.점수조회. 6.분석. 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
		switch(menu) {
			case 1: // 등록.
				System.out.println("친구의 정보를 등록합니다.");
				System.out.print("이름>>>");
				String name = scn.nextLine();
				System.out.print("몸무게>>>");
				double weight = Double.parseDouble(scn.nextLine());
				System.out.print("점수>>>");
				int score = Integer.parseInt(scn.nextLine());
				
				Friend friend = new Friend();
				friend.name = name;
				friend.weight = weight;
				friend.score = score;
				// 비어있는 위치를 찾아서 한건만 입력 후 종료.(전 배열을 입력값으로 채우는 것을 막기 위함.)
				for(int i=0; i < friends.length; i++ ) {
					if(friends[i] == null) {
						friends[i] = friend;
						break;
					}System.out.println("정상적으로 입력되었습니다.");
				}break;
			case 2:
				System.out.println("친구의 목록을 출력합니다.");
				for(int i=0; i<friends.length; i++) {
					if(friends[i] != null) {
					System.out.printf("(%d) 이름 : %s , 몸무게 : %.1f 점수 : %d", (i+1) , friends[i].name, friends[i].weight, friends[i].score);
					System.out.println();
				}
				}break;
			case 3:
				System.out.println("친구의 정보를 수정합니다.");
				System.out.println("친구의 이름>>>");
				String fname = scn.nextLine();
				if(fname != "") {
				//입력 내용이 공백이 아닐 때
					for(int i=0;i<friends.length; i++) {
						if(friends[i] != null && friends[i].name.equals(fname)) {
						//입력 내용이 배열에 존재할 때
							//몸무게 수정	
							System.out.println("수정될 몸무게>>>");
							String fweight = scn.nextLine();
							if(fweight != "") {
							friends[i].weight = Double.parseDouble(fweight);
							System.out.println("수정이 완료되었습니다.");
							}else {System.out.println("공백을 입력하였으므로 저장되지 않았습니다.");}
							
							//점수 수정
							System.out.println("수정될 점수>>>");
							String fscore = scn.nextLine();
							if(fscore != "") {
							friends[i].score = Integer.parseInt(fscore);
							System.out.println("수정이 완료되었습니다.");
							}else {System.out.println("공백을 입력하였으므로 저장되지 않았습니다.");}
						
						//입력 내용이 배열에 존재하지 않을 때
							//null 값에 대한 처리
						if(friends[i] == null) { continue; };
						if(!(friends[i].name.equals(fname))) {System.out.println("그런 친구는 없습니다.");}}}
						
				// 입력 내용이 공백일 때
				}else if(fname == ""){
					System.out.println("공백을 입력하였습니다. 다시 입력하세요.");}
		}}}}
						//try catch finally


//			case 4: 
//				System.out.println("친구의 정보를 삭제합니다.");
//				System.out.print("삭제할 친구의 이름>>>");
//				String fname = scn.nextLine();
//				for(int i=0;i<friends.length; i++) {
//					if(friends[i] != null && friends[i].name.equals(fname)) {
//				String name = scn.nextLine();
//				}
//			case 9:
//				run = false;
//				System.out.println("종료합니다.");
//			
//		}
////		System.out.println("end of prog.");
//	}
//}
//}
