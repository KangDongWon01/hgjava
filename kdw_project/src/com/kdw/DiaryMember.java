package com.kdw;

import java.util.Date;

public class DiaryMember {
	//회원과 관련한 메소드와 필드를 정리하는 클래스
	private String user_id;
	private String user_pw;
	private String user_name;
	private Date user_bd;
	
	//기본 생성자
	public DiaryMember() {
		super();
	}

	//생성자
	public DiaryMember(String user_id, String user_pw, String user_name, Date user_bd) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_bd = user_bd;
	}	
	
	//getter / setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getUser_bd() {
		return user_bd;
	}
	public void setUser_bd(Date user_bd) {
		this.user_bd = user_bd;
	}
}
