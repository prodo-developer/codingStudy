package com.modernJava8.chapter1;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class WhyJava8 {

    public static final int THREE_SIZE = 3;

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1차 실습 반복문을 이용한 " : " 삽입 후 뒤에 영역 사이즈 삭제
        oneTest(numbers);

        // 2차 실습 마지막 " : " 를 지우는 실습
        twoTest(numbers);

        // 스트림을 이용한 실습
        threeTest(numbers);
    }

    private static void oneTest(List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Integer number : numbers) {
            stringBuilder.append(number).append(" : ");
        }

        if(stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - THREE_SIZE, stringBuilder.length());
        }

        System.out.println(stringBuilder);
    }

    private static void twoTest(List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();
        final int size = numbers.size();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(numbers.get(i));
            if(i != size-1) {
                stringBuilder.append(" : ");
            }
        }

        System.out.println(stringBuilder);
    }

    private static void threeTest(List<Integer> numbers) {
        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));

        System.out.println(result);
    }
}