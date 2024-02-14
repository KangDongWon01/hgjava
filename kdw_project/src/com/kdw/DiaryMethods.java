package com.kdw;

import java.sql.Connection;
import java.util.Scanner;

public class DiaryMethods {
	static Scanner scn = new Scanner(System.in);
	
	//로그인 메소드
	public boolean Login(String user_id, String user_pw) {
		System.out.println("로그인 화면입니다.");
		System.out.println("아이디를 입력하세요. >>");
		String id = scn.nextLine();
		Connection conn = DiaryDAO.getConn();
		sql = "select user_id from d_user where user_id = ? "
		return 

	}
	//회원가입 메소드
	
	//CRUD 메소드
	
}
