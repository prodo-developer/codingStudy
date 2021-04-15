package com.sortStudy;

import java.util.Arrays;

// 버블 정렬
public class BubleSort {

    public static void main(String[] args) {
        int[] number = {11,234,23,4,1,5,6,2,65,764,825,46,72,47,26,69,793,25,498,245};

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length -i -1; j++) {
                // < 내림차순, > 오름차순
                if(number[j] > number[j+1]) {
                    int temp = number[j+1];
                    number[j+1] = number[j];
                    number[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(number));
    }
}
