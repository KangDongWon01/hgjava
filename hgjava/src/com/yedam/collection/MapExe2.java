package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapExe2 {
	public static void main(String[] args) {
		// Member 고객의 마일리지를 관리하는 프로그램
		Map<Member, Integer> map = new HashMap<>();
		map.put(new Member(1, "홍길동"), 900);
		map.put(new Member(2, "박길동"), 1200);
		map.put(new Member(3, "최길동"), 500);
		map.put(new Member(1, "홍길동"), 800);
		map.put(new Member(4, "김길동"), 1500);
		
		
		System.out.println("크기 : "+ map.size());
		// Member클래스에서 해시코드, 이퀄즈 메소드를 오버라이드해 놓았기 때문에
		// 그 규칙에 따르면 홍길동은 포인트가 달라도 중복되는 객체로 취급되어
		// 하나로 센다.
		System.out.println("키 : "+ new Member(1, "홍길동"));
		System.out.println("값 : "+ map.get(new Member(1, "홍길동")));
		
		System.out.println("키의 존재유무 : " + map.containsKey(new Member(2, "박길동")));
		System.out.println("값의 존재유무 : " + map.containsValue(1200));
		
		// 포인트가 1000점 이상인 사람의 이름 출력
		Set<Entry<Member, Integer>> eset = map.entrySet();
		Iterator<Entry<Member, Integer>> iter = eset.iterator();
		
		while (iter.hasNext()) {
			Entry<Member, Integer > ent = iter.next();
			if(ent.getValue() > 1000) {
				System.out.printf("이름 %s, 포인트 %d \n", ent.getKey().getName(), ent.getValue());
			}
		}
		
		
		
		
	}
}
