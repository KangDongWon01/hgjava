package com.yedam.reference;

public class RefExe1 {
	public static void main(String[] args) {
		int n1 = 100;
		int n2 = 100;
		System.out.println(n1 == n2); //기본타입 변수. 값을 비교하고 있다.
		
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
		System.out.println(str1 == str2); //참조타입 변수. 값을 비교하는게 아닌, 참조하는 주소를 비교하고 있음.
		System.out.println(str1.equals(str2)); //equals 명령어는 참조하는 주소가 아닌, 주소 안의 값을 비교하는 것.
		
		int intAry[] = new int[10]; // new의 의미는 : 주소에 값을 담아준다는 뜻.
		intAry = null; // intAry라는 배열을 더 사용하지 않겠다는 의미가 된다.
//		System.out.println(intAry[0]); -> 널포인트익셉션 발생
		System.out.println(intAry);
	}
}
