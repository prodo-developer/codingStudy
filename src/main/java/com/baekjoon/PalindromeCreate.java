package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 또는 회문이란 간단하게 말해서 입력 받은 문자열이 거꾸로 해도 같은 문자를 뜻한다.
 * 예를 들어 한글로는 토마토가 있고, 영어로는 level이 있다.
 */
public class PalindromeCreate {

    public static int solution(String str) {
        int strLen = str.length();
        boolean flag = true;

        int size = 0;

        for (int i = 0; i < strLen/2; i++) {
            if(str.charAt(i) != str.charAt(strLen-i-1)) {
                System.out.println(str.charAt(i) + " == " + str.charAt(strLen-i-1));
                flag = false; // 한번이라도 같지 않으면
                size = i + str.length();
            }
        }

        if(!flag) return size;

        return 1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(br.readLine()));
    }
}
