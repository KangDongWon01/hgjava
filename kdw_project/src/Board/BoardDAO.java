package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	public static Connection conn;
	public static PreparedStatement psmt;
	public static ResultSet rs;
	public static String sql;
	
	//DB와 프로그램을 연결시켜주는 메소드
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//데이터베이스 URL, 아이디, 비밀번호 입력
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yedam","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	// DB와 프로그램 연결해제하는 메소드
	public static void disconn() {
		try {
		if(conn != null) {	
		conn.close();
		} if(psmt != null) {
			psmt.close();
		} if(rs != null) {
			rs.close();
		}
	}
		catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
