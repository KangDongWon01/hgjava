package com.yedam.variable;

public class VariableExe4 {
	public static void main(String[] args) {
		//true / false
		boolean isTrue = 10 > 20;
		
		isTrue = update(10);
		
		if(isTrue) {
			System.out.println("참값.");
		}else {
			System.out.println("거짓값.");
		}
		
		Members m1 = new Members();
		m1.name = "홍길동";
		m1.age = 20;
		m1.height = 167.8;
		
		Members m2 = new Members();
		m2.name = "김민수";
		m2.age = 23;
		m2.height = 172.5;
		
		isTrue = m1.height > m2.height;
		isTrue = m1.age == m2.age;
		isTrue = m1 == m2; //속성값을 같게 바꾸더라도, 두 개체의 참조 주소가 다르므로 false다.
		
		System.out.println(m1);
		System.out.println(m2);
		
		byte a = 10;
		int b = (int) a;
		// 아래 코드에서 a를 int로 바꾼다고 명시했기 때문에 강제 형변환 한 것이고,
		// 굳이 저렇게 안 적더라도 자동 형 변환이 된다.
		
		
	}// end of main.
	public static boolean update(int arg) {
		return arg % 2 == 0;
	} // end of update.
	
}// end of class
