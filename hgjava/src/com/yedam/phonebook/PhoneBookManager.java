package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 생성자(초기화)*(저장된 파일값을 넣어 초기화), 등록, 검색, 삭제, 종료(파일 저장), 
public class PhoneBookManager {
	private File dataFile = new File("c:/temp/phonebook.data");
	// 컬렉션 선언.
	HashSet<PhoneInfo> storage = new HashSet<>();
	
	//싱글톤 패턴.
	private static PhoneBookManager instance; // 초기값 : null.
	private PhoneBookManager() {
		//초기화작업.
		readFromFile();
		
	}
	public static PhoneBookManager getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}
	
	// 메소드, 1번유형. 2번유형. 3번유형
	private PhoneInfo getFriendInfo() {
		System.out.println("이름 >>");
		String name = MenuViewer.Keyboard.nextLine();
		System.out.println("연락처 >>");
		String phone = MenuViewer.Keyboard.nextLine();
		return new PhoneInfo(name, phone);
		}
	
	private PhoneInfo getCompanyFriendInfo() {
		System.out.println("이름 >>");
		String name = MenuViewer.Keyboard.nextLine();
		System.out.println("연락처 >>");
		String phone = MenuViewer.Keyboard.nextLine();
		System.out.println("회사명 >>");
		String company = MenuViewer.Keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
		}
	
	private PhoneInfo getUnivFriendInfo() {
		System.out.println("이름 >>");
		String name = MenuViewer.Keyboard.nextLine();
		System.out.println("연락처 >>");
		String phone = MenuViewer.Keyboard.nextLine();
		System.out.println("전공 >>");
		String major = MenuViewer.Keyboard.nextLine();
		System.out.println("학년 >>");
		int year = MenuViewer.Keyboard.nextInt();
		MenuViewer.Keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
		}
	
	//추가.
	public void inputData() {
		System.out.println("=========구분=========");
		System.out.println("1.일반 2.회사 3.학교");
		System.out.println("선택>> ");
		int choice = MenuViewer.Keyboard.nextInt();
		MenuViewer.Keyboard.nextLine();
		
		PhoneInfo info = null;
		
		switch(choice) {
		case InputSelect.NOMAL:
			info = getFriendInfo();
			break;
		case InputSelect.COMPANY:
			info = getCompanyFriendInfo();
			break;
		case InputSelect.UNIV:
			info = getUnivFriendInfo();
		}
		if(storage.add(info)) {
			System.out.println("등록완료");
		}
		else {
			System.out.println("등록실패");
		}
	}
	//삭제
	public void deleteData() {
		// 이름을 입력받고, 이름을 기준으로 storage에서 빼주기.
		System.out.println("이름>> ");
		String name = MenuViewer.Keyboard.nextLine();
		
		Iterator<PhoneInfo> iter = storage.iterator();
		while(iter.hasNext()) {
			PhoneInfo info = iter.next();
			if (info.getName().equals(name)) {
				iter.remove();
				System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
				break;
			}
		}
	//검색
	public void searchData() {
		System.out.println("이름>> ");
		String name = MenuViewer.Keyboard.nextLine();
		Iterator<PhoneInfo> iter = storage.iterator();
		while(iter.hasNext()) {
			PhoneInfo info = iter.next();
			if (info.getName().equals(name)) {
				System.out.println(info.toString());
				System.out.println("조회 성공");
			} else {
				System.out.println("조회 실패");
			}
		}
	}

	
	
	//초기화.
	public void readFromFile() {
		if (dataFile.exists() == false) { //파일이 따로 없다면,
			return; // 메소드 종료.
		}
		
		try {
		// 있으면 파일을 읽어들이도록.
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			PhoneInfo info = null;
			while((str = br.readLine()) != null) { // 읽어들이는 값이 존재하면
				String[] record = str.split(",");
				// 값을 구분하여, 컬렉션에 저장. //
				int type = Integer.parseInt(record[0]);
				switch(type) {
				case InputSelect.NOMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case InputSelect.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					break;
				case InputSelect.UNIV:
					info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
				}
				storage.add(info);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				}
	} // end of readFromFile().
	
	//저장.
	public void storeToFile() {
		try {
		FileWriter fr = new FileWriter(dataFile);
		Iterator<PhoneInfo> iter = storage.iterator();
		
		while(iter.hasNext()) {
			PhoneInfo info = iter.next();
			//toString 활용.
			fr.write(info.toString() +"\n");
			}
			fr.flush();fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} // end of class.
