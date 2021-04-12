package com.hackerrack;

public class NewYearChaos {

    /**
     * 뇌물을 주고받아 순서가 변경된 que가 주어졌을 때 몇 번 이동해야하는지를 출력.
     * 단 아래 조건에 어긋날 que일 경우 'Too Chaotic'를 출력
     * 조건
     * 바로 앞에 있는 사람한테 뇌물을 주고 앞으로 갈 수 있음
     * 한 사람 당 2명까지 뇌물을 줄 수 있음. 즉 최대 2번 앞으로 이동가능
     */

    static int minimumBribes(int[] q) {
        // bubble sort use!
        int swaps = 0;
        for (int i = q.length-1; i >= 0; i--) {
            if(q[i] != i+1) {
                if((i-1) >= 0 && q[i-1] == i+1) {   // 0을 벗어나는지 확인
                    int temp = q[i-1];
                    q[i-1] = q[i];
                    q[i] = temp;
                    swaps++;
                } else if((i-2) >= 0 && q[i-2] == i+1) {   // 2번이동이 가능
                    q[i-2] = q[i-1];
                    q[i-1] = q[i];
                    q[i] = q[i-2];
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return 0;
                }
            }
        }

        System.out.println(swaps);
        return 0;
    }

    public static void main(String[] args) {
//        int[] q  = {1,2,3,5,4,6,7,8};
//        int[] q  = {2, 5, 1, 3, 4};
        int[] q  = {2, 1, 5, 3, 4};
        int[] q1  = {2, 5, 1, 3, 4};
//        int[] q  = {1, 2, 5, 3, 4, 7, 8, 6};
        System.out.println(new NewYearChaos().minimumBribes(q));
        System.out.println(new NewYearChaos().minimumBribes(q1));
    }
}
