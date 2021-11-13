package com.algoStudy.algo0314;

import java.util.*;

public class GroupAnagramsTest {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length ==0) return result;
        // 소팅(key, List<String>)
        Map<String, List<String>> map = new HashMap<>();
//        방법1
        for (String str : strs) {
            int[] count = new int[26];

            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(count);
            System.out.println("hash " + key);

            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

//        방법2
//        for (String str : strs) {
//            char[] charArray = str.toCharArray();
//            Arrays.sort(charArray);
//
//            String key = String.valueOf(charArray);
//            if(map.containsKey(key)) {
//                map.get(key).add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }
//        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(new GroupAnagramsTest().groupAnagrams(strs));
    }
}
