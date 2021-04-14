package com.hackerrack.hashMaps;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {

        Map<Character, Integer> maps1 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            maps1.put(ch, maps1.getOrDefault(ch, 0)+1);
        }

        for (char ch : s2.toCharArray()) {
            if(maps1.get(ch) == null) {
                continue;
            } else {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "aardvark", s2 = "apple";                   // Yes
        String s3 = "beetroot", s4 = "sandals";                 // No

        String s5 = "hackerrankcommunity", s6 = "cdecdecdecde"; // Yes

        System.out.println(new TwoStrings().twoStrings(s1, s2));
        System.out.println(new TwoStrings().twoStrings(s3, s4));
        System.out.println(new TwoStrings().twoStrings(s5, s6));
    }
}
