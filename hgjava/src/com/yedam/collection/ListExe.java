package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("김민석");
		names.add("김민석");
		names.add(1, "이만수"); // 이만수를 1번 인덱스로 넣겠다는 표현.
		names.add(1, "이만우");
		names.set(1, "김만우");
		names.remove(1); // 한건삭제.
//		names.clear(); //미리 알려주지 못하고, 실행 시점에 뜨는 오류. 
		// try-catch로 개발자가 직접 잡아주어야 한다.
		System.out.println(names.size()); // 크기 확인.
		// 반복문.
		for (String name : names) {
			System.out.println(name);
		}
//		if(names.size()>2) {
//		System.out.println(names.get(1)); // 인덱스에 해당하는 배열값 가져오기.
//		}
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "홍길동"));
//		members.add("김민석"); -> List에 선언된 Members 클래스 타입이 아니기 때문에 오류
		members.add(new Member(2, "김민석"));
		members.add(new Member(3, "이충희"));

		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			String name = members.get(i).getName();
			int id = members.get(i).getMid();
			System.out.printf("이름 : %s, 아이디 : %d\n", name, id);
			System.out.printf("%s\n", members.get(i).toString());
		}

//		for(int i = 0; i < members.size(); i++) {
//			String name = members.get(i).getName();
//			if(name.equals("김민석")) {
//				names.set(i, "김길동");
//			}
//		}

		// 교수님 작성
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals("김민석")) {
				members.set(i, new Member(4, "김길동"));
			}

		}
	}
}
