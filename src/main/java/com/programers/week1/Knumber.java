package com.programers.week1;

import java.util.Arrays;

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        int index = 0;

        for(int i=0; i<commands.length; i++) {
//          방법1
//          전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환
//          int[] temp = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);

//          방법2
            int[] temp = new int[commands[i][1]-(commands[i][0]-1)]; // 배열공간 생성
            for(int j=0; j<temp.length; j++) {
                // 증가하는 j값 + 시작하는 위치를 찾아서 temp에 담는다.
                System.out.println(array[j + commands[i][0]-1]);
                temp[j] = array[j + commands[i][0]-1]; // j만큼 array값을 지정한 temp[j]범위에 담는다.
            }
            // 2. 정렬
            Arrays.sort(temp);

            // 3. k 번째 위치 찾기
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };

        System.out.println(new Knumber().solution(array, commands));
    }
}
