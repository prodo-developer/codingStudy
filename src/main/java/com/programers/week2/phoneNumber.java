package com.programers.week2;

import java.util.Arrays;

public class phoneNumber {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);    // 정렬

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]))   // 시작한 값이 처음 포함하는 글자가 같은지.
                answer = false;

            break;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123", "456", "789"};
//        String[] phone_book = {"12", "123", "1235", "567", "88"};

        System.out.println(new phoneNumber().solution(phone_book));
    }
}
