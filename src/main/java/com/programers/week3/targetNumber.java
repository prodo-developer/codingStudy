package com.programers.week3;

public class targetNumber {

    /**
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     */

    public int solution(int[] numbers, int target) {
        int[] numbersS = numbers;
        int targetS=target;

        return dfs(0,0, numbersS, targetS);//배열순번, 더한값
    }

    private int dfs(int numTurn ,int sum, int[] numbersS, int targetS) {

        if(numTurn >= numbersS.length) {
            return (sum==targetS) ? 1 : 0;
        }

        return dfs(numTurn+1,sum+numbersS[numTurn], numbersS, targetS)
            +  dfs(numTurn+1,sum-numbersS[numTurn], numbersS, targetS);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(new targetNumber().solution(numbers, target));
    }
}
