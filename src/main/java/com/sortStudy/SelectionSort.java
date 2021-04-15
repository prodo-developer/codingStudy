package com.sortStudy;

import java.util.Arrays;

// 선택 정렬
public class SelectionSort {

    public static void main(String[] args) {
        int[] number = {15,3,23,64,77,46,42,174,68,78,91,5,76,310,84,342,176,120,33,41};

        // swap 할 공간
        int temp;

        for (int i = 0; i < number.length-1; i++) {
            int indexMin = i;
            for (int j = i+1; j < number.length; j++) {
                // > 내림차순, < 오름차순
                if(number[j] < number[indexMin]) {
                    indexMin = j;
                }
            }
            temp = number[indexMin];
            number[indexMin] = number[i];
            number[i] = temp;
        }

        System.out.println(Arrays.toString(number));
    }
}
