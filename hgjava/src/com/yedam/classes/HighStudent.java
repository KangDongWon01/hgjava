package com.yedam.classes;

// 담임선생님.
public class HighStudent extends Student {
	private String teacher;
	
//	public HighStudent() {
//		super();
//	}
	public HighStudent(String sno, String name) {
		super(sno, name);
	}
	
	public HighStudent(String sno, String name, int score, String teacher) {
		super(sno, name, score);
		this.teacher = teacher;
	}
	//getter / setter
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
}
