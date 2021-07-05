package com.baekjoon;

import java.io.IOException;
import java.util.Arrays;

/**
 * 1. 세그먼트 트리를 만들어서 각 노드에 최소값의 인덱스를 저장한다.
 * 2. 이후 최대 넓이를 계산하는 query를 호출한다.
 *   2-1. 제일 처음엔 [0, n-1] 구간에서 최소 높이가 저장된 인덱스를 찾아낸 뒤, 이를 바탕으로 최소 높이를 산출하여 최대 넓이를 계산한다.
 *   2-2. 위에서 구한 최소 높이 인덱스를 기준으로 삼아서 "왼쪽 탐색", "오른쪽 탐색"의 이진 분할 재귀탐색을 진행한다.
 *   2-3. 왼쪽, 오른쪽 탐색은 모두 재귀로 이뤄지며 각 탐색은 최종적으로 구할 수 있는 최대 넓이를 반환한다.
 *   2-4. 재귀 호출이 모두 끝나고, 최종적으로 최대값을 비교하여 반환한다.
 */

public class histogram {

    public static void main(String[] args) throws IOException {

        int[] arr = {2, 1, 4, 5, 1, 3, 3};

        SegmentTree segmentTree = new SegmentTree(arr, 7);

        System.out.println(Arrays.toString(segmentTree.segmentArr));
    }
}

class SegmentTree {

    int[] segmentArr; // The array that stores segment tree nodes

    SegmentTree(int[] arr, int n) {

        //int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        //int segmentSize = (int) Math.pow(2, x) * 2 - 1;

        //segmentArr = new int[segmentSize];
        segmentArr = new int[n * 4];
        init(arr, 0, n - 1, 1);
    }

    // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
    int init(int[] arr, int left, int right, int node) {

        if (left == right) {

            return segmentArr[node] = arr[left];
        }

        int mid = (left + right) / 2;

        segmentArr[node] += init(arr, left, mid, node * 2);
        segmentArr[node] += init(arr, mid + 1, right, node * 2 + 1);

        return segmentArr[node];
    }

}
