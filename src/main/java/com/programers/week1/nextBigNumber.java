package com.programers.week1;

public class nextBigNumber {

    public int numberOfOne (String n){
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    public int solution ( int n){

        int answer = n;
        int nCnt = numberOfOne(Integer.toBinaryString(answer));

        while (true) {
            int now = numberOfOne(Integer.toBinaryString(++answer));
            if (now == nCnt)
                break;
        }

        return answer;
    }

    public static void main(String[] args) {

//        int n = 15;
        int n = 78;

        System.out.println(new nextBigNumber().solution(n));

    }
}
