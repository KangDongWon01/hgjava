package com.yedam.classes.inherit;

import java.util.Scanner;

public class FriendExe {
	//사용자 입력/처리결과 출력 => 컨트롤.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		FriendApp app = new FriendApp();
		
		while(run) {
			int menu = 0;
			System.out.println("1.등록 2.조회 3.수정 4.삭제 9.종료");
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("다시 입력하시오.");
			}
			switch (menu) {
			case 1: //등록. 1)이름연락처 2)학교친구: 학교,전공 3)회사친구: 회사,부서
				System.out.println("1.친구 2.학교친구 3.회사친구");
				int subMenu = Integer.parseInt(scn.nextLine());
				
				System.out.println("이름 >> ");
				String name = scn.nextLine();
				System.out.println("연락처 >> ");
				String phone = scn.nextLine();
				
				Friend friend = null;
				
				if(subMenu ==1) {
					friend = new Friend();
					friend.setName(name);
					friend.setPhone(phone);
					
				} else if(subMenu ==2) {
					//자식 인스턴스 생성
					UnivFriend ufriend = new UnivFriend();
					ufriend.setName(name);
					ufriend.setPhone(phone);
					System.out.println("학교 >> ");
					String univ = scn.nextLine();
					System.out.println("전공 >> ");
					String major = scn.nextLine();
					ufriend.setPhone(univ);
					ufriend.setPhone(major);
					
					friend = ufriend;
					
				} else if(subMenu ==3) {
					//자식 인스턴스 생성
					CompFriend cfriend = new CompFriend();
					cfriend.setName(name);
					cfriend.setPhone(phone);
					System.out.println("회사 >> ");
					String company = scn.nextLine();
					System.out.println("부서 >> ");
					String dept = scn.nextLine();
					cfriend.setCompany(company);
					cfriend.setDept(dept);
					
					friend = cfriend;
				}
				
				if(app.add(friend)){
					System.out.println("정상 등록");
				} else {
					System.out.println("등록 실패");
				}
				break;
				
			case 2://목록(이름)
				System.out.println("조회할 이름>> ");
				String fname = scn.nextLine();
				Friend[] list = app.list(fname);
				for(int i=0; i<list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].toString()); //toString 이라는 기능은 롬복을 받아서 생겼다.
					}
				}
				break;
				
			case 3: //수정
				System.out.println("수정할 친구의 전화번호 >>");
				String fphone = scn.nextLine();
				System.out.println("회사,또는 학교 >>");
				String info1 = scn.nextLine();
				System.out.println("부서,또는 전공 >>");
				String info2 = scn.nextLine();
				
				Friend[] mlist = app.list(fphone);
				for(int i=0; i<mlist.length; i++) {
					if(mlist[i].getPhone() == fphone) {
						app.modify(fphone, info1, info2);
						//폰번호가 맞을경우 FriendApp의 info1과 info2를 바꿀수 있어야됨
					}
					else {
						System.out.println("잘못된 입력값, 다시 확인하세요.");
					}
				}
				break;
				
			case 4: //삭제
				
			case 9: //종료
				System.out.println("종료합니다.");
				run = false;
			
			} //end of switch.
		} // end of while.
		
		System.out.println("end of program.");
	}
}
