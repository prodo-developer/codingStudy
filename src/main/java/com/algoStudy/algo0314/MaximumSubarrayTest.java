package com.algoStudy.algo0314;

public class MaximumSubarrayTest {
    // subArray중에 합이 제일 큰 수
    public int maxSubArray(int[] nums) {
        // 1. 새로운 값=(새로운값(-2), 새로운값+subArray 값()) 비교
        int newSum = nums[0];
        int max = nums[0];  // -2 부터 시작

        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(nums[i], newSum+nums[i]);
            max = Math.max(newSum, max);
        }
        
        // 2. 1번에서 나온 max값을 따로 저장
        // maxSum = Math.max(새로운값, 기존꺼 합한값)

        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        // 설명 : [4, -1,2,1]의 가장 큰 합계 = 6입니다.

        // 1
        // 5,4,-1,7,8
        System.out.println(new MaximumSubarrayTest().maxSubArray(a));


    }
}
