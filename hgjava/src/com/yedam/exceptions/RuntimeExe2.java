package com.yedam.exceptions;

public class RuntimeExe2 {
	public static void main(String[] args) {
		
		// 실행예외.
		String str = "10";
		
		str = null;
		
		try {
			str = "ten";
		System.out.println(str.toString()); // NullPointer Exception
		int num = Integer.parseInt(str); // NumberFormat Exception
//		} catch(NullPointerException ne) {
//			//ne.printStackTrace(); -> 나중에 실제 프로그램 짤 때, 사용자들이 이 메세지를 볼 일은 없다.
//			System.out.println("참조값이 없음.");
//		} catch(NumberFormatException ne2) {
////			ne2.printStackTrace();
//			System.out.println("숫자값이 아님.");
		} catch(Exception e) {
			System.out.println("예외 발생하였음.");
		} //예외를 상세하게 설정하느냐, 한가지로 설정하느냐 차이, Exception이라는 예외 클래스가 최상위다.
		//그래서, 이 예외 클래스가 맨 위로가면, 이 예외클래스에서 다 잡아내므로 어떤 예외인지 상세히 파악하기 어렵다.
		
		System.out.println("end of program.");
		
	}
}
