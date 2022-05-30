package com.algoStudy.algo0314;

import java.util.stream.Stream;

public class PlusOneTest2 {

    public String addTwoNumbers(int[] param_1, int[] params_2) {
        // 인덱스값, 값 셋팅
        int index = param_1.length-1;
        int carry = 1;

        String val = "";
        String val2 = "";
//        for (int i = digits.length-1; i >= 0; i--) {
        for (int i = 0; i < param_1.length; i++) {
            val += param_1[i];
        }

        for (int i = 0; i < params_2.length; i++) {
            val2 += params_2[i];
        }

        String sum = String.valueOf(Integer.parseInt(val) + Integer.parseInt(val2));

        int[] total = Stream.of(String.valueOf(sum).split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(total);
        String qutor = "->";
        String sb = "";
        for (int i = 0; i < total.length; i++) {
            sb += total[i] + qutor + " ";
        }

        return sb.substring(0, sb.length()-3);
    }

    public static void main(String[] args) {
//        int[] a = {0};
        int[] a = {7, 2, 4, 3};
        int[] b = {5, 6, 4};
//        int[] a = {0, 0, 1};
//        int[] a = {9, 8, 9};
//        int[] a = {8, 9, 9};
//        int[] a = {2,1,9,9,9};

        System.out.println(new PlusOneTest2().addTwoNumbers(a,b));


//        int[] result = new PlusOneTest2().solution(a,b);

//        for (int i : result) {
//            System.out.println("val : " + i);
//        }
    }

}
