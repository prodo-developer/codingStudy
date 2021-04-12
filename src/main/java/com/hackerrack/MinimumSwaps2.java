package com.hackerrack;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {

    /**
     * 배열 정렬에 필요한 최소 스왑 : 더 쉽게 추적할 수 있도록 만든 해쉬맵 알고리즘
     * 배열을 오름차순으로 정렬하는 데 필요한 최소 스왑 수를 찾아야합니다.
     * 알고리즘 개념 :
     * 1. 각 인덱스를보고 인덱스 위치와 요소 값이 같으면 비교 한 다음 다음 인덱스 위치로 이동합니다.
     * 2. 색인 위치가 요소 값과 같지 않으면 다음 요소를 찾기 위해 요소 값을 색인 값으로 취급합니다.
     * 3. 방문한 요소로 돌아 오면주기가 있고 그주기의 크기를 세고 특정주기의 스왑 수는 크기 -1이됩니다. 모든주기에 대해이 작업을 수행하고 합산합니다.
     * 단점 : 이것은 중복되지 않은 값에 대해서만 작동합니다.
     */

   static int minimumSwaps(int[] arr) {

       int swanCnt = 0;

       // 스왑 방문 처리
       boolean[] visited = new boolean[arr.length+1];

       Map<Integer, Integer> map = new HashMap<>();

       // 위치 저장
       for (int i = 1; i < visited.length; i++) {
            map.put(i, arr[i-1]);
       }

       System.out.println(map);
       // 위치 최소값을 찾아주는 알고리즘

       for (int k = 1; k < map.size(); k++) {
           int nextNode;

           if(visited[k] == false) {
               // 방문했는지 체크
               visited[k] = true;

               // 값 비교
               if(k == map.get(k)) {
                   continue;
               } else {
                   int c = map.get(k);

                   while (!visited[c]) {
                       visited[c] = true;
                       nextNode = map.get(c);
                       c = nextNode;
                       ++swanCnt;
                   }
               }
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

        System.out.println(new MinimumSwaps2().minimumSwaps(arr));
        System.out.println(new MinimumSwaps2().minimumSwaps(arr1));
        System.out.println(new MinimumSwaps2().minimumSwaps(arr2));
    }
}
