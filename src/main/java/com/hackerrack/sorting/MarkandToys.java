package com.hackerrack.sorting;

import java.util.Arrays;

// 오름차순 정렬하면서 더하기.. 그러다 예산 넘으면 스탑
public class MarkandToys {

    static int maximumToys(int[] prices, int k) {

        int sum = 0;
        int count = 0;

        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices));
        for (int i = 0; i < prices.length; i++) {
            if(sum > k) {
              count--;
              return count;
            } else {
                sum += prices[i];
                count++;
            }
        }

        return count-1;
    }

    public static void main(String[] args) {
//        int[] prices = {1,2,3,4};
//        int k = 7;

//        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
//        int k = 50;

        int[] prices = {3, 7, 2, 9, 4};
        int k = 15;

        System.out.println(new MarkandToys().maximumToys(prices, k));
    }
}
