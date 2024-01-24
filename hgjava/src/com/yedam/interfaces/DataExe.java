package com.yedam.interfaces;

public class DataExe {
	public static void main(String[] args) {
		// mysql vs Oracle
		// 인터페이스의 필요성을 알아보기 위한 가상 프로젝트.
		// mysql을 쓰던 회사가 Oracle을 쓰면서 생기는 상황으로 가정
		
//		MysqlDB mysql = new MysqlDB();
//		OracleDB oracle = new OracleDB();
		
//		DAO dao = new MysqlDB();
		DAO dao = new OracleDB();
		
		
		int menu = 0;
		
		if(menu == 1) {
//			mysql.insert();
//			oracle.add();
			dao.insert();
		} else if(menu ==2) {
//			mysql.update();
//			oracle.modify();
			dao.update();
		} else if(menu == 3) {
//			mysql.delete();
//			oracle.remove();
			dao.delete();
		}
	}
	// 이렇게 성능이 겹치는걸 매번 수정하는게 회사규모에선 대단히 힘든 일이다.
	// 이럴 때 인터페이스를 사용한다.
	
}
