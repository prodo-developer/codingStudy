package com.programers.week3;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapTest {

    int m, n = 0; // 가로 세로를 구하기 위해 셋팅
    int[][] visited;
    final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 오른쪽, 왼쪽, 위, 아래

    public int solution(int[][] grid) {
        int answer = 0;

        if(grid == null || grid.length == 0) {
            return answer -1;
        }

        m = grid.length;    // 행 길이 5
        n = grid[0].length; // 열 길이 5
        visited = new int[m][n];

        int thisAreaSize = dfs(grid, 0, 0,  visited);

        System.out.println("======thisAreaSize: "+thisAreaSize);

        answer = thisAreaSize;

        return answer;
    }


    public int dfs(int[][] grid, int i, int j, int[][] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j }); // first start queue

//        System.out.println("i: "+i+" j "+j);
        // visited[i][j] = true;
         int thisNumAreaSize = 0;

        visited[i][j] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            System.out.println("thisNumAreaSize: "+thisNumAreaSize);

            for (int[] dir : dirs) {
                int newX = point[0] + dir[0];
                int newY = point[1] + dir[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    System.out.println("grid[i][j]  "+grid[i][j] +" grid[newX][newY] "+grid[newX][newY]);
                    if (visited[newX][newY] <=0 && grid[newX][newY] !=0 ) {
                        queue.add(new int[] { newX, newY });
                        visited[newX][newY] = visited[point[0]][point[1]]+1;
                    }
                }
            }
        }
        
        // 마지막 지점이 0인지 체크
        return visited[m-1][n-1] == 0 ? -1 : visited[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] maps = {{1,0,1,1,1},
//                        {1,0,1,0,1},
//                        {1,0,1,1,1},
//                        {1,1,1,0,1},
//                        {0,0,0,0,1}}; // 11    , 9

        int[][] maps = {{1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}}; // -1

        System.out.println(new GameMapTest().solution(maps));
        // [1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]
    }
}
