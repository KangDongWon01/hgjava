package com.yedam.classes;
//라이브러리용 클래스
// 학생들의 속성 : 학생번호, 이름, 점수, 키
// 학생들의 기능(행동): 자기소개
public class Student { //이 필드 부분은 기능보단 구조를 설명하기 위한 부분에 가깝다.
	//==================================================================================
	//필드 : 코드들 중, 속성에 관련한 요소를 모아놓은 부분.
	private String sno; //private -> 접근 지시, 다른 클래스에서 접근하거나 말거나를 결정
	private String sname;
	private int score;
	private double height;
	private boolean onSchool;
	
	//하나의 클래스이자 객체이기도 한데, 하나의 데이터 타입으로 볼 수 있다.
	
	//==================================================================================
	//생성자 : 따로 명시하지 않으면 기본 생성자 라는것을 컴파일러가 생성해놓는다.
	//예를 들어, new Friend() <- 매개값이 없는 생성자.
	public Student() {
		//다른 생성자들을 따로 정의해놓고, 기본 생성자를 명시치 않으면
		//컴파일러가 기본 생성자를 생성하지 않는다.
	}
	public Student(String no, String name) { //기본 생성자 메서드
//		this.sno = "S001"; // 이 생성자를 호출하는 것 만으로, 위 변수에 값을 저장해준다는 뜻
		sno = no;
		sname = name;
	}
	public Student(String no, String name, int score) {//초기화를 시켜서 넣는 생성자 메서드.
//		sno = no;
//		sname = name;
		this(no,name);
		this.score = score; 
		// 매개변수가 필드의 변수와 이름이 같으면, 우선순위가 높은 필드 쪽 변수가 적용됨
		// 구별하기 위하여 this.라는 것을 붙여준다. 객체에서 자기 자신을 가리킨다.
		
	}
	// 우클릭 - source - constructor using fields - 생성자 자동 생성
	public Student(String sno, String sname, int score, double height) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.height = height;
	}
	//==================================================================================
	//메서드 : 이름, 매개, 반환값(반환값이 없을 경우 void를 입력하여 주며, return값이 없다.)
	public void showInfo() {
		System.out.printf("번호는 %s, 이름은 %s, 점수는 %d 점 입니다.\n", this.sno, this.sname, this.score);
	}
		
	//반환값이 문자다 -> String
	String showInfoStr() {
		return "";
	}
	//getter / setter.
	// 필드의 값들을 private를 통하여, 외부 클래스의 접근을 차단해 놓았음.
	// 그러나 실행용 클래스에서 어쨌든 사용은 해야 되는 값들이므로, 
	// 메서드들을 만들어 호출하면 사용할 수 있게 해주는 것임.
	public void setHeight(double height) {//필드에서 직접적으로 처리하지 못하게 함
		if (height < 0) {
			this.height = 160;
		} else {
			this.height = height;
		}
	}
	public double getHeight() {
		return this.height;
	}
	
	// sno, sname, score 작성해보기.
//	public String setSno() {
//		if (~~~)
//	}
	
	public String getSno() {
		return this.sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isOnSchool() { //필드가 불린 값일때 getter setter 생성하면 getter에 is가 붙는게 관례
		return onSchool;
	}
	public void setOnSchool(boolean onSchool) {
		this.onSchool = onSchool;
	}
	
}
