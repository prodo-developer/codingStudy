package com.programers.test4;

public class TraingClothes {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] s = new int[n];
        // 체육복 현황 만들기
        for (int i = 0; i < n; i++) s[i]= 1;                           // 모든학생이 기본적으로 체육복 소지
        for (int i = 0; i < lost.length; i++)  s[lost[i] -1] -= 1;     // 잃어버렸으니 -1씩 뺀다.
        for (int i = 0; i < reserve.length; i++)  s[reserve[i] -1] += 1;  // 체육복 하나 더 갖고 있음.

        // 빌려주기
        for (int i = 0; i < n; i++) {
            if (s[i] == 0) { // 체육복이 없으면
                if(i > 0 && s[i-1] > 1) {   // i는 0보다 커야하고, 앞에있는애가 체육복이 하나 더 많으면
                    s[i-1] -= 1;   // 하나 뻇어서
                    s[i] += 1;     // 나한테 빌려주기
                } else if(i < n-1 && s[i+1] > 1){
                        s[i + 1] -= 1; // 뒤에 있는애가 체육복을 하나 빼서
                        s[i] += 1;   // 나한테 빌려주기
                }
            }
        }

        // 체육수업을 들을 수 있는 사람 (체육복이 하나라도 있으면)
        for (int i = 0; i < n; i++) if (s[i] > 0) answer++;
        return answer;
    }

    public static void main(String[] args) {

        int n =  5;                     // 전체 학생의 수
        int[] lost = {2, 4};            // 도난당한학생 번호
        int[] reserve = {1, 3, 5};      // 여벌체육복 가져온 번호

        System.out.println(new TraingClothes().solution(n, lost, reserve));
//        n   lost   reserve   return
//        5   [2, 4]   [1, 3, 5]   5
//        5   [2, 4]   [3]   4
//        3   [3]   [1]   2
    }
}
