package com.kdw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DiaryMethods {
	static Scanner scn = new Scanner(System.in);
	Connection conn;
	String sql;
	PreparedStatement psmt;
	ResultSet rs;
	
	void disconn() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//로그인 메소드
	public boolean Login(String user_id, String user_pw) {
		conn = DiaryDAO.getConn();
		sql = "select user_id, user_pw from d_user where user_id = ? and user_pw = ?";
		try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_id);
				psmt.setString(2, user_pw);
				rs = psmt.executeQuery();
				while(rs.next()) {
					if(rs.getString("user_id").equals(user_id) && rs.getString("user_pw").equals(user_pw)) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconn();
			}
			return false;
	}
	//회원가입 메소드
	public boolean join(String user_id, String user_pw, String user_name, Date user_bd) {
		conn = DiaryDAO.getConn();
		
		return false;
	}
	//CRUD 메소드
	
	//일기 작성 메소드
//	public boolean insertDiary(int diary_id, String title, String cont, String regDate, String updateDate ) throws SQLException {
		//쿼리문작성.
	public boolean insertDiary(DiaryObject doj) throws SQLException {

		conn = DiaryDAO.getConn(); //Connection 객체 생성.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		sql = "insert into diary (DIARY_ID, TITLE, CONT, REGDATE, UPDATEDATE) VALUE(SEQ_DIARY_ID.NEXTVAL,?,?,SYSDATE,? )";
		
		try {
			DiaryObject doj1 = new DiaryObject(); 
			psmt = conn.prepareStatement(sql, new String[] {"diary_id"});//시퀀스 쓰지 말고 rownum으로 해 보자.
			psmt.setString(1, doj1.getTitle());
			psmt.setString(2, doj1.getCont());
			psmt.setString(3, sdf.format(doj1.getUpdateDate()));
			
			int r = psmt.executeUpdate(); //데이터 반영.
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconn();
		}
		return false;
	}
	
//	public boolean deleteDiary()
}
