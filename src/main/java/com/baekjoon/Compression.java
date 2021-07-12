package com.baekjoon;

import java.util.Arrays;
import java.util.Stack;

/**
 * 문자열 압축은 재귀호출 추천
 * 문자열 길이 주의
 * '('의 위치를 찾아서 stack에 담는다. (2, 6, 9)
 * ')'의 위치를 찾아서 stack 순서대로 꺼내서 값을 넣는다.
 * 즉, '('에 담았던 최근 값 순서대로 꺼내서 담는다.
 * size[9] = 11;
 * size[6] = 12;
 * size[2] = 13;
 *
 * 33(562(71(9)))
 * => 33(562(79))
 * => 33(567979)
 * => 3567979567979567979
 * => 결과: 19
 */
public class Compression {

    static int[] size = new int[50];
    static char[] s;
    public static int solve(String str) {
        int result = 0;

        if(str.length()%2 != 0) // 짝수가 아니면 false
            return result;

        Stack<Integer> st = new Stack();
        // 문자 자료형으로 치환
        s = str.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(')
                st.push(i);

            if (s[i] == ')') {
                size[st.pop()] = i;
            }
        }

        System.out.println(Arrays.toString(size));

        return recur(0, str.length());
    }

    // n1 = num1.charAt(num1Length)-'0';        // String -> int값으로 나옴. 중요함
    // 2 6 19
    static int recur(int start, int end) {
        int sLength = 0;
        for (int i = start; i < end; i++) {
            System.out.println(s[i]);
            if (s[i] == '(') {
                sLength += (s[i - 1] - '0') * recur(i + 1, size[i]) - 1;
                i = size[i];
            } else {
                sLength++;
            }
        }
        return sLength;
    }

    public static void main(String[] args) {
        String str = "33(562(71(9)))";

        System.out.println(new Compression().solve(str));
    }
}
