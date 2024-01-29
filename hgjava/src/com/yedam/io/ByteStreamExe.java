package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteStreamExe {
	public static void main(String[] args) {
		// 바이트 기반의 출력 스트림.
	try {
		FileInputStream fis = new FileInputStream("c:/temp/sample.png");
		FileOutputStream fos = new FileOutputStream("c:/temp/sample.png");
		while (true) {
			int buf = fis.read();
			if(buf == -1){
				break;
			}fos.write(buf);
		}
		fos.flush();
		fos.close();
		fos.close();
	} catch (Exception e){
		e.printStackTrace();
	}
		
	try {
		FileOutputStream fos = new FileOutputStream("c:/temp/sample.dat");
		// 저정된 파일은 이진 ~~ 라는 개념으로 만들어진다고 함.
		fos.write(10);
		fos.write(20);
		fos.write(30);
		fos.flush();
		fos.close(); // 자원(위 실행에 쓰이는 데이터)를 운영체제로 환원하겠다.
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	static void write() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/sample.dat");
			// 저정된 파일은 이진 ~~ 라는 개념으로 만들어진다고 함.
			fos.write(10);
			fos.write(20);
			fos.write(30);
			fos.flush();
			fos.close(); // 자원(위 실행에 쓰이는 데이터)를 운영체제로 환원하겠다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void read() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/sample.dat");
			while (true) {
				int bytes = fis.read(); // eof => -1 변환
				if (bytes == -1) {
					break;
				}
				System.out.println("bytes");
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}