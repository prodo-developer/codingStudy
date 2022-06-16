package com.programers.week2;

import java.util.HashMap;
import java.util.Map;

public class changeFation {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i< clothes.length; i++) {  // 아무것도 안입은 상태도 갯수로 샌다.
            //System.out.println(clothes[i][1]);
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        System.out.println(map);

        //옷을 하나도 입지 않은 상태를 뺀다.
        return answer-1;
    }

    public static void main(String[] args) {
//        String[][] clothes=
//                {{"yellow_hat", "1"}, {"blue_sunglasses", "2"}, {"green_turban", "3"}, {"red_turban", "3"}
//                        , {"white_turban", "4"}, {"black_turban", "4"}};

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(new changeFation().solution(clothes));
    }
}
