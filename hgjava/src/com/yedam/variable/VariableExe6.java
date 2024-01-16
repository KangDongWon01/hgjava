package com.yedam.variable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class VariableExe6 {
	public static void main(String[] args) 
		throws FileNotFoundException {
		//표준 입출력 : 키보드(System.in), 모니터(System.out).
		InputStream is = new FileInputStream("test.txt");
		Scanner scn = new Scanner(is);
		
		String name = scn.nextLine();
		int age = scn.nextInt(); 
		double height = scn.nextDouble(); 
		// 나이 (int:age), 키(double:height)
		System.out.println("이름은 " + name + "나이는 " + age +"세," + "키는 " + height);
		System.out.printf("이름은 %s, 나이는 %d", "홍길동", 20);
		scn.close();
	}
}
	
	
//		Scanner scn = new Scanner("test.txt");
//		String result = scn.nextLine();
//		System.out.println(": " + result);
//		
//		
//										//%d = 출력하는 값을 double로
//							//  %s = 출력하는 값을 문자열로
//	}
//}
