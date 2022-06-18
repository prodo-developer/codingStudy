package com.programers.week4;

import java.util.Arrays;

public class Lifeboat {

    /**
     * 최소한의 횟수로 옮기기 위해서는 가장 몸무게가 큰 사람 + 가장 몸무게가 작은 사람 조합이여야 한다.
     * 80 (최솟값인 50과 같이 가면 한계점인 100을 넘는다.)
     * 70 (최솟값인 50과 같이 가면 한계점인 100을 넘는다.)
     * 50 + 50
     * 순으로, 총 횟수인 3을 return한다.
     *
     * people의 min 위치에 있는 값 + max 위치에 있는 값이 limit보다 작거나 같으면 min++.
     * answer++ (구명보트 카운트)
     * 위 if문에서 걸리지 않으면 현재 최댓값 혼자 구명보트를 탄 걸로 처리
     */
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 최솟값의 위치역할을 하기위해 0으로 초기화
        int min = 0;

        // people을 정렬한다.
        Arrays.sort(people);

        // 초기값 max는 people 배열의 크기 -1 (max는 최댓값 위치의 역할)
        // min <= max 일때까지 반복 (최소값의 위치가 최댓값의 위치보다 커지면 반복 종료)
        for (int max = people.length-1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

//        int[] people = {10, 20, 30, 40, 50, 60, 70, 80, 90}; // 5
        int[] people = {70, 50, 80}; // 3
        int limit = 100;

        System.out.println(new Lifeboat().solution(people, limit));
    }
}
