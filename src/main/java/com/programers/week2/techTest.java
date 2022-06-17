package com.programers.week2;

import java.util.ArrayList;

public class techTest {

    /*
    첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
    두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
    세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

    따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
     */

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<Integer> arrList = new ArrayList<>();

        // 기능마다 걸리는 일 수 계산
        for (int i = 0; i < progresses.length; i++) {
            int days = 0;
            days +=
                    (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] :
                    (100 - progresses[i]) / speeds[i] +1;
            arrList.add(days);
        }

        for (int a : arrList) {
            System.out.print(a + ",");
        }
        System.out.println("=============");
        System.out.println("작업이 끝나기까지 남은 일수를 구하기");

        int cnt = 1;
        int baseNum = arrList.get(0);
        for (int i = 0; i < arrList.size(); i++) {
            if(arrList.size() == i+1){
               answerList.add(cnt);
               break;
            }

            System.out.println(baseNum + ">=" + arrList.get(i+1));
            if(baseNum >= arrList.get(i+1)) {
                cnt++;
            } else {
                baseNum = arrList.get(i+1);
                answerList.add(cnt);
                cnt = 1;
            }
        }

        // System.out.println("cnt : " + cnt + " temp : " + temp);

//        // int형 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println("=============");
        for (int a : answer) {
            System.out.println(a);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5}; // 2개, 1개

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1}; // 2개, 1개

//        int[] progresses = {40, 93, 30, 55, 60, 65};
//        int[] speeds = {60, 1, 30, 5, 10, 7}; // 1, 2, 3

        System.out.println(new techTest().solution(progresses, speeds));
    }
}
