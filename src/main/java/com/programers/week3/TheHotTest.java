package com.programers.week3;

import java.util.PriorityQueue;

public class TheHotTest {

    /**
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> que = new PriorityQueue();

        for (int start : scoville) {
            que.offer(start);
        }

        System.out.println();

        while (que.peek() < K && que.size() > 1) {
            que.offer(que.poll() + que.poll()*2);
            answer++;
        }

        if(que.peek() < K) return -1;
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(new TheHotTest().solution(scoville, k));
    }
}
