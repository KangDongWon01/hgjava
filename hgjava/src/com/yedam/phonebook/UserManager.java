package com.yedam.phonebook;

import java.io.File;
import java.io.FileReader;

//기능은 c:/temp/userList.txt에 저장된 아이디/비밀번호를 이용.
public class UserManager {
	private String userID;
	private String userPW;

	
	public UserManager(String userID, String userPW) {
		this.userID = userID;
		this.userPW = userPW;
	}
	
	public boolean userCheck(String userID, String userPW) {
//		FileReader fr = new FileReader(userFile);

		System.out.println("ID 입력>> ");
		String userInputId = MenuViewer.Keyboard.nextLine();
		System.out.println("PW 입력>> ");
		String userInputPw = MenuViewer.Keyboard.nextLine();
//		if(userFile.)
		return true;
		
//		while((str = br.readLine()) != null) { // 읽어들이는 값이 존재하면
//			String[] record = str.split(",");
//			// 값을 구분하여, 컬렉션에 저장. //
//			int type = Integer.parseInt(record[0]);
//			switch(type) {
//			case InputSelect.NOMAL:
//				info = new PhoneInfo(record[1], record[2]);
//				break;
//			case InputSelect.COMPANY:
//				info = new PhoneCompanyInfo(record[1], record[2], record[3]);
//				break;
//			case InputSelect.UNIV:
//				info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
//			}
//			storage.add(info);
//		}
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
}