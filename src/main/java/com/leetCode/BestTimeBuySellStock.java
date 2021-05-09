package com.leetCode;

import java.util.Arrays;

// 브루트 포스 문제
public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        System.out.println(minPrice);
        int maxPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            System.out.println("minPrice : " + minPrice + ", price[i] : " + prices[i] + ", maxPrice : " + maxPrice);
            maxPrice = Math.max(maxPrice, prices[i]-minPrice);
        }

        return maxPrice;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(new BestTimeBuySellStock().maxProfit(prices));
    }
}
