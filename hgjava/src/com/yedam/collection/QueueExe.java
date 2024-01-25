package com.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExe {
	public static void main(String[] args) {
		// offer, poll
		Queue<String> que = new LinkedList<>();
		que.offer("홍길동");
		que.offer("김길동");
		que.offer("박길동");
		
		while (!que.isEmpty()) {
			String result = que.poll();
			System.out.println(result);
		}
		
	}
}
