package com.yedam.classes.nested;

import java.util.Map;

public class nestedExe {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method1();
		
		Outer.NestClass nest = outer.new NestClass();
		nest.field2 = "반갑습니다.";
		System.out.println(nest.field2);
	
		Map.Entry<String, Integer> entry;
	
	
	}
}
