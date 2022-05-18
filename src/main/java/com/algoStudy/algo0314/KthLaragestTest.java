package com.algoStudy.algo0314;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLaragestTest {

    public int solution (int[] nums, int k) {

        // 방법1
//        Arrays.sort(nums);
//        int s = nums[nums.length-k];

        // 방법2
        // priority queue 오름차순 정렬
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int s : nums) {
//            pq.offer(s);
//            if(pq.size() > k) {
//                pq.poll();
//            }
//        }
//        int s = pq.peek();

        // 방법3
        // priority queue 내림 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer(num);
        }
        System.out.println(pq);
        int s = 0;
        while (k > 0) {
            s = pq.poll();
            --k;
        }

        return s;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new KthLaragestTest().solution(nums, k));
    }
}
