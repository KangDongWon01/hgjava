package com.kdw;

import java.sql.Connection;
import java.sql.DriverManager;

public class DiaryDAO {
	public static Connection conn;

	//DB와 프로그램을 연결시켜주는 메소드
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//데이터베이스 URL, 아이디, 비밀번호 입력
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yedam","1234");
		} catch (Exception e) {
			
		}
		return conn;
	}
}
