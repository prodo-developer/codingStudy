package com.leetCode;

import java.util.*;

public class ArrayHiddenSearch {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " + != + " + (i+1));
            if(nums[i] != i+1) {
                if(Arrays.binarySearch(nums, i+1) < 0) {
                    list.add(i+1);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(new ArrayHiddenSearch().findDisappearedNumbers(nums));
    }
}
