package com.sortStudy;

import java.util.Arrays;

public class QuickSort {

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) return; // 정렬 하고자 하는 집단의 원소가 1개인 경우

        int pi = partition(array, left, right);

        quicksort(array, left, pi - 1);
        quicksort(array, pi, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];

        while (left <= right) {                         // 엇갈릴 때까지 반복
            // 오름차순 조건, 내림차순은 반대로 하면됩니다.
            while (array[left] < pivot) left++;         // 키 값보다 큰 값을 만날 때까지 오른쪽으로 이동
            while (array[right] > pivot) right--;       // 키 값보다 작은 값을 만날 때까지 왼쪽으로 이동
            if(left <= right) {                         // 현재 엇갈린 상태면 키 값과 교체
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 80, 70, 60, 50, 40, 30, 20 };
        quicksort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
