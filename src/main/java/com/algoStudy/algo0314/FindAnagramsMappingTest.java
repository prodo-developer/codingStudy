package com.algoStudy.algo0314;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMappingTest {

    public int[] findAnagrams(int[] a, int[] b) {
        // Map을 이용한다 key, Value를 이용
        // Array B의 순서를 리턴
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            map.put(b[i], i);
        }
        System.out.println(map);

        for (int i = 0; i < a.length; i++) {
            result[i] =  map.get(a[i]);
        }

        print(result);
        // int[]
        // Map A의 값을 셋팅합니다.
        // 꺼낼때는 B Array 의 key를 꺼냅니다.

        return result;
    }

    public static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};

        System.out.println(new FindAnagramsMappingTest().findAnagrams(A, B));
    }
}
