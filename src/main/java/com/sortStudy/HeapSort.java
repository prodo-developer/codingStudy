package com.sortStudy;

import java.util.Arrays;

public class HeapSort {

    public static void heapsort(int[] array) {
        int n = array.length;

        // init, max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // for extract max element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int p = i;
        int l = i*2 + 1;
        int r = i*2 + 2;

        //  array[p] < array[l] 오름차순, array[p] > array[l] 내림차순
        //왼쪽 자식노드
        if (l < n && array[p] > array[l]) {
            p = l;
        }
        //오른쪽 자식노드
        if (r < n && array[p] > array[r]) {
            p = r;
        }

        //부모노드 < 자식노드
        if(i != p) {
            swap(array, p, i);
            heapify(array, n, p);
        }
    }

    public static void swap(int[] array, int p, int i) {
        int temp = array[p];
        array[p] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 230, 10, 60, 550, 40, 220, 20 };
        heapsort(array);

        System.out.println(Arrays.toString(array));
    }
}
