package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1); // 기본타입 <-> wrapper 클래스 , 
		// 그냥 숫자 1 넣었는데 인티저 클래스의 인스턴스로 변환되었음.
		Double d1 = Double.valueOf("2.3");
		System.out.println(d1);
		
	}
}
