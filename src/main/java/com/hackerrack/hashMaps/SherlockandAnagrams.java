package com.hackerrack.hashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockandAnagrams {

    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // key save, sort
                char[] ch = s.substring(i, j+1).toLowerCase().toCharArray();
                Arrays.sort(ch);
                System.out.println(ch);
                String k = new String(ch);
                System.out.println(k);

                if(map.containsKey(ch)) {
                    map.put(k, map.get(ch) + 1);
                } else {
                    map.put(k, 1);
                }
            }
        }

        System.out.println(map);

        int cnt = 0;

        // Factorial
        for (String k : map.keySet()) {
            int v = map.get(k);
            System.out.println(v);
            cnt += (v * (v-1)) /2;
        }

        return cnt;
    }

    public static void main(String[] args) {
        String s = "abba";
        String s1 = "abcd";

        System.out.println(new SherlockandAnagrams().sherlockAndAnagrams(s));
//        System.out.println(new SherlockandAnagrams().sherlockAndAnagrams(s1));
    }
}
