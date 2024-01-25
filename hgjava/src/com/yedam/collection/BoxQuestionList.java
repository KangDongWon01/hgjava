package com.yedam.collection;

public class BoxQuestionList {
	public static void main(String[] args) {
		Box box = new Box<String>();
		
		box.setObj("Hong");
		String result = (String) box.getObj();
		System.out.println(result);
		
		box.setObj(100);
		Integer result1 = (Integer) box.getObj();
		System.out.println(result1);
		
		
		// GPT에게 물어본 결과,
		// 제너릭의 타입 소거라는 성질 때문에 오류는 없지만,
		// 실행 예외 등 오류가 많이 생길 수 있으므로
		// 권장하지 않는 방법이라고 한다.
		// 예담강동원 계정이 GPT에게 물은 내역을
		// 다시한번 참조해보자.
		// GPT 답변 :
		// 네, 정확히 맞습니다. 해당 코드는 Java의 제네릭 타입 소거 특성을 이용하여 컴파일 오류를 발생시키지 않지만, 이러한 방식의 코드는 타입 안전성을 보장하지 않아 추후 실행 중 예외 등의 오류가 발생할 가능성이 있습니다. 제네릭을 올바르게 사용하지 않으면 컴파일러가 경고를 표시하지만, 이러한 경고를 무시하고 코드를 작성할 수 있습니다.
		// 따라서 일반적으로는 타입 안전성을 유지하기 위해 올바른 제네릭 사용을 권장합니다. 형변환이나 제네릭의 타입 안전성을 무시하는 코드는 실행 시 예외를 발생시킬 수 있으므로 신중하게 다뤄져야 합니다. 코드를 작성할 때는 컴파일러 경고를 무시하지 않고, 제네릭을 적절히 활용하여 안전하고 명확한 코드를 작성하는 것이 좋습니다.
	}
}
