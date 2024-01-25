package com.yedam.collection;

public class Box<T> {
	//어떤 형태의 값이라도 담을 수 있도록.
	//모든 클래스의 최상위 클래스인 오브젝트로 필드 생성
	// 클래스 선언 옆의 <T>나, 아래 필드 부분의 T는
	// Box라는 이 클래스를 사용하는 시점에 결정한다는 뜻이고,
	// 제너릭 이라고 불린다.
	T obj;
	void setObj(T obj) {
		this.obj = obj;
	}
	
	T getObj() {
		return obj;
	}
	
	
}
