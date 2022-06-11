package com.programers.week3;

import java.util.LinkedList;
import java.util.Queue;

public class NetworkTest {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    // bfs 방법
    private void bfs(int c, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(c);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }


    // dfs 재귀호출 방법
//    private void dfs(int i, int[][] computers, boolean[] visited) {
//        for (int j = 0; j < computers[i].length; j++) {
//            if(computers[i][j] == 1 && !visited[j]) {
//                visited[j] = true;
//                dfs(j, computers, visited);
//            }
//        }
//    }

    // dfs 방법
//    private void dfs(int c, int[][] computers, boolean[] visited) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(c);
//
//        while (!stack.isEmpty()) {
//            int i = stack.pop();
//            for (int j = 0; j < computers[i].length; j++) {
//                if(computers[i][j] == 1 && !visited[j]) {
//                    stack.push(j);
//                    visited[j] = true;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0},
                             {1, 1, 0},
                             {0, 0, 1}}; // 2

//        int n = 3;
//        int[][] computers = {{1, 1, 0},
//                             {1, 1, 1},
//                             {0, 1, 1}}; // 1

//        int n = 4;
//        int[][] computers = {{1,1,1,1},
//                             {1,1,1,0},
//                             {1,1,1,0},
//                             {1,0,0,1}};

        System.out.println(new NetworkTest().solution(n, computers));
    }
}
