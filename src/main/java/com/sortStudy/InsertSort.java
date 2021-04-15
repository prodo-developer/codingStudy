package com.sortStudy;

import java.util.Arrays;
import java.util.LinkedList;

// 삽입 정렬
public class InsertSort {

    public static void main(String[] args) {
        char[] str = {'C','A','D','G','F','E','B'};

        // 배열로 구현
//        for (int i = 0; i < str.length; i++) {
//            for (int j = i; j > 0; j--) {
//                // < 내림차순, > 오름차순
//                if(str[j-1] > str[j]) {
//                    char temp = str[j-1];
//                    str[j-1] = str[j];
//                    str[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(str));

        // 리스트로 구현 (가변적이고 좋음)
        LinkedList<Character> list = new LinkedList<>();

        for (char c : str) {
            list.add(c);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i) > list.get(j)) {
                    Character temp = list.remove(j);
                    list.add(i, temp);
                }
            }
        }

        System.out.println(list);
    }
}
