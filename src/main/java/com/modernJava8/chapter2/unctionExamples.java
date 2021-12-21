package com.modernJava8.chapter2;

import java.util.function.Function;

/**
 * 함수형 인터페이스 실습
 */
public class unctionExamples {

    public static void main(String[] args) {

        // 기존 방법
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };

        Integer number = toInt.apply("300");
        System.out.println(number);

        // 2번째 방법 : 메서드 생략 가능
        Function<String, Integer> toIntUp = (String value) -> {
            return Integer.parseInt(value);
        };

        System.out.println(toIntUp.apply("200"));

        // 3번째 방법 : 타입을 미리 알고있기때문에 String은 생략 가능
        Function<String, Integer> toIntUp2 = (value) -> {
            return Integer.parseInt(value);
        };

        System.out.println(toIntUp2.apply("100"));

        // 4번째 방법 : 블록, 리턴 생략 가능 (파라미터가 한개면 optional 괄호 생략가능)
        Function<String, Integer> toIntUp3 = value -> Integer.parseInt(value);

        System.out.println(toIntUp3.apply("10"));

        // identity
//        Function<Integer, Integer> identity = Function.identity(); // 방법1
        Function<Integer, Integer> identity = t -> t; // 방법2

        System.out.println(identity.apply(999));
    }
}