package com.yedam.impl;

public class Helicopter extends Airplane {
	//메소드 - 재정의 또는 상속받는 것 사용.
	@Override
	public void takeOff() {
		System.out.println("[Helicopter] - 이륙.");
	}
	@Override
	public void fly() {
		System.out.println("[Helicopter] - 비행.");
	}

	@Override
	public void land() {
		System.out.println("[Helicopter] - 착륙.");
	}
	
	
}
