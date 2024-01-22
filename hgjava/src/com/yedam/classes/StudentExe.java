package com.yedam.classes;
//동일한 패키지에 있으면, import 같은 케이스를 거치지 않아도 서로 연결
//실행용 클래스
public class StudentExe {
	public static void main(String[] args) {
		//실행용 클래스에는 위 줄을 선언해줌
		Student s1 = new Student("S001","홍길동",80,178.9); //인스턴스 생성.생성자 호출
//		s1.sno="S001";
//		s1.sname = "홍길동";
//		s1.score = 80;
//		s1.height = 178.9;
//		
//		System.out.println(s1.sno);
//		s1.height = -167; //이런식으로하지 않고 메소드를 만들어 호출
		s1.setHeight(-167);
//		System.out.println(s1.);
		s1.showInfo();
		
		Student s2 = new Student("S002", "김길동");
//		s2.score = 85;
		s2.showInfo();
		
		Student s3 = new Student("S003", "박길동", 90);
		s3.showInfo();
		
}
}
