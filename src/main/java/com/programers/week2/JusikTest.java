package com.programers.week2;

public class JusikTest {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int sec=0;

        for (int i = 0; i < answer.length; i++) {         // 주식가격
            for (int j = i+1; j < answer.length; j++) {   // 1초부터 시작
                sec++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = sec;
            sec = 0; // 시간 초기화
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(new JusikTest().solution(prices));
    }
}
