package com.algoStudy.algo0304;

import java.util.Stack;

public class StackTest {

    public String solution(String S) {

        // 1. 스택을 두개로 나누기 12 담을 값과 a
        Stack<Integer> cntStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder(); // 결과를 담을 값
        int k = 0;

        // 2. for문
        for (char c :S.toCharArray()) {
            if(Character.isDigit(c)) {
//                System.out.println(k*10);
//                System.out.println(c-'0');
//                System.out.println(k*10 + c-'0');
                k = k*10 + c-'0'; // [1, 12], [2,
            } else if(c =='[') {
                cntStack.push(k);
                stringStack.push(result);

                // 리셋
                result = new StringBuilder();
                k = 0;
            } else if(c == ']') {
                StringBuilder sb = stringStack.pop();

                for (int i = cntStack.pop(); i>0; i--) {
                    sb.append(result);
                }
                result = sb;
            } else {
                result.append(c);   // real char a, bc
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // aaaaaaaaaaaabcbcdd"
        String s = "12[a]2[bc]2[d]";

        System.out.println(new StackTest().solution(s));
    }

}
