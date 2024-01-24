package com.yedam.exceptions;

public class ThrowExe {
	public static void main(String[] args) {
		try {
		method();
		} catch(ClassNotFoundException e) {
			System.out.println("존재하지 않는 클래스");
		} catch (Exception ee) {
			System.out.println("알 수 없는 예외.");
		}
	}
	static void method() throws ClassNotFoundException {
		// 여러번 예외를 처리해야 하는 번거로움을 해소하기 위하여.
		Class.forName("java.lang.String");
		Class.forName("java.lang.String");
		Class.forName("java.lang.String");
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			System.out.println();
//		}
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			System.out.println();
//		}
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			System.out.println();
//		}
		}
	}
