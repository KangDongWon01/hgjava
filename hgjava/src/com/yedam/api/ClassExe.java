package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassExe {
	public static void main(String[] args) {

		// 해당 클래스의 메소드
		Class cls = String.class;
		String str = "";
		cls = str.getClass();
		try {
			cls = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {

		}

		// 해당 클래스의 필드.
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

		Field[] fields = cls.getDeclaredFields();
		for (Field Field : fields) {
			System.out.println(Field.getName());
		}
		// 경로 정보.
		String path = cls.getResource("ObjectExe.class").getPath();
		System.out.println(path);

//		Scanner scn = new Scanner(new File(path));

	}
}
