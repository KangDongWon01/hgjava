package co.kdw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiaryDAO {
//DAO는 Data Access Object의 약자. 프로그램과 DB와의 연동을 담당하는 클래스의 이름에 많이 붙는다.
//CRUD 메소드 정의	-> 테이블과 연결
//회원가입 메소드 정의 -> 테이블과 연결
	Scanner scn = new Scanner(System.in);
	List<Diary> diarylist = new ArrayList<>();
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	public static Connection conn;
	
	//프로그램과 DB를 연결하는 메소드.
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//데이터베이스 URL, 아이디, 비밀번호 입력
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yedam","1234");
		} catch (Exception e) {
			
		}
		return conn;
	}
	
	public void getDiaryList() { // 일기 목록 불러오기.
		System.out.println("             <<일 기 목 록>>");
		System.out.println("번호     제목        작성일   ");
		System.out.println("------------------------------------");
		if(diarylist.isEmpty()) { //일기 객체들을 담은 리스트에 아무것도 없는 경우
			System.out.println("             작성한 일기가 없어요.");
		}else {
			System.out.println("");
			
		}
	}
}
