package com.kdw;

import java.util.Date;

public class DiaryObject {
	//다이어리 객체를 생성하기 위한 라이브러리형 클래스
	private int diary_id;
	private String title;
	private String cont;
	private Date regDate;
	private Date updateDate;
	
	
	public DiaryObject() {
	}
	
	public DiaryObject(String title, String cont) {
		super();
		this.title = title;
		this.cont = cont;
		
		
	}
	public DiaryObject(int diary_id, String title, String cont, Date regDate, Date updateDate) {
		super();
		this.diary_id = diary_id;
		this.title = title;
		this.cont = cont;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
	
	//getter / setter
	public int getDiary_id() {
		return diary_id;
	}
	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getRegDate() {
		
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
