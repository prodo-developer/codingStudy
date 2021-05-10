package com.leetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 배열 값중에 가장 많이 같은 값을 가지고 있는 값이 결과 값이다.
 * jdk 1.7에서 지원하는 map 기능(map.getOrDefault 사용)
 * jdk 1.8에서 지원하는 최대값 value 구하기 (람다식 사용)
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        int result = Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,3};
        int[] nums2 = {2,2,1,1,1,2,2};
        int[] nums3 = {3,3,4};

        System.out.println(new MajorityElement().majorityElement(nums1));
        System.out.println(new MajorityElement().majorityElement(nums2));
        System.out.println(new MajorityElement().majorityElement(nums3));
    }
}
