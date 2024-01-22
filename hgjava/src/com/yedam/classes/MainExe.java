package com.yedam.classes;

import java.util.Scanner;

public class MainExe {
	public static Scanner scn = new Scanner(System.in);
	public static StudentApp app = new StudentApp();
	static String sno="", sname="";
	static int score = 0;
	static double height = 0;
	
	//등록
	public static void insert() {
		System.out.println("학생번호 >>> ");
		sno = scn.nextLine();
		System.out.println("학생이름 >>> ");
		sname = scn.nextLine();
		System.out.println("학생점수 >>> ");
		score = Integer.parseInt(scn.nextLine());
		System.out.println("학생키 >>> ");
		height = Double.parseDouble(scn.nextLine());
		
		//인스턴스 생성 - 매개변수
		Student std = new Student(sno, sname, score, height);
		if (StudentApp.add(std)) {
			System.out.println("입력 완료");
		} 
		else { System.out.println("입력 실패");
		}
	}
	//목록
	public static void list() {
		Student[] list = app.list();
		for(int i =0; i<list.length; i++) {
			if(list[i] != null) {
				list[i].showInfo();
			}
		}
		System.out.println("조회 완료");
	}
	//수정
	public static void update() {
		System.out.println("학생번호 >>>");
		sno = scn.nextLine();
		System.out.println("학생점수 >>>");
		score = Integer.parseInt(scn.nextLine());
		//정상 점수가 입력되었는지.
		while(true) {
			System.out.println("학생점수 >>>");
			score = Integer.parseInt(scn.nextLine());
			if(score<0) {
				System.out.println("점수는 반드시 0이상의 값입니다.");
				continue;
			}
			break;
		}
		if (app.modify(sno, score)) {
			System.out.println("수정 완료");
		} else {
			System.out.println("잘못된 학생번호입니다.");
		}
	}
	//삭제
	public static void delete() {
		System.out.println("학생번호 >>>");
		sno = scn.nextLine();
		if(app.remove(sno)) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("잘못된 학생번호입니다.");
		}
	}
	//조회
	public static void search() {
		System.out.println("학생번호 >>>");
		sno = scn.nextLine();
		Student onelist = app.get(sno);
		//정상 학번 체크.
		if( onelist == null) {
			System.out.println("잘못된 학생번호입니다.");
		}else {
			onelist.showInfo();
		//정상 점수 입력.
			System.out.println("단건정보 조회 완료.");
		}
	}
	
	//메인.
	public static void main(String[] args) {
		//위 코드를 통해 인스턴스 생성. 아래 것들을 쓰기 위해서 선언해야 함.
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1: // 등록기능.
				insert();
				break;
			case 2: //목록 출력.
				list();
				break;
			case 3: //정보 수정
				update();
				break;
			case 4://학생정보 삭제.
				delete();
				break;
			case 5: //학생 정보 단건 출력
				search();
				break;				
			case 9:
				run = false;
				System.out.println("프로그램을 종료합니다.");
			}
		}
		System.out.println("end of prog.");
	}// end of main()
}
