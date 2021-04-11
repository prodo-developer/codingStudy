package com.hackerrack;

public class LeftRetation {

    static int[] rotLeft(int[] a, int d) {
        int[] result_arr = new int[a.length];
        int size = a.length;

        int i = 0;
        int rotate_index = d;   // 회전인덱스

        // 4번만큼 사이즈 5보다 작으면
        while(rotate_index < size) {
            result_arr[i] = a[rotate_index];
            i++;
            rotate_index++;
        }

        System.out.println(rotate_index);

        // 초기화
        rotate_index = 0;
        while(rotate_index < d) {
            result_arr[i] = a[rotate_index];
            i++;
            rotate_index++;
        }

        for (int i1 : result_arr) {
            System.out.println(i1);
        }

        return result_arr;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int d = 3;

        System.out.println(new LeftRetation().rotLeft(a, d));
    }
}
