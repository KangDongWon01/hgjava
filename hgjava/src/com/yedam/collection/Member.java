package com.yedam.collection;

public class Member {
	private int mid;
	private String name;
	//생성자
	public Member(int mid, String name) {
		super();
		this.mid = mid;
		this.name = name;
	}
	
	//오버라이딩, 이름 같으면 논리적으로 같은 것으로 취급
	@Override
	public int hashCode() {
		return mid;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member target = (Member) obj;
			return this.mid == target.mid && this.name.equals(target.name);
		}
		return false;
	}



	//getter / setter
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + "]";
	}
	
	
	
}
