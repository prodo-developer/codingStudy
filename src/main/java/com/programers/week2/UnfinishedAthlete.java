package com.programers.week2;

import java.util.HashMap;
import java.util.Map;

public class UnfinishedAthlete {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        // 참가자의 이름별 명단을 맵에 담음, 같은값이있으면 value 값에 +1 증가
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        System.out.println("결과1 : " + map);

        // 완주자도 같이 맵에 담음 단, 참가자중에 참가자 중에는 동명이인이 있을 수 있으므로 키값을 전체적으로 -1처리
        for(String c : completion) {
            map.put(c, map.get(c)-1);
        }

        System.out.println("결과2 : " + map);

        // value 값중에 0보다 크면 완주하지 못한 사람으로 인식
        for(String k : map.keySet()) {
            if(map.get(k) != 0) {
                answer = k;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(new UnfinishedAthlete().solution(participant, completion));
    }
}
