package com.yedam.classes.inherit;

import lombok.Data;

//이름, 연락처 (Friend)
//이름, 연락처, 학교, 전공 (UnivFriend)
//이름, 연락처, 회사, 부처 (CompFriend)
@Data
public class Friend extends Object {
	private String name;
	private String phone;
	//롬복?
	
	public void changeInfo(String info1, String info2) {
		return; //자식클래스가 가져와서 오버라이딩하라는 용도
	}
	
	@Override
	public String toString() {
		return "이름은 " + name + ", 연락처는 " + phone;
	}
	
}
