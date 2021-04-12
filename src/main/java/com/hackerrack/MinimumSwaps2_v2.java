package com.hackerrack;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2_v2 {

   /**
    * 배열을 정렬하는 데 필요한 최소 스왑 [비 연속 고유 정수]
    * 배열을 오름차순으로 정렬하는 데 필요한 최소 스왑 수를 찾는 알고리즘입니다. 문제 : 고유 한 정수 ∈ Z 즉 {..., -2, -1, 0, 1, 2, ...}로 구성된 정렬되지 않은 배열이 있습니다.
    * 두 가지 요소를 교환 할 수 있습니다. 배열을 오름차순으로 정렬하는 데 필요한 최소 스왑 수를 찾아야합니다.
    * 알고리즘 개념 :
    * 1. 배열의 첫 번째 요소를 선택하고 배열의 다른 모든 요소와 비교합니다.
    * 2. 모든 비교에서 선택한 요소보다 작은 가장 작은 요소를 찾은 다음이 두 요소를 교체하고 교체 횟수를 1 씩 늘립니다.
    * 3. 배열이 오름차순으로 정렬 될 때까지 배열의 다음 요소에 대해 프로세스를 반복합니다
    *
    * 단점 : 10만건 이상의 데이터를 차는데 무리가 있다. 정확성 떨어짐
    */
   static int minimumSwaps(int[] arr) {

       int swanCnt = 0;

       for (int i = 0; i < arr.length-1; i++) {

           int temp, minloc = i;

           for (int j = i; j < arr.length; j++) {
               if(arr[j]<arr[minloc]) {
                   minloc = j;
               }
           }

           if(minloc != i) {
               temp = arr[minloc];
               arr[minloc] = arr[i];
               arr[i] = temp;

               swanCnt++;
           }

       }

       return swanCnt;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr  = {7, 1, 3, 2, 4, 5, 6};
        int[] arr1 = {4, 3, 1, 2};
        int[] arr2 = {2, 3, 4, 1, 5};

        System.out.println(new MinimumSwaps2_v2().minimumSwaps(arr));
        System.out.println(new MinimumSwaps2_v2().minimumSwaps(arr1));
        System.out.println(new MinimumSwaps2_v2().minimumSwaps(arr2));
    }
}
