package com.yedam.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		//List
		List<String> list1 = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i = 0; i<100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("List 결과 : " + (end - start));
		
		//LinkedList
		List<String> list2 = new LinkedList<>();
		long start1 = System.currentTimeMillis();
		for(int i = 0; i<100000; i++) {
			list2.add(0, String.valueOf(i));
		}
		long end1 = System.currentTimeMillis();
		System.out.println("LinkedList 결과 : " + (end1 - start1));

		
		
	}
}
