package com.baekjoon;

import java.util.ArrayList;
import java.util.List;

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
public class CompressionTest {

    static int[] size = new int[50];
    static char[] s;
    public static int solve(String str) {
        int result = 0;

        if(str.length()%2 != 0) // 짝수가 아니면 false
            return result;

        String[] strings = str.split("");
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                stack.add(-1);
            } else if (strings[i].equals(")")) {
                int cnt = 0;
                while (true) {
                    int tmp = stack.remove(stack.size() - 1);
                    if (tmp == -1) {
                        break;
                    }
                    cnt += tmp;
                }
                stack.add(stack.remove(stack.size() - 1) * cnt);
            } else if (i < strings.length - 1 && strings[i + 1].equals("(")) {
                stack.add(Integer.parseInt(strings[i]));
            } else {
                stack.add(1);
            }
        }

        int answer = 0;
        for (int s: stack) {
            answer += s;
        }

        return answer;
    }

    // n1 = num1.charAt(num1Length)-'0';        // String -> int값으로 나옴. 중요함
    // 2 6 19
    static int recur(int start, int end) {
        int sLength = 0;
        for (int i = start; i < end; i++) {
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

        System.out.println(new CompressionTest().solve(str));
    }
}
