package com.leetCode;

import java.util.Arrays;

// 브루트 포스 문제
public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int maxValue = 0;

        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int price = prices[j] - prices[i];
                if(maxValue < price) {
                    maxValue = price;
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(new BestTimeBuySellStock().maxProfit(prices));
    }
}
