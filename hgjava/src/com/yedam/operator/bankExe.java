package com.yedam.operator;

import java.util.Scanner;

//은행계좌.
public class bankExe {
	public static void main(String[] args) {
		//입금, 출금, 잔고, 종료
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("1.입금 2.출금 3.잔고 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:System.out.println("입금액>> ");
					 String income = scn.nextLine(); 
//					if (Integer.parseInt(scn.nextLine()) > 100000) {
					if (Integer.parseInt(income) > 100000) {
						System.out.println("10만원 이상은 입금이 불가함");
						balance += 0;
					} else {
//					balance += Integer.parseInt(scn.nextLine());
					// 위 코드는 수정 전. 10만원 이상 입금 시도시,
					// 한번에 결과가 처리되지 않고, 다시 사용자 입력값을 대기하고 있다.
					balance += Integer.parseInt(income); 
					// 수정 후의 코드. 위에서 지정한 변수로 바꾸어 주자, 저장된 변수값으로 한번에 처리한다. 
					System.out.println("입금완료!");
					}
					break;
			case 2:System.out.println("출금액>> ");
					String out = scn.nextLine();
					if(Integer.parseInt(out) > balance) {
						System.out.println("잔고보다 큰 금액은 출금 불가함");
						balance -= 0;
					} else {
					balance -= Integer.parseInt(out);
					System.out.println("출금완료!");
					}
					break;
			case 3:System.out.println("잔고>> ");
					System.out.println(balance);
					break;
			case 4:System.out.println("종료합니다. ");
					run = false;
					break;// 굳이 안써도 되긴 한걸로 암
			}
		}
		System.out.println("end of prog.");
	}
}
