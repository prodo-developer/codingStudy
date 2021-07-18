package com.algoStudy.algo0317;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandTest {

    int m, n = 0; // 가로 세로를 구하기위해 셋팅
    final int[][] dirs = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
    int size = 0;// 칸의 개수

    public int[] solution(char[][] grid) {
        int[] answer = new int[2];

        if(grid == null || grid.length == 0) {
            return answer;
        }

        int count = 0; // 카운트 값
        int maxCnt = 0; // 제일큰 값

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {     // 영역구간이라면
                    size = 0;        // 초기화
                    count++;         // 육지 개수 카운트
                    bfs(grid, i, j); // 지나간자리는 치운다 0처리
                    System.out.println(maxCnt + " < " + size);
                    if(maxCnt < size)   // 육지중에 제일 넒은영역 담기
                        maxCnt = size;
                }
            }
        }

        answer[0] = count;
        answer[1] = maxCnt;

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y}); // 0, 0

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                // m > x1 && n >y1
//                System.out.println(m + " == " + n + ", " + grid.length + " == "+ grid[0].length);
                if(x1 >= 0 && y1 >= 0 &&  x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[] {x1, y1});
                    size++;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '1' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println(new NumberOfIslandTest().solution(grid));
    }
}
