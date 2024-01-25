package com.yedam.thread;

import java.awt.Toolkit;

//Runnable 인터페이스의 구현객체를 통해서 쓰레드.
public class BeepTask implements Runnable{
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
