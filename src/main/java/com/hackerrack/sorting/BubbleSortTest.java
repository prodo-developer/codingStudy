package com.hackerrack.sorting;

public class BubbleSortTest {

    static int countSwaps(int[] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length -i -1; j++) {
                // < 내림차순, > 오름차순
                if(a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;

                    count++;
                }
            }
        }
        System.out.println("Array is sorted in "+count+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);

        System.out.println("=============");
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1};
        int[] b = {4,2,3,1};
        int[] c = {1,2,3};

        System.out.println(new BubbleSortTest().countSwaps(a));
        System.out.println(new BubbleSortTest().countSwaps(b));
        System.out.println(new BubbleSortTest().countSwaps(c));
    }
}
