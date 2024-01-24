package com.yedam.api;

public class Member {
	String name;
	int age;
	
	
	Member(){}
	
	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//객체의 주소값 반환
	@Override
	public int hashCode() {
		return this.name.hashCode(); // 문자열이 같으면 같은 해시코드를 반환하게 만들었음.
	}
	
	@Override
	public String toString() {
		return ("이름은 "+ name+ ", 나이는 "+ age);
	}
	
	//name, age만 같으면 논리적으로 동일한 객체
	//equals를 오버라이딩.
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member target = (Member) obj;
			if(this.name.equals(target.name) && this.age == target.age) {
				return true;
			}
		}
		return false;
	}
}
