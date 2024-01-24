package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

//hashCode, equals.
public class ObjectExe2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("김길동");
		
		set.add("박길동");
		set.add("박길동");

		set.add("홍길동");

		for(String name : set) { // for ..of .. -> ":" 뜻은 set에 들어있는 수만큼 반복
			System.out.println(name);
		}
		
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("최길동", 20));
		members.add(new Member("최길동", 20));
		members.add(new Member("전길동", 22));
		members.add(new Member("강길동", 24));

		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
		
		
	}
}
