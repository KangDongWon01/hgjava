package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe2 {
	public static void main(String[] args) {
		Set<Member> members = new HashSet<>();
		
		members.add(new Member(1,"홍길동"));
		members.add(new Member(2,"김길동"));
		members.add(new Member(3,"박길동"));
		members.add(new Member(1,"홍길동"));
		// 논리적으로는 홍길동 2개가 같은 값인데,
		// 오버라이딩을 해서 기준을 바꾸던가 하지 않으면. 
		// 멤버는 new로 생성된 인스턴스, 별개의 값으로 취급됨.
		members.remove(new Member(2,"김길동"));
		//제거시에도 논리적으로 같은지 비교할 것임.
		
		System.out.println(members.size());
		//오버라이딩 전에는 4라는 크기로 측정.
		//Member 클래스로 가서 오버라이딩 시작.
		//오버라이딩 후에는 3이라는 크기로 측정.
		
		//반복된 요소를 선택해서 가져오는 반복자.
		Iterator<Member> iter = members.iterator();
		while(iter.hasNext()) {
			Member member = iter.next();
			System.out.println(member);
		}
		
		
	}
}
