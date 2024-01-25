package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class BoxExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		
//		box.setObj("Hong");
//		String result = (String) box.getObj();
//		System.out.println(result);

		Box<Integer> boxi = new Box<>();
		boxi.setObj(100);
		Integer result1 = (Integer) boxi.getObj();
		System.out.println(result1);
		
		List<Integer> list = new ArrayList<>();
		
		
	}
}
