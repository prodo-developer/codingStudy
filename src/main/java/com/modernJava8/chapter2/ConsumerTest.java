package com.modernJava8.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 컨슈머 실습
 */
public class ConsumerTest {
    public static void main(String[] args) {

        // 1차 실습
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        print.accept("hello");

        // 람다 실습
        Consumer<String> print2 = value -> System.out.println("Hello " + value);

        print2.accept("prodo");
        print2.accept("sungrak");

        Predicate<Integer> isPositive = i -> i > 0;
        Predicate<Integer> isPositiveThree = i -> i < 3;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5 , -4, -3, -2, -1, 0, 1, 2 ,3, 4, 5);

        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if(isPositive.test(number)) {
                positiveNumbers.add(number);
            }
        }
        System.out.println("positive integers: " + positiveNumbers);

        // 공통 함수 사용
        System.out.println("positive integers: " + filter(numbers, i -> i > 0)); // 위에 변수를 만드는것을 추천
        System.out.println("positive integers: " + filter(numbers, isPositive)); // 이방법을 추천
        System.out.println("positive Than 3: " + filter(numbers, isPositiveThree));

        Supplier<String> helloSupplier = () -> "Hello ";

        System.out.println(helloSupplier.get() + "world");

        long start = System.currentTimeMillis();

        // 이번자바 버전
        printIfValidIndex(-1, new Supplier<String>() {
            @Override
            public String get() {
                return gertVeryExpensiveValue();
            }
        });

        // 람다 화살표 연산자 방식 case2 : () -> 로 생략가능
        printIfValidIndex(0, () -> gertVeryExpensiveValue());
        printIfValidIndex(1, () -> gertVeryExpensiveValue());
        printIfValidIndex(-1,() -> gertVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
    }

    private static String gertVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Kevin";
    }

//    private static void printIfValidIndex(int number, String value) {
    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if(number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list , Predicate<T> filter) {
        ArrayList<T> result = new ArrayList<>();
        for (T input : list) {
            if(filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }

//    private static <T>
}