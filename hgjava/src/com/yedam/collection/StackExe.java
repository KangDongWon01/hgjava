package com.yedam.collection;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("김민석");
		stack.push("최만석");
		
		stack.pop(); //이 방법으로 하나씩 제거한다. 제일 마지막으로 온 최만석이가 삭제됨.
		
		while(!stack.isEmpty()) {
			String result = stack.pop();
			System.out.println(result);
		}
		
		// home -> product -> sell
		
		
		
		
	}
}
