package com.sortStudy;

import java.util.Arrays;

public class MergeSort {

    public static void mergesort(int[] arr, int i, int length) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int low, int high) {
        if(high - low < 2) return;

        int mid = (low+high) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int t = 0, l = low, h = mid;

        while (l < mid && h < high) {
            if(arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (h < high) {
            temp[t++] = arr[h++];
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void main(String[] args) {
        int[] array = { 80, 70, 60, 50, 40, 30, 20 };
        mergesort(array, 0, array.length);

        System.out.println(Arrays.toString(array));
    }
}
