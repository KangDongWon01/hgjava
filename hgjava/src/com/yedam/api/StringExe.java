package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello";
		str = new String("Hello");
		//문자열 => 바이트
		byte[] bytes = str.getBytes();
		for(byte b : bytes) {
			System.out.println(b);
		}
		//직접 배열 만들기
		str = new String(new byte[] { 72,101,108,108,111 });
		
		
		int pos = str.indexOf('l');
		System.out.println("l은 " + pos + "번 위치에 있음.");
		
		char chr = str.charAt(0);
		System.out.println(chr);
		
	
	}
}
