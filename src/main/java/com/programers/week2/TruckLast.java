package com.programers.week2;

import java.util.LinkedList;
import java.util.Queue;

public class TruckLast {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length 다리길이 7
        // weight 다리가 견딜 수 있는 무게 7
        // truck_weights 트럭별 무게
        int time = 1;
        // Queue<int[]> q = new PriorityQueue<>(result);
        Queue<Integer> trucksOnBridge = new LinkedList<>();
        Queue<Integer> waitingTrucks = new LinkedList<>();

        // 트럭 저장
        for (int truck : truck_weights) {
            trucksOnBridge.offer(truck);
        }
        System.out.println(trucksOnBridge);
        for(int i=0; i<bridge_length; i++) {
            trucksOnBridge.offer(0);
            waitingTrucks.offer(0);
        }

        int bridge_sum = 0;

        while(!trucksOnBridge.isEmpty()) {

            bridge_sum = bridge_sum - trucksOnBridge.poll();

            if(bridge_sum + trucksOnBridge.peek() > weight) {
                waitingTrucks.offer(0);
            } else {
                bridge_sum += trucksOnBridge.peek();
                waitingTrucks.offer(trucksOnBridge.poll());
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(new TruckLast().solution(7, 7, new int[] {1,1,1,1,1,3,3}));

//        solution(1, 2, new int[] {1,1,1}); //4
//        solution(1, 1, new int[] {1,1,1}); //4
//        solution(4, 2, new int[] {1,1,1,1}); //10
//        solution(3, 3, new int[] {1,1,1}); //6
//        solution(3, 1, new int[] {1,1,1}); //10
//        solution(3, 1, new int[] {1,1,1,1,1}); //16
//        solution(5, 5, new int[] {1,1,1,1,1,2,2}); //14
//        solution(7, 7, new int[] {1,1,1,1,1,3,3}); //18
//        solution(5, 5, new int[] {1,1,1,1,1,2,2,2,2}); //19
//        solution(5, 5, new int[] {2,2,2,2,1,1,1,1,1}); //19
    }
}
