package com.yedam.api;

public class StringTest {
    public static void main(String[] args) {
        // 성별
        String[] jumins = { "970101-1234562", "960301-1224266", "910121-2236566", "920101-2235526", "950101-2266567", "980304-7777020" };

        // checkGender 메소드 호출
        checkGender(jumins);

        // 2번문제. 길동 이라는 이름 몇번나오나?
        String[] names = {};
    }

    static void checkGender(String[] jumins) {
        // 주민번호 뒷자리 1,2로 성별 체크하기
        for (int i = 0; i < jumins.length; i++) {
            if (jumins[i].charAt(7) == '1') {
                System.out.println("남자");
            } else if (jumins[i].charAt(7) == '2') {
                System.out.println("여자");
            } else {
                System.out.println("혼종입니다.");
            }
        }
    }
}
