package com.programers.week1;

import java.util.Arrays;
import java.util.Comparator;

public class ChoiceChar {

    public String[] solution(String[] strings, int n) {
       String[] answer = {};

       Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n))
                    return 1;
                else if(o1.charAt(n) == o2.charAt(n))
                    return o1.compareTo(o2);
                else
                    return -1;
            }
        });

        for (String s : strings) {
            System.out.println(s);
        }

        return strings;
    }

    public static void main(String[] args) {

        String[] s = {"abce", "abcd", "cdx"};
//        String[] s = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(new ChoiceChar().solution(s, n));
    }
}
